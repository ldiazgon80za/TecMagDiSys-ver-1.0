/*
HOLAA  * 
To change this license header, choose License Headers in Project Properties.
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
public class MatrizPostempla {

    private ArrayList<Columnas> tabla;
   
    public MatrizPostempla(ArrayList<Columnas> tabla){
        this.tabla = tabla;
    }
    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public void runPostemplaM() {
        double sio2N, tio2N, al2o3N, fe2o3N, mnoN, mgoN, caoN, na2oN, k2oN, p2o5N;
        double sio2A, tio2A, al2o3A, fe2o3A, mnoA, mgoA, caoA, na2oA, k2oA, p2o5A, sumAdj;
        Columnas r;

//1. debo leer el elemento inicial y su delta para calcular el nuevo elemento
        sio2N = tabla.get(0).getSio2() + (tabla.get(0).getSio2() * (tabla.get(0).getStepSio2() / 100));
        tio2N = tabla.get(0).getTio2() + (tabla.get(0).getTio2() * (tabla.get(0).getStepTio2() / 100));
        al2o3N = tabla.get(0).getAl2o3() + (tabla.get(0).getAl2o3() * (tabla.get(0).getStepAl2o3() / 100));
        fe2o3N = tabla.get(0).getFe2o3() + (tabla.get(0).getFe2o3() * (tabla.get(0).getStepFe2o3() / 100));
        mnoN = tabla.get(0).getMno() + (tabla.get(0).getMno() * (tabla.get(0).getStepMno() / 100));
        mgoN = tabla.get(0).getMgo() + (tabla.get(0).getMgo() * (tabla.get(0).getStepMgo() / 100));
        caoN = tabla.get(0).getCao() + (tabla.get(0).getCao() * (tabla.get(0).getStepCao() / 100));
        na2oN = tabla.get(0).getNa2o() + (tabla.get(0).getNa2o() * (tabla.get(0).getStepNa2o() / 100));
        k2oN = tabla.get(0).getK2o() + (tabla.get(0).getK2o() * (tabla.get(0).getStepK2o() / 100));
        p2o5N = tabla.get(0).getP2o5() + (tabla.get(0).getP2o5() * (tabla.get(0).getStepP2o5() / 100));
        
        double minMajor=0.002; 
        int c = 0;
        do {//ciclo postemplazamiento
            r = new Columnas();
            //2. debo AJUSTAR el nuevo elemento modificado
            sumAdj = sio2N + tio2N + al2o3N + fe2o3N + mnoN + mgoN + caoN + na2oN + k2oN + p2o5N;

            //3. revisar si el nuevo elemento ajustado cumple las condiciones básicas de minimo y maximo, si cumple guardarlo
            sio2A = sio2N * (100 / sumAdj);
            if ((sio2A < 100) && (sio2A > 30)) {
                r.setSio2(sio2N);
                r.setSio2A(sio2A);
            } else {               
                break;
            }

            tio2A = tio2N * (100 / sumAdj);
            if ((tio2A < 100) && (tio2A > minMajor)) {
                r.setTio2(tio2N);
                r.setTio2A(tio2A);
            } else {
                break;
            }

            al2o3A = al2o3N * (100 / sumAdj);
            if ((al2o3A < 100) && (al2o3A > minMajor)) {
                r.setAl2o3(al2o3N);
                r.setAl2o3A(al2o3A);
            } else {
                break;
            }

            fe2o3A = fe2o3N * (100 / sumAdj);
            if ((fe2o3A < 100) && (fe2o3A > minMajor)) {
                r.setFe2o3(fe2o3N);
                r.setFe2o3tA(fe2o3A);
            } else {
                break;
            }

            mnoA = mnoN * (100 / sumAdj);
            if ((mnoA < 100) && (mnoA > minMajor)) {
                r.setMno(mnoN);
                r.setMnoA(mnoA);
            } else {
                break;
            }

            mgoA = mgoN * (100 / sumAdj);
            if ((mgoA < 100) && (mgoA > minMajor)) {
                r.setMgo(mgoN);
                r.setMgoA(mgoA);
            } else {
                break;
            }

            caoA = caoN * (100 / sumAdj);
            if ((caoA < 100) && (caoA > minMajor)) {
                r.setCao(caoN);
                r.setCaoA(caoA);
            } else {
                break;
            }

            na2oA = na2oN * (100 / sumAdj);
            if ((na2oA < 100) && (na2oA > minMajor)) {
                r.setNa2o(na2oN);
                r.setNa2oA(na2oA);
            } else {
                break;
            }

            k2oA = k2oN * (100 / sumAdj);
            if ((k2oA < 100) && (k2oA > minMajor)) {
                r.setK2o(k2oN);
                r.setK2oA(k2oA);
            } else {
                break;
            }

            p2o5A = p2o5N * (100 / sumAdj);
            if ((p2o5A < 100) && (p2o5A > minMajor)) {
                r.setP2o5(p2o5N);
                r.setP2o5A(p2o5A);
            } else {
                break;
            }
            tabla.add(r);//agrego la nueva fila emplazada a la tabla de salida
            c++;//contador de ietraciones de emplazamiento

            //realizo el siguiente cambio de emplazamiento
            sio2N = r.getSio2() + (r.getSio2() * (tabla.get(0).getStepSio2() / 100));
            tio2N = r.getTio2() + (r.getTio2() * (tabla.get(0).getStepTio2() / 100));
            al2o3N = r.getAl2o3() + (r.getAl2o3() * (tabla.get(0).getStepAl2o3() / 100));
            fe2o3N = r.getFe2o3() + (r.getFe2o3() * (tabla.get(0).getStepFe2o3() / 100));
            mnoN = r.getMno() + (r.getMno() * (tabla.get(0).getStepMno() / 100));
            mgoN = r.getMgo() + (r.getMgo() * (tabla.get(0).getStepMgo() / 100));
            caoN = r.getCao() + (r.getCao() * (tabla.get(0).getStepCao() / 100));
            na2oN = r.getNa2o() + (r.getNa2o() * (tabla.get(0).getStepNa2o() / 100));
            k2oN = r.getK2o() + (r.getK2o() * (tabla.get(0).getStepK2o() / 100));
            p2o5N = r.getP2o5() + (r.getP2o5() * (tabla.get(0).getStepP2o5() / 100));
        } while (true);
    }
    
    public void runPostemplaMT() {
        double sio2N, tio2N, al2o3N, fe2o3N, mnoN, mgoN, caoN, na2oN, k2oN, p2o5N, crN, nbN, niN, yN, vN, zrN;
        double sio2A, tio2A, al2o3A, fe2o3A, mnoA, mgoA, caoA, na2oA, k2oA, p2o5A, sumAdj, crA, nbA, niA, yA, vA, zrA;
        Columnas r;
        

//1. debo leer el elemento inicial y su delta para calcular el nuevo elemento
        sio2N = tabla.get(0).getSio2() + (tabla.get(0).getSio2() * (tabla.get(0).getStepSio2() / 100));
        tio2N = tabla.get(0).getTio2() + (tabla.get(0).getTio2() * (tabla.get(0).getStepTio2() / 100));
        al2o3N = tabla.get(0).getAl2o3() + (tabla.get(0).getAl2o3() * (tabla.get(0).getStepAl2o3() / 100));
        fe2o3N = tabla.get(0).getFe2o3() + (tabla.get(0).getFe2o3() * (tabla.get(0).getStepFe2o3() / 100));
        mnoN = tabla.get(0).getMno() + (tabla.get(0).getMno() * (tabla.get(0).getStepMno() / 100));
        mgoN = tabla.get(0).getMgo() + (tabla.get(0).getMgo() * (tabla.get(0).getStepMgo() / 100));
        caoN = tabla.get(0).getCao() + (tabla.get(0).getCao() * (tabla.get(0).getStepCao() / 100));
        na2oN = tabla.get(0).getNa2o() + (tabla.get(0).getNa2o() * (tabla.get(0).getStepNa2o() / 100));
        k2oN = tabla.get(0).getK2o() + (tabla.get(0).getK2o() * (tabla.get(0).getStepK2o() / 100));
        p2o5N = tabla.get(0).getP2o5() + (tabla.get(0).getP2o5() * (tabla.get(0).getStepP2o5() / 100));
        
        crN = tabla.get(0).getCr() + (tabla.get(0).getCr() * (tabla.get(0).getStepCr() / 100));
        nbN = tabla.get(0).getNb() + (tabla.get(0).getNb() * (tabla.get(0).getStepNb() / 100));
        niN = tabla.get(0).getNi() + (tabla.get(0).getNi() * (tabla.get(0).getStepNi() / 100));
        yN = tabla.get(0).getY() + (tabla.get(0).getY() * (tabla.get(0).getStepY() / 100));
        vN = tabla.get(0).getV() + (tabla.get(0).getV() * (tabla.get(0).getStepV() / 100));
        zrN = tabla.get(0).getZr() + (tabla.get(0).getZr() * (tabla.get(0).getStepZr() / 100));
         
        int c = 0;
        double minMajor=0.002;
        double minTrace=0.00001;
        do {//ciclo postemplazamiento
            r = new Columnas();
            //2. debo AJUSTAR el nuevo elemento modificado
            sumAdj = sio2N + tio2N + al2o3N + fe2o3N + mnoN + mgoN + caoN + na2oN + k2oN + p2o5N + ((crN + nbN + niN + yN + vN + zrN)/10000);

            //3. revisar si el nuevo elemento ajustado cumple las condiciones básicas de minimo y maximo, si cumple guardarlo
            sio2A = sio2N * (100 / sumAdj);
            if ((sio2A < 100) && (sio2A > 30)) {
                r.setSio2(sio2N);
                r.setSio2A(sio2A);
            } else {
                break;
            }

            tio2A = tio2N * (100 / sumAdj);
            if ((tio2A < 100) && (tio2A > minMajor)) {
                r.setTio2(tio2N);
                r.setTio2A(tio2A);
            } else {
                break;
            }

            al2o3A = al2o3N * (100 / sumAdj);
            if ((al2o3A < 100) && (al2o3A > minMajor)) {
                r.setAl2o3(al2o3N);
                r.setAl2o3A(al2o3A);
            } else {
                break;
            }

            fe2o3A = fe2o3N * (100 / sumAdj);
            if ((fe2o3A < 100) && (fe2o3A > minMajor)) {
                r.setFe2o3(fe2o3N);
                r.setFe2o3tA(fe2o3A);
            } else {
                break;
            }

            mnoA = mnoN * (100 / sumAdj);
            if ((mnoA < 100) && (mnoA > minMajor)) {
                r.setMno(mnoN);
                r.setMnoA(mnoA);
            } else {
                break;
            }

            mgoA = mgoN * (100 / sumAdj);
            if ((mgoA < 100) && (mgoA > minMajor)) {
                r.setMgo(mgoN);
                r.setMgoA(mgoA);
            } else {
                break;
            }

            caoA = caoN * (100 / sumAdj);
            if ((caoA < 100) && (caoA > minMajor)) {
                r.setCao(caoN);
                r.setCaoA(caoA);
            } else {
                break;
            }

            na2oA = na2oN * (100 / sumAdj);
            if ((na2oA < 100) && (na2oA > minMajor)) {
                r.setNa2o(na2oN);
                r.setNa2oA(na2oA);
            } else {
                break;
            }

            k2oA = k2oN * (100 / sumAdj);
            if ((k2oA < 100) && (k2oA > minMajor)) {
                r.setK2o(k2oN);
                r.setK2oA(k2oA);
            } else {
                break;
            }

            p2o5A = p2o5N * (100 / sumAdj);
            if ((p2o5A < 100) && (p2o5A > minMajor)) {
                r.setP2o5(p2o5N);
                r.setP2o5A(p2o5A);
            } else {
                break;
            }
            
            
            crA = crN * (100 / sumAdj)/10000;
            if (crA > minTrace) {
                r.setCr(crN);
                r.setCrmtA(crA);
            } else {
                break;
            }
            nbA = nbN * (100 / sumAdj)/10000;
            if (nbA > minTrace) {
                r.setNb(nbN);
                r.setNbmtA(nbA);
            } else {
                break;
            }            
            niA = niN * (100 / sumAdj)/10000;            
            if (niA > minTrace) {
                r.setNi(niN);
                r.setNimtA(niA);
            } else {
                break;
            }
            //Y, V, Zr
             yA = yN * (100 / sumAdj)/10000;
            if (yA > minTrace) {
                r.setY(yN);
                r.setYmtA(yA);
            } else {
                break;
            }
            
             vA = vN * (100 / sumAdj)/10000;
            if (vA > minTrace) {
                r.setV(vN);
                r.setVmtA(vA);
            } else {
                break;
            }
            zrA = zrN * (100 / sumAdj)/10000;
            if (zrA > minTrace) {
                r.setZr(zrN);
                r.setZrmtA(zrA);
            } else {
                break;
            }
            
            
            
            tabla.add(r);//agrego la nueva fila emplazada a la tabla de salida
            c++;//contador de ietraciones de emplazamiento

            //realizo el siguiente cambio de emplazamiento
            sio2N = r.getSio2() + (r.getSio2() * (tabla.get(0).getStepSio2() / 100));
            tio2N = r.getTio2() + (r.getTio2() * (tabla.get(0).getStepTio2() / 100));
            al2o3N = r.getAl2o3() + (r.getAl2o3() * (tabla.get(0).getStepAl2o3() / 100));
            fe2o3N = r.getFe2o3()+ (r.getFe2o3() * (tabla.get(0).getStepFe2o3() / 100));
            mnoN = r.getMno() + (r.getMno() * (tabla.get(0).getStepMno() / 100));
            mgoN = r.getMgo() + (r.getMgo() * (tabla.get(0).getStepMgo() / 100));
            caoN = r.getCao() + (r.getCao() * (tabla.get(0).getStepCao() / 100));
            na2oN = r.getNa2o() + (r.getNa2o() * (tabla.get(0).getStepNa2o() / 100));
            k2oN = r.getK2o() + (r.getK2o() * (tabla.get(0).getStepK2o() / 100));
            p2o5N = r.getP2o5() + (r.getP2o5() * (tabla.get(0).getStepP2o5() / 100));            
            crN = r.getCr() + (r.getCr() * (tabla.get(0).getStepCr() / 100));
            nbN = r.getNb() + (r.getNb() * (tabla.get(0).getStepNb() / 100));
            niN = r.getNi() + (r.getNi() * (tabla.get(0).getStepNi() / 100));
            yN = r.getY() + (r.getY() * (tabla.get(0).getStepY() / 100));
            vN = r.getV() + (r.getV() * (tabla.get(0).getStepV() / 100));
            zrN = r.getZr() + (r.getZr() * (tabla.get(0).getStepZr() / 100));
            
        } while (true);
    }    
}
