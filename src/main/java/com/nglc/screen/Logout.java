package com.nglc.screen;

import org.openqa.selenium.By;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;
import com.relevantcodes.extentreports.LogStatus;

public class Logout extends AppDriver
{
	Library library;
	public Logout() {
		super();
		library=new Library();	
	}
	public void clickOnLogoutBtn() throws InterruptedException	{
		
		driver.findElement(By.xpath(Obj.getProperty("BY_LOGOUT_BUTTON"))).click();
		test.log(LogStatus.PASS, "Click on Logout Button Successfully");
	}

}
