package p1Extra;

public class Cell {
	private char symbol;
	private boolean visited;

	public Cell(char symbol) {
		this.symbol = symbol;
		visited = false;
	}

	public Cell(char symbol, boolean visited) {
		this.symbol = symbol;
		this.visited = visited;
	}

	public void setVisited() {
		visited = true;
	}

	public void write(char symbol) {
		this.symbol = symbol;
	}

	public char read() {
		return symbol;
	}

	public boolean visited() {
		return visited;
	}

	public String toString() {
		return symbol + " " + visited;
	}

}
