package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class UserDelete extends AppDriver {
	Library library;
	public String ele;
	
	public UserDelete() {
		super();
		library = new Library();
	}
	
	public void ClickOnInvitedDeleteIcon() throws InterruptedException{
		driver.findElement(By.xpath(Obj.getProperty("BY_BIB_INVITED_USER_DELETE_ICON"))).click();
		WebElement RemoveModalText = driver.findElement(By.xpath(Obj.getProperty("BY_USER_MODAL")));
		String expectedRemoveText = Config.getProperty("removeUserText");
		Thread.sleep(2000);
		String actualRemoveText = RemoveModalText.getText();
		if(expectedRemoveText.equalsIgnoreCase(actualRemoveText)) {
			test.log(LogStatus.PASS, "Expected Text = Actual Text");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Text = "+expectedRemoveText+" Actual Text = "+actualRemoveText);
		}
	}
	
	public void ClickonDeleteIcon() throws InterruptedException{
		driver.findElement(By.xpath(Obj.getProperty("BY_BIB_USER_DELETE_ICON"))).click();
		WebElement RemoveModalText = driver.findElement(By.xpath(Obj.getProperty("BY_USER_MODAL")));
		String expectedRemoveText = Config.getProperty("removeUserText");
		Thread.sleep(1000);
		String actualRemoveText = RemoveModalText.getText();
		if(expectedRemoveText.equalsIgnoreCase(actualRemoveText)) {
			test.log(LogStatus.PASS, "Expected Text = Actual Text");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Text = "+expectedRemoveText+" Actual Text = "+actualRemoveText);
		}
	}
	
	public void ClickonConfirmButton() throws InterruptedException{
		WebElement ConfirmButton = driver.findElement(By.xpath(Obj.getProperty("BY_CONFIRM_BUTTON")));
		ConfirmButton.click();
		String expectedURL = Config.getProperty("UserListURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Expected URL = Actual URL :: User is deleted and redirected to User List ");
		}
		else {
			test.log(LogStatus.FAIL, "Expected URL = "+expectedURL+" Actual URL = "+actualURL);
		}
	}
	
	public void ClickonCancelButton() throws InterruptedException{
		WebElement CancelButton = driver.findElement(By.xpath(Obj.getProperty("BY_CANCEL_BUTTON")));
		CancelButton.click();
		String expectedURL = Config.getProperty("EditUserURL");
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Expected URL = Actual URL :: User has not deleted");
		}
		else {
			test.log(LogStatus.FAIL, "Expected URL = "+expectedURL+" Actual URL = "+actualURL);
		}
	}
}