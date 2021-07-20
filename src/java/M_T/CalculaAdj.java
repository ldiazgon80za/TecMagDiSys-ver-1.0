/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

import java.util.ArrayList;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Abde
 */
public class CalculaAdj {

    private ArrayList<Columnas> tabla;

    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public CalculaAdj( ArrayList<Columnas> tabla){
        this.tabla = tabla;
    }
    
    public ArrayList<Columnas> ajusteM() {
        double sio2, tio2, al2o3, fe2o3, mno, mgo, cao, na2o, k2o, p2o5;        
        Columnas r = new Columnas();        

        for (int j = 0; j < tabla.size(); j++) {
            r = tabla.get(j);

            fe2o3 = r.getFe2o3();
            sio2 = r.getSio2();	//tabla, renglÃ³n, columna
            tio2 = r.getTio2();
            al2o3 = r.getAl2o3();
            mno = r.getMno();
            mgo = r.getMgo();
            cao = r.getCao();
            na2o = r.getNa2o();
            k2o = r.getK2o();
            p2o5 = r.getP2o5();
          
            double sumAdj = sio2 + tio2 + al2o3 + fe2o3 + mno + mgo + cao + na2o + k2o + p2o5;
          
            r.setSio2A(sio2 * (100 / sumAdj));
            r.setTio2A(tio2 * (100 / sumAdj));
            r.setAl2o3A(al2o3 * (100 / sumAdj));
            r.setFe2o3tA(fe2o3 * (100 / sumAdj));
            r.setMnoA(mno * (100 / sumAdj));
            r.setMgoA(mgo * (100 / sumAdj));
            r.setCaoA(cao * (100 / sumAdj));
            r.setNa2oA(na2o * (100 / sumAdj));
            r.setK2oA(k2o * (100 / sumAdj));
            r.setP2o5A(p2o5 * (100 / sumAdj));         
        }
        return tabla;
    }

    
    public ArrayList<Columnas> ajusteIlrM() {
        double sio2, tio2, al2o3, fe2o3, mno, mgo, cao, na2o, k2o, p2o5;        
        Columnas r = new Columnas();        

        for (int j = 0; j < tabla.size(); j++) {
            r = tabla.get(j);

            fe2o3 = r.getFe2o3();
            sio2 = r.getSio2();	//tabla, renglÃ³n, columna
            tio2 = r.getTio2();
            al2o3 = r.getAl2o3();
            mno = r.getMno();
            mgo = r.getMgo();
            cao = r.getCao();
            na2o = r.getNa2o();
            k2o = r.getK2o();
            p2o5 = r.getP2o5();
          
            double sumAdj = sio2 + tio2 + al2o3 + fe2o3 + mno + mgo + cao + na2o + k2o + p2o5;
          
            r.setSio2A(sio2 * (100 / sumAdj));
            r.setTio2A(tio2 * (100 / sumAdj));
            r.setAl2o3A(al2o3 * (100 / sumAdj));
            r.setFe2o3tA(fe2o3 * (100 / sumAdj));
            r.setMnoA(mno * (100 / sumAdj));
            r.setMgoA(mgo * (100 / sumAdj));
            r.setCaoA(cao * (100 / sumAdj));
            r.setNa2oA(na2o * (100 / sumAdj));
            r.setK2oA(k2o * (100 / sumAdj));
            r.setP2o5A(p2o5 * (100 / sumAdj));

            ilrM(r, j);  
            //Messagebox.show("ajusteIlrM()---ilrM(r, j);  ");
        }
        return tabla;
    }

 
    public void ilrM(Columnas ilr, int j) {        
        double mult=0;
        mult = tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A() * tabla.get(j).getFe2o3tA() * tabla.get(j).getMnoA()
                * tabla.get(j).getMgoA() * tabla.get(j).getCaoA() * tabla.get(j).getNa2oA() * tabla.get(j).getK2oA() * tabla.get(j).getP2o5A();

        if (mult != 0) {
            ilr.setIlrTiM(Math.sqrt(1.0 / 2.0) * Math.log(tabla.get(j).getSio2A() / tabla.get(j).getTio2A()));
            ilr.setIlrAlM(Math.sqrt(2.0 / 3.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A(), 1.0 / 2.0)) / tabla.get(j).getAl2o3A()));
            ilr.setIlrFeTM(Math.sqrt(3.0 / 4.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A(), 1.0 / 3.0)) / tabla.get(j).getFe2o3tA()));
            ilr.setIlrMnM(Math.sqrt(4.0 / 5.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A() * tabla.get(j).getFe2o3tA(), 1.0 / 4.0)) / tabla.get(j).getMnoA()));
            ilr.setIlrMgM(Math.sqrt(5.0 / 6.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A() * tabla.get(j).getFe2o3tA() * tabla.get(j).getMnoA(), 1.0 / 5.0)) / tabla.get(j).getMgoA()));
            ilr.setIlrCaM(Math.sqrt(6.0 / 7.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A() * tabla.get(j).getFe2o3tA() * tabla.get(j).getMnoA() * tabla.get(j).getMgoA(), 1.0 / 6.0)) / tabla.get(j).getCaoA()));
            ilr.setIlrNaM(Math.sqrt(7.0 / 8.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A() * tabla.get(j).getFe2o3tA() * tabla.get(j).getMnoA() * tabla.get(j).getMgoA() * tabla.get(j).getCaoA(), 1.0 / 7.0)) / tabla.get(j).getNa2oA()));
            ilr.setIlrKM(Math.sqrt(8.0 / 9.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A() * tabla.get(j).getFe2o3tA() * tabla.get(j).getMnoA() * tabla.get(j).getMgoA() * tabla.get(j).getCaoA() * tabla.get(j).getNa2oA(), 1.0 / 8.0)) / tabla.get(j).getK2oA()));
            ilr.setIlrPM(Math.sqrt(9.0 / 10.0) * Math.log((Math.pow(tabla.get(j).getSio2A() * tabla.get(j).getTio2A() * tabla.get(j).getAl2o3A() * tabla.get(j).getFe2o3tA() * tabla.get(j).getMnoA() * tabla.get(j).getMgoA() * tabla.get(j).getCaoA() * tabla.get(j).getNa2oA() * tabla.get(j).getK2oA(), 1.0 / 9.0)) / tabla.get(j).getP2o5A()));
            
        } else {
            ilr.setIlrTiM(0.0);
            ilr.setIlrAlM(0.0);
            ilr.setIlrFeTM(0.0);
            ilr.setIlrMnM(0.0);
            ilr.setIlrMgM(0.0);
            ilr.setIlrCaM(0.0);
            ilr.setIlrNaM(0.0);
            ilr.setIlrKM(0.0);
            ilr.setIlrPM(0.0);          
           Messagebox.show("Error in elements ");
        }

    }

    public ArrayList<Columnas> ajusteMT() {
        double sio2, tio2, al2o3, fe2o3, mno, mgo, cao, na2o, k2o, p2o5, cr, nb, ni, y, v, zr;
        Columnas r = new Columnas();      

        for (int j = 0; j < tabla.size(); j++) {

            r = tabla.get(j);
            sio2 = r.getSio2();	//tabla, renglÃ³n, columna
            tio2 = r.getTio2();
            al2o3 = r.getAl2o3();
            fe2o3 = r.getFe2o3();
            mno = r.getMno();
            mgo = r.getMgo();
            cao = r.getCao();
            na2o = r.getNa2o();
            k2o = r.getK2o();
            p2o5 = r.getP2o5();
            cr = r.getCr() / 10000;
            nb = r.getNb() / 10000;
            ni = r.getNi() / 10000;
            y = r.getY() / 10000;
            v = r.getV() / 10000;
            zr = r.getZr() / 10000;
           
            double sum = sio2 + tio2 + al2o3 + fe2o3 + mno + mgo + cao + na2o + k2o + p2o5 + cr + nb + ni + y + v + zr;
      

            r.setSio2mtA(sio2 * 100 / sum);
            r.setTio2mtA(tio2 * 100 / sum);
            r.setAl2o3mtA(al2o3 * 100 / sum);
            r.setFe2o3tmtA(fe2o3 * 100 / sum);
            r.setMnomtA(mno * 100 / sum);
            r.setMgomtA(mgo * 100 / sum);
            r.setCaomtA(cao * 100 / sum);
            r.setNa2omtA(na2o * 100 / sum);
            r.setK2omtA(k2o * 100 / sum);
            r.setP2o5mtA(p2o5 * 100 / sum);
            r.setCrmtA(cr * 100 / sum);
            r.setNbmtA(nb * 100 / sum);
            r.setNimtA(ni * 100 / sum);
            r.setYmtA(y * 100 / sum);
            r.setVmtA(v * 100 / sum);
            r.setZrmtA(zr * 100 / sum);
        }
        return tabla;
    }
 
     
    public ArrayList<Columnas> ajusteIlrMT() {
        double sio2, tio2, al2o3, fe2o3, mno, mgo, cao, na2o, k2o, p2o5, cr, nb, ni, y, v, zr;
        Columnas r = new Columnas();      

        for (int j = 0; j < tabla.size(); j++) {

            r = tabla.get(j);
            sio2 = r.getSio2();	//tabla, renglÃ³n, columna
            tio2 = r.getTio2();
            al2o3 = r.getAl2o3();
            fe2o3 = r.getFe2o3();
            mno = r.getMno();
            mgo = r.getMgo();
            cao = r.getCao();
            na2o = r.getNa2o();
            k2o = r.getK2o();
            p2o5 = r.getP2o5();
            cr = r.getCr() / 10000;
            nb = r.getNb() / 10000;
            ni = r.getNi() / 10000;
            y = r.getY() / 10000;
            v = r.getV() / 10000;
            zr = r.getZr() / 10000;

            double sum = sio2 + tio2 + al2o3 + fe2o3 + mno + mgo + cao + na2o + k2o + p2o5 + cr + nb + ni + y + v + zr;
 
            r.setSio2mtA(sio2 * 100 / sum);
            r.setTio2mtA(tio2 * 100 / sum);
            r.setAl2o3mtA(al2o3 * 100 / sum);
            r.setFe2o3tmtA(fe2o3 * 100 / sum);
            r.setMnomtA(mno * 100 / sum);
            r.setMgomtA(mgo * 100 / sum);
            r.setCaomtA(cao * 100 / sum);
            r.setNa2omtA(na2o * 100 / sum);
            r.setK2omtA(k2o * 100 / sum);
            r.setP2o5mtA(p2o5 * 100 / sum);
            r.setCrmtA(cr * 100 / sum);
            r.setNbmtA(nb * 100 / sum);
            r.setNimtA(ni * 100 / sum);
            r.setYmtA(y * 100 / sum);
            r.setVmtA(v * 100 / sum);
            r.setZrmtA(zr * 100 / sum);
            ilrMT(r, j);            
        }
        return tabla;
    }    
    
    public ArrayList<Columnas> ajusteIlrMTprop() {
        double sio2, tio2, al2o3, fe2o3, mno, mgo, cao, na2o, k2o, p2o5, cr, nb, ni, y, v, zr;
        Columnas r = new Columnas();      

        for (int j = 0; j < tabla.size(); j++) {

            r = tabla.get(j);
            sio2 = r.getSio2();	//tabla, renglÃ³n, columna
            tio2 = r.getTio2();
            al2o3 = r.getAl2o3();
            fe2o3 = r.getFe2o3();
            mno = r.getMno();
            mgo = r.getMgo();
            cao = r.getCao();
            na2o = r.getNa2o();
            k2o = r.getK2o();
            p2o5 = r.getP2o5();
            cr = r.getCr();
            nb = r.getNb();
            ni = r.getNi();
            y = r.getY();
            v = r.getV();
            zr = r.getZr();

            double sum = sio2 + tio2 + al2o3 + fe2o3 + mno + mgo + cao + na2o + k2o + p2o5 + cr + nb + ni + y + v + zr;
 
            r.setSio2mtA(sio2 * 100 / sum);
            r.setTio2mtA(tio2 * 100 / sum);
            r.setAl2o3mtA(al2o3 * 100 / sum);
            r.setFe2o3tmtA(fe2o3 * 100 / sum);
            r.setMnomtA(mno * 100 / sum);
            r.setMgomtA(mgo * 100 / sum);
            r.setCaomtA(cao * 100 / sum);
            r.setNa2omtA(na2o * 100 / sum);
            r.setK2omtA(k2o * 100 / sum);
            r.setP2o5mtA(p2o5 * 100 / sum);
            r.setCrmtA(cr * 100 / sum);
            r.setNbmtA(nb * 100 / sum);
            r.setNimtA(ni * 100 / sum);
            r.setYmtA(y * 100 / sum);
            r.setVmtA(v * 100 / sum);
            r.setZrmtA(zr * 100 / sum);
            ilrMT(r, j);            
        }
        return tabla;
    }
 
    
    public void ilrMT(Columnas ilr, int j) {

        double mult, sio2, tio2, al2o3, fe2o3, mno, mgo, cao, na2o, k2o, p2o5, cr, nb, ni, y, v, zr;

        mult = 0;

        mult = tabla.get(j).getSio2mtA() * tabla.get(j).getTio2mtA() * tabla.get(j).getAl2o3mtA() * tabla.get(j).getFe2o3tmtA() * tabla.get(j).getMnomtA()
                * tabla.get(j).getMgomtA() * tabla.get(j).getCaomtA() * tabla.get(j).getNa2omtA() * tabla.get(j).getK2omtA() * tabla.get(j).getP2o5mtA()
                * tabla.get(j).getCrmtA() * tabla.get(j).getNbmtA() * tabla.get(j).getNimtA() * tabla.get(j).getVmtA() * tabla.get(j).getYmtA() * tabla.get(j).getZrmtA();

        if (mult != 0) {
            Columnas r = tabla.get(j);
            sio2 = r.getSio2mtA();	
            tio2 = r.getTio2mtA();
            al2o3 = r.getAl2o3mtA();
            fe2o3 = r.getFe2o3tmtA();
            mno = r.getMnomtA();
            mgo = r.getMgomtA();
            cao = r.getCaomtA();
            na2o = r.getNa2omtA();
            k2o = r.getK2omtA();
            p2o5 = r.getP2o5mtA();            
            cr = r.getCrmtA();
            nb = r.getNbmtA();
            ni = r.getNimtA();            
            v = r.getVmtA();
            y = r.getYmtA();
            zr = r.getZrmtA();
            
            ilr.setIlrTiMT(Math.sqrt    (1.0 / 2.0) *   Math.log(sio2 / tio2));
            ilr.setIlrAlMT(Math.sqrt    (2.0 / 3.0) *   Math.log((Math.pow(sio2 * tio2, 1.0 / 2.0)) / al2o3));
            ilr.setIlrFeTMT(Math.sqrt   (3.0 / 4.0) *   Math.log((Math.pow(sio2 * tio2 * al2o3, 1.0 / 3.0)) / fe2o3));
            ilr.setIlrMnMT(Math.sqrt    (4.0 / 5.0) *   Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3, 1.0 / 4.0)) / mno));
            ilr.setIlrMgMT(Math.sqrt    (5.0 / 6.0) *   Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno, 1.0 / 5.0)) / mgo));
            ilr.setIlrCaMT(Math.sqrt    (6.0 / 7.0) *   Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo, 1.0 / 6.0)) / cao));
            ilr.setIlrNaMT(Math.sqrt    (7.0 / 8.0) *   Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao, 1.0 / 7.0)) / na2o));
            ilr.setIlrKMT(Math.sqrt     (8.0 / 9.0) *   Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o, 1.0 / 8.0)) / k2o));
            ilr.setIlrPMT(Math.sqrt     (9.0 / 10.0) *  Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o * k2o, 1.0 / 9.0)) / p2o5));
            ilr.setIlrCrMT(Math.sqrt    (10.0 / 11.0) * Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o * k2o * p2o5, 1.0 / 10.0)) / cr));
            ilr.setIlrNbMT(Math.sqrt    (11.0 / 12.0) * Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o * k2o * p2o5 * cr, 1.0 / 11.0)) / nb));
            ilr.setIlrNiMT(Math.sqrt    (12.0 / 13.0) * Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o * k2o * p2o5 * cr * nb, 1.0 / 12.0)) / ni));
            ilr.setIlrVMT(Math.sqrt     (13.0 / 14.0) * Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o * k2o * p2o5 * cr * nb * ni, 1.0 / 13.0)) / v));
            ilr.setIlrYMT(Math.sqrt     (14.0 / 15.0) * Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o * k2o * p2o5 * cr * nb * ni * v, 1.0 / 14.0)) / y));
            ilr.setIlrZrMT(Math.sqrt    (15.0 / 16.0) * Math.log((Math.pow(sio2 * tio2 * al2o3 * fe2o3 * mno * mgo * cao * na2o * k2o * p2o5 * cr * nb * ni * v * y, 1.0 / 15.0)) / zr));
        } else {
            ilr.setIlrTiMT(0.0);
            ilr.setIlrAlMT(0.0);
            ilr.setIlrFeTMT(0.0);
            ilr.setIlrMnMT(0.0);
            ilr.setIlrMgMT(0.0);
            ilr.setIlrCaMT(0.0);
            ilr.setIlrNaMT(0.0);
            ilr.setIlrKMT(0.0);
            ilr.setIlrPMT(0.0);
            ilr.setIlrCrMT(0.0);
            ilr.setIlrNiMT(0.0);
            ilr.setIlrNbMT(0.0);
            ilr.setIlrVMT(0.0);
            ilr.setIlrYMT(0.0);
            ilr.setIlrZrMT(0.0);
        }
    }

}
