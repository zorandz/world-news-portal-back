package com.index.utility;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NewsApiItemReader implements ItemReader<NewsArticle> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NewsApiItemReader.class);

    private final RestTemplate restTemplate;

    private int nextArticleIndex = 0;
    private List<NewsArticle> newsArticles;

    public NewsApiItemReader() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public NewsArticle read() throws Exception {

    	if (articlesNotInitialized()) {
    		LOGGER.debug("U if (articlesNotInitialized()), dretva: " + Thread.currentThread().getName());
            fetchArticlesFromApi();
        }

        if (nextArticleIndex >= newsArticles.size()) {
            return null;
        } 

        NewsArticle nextArticle = newsArticles.get(nextArticleIndex);
        System.out.println("Članak pročitan: " + newsArticles.get(nextArticleIndex).getTitle());
        nextArticleIndex++; 
        return nextArticle; 
    }

    private boolean articlesNotInitialized() {
        return this.newsArticles == null;
    }

    private synchronized void fetchArticlesFromApi() {
    	System.out.println("Ušao u reader, dretva: " + Thread.currentThread().getName());
        String requestUrl = "https://api.worldnewsapi.com/search-news?min-sentiment=-1.1&max-sentiment=1.1&earliest-publish-date=2022-04-22 16:12:35&number=15&sort=publish-time&sort-direction=desc&source-countries=gb,us,hr&api-key=9fb1c8bd2ec94cc186b225eb1e3692c9";

        ResponseEntity<NewsResponse> response = restTemplate.getForEntity(requestUrl, NewsResponse.class);
        this.newsArticles = response.getBody().getNews();
        
        HttpHeaders headers = response.getHeaders();
        LOGGER.debug("X-API-Quota-Used: " + headers.getFirst("X-API-Quota-Used"));
    }

}