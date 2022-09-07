package com.nglc.core;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Screenshots {

	public static String photo(WebDriver driver, String tcName) throws IOException {
		 String photo= System.getProperty("user.dir")+"//Screenshots//";
		// "/home/innobit/eclipse-workspace/nglc-webui-automation/Screenshots/";
		//String photo = "Screenshots//";
		Date d = new Date();
		String d1 = d.toString();
		String date = d1.replaceAll(":", "-");
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(photo + date + tcName + ".jpeg");
		String path = destinationFile.getCanonicalPath();
		FileUtils.copyFile(sourceFile, destinationFile);

		return path;
	}

}
