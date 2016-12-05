package p1Extra;

/**
 * @author andrew Creates a transition object, to contain fromState, nextState,
 *         and Symbol
 *
 */
public class Transition {
	private String fromState, nextState;
	private char direction, onSymb, writeSymbol;

	/**
	 * @param fromState
	 *            fromState
	 * @param symbol
	 *            Transition symbol
	 * @param nextState
	 *            nextState
	 */
	public Transition(String fromState, char onSymb, String nextState, char writeSymbol, char direction) {
		this.fromState = fromState;
		this.nextState = nextState;
		this.writeSymbol = writeSymbol;
		this.direction = direction;
		this.onSymb = onSymb;
	}

	public String toString() {
		String str = "From State: " + fromState + "\nOn: " + onSymb + "\nGoes to: " + nextState + "\nWrites: "
				+ writeSymbol + "\nGoes: " + direction;
		return str;

	}
}
