
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SevenGameSeries s1 = new SevenGameSeries(50, 50, true);
		System.out.println("Win series probability " + s1.winWholeSeries() + "%");
		SevenGameSeries s2 = new SevenGameSeries(60, 40, true);
		System.out.println(("Win series probability " + s2.winWholeSeries() + "%"));
		SevenGameSeries s3 = new SevenGameSeries(60, 40, false);
		System.out.println(("Win series probability " + s3.winWholeSeries() + "%"));
		SevenGameSeries s4 = new SevenGameSeries(85, 75, true);
		System.out.println("Sweep probability: " + s4.sweep() + "%");
		SevenGameSeries s5 = new SevenGameSeries(40, 30, false);
		System.out.println(("Win series probability " + s5.winWholeSeries() + "%"));
	}

}
