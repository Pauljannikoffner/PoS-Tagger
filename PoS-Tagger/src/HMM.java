import java.util.HashMap;
import java.util.HashSet;

public class HMM {

	private HashSet<State> states;
	private HashMap<State, Integer> initialDistribution;

	public HMM() {
		states = new HashSet<State>();
		initialDistribution = new HashMap<State, Integer>();
	}

	public void addState(State state) {
		states.add(state);
	}

	public HashSet<State> getStates() {
		return states;
	}

	public void initializationOccured(State state) {
		if (initialDistribution.containsKey(state)) {
			initialDistribution.put(state, new Integer(initialDistribution.get(state).intValue() + 1));
		} else {
			initialDistribution.put(state, new Integer(1));
		}
	}

	public HashMap<State, Integer> getInitialDistribution() {
		return initialDistribution;
	}
	
	public double initialProbability(State state) {
		int divisor = 0;
		for (Integer probability : initialDistribution.values()) {
			divisor += probability.intValue();
		}
		return (double) initialDistribution.get(state).intValue() / divisor;
	}

	public double transitionProbability(State current, State next) {
		return current.transitionProbability(next);
	}

	public double emissionProbability(State state, String emission) {
		return state.emissionProbability(emission);
	}
}
