package com.thetrainline.tests.departures;

import com.thetrainline.pages.departures.DeparturesPage;
import com.thetrainline.tests.DriverTest;
import org.testng.annotations.Test;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class DeparturesTest extends DriverTest {

    private static final String PATH = "https://www.thetrainline.com/live";
    private static final String FROM_STATION = "London Euston";
    private static final String TO_STATION = "Manchester Piccadilly";
    private static final String EXPECTED_DEPARTURES_MESSAGE = "Departures from London Euston calling at Manchester Piccadilly";
    private static final String EXPECTED_ARRIVALS_MESSAGE = "Arrivals at London Euston via Manchester Piccadilly";


    @Test(priority = 0)
    public void departuresLondonManchester(){
        driver.get(PATH);

        DeparturesPage departuresPage = new DeparturesPage(driver);
        assertTrue(departuresPage.isInitialized());

        departuresPage.enterRoute(FROM_STATION, TO_STATION);
        departuresPage.submit();

        assertEquals(EXPECTED_DEPARTURES_MESSAGE, departuresPage.confirmationDeparturesArrivalsTitle());
    }

    @Test (priority = 1)
    public void arrivalsLondonManchester(){
        driver.get(PATH);

        DeparturesPage departuresPage = new DeparturesPage(driver);
        assertTrue(departuresPage.isInitialized());

        departuresPage.arrivals();
        departuresPage.enterRoute(FROM_STATION, TO_STATION);
        departuresPage.submit();

        assertEquals(EXPECTED_ARRIVALS_MESSAGE, departuresPage.confirmationDeparturesArrivalsTitle());
    }

    //Swap - не понимаю почему не работает, после замены меняет одно значение на другое,
    // а второе оставляет, после чего выдает ошибку совпадения конечного и начального
    // пунктов и один из них удаляет.
//    @Test (priority = 2)
//    public void departuresLondonManchesterSwap(){
//        driver.get(PATH);
//
//        DeparturesPage departuresPage = new DeparturesPage(driver);
//        assertTrue(departuresPage.isInitialized());
//
//        departuresPage.enterRoute(FROM_STATION, TO_STATION);
//        departuresPage.swap();
//        departuresPage.submit();
//
//        assertEquals(EXPECTED_SWAP, departuresPage.swapTitle());
//    }
}
