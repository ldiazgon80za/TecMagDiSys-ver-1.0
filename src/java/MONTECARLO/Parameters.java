package MONTECARLO;

import java.util.Arrays;

/*************************************************************************
 * @author Mauricio Rosales Rivera
 * @version 27 / 04 / 2015 - v4.0
 *************************************************************************/
public class Parameters {

	private static final double c1 = 4.5;
	private static final double c2 = 3.0;

	/**
	 * Metodo para calcular la media de los datos
	 * 
	 * @param data
	 *            - arreglo de datos
	 * @return mean - media de datos
	 */
	public static double mean(double[] data) {
		quickSort(data, 0, data.length - 1);
		double value = 0.0;
		for (int i = 0; i < data.length; i++) {
			// System.out.print(i+" ");
			value += data[i];
		}
		return (value / (double) (data.length));
	}

	/**
	 * Metodo que nos permite calcular la varianza de los datos
	 * 
	 * @param data - array
	 * @param mean - of the array
	 * @return variance
	 */
	public static double variance(double[] data, double mean) {
		double variance = 0.0;
		for (int i = 0; i < data.length; i++) {
			// System.out.print(i+" ");
			variance += Math.pow(data[i] - mean, 2);
		}

		return (variance / (double) (data.length - 1));
	}

	/**
	 * Metodo que nos permite calcular la desviacion standar
	 * 
	 * @param data
	 *            - array
	 * @param mean
	 *            - of the array
	 * @return stdev
	 */
	public static double getsDev(double[] data) {
		quickSort(data, 0, data.length - 1);
		double stdev = Math.sqrt(variance(data, mean(data)));
		return stdev;
	}

	/**
	 * Metodo para ordenar de forma ascendente los datos
	 * 
	 * @param muestra  - arreglo de datos
	 * @param izq 0 - valor inicial del arreglo
	 * @param der n-1 - valor final del arreglo
	 */
	public static void quickSort(double[] muestra, int izq, int der) {
		double pivote;
		double aux;
		int i, j;
		i = izq;
		j = der;
		pivote = muestra[(i + j) / 2];
		do {
			while (muestra[i] < pivote)
				i++;
			while (muestra[j] > pivote)
				j--;
			if (i <= j) {
				aux = muestra[i];
				muestra[i] = muestra[j];
				muestra[j] = aux;
				i++;
				j--;
			}
		} while (i <= j);

		if (izq < j)
			quickSort(muestra, izq, j);
		if (i < der)
			quickSort(muestra, i, der);
	}

	/**
	 * Metodo para calcular el error standar de la simulacion
	 * 
	 * @param data array
	 * @param desvest
	 * @return standardError
	 */
	public static double uncertainty(double[] data) {
		return ((getsDev(data) / Math.sqrt((double) data.length)) * 2.6006393 );
	}

	// ...............................................................................................
	/**
	 * Metodos Robustos
	 */

	/**
	 * @param arreglo Arreglo de números.
	 * @return Mediana del arreglo.
	 */
	public static double median(double[] data) {
		quickSort(data, 0, data.length - 1);
		
		int middle = (data.length/2);
		if (data.length % 2 == 1) {
			return (double)(data[middle]);
			
		} else {
			double l = (data[middle-1]) + (data[middle]);
			return (double)(l/2.0);
		}
	}

	/**
	 * MAD modificado con ajuste reportado en literatura
	 * @param data
	 * @param mediana
	 * @return
	 */
	public static double getMAD(double[] data, double median) {
		quickSort(data, 0, data.length - 1);
		double[] difEntreArregloYMediana = new double[data.length];
		for (int i = 0; i < data.length; i++) {
			difEntreArregloYMediana[i] = (Math.abs(data[i] - median));
		}
		return median(difEntreArregloYMediana);
	}

