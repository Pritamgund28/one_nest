package com.infimatrix.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MemberListPage {
    private WebDriver driver;
    public MemberListPage(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToAddMember() {
        driver.findElement(By.xpath("//*[@id=\"kt_content_container\"]/div/div[1]/div[2]/a")).click();
    }
    public void fillMemberDetails(String firstName, String lastName, String email, String contactNumber, String whatsappNumber) {
        driver.findElement(By.id("id_first_name")).sendKeys(firstName);
        driver.findElement(By.id("id_last_name")).sendKeys(lastName);
        driver.findElement(By.id("id_member_name")).click();
        driver.findElement(By.id("id_email")).sendKeys(email);
        driver.findElement(By.id("id_alter_contact_no")).sendKeys(contactNumber);
        driver.findElement(By.id("id_contact_no")).sendKeys(whatsappNumber);
    }
    public void saveMemberDetails() {
        driver.findElement(By.id("submitbutton")).click();
    }
   
    public void fillParkingDetails(String string, String string2, String string3, String string4, String string5,
            String string6, String string7) {
    }
}