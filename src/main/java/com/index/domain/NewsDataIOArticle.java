package com.index.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class NewsDataIOArticle {
	
	@Id
	@SequenceGenerator(name = "news_data_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_data_seq")
	private String article_id;
	private String title;
	private String link;
	private List<String> keywords;
	private List<String> creator;
	private String video_url;
	private String description;
	@Column(columnDefinition = "TEXT")
	private String content;
	private String pubDate;
	private String image_url;
	private String source_id;
	private String source_url;
	private String source_icon;
	private int source_priority;
	private List<String> country;
	private List<String> category;
	private String language;
	private List<String> ai_tag;
	private List<String> ai_region;
	private String sentiment;
	private NewsDataIOSentimentStats sentiment_stats;

	public String getArticle_id() {
		return article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getCreator() {
		return creator;
	}

	public void setCreator(List<String> creator) {
		this.creator = creator;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getSource_id() {
		return source_id;
	}

	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}

	public String getSource_url() {
		return source_url;
	}

	public void setSource_url(String source_url) {
		this.source_url = source_url;
	}

	public String getSource_icon() {
		return source_icon;
	}

	public void setSource_icon(String source_icon) {
		this.source_icon = source_icon;
	}

	public int getSource_priority() {
		return source_priority;
	}

	public void setSource_priority(int source_priority) {
		this.source_priority = source_priority;
	}

}