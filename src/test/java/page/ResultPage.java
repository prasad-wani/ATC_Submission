package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultPage
{
	WebDriver driver;
	public ResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id = "s-result-sort-select")
	public WebElement sortBy;
	
	@FindBy(xpath = "//span[@data-component-type=\"s-search-results\"]/div/div[3]")
	public WebElement secondHighestItem;
	
	@FindBy(xpath = "//div[@id=\"featurebullets_feature_div\"]//h1")
	public WebElement aboutThisItem;
	
	@FindBy(xpath = "//div[@id=\"featurebullets_feature_div\"]//ul")
	public WebElement description;
	
	
}
