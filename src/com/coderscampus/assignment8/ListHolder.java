package com.coderscampus.assignment8;

import java.util.ArrayList;
import java.util.List;

public class ListHolder {
	private List<Integer> holderList = new ArrayList<Integer>();
	
	public ListHolder(List holderList) {
		this.holderList = holderList;
	}

	public List<Integer> getHolderList() {
		return holderList;
	}

	public void setHolderList(List<Integer> holderList) {
		this.holderList = holderList;
	}
	
}
