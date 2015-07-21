package com.yff.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.yff.dao.ArticleDao;
import com.yff.entity.Article;

@Repository("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Resource(name="articleDao")
	private ArticleDao articleDao;
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article getArticle(String id) {
		
		return articleDao.getArticle(id);
	}

	@Override
	public List<Article> getAllArticle(String userName) {
		
		return articleDao.getAllArticle(userName);
	}

	@Override
	public void addArticle(Article article) {
		
		articleDao.addArticle(article);
	}

	@Override
	public boolean delArticle(String id) {
		
		return articleDao.delArticle(id);
	}

	@Override
	public boolean updateArticle(Article article) {
		
		return articleDao.updateArticle(article);
	}

}
