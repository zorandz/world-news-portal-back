package com.index.domain;

import java.util.List;

public class NewsDataIO {

    private String status;
    private int totalResults;
    private List<NewsDataIOArticle> results;
    private String nextPage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsDataIOArticle> getResults() {
        return results;
    }

    public void setResults(List<NewsDataIOArticle> results) {
        this.results = results;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

}