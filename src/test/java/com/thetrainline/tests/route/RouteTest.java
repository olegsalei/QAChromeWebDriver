package com.thetrainline.tests.route;

import com.thetrainline.pages.route.RoutePage;
import com.thetrainline.tests.DriverTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class RouteTest extends DriverTest {

    private static final String PATH = "https://www.thetrainline.com/";
    private static final String ORIGIN_STATION = "London";
    private static final String DESTINATION_STATION = "Manchester";
    private static final String TODAY_EXPECTED_DATE = new SimpleDateFormat("E dd'th' MMM yyyy", Locale.US).format(Calendar.getInstance().getTime());
    private static final String RETURN_ROUTE = "RETURN";
    private static final String EXPECTED_SWAP = "Manchester (Any) to London (Any)";


    @Test (priority = 0)
    public void oneWayRouteLondonManchesterToday(){
        driver.get(PATH);

        RoutePage routePage = new RoutePage(driver);
        assertTrue(routePage.isInitialized());

        routePage.enterRoute(ORIGIN_STATION, DESTINATION_STATION);
        routePage.submit();

        assertEquals(TODAY_EXPECTED_DATE, routePage.confirmationOneWayTitle());
    }

    @Test (priority = 1)
    public void returnRouteLondonManchesterToday(){
        driver.get(PATH);

        RoutePage routePage = new RoutePage(driver);
        assertTrue(routePage.isInitialized());

        routePage.enterRoute(ORIGIN_STATION, DESTINATION_STATION);
        routePage.returnTicket();
        routePage.submit();

        assertEquals(RETURN_ROUTE, routePage.confirmationReturnTitle());
    }

    @Test (priority = 2)
    public void routeLondonManchesterSwap(){
        driver.get(PATH);

        RoutePage routePage = new RoutePage(driver);
        assertTrue(routePage.isInitialized());

        routePage.enterRoute(ORIGIN_STATION, DESTINATION_STATION);

        routePage.swap();
        routePage.submit();

        assertEquals(EXPECTED_SWAP, routePage.swapTitle());
    }
}
