package spribe.dao;

import spribe.model.Article;

import java.util.List;

public interface ArticleDaoMySQL {

    void save(Article article);

    List<Article> getArticleList();

}
