package stepdef;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginStepDef {
	LoginPage loginpage=new LoginPage();

    public LoginStepDef(){
    }

    @Given("User is on CRM Login Page")
	public void user_is_on_crm_login_page(){
	    loginpage.userOnLoginPage();
	}

	@Given("Validate header of the login page {string}")
	public void validate_header_of_the_login_page(String loginText) throws InterruptedException {
		loginpage.validateLoginPage(loginText);
	}

	@Then("user enters us {string} and pwd {string}")
	public void user_enters_us_and_pwd(String username, String password) {
		loginpage.enterUnandPwd(username,password);
	}

	@Then("click on Login")
	public void click_on_login() {
	   loginpage.clickOnLogin();
	}

	@Then("Validate home page")
	public void validateHomePage() throws InterruptedException {
		loginpage.validateHomePage();
	}

	@And("Logout from application and validate user is on login page {string}")
	public void logout(String loginText) throws InterruptedException {
		loginpage.logout(loginText);
	}
}
