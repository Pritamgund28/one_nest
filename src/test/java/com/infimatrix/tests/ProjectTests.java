package com.infimatrix.tests;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.infimatrix.pages.BaseTest;
import com.infimatrix.pages.HomePage;
import com.infimatrix.pages.LoginPage;
import com.infimatrix.pages.MemberListPage;
import com.infimatrix.pages.SignUpPage;
import com.infimatrix.utils.EmailUtil;
import com.infimatrix.utils.ScreenshotUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
public class ProjectTests extends BaseTest {
    private static final String BASE_URL = "https://onenest.infimatrix.in/"; 
    private LoginPage loginPage;
    // private SignUpPage signUpPage;
    private HomePage homePage;
    private MemberListPage memberListPage;
    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
           
            ScreenshotUtil.captureScreenshot(driver, description.getMethodName());
            
            EmailUtil.sendEmail("recipient@example.com", "Test Failure: " + description.getMethodName(),
                    "Test case failed. See attached screenshot for details.", "screenshots/" + description.getMethodName() + ".png");
        }
    };
    @Before
    public void setUpTest() {
        setUp();
        driver.get(BASE_URL); 
        loginPage = new LoginPage(driver);
        // signUpPage = new SignUpPage(driver);
         homePage = new HomePage(driver);
         memberListPage = new MemberListPage(driver);
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDownTest() {
        tearDown();
    }
    
    @Test
    public void testLogin() {
        loginPage.login("sjadhav@infimatrix.com", "1234");
       
    }
    // @Test
    // public void testAddMember() {
    //     loginPage.login("sjadhav@infimatrix.com", "1234");
    //     homePage.navigateToMemberList();
    //     memberListPage.navigateToAddMember();
    //     memberListPage.fillMemberDetails("Shubham", "gund", "johndoe@example.com", "1234567890", "9876543210");
    //     memberListPage.saveMemberDetails();
    // }
       
    @Test
    public void testParking() {
    loginPage.login("sjadhav@infimatrix.com", "1234");
    homePage.navigateToParking();
    // memberListPage.navigateToAddMember();
    memberListPage.fillParkingDetails("Pooja lakde", "1234567890123456", "Two Wheeler", "MH45TY6767", "Black", "M-01", "Open parking");
    memberListPage.saveMemberDetails();
}

    }

