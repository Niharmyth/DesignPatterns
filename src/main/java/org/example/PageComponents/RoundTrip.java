package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {
    By roundTripRadioButton = By.id("ctl00_mainContent_rbtnl_Trip_1");
    By fromTextBox = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By toTextBox = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By discountCheckBox = By.id("ctl00_mainContent_chk_IndArm");
    By submit = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(Map<String, String> reservationDetails) {
        System.out.println("I'm inside RoundTrip");

        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
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

    private void makeStateReady(Consumer<RoundTrip> consumer) {
        findElement(roundTripRadioButton).click();
        consumer.accept(this);
    }
}
