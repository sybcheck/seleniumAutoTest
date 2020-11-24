package cn.ac.handlepage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import cn.ac.base.propBase;
import cn.ac.elementpage.LoginPage;

/**
 * 登录page的操作封装
 * 
 * @author sybcheck
 *
 */
public class LoginPageHandle {
	LoginPage loginPage;
	public WebDriver driver;
	public Properties prop;

	public LoginPageHandle(WebDriver driver) {
		loginPage = new LoginPage(driver);
		this.driver = driver;
	}

	/**
	 * 登录操作
	 */
	public void login() {
		new propBase();
		this.prop = propBase.prop;
		loginPage.userName.sendKeys(prop.getProperty("username"));
		loginPage.passWord.sendKeys(prop.getProperty("password"));
		loginPage.loginBtn.click();
	}

}
