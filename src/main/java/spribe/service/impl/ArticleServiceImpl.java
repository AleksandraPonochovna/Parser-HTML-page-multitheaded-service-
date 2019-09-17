package spribe.service.impl;

import java.util.List;

import spribe.factory.ArticleDaoFactory;
import spribe.model.Article;
import spribe.dao.ArticleDaoMySQL;
import spribe.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	
	private ArticleDaoMySQL dao = ArticleDaoFactory.getInstance();

	public synchronized void save(Article article) {
		dao.save(article);
	}
	
	public synchronized List<Article> getArticleList() {
		return dao.getArticleList();
	}

}
