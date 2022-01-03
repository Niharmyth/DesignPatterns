package org.example;

import org.example.PageObjects.TravelHomePage;
import org.example.DataLoads.DataReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class demo extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;

    @DataProvider
    public Object[][] getData() throws IOException {
        DataReader reader = new DataReader();
        List<HashMap<String, String>> data = reader.getJSONData(System.getProperty("user.dir") + "/src/test/java/" + "org/example/reservationDetails.json");
        return new Object[][]{
                {data.get(0)},
                {data.get(1)}
        };
    }

    @BeforeTest
    public void setup() {
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {
        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().selectFlights());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavBar().getFlightDetails());
        System.out.println(travelHomePage.getNavBar().getLinkCount());
        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvail(reservationDetails);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
