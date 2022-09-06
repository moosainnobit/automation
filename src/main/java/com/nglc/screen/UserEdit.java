package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class UserEdit extends AppDriver {
	Library lib;
	
	public UserEdit(){
		super();
		Library lib = new Library();
	}
	
	public void EditUserName() throws InterruptedException{
		WebElement ChangeUserName = driver.findElement(By.xpath(Obj.getProperty("BY_USERNAME_TEXT")));
		ChangeUserName.sendKeys(Keys.CONTROL+"a");
		ChangeUserName.sendKeys(Keys.DELETE);
		ChangeUserName.sendKeys(Config.getProperty("EditUserName"));
		test.log(LogStatus.INFO, "User edited the name.");
		Thread.sleep(1000);
	}
	
	public void EditUserPhone() throws InterruptedException{
		WebElement ChangeUserPhone = driver.findElement(By.xpath(Obj.getProperty("BY_USERPHONE_TEXT")));
		ChangeUserPhone.sendKeys(Keys.CONTROL+"a");
		ChangeUserPhone.sendKeys(Keys.DELETE);
		ChangeUserPhone.sendKeys(Config.getProperty("EditUserPhone"));
		test.log(LogStatus.INFO, "User edited the phone number.");
		Thread.sleep(1000);
	}
	
	public void ClickOnApplyChangesButton() throws InterruptedException{
		driver.findElement(By.xpath(Obj.getProperty("BY_APPLY_CHANGES_BUTTON"))).click();
		test.log(LogStatus.INFO, "User clicked on Apply Changes button.");
	}
	
	public void ValidateRedirectiononValidEditing() throws InterruptedException{
		String expectedURL = Config.getProperty("UserListURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Expected URL = Actual URL");
		}
		else {
			test.log(LogStatus.FAIL, "Expected URL = "+expectedURL+" Actual URL = "+actualURL);
		}
	}
	
	public void ValidateRedirectiononInvalidEdit() throws InterruptedException{
		String expectedURL = Config.getProperty("EditUserURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Expected URL = Actual URL");
		}
		else {
			test.log(LogStatus.FAIL, "Expected URL = "+expectedURL+" Actual URL = "+actualURL);
		}
	}
}