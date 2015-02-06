package com.example.friendsterdemo.entity;

public class Attachments {
	
	private String url;
	private String thumb;
	private String width;
	private String height;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Attachments() {
		super();
	}
	@Override
	public String toString() {
		return "Attachments [url=" + url + ", thumb=" + thumb + ", width="
				+ width + ", height=" + height + "]";
	}
}
