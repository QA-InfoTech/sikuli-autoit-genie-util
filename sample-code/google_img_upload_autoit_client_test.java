package com.qait.autoIT.sikuli.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest extends TestCase {
	public AppTest(String testName) {
		super(testName);
	}

	public void testApp() {
		Map<String, String> map = new HashMap<String, String>();
		// if (args == null) {
		// System.out.println("no arguments");
		// map.put("host", "localhost");
		// map.put("port", "8080");
		// } else {
		map.put("host", "localhost");
		map.put("port", "8080");
		// }
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://images.google.com/imghp?hl=en&gws_rd=ssl");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='qbi']")).click();
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='qbp']"))
				.isDisplayed());
		Assert.assertTrue(driver.findElement(
				By.xpath(".//a[contains(text(),'Upload an image')]"))
				.isDisplayed());
		driver.findElement(By.xpath(".//a[contains(text(),'Upload an image')]"))
				.click();
		driver.findElement(By.xpath(".//*[@type='file']")).click();
		AutoITServer jettyServerRun = AutoITServer.getJettyServerInstance(
				map.get("host"), map.get("port"));
		jettyServerRun.autoITExecutor.explicitWait(5000);
		jettyServerRun.autoITExecutor.sendKeys("Open", "", "Edit1",
				"****PATH OF THE IMAGE THAT NEEDS TO BE UPLOADED****");
		jettyServerRun.autoITExecutor.explicitWait(2000);
		jettyServerRun.autoITExecutor.click("Open", "", "Button1");
	}
}
