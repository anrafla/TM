package p1Extra;

import java.util.HashSet;
import java.util.Set;

public class TMState {
	private String name;
	private Set<Transition> delta;
	
	public TMState(String name) {
		this.name = name;
		delta = new HashSet<Transition>();
	}

	public String getName(){
		return name;
	}

	public void addTransition(char onSymb, TMState nextState, char writeSymbol, char direction) {
		delta.add(new Transition(onSymb, nextState, writeSymbol, direction));
	}

	public String toString() {
		return name;
	}

	public Transition getTransitionOn(char symb) {
		for(Transition trans: delta){
			if(trans.getOnSymb() == symb)
				return trans;
		}
		return null;
	}
}
