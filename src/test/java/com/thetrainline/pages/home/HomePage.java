package com.thetrainline.pages.home;

import com.thetrainline.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"master\"]/div[1]/header/div/div/div[2]/ul/li[4]/a")
    private WebElement heading;

    public boolean isPageOpened() {
        return heading.isDisplayed();
    }

    public String confirmationTitle(){
        return heading.getText();
    }

}
