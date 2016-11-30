package p1Extra;

import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class TM {

	private Set<TMState> states;
	private Set<Integer> alphabet;
	private TMState startState, haltingState;
	private List<Integer> tape;

	/**
	 * Constructor
	 */
	public TM() {
		states = new HashSet<TMState>();
		alphabet = new HashSet<Integer>();
		tape = new LinkedList<Integer>();
	}

	public void addStartState(TMState state) {
		startState = state;
	}

	public void addHaltingState(TMState state) {
		haltingState = state;
	}

	public void addState(TMState state) {
		states.add(state);
	}

	public String toString() {
		return states.toString();
	}
}
