package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nglc.core.AppDriver;
import com.nglc.core.ExcelLib;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class UserAdd extends AppDriver {

	ExcelLib exlib = new ExcelLib(System.getProperty("user.dir")+"/TestData/UserTestData.xlsx/");
	Library library;
	
	public UserAdd() {
		super();
		Library library = new Library();
	}
	
	public void AddUserBreadcrumbClick() throws InterruptedException{
		driver.findElement(By.xpath(Obj.getProperty("BY_BIBUSER_BREADCRUMB_LINK"))).click();
		String expectedURL = Config.getProperty("UserListURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Expected URL = Actual URL ::  User is being redirected back to User List Page");
		}
		else {
			test.log(LogStatus.FAIL, "Actual URL : "+actualURL);
		}
	}
	
	public void AddUserButtonClick() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(Obj.getProperty("BY_ADDUSER_BTN"))).click();
		Thread.sleep(2000);
	}
	
	public void ValidateRedirectiononValidUser() throws InterruptedException{
		String expectedURL = Config.getProperty("UserListURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Expected URL = Actual URL ::  User is being redirected back to User List Page");
		}
		else {
			test.log(LogStatus.FAIL, "Actual URL : "+actualURL+" Expected URL = "+expectedURL);
			}
	}
	
	public void ValidateRedirectiononInvalidUser() throws InterruptedException{
		String expectedURL = Config.getProperty("AddUserURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Expected URL = Actual URL ::  User is being redirected back to User List Page");
		}
		else {
			test.log(LogStatus.FAIL, "Actual URL : "+actualURL+ "Expected URL = "+expectedURL);
			}
	}
	
	public void AddValidUser() throws InterruptedException{
        
        WebElement FullNameInput = driver.findElement(By.xpath(Obj.getProperty("BY_FULLNAME_TEXT")));
        FullNameInput.sendKeys(exlib.readData("ValidUserData", 1, 0));
        Thread.sleep(1000);
        
        
        WebElement EmailInput = driver.findElement(By.xpath(Obj.getProperty("BY_USEREMAIL_TEXT")));
        EmailInput.sendKeys(exlib.readData("ValidUserData", 1, 1));
        Thread.sleep(1000);
        
        WebElement PhoneInput = driver.findElement(By.xpath(Obj.getProperty("BY_PHONE_TEXT")));
        PhoneInput.sendKeys(exlib.readData("ValidUserData", 1, 2));
        Thread.sleep(1000);
        
        WebElement userRoleDropDown = driver.findElement(By.xpath(Obj.getProperty("BY_ROLE_DROPDOWN")));
        userRoleDropDown.sendKeys(exlib.readData("ValidUserData", 1, 3));
        userRoleDropDown.sendKeys(Keys.ARROW_DOWN);        
        userRoleDropDown.sendKeys(Keys.ENTER);    
        userRoleDropDown.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        
        WebElement userLocation = driver.findElement(By.xpath(Obj.getProperty("BY_LOC_SELECT")));
        System.out.println("userLocation");
        userLocation.sendKeys(exlib.readData("ValidUserData", 1, 4));
        userLocation.sendKeys(Keys.SPACE);
    
    }
	
	public void ReqFullNameBlankInput() throws InterruptedException{
		WebElement FullNameError = driver.findElement(By.xpath(Obj.getProperty("BY_FULLNAME_ERROR_MSG")));
		String ExpectedFullNameError = "Please input your Full Name!";
		String ActualFullNameError = FullNameError.getText();
		if(ExpectedFullNameError.equalsIgnoreCase(ActualFullNameError)) {
			test.log(LogStatus.PASS, "Expected Validation Message = Actual Validation Message");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Error = "+ExpectedFullNameError+" Actual Error = "+ActualFullNameError);
		}
		}
	
	public void ReqEmailBlankInput() throws InterruptedException{
		WebElement EmailError = driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_REQ_ERROR_MSG")));
		String ExpectedEmailError = "Please input your Email Address";
		String ActualEmailError = EmailError.getText();
		if(ExpectedEmailError.equalsIgnoreCase(ActualEmailError)) {
			test.log(LogStatus.PASS, "Expected Validation Message = Actual Validation Message");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Error = "+ExpectedEmailError+"Actual Error = "+ActualEmailError);
		}
	}
	
	public void ReqPhoneBlankInput() throws InterruptedException{
		WebElement PhoneError = driver.findElement(By.xpath(Obj.getProperty("BY_PHONE_REQ_ERROR_MSG")));
		String ExpectedPhoneError = "Please input your Phone Number!";
		String ActualPhoneError = PhoneError.getText();
		if(ExpectedPhoneError.equalsIgnoreCase(ActualPhoneError)) {
			test.log(LogStatus.PASS, "Expected Validation Message = Actual Validation Message");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Error = "+ExpectedPhoneError+"Actual Error = "+ActualPhoneError);
		}
	}
	
	public void ReqRoleBlankInput() throws InterruptedException{
		WebElement RoleError = driver.findElement(By.xpath(Obj.getProperty("BY_ROLE_ERROR_MSG")));
		String ExpectedRoleError = "Please Select a Role";
		String ActualRoleError = RoleError.getText();
		if(ExpectedRoleError.equalsIgnoreCase(ActualRoleError)) {
			test.log(LogStatus.PASS, "Expected Validation Message = Actual Validation Message");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Error = "+ExpectedRoleError+"Actual Error = "+ActualRoleError);
		}
	}
	
	public void ReqLocBlankInput() throws InterruptedException{
		WebElement LocError = driver.findElement(By.xpath(Obj.getProperty("BY_LOC_ERROR_MSG")));
		String ExpectedLocError = "Please select a Location!";
		String ActualLocError = LocError.getText();
		if(ExpectedLocError.equalsIgnoreCase(ActualLocError)) {
			test.log(LogStatus.PASS, "Expected Validation Message = Actual Validation Message");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Error = "+ExpectedLocError+"Actual Error = "+ActualLocError);
		}
	}
	
}