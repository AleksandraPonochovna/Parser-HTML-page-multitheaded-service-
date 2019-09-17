package spribe.parser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import spribe.factory.ArticleServiceFactory;
import spribe.model.Article;
import spribe.pages.ArticlePage;
import spribe.pages.MainPage;
import spribe.service.ArticleService;

public class Parser {

    private static final ArticleService service = ArticleServiceFactory.getInstance();
    private static final String URL_WEB_PAGE = "https://ain.ua/";
    private static final String KEY_DRIVER = "webdriver.chrome.driver";
    private static final String VALUE_DRIVER = "C:\\Users\\Lenovo\\IdeaProjects\\Task Spribe\\chromedriver.exe";

    public static Runnable parse(int i) {
        return () -> {
            WebDriver driver = new ChromeDriver();
            System.setProperty(KEY_DRIVER, VALUE_DRIVER);
            driver.get(URL_WEB_PAGE);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            new MainPage(driver).clickOnArticle(i);
            ArticlePage articlePage = new ArticlePage(driver);
            String title = articlePage.getTitle();
            String author = articlePage.getAuthor();
            String contentList = articlePage.getContent().toString();
            Article article = new Article(title, author, contentList);
            service.save(article);
            driver.quit();
        };
    }

}
