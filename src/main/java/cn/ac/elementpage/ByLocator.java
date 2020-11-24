package cn.ac.elementpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cn.ac.base.DriverBase;

public class ByLocator extends DriverBase {
	public ByLocator() {
		super();
	}

	// by的封装和从配置文件中读取数据进行分割

	public static WebElement bylocator(String identity) {
		
		String locator = prop.getProperty(identity);
		String locatorType = locator.split("=>")[0];
		String locatorValue = locator.split("=>")[1];
		// 根据type的元素定位方式，返回元素定位
		if (locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else {
			return driver.findElement(By.xpath(locatorValue));
		}
	}

	/**
	 * 读取一组元素
	 * 
	 * @param identity
	 * @return
	 */
	public static List<WebElement> bylocators(String identity) {
		String locator = prop.getProperty(identity);
		String locatorType = locator.split("=>")[0];
		String locatorValue = locator.split("=>")[1];
		// 根据type的元素定位方式，返回元素定位
		if (locatorType.equalsIgnoreCase("xpaths")) {
			return driver.findElements(By.xpath(locatorValue));
		}
		return null;
	}
}
