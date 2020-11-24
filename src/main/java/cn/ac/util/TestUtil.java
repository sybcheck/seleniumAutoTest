package cn.ac.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cn.ac.base.DriverBase;

public class TestUtil extends DriverBase {
	public static WebDriver driver;
	// 加载页面等待时间
	public static long PAGE_LOAD_TIMEOUT = 20;
	// 同步浏览器等待时间
	public static long IMPLICIT_WAIT = 20;

	// 操作执行js
	static JavascriptExecutor js;

	public TestUtil(WebDriver driver) {
		TestUtil.driver = driver;
	}

	/**
	 * 切换iframe
	 */
	public void switchToFrame(String ifr) {
		driver.switchTo().frame(ifr);
	}

	/**
	 * @test测试用例错误截图
	 * 
	 * @param methodname
	 * @param classname
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void takeScreenshot(String classname, String methodname) throws IOException {
		// 获取截图file
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// 将图片移动到指定位置
			FileUtils.moveFile(file, new File(getFilePath(classname, methodname)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 创建文件路径
	 * 
	 * @param classname
	 * @param methodname
	 * @return
	 */
	public static String getFilePath(String classname, String methodname) {
		// 创建储存图片的路径，不存在则创建
		File dir = new File("test-output/snapshot");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String dateStr = dateFormat.format(new Date());
		// 获取新的文件名，包含时间，类名，方法名
		String fileName = dateStr + "_" + classname + "_" + methodname + ".jpg";
		// 获取文件路径
		String filePath = dir.getAbsolutePath() + "/" + fileName;
		return filePath;

	}

	/**
	 * 获取当前时间
	 * 
	 * @param messageType
	 * @param message
	 * @throws InterruptedException
	 */
	public static String getFormatCurrentTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		// 获取当前时间
		String time = dateFormat.format(Calendar.getInstance().getTime());
		return time;
	}

	/**
	 * 执行js弹窗 暂时不用 保留
	 * 
	 * @param messageType
	 * @param message
	 * @throws InterruptedException
	 */
	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
		// '"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '" + message + "' });");
		} else if (messageType.equals("info")) {
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		} else if (messageType.equals("warning")) {
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		} else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
		// js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error
		// message goes here' });");
		// js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice
		// message goes here' });");
		// js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning
		// message goes here' });");
		Thread.sleep(5000);
	}

}
