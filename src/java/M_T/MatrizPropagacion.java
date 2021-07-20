/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

import MONTECARLO.UncertaintyPropagation;
import java.util.ArrayList;

import org.zkoss.zul.Messagebox;

/**
 *
 * @author Abde
 */
public class MatrizPropagacion {

    private ArrayList<Columnas> tabla;


    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public  MatrizPropagacion (ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }
    public void converMatrizMT() {
        double[] means = new double[16];
        double[] errores = new double[16];

        means[0] = tabla.get(0).getSio2();
        means[1] = tabla.get(0).getTio2();
        means[2] = tabla.get(0).getAl2o3();
        means[3] = tabla.get(0).getFe2o3();
        means[4] = tabla.get(0).getMno();
        means[5] = tabla.get(0).getMgo();
        means[6] = tabla.get(0).getCao();
        means[7] = tabla.get(0).getNa2o();
        means[8] = tabla.get(0).getK2o();
        means[9] = tabla.get(0).getP2o5();
        means[10] = tabla.get(0).getCr();
        means[11] = tabla.get(0).getNb();
        means[12] = tabla.get(0).getNi();
        means[13] = tabla.get(0).getV();
        means[14] = tabla.get(0).getY();
        means[15] = tabla.get(0).getZr();        

        errores[0] = tabla.get(0).getUcSio2();
        errores[1] = tabla.get(0).getUcTio2();
        errores[2] = tabla.get(0).getUcAl2o3();
        errores[3] = tabla.get(0).getUcFe2o3();
        errores[4] = tabla.get(0).getUcMno();
        errores[5] = tabla.get(0).getUcMgo();
        errores[6] = tabla.get(0).getUcCao();
        errores[7] = tabla.get(0).getUcNa2o();
        errores[8] = tabla.get(0).getUcK2o();
        errores[9] = tabla.get(0).getUcP2o5();
        errores[10] = tabla.get(0).getUcCr();
        errores[11] = tabla.get(0).getUcNb();
        errores[12] = tabla.get(0).getUcNi();
        errores[13] = tabla.get(0).getUcV();
        errores[14] = tabla.get(0).getUcY();
        errores[15] = tabla.get(0).getUcZr();       

        UncertaintyPropagation up = new UncertaintyPropagation(means, errores, 200);
        up.runPropagation();
        up.getmTodosElementosSimulados();     

        double[][] tMonteCarlo = up.getmTodosElementosSimulados();

        for (int j = 0; j < tMonteCarlo.length; j++) {
            Columnas r = new Columnas();
            r.setSio2(tMonteCarlo[j][0]);
            r.setTio2(tMonteCarlo[j][1]);
            r.setAl2o3(tMonteCarlo[j][2]);
            r.setFe2o3(tMonteCarlo[j][3]);
            r.setMno(tMonteCarlo[j][4]);
            r.setMgo(tMonteCarlo[j][5]);
            r.setCao(tMonteCarlo[j][6]);
            r.setNa2o(tMonteCarlo[j][7]);
            r.setK2o(tMonteCarlo[j][8]);
            r.setP2o5(tMonteCarlo[j][9]);
           
            r.setCr(tMonteCarlo[j][10]);            
            r.setNb(tMonteCarlo[j][11]);
            r.setNi(tMonteCarlo[j][12]);
            r.setV(tMonteCarlo[j][13]);
            r.setY(tMonteCarlo[j][14]);
            r.setZr(tMonteCarlo[j][15]);
            tabla.add(r);
        } 
    }
    
    public void converMatrizM() {
        double[] means = new double[10];
        double[] errores = new double[10];

        means[0] = tabla.get(0).getSio2();
        means[1] = tabla.get(0).getTio2();
        means[2] = tabla.get(0).getAl2o3();
        means[3] = tabla.get(0).getFe2o3();
        means[4] = tabla.get(0).getMno();
        means[5] = tabla.get(0).getMgo();
        means[6] = tabla.get(0).getCao();
        means[7] = tabla.get(0).getNa2o();
        means[8] = tabla.get(0).getK2o();
        means[9] = tabla.get(0).getP2o5();

        errores[0] = tabla.get(0).getUcSio2();
        errores[1] = tabla.get(0).getUcTio2();
        errores[2] = tabla.get(0).getUcAl2o3();
        errores[3] = tabla.get(0).getUcFe2o3();
        errores[4] = tabla.get(0).getUcMno();
        errores[5] = tabla.get(0).getUcMgo();
        errores[6] = tabla.get(0).getUcCao();
        errores[7] = tabla.get(0).getUcNa2o();
        errores[8] = tabla.get(0).getUcK2o();
        errores[9] = tabla.get(0).getUcP2o5();

        UncertaintyPropagation up = new UncertaintyPropagation(means, errores, 200);
        up.runPropagation();
        up.getmTodosElementosSimulados();
        

        double[][] tMonteCarlo = up.getmTodosElementosSimulados();

        for (int j = 0; j < tMonteCarlo.length; j++) {
            Columnas r = new Columnas();
            r.setSio2(tMonteCarlo[j][0]);
            r.setTio2(tMonteCarlo[j][1]);
            r.setAl2o3(tMonteCarlo[j][2]);
            r.setFe2o3(tMonteCarlo[j][3]);
            r.setMno(tMonteCarlo[j][4]);
            r.setMgo(tMonteCarlo[j][5]);
            r.setCao(tMonteCarlo[j][6]);
            r.setNa2o(tMonteCarlo[j][7]);
            r.setK2o(tMonteCarlo[j][8]);
            r.setP2o5(tMonteCarlo[j][9]);
            tabla.add(r);
        }        
    }
}
