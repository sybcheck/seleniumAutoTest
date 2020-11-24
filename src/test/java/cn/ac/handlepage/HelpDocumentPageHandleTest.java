package cn.ac.handlepage;

import org.testng.annotations.Test;

import cn.ac.base.DriverBase;

public class HelpDocumentPageHandleTest extends DriverBase {
	HelpDocumentPageHandle helpDocumentPageHandle;
	LoginPageHandle loginPageHandle;
	HomePageHandle homePageHandle;

	public HelpDocumentPageHandleTest() {
		helpDocumentPageHandle = new HelpDocumentPageHandle(driver);
		loginPageHandle = new LoginPageHandle(driver);
		homePageHandle = new HomePageHandle(driver);
	}

	@Test
	public void login() {
		driver.get(prop.getProperty("url"));
		loginPageHandle.login();
	}

	@Test(priority = 1)
	public void clickhelpDocument() {
		homePageHandle.clickhelpDocument();
	}

	@Test(priority = 2)
	public void search() {
		helpDocumentPageHandle.search();
	}

	@Test(priority = 3, invocationCount = 1)
	public void add() {
		helpDocumentPageHandle.add();
	}

	@Test(priority = 4)
	public void setPage() {
		helpDocumentPageHandle.setPage();
	}

	@Test(priority = 5)
	public void pageDown() {
		helpDocumentPageHandle.pageDown();
	}

	@Test(priority = 6)
	public void pageSkip() {
		helpDocumentPageHandle.pageSkip();
	}

	@Test(priority = 7)
	public void edit() {
		helpDocumentPageHandle.edit();
	}

	@Test(priority = 8)
	public void download() {
		helpDocumentPageHandle.download();
	}

	@Test(priority = 9)
	public void delete() {
		helpDocumentPageHandle.delete();
	}

}
