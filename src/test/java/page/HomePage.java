package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage
{
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id = "nav-hamburger-menu")
	public WebElement menuButton;
	
	@FindBy(xpath = "//div[contains(text(),'TV, Appliances, Electronics')]")
	public WebElement tvSection;
	
	@FindBy(xpath = "//*[contains (text(),'Televisions')]")
	public WebElement televisionsButton;
}
