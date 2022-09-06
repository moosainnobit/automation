package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class ForgotPassword extends AppDriver {

	Library library;

	public ForgotPassword() {
		super();
		library = new Library();
	}

	public void setEmailName(String name) {
		WebElement emailName = driver.findElement(By.xpath(Obj.getProperty("BY_FORGOTPASSWORD_TEXT")));
		emailName.sendKeys(name);
	}

	public void clickOnSendResetLinkBtn() throws InterruptedException {
		driver.findElement(By.xpath(Obj.getProperty("BY_FORGOTPASSWORD_BUTTON"))).click();
		test.log(LogStatus.PASS, "Click on Send Reset Link Button Successfully");

	}

	public void validateEmailAddress() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement emailLabelActEle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='forgot-pwd_email']")));
		String emailLabelActual = emailLabelActEle.getAttribute("value");
		System.out.println("emailLabelActual" + emailLabelActual);
		String emailLabelExpected = Config.getProperty("platformAdminMailID");
		System.out.println("emailLabelExpected" + emailLabelExpected);
		if (emailLabelActual.equalsIgnoreCase(emailLabelExpected)) {
			test.log(LogStatus.PASS,
					"Actual Result:: Email address field must be same in the login page email address.");

		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Email address field not be same in the login page email address."
					+ "  Expected Result:: Email address field should be same in the login page email address.");

		}

	}

	public void verifyNotificationMsgAfterClickOnSendResetBtn() throws InterruptedException {
		String expMessage = "Email sent successfully";
		WebElement m = driver.findElement(By.xpath(Obj.getProperty("BY_SENT_SUCCESSFULLY")));
		String actMessage = m.getText();
		if (actMessage.equalsIgnoreCase(expMessage)) {
			test.log(LogStatus.PASS, "Actual Result:: Message (" + actMessage + ") is being dispalyed.");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Message (" + actMessage + ") is not being dispalyed.  "
					+ "Expected Result:: Message (" + expMessage + ") should be display on the login screen ");

		}
	}

}
