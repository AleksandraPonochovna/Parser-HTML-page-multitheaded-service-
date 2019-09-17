package spribe.service;

import spribe.model.Article;

import java.util.List;

public interface ArticleService {

    void save(Article article);

    List<Article> getArticleList();

}
