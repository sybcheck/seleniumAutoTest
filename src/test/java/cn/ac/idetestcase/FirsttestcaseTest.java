package cn.ac.idetestcase;

import java.io.IOException;

// Generated by Selenium IDE
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import cn.ac.base.DriverBase;

public class FirsttestcaseTest extends DriverBase {

	@Test(groups="aaa")
	public void firsttestcase() throws IOException, InterruptedException {
		LOGGER.info("执行租户查询功能");
		driver.get("http://localhost:8010/public/saas/sam/admin/main/html/main.html");
		driver.manage().window().setSize(new Dimension(1875, 1040));
		driver.findElement(By.name("login_user")).click();
		driver.findElement(By.name("login_user")).sendKeys("Super");
		driver.findElement(By.name("login_pas")).click();
		driver.findElement(By.name("login_pas")).sendKeys("Super");
		driver.findElement(By.cssSelector(".login-sub")).click();
		driver.findElement(By.cssSelector(".platformmune-list > li:nth-child(3) > span")).click();
		{
			WebElement element = driver.findElement(By.xpath("//span[contains(.,\'基础数据维护\')]"));
			Actions builder = new Actions(driver);
			builder.moveToElement(element).perform();
		}
		driver.findElement(By.xpath("//li[3]/ul/li/ul/li")).click();
		driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/span")).click();
	}
	

}
