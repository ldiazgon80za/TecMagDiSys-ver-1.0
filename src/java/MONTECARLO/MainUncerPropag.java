package MONTECARLO;


import java.util.Scanner;
import java.math.*;

public class MainUncerPropag {

	public static void main(String[] arg){		
		double medias[]={42.69909906,3.384444821,12.82631668,13.67797174,0.254426308,10.25155486,11.30366799,3.289589953,1.493949083,0.81897951};
		double errors[]={0.11,0.07,0.14,0.09,0.05,0.26,0.12,0.08,0.08,0.02};
		
		UncertaintyPropagation up=new UncertaintyPropagation(medias, errors, 100);
		up.runPropagation();
		up.saveFilesPropagation();		
	}
	
}
