package spribe.factory;

import spribe.dao.ArticleDaoMySQL;
import spribe.dao.impl.ArticleDaoMySQLImpl;

public class ArticleDaoFactory {

    private static ArticleDaoMySQL instance;

    public static synchronized ArticleDaoMySQL getInstance() {
        if (instance == null) {
            instance = new ArticleDaoMySQLImpl();
        }
        return instance;
    }

}
