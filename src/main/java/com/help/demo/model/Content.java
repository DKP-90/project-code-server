package com.help.demo.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="content")
public class Content {
	
	@Id
	private String id;
	private String title;
	private String content;
	private String http_response;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getHttp_response() {
		return http_response;
	}
	public void setHttp_response(String http_response) {
		this.http_response = http_response;
	}
	
	
}
