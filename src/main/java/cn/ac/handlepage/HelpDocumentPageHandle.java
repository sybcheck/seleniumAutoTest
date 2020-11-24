package cn.ac.handlepage;

import java.awt.AWTException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cn.ac.elementpage.HelpDocumentPage;

/**
 * 帮助文档管理
 * 
 * @author sybcheck
 *
 */
public class HelpDocumentPageHandle {
	HelpDocumentPage helpDocumentPage;
	public WebDriver driver;

	public HelpDocumentPageHandle(WebDriver driver) {
		helpDocumentPage = new HelpDocumentPage(driver);
		this.driver = driver;
	}

	/**
	 * 查询
	 */
	public void search() {
		try {
			helpDocumentPage.search.click();
			Thread.sleep(1500);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 添加
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void add() {
		try {
			helpDocumentPage.add.click();
			helpDocumentPage.description.sendKeys("tests00");
			helpDocumentPage.catalog.sendKeys("tests00");
			helpDocumentPage.helpdocFile.sendKeys("C:\\Users\\sybcheck\\Desktop\\upfile.html");
			helpDocumentPage.helpdocSubmit.click();
			driver.findElement(By.xpath("//span[contains(text(),'确定')]")).click();
			driver.findElement(By.xpath("//span[@class='mainModel-alert-sure']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改测试 修改第一条数据
	 */
	public void edit() {
		try {
			List<WebElement> editElements = helpDocumentPage.editButtons;
			if (editElements.size() >= 1) {
				WebElement ele = editElements.get(1);
				ele.click();
				helpDocumentPage.description.sendKeys(Keys.chord(Keys.CONTROL, "a"), "edittest");
				helpDocumentPage.catalog.sendKeys(Keys.chord(Keys.CONTROL, "a"), "edittest");
				helpDocumentPage.helpdocSubmit.click();
				driver.findElement(By.xpath("//span[contains(text(),'确定')]")).click();
				// 接收弹窗
				driver.findElement(By.xpath("//span[@class='mainModel-alert-sure']")).click();
			} else {
				System.out.println("暂无数据");
			}
			Thread.sleep(1500);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 设置每页显示条数 5页
	 */
	public void setPage() {
		helpDocumentPage.selectPage.click();
		helpDocumentPage.five.click();
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 翻页测试
	 */
	public void pageDown() {
		try {
			helpDocumentPage.pageDown.click();
			Thread.sleep(1500);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 跳页测试
	 */
	public void pageSkip() {
		try {
			helpDocumentPage.pageSkip.sendKeys(Keys.chord(Keys.CONTROL, "a"), "3");
			// 空白区域点击
			Actions actions = new Actions(driver);
			actions.moveByOffset(0, 0).click().build().perform();
			Thread.sleep(5000);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 下载测试
	 */
	public void download() {
		try {
			// 获得当前窗口句柄
			String doc_handle = driver.getWindowHandle();
			helpDocumentPage.download.click();
			Thread.sleep(2000);
			driver.switchTo().window(doc_handle);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除 一个文档
	 */
	public void delete() {
		try {
			helpDocumentPage.delete.click();
			driver.findElement(By.xpath("//span[contains(text(),'确定')]")).click();
			driver.findElement(By.xpath("//span[@class='mainModel-alert-sure']")).click();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
