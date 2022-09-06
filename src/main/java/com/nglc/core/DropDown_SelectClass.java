package com.nglc.core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown_SelectClass 
{
	public void selectIndex(WebElement ele, int i)
	{
		Select s = new Select(ele);
	    s.selectByIndex(i);
	}
	public void selectText(WebElement ele, String Text)
	{
		Select s = new Select(ele);
	    s.selectByVisibleText(Text);
	}
	public void selectValue(WebElement ele, String Text)
	{
		Select s = new Select(ele);
	    s.selectByValue(Text);
	}
	public void DeselectIndex(WebElement ele, int i)
	{
		Select s = new Select(ele);
	    s.deselectByIndex(i);
	}
	public void DeselectText(WebElement ele, String Text)
	{
		Select s = new Select(ele);
	    s.deselectByVisibleText(Text);
	}
	public void DeselectValue(WebElement ele, String Text)
	{
		Select s = new Select(ele);
	    s.deselectByValue(Text);
	}
	public void IsMultipleSelection(WebElement ele)
	{
		Select s = new Select(ele);
		s.isMultiple();
		
		if(s.isMultiple()) 
		   { 
		      System.out.println("Dropdown list accepts multiple choices"); 
		   } 
		  else { 
		     System.out.println("Dropdown list does not accept multiple choices"); 
		  } 
	}
	

}
