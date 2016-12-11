package p1Extra;

/**
 * @author andrew joshua Creates a transition object, to contain read symbol,
 *         nextState, writeSymbol, and tape head direction
 */
public class Transition {
	private TMState nextState;
	private char direction, onSymb, writeSymbol;

	/**
	 * @param onSymb
	 *            read symbol
	 * @param nextState
	 *            reference to next state
	 * @param writeSymbol
	 *            write symbol
	 * @param direction
	 *            direction to move tape head ('L' or 'R')
	 */
	public Transition(char onSymb, TMState nextState, char writeSymbol, char direction) {
		this.nextState = nextState;
		this.writeSymbol = writeSymbol;
		this.direction = direction;
		this.onSymb = onSymb;
	}

	/**
	 * @return symbol the transition reads
	 */
	public char getOnSymb() {
		return onSymb;
	}

	/**
	 * @return reference to next TMState object
	 */
	public TMState getNextState() {
		return nextState;
	}

	/**
	 * @return symbol to write to the tape on this transition
	 */
	public char getWriteSymbol() {
		return writeSymbol;
	}

	/**
	 * @return direction to move tape head (should be either 'L' or 'R' if
	 *         transition was created correctly
	 */
	public char getDirection() {
		return direction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str = "On: " + onSymb + "\nGoes to: " + nextState + "\nWrites: " + writeSymbol + "\nGoes: " + direction;
		return str;

	}
}
