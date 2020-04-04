package testNG;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.setmore.pages.BasePage;
import com.setmore.pages.HomePage;
import com.setmore.pages.LoginPage;

//Exploring POM with HomePage,LoginPage,CalendarPage---->LoginClick->SignIn with valid credentials,check the ClaendarPage Title
//Verify the HomePageTitle and LoginButtonClick
public class HomePageTests{

	HomePage hp;
	//BasePage bp;
	//LoginPage lp;
	public HomePageTests() {

		hp=new HomePage();	

	}
	@BeforeMethod
	public void verifyTheHomePageTitleTest() {
		String title=hp.validateHomePageTitle();
		Assert.assertEquals(title, "Free Online Appointment Scheduling Calendar Software | Setmore");
	}

	@Test
	public void VerifyloginBtnClickTest() {
		hp.loginButton();

	}
}
