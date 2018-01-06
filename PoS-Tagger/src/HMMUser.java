import java.util.HashMap;

public class HMMUser {

	private HMM hmm;

	public HMMUser(HMM hmm) {
		this.hmm = hmm;
	}

	public void doSomething(String[] emissionSequence) {
		HashMap<State, Double> alpha = new HashMap<State, Double>();
		for (State state : hmm.getStates()) {
			alpha.put(state, hmm.initialProbability(state) * hmm.emissionProbability(state, emissionSequence[0]));
		}
		for (int i = 1; i < emissionSequence.length; i++) {
			// do something
		}
	}
}
