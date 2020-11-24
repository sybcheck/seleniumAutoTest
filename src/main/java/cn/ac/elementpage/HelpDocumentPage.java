package cn.ac.elementpage;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HelpDocumentPage {

	// 查询
	@FindBy(xpath = "//span[@class='searchtoolbar-search-span']")
	public WebElement search;

	// 添加按钮
	@FindBy(xpath = "//img[@class='searchtoolbar-batchAdd']")
	public WebElement add;

	// 文档描述
	@FindBy(xpath = "//input[@class='helpdoc-helpdocdesc']")
	public WebElement description;

	// 文档目录
	@FindBy(xpath = "//input[@class='helpdoc-helpdocdir']")
	public WebElement catalog;

	// 选择文件
	@FindBy(xpath = "//input[@class='helpdoc-file']")
	public WebElement helpdocFile;

	// 保存按钮
	@FindBy(xpath = "//button[@class='helpdoc-submit']")
	public WebElement helpdocSubmit;

	// 获取一组修改标签
	@FindBys({ @FindBy(xpath = "//button[@class='helpdoc-change']") })
	public List<WebElement> editButtons;
	// 修改按鈕
	@FindBy(xpath = "//button[@class='helpdoc-updata']")
	public WebElement edit;

	// 下一页
	@FindBy(xpath = "//span[contains(text(),'下一页')]")
	public WebElement pageDown;

	// 条数显示
	@FindBy(xpath = "//select[@class='swPageSelect-select']")
	public WebElement selectPage;

	// 设置每页5条
	@FindBy(xpath = "//option[@value='5']")
	public WebElement five;

	// 跳页
	@FindBy(xpath = "//input[@class='swPageSelect-onePage']")
	public WebElement pageSkip;

	// 下载
	@FindBy(xpath = "//span[contains(text(),'下载')][1]")
	public WebElement download;

	// 删除按钮 定义第一个删除按钮
	@FindBys(@FindBy(xpath = "//tbody[@class='showdatagrid-tbody']/tr[1]/td[1]"))
	public WebElement delete;

	public HelpDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
