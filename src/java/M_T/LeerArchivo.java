/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

import M_T.Columnas;
//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Abde
 */
public class LeerArchivo {

    private HSSFSheet hssfSheet;
    private HashMap<String, Integer> headers;
    private ArrayList<Columnas> tabla;
    private boolean change;

    public HSSFSheet getHssfSheet() {
        return hssfSheet;
    }

    public void setHssfSheet(HSSFSheet hssfSheet) {
        this.hssfSheet = hssfSheet;
    }

    public HashMap<String, Integer> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, Integer> headers) {
        this.headers = headers;
    }

    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public HSSFSheet leeMT(String fileName, boolean cambia) {

        headers = new HashMap<String, Integer>();
        tabla = new ArrayList<Columnas>();
        change = cambia;
        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            hssfSheet = workBook.getSheetAt(0);

            Iterator rowIterator = hssfSheet.rowIterator();

            HSSFRow hssfRow = (HSSFRow) rowIterator.next();
            Iterator iterator = hssfRow.cellIterator();
            while (iterator.hasNext()) {

                HSSFCell hssfCell = (HSSFCell) iterator.next();

                String stringhssfCell = hssfCell.toString();

                headers.put(stringhssfCell, hssfCell.getColumnIndex());
            }
            validateHeadersMT(headers);
        } catch (Exception e) {
             Messagebox.show("Error in the input file. Download the correct template. "+e);
        }
        return hssfSheet;
    }
    
        public void leeM(String fileName, boolean cambia) {

        headers = new HashMap<String, Integer>();
        tabla = new ArrayList<Columnas>();
        change = cambia;
        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            hssfSheet = workBook.getSheetAt(0);

            Iterator rowIterator = hssfSheet.rowIterator();

            HSSFRow hssfRow = (HSSFRow) rowIterator.next();
            Iterator iterator = hssfRow.cellIterator();
            while (iterator.hasNext()) {
                HSSFCell hssfCell = (HSSFCell) iterator.next();
                String stringhssfCell = hssfCell.toString();
                headers.put(stringhssfCell, hssfCell.getColumnIndex());
            }
            validateHeadersM(headers);
        } catch (Exception e) {
             Messagebox.show("Error in the input file. Download the correct template. "+e);
        }
    }

    public void validateHeadersMT(HashMap headers) {
        Map<String, Integer> h = headers;
        Map<String, Integer> nameCol = new HashMap();
        int i = 1;

        nameCol.put("CONSECUT", 1);
        nameCol.put("Region", 2);
        nameCol.put("SampID", 3);

        nameCol.put("SIO2", 4);
        nameCol.put("TIO2", 5);
        nameCol.put("AL2O3", 6);
        nameCol.put("FE2O3T", 7);
        nameCol.put("MNO", 8);
        nameCol.put("MGO", 9);
        nameCol.put("CAO", 10);
        nameCol.put("NA2O", 11);
        nameCol.put("K2O", 12);
        nameCol.put("P2O5", 13);

        nameCol.put("CR", 14);
        nameCol.put("NB", 15);
        nameCol.put("NI", 16);
        nameCol.put("V", 17);
        nameCol.put("Y", 18);
        nameCol.put("ZR", 19);
        i = 0;
        boolean falta = false;
        String faltante=null;
        for (String column : nameCol.keySet()) {
            if (!h.containsKey(column)) {
                falta = true;
                faltante=h.containsKey(column)+column;
                break;
            } else 
                nameCol.put(column, h.get(column));
            i++;
        }
        if (falta) {
            Messagebox.show("At least one column is missing in the file. "
                    + "The following columns are needed: "
                    + "CONSECUT, Region, SampID, SIO2, TIO2, AL2O3, FE2O3, MNO, MGO, NA2O, K2O, P2O5, CR, NB, NI, V,Y, ZR");

        } else {
            visualizaTablaMT((HashMap) nameCol);
        }
    }
    //AnalizaArchivoOnlyM
    public void validateHeadersM(HashMap headers) {
        Map<String, Integer> h = headers;
        Map<String, Integer> nameCol = new HashMap();
        int i = 1;

        nameCol.put("CONSECUT", 1);
        nameCol.put("Region", 2);
        nameCol.put("SampID", 3);

        nameCol.put("SIO2", 4);
        nameCol.put("TIO2", 5);
        nameCol.put("AL2O3", 6);
        nameCol.put("FE2O3T", 7);
        //nameCol.put("FEO", 8);
        nameCol.put("MNO", 8);
        nameCol.put("MGO", 9);
        nameCol.put("CAO", 10);
        nameCol.put("NA2O", 11);
        nameCol.put("K2O", 12);
        nameCol.put("P2O5", 13);
        
        i = 0;
        boolean falta = false;
        for (String column : nameCol.keySet()) {
            if (!h.containsKey(column)) {
                falta = true;
                break;
            } else {
                nameCol.put(column, h.get(column));
            }
            i++;
        }
        if (falta) {
            Messagebox.show("At least one column is missing in the file. Download the correct template. "
                    + "The following columns are needed: "
                    + "CONSECUT, Region, SampID, SIO2, TIO2, AL2O3, FE2O3, MNO, MGO, NA2O, K2O, P2O5.");

        } else {
            visualizaTablaM((HashMap) nameCol);
        }
    }

    public void visualizaTablaMT(HashMap columnas) {

        Iterator rowIterator = hssfSheet.rowIterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Object consecut,region,sampID,sio2,tio2,al2o3,fe2o3t,mno,mgo, cao, na2o, k2o, p2o5, cr, nb, ni,v,y,zr;

            HSSFRow hssfRow = (HSSFRow) rowIterator.next();

            Columnas row = new Columnas();
            //Object val;
            try {
                consecut = addCell(hssfRow, columnas, "CONSECUT", 1);
                row.setConsecut(((Double) consecut).intValue());
            } catch (Exception ex) {             
            }
            try {
                region = addCell(hssfRow, columnas, "Region", 2);
                row.setLocality((String) region);
            } catch (Exception ex) {
                //row.setLocality(" ");
            }
            try {
                sampID = addCell(hssfRow, columnas, "SampID", 2);
                row.setSampID((String) sampID);
            } catch (Exception ex) {
                //row.setLocality(" ");
            }
            
            try {
                sio2 = addCell(hssfRow, columnas, "SIO2", 1);
                row.setSio2((Double) sio2);
            } catch (Exception ex) {
                //row.setSio2(0.0);
            }
            try {
                tio2 = addCell(hssfRow, columnas, "TIO2", 1);
                row.setTio2((Double) tio2);
            } catch (Exception ex) {
                //row.setTio2(0.0);
            }
            try {
                al2o3 = addCell(hssfRow, columnas, "AL2O3", 1);
                row.setAl2o3((Double) al2o3);
            } catch (Exception ex) {
                //row.setAl2o3(0.0);
            }
            try {
                fe2o3t = addCell(hssfRow, columnas, "FE2O3T", 1);
                row.setFe2o3((Double) fe2o3t);
            } catch (Exception ex) {
                //row.setFe2o3(0.0);
            }
          
            try {
                mno = addCell(hssfRow, columnas, "MNO", 1);
                row.setMno((Double) mno);
            } catch (Exception ex) {
                //row.setMno(0.0);
            }
            try {
                mgo = addCell(hssfRow, columnas, "MGO", 1);
                row.setMgo((Double) mgo);
            } catch (Exception ex) {
                //row.setMgo(0.0);
            }
            try {
                cao = addCell(hssfRow, columnas, "CAO", 1);
                row.setCao((Double) cao);
            } catch (Exception ex) {
                //row.setCao(0.0);
            }  
            try {
                na2o = addCell(hssfRow, columnas, "NA2O", 1);
                row.setNa2o((Double) na2o);
            } catch (Exception ex) {
                //row.setNa2o(0.0);
            }
            try {
                k2o = addCell(hssfRow, columnas, "K2O", 1);
                row.setK2o((Double) k2o);
            } catch (Exception ex) {
                //row.setK2o(0.0);
            }
            try {
                p2o5 = addCell(hssfRow, columnas, "P2O5", 1);
                row.setP2o5((Double) p2o5);
            } catch (Exception ex) {
                //row.setP2o5(0.0);
            }
            try { 
                cr = addCell(hssfRow, columnas, "CR", 1);
                row.setCr((Double) cr);
                nb = addCell(hssfRow, columnas, "NB", 1);
                row.setNb((Double) nb);
                ni = addCell(hssfRow, columnas, "NI", 1);
                row.setNi((Double) ni);
                v = addCell(hssfRow, columnas, "V", 1);
                row.setV((Double) v);
                y = addCell(hssfRow, columnas, "Y", 1);
                row.setY((Double) y);
                zr = addCell(hssfRow, columnas, "ZR", 1);
                row.setZr((Double) zr);
            } catch (Exception ex) {
                /*row.setCr(0.0);
                row.setNb(0.0);
                row.setNi(0.0);
                row.setV(0.0);
                row.setY(0.0);
                row.setZr(0.0);*/

            }
            tabla.add(row);
           
        }
    }

    
    public void visualizaTablaM(HashMap columnas) {

        Iterator rowIterator = hssfSheet.rowIterator();
        rowIterator.next();
        while (rowIterator.hasNext()) {

            HSSFRow hssfRow = (HSSFRow) rowIterator.next();

            Columnas row = new Columnas();
            Object val;
            try {
                val = addCell(hssfRow, columnas, "CONSECUT", 1);
                row.setConsecut(((Double) val).intValue());
            } catch (Exception ex) {
                row.setConsecut(((Double) 0.0).intValue());
            }
            try {
                val = addCell(hssfRow, columnas, "Region", 2);
                row.setLocality((String) val);
            } catch (Exception ex) {
                row.setLocality(" ");
            }
            val = addCellVerifica(hssfRow, columnas, "SampID", 2);
            
            if (val==(null)){
                break;
            }else{
                row.setSampID((String) val);}
            try {
                val = addCell(hssfRow, columnas, "SIO2", 1);
                row.setSio2((Double) val);
            } catch (Exception ex) {
                row.setSio2(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "TIO2", 1);
                row.setTio2((Double) val);
            } catch (Exception ex) {
                row.setTio2(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "AL2O3", 1);
                row.setAl2o3((Double) val);
            } catch (Exception ex) {
                row.setAl2o3(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "FE2O3T", 1);
                row.setFe2o3((Double) val);
            } catch (Exception ex) {
                row.setFe2o3(0.0);
            }
            
            try {
                val = addCell(hssfRow, columnas, "MNO", 1);
                row.setMno((Double) val);
            } catch (Exception ex) {
                row.setMno(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "MGO", 1);
                row.setMgo((Double) val);
            } catch (Exception ex) {
                row.setMgo(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "CAO", 1);
                row.setCao((Double) val);
            } catch (Exception ex) {
                row.setCao(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "NA2O", 1);
                row.setNa2o((Double) val);
            } catch (Exception ex) {
                row.setNa2o(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "K2O", 1);
                row.setK2o((Double) val);
            } catch (Exception ex) {
                row.setK2o(0.0);
            }
            try {
                val = addCell(hssfRow, columnas, "P2O5", 1);
                row.setP2o5((Double) val);
            } catch (Exception ex) {
                row.setP2o5(0.0);
            }
            
            tabla.add(row);
           
        }
    }

   
    public Object addCell(HSSFRow hssfRow, HashMap columnas, String key, int tipo) {
        Object result = null;
        int num = (Integer) columnas.get(key);
        HSSFCell hssfCell = hssfRow.getCell(num);
        String col = hssfCell.toString();

        if (tipo == 1) 
            if (!"".equals(col)) {//si encuentra  vacíos, devuelve ceros y después filtrar los ceros
                Double val = Double.parseDouble(col);
                result = val;
            }else result=0;
        else if (!"".equals(col)) //en celdas String si encuentra  vacíos, devuelve null             
                result = col;
        else result=null;
        return result;
    }
    
    public Object addCellVerifica(HSSFRow hssfRow, HashMap columnas, String key, int tipo) {
        Object result = null;
        HSSFCell hssfCell = hssfRow.getCell((Integer) columnas.get(key));
        String col = hssfCell.toString();
            if ("".equals(col)) {
                result = null;
            } else {
                result = col;
            }
        return result;
    }

}
