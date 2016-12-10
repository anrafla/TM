package p1Extra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TM {

	private Set<TMState> states;
	private Set<Character> alphabet;
	private TMState startState, haltingState;
	private ArrayList<Cell> tape;

	/**
	 * Constructor
	 */
	public TM() {
		states = new HashSet<TMState>();
		alphabet = new HashSet<Character>();
		tape = new ArrayList<Cell>();
	}

	public String simulate(String input) {
		initTape(input);
		int tapeIndex = 0;
		int sum = 0;
		Cell curr = tape.get(0);
		curr.setVisited();
		TMState currState = startState;
		boolean printOnlyVisited = (input.equals(""));
		// while the TM is running, i.e, when it is not in a halting state
		while (!currState.getName().equals(haltingState.getName())) {
			Transition trans = currState.getTransitionOn(curr.read());
			// update which state it is in
			currState = trans.getNextState();
			// update the tape, and mark cell as visited, then update the list
			curr.write(trans.getWriteSymbol());
			if (trans.getDirection() == 'R' || trans.getDirection() == 'r') {
				// making sure we dont go out of index exception: tape is
				// bi-infinite
				if (tapeIndex < tape.size() - 1) {
					curr = tape.get(++tapeIndex);
					curr.setVisited();
				} else {
					curr = new Cell('0', true);
					tape.add(tape.size(), curr);
					tapeIndex++;
				}
			} else {
				if (tapeIndex > 0) {
					curr = tape.get(--tapeIndex);
					curr.setVisited();
				} else {
					curr = new Cell('0', true);
					tape.add(0, curr);
				}

			}
		}
		String retVal = "";
		for (int i = 0; i < tape.size(); i++) {
			Cell temp = tape.get(i);
			sum += Character.getNumericValue(temp.read());
			if (printOnlyVisited) {
				if (temp.visited()) {
					retVal += temp.read();
				}
			} else
				retVal+= temp.read();
		}
		System.out.println("Sum: " + sum);
		return retVal;
	}

	private void initTape(String input) {
		if (input.equals("")) {
			Cell cell = new Cell('0');
			tape.add(cell);
		}
		for (char c : input.toCharArray()) {
			Cell cell = new Cell(c);
			tape.add(tape.size(), cell);
		}
	}

	public void addStartState(String state) {
		startState = new TMState(state);
		addState(state);
	}

	public void addHaltingState(String state) {
		haltingState = new TMState(state);
		addState(state);
	}

	public void addState(String state) {
		states.add(new TMState(state));
	}

	public void addTransition(String fromState, char onSymb, String toState, char writeSymbol, char direction) {
		alphabet.add(onSymb);
		alphabet.add(writeSymbol);
		TMState stateToAdd = getState(fromState);
		TMState nextState = getState(toState);
		stateToAdd.addTransition(onSymb, nextState, writeSymbol, direction);
		if (stateToAdd.getName().equals(startState.getName())) {
			startState = stateToAdd;
		}
		if (stateToAdd.getName().equals(haltingState.getName())) {
			haltingState = stateToAdd;
		}
	}

	private TMState getState(String state) {
		for (TMState st : states) {
			if (st.getName().equals(state)) {
				return st;
			}
		}
		return null;
	}

	public String toString() {
		return states.toString();
	}

}
