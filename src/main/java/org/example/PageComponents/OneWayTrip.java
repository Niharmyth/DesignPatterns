package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class OneWayTrip extends AbstractComponent implements SearchFlightAvail {
    By oneWayTripRadioButton = By.id("ctl00_mainContent_rbtnl_Trip_0");
    By fromTextBox = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By toTextBox = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By discountCheckBox = By.id("ctl00_mainContent_chk_IndArm");
    By submit = By.id("ctl00_mainContent_btn_FindFlights");

    public OneWayTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(Map<String, String> reservationDetails) {
        System.out.println("I'm inside OneWay Trip");
        findElement(oneWayTripRadioButton).click();
        selectOriginCity(reservationDetails.get("origin"));
        selectDestinationCity(reservationDetails.get("destination"));
        findElement(discountCheckBox).click();
        findElement(submit).click();
    }

    private void selectOriginCity(String origin) {
        findElement(fromTextBox).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    private void selectDestinationCity(String destination) {
        findElement(toTextBox).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }
}
