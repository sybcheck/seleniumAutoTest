package cn.ac.businesspage;

import org.openqa.selenium.WebDriver;

import cn.ac.handlepage.HelpDocumentPageHandle;

public class HelpDocumentPagePro {
	HelpDocumentPageHandle helpDocumentPageHandle;

	public HelpDocumentPagePro(WebDriver driver) {
		helpDocumentPageHandle = new HelpDocumentPageHandle(driver);
	}

	/**
	 * 查询，添加，设置每页显示5条，下一页，跳页，修改，下载
	 * 
	 * @throws InterruptedException
	 */
	public void allTest() throws InterruptedException {
		helpDocumentPageHandle.search();
		Thread.sleep(2000);
		helpDocumentPageHandle.add();
		Thread.sleep(2000);
		helpDocumentPageHandle.setPage();
		Thread.sleep(2000);
		helpDocumentPageHandle.pageDown();
		Thread.sleep(2000);
		helpDocumentPageHandle.pageSkip();
		Thread.sleep(2000);
		helpDocumentPageHandle.edit();
		Thread.sleep(2000);
		helpDocumentPageHandle.download();
		Thread.sleep(2000);
		helpDocumentPageHandle.delete();
		Thread.sleep(2000);
	}

}
