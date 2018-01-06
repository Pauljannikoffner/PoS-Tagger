import java.io.IOException;

public class Controller {

	private HMM hmm;
	private UI ui;
	private HMMTrainer hmmTrainer;
	private HMMUser hmmUser;

	public Controller() {
		hmmTrainer = new HMMTrainer();

		try {
			hmmTrainer.setUp();
			hmm = hmmTrainer.getHMM();
			hmmUser = new HMMUser(hmm);
		} catch (IOException e) {
			System.out.println("File not found or not readable");
		}

		State nn = null;

		for (State state : hmm.getStates()) {
			if (state.getTag().equals("NN")) {
				nn = state;
			}
		}

		// double test = 0.0;
		//
		// for (State next : nn.getTransitions().keySet()) {
		// test += nn.transitionProbability(next);
		// double probDouble = nn.transitionProbability(next) * 1000;
		// int probInt = (int) probDouble;
		// double result = (double) probInt / 1000;
		// System.out.print(next.getTag() + ": " + result + " - ");
		// }
		//
		// System.out.println("");
		// System.out.println(test);
		//
		// double test2 = 0.0;
		//
		// for (String emission : nn.getEmissions().keySet()) {
		// test2 += nn.emissionProbability(emission);
		// double probDouble = nn.emissionProbability(emission) * 1000;
		// int probInt = (int) probDouble;
		// double result = (double) probInt / 1000;
		// System.out.print(emission + ": " + result + " - ");
		// }
		//
		// System.out.println("");
		// System.out.println(test2);
		//
		// double test3 = 0.0;
		//
		// for (State state : hmm.getInitialDistribution().keySet()) {
		// System.out.println(state.getTag() + ": " +
		// hmm.getInitialDistribution().get(state).intValue());
		// test3 += hmm.initialProbability(state);
		// }
		//
		// System.out.println(test3);

		ui = new UI();
	}
}
