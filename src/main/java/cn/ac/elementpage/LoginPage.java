package cn.ac.elementpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "login_user")
	public WebElement userName;

	@FindBy(name = "login_pas")
	public WebElement passWord;

	@FindBy(xpath = "//div[@class='login-sub']")
	public WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // add this
	}

}
