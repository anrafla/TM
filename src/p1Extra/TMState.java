package p1Extra;

import java.util.HashSet;
import java.util.Set;

/**
 * @author andrew joshua
 *
 */
public class TMState {
	/**
	 * 
	 */
	private String name;
	private Set<Transition> delta;
	
	/**
	 * @param name of TMState
	 */
	public TMState(String name) {
		this.name = name;
		delta = new HashSet<Transition>();
	}

	/**
	 * @return TMState's name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Creates a new transition that this TMState has
	 * @param onSymb read symbol on tape head
	 * @param nextState state to transition to
	 * @param writeSymbol symbol to write to tape
	 * @param direction direction to move the tape head
	 */
	public void addTransition(char onSymb, TMState nextState, char writeSymbol, char direction) {
		delta.add(new Transition(onSymb, nextState, writeSymbol, direction));
	}
	/**
	 * Gets the transition object on a read symbol
	 * @param symb symbol on tape head
	 * @return Transition object
	 */
	public Transition getTransitionOn(char symb) {
		for(Transition trans: delta){
			if(trans.getOnSymb() == symb)
				return trans;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}

}
