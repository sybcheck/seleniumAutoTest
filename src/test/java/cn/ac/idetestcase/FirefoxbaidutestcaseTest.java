package cn.ac.idetestcase;

// Generated by Selenium IDE

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import cn.ac.base.DriverBase;

public class FirefoxbaidutestcaseTest extends DriverBase {

	@Test
	public void firefoxbaidutestcase() {
		LOGGER.info("执行火狐百度测试用例");
		driver.get("https://www.baidu.com/");
		driver.manage().window().setSize(new Dimension(1184, 873));
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).sendKeys("dsadas");
		driver.findElement(By.cssSelector(".bdsug-overflow")).click();
		driver.findElement(By.id("su")).click();
		{
			WebElement element = driver.findElement(By.id("su"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		{
			WebElement element = driver.findElement(By.tagName("body"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element, 0, 0).perform();
		}	
		
	}
}
