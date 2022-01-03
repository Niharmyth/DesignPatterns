package org.example.PageComponents;

import org.example.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");
    public NavBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public String getFlightDetails(){
        return findElement(flights).getAttribute("class");
    }

    public int getLinkCount(){
        return findElements(links).size();
    }
}
