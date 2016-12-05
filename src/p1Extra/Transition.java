package p1Extra;

/**
 * @author andrew Creates a transition object, to contain fromState, nextState,
 *         and Symbol
 *
 */
public class Transition {
	private TMState nextState;
	private char direction, onSymb, writeSymbol;

	/**
	 * @param fromState
	 *            fromState
	 * @param symbol
	 *            Transition symbol
	 * @param nextState
	 *            nextState
	 */
	public Transition(char onSymb, TMState nextState, char writeSymbol, char direction) {
		this.nextState = nextState;
		this.writeSymbol = writeSymbol;
		this.direction = direction;
		this.onSymb = onSymb;
	}
	public char getOnSymb(){
		return onSymb;
	}
	public TMState getNextState(){
		return nextState;
	}
	public char getWriteSymbol(){
		return writeSymbol;
	}
	public char getDirection(){
		return direction;
	}
	
	public String toString() {
		String str = "\nOn: " + onSymb + "\nGoes to: " + nextState + "\nWrites: "
				+ writeSymbol + "\nGoes: " + direction;
		return str;

	}
}
