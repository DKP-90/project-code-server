package com.help.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="media")
public class Media {
	
	@Id
	@GeneratedValue
	private int mid;	
	
	private String id;
	private String murl;
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getId_m() {
		return id;
	}
	public void setId_m(String id_m) {
		this.id = id_m;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
		

}
