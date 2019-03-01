package com.help.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name="url")
public class Url {
@Id

	private String id;
	private String url;
	@CreationTimestamp
	private LocalDateTime timestamp;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	private Content Content_type;	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName="id")
	private List<Link> link_type;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName="id")
	private List<Media> media_type;
	
	
	public List<Media> getMedia_type() {
		return media_type;
	}
	public void setMedia_type(List<Media> media_type) {
		this.media_type = media_type;
	}
	public List<Link> getLink_type() {
		return link_type;
	}
	public void setLink_type(List<Link> link_type) {
		this.link_type = link_type;
	}
	public Content getContent_type() {
		return Content_type;
	}
	public void setContent_type(Content content_type) {
		Content_type = content_type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
