package pageObject;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import page.HomePage;
import page.ResultPage;
import page.TelevisionPage;
import setup.BaseTest;

public class SecondHighestRateTelevision extends BaseTest
{	
	
	@Test
	public void fetchDetails() throws Exception
	{
		HomePage homePage=PageFactory.initElements(driver, HomePage.class);
		TelevisionPage televisionPage=PageFactory.initElements(driver, TelevisionPage.class);
		ResultPage resultPage=PageFactory.initElements(driver, ResultPage.class);
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		homePage.menuButton.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.tvSection));
		homePage.tvSection.click();
		wait.until(ExpectedConditions.visibilityOf(homePage.televisionsButton));
		homePage.televisionsButton.click();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", televisionPage.brand);
		
		wait.until(ExpectedConditions.elementToBeClickable(televisionPage.samsungFilter));
		televisionPage.samsungFilter.click();		
		
		Select sortBy = new Select(resultPage.sortBy);
		sortBy.selectByValue("price-desc-rank");
		
		wait.until(ExpectedConditions.visibilityOf(resultPage.secondHighestItem));
		resultPage.secondHighestItem.click();
		
		String parent=driver.getWindowHandle();
		
	    Set<String> windows=driver.getWindowHandles();
	    for(String window:windows)
	    {
	    	if(!window.equals(parent))
	    		driver.switchTo().window(window);
	    }
		
	   assertEquals(resultPage.aboutThisItem.getText().trim(), "About this item");
	   
	   System.out.println(resultPage.description.getText());
	}
}
