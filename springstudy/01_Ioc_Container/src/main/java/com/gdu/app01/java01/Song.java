package com.gdu.app01.java01;

public class Song {
	
	private String title;
	private String genre;
	
	public Song() {
		// TODO Auto-generated constructor stub
	}
	
	//constructor
	public Song(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}

	
	//getter, setter
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
	
	
	
	
	
}
