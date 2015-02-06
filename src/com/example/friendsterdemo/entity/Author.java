package com.example.friendsterdemo.entity;

public class Author {

	private String id;
	private String username;
	private String avatar;
	private String medal_id;
	private String medal_desc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getMedal_id() {
		return medal_id;
	}
	public void setMedal_id(String medal_id) {
		this.medal_id = medal_id;
	}
	public String getMedal_desc() {
		return medal_desc;
	}
	public void setMedal_desc(String medal_desc) {
		this.medal_desc = medal_desc;
	}
	public Author() {
		super();
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", username=" + username + ", avatar="
				+ avatar + ", medal_id=" + medal_id + ", medal_desc="
				+ medal_desc + "]";
	}
	
}
