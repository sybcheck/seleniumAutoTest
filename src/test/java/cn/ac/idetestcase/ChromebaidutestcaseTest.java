package cn.ac.idetestcase;

// Generated by Selenium IDE

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import cn.ac.base.DriverBase;

public class ChromebaidutestcaseTest extends DriverBase {
	@Test
	public void baiduonetestcase() {
		LOGGER.info("执行谷歌百度测试用例");
		driver.get("https://www.baidu.com/");
		driver.manage().window().setSize(new Dimension(945, 1020));
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).sendKeys("豆瓣");
		driver.findElement(By.id("su")).click();
	}
}