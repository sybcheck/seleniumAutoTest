package cn.ac.idetestcase;

// Generated by Selenium IDE
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import cn.ac.base.DriverBase;

import org.openqa.selenium.Keys;

public class SectestcaseTest extends DriverBase {
	@Test(groups="bbb")
	public void sectestcase() {
		LOGGER.info("执行协同查询功能");
		driver.get("http://localhost:8010/public/saas/sam/admin/main/html/main.html");
		driver.manage().window().setSize(new Dimension(945, 1020));
		driver.findElement(By.name("login_user")).click();
		driver.findElement(By.name("login_user")).sendKeys("Super");
		driver.findElement(By.name("login_pas")).sendKeys("Super");
		driver.findElement(By.name("login_pas")).sendKeys(Keys.ENTER);
		driver.findElement(By.cssSelector(".platformmune-list > li:nth-child(3) > span")).click();
		{
			WebElement element = driver.findElement(By.xpath("//span[contains(.,\'基础数据维护\')]"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.xpath("//li[23]")).click();

		driver.findElement(By.cssSelector(".searchtoolbar-search-span")).click();

		WebElement ele = driver.findElement(By.cssSelector(".searchtoolbar-batchAdd"));
		// xpath=//div[2]/div[2]/div/div/div/div/span
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		ele = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		// {
		// WebElement element = driver.findElement(By.cssSelector("tr:nth-child(1) >
		// td:nth-child(2)"));
		// Actions builder = new Actions(driver);
		// builder.moveToElement(element).perform();
		// }
		driver.findElement(By.xpath("//input[@name=\'coordinationcode\']")).sendKeys("fff");
		ele = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(3)"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		driver.findElement(By.xpath("//input[@name=\'coordinationdesc\']")).sendKeys("fff");
	}
	@Test
	public void aa() {
		System.out.println("");
	}
}
