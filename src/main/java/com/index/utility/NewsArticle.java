package com.index.utility;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class NewsArticle {
	
	@Id
	@SequenceGenerator(name = "article_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
	private Long id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String text;
    private String url;
    private String image;
    private String publish_date;
    private List<String> authors;
    private String language;
    private String source_country;
    private double sentiment;
    
    
    
	public NewsArticle(Long id, String title, String text, String url, String image, String publish_date,
			List<String> authors, String language, String source_country, double sentiment) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
		this.url = url;
		this.image = image;
		this.publish_date = publish_date;
		this.authors = authors;
		this.language = language;
		this.source_country = source_country;
		this.sentiment = sentiment;
	}
	
	public NewsArticle() {};
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getSource_country() {
		return source_country;
	}
	public void setSource_country(String source_country) {
		this.source_country = source_country;
	}
	public double getSentiment() {
		return sentiment;
	}
	public void setSentiment(double sentiment) {
		this.sentiment = sentiment;
	}
    
    
}
