package org.jfcmc.servlet.chap06;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import static java.net.URLEncoder.encode;
import static java.nio.charset.Charset.defaultCharset;
import static java.util.Objects.isNull;

public class SearchEngines extends HttpServlet {

    public void doGet(HttpServletRequest request,
		      HttpServletResponse response)
	throws ServletException, IOException {

	String searchStr = request.getParameter("searchString");

	if (isNull(searchStr) ||
	    searchStr.isEmpty()) {
	    reportIssue(response, "There is not search String");
	    return;
	}

	searchStr = encode(searchStr, defaultCharset());

	String howManyResults = request.getParameter("howManyResults");

	if (isNull(howManyResults) ||
	    howManyResults.isEmpty() ||
	    howManyResults.equals("0")) {
	    howManyResults = "10";
	}

	String searchEngine =
	    request.getParameter("searchEngine");

	if (isNull(searchEngine) ||
	    searchEngine.isEmpty()) {
	    reportIssue(response, "Search engine is empty");
	    return;
	}

	SearchSpec[] commonSpecs = SearchSpec.getCommonSpecs();

	for (SearchSpec searchSpec : commonSpecs) {
	    if (searchSpec.getName().equals(searchEngine)) {
		String url = searchSpec.makeURL(searchStr,
						howManyResults);
		response.sendRedirect(url);
		return;
	    }
	}

	reportIssue(response, "Search Enginee wasn't recognized");
	return;
    }

    private void reportIssue(HttpServletResponse response,
			     String message)
	throws IOException {
	response.sendError(HttpServletResponse.SC_NOT_FOUND,
			   "<H2>" + message + "</H2>");
    }

    public void doPost(HttpServletRequest request,
		       HttpServletResponse response)
	throws ServletException, IOException {
	doGet(request, response);
    }	
}
