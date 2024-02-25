package com.index.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.index.utility.NewsArticle;

@Repository
public interface ArticleRepo extends JpaRepository<NewsArticle, Long> {

	public NewsArticle findByTitle(String title);
	
	@Query(nativeQuery = true, value = "SELECT * FROM news_article\r\n"
			+ "ORDER BY id DESC LIMIT 20")
	public List<NewsArticle> getHomePageArticles();
}
