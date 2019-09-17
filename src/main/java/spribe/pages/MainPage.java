package spribe.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	private final WebDriver driver;

	@FindBy(css = ".content-wrapper.content-wrapper-paged .post-item")
	private List<WebElement> listOfArticle;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public MainPage clickOnArticle(int i) {
		listOfArticle.get(i).click();
		return this;
	}
}
