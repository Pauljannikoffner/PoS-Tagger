import java.util.HashMap;

public class State {

	private HashMap<State, Integer> transitions;
	private HashMap<String, Integer> emissions;

	private final String tag;

	public State(String tag) {
		this.tag = tag;
		transitions = new HashMap<State, Integer>();
		emissions = new HashMap<String, Integer>();
	}

	public double transitionProbability(State next) {
		int divisor = 0;
		for (Integer probability : transitions.values()) {
			divisor += probability.intValue();
		}
		return (double) transitions.get(next).intValue() / divisor;
	}

	public double emissionProbability(String emission) {
		int divisor = 0;
		for (Integer probability : emissions.values()) {
			divisor += probability.intValue();
		}
		return (double) emissions.get(emission).intValue() / divisor;
	}

	public void transitionOccured(State next) {
		if (transitions.containsKey(next)) {
			transitions.put(next, new Integer(transitions.get(next).intValue() + 1));
		} else {
			transitions.put(next, new Integer(1));
		}
	}

	public void emissionOccured(String emission) {
		if (emissions.containsKey(emission)) {
			emissions.put(emission, new Integer(emissions.get(emission).intValue() + 1));
		} else {
			emissions.put(emission, new Integer(1));
		}
	}

	public String getTag() {
		return tag;
	}

	public HashMap<State, Integer> getTransitions() {
		return transitions;
	}

	public HashMap<String, Integer> getEmissions() {
		return emissions;
	}
}
