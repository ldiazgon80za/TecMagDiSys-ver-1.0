/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MONTECARLO;

/**
 *
 * @author Abde
 */
public class UncertaintyPropagation {

    private double[] arrayMeans, arrayErrors; //variables de instancia
    private int nRepetions;
    /**
     * matriz que contiene [nRepeticiones][nExperiments] datos simulados para un
     * solo elemento, de esta matriz se obtendr�n dos arreglos: media de 190
     * experimentos, y su respectiva incertidumbre
     */
    double mTodosElementosSimulados[][];

		//private double[][] mMean;//en esta matriz se guardar�n la media de los 190 experimentos de todos los elementos
    //private double[][] mUncer;//en esta matriz se guardar�n la incertidumbre de los 190 experimentos de todos los elementos
    /**
     * el constructor debe DOS ARREGLOS DE VALORES double: double[] arrayMeans:
     * composici�n de los elementos (mayores y/o traza) double[] arrayErrors:
     * ERROR de una muestra experimental.
     *
     * En este caso, interesa propagar el error de estos elementos de una
     * muestra experimental: SIO2	TIO2	AL2O3	FE2O3T	MNO	MGO	CAO	NA2O	K2O	P2O5 CR
     * NB	NI	V	Y	ZR
     */
    public UncertaintyPropagation(double[] arrayMeans, double[] arrayErrors, int nRepetions) {
        if (arrayMeans.length > 0 && arrayErrors.length > 0 && nRepetions > 0) {
            setArrayMeansErrors(arrayMeans, arrayErrors);
            this.nRepetions = nRepetions;
            mTodosElementosSimulados = new double[nRepetions * 11][arrayMeans.length];
		    	//this.nExperiments=nExperiments;
            //mMean= new double[nRepetions][arrayMeans.length];
            //mUncer= new double[nRepetions][arrayMeans.length];
        } else {
            System.err.println("Argumemtos no validos para la clase UncertaintyPropagation.  "
                    + "arrayMeans: " + arrayMeans.length
                    + " arrayErrors: " + arrayErrors.length
                    + " nrep: " + nRepetions);
        }
    }

    //inicializar los arreglos de instancia
    private void setArrayMeansErrors(double[] arrayMeans, double[] arrayErrors) {
        //declaro los arreglos de instancia
        this.arrayMeans = new double[arrayMeans.length];
        this.arrayErrors = new double[arrayErrors.length];

        //inicializo los arreglos de instancia
        for (int i = 0; i < arrayMeans.length; i++) {
            this.arrayMeans[i] = arrayMeans[i];
            this.arrayErrors[i] = arrayErrors[i];
        }
    }

    //este metodo ejecuta la propagaci�n del error

    public void runPropagation() {
        NormalDistribution nd1;
        int filasGuardadas;

        for (int i = 0; i < arrayMeans.length; i++) {//aqui recorro el arreglo de elementos qu�micos que se quiere propagar su error
            filasGuardadas = 0;
            for (int j = 0; j < 11; j++) {//11 experimentos (semillas diferentes) para cada elemento	    		
                nd1 = new NormalDistribution(Seeds.seed2[j + (11 * i)]);//siembro una semilla
                for (int k = 0; k < nRepetions; k++) 
            //****************************************Bloque agregado para eliminar los datos negativos************************************************************                         
                {
                    double numg=(nd1.getNext() * arrayErrors[i]) + arrayMeans[i];
                    if (numg > 0) {
                        mTodosElementosSimulados[filasGuardadas++][i] = numg;//cada valor obtenido por Monte Carlo se va a multiplicar por el error y sumar la media
                    } else {
                        k--;
                    }
                }
                //**************************************************************************************************************************************************                  
            }
        }
    }

    public double[][] getmTodosElementosSimulados() {
        return mTodosElementosSimulados;
    }

    public void saveFilesPropagation() {
        runPropagation();
        /*guardar en un archivo las muestras simuladas*/
        TextFile mElementos = new TextFile("Datos.txt");
        String ar = "SIO2\tTIO2\tAL2O3\tFE2O3T\tMNO\tMGO\tCAO\tNA2O\tK2O\tP2O5\tCR\tNB\tNI\tV\tY\tZR\n";
        mElementos.writeText(ar);

        for (double[] u : this.mTodosElementosSimulados) {
            for (double elem : u) {
                mElementos.writeText(elem + "\t");
                System.out.print(elem + "\t");// Your individual element
            }
            System.out.print("\n");
            mElementos.writeText("\n");
        }
    }

}
