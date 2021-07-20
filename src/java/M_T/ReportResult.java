/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

import M_T.Columnas;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.zkoss.util.media.AMedia;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Abde
 */
public class ReportResult {

    private ArrayList<Columnas> tabla;
    public HSSFSheet hssfSheet, hssfSheetMT;

    public ReportResult(ArrayList<Columnas> tabla){
        this.tabla = tabla;
    }
    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }
  
    public void reportM(String filePath) {
        try {
           
            FileInputStream fileInputStream = new FileInputStream(filePath);
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            hssfSheet = workBook.getSheetAt(0);
            
            HSSFFont font2 = workBook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(font2.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2 = workBook.createCellStyle();
            style2.setVerticalAlignment(style2.VERTICAL_CENTER);
            style2.setAlignment(style2.ALIGN_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);
            
            HSSFFont font3 = workBook.createFont();
            font3.setColor(HSSFColor.RED.index);
            font3.setBoldweight(font3.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workBook.createCellStyle();
            style3.setVerticalAlignment(style3.VERTICAL_CENTER);
            style3.setAlignment(style3.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);
            
            HSSFFont font4 = workBook.createFont();
            font4.setColor(HSSFColor.GREEN.index);
            font4.setBoldweight(font4.BOLDWEIGHT_BOLD);
            HSSFCellStyle style4 = workBook.createCellStyle();
            style4.setVerticalAlignment(style4.VERTICAL_CENTER);
            style4.setAlignment(style4.ALIGN_CENTER);
            style4.setWrapText(true);
            style4.setFont(font4);
            
            HSSFFont font5 = workBook.createFont();
            font5.setColor(HSSFColor.BROWN.index);
            font5.setBoldweight(font5.BOLDWEIGHT_BOLD);
            HSSFCellStyle style5 = workBook.createCellStyle();
            style5.setVerticalAlignment(style5.VERTICAL_CENTER);
            style5.setAlignment(style5.ALIGN_CENTER);
            style5.setWrapText(true);
            style5.setFont(font5);
            
            Iterator rowIterator = hssfSheet.rowIterator();
            HSSFRow hssfRow = (HSSFRow) rowIterator.next();
            int nc, ncreg;
            HSSFCell hssfCell;

            nc = hssfRow.getLastCellNum();
            ncreg = hssfRow.getLastCellNum();
            nc=19;
            hssfRow.createCell(nc);
            hssfCell = hssfRow.getCell(nc);

            insertFile("Adj major start here", hssfCell, hssfRow, nc++, style2);            
            insertFile("SIO2adj", hssfCell, hssfRow, nc++, style2);
            insertFile("TIO2adj", hssfCell, hssfRow, nc++, style2);
            insertFile("AL2O3adj", hssfCell, hssfRow, nc++, style2);
            insertFile("FE2O3Tadj", hssfCell, hssfRow, nc++, style2);
            insertFile("MNOadj", hssfCell, hssfRow, nc++, style2);
            insertFile("MGOadj", hssfCell, hssfRow, nc++, style2);
            insertFile("CAOadj", hssfCell, hssfRow, nc++, style2);
            insertFile("NA2Oadj", hssfCell, hssfRow, nc++, style2);
            insertFile("K2Oadj", hssfCell, hssfRow, nc++, style2);
            insertFile("P2O5adj", hssfCell, hssfRow, nc++, style2);
            
            insertFile("Ilr major start here", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrTIO2", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrAL2O3", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrFE2O3T", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrMNO", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrMGO", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrCAO", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrNA2O", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrK2O", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrP2O5", hssfCell, hssfRow, nc++, style2);
            
            insertFile("ilrM models start here", hssfCell, hssfRow, nc++, style2);
            insertFile("DF1_SG1-2-3_M", hssfCell, hssfRow, nc++, style5);
            insertFile("DF2_SG1-2-3_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P1_SG1_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P2_SG2_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P3_SG3_M", hssfCell, hssfRow, nc++, style5);
            insertFile("Decision_SG1-2-3_M", hssfCell, hssfRow, nc++, style5);

            insertFile("DF1_MG11-12-13_M", hssfCell, hssfRow, nc++, style3);
            insertFile("DF2_MG11-12-13_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_MG11_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_MG12_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P3_MG13_M", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_MG11-12-13_M", hssfCell, hssfRow, nc++, style3);


            insertFile("DF1_Gr111-112-113_M", hssfCell, hssfRow, nc++, style3);
            insertFile("DF2_Gr111-112-113_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_Gr111_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_Gr112_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P3_Gr113_M", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_Gr111-112-113_M", hssfCell, hssfRow, nc++, style3);


            insertFile("DF1_sGr1111-1112-1113_M", hssfCell, hssfRow, nc++, style3);
            insertFile("DF2_sGr1111-1112-1113_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_sGr1111_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_sGr1112_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P3_sGr1113_M", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1111-1112-1113_M", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_sGr1121-1122_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_1121_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_1122_M", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1121-1122_M", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_Gr121-122_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_Gr121_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_Gr122_M", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_Gr121-122_M", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_sGr1211-1212_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_sGr1211_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_sGr1212_M", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1211-1212_M", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_sGr1221-1222_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_sGr1221_M", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_sGr1222_M", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1221-1222_M", hssfCell, hssfRow, nc++, style3);

            insertFile("DF1_MG21-22-23_M", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_MG21-22-23_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_MG21_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_MG22_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_MG23_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_MG21-22-23_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF1_Gr211-212-213_M", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_Gr211-212-213_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_Gr211_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_Gr212_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_Gr213_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_Gr211-212-213_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF1_Gr221-222-223_M", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_Gr221-222-223_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_Gr221_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_Gr222_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_Gr223_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_Gr221-222-223_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF1_Gr231-232-233_M", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_Gr231-232-233_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_Gr231_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_Gr232_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_Gr233_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_Gr231-232-233_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF0_sGr2311-2312_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr2311_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr2312_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr23111_23112_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF0_sGr23111-23112_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr23111_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr23112_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr23111-23112_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF0_sGr23121-23122_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr23121_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr23122_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr23121-23122_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF0_sGr2321-2322_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr2321_M", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr2322_M", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr2321-2322_M", hssfCell, hssfRow, nc++, style4);

            insertFile("DF1_MG31-32-33_M", hssfCell, hssfRow, nc++, style5);
            insertFile("DF2_MG31-32-33_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P1_MG31_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P2_MG32_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P3_MG33_M", hssfCell, hssfRow, nc++, style5);
            insertFile("Decision_MG31-32-33_M", hssfCell, hssfRow, nc++, style5);

            insertFile("DF1_Gr311-312-313_M", hssfCell, hssfRow, nc++, style5);
            insertFile("DF2_Gr311-312-313_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P1_Gr311_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P2_Gr312_M", hssfCell, hssfRow, nc++, style5);
            insertFile("P3_Gr313_M", hssfCell, hssfRow, nc++, style5);
            insertFile("Decision_Gr311-312-313_M", hssfCell, hssfRow, nc++, style5);

            insertFile("RESULT_M", hssfCell, hssfRow, nc++, style2);
            
            
//ahora pegar encabezados para MT
            int j = 0;
            while (j< tabla.size()) {
                hssfRow = (HSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                //nc = ncreg;
                nc=19;
               if (!(tabla.get(j).getDecision_SG1_2_3M()).isEmpty()){ 
                    insertFile(" ", hssfCell, hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getSio2A(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getTio2A(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getAl2o3A(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getFe2o3tA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getMnoA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getMgoA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getCaoA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getNa2oA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getK2o(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getP2o5A(), hssfCell, hssfRow, nc++);

                    insertFile(" ", hssfCell, hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getIlrTiM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrAlM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrFeTM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMnM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMgM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrCaM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrNaM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrKM(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrPM(), hssfCell, hssfRow, nc++);
                
                    insertFile(" ", hssfCell, hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getDf1_SG1_2_3Md(), hssfCell, hssfRow, nc++);//41
                    insertFileD(tabla.get(j).getDf2_SG1_2_3Md(), hssfCell, hssfRow, nc++);//42
                    insertFileD(tabla.get(j).getP1_SG1M(), hssfCell, hssfRow, nc++);//43
                    insertFileD(tabla.get(j).getP2_SG2M(), hssfCell, hssfRow, nc++);//44
                    insertFileD(tabla.get(j).getP3_SG3M(), hssfCell, hssfRow, nc++);//45
                    insertFile(tabla.get(j).getDecision_SG1_2_3M(), hssfCell, hssfRow, nc++,style2);//46                    
                   
                    nc=46;                       
                    if ("SG3".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){
                            //System.out.println("cuando entro a SG3: aplico MG31_32_33 ..."+tabla.get(j).getDecision_MG31_32_33M());
                            insertFileD(tabla.get(j).getDf1_MG31_32_33Md(), hssfCell, hssfRow, nc+75);//75
                            insertFileD(tabla.get(j).getDf2_MG31_32_33Md(), hssfCell, hssfRow, nc+76);
                            insertFileD(tabla.get(j).getP1_MG31M(), hssfCell, hssfRow, nc+77);
                            insertFileD(tabla.get(j).getP2_MG32M(), hssfCell, hssfRow, nc+78);
                            insertFileD(tabla.get(j).getP3_MG33M(), hssfCell, hssfRow, nc+79);
                            insertFile(tabla.get(j).getDecision_MG31_32_33M(), hssfCell, hssfRow, nc+80, style2);                          
                            insertFile(tabla.get(j).getDecision_MG31_32_33M(), hssfCell, hssfRow, nc+87, style2);
                            
                            if ("MG31".equalsIgnoreCase(tabla.get(j).getDecision_MG31_32_33M())){
                                //System.out.println("cuando entro a SG3_ y luego a MG31: aplico Gr311_312_313 ..."+tabla.get(j).getDecision_Gr311_312_313M());
                                insertFileD(tabla.get(j).getDf1_Gr311_312_313Md(), hssfCell, hssfRow, nc+81);
                                insertFileD(tabla.get(j).getDf2_Gr311_312_313Md(), hssfCell, hssfRow, nc+82);
                                insertFileD(tabla.get(j).getP1_Gr311M(), hssfCell, hssfRow, nc+83);
                                insertFileD(tabla.get(j).getP2_Gr312M(), hssfCell, hssfRow, nc+84);
                                insertFileD(tabla.get(j).getP3_Gr313M(), hssfCell, hssfRow, nc+85);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313M(), hssfCell, hssfRow, nc+86, style2);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313M(), hssfCell, hssfRow, nc+87, style2);                                
                            }else{
                               insertFile(tabla.get(j).getDecision_MG31_32_33M(), hssfCell, hssfRow, nc+87, style2); 
                            //System.out.println("cuando entro a SG3_ y luego NO es MG31: entonces es: "+tabla.get(j).getDecision_MG31_32_33M());
                            }
                        } 
                    if ("SG1".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){                    
                        insertFileD(tabla.get(j).getDf1_MG11_12_13Md(), hssfCell, hssfRow, nc+1);
                        insertFileD(tabla.get(j).getDf2_MG11_12_13Md(), hssfCell, hssfRow, nc+2);
                        insertFileD(tabla.get(j).getP1_MG11M(), hssfCell, hssfRow, nc+3);
                        insertFileD(tabla.get(j).getP2_MG12M(), hssfCell, hssfRow, nc+4);
                        insertFileD(tabla.get(j).getP3_MG13M(), hssfCell, hssfRow, nc+5);
                        insertFile(tabla.get(j).getDecision_MG11_12_13M(), hssfCell, hssfRow, nc+6, style2);
                    
                        if ("MG11".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M())){
                            insertFileD(tabla.get(j).getDf1_Gr111_112_113Md(), hssfCell, hssfRow, nc+7);
                            insertFileD(tabla.get(j).getDf2_Gr111_112_113Md(), hssfCell, hssfRow, nc+8);
                            insertFileD(tabla.get(j).getP1_Gr111M(), hssfCell, hssfRow, nc+9);
                            insertFileD(tabla.get(j).getP2_Gr112M(), hssfCell, hssfRow, nc+10);
                            insertFileD(tabla.get(j).getP3_Gr113M(), hssfCell, hssfRow, nc+11);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113M(), hssfCell, hssfRow, nc+12, style2);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113M(), hssfCell, hssfRow, nc+87, style2);//resultM
                            
                            if ("Gr111".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M())){
                                insertFileD(tabla.get(j).getDf1_sGr1111_1112_1113Md(), hssfCell, hssfRow, nc+13);                    
                                insertFileD(tabla.get(j).getDf2_sGr1111_1112_1113Md(), hssfCell, hssfRow, nc+14);
                                insertFileD(tabla.get(j).getP1_sGr1111M(), hssfCell, hssfRow, nc+15);
                                insertFileD(tabla.get(j).getP2_sGr1112M(), hssfCell, hssfRow, nc+16);
                                insertFileD(tabla.get(j).getP3_sGr1113M(), hssfCell, hssfRow, nc+17);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113M(), hssfCell, hssfRow, nc+18, style2);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113M(), hssfCell, hssfRow, nc+87, style2);//resultM
                            }
                            if ("Gr112".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M())){
                                insertFileD(tabla.get(j).getDf0_sGr1121_1122Md(), hssfCell, hssfRow, nc+19);
                                insertFileD(tabla.get(j).getP1_sGr1121M(), hssfCell, hssfRow, nc+20);
                                insertFileD(tabla.get(j).getP2_sGr1122M(), hssfCell, hssfRow, nc+21);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122M(), hssfCell, hssfRow, nc+22, style2);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122M(), hssfCell, hssfRow, nc+87, style2);
                            }
                            if ("CBA".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M()))
                                insertFile(tabla.get(j).getDecision_Gr111_112_113M(), hssfCell, hssfRow, nc+87, style2);    
                        }if ("MG12".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M())){
                            insertFileD(tabla.get(j).getDf0_Gr121_122Md(), hssfCell, hssfRow, nc+23);
                            insertFileD(tabla.get(j).getP1_Gr121M(), hssfCell, hssfRow, nc+24);
                            insertFileD(tabla.get(j).getP2_Gr122M(), hssfCell, hssfRow, nc+25);
                            insertFile(tabla.get(j).getDecision_Gr121_122M(), hssfCell, hssfRow, nc+26, style2);
                            insertFile(tabla.get(j).getDecision_Gr121_122M(), hssfCell, hssfRow, nc+87, style2);
                            
                            if ("Gr121".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122M())){
                                insertFileD(tabla.get(j).getDf0_sGr1211_1212Md(), hssfCell, hssfRow, nc+27);
                                insertFileD(tabla.get(j).getP1_sGr1211M(), hssfCell, hssfRow, nc+28);
                                insertFileD(tabla.get(j).getP2_sGr1212M(), hssfCell, hssfRow, nc+29);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212M(), hssfCell, hssfRow, nc+30,style2);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212M(), hssfCell, hssfRow, nc+87,style2);
                               }
                           if ("Gr122".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122M())){
                                insertFileD(tabla.get(j).getDf0_sGr1221_1222Md(), hssfCell, hssfRow, nc+31 );
                                insertFileD(tabla.get(j).getP1_sGr1221M(), hssfCell, hssfRow, nc+32);
                                insertFileD(tabla.get(j).getP2_sGr1222M(), hssfCell, hssfRow, nc+33);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222M(), hssfCell, hssfRow, nc+34, style2);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222M(), hssfCell, hssfRow, nc+87, style2);
                            }
                        }if ("Col".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M()))
                            insertFile(tabla.get(j).getDecision_MG11_12_13M(), hssfCell, hssfRow, nc+87, style2);
                     }
                    if ("SG2".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){
                        insertFileD(tabla.get(j).getDf1_MG21_22_23Md(), hssfCell, hssfRow, nc+35);
                        insertFileD(tabla.get(j).getDf2_MG21_22_23Md(), hssfCell, hssfRow, nc+36);
                        insertFileD(tabla.get(j).getP1_MG21M(), hssfCell, hssfRow, nc+37);
                        insertFileD(tabla.get(j).getP2_MG22M(), hssfCell, hssfRow, nc+38);
                        insertFileD(tabla.get(j).getP3_MG23M(), hssfCell, hssfRow, nc+39);
                        insertFile(tabla.get(j).getDecision_MG21_22_23M(), hssfCell, hssfRow, nc+40, style2);
                        insertFile(tabla.get(j).getDecision_MG21_22_23M(), hssfCell, hssfRow, nc+87, style2);
                        
                        if ("MG21".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr211_212_213Md(), hssfCell, hssfRow, nc+41);
                            insertFileD(tabla.get(j).getDf2_Gr211_212_213Md(), hssfCell, hssfRow, nc+42);
                            insertFileD(tabla.get(j).getP1_Gr211M(), hssfCell, hssfRow, nc+43);
                            insertFileD(tabla.get(j).getP2_Gr212M(), hssfCell, hssfRow, nc+44);
                            insertFileD(tabla.get(j).getP3_Gr213M(), hssfCell, hssfRow, nc+45);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213M(), hssfCell, hssfRow, nc+46, style2);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213M(), hssfCell, hssfRow, nc+87, style2);
                            
                        }if ("MG22".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr221_222_223Md(), hssfCell, hssfRow, nc+47);
                            insertFileD(tabla.get(j).getDf2_Gr221_222_223Md(), hssfCell, hssfRow, nc+48);
                            insertFileD(tabla.get(j).getP1_Gr221M(), hssfCell, hssfRow, nc+49);
                            insertFileD(tabla.get(j).getP2_Gr222M(), hssfCell, hssfRow, nc+50);
                            insertFileD(tabla.get(j).getP3_Gr223M(), hssfCell, hssfRow, nc+51);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223M(), hssfCell, hssfRow, nc+52, style2);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223M(), hssfCell, hssfRow, nc+87, style2);
                            
                        }if ("MG23".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr231_232_233Md(), hssfCell, hssfRow, nc+53);
                            insertFileD(tabla.get(j).getDf2_Gr231_232_233Md(), hssfCell, hssfRow, nc+54);
                            insertFileD(tabla.get(j).getP1_Gr231M(), hssfCell, hssfRow, nc+55);
                            insertFileD(tabla.get(j).getP2_Gr232M(), hssfCell, hssfRow, nc+56);
                            insertFileD(tabla.get(j).getP3_Gr233M(), hssfCell, hssfRow, nc+57);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfCell, hssfRow, nc+58, style2);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfCell, hssfRow, nc+87, style2);
                            //System.out.println("****p1, p2, p3 "+tabla.get(j).getP1_Gr231M()+"\n"+tabla.get(j).getP2_Gr232M()+"\n"+tabla.get(j).getP3_Gr233M()+"\n");                            
                            System.out.println(" ++++++++ es 231 o 232:"+ tabla.get(j).getDecision_Gr231_232_233M() +"****p1, p2, p3 "+tabla.get(j).getP1_Gr231M()+"\n"+tabla.get(j).getP2_Gr232M()+"\n"+tabla.get(j).getP3_Gr233M()+"\n");
                            
                            
                            if((tabla.get(j).getP1_Gr231M()>tabla.get(j).getP2_Gr232M())&&(tabla.get(j).getP1_Gr231M()>tabla.get(j).getP3_Gr233M())){
//if (Objects.equals("Gr231", tabla.get(j).getDecision_Gr231_232_233M())) {
                            //if ("Gr231".equalsIgnoreCase(tabla.get(j).getDecision_Gr231_232_233M())){
                                insertFileD(tabla.get(j).getDf0_sGr2311_2312Md(), hssfCell, hssfRow, nc+59); //aquí ya hay ceros en todo 231 y 232 hacia abajo del árbol
                                insertFileD(tabla.get(j).getP1_sGr2311M(), hssfCell, hssfRow, nc+60);
                                insertFileD(tabla.get(j).getP2_sGr2312M(), hssfCell, hssfRow, nc+61);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312M(), hssfCell, hssfRow, nc+62,style2);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312M(), hssfCell, hssfRow, nc+87,style2);
                                
                                System.out.println(" es sGr2311 o sGr2312:"+ tabla.get(j).getDecision_sGr2311_2312M());
                                if (tabla.get(j).getP1_sGr2311M()>tabla.get(j).getP2_sGr2312M()) {
                                    insertFileD(tabla.get(j).getDf0_sGr23111_23112Md(), hssfCell, hssfRow, nc+63);
                                    insertFileD(tabla.get(j).getP1_sGr23111M(), hssfCell, hssfRow, nc+64);
                                    insertFileD(tabla.get(j).getP2_sGr23112M(), hssfCell, hssfRow, nc+65);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112M(), hssfCell, hssfRow, nc+66, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112M(), hssfCell, hssfRow, nc+87, style2);
                                }else//if ("sGr2312".equalsIgnoreCase(tabla.get(j).getDecision_sGr2311_2312M()))
                                {
                                    insertFileD(tabla.get(j).getDf0_sGr23121_23122Md(), hssfCell, hssfRow, nc+67);
                                    insertFileD(tabla.get(j).getP1_sGr23121M(), hssfCell, hssfRow, nc+68);
                                    insertFileD(tabla.get(j).getP2_sGr23122M(), hssfCell, hssfRow, nc+69);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122M(), hssfCell, hssfRow, nc+70, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122M(), hssfCell, hssfRow, nc+87, style2);
                                }
                            }if((tabla.get(j).getP2_Gr232M()>tabla.get(j).getP1_Gr231M())&&(tabla.get(j).getP2_Gr232M()>tabla.get(j).getP3_Gr233M())){         
                            //if (Objects.equals("Gr232", tabla.get(j).getDecision_Gr231_232_233M())) {
                                insertFileD(tabla.get(j).getDf0_sGr2321_2322Md(), hssfCell, hssfRow, nc+71);
                                insertFileD(tabla.get(j).getP1_sGr2321M(), hssfCell, hssfRow, nc+72);
                                insertFileD(tabla.get(j).getP2_sGr2322M(), hssfCell, hssfRow, nc+73);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322M(), hssfCell, hssfRow, nc+74, style2);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322M(), hssfCell, hssfRow, nc+87, style2);
                                
                            }if((tabla.get(j).getP3_Gr233M()>tabla.get(j).getP1_Gr231M())&&(tabla.get(j).getP3_Gr233M()>tabla.get(j).getP2_Gr232M()))
                                insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfCell, hssfRow, nc+87, style2);
                        
                        }
                                                   
                        } 
                    }
                    j++;
            }//cierra ciclo de procesar cada muestra recibida
            OutputStream output = new FileOutputStream(filePath);
            output.flush();
            workBook.write(output);
            output.close();

            //reporte2_res();
        } catch (Exception e) {

             Messagebox.show("Error in reportM() " + e);
            e.printStackTrace();
        }
        // tabla.
    }  
   
    public void reportMT(String filePath) {
        try {
           
            FileInputStream fileInputStream = new FileInputStream(filePath);
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            hssfSheetMT = workBook.getSheetAt(0);
            
            HSSFFont font2 = workBook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(font2.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2 = workBook.createCellStyle();
            style2.setVerticalAlignment(style2.VERTICAL_CENTER);
            style2.setAlignment(style2.ALIGN_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);
            
            HSSFFont font3 = workBook.createFont();
            font3.setColor(HSSFColor.RED.index);
            font3.setBoldweight(font3.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workBook.createCellStyle();
            style3.setVerticalAlignment(style3.VERTICAL_CENTER);
            style3.setAlignment(style3.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);
            
            HSSFFont font4 = workBook.createFont();
            font4.setColor(HSSFColor.GREEN.index);
            font4.setBoldweight(font4.BOLDWEIGHT_BOLD);
            HSSFCellStyle style4 = workBook.createCellStyle();
            style4.setVerticalAlignment(style4.VERTICAL_CENTER);
            style4.setAlignment(style4.ALIGN_CENTER);
            style4.setWrapText(true);
            style4.setFont(font4);
            
            HSSFFont font5 = workBook.createFont();
            font5.setColor(HSSFColor.BROWN.index);
            font5.setBoldweight(font5.BOLDWEIGHT_BOLD);
            HSSFCellStyle style5 = workBook.createCellStyle();
            style5.setVerticalAlignment(style5.VERTICAL_CENTER);
            style5.setAlignment(style5.ALIGN_CENTER);
            style5.setWrapText(true);
            style5.setFont(font5);
            
            Iterator rowIterator = hssfSheetMT.rowIterator();
            HSSFRow hssfRow = (HSSFRow) rowIterator.next();
            int nc;
            HSSFCell hssfCell;

            nc=19;
            hssfRow.createCell(nc);
            hssfCell = hssfRow.getCell(nc);

            //****************************************************************
            //cabecera de elementos Major and traza
            insertFile("Adj Major and Trace -reportMT", hssfCell, hssfRow, nc++, style2);
            insertFile("SIO2adj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("TIO2adj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("AL2O3adj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("FE2O3Tadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("MNOadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("MGOadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("CAOadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("NA2Oadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("K2Oadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("P2O5adj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("CRadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("NBadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("NIadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("Vadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("Yadj1mt", hssfCell, hssfRow, nc++, style2);
            insertFile("ZRadj1mt", hssfCell, hssfRow, nc++, style2);
            
            insertFile("Ilr start here ", hssfCell, hssfRow, nc++, style2);            
            insertFile("ilrTIO2mt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrAL2O3mt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrFE2O3Tmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrMNOmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrMGOmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrCAOmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrNA2Omt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrK2Omt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrP2O5mt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrCRmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrNBmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrNImt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrVmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrYmt", hssfCell, hssfRow, nc++, style2);
            insertFile("ilrZRmt", hssfCell, hssfRow, nc++, style2);  
            
             //****************************************************************
            //Modelos basados elementos Majores-traza
            insertFile("MT models start here", hssfCell, hssfRow, nc++, style2);
            
            insertFile("DF1_SG1-2-3_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("DF2_SG1-2-3_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P1_SG1_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P2_SG2_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P3_SG3_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("Decision_SG1-2-3_MT", hssfCell, hssfRow, nc++, style5);

            insertFile("DF1_MG11-12-13_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("DF2_MG11-12-13_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_MG11_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_MG12_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P3_MG13_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_MG11-12-13_MT", hssfCell, hssfRow, nc++, style3);


            insertFile("DF1_Gr111-112-113_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("DF2_Gr111-112-113_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_Gr111_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_Gr112_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P3_Gr113_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_Gr111-112-113_MT", hssfCell, hssfRow, nc++, style3);


            insertFile("DF1_sGr1111-1112-1113_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("DF2_sGr1111-1112-1113_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_sGr1111_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_sGr1112_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P3_sGr1113_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1111-1112-1113_MT", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_sGr1121-1122_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_1121_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_1122_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1121-1122_MT", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_Gr121-122_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_Gr121_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_Gr122_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_Gr121-122_MT", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_sGr1211-1212_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_sGr1211_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_sGr1212_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1211-1212_MT", hssfCell, hssfRow, nc++, style3);


            insertFile("DF0_sGr1221-1222_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P1_sGr1221_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("P2_sGr1222_MT", hssfCell, hssfRow, nc++, style3);
            insertFile("Decision_sGr1221-1222_MT", hssfCell, hssfRow, nc++, style3);

            insertFile("DF1_MG21-22-23_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_MG21-22-23_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_MG21_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_MG22_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_MG23_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_MG21-22-23_MT", hssfCell, hssfRow, nc++, style4);

            insertFile("DF1_Gr211-212-213_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_Gr211-212-213_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_Gr211_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_Gr212_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_Gr213_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_Gr211-212-213_MT", hssfCell, hssfRow, nc++, style4);

            insertFile("DF1_Gr221-222-223_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_Gr221-222-223_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_Gr221_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_Gr222_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_Gr223_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_Gr221-222-223_MT", hssfCell, hssfRow, nc++, style4);

            insertFile("DF1_Gr231-232-233_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("DF2_Gr231-232-233_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_Gr231_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_Gr232_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P3_Gr233_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_Gr231-232-233_MT", hssfCell, hssfRow, nc++, style4);

            insertFile("DF0_sGr2311-2312_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr2311_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr2312_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr23111_23112_MT", hssfCell, hssfRow, nc++, style4);

            insertFile("DF0_sGr23111-23112_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr23111_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr23112_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr23111-23112_MT", hssfCell, hssfRow, nc++, style4);

            insertFile("DF0_sGr23121-23122_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr23121_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr23122_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr23121-23122_MT", hssfCell, hssfRow, nc++, style4);


            insertFile("DF0_sGr2321-2322_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P1_sGr2321_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("P2_sGr2322_MT", hssfCell, hssfRow, nc++, style4);
            insertFile("Decision_sGr2321-2322_MT", hssfCell, hssfRow, nc++, style4);



            insertFile("DF1_MG31-32-33_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("DF2_MG31-32-33_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P1_MG31_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P2_MG32_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P3_MG33_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("Decision_MG31-32-33_MT", hssfCell, hssfRow, nc++, style5);

            insertFile("DF1_Gr311-312-313_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("DF2_Gr311-312-313_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P1_Gr311_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P2_Gr312_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("P3_Gr313_MT", hssfCell, hssfRow, nc++, style5);
            insertFile("Decision_Gr311-312-313_MT", hssfCell, hssfRow, nc++, style5);

            insertFile("RESULT_MT", hssfCell, hssfRow, nc++, style2);

            int j = 0;
            while (j< tabla.size()) {
                hssfRow = (HSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                //nc = ncreg;
                nc=19;//antes de ajustados hay 19 columnas
               if (!(tabla.get(j).getDecision_SG1_2_3MT()).isEmpty()){                     
                    insertFile(" ", hssfCell, hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getSio2mtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getTio2mtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getAl2o3mtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getFe2o3tmtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getMnomtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getMgomtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getCaomtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getNa2omtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getK2omtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getP2o5mtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getCrmtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getNbmtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getNimtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getVmtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getYmtA(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getZrmtA(), hssfCell, hssfRow, nc++);

                    insertFile(" ", hssfCell, hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getIlrTiMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrAlMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrFeTMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMnMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMgMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrCaMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrNaMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrKMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrPMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrCrMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrNbMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrNiMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrVMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrYMT(), hssfCell, hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrZrMT(), hssfCell, hssfRow, nc++); 
                    
                    insertFile(" ", hssfCell, hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getDf1_SG1_2_3MTd(), hssfCell, hssfRow, nc++);//41
                    insertFileD(tabla.get(j).getDf2_SG1_2_3MTd(), hssfCell, hssfRow, nc++);//42
                    insertFileD(tabla.get(j).getP1_SG1MT(), hssfCell, hssfRow, nc++);//43
                    insertFileD(tabla.get(j).getP2_SG2MT(), hssfCell, hssfRow, nc++);//44
                    insertFileD(tabla.get(j).getP3_SG3MT(), hssfCell, hssfRow, nc++);//45
                    insertFile(tabla.get(j).getDecision_SG1_2_3MT(), hssfCell, hssfRow, nc++,style2);//46
                    insertFile(tabla.get(j).getDecision_SG1_2_3MT(), hssfCell, hssfRow, nc+87,style2);//46
                    
                    
                    nc=58;//ES EL NÚMERO DE COLUMNAS QUE ESTÁN ANTES DE LA DECISIÓN DEL PRIMER DIAGRAMA GENERAL, 
                    if ("SG3".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){
                            //System.out.println("cuando entro a SG3: aplico MG31_32_33 ..."+tabla.get(j).getDecision_MG31_32_33MT());
                            insertFileD(tabla.get(j).getDf1_MG31_32_33MTd(), hssfCell, hssfRow, nc+75);//75
                            insertFileD(tabla.get(j).getDf2_MG31_32_33MTd(), hssfCell, hssfRow, nc+76);
                            insertFileD(tabla.get(j).getP1_MG31MT(), hssfCell, hssfRow, nc+77);
                            insertFileD(tabla.get(j).getP2_MG32MT(), hssfCell, hssfRow, nc+78);
                            insertFileD(tabla.get(j).getP3_MG33MT(), hssfCell, hssfRow, nc+79);
                            insertFile(tabla.get(j).getDecision_MG31_32_33MT(), hssfCell, hssfRow, nc+80, style2);                            
                            insertFile(tabla.get(j).getDecision_MG31_32_33MT(), hssfCell, hssfRow, nc+87, style2);                            
                            
                            if ("MG31".equalsIgnoreCase(tabla.get(j).getDecision_MG31_32_33MT())){
                                //System.out.println("cuando entro a SG3_ y luego a MG31: aplico Gr311_312_313 ..."+tabla.get(j).getDecision_Gr311_312_313MT());
                                insertFileD(tabla.get(j).getDf1_Gr311_312_313MTd(), hssfCell, hssfRow, nc+81);
                                insertFileD(tabla.get(j).getDf2_Gr311_312_313MTd(), hssfCell, hssfRow, nc+82);
                                insertFileD(tabla.get(j).getP1_Gr311MT(), hssfCell, hssfRow, nc+83);
                                insertFileD(tabla.get(j).getP2_Gr312MT(), hssfCell, hssfRow, nc+84);
                                insertFileD(tabla.get(j).getP3_Gr313MT(), hssfCell, hssfRow, nc+85);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313MT(), hssfCell, hssfRow, nc+86, style2);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313MT(), hssfCell, hssfRow, nc+87, style2);
                                
                            }else{
                               insertFile(tabla.get(j).getDecision_MG31_32_33MT(), hssfCell, hssfRow, nc+87, style2); 
                            //System.out.println("cuando entro a SG3_ y luego NO es MG31: entonces es: "+tabla.get(j).getDecision_MG31_32_33MT());
                            }
                        } 
                    if ("SG1".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){                    
                        insertFileD(tabla.get(j).getDf1_MG11_12_13MTd(), hssfCell, hssfRow, nc+1);
                        insertFileD(tabla.get(j).getDf2_MG11_12_13MTd(), hssfCell, hssfRow, nc+2);
                        insertFileD(tabla.get(j).getP1_MG11MT(), hssfCell, hssfRow, nc+3);
                        insertFileD(tabla.get(j).getP2_MG12MT(), hssfCell, hssfRow, nc+4);
                        insertFileD(tabla.get(j).getP3_MG13MT(), hssfCell, hssfRow, nc+5);
                        insertFile(tabla.get(j).getDecision_MG11_12_13MT(), hssfCell, hssfRow, nc+6, style2);
                        insertFile(tabla.get(j).getDecision_MG11_12_13MT(), hssfCell, hssfRow, nc+87, style2);
                    
                        if ("MG11".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT())){
                            insertFileD(tabla.get(j).getDf1_Gr111_112_113MTd(), hssfCell, hssfRow, nc+7);
                            insertFileD(tabla.get(j).getDf2_Gr111_112_113MTd(), hssfCell, hssfRow, nc+8);
                            insertFileD(tabla.get(j).getP1_Gr111MT(), hssfCell, hssfRow, nc+9);
                            insertFileD(tabla.get(j).getP2_Gr112MT(), hssfCell, hssfRow, nc+10);
                            insertFileD(tabla.get(j).getP3_Gr113MT(), hssfCell, hssfRow, nc+11);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113MT(), hssfCell, hssfRow, nc+12, style2);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113MT(), hssfCell, hssfRow, nc+87, style2);
                            
                            if ("Gr111".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT())){
                                insertFileD(tabla.get(j).getDf1_sGr1111_1112_1113MTd(), hssfCell, hssfRow, nc+13);                    
                                insertFileD(tabla.get(j).getDf2_sGr1111_1112_1113MTd(), hssfCell, hssfRow, nc+14);
                                insertFileD(tabla.get(j).getP1_sGr1111MT(), hssfCell, hssfRow, nc+15);
                                insertFileD(tabla.get(j).getP2_sGr1112MT(), hssfCell, hssfRow, nc+16);
                                insertFileD(tabla.get(j).getP3_sGr1113MT(), hssfCell, hssfRow, nc+17);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113MT(), hssfCell, hssfRow, nc+18, style2);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113MT(), hssfCell, hssfRow, nc+87, style2);//resultM
                            }
                            if ("Gr112".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1121_1122MTd(), hssfCell, hssfRow, nc+19);
                                insertFileD(tabla.get(j).getP1_sGr1121MT(), hssfCell, hssfRow, nc+20);
                                insertFileD(tabla.get(j).getP2_sGr1122MT(), hssfCell, hssfRow, nc+21);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122MT(), hssfCell, hssfRow, nc+22, style2);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122MT(), hssfCell, hssfRow, nc+87, style2);
                            }
                            if ("CBA".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT()))
                                insertFile(tabla.get(j).getDecision_Gr111_112_113MT(), hssfCell, hssfRow, nc+87, style2);    
                        }if ("MG12".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT())){
                            insertFileD(tabla.get(j).getDf0_Gr121_122MTd(), hssfCell, hssfRow, nc+23);
                            insertFileD(tabla.get(j).getP1_Gr121MT(), hssfCell, hssfRow, nc+24);
                            insertFileD(tabla.get(j).getP2_Gr122MT(), hssfCell, hssfRow, nc+25);
                            insertFile(tabla.get(j).getDecision_Gr121_122MT(), hssfCell, hssfRow, nc+26, style2);
                            insertFile(tabla.get(j).getDecision_Gr121_122MT(), hssfCell, hssfRow, nc+87, style2);
                            
                            if ("Gr121".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1211_1212MTd(), hssfCell, hssfRow, nc+27);
                                insertFileD(tabla.get(j).getP1_sGr1211MT(), hssfCell, hssfRow, nc+28);
                                insertFileD(tabla.get(j).getP2_sGr1212MT(), hssfCell, hssfRow, nc+29);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212MT(), hssfCell, hssfRow, nc+30,style2);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212MT(), hssfCell, hssfRow, nc+87,style2);
                               }
                           if ("Gr122".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1221_1222MTd(), hssfCell, hssfRow, nc+31 );
                                insertFileD(tabla.get(j).getP1_sGr1221MT(), hssfCell, hssfRow, nc+32);
                                insertFileD(tabla.get(j).getP2_sGr1222MT(), hssfCell, hssfRow, nc+33);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222MT(), hssfCell, hssfRow, nc+34, style2);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222MT(), hssfCell, hssfRow, nc+87, style2);
                            }
                        }if ("Col".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT()))
                            insertFile(tabla.get(j).getDecision_MG11_12_13MT(), hssfCell, hssfRow, nc+87, style2);
                     }
                    if ("SG2".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){
                        insertFileD(tabla.get(j).getDf1_MG21_22_23MTd(), hssfCell, hssfRow, nc+35);
                        insertFileD(tabla.get(j).getDf2_MG21_22_23MTd(), hssfCell, hssfRow, nc+36);
                        insertFileD(tabla.get(j).getP1_MG21MT(), hssfCell, hssfRow, nc+37);
                        insertFileD(tabla.get(j).getP2_MG22MT(), hssfCell, hssfRow, nc+38);
                        insertFileD(tabla.get(j).getP3_MG23MT(), hssfCell, hssfRow, nc+39);
                        insertFile(tabla.get(j).getDecision_MG21_22_23MT(), hssfCell, hssfRow, nc+40, style2);
                        insertFile(tabla.get(j).getDecision_MG21_22_23MT(), hssfCell, hssfRow, nc+87, style2);
                        
                        if ("MG21".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr211_212_213MTd(), hssfCell, hssfRow, nc+41);
                            insertFileD(tabla.get(j).getDf2_Gr211_212_213MTd(), hssfCell, hssfRow, nc+42);
                            insertFileD(tabla.get(j).getP1_Gr211MT(), hssfCell, hssfRow, nc+43);
                            insertFileD(tabla.get(j).getP2_Gr212MT(), hssfCell, hssfRow, nc+44);
                            insertFileD(tabla.get(j).getP3_Gr213MT(), hssfCell, hssfRow, nc+45);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213MT(), hssfCell, hssfRow, nc+46, style2);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213MT(), hssfCell, hssfRow, nc+87, style2);
                            
                        }if ("MG22".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr221_222_223MTd(), hssfCell, hssfRow, nc+47);
                            insertFileD(tabla.get(j).getDf2_Gr221_222_223MTd(), hssfCell, hssfRow, nc+48);
                            insertFileD(tabla.get(j).getP1_Gr221MT(), hssfCell, hssfRow, nc+49);
                            insertFileD(tabla.get(j).getP2_Gr222MT(), hssfCell, hssfRow, nc+50);
                            insertFileD(tabla.get(j).getP3_Gr223MT(), hssfCell, hssfRow, nc+51);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223MT(), hssfCell, hssfRow, nc+52, style2);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223MT(), hssfCell, hssfRow, nc+87, style2);
                            
                        }if ("MG23".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr231_232_233MTd(), hssfCell, hssfRow, nc+53);
                            insertFileD(tabla.get(j).getDf2_Gr231_232_233MTd(), hssfCell, hssfRow, nc+54);
                            insertFileD(tabla.get(j).getP1_Gr231MT(), hssfCell, hssfRow, nc+55);
                            insertFileD(tabla.get(j).getP2_Gr232MT(), hssfCell, hssfRow, nc+56);
                            insertFileD(tabla.get(j).getP3_Gr233MT(), hssfCell, hssfRow, nc+57);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233MT(), hssfCell, hssfRow, nc+58, style2);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233MT(), hssfCell, hssfRow, nc+87, style2);
                            //System.out.println("****p1, p2, p3 "+tabla.get(j).getP1_Gr231MT()+"\n"+tabla.get(j).getP2_Gr232MT()+"\n"+tabla.get(j).getP3_Gr233MT()+"\n");                            
                            System.out.println(" ++++++++ es 231 o 232:"+ tabla.get(j).getDecision_Gr231_232_233MT() +"****p1, p2, p3 "+tabla.get(j).getP1_Gr231MT()+"\n"+tabla.get(j).getP2_Gr232MT()+"\n"+tabla.get(j).getP3_Gr233MT()+"\n");
                            
                            
                            if((tabla.get(j).getP1_Gr231MT()>tabla.get(j).getP2_Gr232MT())&&(tabla.get(j).getP1_Gr231MT()>tabla.get(j).getP3_Gr233MT())){
//if (Objects.equals("Gr231", tabla.get(j).getDecision_Gr231_232_233MT())) {
                            //if ("Gr231".equalsIgnoreCase(tabla.get(j).getDecision_Gr231_232_233MT())){
                                insertFileD(tabla.get(j).getDf0_sGr2311_2312MTd(), hssfCell, hssfRow, nc+59); //aquí ya hay ceros en todo 231 y 232 hacia abajo del árbol
                                insertFileD(tabla.get(j).getP1_sGr2311MT(), hssfCell, hssfRow, nc+60);
                                insertFileD(tabla.get(j).getP2_sGr2312MT(), hssfCell, hssfRow, nc+61);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312MT(), hssfCell, hssfRow, nc+62,style2);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312MT(), hssfCell, hssfRow, nc+87,style2);
                                
                                System.out.println(" es sGr2311 o sGr2312:"+ tabla.get(j).getDecision_sGr2311_2312MT());
                                if (tabla.get(j).getP1_sGr2311MT()>tabla.get(j).getP2_sGr2312MT()) {
                                    insertFileD(tabla.get(j).getDf0_sGr23111_23112MTd(), hssfCell, hssfRow, nc+63);
                                    insertFileD(tabla.get(j).getP1_sGr23111MT(), hssfCell, hssfRow, nc+64);
                                    insertFileD(tabla.get(j).getP2_sGr23112MT(), hssfCell, hssfRow, nc+65);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112MT(), hssfCell, hssfRow, nc+66, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112MT(), hssfCell, hssfRow, nc+87, style2);
                                }else//if ("sGr2312".equalsIgnoreCase(tabla.get(j).getDecision_sGr2311_2312MT()))
                                {
                                    insertFileD(tabla.get(j).getDf0_sGr23121_23122MTd(), hssfCell, hssfRow, nc+67);
                                    insertFileD(tabla.get(j).getP1_sGr23121MT(), hssfCell, hssfRow, nc+68);
                                    insertFileD(tabla.get(j).getP2_sGr23122MT(), hssfCell, hssfRow, nc+69);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122MT(), hssfCell, hssfRow, nc+70, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122MT(), hssfCell, hssfRow, nc+87, style2);
                                }
                            }if((tabla.get(j).getP2_Gr232MT()>tabla.get(j).getP1_Gr231MT())&&(tabla.get(j).getP2_Gr232MT()>tabla.get(j).getP3_Gr233MT())){         
                            //if (Objects.equals("Gr232", tabla.get(j).getDecision_Gr231_232_233MT())) {
                                insertFileD(tabla.get(j).getDf0_sGr2321_2322MTd(), hssfCell, hssfRow, nc+71);
                                insertFileD(tabla.get(j).getP1_sGr2321MT(), hssfCell, hssfRow, nc+72);
                                insertFileD(tabla.get(j).getP2_sGr2322MT(), hssfCell, hssfRow, nc+73);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322MT(), hssfCell, hssfRow, nc+74, style2);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322MT(), hssfCell, hssfRow, nc+87, style2);
                            }if((tabla.get(j).getP3_Gr233MT()>tabla.get(j).getP1_Gr231MT())&&(tabla.get(j).getP3_Gr233MT()>tabla.get(j).getP2_Gr232MT()))
                                insertFile(tabla.get(j).getDecision_Gr231_232_233MT(), hssfCell, hssfRow, nc+87, style2);
                        
                        }
                                                   
                        } 
                    }

                    j++;
            }//cierra ciclo de procesar cada muestra recibida
            OutputStream output = new FileOutputStream(filePath);
            output.flush();
            workBook.write(output);
            output.close();

            //reporte2_res();
        } catch (Exception e) {

             Messagebox.show("Error in reportMT() " + e);
            e.printStackTrace();
        }
        // tabla.
    }  
    
    public void insertFile(String name, HSSFCell hssfCell, HSSFRow hssfRow, int nc, HSSFCellStyle style) {        
            try {                
                hssfRow.createCell(nc);
                hssfCell = hssfRow.getCell(nc);
                hssfCell.setCellValue(name);
                hssfCell.setCellStyle(style);
            } catch (Exception e) {
                Messagebox.show("Error in ReportRobustness.insertFile()" + e);
                e.printStackTrace();
            }
        }


    public void insertFileD(Double name, HSSFCell hssfCell, HSSFRow hssfRow, int nc) {
        try {

            hssfRow.createCell(nc);
            hssfCell = hssfRow.getCell(nc);
            if (name == null) {
                hssfCell.setCellValue("");
            } else {
                hssfCell.setCellValue(name);
            }
        } catch (Exception e) {
            Messagebox.show("dou" + name);
            e.printStackTrace();
        }
    }
}
