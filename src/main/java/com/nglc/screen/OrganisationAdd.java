package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.nglc.core.AppDriver;
import com.nglc.core.ExcelLib;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class OrganisationAdd extends AppDriver {
	ExcelLib elib = new ExcelLib(System.getProperty("user.dir") + "//TestData//OrganisationTestData.xlsx");
	Library library;

	public OrganisationAdd() {
		super();
		library = new Library();
	}

	public void enterOrganisationName() {
		driver.findElement(By.xpath(Obj.getProperty("BY_ORGANISATIONNAME_TEXT")))
				.sendKeys(Config.getProperty("platformAdminMailID"));

	}

	public void clickOnCreateOrganisationButton() throws InterruptedException {

		driver.findElement(By.xpath(Obj.getProperty("BY_CREATEORGANISATION_BUTTON"))).click();
		Thread.sleep(2000);
		String expectedUrl = "https://eu-n1-dev.nglc.net/organisation/list";
		String actualUrl = driver.getCurrentUrl();
		
		if(expectedUrl.equalsIgnoreCase(actualUrl)) {
			test.log(LogStatus.PASS, "Organization Added Successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Expected URL: "+expectedUrl+" Actual URL: "+actualUrl);
		}
	}

	public void CreateAnOrganisationFilledAllRequiredData() throws InterruptedException {
		
		

		WebElement orgNameEle = driver.findElement(By.xpath(Obj.getProperty("BY_ORGANISATIONNAME_TEXT")));
		orgNameEle.sendKeys(elib.readData("CreateOrganisation", 1, 1));
		String OrgNameText = orgNameEle.getAttribute("value");
		if (OrgNameText == "") {
			test.log(LogStatus.FAIL, "Organisation name is required");
		}

		
		WebElement displayNameEle = driver.findElement(By.xpath(Obj.getProperty("BY_DISPLAYNAME_TEXT")));
		displayNameEle.sendKeys(elib.readData("CreateOrganisation", 1, 2));
		String displayNameText = displayNameEle.getAttribute("value");
		if (displayNameText == "") {
			test.log(LogStatus.FAIL, "Display name is required");
		}
		
		
		WebElement streetAddEle = driver.findElement(By.xpath(Obj.getProperty("BY_STREETADDRESS_TEXT")));
		streetAddEle.sendKeys(elib.readData("CreateOrganisation", 1, 3));
		String streetAddText = streetAddEle.getAttribute("value");
		if (streetAddText == "") {
			test.log(LogStatus.FAIL, "Street address is required");
		}

		
		WebElement localityEle = driver.findElement(By.xpath(Obj.getProperty("BY_LOCALITY_TEXT")));
		localityEle.sendKeys(elib.readData("CreateOrganisation", 1, 4));
		String localityText = localityEle.getAttribute("value");
		if (localityText == "") {
			test.log(LogStatus.FAIL, "Locality is required");
		}

		WebElement postCodeEle = driver.findElement(By.xpath(Obj.getProperty("BY_POSTALCODE_TEXT")));
		postCodeEle.sendKeys(elib.readData("CreateOrganisation", 1, 5));
		String postCodeText = postCodeEle.getAttribute("value");
		if (postCodeText == "") {
			test.log(LogStatus.FAIL, "Postal Code is required");
		}
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");

		WebElement countrydrpdwn = driver.findElement(By.xpath(Obj.getProperty("BY_COUNTRY_DROPDOWN")));
		countrydrpdwn.sendKeys(elib.readData("CreateOrganisation", 1, 6));
		countrydrpdwn.sendKeys(Keys.DOWN);
		countrydrpdwn.sendKeys(Keys.ENTER);
		String countryText = countrydrpdwn.getAttribute("value");
		if (countryText == "") {
			test.log(LogStatus.FAIL, "Country Code is required");
		}
		

		WebElement regiondrpdwn = driver.findElement(By.xpath(Obj.getProperty("BY_REGION_DROPDOWN")));
		regiondrpdwn.sendKeys(elib.readData("CreateOrganisation", 1, 7));
		regiondrpdwn.sendKeys(Keys.DOWN);
		regiondrpdwn.sendKeys(Keys.ENTER);
		String regionText = regiondrpdwn.getAttribute("value");
		if (regionText == "") {
			test.log(LogStatus.FAIL, "Region is required");
		}

//		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Obj.getProperty("BY_ORGANISATIONWEBSITE_TEXT"))));
//		js.executeScript("arguments[0].scrollIntoView();", ele);
		
		WebElement websiteEle = driver.findElement(By.xpath(Obj.getProperty("BY_ORGANISATIONWEBSITE_TEXT")));
		websiteEle.sendKeys(elib.readData("CreateOrganisation", 1, 8));
		
//		WebElement emailEle = driver.findElement(By.xpath(Obj.getProperty("BY_SUPPORTEMAIL_TEXT")));
//		emailEle.sendKeys(elib.readData("CreateOrganization", 1, 9));
//		
//		Thread.sleep(2000);
//		WebElement urlEle = driver.findElement(By.xpath(Obj.getProperty("BY_SUPPORTURL_TEXT")));
//		urlEle.sendKeys(elib.readData("CreateOrganization", 1, 10));
		
		WebElement languagedrpdwn = driver.findElement(By.xpath(Obj.getProperty("BY_LANGUAGE_DROPDOWN")));
		languagedrpdwn.sendKeys(elib.readData("CreateOrganisation", 1, 11));
		languagedrpdwn.sendKeys(Keys.DOWN);
		languagedrpdwn.sendKeys(Keys.ENTER);
		String languageText = languagedrpdwn.getAttribute("value");
		if (languageText == "") {
			test.log(LogStatus.FAIL, "Language is required");
		}
		
		
		WebElement timezonedrpdwn = driver.findElement(By.xpath(Obj.getProperty("BY_TIMEZONE_DROPDOWN")));
		timezonedrpdwn.sendKeys(elib.readData("CreateOrganisation", 1, 12));
		timezonedrpdwn.sendKeys(Keys.DOWN);
		timezonedrpdwn.sendKeys(Keys.ENTER);
		String timezoneText = timezonedrpdwn.getAttribute("value");
		if (timezoneText == "") {
			test.log(LogStatus.FAIL, "Timezone is required");
		}
		

		WebElement culturedrpdwn = driver.findElement(By.xpath(Obj.getProperty("BY_CULTURE_DROPDOWN")));
		culturedrpdwn.sendKeys(Keys.DOWN);
		culturedrpdwn.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		culturedrpdwn.sendKeys(elib.readData("CreateOrganisation", 1, 13));
		Thread.sleep(1000);
//		String cultureText = culturedrpdwn.getAttribute("value");
//		if (cultureText == "") {
//			test.log(LogStatus.FAIL, "Culture is required");
//		}

	}

	public void CreateAnOrganisationBlankRequiredData() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement orgNameEle = driver.findElement(By.xpath(Obj.getProperty("BY_ORGANISATIONNAME_TEXT")));
		orgNameEle.sendKeys("");
		orgNameEle.click();
		Thread.sleep(2000);
		WebElement OrgNameError = driver.findElement(By.xpath(Obj.getProperty("BY_ORGANISATIONNAME_ERROR_MESSAGES")));
		String expectedOrgNameError = "Organisation name is required";
		String actOrgNameError = OrgNameError.getAttribute("Value");
		System.out.println("actOrgNameError" + actOrgNameError);
//		if (actOrgNameError.equalsIgnoreCase(expectedOrgNameError)) {
//			test.log(LogStatus.PASS, "Actual Result and Expected Result:: Organisation name is required ");
//		} else {
//			test.log(LogStatus.FAIL,   Organisation name is required ");
//		}
//		{
//		  test.log(LogStatus.FAIL, "Organisation name is required");
//		}
		Assert.assertEquals(expectedOrgNameError, actOrgNameError);
		test.log(LogStatus.FAIL, "Organisation name is required");

		driver.findElement(By.xpath(Obj.getProperty("BY_DISPLAYNAME_TEXT"))).sendKeys("");

		driver.findElement(By.xpath(Obj.getProperty("BY_STREETADDRESS_TEXT"))).sendKeys("");
		WebElement streetAddressError = driver
				.findElement(By.xpath(Obj.getProperty("BY_STREETADDRESS_ERROR_MESSAGES")));
		String expectedStreetAddressError = "Street address is required";
		String actStreetAddressError = streetAddressError.getAttribute("Value");
		System.out.println("expectedStreetAddressError" + actStreetAddressError);
		Assert.assertEquals(expectedOrgNameError, actStreetAddressError);
		test.log(LogStatus.FAIL, "Street address is required");

		driver.findElement(By.xpath(Obj.getProperty("BY_LOCALITY_TEXT"))).sendKeys("");

		driver.findElement(By.xpath(Obj.getProperty("BY_POSTALCODE_TEXT"))).sendKeys("");

		js.executeScript("window.scrollBy(0,2050)", "");

		driver.findElement(By.xpath(Obj.getProperty("BY_COUNTRY_DROPDOWN"))).sendKeys("");

		driver.findElement(By.xpath(Obj.getProperty("BY_REGION_DROPDOWN"))).sendKeys("");

		WebElement ele = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(Obj.getProperty("BY_CREATEORGANISATION_BUTTON"))));
		js.executeScript("arguments[0].scrollIntoView();", ele);

		driver.findElement(By.xpath(Obj.getProperty("BY_LANGUAGE_DROPDOWN"))).sendKeys("");

		driver.findElement(By.xpath(Obj.getProperty("BY_TIMEZONE_DROPDOWN"))).sendKeys("");

		driver.findElement(By.xpath(Obj.getProperty("BY_CULTURE_DROPDOWN"))).sendKeys("");

	}
}
