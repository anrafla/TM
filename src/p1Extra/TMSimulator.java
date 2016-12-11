package p1Extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author andrew joshua
 *
 */
public class TMSimulator {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// The file name is passed as an argument
		String fileName = args[0];
		//create a new TM
		TM tm = new TM();
		File file = new File(fileName);
		if (file.exists()) {
			Scanner scan = new Scanner(file);
			//get the number of states and number of symbols from the input file
			String numOfStates = scan.nextLine();
			String numOfSymbols = scan.nextLine();
			//start state will always be "0"
			tm.addStartState("0");
			//add intermediate states, then after the loop, add the halting state
			for (int i = 1; i < Integer.parseInt(numOfStates); i++) {
				Integer name = new Integer(i);
				tm.addState(name.toString());
			}
			tm.addHaltingState(numOfStates);
			//now we need to parse the transitions from the file, they are in the format
			//toState,writeSymbol,direction. We must do this in order of states and 
			//number of symbols, each state will start with transition on 0, then 
			//have an extra line for each additional symbol in the alphabet
			for (int i = 0; i < Integer.parseInt(numOfStates); i++) {
				for (int j = 0; j <= Integer.parseInt(numOfSymbols); j++) {
					StringTokenizer tk = new StringTokenizer(scan.nextLine(), ",");
					String nextState = tk.nextToken();
					String writeSymbol = tk.nextToken();
					String direction = tk.nextToken();
					tm.addTransition(Integer.toString(i), Character.forDigit(j, 10), nextState, writeSymbol.charAt(0),
							direction.charAt(0));
				}
			}
			String input = "";
			if (scan.hasNext()) {
				input = scan.nextLine().trim();
			}
			scan.close();
			System.out.println(tm.simulate(input));
		} else {
			System.out.println("Did not find file: " + fileName);
		}
	}

}
