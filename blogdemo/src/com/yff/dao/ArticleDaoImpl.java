package com.yff.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.yff.entity.Article;
import com.yff.entity.User;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Article getArticle(String id) {
		
		String hql = "from Article art where art.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		
		return (Article)query.uniqueResult();
	}

	@Override
	public List<Article> getAllArticle(String userName) {
		
		String hql = "from Article where userName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		return query.list();
	}

	@Override
	public void addArticle(Article article) {
		
		sessionFactory.getCurrentSession().save(article);
	}

	@Override
	public boolean delArticle(String id) {
		
		String hql = "delete Article art where art.id = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);//ɾ��ǰid���Ӧ������
		
		return (query.executeUpdate() > 0);

	}

	@Override
	public boolean updateArticle(Article article) {
		
		String hql = "update Article art set art.title = ?,art.content=? where art.articleId = ?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, article.getTitle());
		query.setString(1, article.getContent());
		query.setString(2, article.getArticleId());
		
		return (query.executeUpdate() > 0);
	}

}
