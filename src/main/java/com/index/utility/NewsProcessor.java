package com.index.utility;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import com.index.repository.ArticleRepo;

public class NewsProcessor implements ItemProcessor<NewsArticle, NewsArticle>{
	
	@Autowired
	ArticleRepo articleRepo;

	@Override
	public NewsArticle process(NewsArticle item) throws Exception {
		item.setId(null);
		
		if (articleRepo.findByTitle(item.getTitle()) != null) {
			System.out.println("Already exists: " + item.getTitle());
			return null;
		} else {
			System.out.println("New article: " + item.getTitle());
			return item;
		}
		
	}

}
