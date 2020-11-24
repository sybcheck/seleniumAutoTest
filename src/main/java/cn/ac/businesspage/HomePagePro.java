package cn.ac.businesspage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import cn.ac.elementpage.HomePage;
import cn.ac.handlepage.HomePageHandle;

/**
 * 业务逻辑层
 * 
 * @author sybcheck
 *
 */
public class HomePagePro {
	HomePageHandle homePageHandle;
	HomePage homePage;
	public WebDriver driver;

	public HomePagePro(WebDriver driver) {
		homePageHandle = new HomePageHandle(driver);
		homePage = new HomePage(driver);
		this.driver = driver;
	}

	/**
	 * 基础数据/基础数据维护
	 */
	public void clickBasicData() {
		homePageHandle.basicDataMaintenance();
	}

	/**
	 * 基础数据/基础数据维护/帮助文档管理
	 */
	public void clickHelpDocument() {
		homePageHandle.clickhelpDocument();
	}

	/**
	 * 基础数据/基础数据维护/租户管理/查询
	 */
	public void tenantManagementSearch() {
		homePageHandle.basicDataMaintenance();
		homePageHandle.tenantManagementSearch();
	}

	/**
	 * 基础数据/基础数据维护/协同定义/查询
	 */
	public void synergyDefinedSearch() {
		homePageHandle.basicDataMaintenance();
		homePageHandle.synergyDefinedSearch();
	}

	/**
	 * 基础数据/基础数据维护/协同定义/添加
	 */
	public void addData() {
		homePageHandle.basicDataMaintenance();
		homePageHandle.synergyDefinedAdd();
		// 循环打印搜索结果的标题
		int i = 1;
		List<WebElement> tdElements = homePage.tdElements;
		if (i <= tdElements.size()) {
			WebElement ele = tdElements.get(i);
			ele.click();
			// 显示等待,针对某个元素等待 （可以加条件 这个例子中好像并没有加条件 所以和隐式等待没什么区别）
			WebDriverWait wait = new WebDriverWait(driver, 5, 1);
			wait.until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver arg) {
					return ele.findElement(By.xpath("//input[@name='coordinationcode']"));
				}
			}).sendKeys(String.valueOf((int) ((Math.random() * 9 + 1) * 100)));
			// 隐式等待
			// 定位对象时给 10s 的时间, 如果 10s 内还定位不到则抛出异常
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//input[@name='coordinationdesc']")).sendKeys("6");
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//ul/li[contains(text(),'企业间')]")).click();
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//input[@name='sourceclassname']")).sendKeys("6");
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//input[@name='sourcemethodname']")).sendKeys("6");
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//input[@name='destclassname']")).sendKeys("6");
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//input[@name='destmethodname']")).sendKeys("6");
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//input[@name='operationdirection']")).sendKeys("6");
			tdElements.get(++i).click();
			tdElements.get(i).findElement(By.xpath("//input[@name='beginopportune']")).sendKeys("6");
		}
		homePage.saveButton.click();
		driver.findElement(
				By.xpath("//div[@class='mainModel-alert-submit clearfix']/span[@class='mainModel-alert-sure']"))
				.click();
	}


}
