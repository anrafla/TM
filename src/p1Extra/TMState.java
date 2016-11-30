package p1Extra;

import java.util.HashSet;
import java.util.Set;

public class TMState {
	private String name;
	private Set<Transition> delta;

	public TMState(String name) {
		this.name = name;
		delta = new HashSet<Transition>();
	}

	public void addTransition(TMState fromState, TMState nextState, int writeSymbol, char direction) {
		delta.add(new Transition(fromState, nextState, writeSymbol, direction));
	}

	public String toString() {
		return name;
	}
}
