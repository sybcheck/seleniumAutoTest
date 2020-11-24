package cn.ac.idetestcase;

// Generated by Selenium IDE

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import cn.ac.base.DriverBase;

public class ChromejngxiaoyuntestcaseTest extends DriverBase {

	@Test
	public void chromejngxiaoyuntestcase() {
		LOGGER.info("执行谷歌抓取的代码");
		driver.get("http://localhost:8010/public/saas/sam/admin/main/html/main.html");
		driver.manage().window().setSize(new Dimension(1936, 1056));
		driver.findElement(By.name("login_user")).click();
		driver.findElement(By.name("login_user")).sendKeys("Super");
		driver.findElement(By.name("login_pas")).sendKeys("Super");
		driver.findElement(By.cssSelector(".login-sub")).click();
		driver.findElement(By.cssSelector(".platformmune-list > li:nth-child(3) > span")).click();
		{
			WebElement element = driver.findElement(By.xpath("//span[contains(.,\'基础数据维护\')]"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.xpath("//li[23]")).click();
		driver.findElement(By.cssSelector(".searchtoolbar-search-span")).click();
	}
}
