
public class SevenGameSeries {
	private double homeWinProb;
	private double roadWinProb;
	private double homeLoseProb;
	private double roadLoseProb;
	private boolean homeField;
	public SevenGameSeries(int homeWinPercent, int roadWinPercent, boolean homeField) {
		homeWinProb = homeWinPercent / 100.0;
		roadWinProb = roadWinPercent / 100.0;
		homeLoseProb = 1.00 - homeWinProb;
		roadLoseProb = 1.00 - roadWinProb;
		this.homeField = homeField;
	}
	public double sweep() {
		double prob = homeWinProb * homeWinProb * roadWinProb * roadWinProb;
		double percent = 100.0 * prob;
		return percent;
	}
	public double winIn5() {
		double prob = 0.0;
		double percent = 0.0;
		int permutations = 0;
		// homefield case
		if (homeField) {
			// Case 1: Go 3-0 at home and 1-1 on the road (2 permutations)
			double case1 = Math.pow(homeWinProb, 3) * roadLoseProb * roadWinProb;
			permutations = 2;
			case1 *= permutations;
			// Case 2: Go 2-1 at home and 2-0 on the road (2 permutations because you must win the last game)
			double case2 = homeWinProb * homeWinProb * homeLoseProb * roadWinProb * roadWinProb;
			permutations = 2;
			case2 *= permutations;
			prob = case1 + case2;
			percent = 100.0 * prob;
			return percent;
		}
		// if they don't have homefield case
		// Case 1: Go 3-0 on the road and 1-1 at home (2 permutations)
		double case1 = Math.pow(roadWinProb, 3) * homeLoseProb * homeWinProb;
		permutations = 2;
		case1 *= permutations;
		// Case 2: Go 2-1 on the road and 2-0 at home (2 permutations)
		double case2 = roadWinProb * roadWinProb * roadLoseProb * homeWinProb * homeWinProb;
		case2 *= permutations;
		prob = case1 + case2;
		percent = 100.0 * prob;
		return percent;
	}
	public double winIn6() {
		
		double prob = 0.0;
		double percent = 0.0;
		int permutations = 0;
		// homefield case
		if (homeField) {
			//Case 1: Go 3-0 at home and 1-2 on the road(1 permutation because must win last game)
			double case1 = Math.pow(homeWinProb, 3) * roadLoseProb * roadLoseProb * roadWinProb;
			// Case 2: Go 2-1 at home and 2-1 on the road(6 permutations)
			double case2 = homeWinProb * homeWinProb * roadWinProb * roadWinProb * homeLoseProb * roadLoseProb;
			permutations = 6;
			case2 *= permutations;
			// Case 3: Go 1-2 at home and 3-0 on the road (3 permutations)
			double case3 = Math.pow(roadWinProb, 3) * homeLoseProb * homeLoseProb * homeWinProb;	
			permutations = 3;
			case3 *= permutations;
			prob = case1 + case2 + case3;
			percent = 100.0 * prob;
			return percent;
		}
		// if no homefield
		//Case 1: Go 3-0 on the road and 1-2 at home(1 permutation because must win last game)
		double case1 = Math.pow(roadWinProb, 3) * homeLoseProb * homeLoseProb * homeWinProb;	
		// Case 2: Go 2-1 at home and 2-1 on the road(6 permutations)
		double case2 = homeWinProb * homeWinProb * roadWinProb * roadWinProb * homeLoseProb * roadLoseProb;
		permutations = 6;
		case2 *= permutations;
		// Case 3: Go 1-2 on the road and 3-0 at home (3 permutations)
		double case3 = Math.pow(homeWinProb, 3) * roadLoseProb * roadLoseProb * roadWinProb;	
		permutations = 3;
		case3 *= permutations;
		prob = case1 + case2 + case3;
		percent = 100.0 * prob;
		return percent;
		
	}
	public double winIn7() {
		double prob = 0.0;
		double percent = 0.0;
		int permutations = 0;
		// first go case by case for the first 6 games of the series, then check homefield for game 7
		// Case 1: Go 3-0 at home and 0-3 on the road in the first 6 games(1 permutation)
		double case1 = Math.pow(homeWinProb, 3) * Math.pow(roadLoseProb, 3);
		// case 2: Go 2-1 at home and 1-2 on the road in first 6 games(9 permutations)
		double case2 = Math.pow(homeWinProb, 2) * Math.pow(roadLoseProb, 2) * homeLoseProb * roadWinProb;
		permutations = 9;
		case2 *= permutations;
		// case 3: Go 1-2 at home and 2-1 on the road in first 6 games(9 permutations)
		double case3 = Math.pow(homeLoseProb, 2) * Math.pow(roadWinProb, 2) * homeWinProb * roadLoseProb;
		permutations = 9;
		case3 *= permutations;
		// Case 4: Go 0-3 at home and 3-0 on the road in the first 6 games(1 permutation)
		double case4 = Math.pow(homeLoseProb, 3) * Math.pow(roadWinProb, 3);
		double probSplitFirstSix = case1 + case2 + case3 + case4;
		// check for home field in game 7
		if (homeField) {
			prob = probSplitFirstSix * homeWinProb;
		}
		else {
			prob = probSplitFirstSix * roadWinProb;
		}
		percent = 100.0 * prob;
		return percent;
	}
	public double winWholeSeries() {
		return sweep() + winIn5() + winIn6() + winIn7();
	}
}

