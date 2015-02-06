package com.example.friendsterdemo.entity;

public class Users {

	private String username;
	private String avatar;
	private String medal_id;
	private String medal_desc;
	
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
	public Users(String username, String avatar, String medal_id,
			String medal_desc) {
		super();
		this.username = username;
		this.avatar = avatar;
		this.medal_id = medal_id;
		this.medal_desc = medal_desc;
	}
	public Users() {
		super();
	}
}
