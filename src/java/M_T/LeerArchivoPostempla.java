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
public class LeerArchivoPostempla {

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

    public void lee(String fileName, boolean banMT) {

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

            analizaArchivoPostempla(headers, banMT);

        } catch (Exception e) {
            Messagebox.show("Error in input file. Download the correct template." + e);
        }

    }

    public void analizaArchivoPostempla(HashMap headers, boolean banMT) {
        Map<String, Integer> h = headers;
        Map<String, Integer> colName = new HashMap();
        colName.put("Element", 1);
        colName.put("Sample", 2);
        colName.put("Step (gain/loss)", 3);
        int i = 0;
        boolean falta = false;
        for (String column : colName.keySet()) {
            if (!h.containsKey(column)) {
                falta = true;
                break;
            } else {
                colName.put(column, h.get(column));
                // System.out.println(column + "=" + name_col.get(column));
            }
            i++;
        }
        if (falta) {
            Messagebox.show("Error in input file. Download the correct template.");

        } else {
            visualizaTabla((HashMap) colName, banMT);
        }
    }

    public void visualizaTabla(HashMap hashMapColumnas, boolean banMT) {

        boolean flag = false;
        Iterator rowIterator = hssfSheet.rowIterator();
        rowIterator.next();

        HSSFRow hssfRow = (HSSFRow) rowIterator.next();
        String kSample = "Sample";
        String kStep = "Step (gain/loss)";

        Columnas row = new Columnas();
        Object val;
        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setSio2((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }

        row.setStepSio2((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setTio2((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepTio2((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setAl2o3((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepAl2o3((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setFe2o3((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepFe2o3((Double) val);

//falta agregar el otro feo
        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setMno((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepMno((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setMgo((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepMgo((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setCao((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepCao((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setNa2o((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepNa2o((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setK2o((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepK2o((Double) val);

        hssfRow = (HSSFRow) rowIterator.next();
        val = addCell(hssfRow, hashMapColumnas, kSample);
        row.setP2o5((Double) val);
        val = addCell(hssfRow, hashMapColumnas, kStep);
        if ((Double) val == 0.0 || ((Double) val).equals(0)) {
            flag = true;
        } else {
            flag = false;
        }
        row.setStepP2o5((Double) val);

        if (banMT) {
            hssfRow = (HSSFRow) rowIterator.next();
            val = addCell(hssfRow, hashMapColumnas, kSample);
            row.setCr((Double) val);
            val = addCell(hssfRow, hashMapColumnas, kStep);
            if ((Double) val == 0.0 || ((Double) val).equals(0)) {
                flag = true;
            } else {
                flag = false;
            }
            row.setStepCr((Double) val);

            hssfRow = (HSSFRow) rowIterator.next();
            val = addCell(hssfRow, hashMapColumnas, kSample);
            row.setNb((Double) val);
            val = addCell(hssfRow, hashMapColumnas, kStep);
            if ((Double) val == 0.0 || ((Double) val).equals(0)) {
                flag = true;
            } else {
                flag = false;
            }
            row.setStepNb((Double) val);

            hssfRow = (HSSFRow) rowIterator.next();
            val = addCell(hssfRow, hashMapColumnas, kSample);
            row.setNi((Double) val);
            val = addCell(hssfRow, hashMapColumnas, kStep);
            if ((Double) val == 0.0 || ((Double) val).equals(0)) {
                flag = true;
            } else {
                flag = false;
            }
            row.setStepNi((Double) val);

            hssfRow = (HSSFRow) rowIterator.next();
            val = addCell(hssfRow, hashMapColumnas, kSample);
            row.setV((Double) val);
            val = addCell(hssfRow, hashMapColumnas, kStep);
            if ((Double) val == 0.0 || ((Double) val).equals(0)) {
                flag = true;
            } else {
                flag = false;
            }
            row.setStepV((Double) val);

            hssfRow = (HSSFRow) rowIterator.next();
            val = addCell(hssfRow, hashMapColumnas, kSample);
            row.setY((Double) val);
            val = addCell(hssfRow, hashMapColumnas, kStep);
            if ((Double) val == 0.0 || ((Double) val).equals(0)) {
                flag = true;
            } else {
                flag = false;
            }
            row.setStepY((Double) val);

            hssfRow = (HSSFRow) rowIterator.next();
            val = addCell(hssfRow, hashMapColumnas, kSample);
            row.setZr((Double) val);
            val = addCell(hssfRow, hashMapColumnas, kStep);
            if ((Double) val == 0.0 || ((Double) val).equals(0)) {
                flag = true;
            } else {
                flag = false;
            }
            row.setStepZr((Double) val);
        }

        tabla.add(row);

    }

    public Object addCell(HSSFRow hssfRow, HashMap columnas, String key) {
        Object result = null;
        int num = (Integer) columnas.get(key);

        HSSFCell hssfCell = hssfRow.getCell(num);
        String col = hssfCell.toString();

        if ("".equals(col)) {
            result = 0.0;
        } else {
            Double val = Double.parseDouble(col);
            result = val;
        }
        return result;
    }

}
