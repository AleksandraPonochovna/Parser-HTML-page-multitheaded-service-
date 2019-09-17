package spribe.factory;

import spribe.service.ArticleService;
import spribe.service.impl.ArticleServiceImpl;

public class ArticleServiceFactory {

    private static ArticleService instance;

    public static synchronized ArticleService getInstance() {
        if (instance == null) {
            instance = new ArticleServiceImpl();
        }
        return instance;
    }

}
