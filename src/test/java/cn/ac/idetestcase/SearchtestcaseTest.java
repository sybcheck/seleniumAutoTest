package cn.ac.idetestcase;

// Generated by Selenium IDE

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import cn.ac.base.DriverBase;

public class SearchtestcaseTest extends DriverBase {

	@Test
	public void searchtestcase() {
		driver.get("http://wzg02.shineway-soft.com/public/saas/sam/admin/main/html/main.html");
		driver.manage().window().setSize(new Dimension(1936, 1056));
		driver.findElement(By.name("login_user")).click();
		driver.findElement(By.name("login_user")).click();
		driver.findElement(By.name("login_user")).sendKeys("Super");
		driver.findElement(By.name("login_pas")).sendKeys("Super");
		driver.findElement(By.cssSelector(".login-sub")).click();
		driver.findElement(By.cssSelector(".platformmune-list > li:nth-child(3) > span")).click();
		driver.findElement(By.xpath("//span[contains(.,'基础数据维护')]")).click();
		driver.findElement(By.xpath("//li[24]")).click();
		driver.findElement(By.cssSelector(".searchtoolbar-search-span")).click();
	}
}