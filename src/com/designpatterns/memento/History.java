package com.designpatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class History {

	private List<EditorState> states = new ArrayList<EditorState>();
	
	public void push(EditorState state) {
		states.add(state);
	}
	
	public EditorState pop() {
		var lastState = states.get(states.size() - 1);
		states.remove(lastState);
		
		return lastState;
	}
}