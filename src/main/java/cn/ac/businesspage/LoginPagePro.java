package cn.ac.businesspage;

import org.openqa.selenium.WebDriver;

import cn.ac.handlepage.LoginPageHandle;

/**
 * 业务逻辑层
 *
 * @author sybcheck
 */
public class LoginPagePro {
    LoginPageHandle loginPageHandle;

    public LoginPagePro(WebDriver driver) {
        loginPageHandle = new LoginPageHandle(driver);
    }

    /**
     * 登录
     *
     * @return
     */
    public void login() {
        loginPageHandle.login();
        // loginBtn.click();
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click;", loginBtn);
        // 调用element元素本身的点击方法 js的点击暂时不好使 应该是好使的
    }

}
