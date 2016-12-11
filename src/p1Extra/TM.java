package p1Extra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author andrew joshua
 *
 */
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

	/**
	 * simulates the TM on string
	 * 
	 * @param input
	 *            string to simulate TM on
	 * @return the contents of the tape if input is "", otherwise return only
	 *         the visited cells of the tape
	 */
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
				// transition to the right
				if (tapeIndex < tape.size() - 1) {
					curr = tape.get(++tapeIndex);
					curr.setVisited();
				} else {
					// if we are at end of arraylist, add new cell to end
					curr = new Cell('0', true);
					tape.add(curr);
					tapeIndex++;
				}
			} else {
				// transition to the left
				if (tapeIndex > 0) {
					// get previous cell on the tape
					curr = tape.get(--tapeIndex);
					curr.setVisited();
				} else {
					// if we are at the beginning of the tape, add to the
					// beginning of the arraylist
					curr = new Cell('0', true);
					tape.add(0, curr);
				}
			}
		}
		// for returning the tape
		// if printOnlyVisited is true (when initial tape content is empty)
		// then only print the visited cells, otherwise, print entire tape
		String retVal = "";
		for (int i = 0; i < tape.size(); i++) {
			Cell temp = tape.get(i);
			sum += Character.getNumericValue(temp.read());
			if (printOnlyVisited) {
				if (temp.visited()) {
					retVal += temp.read();
				}
			} else
				retVal += temp.read();
		}
		System.out.println("Sum: " + sum);
		return retVal;
	}

	/**
	 * Initializes the tape
	 * 
	 * @param input
	 *            what to put on the tape
	 */
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

	/**
	 * Creates new starting state
	 * 
	 * @param state
	 *            name of new starting state
	 */
	public void addStartState(String state) {
		startState = new TMState(state);
		addState(state);
	}

	/**
	 * Creates new halting state
	 * 
	 * @param state
	 *            name of the halting state
	 */
	public void addHaltingState(String state) {
		haltingState = new TMState(state);
		addState(state);
	}

	/**
	 * Add an intermediate state
	 * 
	 * @param state
	 *            name of state
	 */
	public void addState(String state) {
		states.add(new TMState(state));
	}

	/**
	 * Creates a transition for a given state
	 * 
	 * @param fromState
	 *            name of on state
	 * @param onSymb
	 *            name of symbol on tape head
	 * @param toState
	 *            name of to state
	 * @param writeSymbol
	 *            symbol to write to the tape
	 * @param direction
	 *            which direction to move the tape head (either 'R' or 'L')
	 */
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

	/**
	 * Gets a state from the name of it
	 * @param state name of state
	 * @return TMState in the machine that has that name
	 */
	private TMState getState(String state) {
		for (TMState st : states) {
			if (st.getName().equals(state)) {
				return st;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return states.toString();
	}

}