	/**
	 * 
	 * @param arreglo
	 *            Arreglo ORDENADO de nÃºmeros.
	 * @return
	 */
	public static double getSn(double[] arreglo) {
		/*
		 * Almacena las distancias entre un dato y el resto de los datos (Se
		 * incluye a sÃ­ mismo en el resto de los datos).
		 */
		quickSort(arreglo,0,arreglo.length-1);
		double[] tmpArreglo = new double[arreglo.length];
		// Almacena las medias de las distancias entre cada dato y el resto.
		double[] medianj = new double[arreglo.length];

		// CÃ¡lculo de las distancias entre un dato y el resto, y
		// almacenamiento de la media.
		for (int j = 0; j < medianj.length; j++) {
			for (int i = 0; i < tmpArreglo.length; i++) {
				tmpArreglo[i] = Math.abs(arreglo[j] - arreglo[i]);

				// System.out.println(j+","+i+" diferencia abs: "+
				// arreglo[j]+"-"+arreglo[i]+"="+tmpArreglo[i]);
			}
			quickSort(tmpArreglo, 0, tmpArreglo.length - 1);
			// Arrays.sort(tmpArreglo);
			medianj[j] = median(tmpArreglo);
			// System.err.println("MEDIANA de estas diferencias: "+medianj[j]);
		}
		// System.err.println("\n\n");
		quickSort(medianj, 0, medianj.length - 1);
		// Arrays.sort(medianj);
		// Se devuelve la media de las medias almacenadas.
		// System.err.println("Sn es la MEDIANA de las diferencias generales: "+getMedian(medianj));
		return /* 1.1926 */(median(medianj));
	}

	/**
	 * 
	 * @param arreglo
	 * @return
	 */
	public static double getQn(double[] arreglo) {
		int n = arreglo.length;
		quickSort(arreglo,0,arreglo.length-1);
		// Cantidad de subconjuntos de 2 datos del arreglo.
		int p = (n * (n - 1)) / 2;// p combinaciones 50,2 (50*(50-1))/2=1225
		// System.out.println("Calcular m: "+p);
		// PosiciÃ³n del elemento a devolver de pairwiseDists ordenado.
		// int k = (n*(n+2))/8 - 1; // esto es lo mismo: (26*(26-1))/2 =325 //
		// -1 debido a que el indexado inicia en 0
		//Calculo aproximado
		//***************************
		//int m = (int)(n*(n-1)/2);
		//int k = (int)(m/4);
		//***************************
		//Calculo correcto
		int k = ((n*(n+2))/8) - 1;
		//int k = ((n / 2) * ((n / 2) + 1)) / 2;
		// System.out.println("Calcular k: "+k);
		// Almacena las distancias entre cada par de datos en el arreglo.
		double[] pairwiseDists = new double[p];
		// Contador de pares.
		int c = 0;

		// CÃ¡lculo de las distancias entre cada par de datos en el arreglo.
		for (int i = 0; i < arreglo.length - 1; i++) {
			for (int j = i + 1; j < arreglo.length; j++) {
				pairwiseDists[c++] = Math.abs(arreglo[i] - arreglo[j]);
			}
		}

		quickSort(pairwiseDists, 0, pairwiseDists.length - 1);

		return /* 2.2219 */pairwiseDists[k]; //[k-1]
	}

	// calcula Mu gorrito LDG
	public static double getMu(double[] arreglo, double mediana, double mad) {
		double u, maxu;
		quickSort(arreglo,0,arreglo.length-1);
		double[] wi = new double[arreglo.length];

		for (int i = 0; i < wi.length; i++) {
			u = (arreglo[i] - mediana) / mad;
			maxu = Math.max(0, (1 - Math.pow(u / c1, 2)));// max{0, 1-(u/c1)2 }
			wi[i] = Math.pow(maxu, 2);// wi=max{0, 1-(u/c1)2 }2
		}

		// double[] w = new double[arreglo.length];
		double sumWiXi = 0, sumWi = 0;
		for (int i = 0; i < wi.length; i++) {
			sumWi += wi[i];
			sumWiXi += wi[i] * arreglo[i];

		}
		// System.out.println("sumWi: "+sumWi+ "\n 1/sumWi: "+(1/sumWi)+
		// "\n sumWiXi: "+sumWiXi);
		// System.out.println("Mu^: "+(1/sumWi)*sumWiXi);

		return ((1 / sumWi) * sumWiXi);
	}

	public static double getSigma(double[] arreglo, double muc, double mad) {
		quickSort(arreglo,0,arreglo.length-1);
		double[] pc2 = new double[arreglo.length];
		double c22 = c2 * c2, u;
		double sumaPc2 = 0.0;
		for (int i = 0; i < pc2.length; i++) {
			u = Math.pow((arreglo[i] - muc) / mad, 2.0);// aquí se calcula (u)
														// para--> ROc2(u) ..
			if (u > c22)
				pc2[i] = c22;
			else
				pc2[i] = u;

			sumaPc2 += pc2[i];
		}
		return (mad * Math.sqrt(sumaPc2 / arreglo.length));
	}

}// End of Stadistics
