package com.monkeyliu.tvshow.data.bean;

/**
 * @author monkey
 * @date 2016/6/3 0003.
 */
public class Drama {
	private String name;
	private String url;

	public Drama(String name, String url){
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
