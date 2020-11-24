package cn.ac.testcase;

import org.openqa.selenium.WebDriver;

import cn.ac.businesspage.HelpDocumentPagePro;
import cn.ac.businesspage.HomePagePro;
import cn.ac.businesspage.LoginPagePro;

public class HelpDocumentPageTest {
	LoginPagePro loginPagePro;
	HomePagePro homePagePro;
	HelpDocumentPagePro helpDocumentPagePro;

	public HelpDocumentPageTest(WebDriver driver) {
		loginPagePro = new LoginPagePro(driver);
		homePagePro = new HomePagePro(driver);
		helpDocumentPagePro = new HelpDocumentPagePro(driver);
	}

	/**
	 * 帮助文档测试
	 * 
	 * @throws InterruptedException
	 */
	public void allTest() throws InterruptedException {
		loginPagePro.login();
		// 基础数据->基础数据维护->帮助文档管理
		homePagePro.clickHelpDocument();
		// 帮助文档管理all测试
		helpDocumentPagePro.allTest();
	}

}
