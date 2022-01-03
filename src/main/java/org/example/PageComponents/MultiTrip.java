package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.example.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    By multiTrip_rdb = By.id("ctl00_mainContent_rbtnl_Trip_2");
    By multiTrip_modal = By.id("MultiCityModelAlert");
    By fromTextBox = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By toTextBox = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By fromTextBox2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    By discountCheckBox = By.id("ctl00_mainContent_chk_IndArm");
    By submit = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(Map<String, String> reservationDetails) {
        System.out.println("I'm inside MultiTrip");

        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectOriginCity2(reservationDetails.get("destination2"));
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

    private void selectOriginCity2(String origin) {
        findElement(fromTextBox2).click();
        findElement(By.xpath("(//a[@value='" + origin + "'])[3]")).click();
    }

    // Execute Around Design Pattern
    public void makeStateReady(Consumer<MultiTrip> consumer){
        findElement(multiTrip_rdb).click();
        findElement(multiTrip_modal).click();
        waitForElementToDisappear(multiTrip_modal);
        consumer.accept(this);
    }
}

