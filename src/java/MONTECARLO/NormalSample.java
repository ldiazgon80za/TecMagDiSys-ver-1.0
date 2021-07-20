package MONTECARLO;

 /* MuestraNormal: genera muestras don datos provenientes de una distribucion
 * normal
 *************************************************************************/
public class NormalSample {

	/**
	 * Arreglo que almacena los datos de la Muestra_normal.
	 */
	private double[] aNormalSample;


	/**
	 * Metodo para construir las muestras normales
	 * 
	 * @param normalDist
	 * @param tamanoActual
	 * @return 
	 */
	//constructor para generar una muestra normal N(0,1)
	public NormalSample(NormalDistribution normalDist, int n) {
		aNormalSample = new double[n];
		
		// Primeros valores se obtienen de una distribucion.
		for (int i = 0; i < n; i++) {
			//llama al metodo ziggurat
			aNormalSample[i] = (normalDist.getNext());//aqui genero el arreglo normal	con Ziggurat		
		}
	}
	
	//constructor para generar una muestra normal desplazada N(centralTendency, dispersion)
	public NormalSample(NormalDistribution normalDist, int n, double centralTendency, double dispersion) {
		aNormalSample = new double[n];
		
		// Primeros valores se obtienen de una distribucion.
		for (int i = 0; i < n; i++) {
			//llama al metodo ziggurat
			aNormalSample[i] = (normalDist.getNext())*dispersion+centralTendency;
			//aqui desplazado la media y cambio la dispersi�n
		}
	}
	
	private double[] generateNormalSample() {
		return aNormalSample;
	}
	/**
	 * @return muestra normal generada
	 */
	public double[] getNormalSample() {
		return aNormalSample;
	}
	

}// Fin Clase Muestra_normal