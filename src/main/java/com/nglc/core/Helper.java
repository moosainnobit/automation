package com.nglc.core;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Helper {
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static String username = "user-name";
	public static String access_key = "access-key";

	public void setupThread(String build, String name, String platformName, String browserName, String browserVersion)
			throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("build", build);
		capabilities.setCapability("name", name);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", browserVersion);
		capabilities.setCapability("tunnel", false);
		capabilities.setCapability("network", true);
		capabilities.setCapability("console", true);
		capabilities.setCapability("visual", true);

		driver.set(new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"),
				capabilities));
	}

	public WebDriver getDriver() {
		return driver.get();
	}

	public void tearDownThread() {
		getDriver().quit();
	}
}
