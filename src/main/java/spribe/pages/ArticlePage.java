package spribe.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticlePage {

    private final WebDriver driver;

    @FindBy(css = "#post-content > p")
    private List<WebElement> article;

    @FindBy(css = "#post-content h1")
    private WebElement title;

    @FindBy(css = "#post-content .author_name")
    private WebElement author;

    @FindBy(css = "#post-content > :not(div):not(h1)")
    private List<WebElement> contentList;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getAuthor() {
        return author.getText();
    }

    public StringBuffer getContent() {
        StringBuffer text = new StringBuffer();
        for (WebElement element : contentList) {
            text.append(element.getText());
            if (element.getTagName().equals("h3"))
                text.append("\n");
            else if (element.getText().isEmpty())
                text.append(" ");
            else if (!element.getText().endsWith(" "))
                text.append(" ");
        }
        return text;
    }

}
