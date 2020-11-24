package cn.ac.elementpage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	/**
	 * (xpath方式下) class方式获取标签 //div[@class='login-sub'] 文本方式获取标签
	 * //span[contains(text(),'基础数据维护')]
	 */
	// 基础数据
	@FindBy(xpath = "//span[contains(text(),'基础数据')]")
	public WebElement basicData;

	// 基础数据维护
	@FindBy(xpath = "//span[contains(text(),'基础数据维护')]")
	public WebElement basicDataMaintenance;

	/**
	 * 租户管理 start...
	 */
	// 租户管理
	@FindBy(xpath = "//li[contains(text(),'租户管理')]")
	public WebElement tenantManagement;

	// 查询
	@FindBy(xpath = "//span[@class='searchtoolbar-search-span']")
	public WebElement tenantManagementSearch;

	// 统计数据
	@FindBy(xpath = "//span[contains(text(),'统计数据')]")
	public WebElement statisticalData;

	/**
	 * 租户管理 end...
	 */

	/**
	 * 协同定义 start...
	 */

	// 协同定义
	@FindBy(xpath = "//li[contains(text(),'协同定义')]")
	public WebElement synergyDefined;

	// 查询
	@FindBy(xpath = "//span[contains(text(),'查询')]")
	public WebElement synergyDefinedSearch;

	// 添加按钮
	@FindBy(xpath = "//img[@class='searchtoolbar-batchAdd']")
	public WebElement addButton;

	// 定位一组td元素
	@FindBys(@FindBy(xpath = "//tbody[@class='showdatagrid-tbody']/tr[1]/td"))
	public List<WebElement> tdElements;

	// 保存按钮
	@FindBy(xpath = "//img[@class='searchtoolbar-hold']")
	public WebElement saveButton;

	/**
	 * 协同定义 end...
	 */
	// 帮助文档管理
	@FindBy(xpath = "//li[contains(text(),'帮助文档管理')]")
	public WebElement helpDocument;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}
