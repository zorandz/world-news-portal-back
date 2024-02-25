package com.index.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.index.repository.ArticleRepo;
import com.index.utility.NewsArticle;

@Service
public class ArticlesServiceImpl implements ArticlesService {
	
	@Autowired
	private ArticleRepo articleRepo;

	@Override
	public List<NewsArticle> getArticles() {
		
		return articleRepo.getHomePageArticles();
	}

}
