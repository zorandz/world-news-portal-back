package com.index.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.index.utility.NewsArticle;


public interface ArticlesService {

	List<NewsArticle> getArticles();
}
