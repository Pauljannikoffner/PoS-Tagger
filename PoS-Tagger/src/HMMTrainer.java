import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HMMTrainer {

	private HMM hmm;

	private BufferedReader br;
	private FileReader fr;

	public HMMTrainer() {
		hmm = new HMM();
	}

	public HMMTrainer(HMM hmm) {
		this.hmm = hmm;
	}

	public void setUp() throws IOException {
		fr = new FileReader("D:/Users/poffner/Desktop/hdt-tagged/hdt-1-10000-train.txt");
		br = new BufferedReader(fr);

		String line = br.readLine();

		State lastState = null;

		while (line != null) {
			if (!line.isEmpty()) {
				String[] lineArray = line.split("[\\t]");
				boolean stateKnown = false;
				for (State state : hmm.getStates()) {
					if (state.getTag().equals(lineArray[1])) {
						stateKnown = true;
						state.emissionOccured(lineArray[0]);
						if (lastState != null) {
							lastState.transitionOccured(state);
							if (lastState.getTag().equals("$.")) {
								hmm.initializationOccured(state);
							}
						}
						lastState = state;
						break;
					}
				}
				if (!stateKnown) {
					State state = new State(lineArray[1]);
					state.emissionOccured(lineArray[0]);
					hmm.addState(state);
					if (lastState != null) {
						lastState.transitionOccured(state);
					}
					lastState = state;
				}
			}
			line = br.readLine();
		}
	}

	public HMM getHMM() {
		return hmm;
	}
}
