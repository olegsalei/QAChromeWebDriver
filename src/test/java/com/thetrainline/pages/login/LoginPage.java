package com.thetrainline.pages.login;

import com.thetrainline.pages.BasePage;
import com.thetrainline.pages.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"ContentPanel\"]/form/div[1]/div/div/div[1]/strong")
    private WebElement message;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized() {
        return email.isDisplayed();
    }

    public void enterName(String firstName, String lastName){
        this.email.clear();
        this.email.sendKeys(firstName);

        this.password.clear();
        this.password.sendKeys(lastName);
    }

    public HomePage submit(){
        login.click();
        return new HomePage(driver);
    }

    public boolean isNotifictionEnable(){return message.isEnabled(); }
    public String getNotificationMassage() {return  message.getText(); }

}

