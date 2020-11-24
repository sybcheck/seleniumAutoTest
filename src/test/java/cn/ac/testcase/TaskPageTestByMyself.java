package cn.ac.testcase;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import cn.ac.base.DriverBase;

public class TaskPageTestByMyself extends DriverBase {

	HomePageTest homePageTest;

	public TaskPageTestByMyself() {
		homePageTest = new HomePageTest(driver);
	}

	//
	@Test(groups = "synergy", priority = 0)
	public void assertLoginPageTile() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		LOGGER.info("执行断言title");
		homePageTest.assertLoginPageTile();
	}
	
	//
	@Test(groups = "synergy", priority = 1)
	public void login() {
		LOGGER.info("执行登录");
		homePageTest.login();
	}

	// 租户管理 查询
	// @Test(priority = 3)
	// public void clickTenantManagementSearch() {
	// homePageTest.clickTenantManagementSearch();
	// }

	// 租户管理中 统计数据
	// @Test(priority = 4)
	// public void clickStatisticalData() {
	// homePageTest.clickStatisticalData();
	// }

	// 协同定义 添加数据
	@Test(groups = "synergy", priority = 5)
	public void addData() throws IOException, InterruptedException {
		// Reporter.getCurrentTestResult().setStatus(ITestResult.SUCCESS);
		// int i=1/0;
		LOGGER.info("执行添加数据");
		Reporter.log("开始添加数据..");
		homePageTest.addData();
		//
	}

}
