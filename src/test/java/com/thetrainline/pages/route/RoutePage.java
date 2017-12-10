package com.thetrainline.pages.route;

import com.thetrainline.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoutePage extends BasePage {
    @FindBy(id = "originStation")
    WebElement originStation;

    @FindBy(id = "destinationStation")
    WebElement destinationStation;

    @FindBy(id = "submitButton")
    WebElement submitButton;

    @FindBy(className = "matrix-date")
    WebElement message;

    @FindBy(xpath = "//*[@id=\"journey-type-return\"]")
    WebElement returnRatio;

    @FindBy(xpath = "//*[@id=\"extendedSearchForm\"]/div[3]/div[2]/div/div[1]/button[2]")
    WebElement nextDay;

    @FindBy(xpath = "//*[@id=\"extendedSearchForm\"]/div[3]/div[1]/div/div[1]/button[1]")
    WebElement today;

    @FindBy(xpath = "//*[@id=\"tickets\"]/div/div[2]/table/thead/tr[1]/th[2]/div/div[1]")
    WebElement returnRoute;

    @FindBy(id = "swap")
    WebElement swapButton;

    @FindBy(xpath = "//*[@id=\"timetable\"]/h1")
    WebElement swap;



    public RoutePage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return originStation.isDisplayed();
    }

    public void enterRoute(String originStation, String destinationStation) {
        this.originStation.clear();
        this.originStation.sendKeys(originStation);

        this.destinationStation.clear();
        this.destinationStation.sendKeys(destinationStation);
    }

    public void submit() {
        submitButton.click();
    }

    public void returnTicket() {
        returnRatio.click();
        nextDay.click();
    }

    private void today(){
        today.click();
    }

    public void swap(){
        today();
        swapButton.click();
    }

    public String swapTitle() {
        return swap.getText();
    }

    public String confirmationOneWayTitle() {
        return message.getText();
    }

    public  String confirmationReturnTitle(){
        return returnRoute.getText();
    }
}
