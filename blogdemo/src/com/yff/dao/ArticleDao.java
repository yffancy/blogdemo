package com.yff.dao;

import java.util.List;

import com.yff.entity.Article;

public interface ArticleDao {
	
	public Article getArticle(String id); 
	
	public List<Article> getAllArticle(String userName);
	
    public void addArticle(Article article);	

    public boolean delArticle(String id);
	
	public boolean updateArticle(Article article);

}
