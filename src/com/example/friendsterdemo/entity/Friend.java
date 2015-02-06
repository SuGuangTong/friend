package com.example.friendsterdemo.entity;

import java.util.List;

public class Friend {

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	private String title;
	private String total;//访问总人数
	private String content;//内容
	private String created_at;//发生的时间
	private String total_replies;//回复人数
	private String visits;//最近访问
	private Author author;
	private Attachments attachments;
	private List<Users> list;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTotal_replies() {
		return total_replies;
	}
	public void setTotal_replies(String total_replies) {
		this.total_replies = total_replies;
	}
	public String getVisits() {
		return visits;
	}
	public void setVisits(String visits) {
		this.visits = visits;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Attachments getAttachments() {
		return attachments;
	}
	public void setAttachments(Attachments attachments) {
		this.attachments = attachments;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Friend(String title,String total, String content, String created_at,
			String total_replies, String visits, Author author,
			Attachments attachments,List<Users> list) {
		super();
		this.title = title;
		this.total = total;
		this.content = content;
		this.created_at = created_at;
		this.total_replies = total_replies;
		this.visits = visits;
		this.author = author;
		this.attachments = attachments;
		this.list = list;
	}
	@Override
	public String toString() {
		return "Friend [title=" + title + ", total=" + total + ", content="
				+ content + ", created_at=" + created_at + ", total_replies="
				+ total_replies + ", visits=" + visits + ", author=" + author
				+ ", attachments=" + attachments + ", list=" + list + "]";
	}
	public Friend() {
		super();
	}
	public List<Users> getList() {
		return list;
	}
	public void setList(List<Users> list) {
		this.list = list;
	}
	
}
