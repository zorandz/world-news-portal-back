package com.index.utility;

import java.util.List;

public class NewsResponse {
	   private int offset;
	    private int number;
	    private int available;
	    private List<NewsArticle> news;
	    
	    
	    
		public NewsResponse(int offset, int number, int available, List<NewsArticle> news) {
			super();
			this.offset = offset;
			this.number = number;
			this.available = available;
			this.news = news;
		}
		
		public NewsResponse() {};
		
		public int getOffset() {
			return offset;
		}
		public void setOffset(int offset) {
			this.offset = offset;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public int getAvailable() {
			return available;
		}
		public void setAvailable(int available) {
			this.available = available;
		}
		public List<NewsArticle> getNews() {
			return news;
		}
		public void setNews(List<NewsArticle> news) {
			this.news = news;
		}
	    
	    
}
