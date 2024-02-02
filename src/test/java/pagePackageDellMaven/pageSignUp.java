package pagePackageDellMaven;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageSignUp {
	WebDriver dr;
	@FindBy(xpath="//*[@id=\"unified-masthead\"]/div[1]/div[2]/div[1]/div/a")
	WebElement signInLink;
	@FindBy(xpath="//*[@class = 'mh-btn mh-btn-primary navigate']")
	WebElement signInButton;
	@FindBy(xpath="//*[@name='SignInModel.EmailAddress']")
	WebElement emailAddress;
	@FindBy(xpath="//*[@name='userPwd_UserInputSecret']")
	WebElement passWord;
	@FindBy(xpath="//*[@id='btnSignIn']")
	WebElement signButton;
	
	public pageSignUp(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	public void signUplinkHover() {
		Actions act = new Actions(dr);
		act.moveToElement(signInLink).perform();
	}
	public void signInButtonClick() {
		clickOnWebElements(dr, signInButton, Duration.ofSeconds(20));
	}
	public void setValuesforSignInPage(String email,String password) {
		emailAddress.clear();
		passWord.clear();
		sendkeysOnWebElements(dr, emailAddress,Duration.ofSeconds(20),email);
		sendkeysOnWebElements(dr, passWord, Duration.ofSeconds(20), password);
	}
	public void signInClick() {
		clickOnWebElements(dr, signButton, Duration.ofSeconds(20));
	}
	public static void sendkeysOnWebElements(WebDriver dr,WebElement e,Duration timeout,String value) {
		new WebDriverWait(dr,timeout).until(ExpectedConditions.visibilityOf(e));
		e.sendKeys(value);
	}
	
	public static void clickOnWebElements(WebDriver dr,WebElement e,Duration timeout) {
		new WebDriverWait(dr,timeout).until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}
	
}
