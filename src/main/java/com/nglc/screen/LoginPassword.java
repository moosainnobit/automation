package com.nglc.screen;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import com.nglc.core.AppDriver;
import com.nglc.core.Library;
import com.nglc.core.Screenshots;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPassword extends AppDriver {
	Library library;
	public String ele;

	public LoginPassword() {
		super();
		library = new Library();
	}

	public void emailLabel() {
		WebElement ele = driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_LABEL")));
		// System.out.println("Email label" + ele);
	}

	public void enterValidPassword() {
		// .sendKeys(Config.getProperty("platformAdminPwd"));
		WebElement pwdtext = driver.findElement(By.xpath(Obj.getProperty("BY_PASSWORD_TEXT")));
		pwdtext.sendKeys(Config.getProperty("platformAdminPwd"));
		test.log(LogStatus.INFO, "Enter the Password: " + pwdtext.getAttribute("value"));

	}

	public void clickOnLoginBtn() throws InterruptedException {
		driver.findElement(By.xpath(Obj.getProperty("BY_PASSWORDLOGIN_BUTTON"))).click();
		test.log(LogStatus.PASS, "Click on Login Button Successfully");

	}

	public void verifyOverviewScreen() throws InterruptedException {
		String expectedUrl = "https://eu-n1-dev.nglc.net/organisation/overview";
		Thread.sleep(1000);
		String actualUrl = driver.getCurrentUrl();
		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			test.log(LogStatus.PASS, "Actual Result:: User is being redirect to the Overview Page");
		} else {
			test.log(LogStatus.FAIL,
					"Expected Result:: User should be redirect to the Overview Page . "
							+ "\n Actual Result:: User is not being redirect to the Overview Page " + "Actual URL:"
							+ actualUrl);
		}

	}

	public void verifyLoginPasswordScreen() throws InterruptedException {
		String expectedUrl = "https://eu-n1-dev.nglc.net/login";
		Thread.sleep(1000);
		String actualUrl = driver.getCurrentUrl();
		if (expectedUrl.equalsIgnoreCase(actualUrl)) {
			test.log(LogStatus.PASS, "Actual Result:: User is on the Login Password Screen");
		} else {
			test.log(LogStatus.FAIL,
					"Expected Result:: User should be on Login Password Screen . "
							+ "\n Actual Result:: User is not being on to the Login Password Screen " + "Actual URL:"
							+ actualUrl);
		}

	}

	// Login_FT_076 :: Test with valid username and empty password and check if
	// login fails
	public void BlankPasswordMessageValidate() throws InterruptedException {
		String expMessage = "Please enter the correct password";
		Thread.sleep(1000);
		WebElement m = driver.findElement(By.xpath(Obj.getProperty("BY_BLANK_PASSWORD_FIELD_ERROR_MESSAGES")));
		String actMessage = m.getText();
		if (actMessage.equalsIgnoreCase(expMessage)) {
			test.log(LogStatus.PASS, "Actual Result:: Validation message (" + actMessage + ") is being dispalyed. ");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Validation message (" + actMessage + ") is not being dispalyed.  "
					+ "Expected Result:: Validation Message (" + expMessage + ") should be displayed. ");

		}
	}

	// Login_FT_077 :: Check of the password is masked on the screen i.e., password
	// must be in bullets or asterisks.
	public void MaskedPassword() throws InterruptedException {
		String pwdExp = "password";

		WebElement act = driver.findElement(By.xpath(Obj.getProperty("BY_PASSWORD_TEXT")));
		act.sendKeys(Config.getProperty("platformAdminPwd"));
		test.log(LogStatus.INFO, "Enter the Password:" + act.getAttribute("value"));

		String pwdAct = act.getAttribute("type");
		// clickOnLoginBtn();
		if (pwdAct.equalsIgnoreCase(pwdExp)) {
			test.log(LogStatus.PASS,
					"Actual Result:: The password field is being display the characters in  bullets such that the password is not visible on the screen. ");
		} else {
			test.log(LogStatus.FAIL,
					"Actual Result:: The password field is not being  display the characters in  bullets such that the password is not visible on the screen  "
							+ "Expected Result:: The password field would be display the characters in  bullets such that the password is not visible on the screen. ");

		}
	}

	public void enterInvalidPassword() {
		WebElement pwdtext = driver.findElement(By.xpath(Obj.getProperty("BY_PASSWORD_TEXT")));
		pwdtext.sendKeys(Config.getProperty("incorrectPlatformAdminPwd"));
		test.log(LogStatus.INFO, "Enter the EmailID: " + pwdtext.getAttribute("value"));

	}

	public void invalidPasswordMessageValidate() throws InterruptedException, IOException {
		String expMessage = "Username or Password not found. Please try again.";
		WebElement m = driver.findElement(By.xpath(Obj.getProperty("BY_FIELD_ERROR_MESSAGES")));
		String actMessage = m.getText();
		if (actMessage.equalsIgnoreCase(expMessage)) {
			test.log(LogStatus.PASS, "Actual Result:: Validation Message (" + actMessage + ") is being dispalyed.");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Validation Message (" + actMessage + ") is not being dispalyed.  "
					+ "Expected Result:: Validation Message (Please enter a valid email address) should be display on the login screen ");

		}

	}

	// Login_FT_073 :: Check the back arrow button on the web working or not.
	public void clickOnBackImageBtn() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='backImg']")).click();
		test.log(LogStatus.INFO, "Click on the Back Arrow Image");

		String exp = "http://eu-n1-dev.nglc.net/auth";
		String act = driver.getCurrentUrl();
		if (!act.equalsIgnoreCase(exp)) {
			test.log(LogStatus.PASS, "Actual Result:: User is being redirect to the auth page.");
		} else {

			test.log(LogStatus.FAIL,
					"Actual Result:: User is not being redirect to the auth page.\n  Expected Result:: User should be redirect to the auth page.");
		}

	}

	// Login_FT_072 :: Check the back Text link is there in the Password screen.
	public void clickOnBackTextBtn() throws InterruptedException {

		driver.findElement(By.xpath(Obj.getProperty("BY_BACK_BUTTON"))).click();
		test.log(LogStatus.INFO, "Click on the Back Button");
		String exp = "https://eu-n1-dev.nglc.net/auth";
		Thread.sleep(1000);
		String act = driver.getCurrentUrl();
		if (act.equalsIgnoreCase(exp)) {
			test.log(LogStatus.PASS, "Actual Result:: User is being redirect to the auth page.");
		} else {
			test.log(LogStatus.FAIL,
					"Actual Result:: User is not being redirect to the auth page.\n  Expected Result:: User should be redirect to the auth page.");
		}

	}

	// Login_FT_074 :: Verify the email address field is same as enter in login
	// screen.
	public void validateEmailAddress() throws InterruptedException {
		WebElement emailLabelActEle = driver.findElement(By.xpath(Obj.getProperty("BY_EMAIL_LABEL")));
		String emailLabelActual = emailLabelActEle.getText();
		String emailLabelExpected = Config.getProperty("platformAdminMailID");
		if (emailLabelActual.equalsIgnoreCase(emailLabelExpected)) {
			test.log(LogStatus.PASS,
					"Actual Result:: Email address field must be same in the login page email address.");

		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Email address field not be same in the login page email address."
					+ "  Expected Result:: Email address field should be same in the login page email address.");

		}
	}

	public void clickOnForgotPasswordBtn() throws InterruptedException {

		library.clickOnAnyElement(Obj.getProperty("BY_FORGOT_LINK"), "xpath", "click");
		test.log(LogStatus.PASS, "Click on Forgot Password Link Successfully");

	}

	public void verifyForgotPasswordScreen() throws InterruptedException {
		String expURL = "https://eu-n1-dev.nglc.net/forgot-password";
		Thread.sleep(1000);
		String actURL = driver.getCurrentUrl();
		if (actURL.equalsIgnoreCase(expURL)) {
			test.log(LogStatus.PASS, "Actual Result:: User is being redirect to the Forgot password screen ");
		} else {
			test.log(LogStatus.FAIL, "Actual Result: User is not being redirect to the Forgot password screen. Actual URL: "+actURL+ " "
					+ "\n Expected Result:: User should be redirect to the Forgot password screen. ");
		}
	}

	public void enterCaseSensitivityPwd() {

		WebElement caseSensitivityPwdText = driver.findElement(By.xpath(Obj.getProperty("BY_PASSWORD_TEXT")));
		caseSensitivityPwdText.sendKeys(Config.getProperty("caseSensitivityPwd"));
		test.log(LogStatus.INFO, "Enter the Password: " + caseSensitivityPwdText.getAttribute("value"));
	}

	public void validateErrorMessageCaseSensitivityPwd() throws InterruptedException {

		String expMessage = "Username or Password not found. Please try again.";
		WebElement m = driver.findElement(By.xpath(Obj.getProperty("BY_PASSWORD_FIELD_ERROR_MESSAGES")));
		String actMessage = m.getText();
		if(actMessage.equalsIgnoreCase(expMessage)) {
			test.log(LogStatus.PASS, "Actual Result: Validation Message ("+ actMessage +") is being displayed. ");
		}else {
			test.log(LogStatus.FAIL, "Actual Result: Validation Message (\"+ actMessage +\") is being displayed. " + "\n Expected Result:: Validation Message (" + expMessage + ") should be displayed.");
		}
		
	}

}
