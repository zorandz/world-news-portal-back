
package com.index.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@SequenceGenerator(name = "article_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_seq")
	@Column(name = "article_id")
	public Long articleId;
	
	@Column(name = "title")
	private String title;
	
	@Column(columnDefinition="TEXT", name = "content")
	private String content;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "video_url")
	private String videoUrl;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "hyperlink")
	private String hyperlink;
	/*
	@JsonBackReference
	@ManyToOne 
	@JoinColumn(name = "ai_subcategory_id")
	private ArticleSubcategory subcategory;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "ai_category_id")
	private ArticleCategory category;
	*/
	@Column(name="date_created")
	@CreationTimestamp  //special anotation from Hybernate
	private Date dateCreated;
	
	@Column(name="last_updated")
	@UpdateTimestamp //another special from hybernate
	private Date lastUpdated;
	
	public Article(String title, String content, String imageUrl, String videoUrl) {
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
	}
	
	public Article() {
		
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getVideoUrl() {
		return videoUrl;
	}


	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	


	public Long getArticleId() {
		return articleId;
	}


	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*

	public ArticleSubcategory getSubcategory() {
		return subcategory;
	}


	public void setSubcategory(ArticleSubcategory subcategory) {
		this.subcategory = subcategory;
	}


	public ArticleCategory getCategory() {
		return category;
	}


	public void setCategory(ArticleCategory category) {
		this.category = category;
	}

*/
	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Date getLastUpdated() {
		return lastUpdated;
	}


	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	


	public String getHyperlink() {
		return hyperlink;
	}

	public void setHyperlink(String hyperlink) {
		this.hyperlink = hyperlink;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", content=" + content + ", imageUrl="
				+ imageUrl + ", videoUrl=" + videoUrl + ", userName=" + userName
				+ ", dateCreated=" + dateCreated + ", lastUpdated="
				+ lastUpdated + "]";
	}



	


}
