package com.endava.hackathon.dto;

import java.util.List;

public class SearchResult<T> {

	private List<T> items;
	private Long totalItems;

	public SearchResult(List<T> items, Long totalItems) {
		this.items = items;
		this.totalItems = totalItems;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}
}
