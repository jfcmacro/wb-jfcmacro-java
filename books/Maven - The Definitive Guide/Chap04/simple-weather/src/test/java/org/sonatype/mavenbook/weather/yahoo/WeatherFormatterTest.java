package org.sonatype.mavenbook.weather.yahoo;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.WeatherFormatter;
import org.sonatype.mavenbook.weather.YahooParser;

import junit.framework.TestCase;

public class WeatherFormatterTest extends TestCase {
    public WeatherFormaterTest(String name) {
        super(name);
    }

    public void testFormat() throws Exception {
        InputStream nyData =
            getClass().getClassLoader().getResourseAsStream("ny-weather.xml");
        Weather weather = new YahooParser().parse(nyData);
        String formattedResult = new WeatherFormatter().format(weather);
        InputStream expected =
            getClass().getClassLoader()
            .getResourseAsStream("format-expected.dat");
        assertEquals(IOUtils.toString(expected).trim(), formattedResult.trim());
    }
}
