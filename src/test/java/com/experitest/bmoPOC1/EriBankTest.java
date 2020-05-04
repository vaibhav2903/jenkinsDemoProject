package com.experitest.bmoPOC1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class EriBankTest {
	 private String accessKey = "eyJ4cC51IjozODI3MjEsInhwLnAiOjIsInhwLm0iOiJNVFUxTmpnd09UVTROakk1T0EiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4NzIxNjk1ODYsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.aTgX-5SHxDCBFF2opiw6tAoiRSifp84tJtrQd9-N2go";
	    protected IOSDriver<IOSElement> driver = null;
	    DesiredCapabilities dc = new DesiredCapabilities();

	    @Parameters("region")
	    @BeforeTest
	    public void setUp(@Optional String region) throws MalformedURLException {
	        dc.setCapability("testName", "Quick Start iOS Native Demo Test "+region);
	        dc.setCapability("accessKey", accessKey);
	        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE' and @region='"+region+"'");
	        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
	        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
	        driver = new IOSDriver<IOSElement>(new URL("https://uscloud.experitest.com/wd/hub"), dc);
	    }

	    @Test
	    public void quickStartiOSNativeDemo() {
	        driver.rotate(ScreenOrientation.PORTRAIT);
	        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
	        driver.hideKeyboard();
	        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
	        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
	        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
	        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
	        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
	        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
	        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
	        driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
	        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
	        driver.findElement(By.xpath("//*[@id='Yes']")).click();
	    }

	    @AfterTest
	    public void tearDown() {
	        System.out.println("Report URL: "+ driver.getCapabilities().getCapability("reportUrl"));
	        driver.quit();
	    }

}
