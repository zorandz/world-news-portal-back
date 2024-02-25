package com.index.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.index.domain.NewsDataIO;
import com.index.domain.NewsDataIOArticle;
import com.index.utility.NewsApiItemReader;

public class NewsDataIOReader implements ItemReader<NewsDataIOArticle> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewsApiItemReader.class);

    private final RestTemplate restTemplate;

    private int nextArticleIndex = 0;
    private List<NewsDataIOArticle> newsArticles;

    public NewsDataIOReader() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public NewsDataIOArticle read() throws Exception {

    	if (articlesNotInitialized()) {
    		LOGGER.debug("U if (articlesNotInitialized()), dretva: " + Thread.currentThread().getName());
            fetchArticlesFromApi();
        }

        if (nextArticleIndex >= newsArticles.size()) {
            return null;
        } 

        NewsDataIOArticle nextArticle = newsArticles.get(nextArticleIndex);
        nextArticleIndex++; 
        return nextArticle; 
    }

    private boolean articlesNotInitialized() {
        return this.newsArticles == null;
    }

    private synchronized void fetchArticlesFromApi() {
    	System.out.println("Ušao u reader, dretva: " + Thread.currentThread().getName());
        String requestUrl = "https://newsdata.io/api/1/archive?apikey=pub_38826a37a3fe4994c53cfb48df8224484a50a&q=example&language=hr&from_date=2023-01-19";

        ResponseEntity<NewsDataIO> response = restTemplate.getForEntity(requestUrl, NewsDataIO.class);
        this.newsArticles = response.getBody().getResults();
        
        HttpHeaders headers = response.getHeaders();
        LOGGER.debug("X-API-Quota-Used: " + headers.getFirst("X-API-Quota-Used"));
    }

}
