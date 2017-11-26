package com.thetrainline.tests.login;

import com.thetrainline.pages.home.HomePage;
import com.thetrainline.pages.login.LoginPage;
import com.thetrainline.tests.DriverTest;
import org.testng.annotations.Test;

import static com.thoughtworks.selenium.SeleneseTestBase.assertEquals;
import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;

public class LoginTest extends DriverTest {

    private static final String PATH = "https://www.thetrainline.com/buytickets/login.aspx";
    private static final String USER_VALID_EMAIL = "dowi@p33.org";
    private static final String USER_VALID_PASSWORD = "dowi@p33.org";
    private static final String USER_INVALID_EMAIL = "ifwifub@gmail.com";
    private static final String LOGIN_FAILED_EXPECTED_MASSAGE = "Unable to sign in:";
    private static final String LOGIN_EXPECTED_MASSAGE = "Sign out";

    @Test(priority = 0)
    public void loginFailed(){
        driver.get(PATH);

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isInitialized());

        loginPage.enterName(USER_INVALID_EMAIL, USER_VALID_PASSWORD);

        loginPage.submit();
        assertTrue(loginPage.isNotifictionEnable());

        assertEquals(LOGIN_FAILED_EXPECTED_MASSAGE, loginPage.getNotificationMassage());
    }

    @Test (priority = 1)
    public void login(){
        driver.get(PATH);

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.isInitialized());

        loginPage.enterName(USER_VALID_EMAIL, USER_VALID_PASSWORD);

        HomePage homePage = loginPage.submit();
        assertTrue(homePage.isPageOpened());

        assertEquals(LOGIN_EXPECTED_MASSAGE, homePage.confirmationTitle());
    }

}
