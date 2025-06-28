package org.jfcmc.servlet.chap06;

public class SearchSpec {

    private String name;
    private String URLBase;
    private String suffixHowManyResults;

    private static SearchSpec[] commonSpecs = {
	new SearchSpec("google",
		       "https://www.google.com/search?q=",
		       "&num="),
	new SearchSpec("bing",
		       "https://www.bing.com/search?q=",
		       "&num="),
	new SearchSpec("yahoo",
		       "https://search.yahoo.com/search?q=",
		       "&num="),
	new SearchSpec("brave",
		       "https://search.brave.com/search?q=",
		       "&num="),
	new SearchSpec("duckduckgo",
		       "https://duckduckgo.com/?t=h_&q=",
		       "&num=")
    };

    public SearchSpec(String name,
		      String URLBase,
		      String suffixHowManyResults) {
	this.name = name;
	this.URLBase = URLBase;
	this.suffixHowManyResults = suffixHowManyResults;
    }

    public String makeURL(String searchString,
			  String howManyResults) {
	return (new StringBuilder(URLBase))
	    .append(searchString)
	    .append(suffixHowManyResults)
	    .append(howManyResults)
	    .toString();
    }

    public String getName() {
	return name;
    }

    public static SearchSpec[] getCommonSpecs() {
	return commonSpecs;
    }
}
