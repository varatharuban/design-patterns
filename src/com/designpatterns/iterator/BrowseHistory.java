package com.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {
	
	private List<String> urlLists = new ArrayList<String>();
	private String[] urls = new String[10];
	private int count;

	public void push(String url) {
		urls[count++] = url;
	}

	public String pop() {
		return urls[--count];
	}

	public Iterator createIterator() {
		return new ArrayIterator(this);
	}

	public class ArrayIterator implements Iterator {
		private BrowseHistory history;
		private int index;

		public ArrayIterator(BrowseHistory history) {
			this.history = history;
		}

		@Override
		public boolean hasNext() {
			return (index < history.count);
		}

		@Override
		public String current() {
			return history.urls[index];
		}

		@Override
		public void next() {
			index++;
		}
	}

	public class ListIterator implements Iterator {
		private BrowseHistory history;
		private int index;

		public ListIterator(BrowseHistory history) {
			this.history = history;
		}

		@Override
		public boolean hasNext() {
			return (index < history.urlLists.size());
		}

		@Override
		public String current() {
			return history.urlLists.get(index);
		}

		@Override
		public void next() {
			index++;
		}
	}
}
