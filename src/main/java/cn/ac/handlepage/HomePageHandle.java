package cn.ac.handlepage;

import org.openqa.selenium.WebDriver;
import cn.ac.elementpage.HomePage;

public class HomePageHandle {
	HomePage homePage;

	// Initializing the Page Objects:
	public HomePageHandle(WebDriver driver) {
		homePage = new HomePage(driver);
	}

	/**
	 * 基础数据/基础数据维护
	 */
	public void basicDataMaintenance() {
		homePage.basicData.click();
		homePage.basicDataMaintenance.click();
	}

	/**
	 * 租户管理/查询
	 */
	public void tenantManagementSearch() {
		homePage.tenantManagement.click();
		homePage.tenantManagementSearch.click();
	}

	/**
	 * 协同定义/查询
	 */
	public void synergyDefinedSearch() {
		homePage.synergyDefined.click();
		homePage.synergyDefinedSearch.click();
	}

	/**
	 * 协同定义/添加
	 */
	public void synergyDefinedAdd() {
		homePage.synergyDefined.click();
		homePage.addButton.click();
	}

	/**
	 * 基础数据/基础数据维护/帮助文档管理
	 */
	public void clickhelpDocument() {
		homePage.basicData.click();
		homePage.basicDataMaintenance.click();
		homePage.helpDocument.click();
	}
}
