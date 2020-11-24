package cn.ac.idetestcase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cn.ac.util.TestUtil;
import cn.ac.util.WebEventListener;

public class TestSeleniumWebDriver {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	@BeforeTest
	public void bftest() {
		System.out.println("火狐栈溢出测试");
		// 加载配置文件
		try {
			prop = new Properties();
			prop.load(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("config.properties"),
					"utf-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty(prop.getProperty("geckoDriverName"), prop.getProperty("geckoDriverPath"));
		// 无头模式
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary("D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		firefoxOptions.addArguments("--headless");//
		driver = new FirefoxDriver(firefoxOptions);
		e_driver = new EventFiringWebDriver(driver);
		// 实现自己的监听器
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		// 加载超时
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		// 同步浏览器
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	@Test
	public void teststachoverflow() {
		driver.get("https://www.baidu.com");
		driver.manage().window().setSize(new Dimension(945, 1020));
		driver.findElement(By.id("kw")).click();
		driver.findElement(By.id("kw")).sendKeys("dsadasda");
		System.out.println("测试结束");
	}

	@AfterTest
	public void aftest() {
		driver.close();
		driver.quit();
	}
}
