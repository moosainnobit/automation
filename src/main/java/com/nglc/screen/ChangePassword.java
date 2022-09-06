package com.nglc.screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.nglc.core.AppDriver;
import com.nglc.core.Library;

public class ChangePassword extends AppDriver
{
	Library library;
	public ChangePassword() {
		super();
		library=new Library();	
	}
	public void setNewPassword() {
		driver.findElement(By.xpath(Obj.getProperty("BY_FORGOT_NEWPASSWORD_TEXT")));
	}
	public void setConfirmPassword() {
		driver.findElement(By.xpath(Obj.getProperty("BY_FORGOT_CONFIRMPASSWORD_TEXT")));
	}
	
	public void clickOnValidSaveNewPasswordBtn()	{
		
		library.clickOnAnyElement(Obj.getProperty("BY_SAVE_NEW_PASSWORD_BUTTON"), "xpath", "click");	
		
	}
	public void clickOnBlankSaveNewPasswordBtn() throws InterruptedException
	{
		 String newPasswordExpectation = "Please enter a valid password";
		 String confirmPasswordExpectation = "Password does not match";
	     WebElement m;
	     driver.findElement(By.xpath(Obj.getProperty("BY_FORGOT_NEWPASSWORD_TEXT"))).sendKeys("");
	     driver.findElement(By.xpath(Obj.getProperty("BY_FORGOT_CONFIRMPASSWORD_TEXT"))).sendKeys("");
		 	  
	     clickOnValidSaveNewPasswordBtn();
	    
		  Thread.sleep(1000);
		  m =  driver.findElement(By.xpath(Obj.getProperty("BY_FORGOT_NEWPASSWORD_ERROR_MESSAGE")));
		  String newPasswordActual = m.getText();		    
		  Assert.assertEquals(newPasswordExpectation, newPasswordActual);
		  Reporter.log(newPasswordActual,true);
		  
		  Thread.sleep(1000);
		  m =  driver.findElement(By.xpath(Obj.getProperty("BY_FORGOT_CONFIRMPASSWORD_ERROR_MESSAGE")));
		  String confirmPasswordActual = m.getText();		    
		  Assert.assertEquals(confirmPasswordExpectation, confirmPasswordActual);
		  Reporter.log(confirmPasswordActual,true);
	
	}
}
