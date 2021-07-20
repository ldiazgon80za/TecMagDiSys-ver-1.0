package MONTECARLO;

/*************************************************************************
 * NormalDistribution : Genera cadenas con distribucion normal usando el
 * Mersenne Twister algorithm / ziggurat
 * 
 * m�todo importante: 
 * getNext() regresa UN VALOR DOUBLE proveniente de una distribucion normal
 *************************************************************************/

public class NormalDistribution {

	// Variables
	private int[] seed1;
	private int[] seed2;
	private MTRandom r1, r2;


	/**
	 * NormalDistribution fija las seeds a usar en MTRandom
	 * 
	 * @param s1
	 * @param s2
	 */
	public NormalDistribution(int s1[], int[] s2) {
		setSeeds(s1, s2);
	}
	
	//Recibe una sola semilla; el m�todo Ziggurat solo requiere una.
	public NormalDistribution(int s1[]) {
		setSeeds(s1);
	}
	
	protected NormalDistribution() {
	}

	/**
	 * Seeds de MTRandom.java
	 * 
	 * @param s1
	 * @param s2
	 * RECIBE DOS SEMILLAS
	 */
	public void setSeeds(int s1[], int[] s2) {
		seed1 = s1;
		seed2 = s2;
		r1 = new MTRandom(true);
		r2 = new MTRandom(true);
		r1.setSeed(seed1);
		r2.setSeed(seed2);
	}
	/**
	 * Seeds de MTRandom.java
	 * 
	 * @param s1
	 * RECIBE UNA SEMILLA, que no se repite
	 */
	public void setSeeds(int s2[]) {
		seed2 = s2;
		r2 = new MTRandom(true);
		r2.setSeed(seed2);
	}
	
	/**
	 * getNext() return UN VALOR DOUBLE proveniente de una distribucion normal
	 */
	public double getNext() {
		return Ziggurat.nextGaussian(r2);
	}
}// End of NormalDistribution
