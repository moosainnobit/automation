package com.nglc.screen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;
//import com.nglc.core.DropDown_SelectClass;
import com.nglc.core.ExcelLib;
import com.relevantcodes.extentreports.LogStatus;

public class OrganisationList extends AppDriver {
	Library library;
	public String ele;

	public OrganisationList() {
		super();
		library = new Library();
	}

	public void clickOnAddAnOrganisationBtn() throws InterruptedException {
//		long startTime = System.currentTimeMillis();
		library.clickOnAnyElement(Obj.getProperty("BY_ADDANORGANISATIONS_BUTTON"), "xpath", "click");
		String actualUrl = "https://eu-n1-dev.nglc.net/organisation/add";
		String expectedUrl = driver.getCurrentUrl();
		
//	    long endTime = System.currentTimeMillis();
//		long totalTime = endTime - startTime;
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			test.log(LogStatus.PASS, " User is on the add an organisation Screen ");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: User is not being redirect to the add an organisation  "
					+ "\n Expected Result:: User should be redirect to the add an organisation  ");
		}
//		test.log(LogStatus.INFO,"Total Page Load Time for Add an Organisation Screen: " + totalTime + " milliseconds");
		  

	}

	// ORGANISATION LIST VIEW FUNCTIONALITY
	public void clickOnLibraryListView() throws InterruptedException {
		
		library.clickOnAnyElement(Obj.getProperty("BY_ORGANISATIONSLIST_VIEW"), "xpath", "click");
		String expectedUrl = "https://eu-n1-dev.nglc.net/organisation/organisationDetails";
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			test.log(LogStatus.PASS, "Actual Result and Expected Result:: User is being redirect to the Organisation Detail page ");
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: User is not being redirect to the Organisation Detail page "
					+ "\n Expected Result:: User should be redirect to the Organisation Detail page  ");
		}
	}

	// SEARCH FUNCTIONALITY
	// Verify that search icon is clickable
	public void clickOnSearchIcon() throws InterruptedException {
		driver.findElement(By.xpath(Obj.getProperty("BY_SEARCH_ICON"))).click();
		test.log(LogStatus.PASS, "Click on Search Icon Successfully");

	}

	// Verify that Existing Data would be displayed
	public void validSearchData() throws InterruptedException {
		String expSearchText = "Norfolks county Library";
		WebElement searchText = driver.findElement(By.xpath(Obj.getProperty("BY_SEARCH_TEXT")));
		searchText.sendKeys(Config.getProperty("orgNameSearchText"));
		Thread.sleep(2000);
		WebElement searchTextEle = driver.findElement(By.xpath(Obj.getProperty("BY_SEARCHED_ORG")));
		String actSearchedText = searchTextEle.getText();
		if (actSearchedText.equalsIgnoreCase(expSearchText)) {
			test.log(LogStatus.PASS, "User is able to See the Searched Organisation ");
		}else
			test.log(LogStatus.FAIL, "Actual Result:: User is not being See the Organisation , Actual Text: "+actSearchedText+
					"\n Expected Result:: User should be See the Organisation, Expected Text: "+ expSearchText +"");

	}

	// Verify that non Existing Data would be not visible
	public void invalidSearchData() throws InterruptedException {
		String expSearchText = "No Organisation Found";
		WebElement searchText = driver.findElement(By.xpath(Obj.getProperty("BY_SEARCH_TEXT")));
		searchText.sendKeys(Config.getProperty("invalidOrgNameSearchText"));
		Thread.sleep(2000);
		WebElement searchTextEle = driver.findElement(By.xpath(Obj.getProperty("BY_NOT_FOUND")));
		String actSearchedText = searchTextEle.getText();
		if (actSearchedText.equalsIgnoreCase(expSearchText))
			test.log(LogStatus.PASS, "User is able to See No Organisation Found Message");
		else
			test.log(LogStatus.FAIL, "Actual Result:: User is not being See the No Organisation Found Message "
					+ "\n Expected Result:: User should be See the No Organisation Found Message  ");

	}

	

	public void setCountryField() {
		driver.findElement(By.xpath(Obj.getProperty("BY_ALLCOUNTRY_DROPDOWN")))
				.sendKeys(Config.getProperty("platformAdminMailID"));
	}

	// Verify the Country dropdown is clickable in organisation List Screen.
	public void clickOnCountryDropDown() throws InterruptedException {
		library.clickOnAnyElement(Obj.getProperty("BY_ALLCOUNTRY_DROPDOWN"), "xpath", "click");

	}

	// Verify the Country dropdown is enabled and visible in the organisation List Screen.
	public void isEnableCountry() throws InterruptedException {
		WebElement countryDrpDwn = driver.findElement(By.xpath(Obj.getProperty("BY_ALLCOUNTRY_DROPDOWN")));
		if (countryDrpDwn.isEnabled() && countryDrpDwn.isDisplayed()) {
			test.log(LogStatus.PASS, " Country Dropdown is enabled and visible ");
		} else {
			test.log(LogStatus.FAIL, "Country Dropdown is not visible ");

		}
	}

	
	// Verify that organisation Not found in the organisation list
	public void SelectionCountryForNotExistingOrg() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		String exp = "No Organisation Found";
		WebElement m;
		WebElement countryDrpDwn = driver.findElement(By.xpath(Obj.getProperty("BY_ALLCOUNTRY_DROPDOWN")));
		countryDrpDwn.click();
		// Xpath for Afghanistan
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//*[@id=\"root\"]/div/section/div[2]/div[2]/main/div/div[1]/div[2]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div/div/div[2]/div")));
		ele.click();
		m = driver.findElement(By.xpath("//div[text()='No Organisation Found']"));
		String act = m.getText();
		if (act.equalsIgnoreCase(exp)) {
			test.log(LogStatus.PASS, "Actual Result:: " + act);
		} else {
			test.log(LogStatus.FAIL, "Actual Result:: " + act + "  Expected Result:: " + exp);
		}

	}
	
	
	// Verify that all Organisation should be display in list view
	public void SelectionCountryForExistingOrg() throws InterruptedException {
			WebDriverWait wait= new WebDriverWait(driver,30);
			List<WebElement>TotalRowsList = driver.findElements(By.xpath(Obj.getProperty("BY_ALLCOUNTRY_DROPDOWN")));
			
			//List<WebElement> TotalRowsList = driver.findElements(By.xpath("//*[@class='scrollY scrollContent scrollStyle orgListContainer pl-vw pb-50']/div"));
			
			int eleCount=TotalRowsList.size();
			for(int i=0;i<=eleCount;i++)
			{
			System.out.println("Total number of Rows in the list are : "+TotalRowsList.size() );
			System.out.println("Total number of Rows in the list text : "+TotalRowsList);
			}
			
//			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input_fromto checkSpecialCharacters ui-autocomplete-input' and @id='hp-widget__sfrom']"))).click();
//			List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item'][starts-with(@id,'ui-id-')]//span[@class='autoCompleteItem__label']")));
//			for (WebElement element:myList)
//			    if(element.getText().contains("Mumbai"));
//			        element.click();
////			JavascriptExecutor js = (JavascriptExecutor) driver;
//			Thread.sleep(3000);	
//			WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='ant-col addOrgCardInner']\"")));
//			js.executeScript("arguments[0].scrollIntoView();", ele);
//			Thread.sleep(1000);
//			
			//}
			}

	//To Get all organisation List
	public void getOrganisationList() throws InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver,30);
		ExcelLib elib=new ExcelLib(System.getProperty("user.dir")+"//TestData//OrganisationTestData.xlsx");
		List<WebElement>TotalRowsList = driver.findElements(By.xpath(Obj.getProperty("BY_ORGANISATIONSLIST_VIEW")));
		String orgName=elib.readData("CreateOrganisation", 1, 1);
		for(int i=0;i<TotalRowsList.size();i++)
			
		{	   	
			WebElement orgNameListEle=driver.findElement(By.xpath(Obj.getProperty("BY_ORGANISATIONS_SHORTNAME_FIELD")));
			String orgNamelist=orgNameListEle.getAttribute("value");
			System.out.println("orgName::orgNamelist "	+orgNamelist+"::"+orgName);
//			Assert.assertEquals(orgName,orgNamelist);
//			test.log(LogStatus.PASS,"Organisation Added Successfully");
//			if(orgName==orgNamelist)
//			{
//				test.log(LogStatus.PASS, "Actual Result:: " + act);
//			}
						
				
			
		}
		
		
		
		
	}
}
