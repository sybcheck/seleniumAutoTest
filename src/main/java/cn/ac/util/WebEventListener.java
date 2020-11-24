package cn.ac.util;

/*************************************** PURPOSE **********************************

 -  这个类实现了WebDriverEventListener，它包含在events中。
	实现此接口的目的是覆盖所有方法并定义某些有用的日志语句
	当被测试的应用程序正在运行时，它将被显示/记录。
	不要调用这些方法中的任何一个，而是自动调用这些方法
	当操作完成时(单击，findBy等)。
 */

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebEventListener implements WebDriverEventListener {
	public static final Logger LOGGER = LoggerFactory.getLogger(WebEventListener.class);

	public void beforeNavigateTo(String url, WebDriver driver) {
		LOGGER.debug("Before navigating to: '" + url + "'");
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		LOGGER.debug("Navigated to:'" + url + "'");
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		LOGGER.debug("Value of the:" + element.toString() + " before any changes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		LOGGER.debug("Element value changed to: " + element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		LOGGER.debug("点击标签: " + element.toString() + "之前执行...");
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		LOGGER.debug("点击标签之后: " + element.toString() + "之后执行...");
	}

	public void beforeNavigateBack(WebDriver driver) {
		LOGGER.debug("回退上一页之前执行...");
	}

	public void afterNavigateBack(WebDriver driver) {
		LOGGER.debug("回退上一页之后执行...");
	}

	public void beforeNavigateForward(WebDriver driver) {
		LOGGER.debug("Navigating forward to next page");
	}

	public void afterNavigateForward(WebDriver driver) {
		LOGGER.debug("Navigated forward to next page");
	}

	public void onException(Throwable error, WebDriver driver) {
		LOGGER.debug("Exception occured: " + error);
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		LOGGER.debug("找到标签前 : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		LOGGER.debug("找到标签后 : " + by.toString());
	}

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

}