package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.nglc.core.AppDriver;

import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;
import com.nglc.core.AppDriver;

import com.nglc.core.Library;

public class LoginEmail extends AppDriver {
	Library library;

	public LoginEmail() {
		super();
		library = new Library();
	}

	public void enterValidUsername() {

		WebElement emailtext = driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_TEXT")));
		emailtext.sendKeys(Config.getProperty("platformAdminMailID"));
		test.log(LogStatus.INFO, "Enter the EmailID: " + emailtext.getAttribute("value"));

	}

	public void setUsername() {

		WebElement emailtext = driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_TEXT")));
		emailtext.sendKeys(Config.getProperty("platformAdminMailID"));

	}

	public void clickOnNextButton() {

		driver.findElement(By.xpath(Obj.getProperty("BY_EMAILNEXT_BUTTON"))).click();
		test.log(LogStatus.PASS, "Click on Next Button Successfully");

	}

	public void validateErrorMessageBlankEmail() throws InterruptedException {
		String exp = "Please enter a valid email address";
		WebElement m;

		driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_TEXT"))).sendKeys("");
		m = driver.findElement(By.xpath("//div[text()='Please enter a valid email address']"));
		String act = m.getText();
		if (act.equalsIgnoreCase(exp)) {
			test.log(LogStatus.PASS, "Actual Result:: Validation Message (" + act + ") is being displayed. ");
		} else {
			test.log(LogStatus.FAIL,
					"Actual Result:: Validation Message (Please enter a valid email address) is not being dispalyed.  "
							+ "Expected Result:: Validation Message (Please enter a valid email address) should be display on the login screen ");
		}
	}

	public void enterUnregisteredUsername() {
		WebElement unregisteredEmailText = driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_TEXT")));
		unregisteredEmailText.sendKeys(Config.getProperty("incorrectPlatformAdminMailID"));
		test.log(LogStatus.INFO, "Enter the EmailID: " + unregisteredEmailText.getAttribute("value"));
	}

	public void validateErrorMessageUnregisteredEmail() throws InterruptedException {
		String exp = "User not found. Please try again";

		WebElement m = driver.findElement(By.xpath(Obj.getProperty("BY_FIELD_ERROR_MESSAGES")));
		String act = m.getText();
		if (act.equalsIgnoreCase(exp)) {
			test.log(LogStatus.PASS, "Actual Result:: Validation Message (" + act + ") is being dispalyed.");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Validation Message (" + act + ") is not being dispalyed.  "
					+ "Expected Result:: Validation Message (Please enter a valid email address) should be display on the login screen ");

		}

	}

	public void enterCaseSensitivityEmail() {

		WebElement caseSensitivityEmailText = driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_TEXT")));
		caseSensitivityEmailText.sendKeys(Config.getProperty("caseSensitivityEmailID"));
		test.log(LogStatus.INFO, "Enter the EmailID: " + caseSensitivityEmailText.getAttribute("value"));

	}

	public void validateUrlOfLoginScreen() throws InterruptedException {
		test.log(LogStatus.INFO, "Validating Url on Login screen ");
		Thread.sleep(2000);
		String expURL = "https://eu-n1-dev.nglc.net/login";
		String actURL = driver.getCurrentUrl();
		
		if (actURL.equalsIgnoreCase(expURL)) {
			test.log(LogStatus.PASS, "Actual Result:: User is being redirect to the login screen Successfully");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Not redirect to Login screen "
					+ "Expected Result:: user should be redirect to the login screen ");
		}
	}
	
	public void verifyLoginAuthScreen() throws InterruptedException {
		String expectedUrl = "https://eu-n1-dev.nglc.net/auth";
		Thread.sleep(1000);
		String actualUrl = driver.getCurrentUrl();
		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			test.log(LogStatus.PASS, "User is on the Login Auth Screen");
		} else {
			test.log(LogStatus.FAIL,
					"Expected Result:: User should be on Login Auth Screen . "
							+ "\n Actual Result:: User is not being on to the Login Auth Screen " + "Actual URL:"
							+ actualUrl);
		}

	}

}
