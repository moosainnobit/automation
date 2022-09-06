package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class OrganisationOverview extends AppDriver {

	Library library;
	public String ele;

	public OrganisationOverview() {
		super();
		library = new Library();
	}

	public void overviewScreen() throws InterruptedException {
		String expUrl = "https://eu-n1-dev.nglc.net/organisation/overview";
		Thread.sleep(2000);
		String actUrl = driver.getCurrentUrl();
		if (actUrl.equalsIgnoreCase(expUrl)) {
			test.log(LogStatus.PASS, "User is on the Overview Screen");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: Not Redirected to Overview Screen , Actual URL: " + actUrl
					+ "Expected URL:: " + expUrl);
		}

	}

	public void clickOnOrganisationsLink() throws InterruptedException {
		library.clickOnAnyElement(Obj.getProperty("BY_ORGANISATIONS_LINK"), "xpath", "click");
//		long startTime = System.currentTimeMillis();
		String actualUrl = "https://eu-n1-dev.nglc.net/organisation/list";
		String expectedUrl = driver.getCurrentUrl();
		// Assert.assertEquals(expectedUrl,actualUrl);
//		  long endTime = System.currentTimeMillis();
//		  long totalTime = endTime - startTime;
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			test.log(LogStatus.PASS, " User is being redirect to the organisation List. ");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: User is not being redirect to the organisation List. "
					+ "\n Expected Result:: User should be redirect to the organisation List. ");
		}
//		  test.log(LogStatus.INFO,"Total Page Load Time for organisation List Screen: " + totalTime + " milliseconds");

	}

	public void clickOnBibliothecaUsersLink() throws InterruptedException {
		driver.findElement(By.xpath(Obj.getProperty("BY_BIBLIOTHECAUSER_LINK"))).click();
		String actualUrl = "https://eu-n1-dev.nglc.net/organisation/users";
		Thread.sleep(1000);
		String expectedUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			test.log(LogStatus.PASS, "Actual Result:: User is being redirect to the Bib User Screen ");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: User is not being redirect to the Bib User Screen. "
					+ "\n Expected Result:: User should be redirect to the Bib User Screen. ");
		}
	}

	public void clickOnNotificationIcon() throws InterruptedException {
		driver.findElement(By.xpath(Obj.getProperty("BY_NOTIFICATION_ICON"))).click();
		test.log(LogStatus.PASS, "Click on Notification Icon Successfully");

	}

	public void clickOnProfileIcon() throws InterruptedException {
		driver.findElement(By.xpath(Obj.getProperty("BY_PROFILEICON_BUTTON"))).click();
		test.log(LogStatus.PASS, "Click on Profile Icon Successfully");
	}
}
