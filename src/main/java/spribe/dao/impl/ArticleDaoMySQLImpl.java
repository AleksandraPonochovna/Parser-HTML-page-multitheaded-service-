package spribe.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import spribe.util.DBConnector;
import spribe.model.Article;
import spribe.dao.ArticleDaoMySQL;

public class ArticleDaoMySQLImpl implements ArticleDaoMySQL {

    private static final String INSERT_ARTICLE_IN_DB = "INSERT INTO article " +
            "(title, author, content) values (?, ?, ?)";
    private static final String SELECT_LIST_ARTICLES_FROM_DB = "SELECT * FROM article";
    private static final Logger logger = Logger.getLogger(ArticleDaoMySQLImpl.class);

    public void save(Article article) {
        try {
            try (Connection connection = DBConnector.connect();
                 PreparedStatement prStatement = connection.prepareStatement(INSERT_ARTICLE_IN_DB)) {
                prStatement.setString(1, article.getTitle());
                prStatement.setString(2, article.getAuthor());
                prStatement.setString(3, article.getContent());
                prStatement.execute();
                logger.info(article + " was added in DB.");
            }
        } catch (Exception ex) {
            logger.error(article + "can't be added in DB.", ex);
        }
    }

    public List<Article> getArticleList() {
        List<Article> articleList = new ArrayList<>();
        try (Connection connection = DBConnector.connect();
             PreparedStatement prStatement = connection.prepareStatement(SELECT_LIST_ARTICLES_FROM_DB)) {
            ResultSet resultSet = prStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String description = resultSet.getString("content");
                Article article = new Article(id, title, author, description);
                articleList.add(article);
            }
        } catch (Exception ex) {
            logger.error("The article's list wasn't founded in DB.", ex);
        }
        return articleList;
    }

}