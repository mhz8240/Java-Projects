
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		SevenGameSeries s1 = new SevenGameSeries(50, 50, true);
//		System.out.println("Win series probability " + s1.winWholeSeries() + "%");
//		SevenGameSeries s2 = new SevenGameSeries(60, 40, true);
//		System.out.println(("Win series probability " + s2.winWholeSeries() + "%"));
//		SevenGameSeries s3 = new SevenGameSeries(60, 40, false);
//		System.out.println(("Win series probability " + s3.winWholeSeries() + "%"));
		SevenGameSeries s4 = new SevenGameSeries(75, 65, false); 
		System.out.println("Sweep probability: " + s4.sweep() + "%");
		System.out.println("Win in 5 probability: " + s4.winIn5() + "%");
		System.out.println("Win in 6 probability: " + s4.winIn6() + "%");
		System.out.println("Win in 7 probability: " + s4.winIn7() + "%");
		System.out.println("Win series probability: " + s4.winWholeSeries() + "%");
		
	}

}
