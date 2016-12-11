package p1Extra;

/**
 * Cell Object for TM tape
 * @author andrew joshua
 *
 */
public class Cell {
	private char symbol;
	private boolean visited;

	/**
	 * @param symbol symbol stored in the Cell
	 */
	public Cell(char symbol) {
		this.symbol = symbol;
		visited = false;
	}

	/**
	 * @param symbol synbol stored in the cell
	 * @param visited start with the cell being visited
	 */
	public Cell(char symbol, boolean visited) {
		this.symbol = symbol;
		this.visited = visited;
	}

	/**
	 * Set visited flag of cell to true
	 */
	public void setVisited() {
		visited = true;
	}

	/**
	 * Writes a symbol to the Cell
	 * @param symbol symbol to write onto the cell
	 */
	public void write(char symbol) {
		this.symbol = symbol;
	}

	/**
	 * Reads the symbol stored in the cell
	 * @return symbol in the cell
	 */
	public char read() {
		return symbol;
	}

	/**
	 * @return whether the cell has been visited or not
	 */
	public boolean visited() {
		return visited;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return symbol + " " + visited;
	}

}
