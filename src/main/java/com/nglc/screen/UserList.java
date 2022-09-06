package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class UserList extends AppDriver {
	Library library;
	public String ele;
	
	public UserList() {
		super();
		library = new Library();
		
	}
	
	public void  ClickOnAddUserBtn() throws InterruptedException{
		library.clickOnAnyElement(Obj.getProperty("BY_BIB_ADDUSER_BTN"), "xpath", "click");
		String expectedURL = Config.getProperty("AddUserURL");
		String actualURL = driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Actual URL = Expected URL :: User is being redirected to Add User Screen");
			}	
		else {
			test.log(LogStatus.FAIL, "Actual URL = "+ actualURL +" Expected URL :" +expectedURL);
		}
		}
	
	public void ClickOnActiveUserCard() throws InterruptedException{
		library.clickOnAnyElement(Obj.getProperty("BY_USER_CARD_TEXT"), "xpath", "click");
		String expectedURL = Config.getProperty("EditUserURL");
		Thread.sleep(2000);
		String actualURL =  driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Actual URL = Expected URL :: User is being redirected to User Profile Screen");
			}	
		else {
			test.log(LogStatus.FAIL, "Actual URL = "+ actualURL +" Expected URL : " +expectedURL);
		}
	}
	
	public void ClickOnInvitedUserCard() throws InterruptedException{
		library.clickOnAnyElement(Obj.getProperty("BY_BIB_INVITED_USER_CARD"), "xpath", "click");
		String expectedURL = Config.getProperty("EditUserURL");
		Thread.sleep(2000);
		String actualURL =  driver.getCurrentUrl();
		if(expectedURL.equalsIgnoreCase(actualURL)) {
			test.log(LogStatus.PASS, "Actual URL = Expected URL :: User is being redirected to User Profile Screen");
			}	
		else {
			test.log(LogStatus.FAIL, "Actual URL = "+ actualURL +" Expected URL : " +expectedURL);
		}
	}
	
	public void ClickOnSearchIcon() throws InterruptedException{
//		library.clickOnAnyElement(Obj.getProperty("BY_BIBUSER_SEARCH_BTN"), "xpath", "click");
		driver.findElement(By.xpath(Obj.getProperty("BY_BIBUSER_SEARCH_BTN"))).click();
		
	}
	
	public void ValidUserSearch() throws InterruptedException{
		String expectedSearchText = "Michael Smith";
		WebElement searchText =  driver.findElement(By.xpath(Obj.getProperty("BY_SEARCH_TEXT")));
		searchText.sendKeys(Config.getProperty("validBibUserSearch"));
		Thread.sleep(2000);
		WebElement actualSearchText = driver.findElement(By.xpath(Obj.getProperty("BY_SEARCHED_USER")));
		if(expectedSearchText.equalsIgnoreCase(actualSearchText.getText())) {
			test.log(LogStatus.PASS, "Actual Search Text = Expected Search Text :: The searched user is filtered out.");
		}
		else {
			test.log(LogStatus.FAIL, "Expected Search Text is: " + expectedSearchText +"\nActual Search Text is:" +actualSearchText.getText());
		}
	}
	
	public void InvalidUserSearch() throws InterruptedException{
		String expectedSearchText = "No such user found";
		WebElement searchText = driver.findElement(By.xpath(Obj.getProperty("BY_SEARCH_TEXT")));
		searchText.sendKeys(Config.getProperty("invalidBibUserSearch"));
		Thread.sleep(2000);
		WebElement NoUserText = driver.findElement(By.xpath(Obj.getProperty("BY_NOUSER_FOUND")));
		String noUserTextValue = NoUserText.getText();
		System.out.println(noUserTextValue);
		if(expectedSearchText.equalsIgnoreCase(noUserTextValue)) {
			test.log(LogStatus.PASS, "Actual Results = Expected Results : No such user found");
		}
		else {
			test.log(LogStatus.FAIL, "Actual Results : " +noUserTextValue);
		}
	}
	
	public void clickOnAddUserCard() throws InterruptedException{
		library.clickOnAnyElement(Config.getProperty("BY_BIB_ADDUSER_CARD"), "xpath", "click");
		String expectedURL = Config.getProperty("AddUserURL");
		String actualURL = driver.getCurrentUrl();
//		Assert.assertEquals(actualURL, expectedURL);
		if(actualURL.equalsIgnoreCase(expectedURL)) {
			test.log(LogStatus.PASS, "Actual URL = Expected URL :: User is being redirected to Add USer Screen");
			}	
		else {
			test.log(LogStatus.FAIL, "Actual URL = "+ actualURL +"User is not being redirected to Add User Screen" + "\n User must be redirected to :" +expectedURL);
		}
	}
	
}