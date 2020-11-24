package cn.ac.testcase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import cn.ac.businesspage.HomePagePro;
import cn.ac.businesspage.LoginPagePro;
import cn.ac.util.AssertRewrite;

/**
 * 组装测试用例
 * 
 * @author sybcheck
 *
 */
public class HomePageTest {
	LoginPagePro loginPagePro;
	HomePagePro homePagePro;
	public WebDriver driver;

	public HomePageTest(WebDriver driver) {
		this.driver = driver;
		homePagePro = new HomePagePro(driver);
		loginPagePro = new LoginPagePro(driver);
	}

	/**
	 * 断言登录页面title
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public void assertLoginPageTile() {
		String title = driver.getTitle();
		AssertRewrite.assertEquals(title, "经销商云平台管理系统");
	}

	/**
	 * 登录功能
	 */
	public void login() {
		loginPagePro.login();
	}

	/**
	 * 租户管理->查询
	 */
	public void clickTenantManagementSearch() {
		homePagePro.tenantManagementSearch();
	}

	/**
	 * 协同定义->添加一组数据
	 */
	public void addData() {
		homePagePro.addData();
	}

}
