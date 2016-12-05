package p1Extra;

import java.util.List;
import java.util.ListIterator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class TM {

	private Set<TMState> states;
	private Set<Character> alphabet;
	private TMState startState, haltingState;
	private LinkedList<Cell> tape;

	/**
	 * Constructor
	 */
	public TM() {
		states = new HashSet<TMState>();
		alphabet = new HashSet<Character>();
		tape = new LinkedList<Cell>();
	}

	public String simulate(String input) {
		initTape(input);
		ListIterator<Cell> iter = tape.listIterator();
		Cell curr = tape.getFirst();
		curr.setVisited();
		TMState currState = startState;
		//while the TM is running, i.e, when it is not in a halting state
		while(!currState.getName().equals(haltingState.getName())){
			Transition temp = currState.getTransitionOn(curr.read());
			//update which state it is in
			currState = temp.getNextState();
			//update the tape, and mark cell as visited, then update the list
			curr.write(temp.getWriteSymbol());
//			iter.set(curr);
			//moving the tape pointer
//			System.out.println(temp.getDirection());
			curr.setVisited();
			if(temp.getDirection() == 'R'){
				//making sure we dont go out of index exception: tape is bi-infinite
				if(iter.hasNext()){
					curr = iter.next();
				}else{
					curr = new Cell('0' ,true);
					tape.addLast(curr);
					iter = tape.listIterator(tape.indexOf(curr));
				}
			}else{
				if(iter.hasPrevious()){
					curr = iter.previous();
				}else{
					curr = new Cell('0', true);
					curr.setVisited();
					tape.addFirst(curr);
					iter = tape.listIterator(tape.indexOf(curr));
				}
				
			}
		}
		ListIterator<Cell> iterator = tape.listIterator();
		String retVal = "";
		while(iterator.hasNext()){
			Cell c = iterator.next();
			if(c.visited()){
				retVal += c.read();
			}
		}
		return retVal;
	}
	private void initTape(String input){
		if(input.equals("")){
			Cell cell = new Cell('0');
			tape.add(cell);
		}
		for(char c : input.toCharArray()){
			Cell cell = new Cell(c);
			tape.addLast(cell);
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
		if(stateToAdd.getName().equals(startState.getName())){
			startState = stateToAdd;
		}
		if(stateToAdd.getName().equals(haltingState.getName())){
			haltingState = stateToAdd;
		}
	}
	
	private TMState getState(String state){
		for(TMState st: states){
			if(st.getName().equals(state)){
				return st;
			}
		}
		return null;
	}

	public String toString() {
		return states.toString();
	}

}
