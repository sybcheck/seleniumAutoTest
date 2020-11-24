package cn.ac.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import cn.ac.base.DriverBase;

public class HelpDocumentPageTestTest extends DriverBase {
	HelpDocumentPageTest helpDocumentPageTest;

	public HelpDocumentPageTestTest() {
		helpDocumentPageTest = new HelpDocumentPageTest(driver);
	}

	@Test(groups = "doc",priority=12)
	public void allTest() {
		try {
			driver.get(prop.getProperty("url"));
			helpDocumentPageTest.allTest();
			Assert.assertTrue(true);
		} catch (InterruptedException e) {
			Assert.assertTrue(false);
			e.printStackTrace();
		}
	}
}
