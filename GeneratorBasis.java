package generator;

import java.text.DecimalFormat;

public class GeneratorBasis {

	double z1 = 20.0;
	double z2 = 10.0;
	double x = 1.0;

	private void runRandom() {
		DecimalFormat df = new DecimalFormat("0.00");
		double u1 = doLinearRandom(z1, z2, 1000000000);
		double u2 = doLinearRandom(z2, z1, 1000000000);
		//
		z1 = doBoxMuller(u1, u2);
		z2 = doBoxMuller(u1, u2);
		//
		System.out.println(df.format(z1).toString() + "; " + df.format(z2).toString() + ";");
	}

	private double doLinearRandom(double a, double c, double m) {
		double random = 0;
		//
		while (random < 1.0 && random > 0.0) {
			x = (a * x + c) % m;
			random = ((a * x + c) % m) / x;
		}
		//
		return random;

	}

	private double doBoxMuller(double u1, double u2) {
		double random = 0;
		//
		random = (Math.sqrt(-2 * Math.log(u1))) * Math.cos(2 * Math.PI * u2);
		//
		return random;
	}

	public static void main(String args[]) {
		GeneratorBasis gnb = new GeneratorBasis();
		gnb.runRandom();
	}
}
