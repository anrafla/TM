package p1Extra;

/**
 * @author andrew
 * Creates a transition object, to contain fromState, nextState, and Symbol
 *
 */
public class Transition {
	private TMState nextState;
	private int writeSymbol;
	private char direction;

	/**
	 * @param fromState fromState
	 * @param symbol Transition symbol
	 * @param nextState nextState
	 */
	public Transition(TMState nextState, int writeSymbol, char direction) {
		this.nextState = nextState;
		this.writeSymbol = writeSymbol;
		this.direction = direction;
	}
}

	