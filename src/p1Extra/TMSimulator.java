package p1Extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TMSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		// The file name is passed as an argument
		String fileName = args[0];
		TM tm = new TM();
		File file = new File(fileName);
		if (file.exists()) {
			Scanner scan = new Scanner(file);
			String numOfStates = scan.nextLine();
			String numOfSymbols = scan.nextLine();
			tm.addStartState(new TMState("0"));
			for (int i = 1; i < Integer.parseInt(numOfStates); i++) {
				Integer name = new Integer(i);
				TMState state = new TMState(name.toString());
				tm.addState(state);
			}
			tm.addHaltingState(new TMState(numOfStates));
			for (int i = 0; i < Integer.parseInt(numOfStates); i++) {
				for (int j = 0; j <= Integer.parseInt(numOfSymbols); j++) {
					StringTokenizer tk = new StringTokenizer(scan.nextLine(), ",");
					String nextState = tk.nextToken();
					String writeSymbol = tk.nextToken();
					String direction = tk.nextToken();
					tm.addTransition(new Transition(Integer.toString(i), Character.forDigit(j, 10), nextState,
							writeSymbol.charAt(0), direction.charAt(0)));
				}
			}
			String input = scan.next().trim();
			tm.simulate(input);
		}
	}

}
