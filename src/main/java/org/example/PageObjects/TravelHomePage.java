package org.example.PageObjects;

import org.example.AbstractComponents.SearchFlightAvail;
import org.example.AbstractComponents.StrategyFactor;
import org.example.PageComponents.FooterNav;
import org.example.PageComponents.NavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TravelHomePage {

    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    By navSectionElement = By.id("buttons");
    By footerSectionElement = By.id("traveller-home");

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavBar getNavBar() {
        return new NavBar(driver, navSectionElement);
    }

    public FooterNav getFooterNav() {
        return new FooterNav(driver, footerSectionElement);
    }

    public void setBookingStrategy(String strategyType) {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
    }

    public void checkAvail(Map<String, String> reservationDetails) {
        System.out.println("Nihar Here !!");
        searchFlightAvail.checkAvail(reservationDetails);
    }
}
