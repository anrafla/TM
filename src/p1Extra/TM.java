package p1Extra;

import java.util.List;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class TM {

	private Set<TMState> states;
	private Set<Integer> alphabet;
	public Set<Transition> delta;
	private TMState startState, haltingState;
	private LinkedList<Cell> tape;
	private Cell curr;

	/**
	 * Constructor
	 */
	public TM() {
		states = new HashSet<TMState>();
		alphabet = new HashSet<Integer>();
		delta = new LinkedHashSet<Transition>();
		tape = new LinkedList<Cell>();
		curr = null;
	}

	public String simulate(String input) {
		initTape(input);
		Cell curr = tape.getFirst();
		TMState currState = startState;
		while(!currState.equals(haltingState)){

		}
		return "";
	}
	private TMState onSymb(TMState currState, char c){
		return null;
	}
	private void initTape(String input){
		for(char c : input.toCharArray()){
			Cell cell = new Cell(c);
			tape.addLast(cell);
		}
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

	public void addTransition(Transition trans) {
		delta.add(trans);
	}

	public String toString() {
		return states.toString();
	}

}
