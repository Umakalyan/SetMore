package testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.setmore.pages.BasePage;
import com.setmore.pages.HomePage;
import com.setmore.pages.LoginPage;

//Exploring POM with HomePage,LoginPage,CalendarPage---->LoginClick->SignIn with valid credentials,check the ClaendarPage Title
//Verify LoginwithValid Credential

public class LoginPageTests {
	HomePage hp;
	LoginPage lp;
	//BasePage bp;

	public LoginPageTests() {
		hp=new HomePage();
		lp=new LoginPage();
		//bp=new BasePage();
	}

	@BeforeMethod
	public void loginClick() {
		hp.loginButton();

	}
	@Test
	public void signInTest() {
		lp.signIn("uma.kalyan@anywhere.co", "Search123!");

	}
}