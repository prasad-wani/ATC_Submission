package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TelevisionPage
{
	WebDriver driver;
	
	public TelevisionPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath = "//*[text()='Brands']")
	public WebElement brand;
	
	@FindBy(xpath="//*[text()='Brands']/following::span[text()='Samsung']")
	public WebElement samsungFilter;

}
