package p1Extra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TMSimulator {

	public static void main(String[] args) throws FileNotFoundException {
		//The file name is passed as an argument
		String fileName = args[0];
		TM tm = new TM();
		File file = new File(fileName);
		if(file.exists()){
			Scanner scan = new Scanner(file);
			int numOfStates = scan.nextInt();
			int numOfSymbols = scan.nextInt();
			tm.addStartState(new TMState("0"));
			for(int i = 1; i<numOfStates; i++){
				Integer name = new Integer(i);
				TMState state = new TMState(name.toString());
				tm.addState(state);
			}
			tm.addHaltingState(new TMState(new Integer(numOfStates).toString()));
			
		}else{
			System.out.println("No File found");
		}
		System.out.println(tm);
	}

}
