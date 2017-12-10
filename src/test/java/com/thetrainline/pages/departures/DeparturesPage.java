package com.thetrainline.pages.departures;

import com.thetrainline.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;

public class DeparturesPage extends BasePage{
    @FindBy(id = "fromStation")
    WebElement fromStation;

    @FindBy(id = "toStation")
    WebElement toStation;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div/div[2]/form/div[2]/div[3]/button")
    WebElement submitButton;

    @FindBy(id = "swapStations")
    WebElement swapButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div/div[3]/div[2]/div[3]/div/div[1]/div[2]/h3")
    WebElement swapText;

    @FindBy(xpath = "//*[@id=\"radioArrivals\"]")
    WebElement radioArrivals;

    @FindBy(xpath = "//*[@id=\"radioDepartures\"]")
    WebElement radioDepartures;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div/div[1]/h1/span")
    WebElement confirmationDeparturesArrivalsTitle;




    public DeparturesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return fromStation.isDisplayed();
    }

    public void enterRoute(String originStation, String destinationStation) {
        this.fromStation.clear();
        this.fromStation.sendKeys(originStation);
        this.fromStation.sendKeys(Keys.TAB);

        this.toStation.clear();
        this.toStation.sendKeys(destinationStation);
        this.fromStation.sendKeys(Keys.TAB);
        this.fromStation.sendKeys(Keys.ENTER);
    }

    public  void arrivals() {
        radioArrivals.click();
    }


    public void submit() {
        submitButton.click();
    }


    public void swap(){
        swapButton.click();
    }

    public String swapTitle() {
        return swapText.getText();
    }

    public String confirmationDeparturesArrivalsTitle(){
        return confirmationDeparturesArrivalsTitle.getText();
    }
}
