package testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.setmore.pages.CalendarPage;
import com.setmore.pages.HomePage;
import com.setmore.pages.LoginPage;

//Exploring POM with HomePage,LoginPage,CalendarPage---->LoginClick->SignIn with valid credentials,check the ClaendarPage Title
public class CalendarPageTest {

	CalendarPage cp;
	HomePage hp;
	LoginPage lp;


	public  CalendarPageTest() {
		cp=new CalendarPage();
		hp=new HomePage();
		lp=new LoginPage();	

	}

	@BeforeMethod
	public void goToCalendar() {
		hp.loginButton();
		lp.signIn("uma.kalyan@anywhere.co", "Search123!");

	}
	@Test
	public void verifyPageTitle() {
		String calendarPageTitle=cp.pageTitle();
		Assert.assertEquals(calendarPageTitle, "Setmore Calendar");	


	}

}
