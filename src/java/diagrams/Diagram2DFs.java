/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diagrams;
import M_T.Columnas;
import java.util.ArrayList;
/**
 *
 * @author Lorena
 */

public abstract class Diagram2DFs {   
    /*private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    private ArrayList<Columnas> tabla;
    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }  
    */
    abstract public void  calculaDFsM();
    
    abstract public void calculaProbabilitiesM();
    
    //para MT
    abstract public void  calculaDFsMT();
    
    abstract public void calculaProbabilitiesMT();
       
}
  