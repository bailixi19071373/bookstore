package com.mtw.author;

public class Author {
	private String authorid;
	
	private String name;

	public Author(String authorid, String name) {
		super();
		this.authorid = authorid;
		this.name = name;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", name=" + name + "]";
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
