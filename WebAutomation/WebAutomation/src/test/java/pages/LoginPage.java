package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import baseclass.BaseClass;
import baseclass.Log;

public class LoginPage {

	@FindBy(xpath = "//h5[contains(@class,'orangehrm-login-title')]")
	static WebElement logintext;
	@FindBy(name = "username")
	static WebElement userName;
	@FindBy(name = "password")
	static WebElement passWord;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	static WebElement submit;
	@FindBy(xpath = "//h6[text()='Dashboard']")
	static WebElement homePageText;
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	static WebElement userDroDown;
	@FindBy(xpath = "//a[text()='Logout']")
	static WebElement logout;

	public LoginPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	public void userOnLoginPage() {
		BaseClass.openPage();
	}

	public void validateLoginPage(String loginText) throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(loginText, logintext.getText());
		Log.info("User is on login page");
	}

	public void enterUnandPwd(String username, String password) {
		userName.sendKeys(username);
		Log.info("User Enters UserName");
		passWord.sendKeys(password);
		Log.info("User Enters Password");
	}

	public void clickOnLogin() {
		submit.submit();
		Log.info("User clicks on Login");
	}

	public void validateHomePage() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(homePageText.isDisplayed());
	}

	public void logout(String loginText) throws InterruptedException {
		userDroDown.click();
		logout.click();
		Thread.sleep(5000);
		Assert.assertEquals(loginText, logintext.getText());
		Log.info("User is on login page");
	}
}
