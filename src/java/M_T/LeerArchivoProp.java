/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

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
public class LeerArchivoProp {
    private HSSFSheet hssfSheet;
    private HashMap<String, Integer> headers;
    private ArrayList<Columnas> tabla;

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

    public void lee(String fileName) {

        headers = new HashMap<String, Integer>();
        tabla = new ArrayList<Columnas>();

        try {

            FileInputStream fileInputStream = new FileInputStream(fileName);
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            hssfSheet = workBook.getSheetAt(0);

            Iterator rowIterator = hssfSheet.rowIterator();

            HSSFRow hssfRow = (HSSFRow) rowIterator.next();
            hssfRow = (HSSFRow) rowIterator.next();
            Iterator iterator = hssfRow.cellIterator();
            while (iterator.hasNext()) {
                HSSFCell hssfCell = (HSSFCell) iterator.next();
                String stringhssfCell = hssfCell.toString();
                headers.put(stringhssfCell, hssfCell.getColumnIndex());
            }
            analizaArchivo(headers);

        } catch (Exception e) {
            System.out.println("error" + e);
            Messagebox.show("Error in LeerArchivoProp.lee()" + e);

        }

    }
//seguir revisando si la vía de abrir un archivo de prop de M es igual para MT....
    public void analizaArchivo(HashMap headers) {
        Map<String, Integer> h = headers;
        Map<String, Integer> nameCol = new HashMap();
        int i = 0;

        nameCol.put("Element", 1);
        nameCol.put("Sample", 2);
        nameCol.put("uC", 3);        
        //nameCol.put("RSD%",4);
        
        boolean falta = false;
        for (String column : nameCol.keySet()) {
            if (!h.containsKey(column)) {
                falta = true;
                break;
            } else {
                nameCol.put(column, h.get(column));
                System.out.println(column + "=" + nameCol.get(column));
            }
            i++;
        }
        if (falta) {
            System.out.println("no es el archivo correcto");
            Messagebox.show("Error in LeerArchivoProp.analizaArchivo()");

        } else {
            visualizaTabla((HashMap) nameCol);
        }
    }

    public void visualizaTabla(HashMap columnas) {

        Iterator rowIterator = hssfSheet.rowIterator();
        rowIterator.next();

        HSSFRow hssfRow = (HSSFRow) rowIterator.next();

        Columnas row = new Columnas();
        Object val;
        hssfRow = (HSSFRow) rowIterator.next();
          val = addCell(hssfRow, columnas, "Sample", 1);
        row.setSio2((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcSio2((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdSIO2((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setTio2((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcTio2((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdTIO2((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setAl2o3((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcAl2o3((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdAL2O3((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setFe2o3((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcFe2o3((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdFE2O3((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setMno((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcMno((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdMNO((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setMgo((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcMgo((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdMGO((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setCao((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcCao((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdCAO((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setNa2o((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcNa2o((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdNA2O((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setK2o((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcK2o((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
       // row.setRsdK2O((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setP2o5((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcP2o5((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdP2O5((Double) val);

       
        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setCr((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcCr((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdCr((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setNb((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcNb((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdNb((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setNi((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcNi((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdNi((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);;
        row.setV((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcV((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdV((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setY((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcY((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdY((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, columnas, "Sample", 1);
        row.setZr((Double) val);
        val = addCell(hssfRow, columnas, "uC", 1);
        row.setUcZr((Double) val);
        //val = addCell(hssfRow, columnas, "RSD%", 1);
        //row.setRsdZr((Double) val);

        tabla.add(row);

    }

    public Object addCell(HSSFRow hssfRow, HashMap columnas, String key, int tipo) {
        Object result = null;
        int num = (Integer) columnas.get(key);

        HSSFCell hssfCell = hssfRow.getCell(num);
        //System.out.println("numcell=" + hssfCell.getColumnIndex() + " tipo" + hssfCell.getCellType());

        String col = hssfCell.toString();

        if (tipo == 1) {
            if ("".equals(col)) {
                result = 0.0;
            } else {

                Double val = Double.parseDouble(col);
                result = val;
            }
        } else {
            if ("".equals(col)) {
                result = " ";
            } else {
                result = col;
            }

        }

        return result;
    }    
}
