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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.zkoss.util.media.AMedia;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Abde
 */
public class ReportRobustness {

    private ArrayList<Columnas> tabla;
    public HSSFSheet hssfSheet;
    AMedia fileContent;
    AMedia fileContentSummary;
    String[] tectonicSetting;

    public  ReportRobustness(ArrayList<Columnas> tabla){
        this.tabla = tabla;
    }
            
    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public AMedia getFileContent() {
        return fileContent;
    }

    public void setFileContent(AMedia fileContent) {
        this.fileContent = fileContent;
    }
   
     public AMedia getFileContentSummary() {
        return fileContentSummary;
    }

    public void setFileContentSummary(AMedia fileContent) {
        this.fileContentSummary = fileContent;
    }
    
   
    public void reportpropagationM(String fileout) {
        try {  
            FileOutputStream fileOut = new FileOutputStream(fileout);
            HSSFWorkbook workbook = new HSSFWorkbook();      
            HSSFSheet worksheet = workbook.createSheet("Complete report");
            
            HSSFFont font2 = workbook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(font2.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setVerticalAlignment(style2.VERTICAL_CENTER);
            style2.setAlignment(style2.ALIGN_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);
            
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.RED.index);
            font3.setBoldweight(font3.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setVerticalAlignment(style3.VERTICAL_CENTER);
            style3.setAlignment(style3.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);
            
            HSSFFont font4 = workbook.createFont();
            font4.setColor(HSSFColor.GREEN.index);
            font4.setBoldweight(font4.BOLDWEIGHT_BOLD);
            HSSFCellStyle style4 = workbook.createCellStyle();
            style4.setVerticalAlignment(style4.VERTICAL_CENTER);
            style4.setAlignment(style4.ALIGN_CENTER);
            style4.setWrapText(true);
            style4.setFont(font4);
            
             HSSFFont font5 = workbook.createFont();
            font5.setColor(HSSFColor.BROWN.index);
            font5.setBoldweight(font5.BOLDWEIGHT_BOLD);
            HSSFCellStyle style5 = workbook.createCellStyle();
            style5.setVerticalAlignment(style5.VERTICAL_CENTER);
            style5.setAlignment(style5.ALIGN_CENTER);
            style5.setWrapText(true);
            style5.setFont(font5);
            
            
                      
            HSSFRow hssfRow = worksheet.createRow((short) 0);
            int nc = 0;
            insertFile("Consecutive",  hssfRow, nc++,style2);
            insertFile("Region",  hssfRow, nc++,style2);
            insertFile("SampID",  hssfRow, nc++,style2);
            insertFile("SiO2",  hssfRow, nc++,style2);
            insertFile("TiO2",  hssfRow, nc++,style2);
            insertFile("Al2O3",  hssfRow, nc++,style2);
            insertFile("Fe2O3T",  hssfRow, nc++,style2);
            insertFile("MnO",  hssfRow, nc++,style2);
            insertFile("MgO",  hssfRow, nc++,style2);
            insertFile("CaO",  hssfRow, nc++,style2);
            insertFile("Na2O",  hssfRow, nc++,style2);
            insertFile("K2O",  hssfRow, nc++,style2); 
            insertFile("P2O5",  hssfRow, nc++,style2); 
            insertFile("CR",  hssfRow, nc++,style2); 
            insertFile("NB",  hssfRow, nc++,style2); 
            insertFile("NI",  hssfRow, nc++,style2); 
            insertFile("V",  hssfRow, nc++,style2); 
            insertFile("Y",  hssfRow, nc++,style2); 
            insertFile("ZR",  hssfRow, nc++,style2);
            
            insertFile("Adj major start here", hssfRow, nc++, style2);            
            insertFile("SIO2adj", hssfRow, nc++, style2);
            insertFile("TIO2adj", hssfRow, nc++, style2);
            insertFile("AL2O3adj", hssfRow, nc++, style2);
            insertFile("FE2O3Tadj", hssfRow, nc++, style2);
            insertFile("MNOadj", hssfRow, nc++, style2);
            insertFile("MGOadj", hssfRow, nc++, style2);
            insertFile("CAOadj", hssfRow, nc++, style2);
            insertFile("NA2Oadj", hssfRow, nc++, style2);
            insertFile("K2Oadj", hssfRow, nc++, style2);
            insertFile("P2O5adj", hssfRow, nc++, style2);
            
             //cabecera de elementos Major and traza
            insertFile("Ilr major start here", hssfRow, nc++, style2);
            insertFile("ilrTIO2", hssfRow, nc++, style2);
            insertFile("ilrAL2O3", hssfRow, nc++, style2);
            insertFile("ilrFE2O3T", hssfRow, nc++, style2);
            insertFile("ilrMNO", hssfRow, nc++, style2);
            insertFile("ilrMGO", hssfRow, nc++, style2);
            insertFile("ilrCAO", hssfRow, nc++, style2);
            insertFile("ilrNA2O", hssfRow, nc++, style2);
            insertFile("ilrK2O", hssfRow, nc++, style2);
            insertFile("ilrP2O5", hssfRow, nc++, style2);
            
            insertFile("ilrM models start here", hssfRow, nc++, style2);
            insertFile("DF1_SG1-2-3_M", hssfRow, nc++, style5);
            insertFile("DF2_SG1-2-3_M", hssfRow, nc++, style5);
            insertFile("P1_SG1_M", hssfRow, nc++, style5);
            insertFile("P2_SG2_M", hssfRow, nc++, style5);
            insertFile("P3_SG3_M", hssfRow, nc++, style5);
            insertFile("Decision_SG1-2-3_M", hssfRow, nc++, style5);

            insertFile("DF1_MG11-12-13_M", hssfRow, nc++, style3);
            insertFile("DF2_MG11-12-13_M", hssfRow, nc++, style3);
            insertFile("P1_MG11_M", hssfRow, nc++, style3);
            insertFile("P2_MG12_M", hssfRow, nc++, style3);
            insertFile("P3_MG13_M", hssfRow, nc++, style3);
            insertFile("Decision_MG11-12-13_M", hssfRow, nc++, style3);


            insertFile("DF1_Gr111-112-113_M", hssfRow, nc++, style3);
            insertFile("DF2_Gr111-112-113_M", hssfRow, nc++, style3);
            insertFile("P1_Gr111_M", hssfRow, nc++, style3);
            insertFile("P2_Gr112_M", hssfRow, nc++, style3);
            insertFile("P3_Gr113_M", hssfRow, nc++, style3);
            insertFile("Decision_Gr111-112-113_M", hssfRow, nc++, style3);


            insertFile("DF1_sGr1111-1112-1113_M", hssfRow, nc++, style3);
            insertFile("DF2_sGr1111-1112-1113_M", hssfRow, nc++, style3);
            insertFile("P1_sGr1111_M", hssfRow, nc++, style3);
            insertFile("P2_sGr1112_M", hssfRow, nc++, style3);
            insertFile("P3_sGr1113_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1111-1112-1113_M", hssfRow, nc++, style3);


            insertFile("DF0_sGr1121-1122_M", hssfRow, nc++, style3);
            insertFile("P1_1121_M", hssfRow, nc++, style3);
            insertFile("P2_1122_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1121-1122_M", hssfRow, nc++, style3);


            insertFile("DF0_Gr121-122_M", hssfRow, nc++, style3);
            insertFile("P1_Gr121_M", hssfRow, nc++, style3);
            insertFile("P2_Gr122_M", hssfRow, nc++, style3);
            insertFile("Decision_Gr121-122_M", hssfRow, nc++, style3);


            insertFile("DF0_sGr1211-1212_M", hssfRow, nc++, style3);
            insertFile("P1_sGr1211_M", hssfRow, nc++, style3);
            insertFile("P2_sGr1212_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1211-1212_M", hssfRow, nc++, style3);


            insertFile("DF0_sGr1221-1222_M", hssfRow, nc++, style3);
            insertFile("P1_sGr1221_M", hssfRow, nc++, style3);
            insertFile("P2_sGr1222_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1221-1222_M", hssfRow, nc++, style3);

            insertFile("DF1_MG21-22-23_M", hssfRow, nc++, style4);
            insertFile("DF2_MG21-22-23_M", hssfRow, nc++, style4);
            insertFile("P1_MG21_M", hssfRow, nc++, style4);
            insertFile("P2_MG22_M", hssfRow, nc++, style4);
            insertFile("P3_MG23_M", hssfRow, nc++, style4);
            insertFile("Decision_MG21-22-23_M", hssfRow, nc++, style4);

            insertFile("DF1_Gr211-212-213_M", hssfRow, nc++, style4);
            insertFile("DF2_Gr211-212-213_M", hssfRow, nc++, style4);
            insertFile("P1_Gr211_M", hssfRow, nc++, style4);
            insertFile("P2_Gr212_M", hssfRow, nc++, style4);
            insertFile("P3_Gr213_M", hssfRow, nc++, style4);
            insertFile("Decision_Gr211-212-213_M", hssfRow, nc++, style4);

            insertFile("DF1_Gr221-222-223_M", hssfRow, nc++, style4);
            insertFile("DF2_Gr221-222-223_M", hssfRow, nc++, style4);
            insertFile("P1_Gr221_M", hssfRow, nc++, style4);
            insertFile("P2_Gr222_M", hssfRow, nc++, style4);
            insertFile("P3_Gr223_M", hssfRow, nc++, style4);
            insertFile("Decision_Gr221-222-223_M", hssfRow, nc++, style4);

            insertFile("DF1_Gr231-232-233_M", hssfRow, nc++, style4);
            insertFile("DF2_Gr231-232-233_M", hssfRow, nc++, style4);
            insertFile("P1_Gr231_M", hssfRow, nc++, style4);
            insertFile("P2_Gr232_M", hssfRow, nc++, style4);
            insertFile("P3_Gr233_M", hssfRow, nc++, style4);
            insertFile("Decision_Gr231-232-233_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr2311-2312_M", hssfRow, nc++, style4);
            insertFile("P1_sGr2311_M", hssfRow, nc++, style4);
            insertFile("P2_sGr2312_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr23111_23112_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr23111-23112_M", hssfRow, nc++, style4);
            insertFile("P1_sGr23111_M", hssfRow, nc++, style4);
            insertFile("P2_sGr23112_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr23111-23112_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr23121-23122_M", hssfRow, nc++, style4);
            insertFile("P1_sGr23121_M", hssfRow, nc++, style4);
            insertFile("P2_sGr23122_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr23121-23122_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr2321-2322_M", hssfRow, nc++, style4);
            insertFile("P1_sGr2321_M", hssfRow, nc++, style4);
            insertFile("P2_sGr2322_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr2321-2322_M", hssfRow, nc++, style4);

            insertFile("DF1_MG31-32-33_M", hssfRow, nc++, style5);
            insertFile("DF2_MG31-32-33_M", hssfRow, nc++, style5);
            insertFile("P1_MG31_M", hssfRow, nc++, style5);
            insertFile("P2_MG32_M", hssfRow, nc++, style5);
            insertFile("P3_MG33_M", hssfRow, nc++, style5);
            insertFile("Decision_MG31-32-33_M", hssfRow, nc++, style5);

            insertFile("DF1_Gr311-312-313_M", hssfRow, nc++, style5);
            insertFile("DF2_Gr311-312-313_M", hssfRow, nc++, style5);
            insertFile("P1_Gr311_M", hssfRow, nc++, style5);
            insertFile("P2_Gr312_M", hssfRow, nc++, style5);
            insertFile("P3_Gr313_M", hssfRow, nc++, style5);
            insertFile("Decision_Gr311-312-313_M", hssfRow, nc++, style5);

            insertFile("RESULT_M", hssfRow, nc++, style2);
                     
            int r = 1;
            tectonicSetting=new String[tabla.size()];//para guardar la asignación específica de la tectónica 
            for (int j = 0; j < tabla.size(); j++) {
                nc = 0;
                hssfRow = worksheet.createRow((short) r++);
                insertFileD(j,  hssfRow, nc++);
                insertFile(" ", hssfRow, nc++, style2);//región
                insertFile(" ", hssfRow, nc++, style2);//sampleID        
                insertFileD(tabla.get(j).getSio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getTio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getAl2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getFe2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMno(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMgo(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCao(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNa2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getK2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getP2o5(),  hssfRow, nc++);
                insertFile(" ", hssfRow, nc++, style2);//trazas que no estoy imprimiendo             
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                //variables de elementos majores y traza
                insertFile(" ", hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getSio2A(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getTio2A(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getAl2o3A(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getFe2o3tA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getMnoA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getMgoA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getCaoA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getNa2oA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getK2o(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getP2o5A(), hssfRow, nc++);

                    insertFile(" ", hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getIlrTiM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrAlM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrFeTM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMnM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMgM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrCaM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrNaM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrKM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrPM(), hssfRow, nc++);
                
                    insertFile(" ", hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getDf1_SG1_2_3Md(), hssfRow, nc++);//41
                    insertFileD(tabla.get(j).getDf2_SG1_2_3Md(), hssfRow, nc++);//42
                    insertFileD(tabla.get(j).getP1_SG1M(), hssfRow, nc++);//43
                    insertFileD(tabla.get(j).getP2_SG2M(), hssfRow, nc++);//44
                    insertFileD(tabla.get(j).getP3_SG3M(), hssfRow, nc++);//45
                    insertFile(tabla.get(j).getDecision_SG1_2_3M(), hssfRow, nc++,style2);//46                    
                   
                    nc=46;                       
                    if ("SG3".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){
                            //System.out.println("cuando entro a SG3: aplico MG31_32_33 ..."+tabla.get(j).getDecision_MG31_32_33M());
                            insertFileD(tabla.get(j).getDf1_MG31_32_33Md(), hssfRow, nc+75);//75
                            insertFileD(tabla.get(j).getDf2_MG31_32_33Md(), hssfRow, nc+76);
                            insertFileD(tabla.get(j).getP1_MG31M(), hssfRow, nc+77);
                            insertFileD(tabla.get(j).getP2_MG32M(), hssfRow, nc+78);
                            insertFileD(tabla.get(j).getP3_MG33M(), hssfRow, nc+79);
                            insertFile(tabla.get(j).getDecision_MG31_32_33M(), hssfRow, nc+80, style2);                            
                            
                            if ("MG31".equalsIgnoreCase(tabla.get(j).getDecision_MG31_32_33M())){
                                //System.out.println("cuando entro a SG3_ y luego a MG31: aplico Gr311_312_313 ..."+tabla.get(j).getDecision_Gr311_312_313M());
                                insertFileD(tabla.get(j).getDf1_Gr311_312_313Md(), hssfRow, nc+81);
                                insertFileD(tabla.get(j).getDf2_Gr311_312_313Md(), hssfRow, nc+82);
                                insertFileD(tabla.get(j).getP1_Gr311M(), hssfRow, nc+83);
                                insertFileD(tabla.get(j).getP2_Gr312M(), hssfRow, nc+84);
                                insertFileD(tabla.get(j).getP3_Gr313M(), hssfRow, nc+85);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313M(), hssfRow, nc+86, style2);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313M(), hssfRow, nc+87, style2);
                                
                            }else{
                               insertFile(tabla.get(j).getDecision_MG31_32_33M(), hssfRow, nc+87, style2); 
                            //System.out.println("cuando entro a SG3_ y luego NO es MG31: entonces es: "+tabla.get(j).getDecision_MG31_32_33M());
                            }
                        } 
                    if ("SG1".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){                    
                        insertFileD(tabla.get(j).getDf1_MG11_12_13Md(), hssfRow, nc+1);
                        insertFileD(tabla.get(j).getDf2_MG11_12_13Md(), hssfRow, nc+2);
                        insertFileD(tabla.get(j).getP1_MG11M(), hssfRow, nc+3);
                        insertFileD(tabla.get(j).getP2_MG12M(), hssfRow, nc+4);
                        insertFileD(tabla.get(j).getP3_MG13M(), hssfRow, nc+5);
                        insertFile(tabla.get(j).getDecision_MG11_12_13M(), hssfRow, nc+6, style2);
                    
                        if ("MG11".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M())){
                            insertFileD(tabla.get(j).getDf1_Gr111_112_113Md(), hssfRow, nc+7);
                            insertFileD(tabla.get(j).getDf2_Gr111_112_113Md(), hssfRow, nc+8);
                            insertFileD(tabla.get(j).getP1_Gr111M(), hssfRow, nc+9);
                            insertFileD(tabla.get(j).getP2_Gr112M(), hssfRow, nc+10);
                            insertFileD(tabla.get(j).getP3_Gr113M(), hssfRow, nc+11);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113M(), hssfRow, nc+12, style2);
                            
                            if ("Gr111".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M())){
                                insertFileD(tabla.get(j).getDf1_sGr1111_1112_1113Md(), hssfRow, nc+13);                    
                                insertFileD(tabla.get(j).getDf2_sGr1111_1112_1113Md(), hssfRow, nc+14);
                                insertFileD(tabla.get(j).getP1_sGr1111M(), hssfRow, nc+15);
                                insertFileD(tabla.get(j).getP2_sGr1112M(), hssfRow, nc+16);
                                insertFileD(tabla.get(j).getP3_sGr1113M(), hssfRow, nc+17);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113M(), hssfRow, nc+18, style2);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113M(), hssfRow, nc+87, style2);//resultM
                            }
                            if ("Gr112".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M())){
                                insertFileD(tabla.get(j).getDf0_sGr1121_1122Md(), hssfRow, nc+19);
                                insertFileD(tabla.get(j).getP1_sGr1121M(), hssfRow, nc+20);
                                insertFileD(tabla.get(j).getP2_sGr1122M(), hssfRow, nc+21);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122M(), hssfRow, nc+22, style2);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122M(), hssfRow, nc+87, style2);
                            }
                            if ("Gr113".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M()))
                                insertFile(tabla.get(j).getDecision_Gr111_112_113M(), hssfRow, nc+87, style2);    
                        }if ("MG12".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M())){
                            insertFileD(tabla.get(j).getDf0_Gr121_122Md(), hssfRow, nc+23);
                            insertFileD(tabla.get(j).getP1_Gr121M(), hssfRow, nc+24);
                            insertFileD(tabla.get(j).getP2_Gr122M(), hssfRow, nc+25);
                            insertFile(tabla.get(j).getDecision_Gr121_122M(), hssfRow, nc+26, style2);
                            
                            if ("Gr121".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122M())){
                                insertFileD(tabla.get(j).getDf0_sGr1211_1212Md(), hssfRow, nc+27);
                                insertFileD(tabla.get(j).getP1_sGr1211M(), hssfRow, nc+28);
                                insertFileD(tabla.get(j).getP2_sGr1212M(), hssfRow, nc+29);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212M(), hssfRow, nc+30,style2);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212M(), hssfRow, nc+87,style2);
                               }
                           if ("Gr122".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122M())){
                                insertFileD(tabla.get(j).getDf0_sGr1221_1222Md(), hssfRow, nc+31 );
                                insertFileD(tabla.get(j).getP1_sGr1221M(), hssfRow, nc+32);
                                insertFileD(tabla.get(j).getP2_sGr1222M(), hssfRow, nc+33);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222M(), hssfRow, nc+34, style2);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222M(), hssfRow, nc+87, style2);
                            }
                        }if ("MG13".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M()))
                            insertFile(tabla.get(j).getDecision_MG11_12_13M(), hssfRow, nc+87, style2);
                     }
                    if ("SG2".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){
                        insertFileD(tabla.get(j).getDf1_MG21_22_23Md(), hssfRow, nc+35);
                        insertFileD(tabla.get(j).getDf2_MG21_22_23Md(), hssfRow, nc+36);
                        insertFileD(tabla.get(j).getP1_MG21M(), hssfRow, nc+37);
                        insertFileD(tabla.get(j).getP2_MG22M(), hssfRow, nc+38);
                        insertFileD(tabla.get(j).getP3_MG23M(), hssfRow, nc+39);
                        insertFile(tabla.get(j).getDecision_MG21_22_23M(), hssfRow, nc+40, style2);
                        if ("MG21".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr211_212_213Md(), hssfRow, nc+41);
                            insertFileD(tabla.get(j).getDf2_Gr211_212_213Md(), hssfRow, nc+42);
                            insertFileD(tabla.get(j).getP1_Gr211M(), hssfRow, nc+43);
                            insertFileD(tabla.get(j).getP2_Gr212M(), hssfRow, nc+44);
                            insertFileD(tabla.get(j).getP3_Gr213M(), hssfRow, nc+45);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213M(), hssfRow, nc+46, style2);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213M(), hssfRow, nc+87, style2);
                        }if ("MG22".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr221_222_223Md(), hssfRow, nc+47);
                            insertFileD(tabla.get(j).getDf2_Gr221_222_223Md(), hssfRow, nc+48);
                            insertFileD(tabla.get(j).getP1_Gr221M(), hssfRow, nc+49);
                            insertFileD(tabla.get(j).getP2_Gr222M(), hssfRow, nc+50);
                            insertFileD(tabla.get(j).getP3_Gr223M(), hssfRow, nc+51);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223M(), hssfRow, nc+52, style2);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223M(), hssfRow, nc+87, style2);
                        }if ("MG23".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr231_232_233Md(), hssfRow, nc+53);
                            insertFileD(tabla.get(j).getDf2_Gr231_232_233Md(), hssfRow, nc+54);
                            insertFileD(tabla.get(j).getP1_Gr231M(), hssfRow, nc+55);
                            insertFileD(tabla.get(j).getP2_Gr232M(), hssfRow, nc+56);
                            insertFileD(tabla.get(j).getP3_Gr233M(), hssfRow, nc+57);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfRow, nc+58, style2);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfRow, nc+87, style2);
                            //System.out.println("****p1, p2, p3 "+tabla.get(j).getP1_Gr231M()+"\n"+tabla.get(j).getP2_Gr232M()+"\n"+tabla.get(j).getP3_Gr233M()+"\n");                            
                            System.out.println(" ++++++++ es 231 o 232:"+ tabla.get(j).getDecision_Gr231_232_233M() +"****p1, p2, p3 "+tabla.get(j).getP1_Gr231M()+"\n"+tabla.get(j).getP2_Gr232M()+"\n"+tabla.get(j).getP3_Gr233M()+"\n");
                            
                            
                            if((tabla.get(j).getP1_Gr231M()>tabla.get(j).getP2_Gr232M())&&(tabla.get(j).getP1_Gr231M()>tabla.get(j).getP3_Gr233M())){
//if (Objects.equals("Gr231", tabla.get(j).getDecision_Gr231_232_233M())) {
                            //if ("Gr231".equalsIgnoreCase(tabla.get(j).getDecision_Gr231_232_233M())){
                                insertFileD(tabla.get(j).getDf0_sGr2311_2312Md(), hssfRow, nc+59); //aquí ya hay ceros en todo 231 y 232 hacia abajo del árbol
                                insertFileD(tabla.get(j).getP1_sGr2311M(), hssfRow, nc+60);
                                insertFileD(tabla.get(j).getP2_sGr2312M(), hssfRow, nc+61);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312M(), hssfRow, nc+62,style2);
                                
                                System.out.println(" es sGr2311 o sGr2312:"+ tabla.get(j).getDecision_sGr2311_2312M());
                                if (tabla.get(j).getP1_sGr2311M()>tabla.get(j).getP2_sGr2312M()) {
                                    insertFileD(tabla.get(j).getDf0_sGr23111_23112Md(), hssfRow, nc+63);
                                    insertFileD(tabla.get(j).getP1_sGr23111M(), hssfRow, nc+64);
                                    insertFileD(tabla.get(j).getP2_sGr23112M(), hssfRow, nc+65);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112M(), hssfRow, nc+66, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112M(), hssfRow, nc+87, style2);
                                }else//if ("sGr2312".equalsIgnoreCase(tabla.get(j).getDecision_sGr2311_2312M()))
                                {
                                    insertFileD(tabla.get(j).getDf0_sGr23121_23122Md(), hssfRow, nc+67);
                                    insertFileD(tabla.get(j).getP1_sGr23121M(), hssfRow, nc+68);
                                    insertFileD(tabla.get(j).getP2_sGr23122M(), hssfRow, nc+69);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122M(), hssfRow, nc+70, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122M(), hssfRow, nc+87, style2);
                                }
                            }if((tabla.get(j).getP2_Gr232M()>tabla.get(j).getP1_Gr231M())&&(tabla.get(j).getP2_Gr232M()>tabla.get(j).getP3_Gr233M())){         
                            //if (Objects.equals("Gr232", tabla.get(j).getDecision_Gr231_232_233M())) {
                                insertFileD(tabla.get(j).getDf0_sGr2321_2322Md(), hssfRow, nc+71);
                                insertFileD(tabla.get(j).getP1_sGr2321M(), hssfRow, nc+72);
                                insertFileD(tabla.get(j).getP2_sGr2322M(), hssfRow, nc+73);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322M(), hssfRow, nc+74, style2);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322M(), hssfRow, nc+87, style2);
                            }if((tabla.get(j).getP3_Gr233M()>tabla.get(j).getP1_Gr231M())&&(tabla.get(j).getP3_Gr233M()>tabla.get(j).getP2_Gr232M()))
                                insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfRow, nc+87, style2);
                        
                        }
                                                   
                    } 
                //debo guardar la decisión final específica de la muestra (lo que pongo en la última columan del reporte)
                tectonicSetting[j]=hssfRow.getCell(nc+87).toString();
                
            } 
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

            //reporte2_res();
        } catch (Exception e) {

            Messagebox.show("Error in ReportRobustness.reportMT()" + e);
            e.printStackTrace();
        }
        // tabla.
    }        
    public void reportPropagationMT(String fileout) {
        try {  
            FileOutputStream fileOut = new FileOutputStream(fileout);
            HSSFWorkbook workbook = new HSSFWorkbook();      
            HSSFSheet worksheet = workbook.createSheet("Uncertainty propagation");
            
            HSSFFont font2 = workbook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(font2.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setVerticalAlignment(style2.VERTICAL_CENTER);
            style2.setAlignment(style2.ALIGN_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);
            
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.RED.index);
            font3.setBoldweight(font3.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setVerticalAlignment(style3.VERTICAL_CENTER);
            style3.setAlignment(style3.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);
            
            HSSFFont font4 = workbook.createFont();
            font4.setColor(HSSFColor.GREEN.index);
            font4.setBoldweight(font4.BOLDWEIGHT_BOLD);
            HSSFCellStyle style4 = workbook.createCellStyle();
            style4.setVerticalAlignment(style4.VERTICAL_CENTER);
            style4.setAlignment(style4.ALIGN_CENTER);
            style4.setWrapText(true);
            style4.setFont(font4);
            
             HSSFFont font5 = workbook.createFont();
            font5.setColor(HSSFColor.BROWN.index);
            font5.setBoldweight(font5.BOLDWEIGHT_BOLD);
            HSSFCellStyle style5 = workbook.createCellStyle();
            style5.setVerticalAlignment(style5.VERTICAL_CENTER);
            style5.setAlignment(style5.ALIGN_CENTER);
            style5.setWrapText(true);
            style5.setFont(font5);
            
            
                      
            HSSFRow hssfRow = worksheet.createRow((short) 0);
            int nc = 0;
            insertFile("Consecutive",  hssfRow, nc++,style2);
            insertFile("SiO2",  hssfRow, nc++,style2);
            insertFile("TiO2",  hssfRow, nc++,style2);
            insertFile("Al2O3",  hssfRow, nc++,style2);
            insertFile("Fe2O3T",  hssfRow, nc++,style2);
            insertFile("MnO",  hssfRow, nc++,style2);
            insertFile("MgO",  hssfRow, nc++,style2);
            insertFile("CaO",  hssfRow, nc++,style2);
            insertFile("Na2O",  hssfRow, nc++,style2);
            insertFile("K2O",  hssfRow, nc++,style2); 
            insertFile("P2O5",  hssfRow, nc++,style2); 
            insertFile("Cr",  hssfRow, nc++,style2);
            insertFile("Nb",  hssfRow, nc++,style2);
            insertFile("Ni",  hssfRow, nc++,style2);
            insertFile("V",  hssfRow, nc++,style2);
            insertFile("Y",  hssfRow, nc++,style2);
            insertFile("Zr",  hssfRow, nc++,style2);
             //cabecera de elementos Major and traza
            insertFile("Adj Major and Trace",  hssfRow, nc++,style2);
            insertFile("SiO2adjmt",  hssfRow, nc++,style2);
            insertFile("TiO2adjmt",  hssfRow, nc++,style2);
            insertFile("Al2O3adjmt",  hssfRow, nc++,style2);
            insertFile("Fe2O3Tadjmt",  hssfRow, nc++,style2);
            insertFile("MnOadjmt",  hssfRow, nc++,style2);
            insertFile("MgOadjmt",  hssfRow, nc++,style2);
            insertFile("CaOadjmt",  hssfRow, nc++,style2);
            insertFile("Na2Oadjmt",  hssfRow, nc++,style2);
            insertFile("K2Oadjmt",  hssfRow, nc++,style2);
            insertFile("P2O5adjmt",  hssfRow, nc++,style2);
            insertFile("Cradjmt",  hssfRow, nc++,style2);
            insertFile("Nbadjmt",  hssfRow, nc++,style2);
            insertFile("Niadjmt",  hssfRow, nc++,style2);
            insertFile("Vadjmt",  hssfRow, nc++,style2);
            insertFile("Yadjmt",  hssfRow, nc++,style2);
            insertFile("ZRadjmt",  hssfRow, nc++,style2);
            
            insertFile("Ilr start here ",  hssfRow, nc++,style2);            
            insertFile("ilrTiO2mt",  hssfRow, nc++,style2);
            insertFile("ilrAl2O3mt",  hssfRow, nc++,style2);
            insertFile("ilrFe2O3Tmt",  hssfRow, nc++,style2);
            insertFile("ilrMnOmt",  hssfRow, nc++,style2);
            insertFile("ilrMgOmt",  hssfRow, nc++,style2);
            insertFile("ilrCaOmt",  hssfRow, nc++,style2);
            insertFile("ilrNa2Omt",  hssfRow, nc++,style2);
            insertFile("ilrK2Omt",  hssfRow, nc++,style2);
            insertFile("ilrP2O5mt",  hssfRow, nc++,style2);
            insertFile("ilrCrmt",  hssfRow, nc++,style2);
            insertFile("ilrNbmt",  hssfRow, nc++,style2);
            insertFile("ilrNimt",  hssfRow, nc++,style2);
            insertFile("ilrVmt",  hssfRow, nc++,style2);
            insertFile("ilrYmt",  hssfRow, nc++,style2);
            insertFile("ilrZrmt",  hssfRow, nc++,style2);            
            
             //Modelos basados elementos Majores-traza
            insertFile("MT models start here", hssfRow, nc++, style2);
            
            insertFile("DF1_SG1-2-3_MT",  hssfRow, nc++, style5);
            insertFile("DF2_SG1-2-3_MT",  hssfRow, nc++, style5);
            insertFile("P1_SG1_MT",  hssfRow, nc++, style5);
            insertFile("P2_SG2_MT",  hssfRow, nc++, style5);
            insertFile("P3_SG3_MT",  hssfRow, nc++, style5);
            insertFile("Decision_SG1-2-3_MT",  hssfRow, nc++, style5);

            insertFile("DF1_MG11-12-13_MT",  hssfRow, nc++, style3);
            insertFile("DF2_MG11-12-13_MT",  hssfRow, nc++, style3);
            insertFile("P1_MG11_MT",  hssfRow, nc++, style3);
            insertFile("P2_MG12_MT",  hssfRow, nc++, style3);
            insertFile("P3_MG13_MT",  hssfRow, nc++, style3);
            insertFile("Decision_MG11-12-13_MT",  hssfRow, nc++, style3);


            insertFile("DF1_Gr111-112-113_MT",  hssfRow, nc++, style3);
            insertFile("DF2_Gr111-112-113_MT",  hssfRow, nc++, style3);
            insertFile("P1_Gr111_MT",  hssfRow, nc++, style3);
            insertFile("P2_Gr112_MT",  hssfRow, nc++, style3);
            insertFile("P3_Gr113_MT",  hssfRow, nc++, style3);
            insertFile("Decision_Gr111-112-113_MT",  hssfRow, nc++, style3);


            insertFile("DF1_sGr1111-1112-1113_MT",  hssfRow, nc++, style3);
            insertFile("DF2_sGr1111-1112-1113_MT",  hssfRow, nc++, style3);
            insertFile("P1_sGr1111_MT",  hssfRow, nc++, style3);
            insertFile("P2_sGr1112_MT",  hssfRow, nc++, style3);
            insertFile("P3_sGr1113_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1111-1112-1113_MT",  hssfRow, nc++, style3);


            insertFile("DF0_sGr1121-1122_MT",  hssfRow, nc++, style3);
            insertFile("P1_1121_MT",  hssfRow, nc++, style3);
            insertFile("P2_1122_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1121-1122_MT",  hssfRow, nc++, style3);


            insertFile("DF0_Gr121-122_MT",  hssfRow, nc++, style3);
            insertFile("P1_Gr121_MT",  hssfRow, nc++, style3);
            insertFile("P2_Gr122_MT",  hssfRow, nc++, style3);
            insertFile("Decision_Gr121-122_MT",  hssfRow, nc++, style3);


            insertFile("DF0_sGr1211-1212_MT",  hssfRow, nc++, style3);
            insertFile("P1_sGr1211_MT",  hssfRow, nc++, style3);
            insertFile("P2_sGr1212_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1211-1212_MT",  hssfRow, nc++, style3);


            insertFile("DF0_sGr1221-1222_MT",  hssfRow, nc++, style3);
            insertFile("P1_sGr1221_MT",  hssfRow, nc++, style3);
            insertFile("P2_sGr1222_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1221-1222_MT",  hssfRow, nc++, style3);

            insertFile("DF1_MG21-22-23_MT",  hssfRow, nc++, style4);
            insertFile("DF2_MG21-22-23_MT",  hssfRow, nc++, style4);
            insertFile("P1_MG21_MT",  hssfRow, nc++, style4);
            insertFile("P2_MG22_MT",  hssfRow, nc++, style4);
            insertFile("P3_MG23_MT",  hssfRow, nc++, style4);
            insertFile("Decision_MG21-22-23_MT",  hssfRow, nc++, style4);

            insertFile("DF1_Gr211-212-213_MT",  hssfRow, nc++, style4);
            insertFile("DF2_Gr211-212-213_MT",  hssfRow, nc++, style4);
            insertFile("P1_Gr211_MT",  hssfRow, nc++, style4);
            insertFile("P2_Gr212_MT",  hssfRow, nc++, style4);
            insertFile("P3_Gr213_MT",  hssfRow, nc++, style4);
            insertFile("Decision_Gr211-212-213_MT",  hssfRow, nc++, style4);

            insertFile("DF1_Gr221-222-223_MT",  hssfRow, nc++, style4);
            insertFile("DF2_Gr221-222-223_MT",  hssfRow, nc++, style4);
            insertFile("P1_Gr221_MT",  hssfRow, nc++, style4);
            insertFile("P2_Gr222_MT",  hssfRow, nc++, style4);
            insertFile("P3_Gr223_MT",  hssfRow, nc++, style4);
            insertFile("Decision_Gr221-222-223_MT",  hssfRow, nc++, style4);

            insertFile("DF1_Gr231-232-233_MT",  hssfRow, nc++, style4);
            insertFile("DF2_Gr231-232-233_MT",  hssfRow, nc++, style4);
            insertFile("P1_Gr231_MT",  hssfRow, nc++, style4);
            insertFile("P2_Gr232_MT",  hssfRow, nc++, style4);
            insertFile("P3_Gr233_MT",  hssfRow, nc++, style4);
            insertFile("Decision_Gr231-232-233_MT",  hssfRow, nc++, style4);

            insertFile("DF0_sGr2311-2312_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr2311_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr2312_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr23111_23112_MT",  hssfRow, nc++, style4);

            insertFile("DF0_sGr23111-23112_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr23111_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr23112_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr23111-23112_MT",  hssfRow, nc++, style4);

            insertFile("DF0_sGr23121-23122_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr23121_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr23122_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr23121-23122_MT",  hssfRow, nc++, style4);


            insertFile("DF0_sGr2321-2322_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr2321_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr2322_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr2321-2322_MT",  hssfRow, nc++, style4);



            insertFile("DF1_MG31-32-33_MT",  hssfRow, nc++, style5);
            insertFile("DF2_MG31-32-33_MT",  hssfRow, nc++, style5);
            insertFile("P1_MG31_MT",  hssfRow, nc++, style5);
            insertFile("P2_MG32_MT",  hssfRow, nc++, style5);
            insertFile("P3_MG33_MT",  hssfRow, nc++, style5);
            insertFile("Decision_MG31-32-33_MT",  hssfRow, nc++, style5);

            insertFile("DF1_Gr311-312-313_MT",  hssfRow, nc++, style5);
            insertFile("DF2_Gr311-312-313_MT",  hssfRow, nc++, style5);
            insertFile("P1_Gr311_MT",  hssfRow, nc++, style5);
            insertFile("P2_Gr312_MT",  hssfRow, nc++, style5);
            insertFile("P3_Gr313_MT",  hssfRow, nc++, style5);
            insertFile("Decision_Gr311-312-313_MT",  hssfRow, nc++, style5);

            insertFile("RESULT_MT",  hssfRow, nc++, style2);
            tectonicSetting=new String[tabla.size()];//para guardar la asignación específica de la tectónica   
            
            int r = 1;
            for (int j = 0; j < tabla.size(); j++) {
                nc = 0;
                hssfRow = worksheet.createRow((short) r++);
                insertFile(" ",  hssfRow, nc++,style2);
                insertFileD(tabla.get(j).getSio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getTio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getAl2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getFe2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMno(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMgo(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCao(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNa2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getK2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getP2o5(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCr(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNb(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNi(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getV(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getY(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getZr(),  hssfRow, nc++);
                
                //variables de elementos majores y traza
                insertFile(" ",  hssfRow, nc++,style2);
                insertFileD(tabla.get(j).getSio2mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getTio2mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getAl2o3mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getFe2o3tmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMnomtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMgomtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCaomtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNa2omtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getK2omtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getP2o5mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCrmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNbmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNimtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getVmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getYmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getZrmtA(),  hssfRow, nc++);

                insertFile(" ",  hssfRow, nc++,style2);
                insertFileD(tabla.get(j).getIlrTiMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrAlMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrFeTMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrMnMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrMgMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrCaMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrNaMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrKMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrPMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrCrMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrNbMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrNiMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrVMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrYMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrZrMT(),  hssfRow, nc++);
                              
                insertFile(" ",  hssfRow, nc++, style2);
                insertFileD(tabla.get(j).getDf1_SG1_2_3MTd(),  hssfRow, nc++);//41
                insertFileD(tabla.get(j).getDf2_SG1_2_3MTd(),  hssfRow, nc++);//42
                insertFileD(tabla.get(j).getP1_SG1MT(),  hssfRow, nc++);//43
                insertFileD(tabla.get(j).getP2_SG2MT(),  hssfRow, nc++);//44
                insertFileD(tabla.get(j).getP3_SG3MT(),  hssfRow, nc++);//45
                insertFile(tabla.get(j).getDecision_SG1_2_3MT(),  hssfRow, nc++,style2);//46
                    
                nc=58;//ES EL NÚMERO DE COLUMNAS QUE ESTÁN ANTES DE LA DECISIÓN DEL PRIMER DIAGRAMA GENERAL, 
          
                if ("SG3".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){
                            //System.out.println("cuando entro a SG3: aplico MG31_32_33 ..."+tabla.get(j).getDecision_MG31_32_33MT());
                            insertFileD(tabla.get(j).getDf1_MG31_32_33MTd(),  hssfRow, nc+75);//75
                            insertFileD(tabla.get(j).getDf2_MG31_32_33MTd(),  hssfRow, nc+76);
                            insertFileD(tabla.get(j).getP1_MG31MT(),  hssfRow, nc+77);
                            insertFileD(tabla.get(j).getP2_MG32MT(),  hssfRow, nc+78);
                            insertFileD(tabla.get(j).getP3_MG33MT(),  hssfRow, nc+79);
                            insertFile(tabla.get(j).getDecision_MG31_32_33MT(),  hssfRow, nc+80, style2);                            
                            
                            if ("MG31".equalsIgnoreCase(tabla.get(j).getDecision_MG31_32_33MT())){
                                //System.out.println("cuando entro a SG3_ y luego a MG31: aplico Gr311_312_313 ..."+tabla.get(j).getDecision_Gr311_312_313MT());
                                insertFileD(tabla.get(j).getDf1_Gr311_312_313MTd(),  hssfRow, nc+81);
                                insertFileD(tabla.get(j).getDf2_Gr311_312_313MTd(),  hssfRow, nc+82);
                                insertFileD(tabla.get(j).getP1_Gr311MT(),  hssfRow, nc+83);
                                insertFileD(tabla.get(j).getP2_Gr312MT(),  hssfRow, nc+84);
                                insertFileD(tabla.get(j).getP3_Gr313MT(),  hssfRow, nc+85);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313MT(),  hssfRow, nc+86, style2);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313MT(),  hssfRow, nc+87, style2);
                                
                            }else{
                               insertFile(tabla.get(j).getDecision_MG31_32_33MT(),  hssfRow, nc+87, style2); 
                            //System.out.println("cuando entro a SG3_ y luego NO es MG31: entonces es: "+tabla.get(j).getDecision_MG31_32_33MT());
                            }
                        } 
                    if ("SG1".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){                    
                        insertFileD(tabla.get(j).getDf1_MG11_12_13MTd(),  hssfRow, nc+1);
                        insertFileD(tabla.get(j).getDf2_MG11_12_13MTd(),  hssfRow, nc+2);
                        insertFileD(tabla.get(j).getP1_MG11MT(),  hssfRow, nc+3);
                        insertFileD(tabla.get(j).getP2_MG12MT(),  hssfRow, nc+4);
                        insertFileD(tabla.get(j).getP3_MG13MT(),  hssfRow, nc+5);
                        insertFile(tabla.get(j).getDecision_MG11_12_13MT(),  hssfRow, nc+6, style2);
                    
                        if ("MG11".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT())){
                            insertFileD(tabla.get(j).getDf1_Gr111_112_113MTd(),  hssfRow, nc+7);
                            insertFileD(tabla.get(j).getDf2_Gr111_112_113MTd(),  hssfRow, nc+8);
                            insertFileD(tabla.get(j).getP1_Gr111MT(),  hssfRow, nc+9);
                            insertFileD(tabla.get(j).getP2_Gr112MT(),  hssfRow, nc+10);
                            insertFileD(tabla.get(j).getP3_Gr113MT(),  hssfRow, nc+11);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113MT(),  hssfRow, nc+12, style2);
                            
                            if ("Gr111".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT())){
                                insertFileD(tabla.get(j).getDf1_sGr1111_1112_1113MTd(),  hssfRow, nc+13);                    
                                insertFileD(tabla.get(j).getDf2_sGr1111_1112_1113MTd(),  hssfRow, nc+14);
                                insertFileD(tabla.get(j).getP1_sGr1111MT(),  hssfRow, nc+15);
                                insertFileD(tabla.get(j).getP2_sGr1112MT(),  hssfRow, nc+16);
                                insertFileD(tabla.get(j).getP3_sGr1113MT(),  hssfRow, nc+17);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113MT(),  hssfRow, nc+18, style2);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113MT(),  hssfRow, nc+87, style2);//resultM
                            }
                            if ("Gr112".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1121_1122MTd(),  hssfRow, nc+19);
                                insertFileD(tabla.get(j).getP1_sGr1121MT(),  hssfRow, nc+20);
                                insertFileD(tabla.get(j).getP2_sGr1122MT(),  hssfRow, nc+21);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122MT(),  hssfRow, nc+22, style2);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122MT(),  hssfRow, nc+87, style2);
                            }
                            if ("Gr113".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT()))
                                insertFile(tabla.get(j).getDecision_Gr111_112_113MT(),  hssfRow, nc+87, style2);    
                        }if ("MG12".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT())){
                            insertFileD(tabla.get(j).getDf0_Gr121_122MTd(),  hssfRow, nc+23);
                            insertFileD(tabla.get(j).getP1_Gr121MT(),  hssfRow, nc+24);
                            insertFileD(tabla.get(j).getP2_Gr122MT(),  hssfRow, nc+25);
                            insertFile(tabla.get(j).getDecision_Gr121_122MT(),  hssfRow, nc+26, style2);
                            
                            if ("Gr121".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1211_1212MTd(),  hssfRow, nc+27);
                                insertFileD(tabla.get(j).getP1_sGr1211MT(),  hssfRow, nc+28);
                                insertFileD(tabla.get(j).getP2_sGr1212MT(),  hssfRow, nc+29);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212MT(),  hssfRow, nc+30,style2);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212MT(),  hssfRow, nc+87,style2);
                               }
                           if ("Gr122".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1221_1222MTd(),  hssfRow, nc+31 );
                                insertFileD(tabla.get(j).getP1_sGr1221MT(),  hssfRow, nc+32);
                                insertFileD(tabla.get(j).getP2_sGr1222MT(),  hssfRow, nc+33);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222MT(),  hssfRow, nc+34, style2);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222MT(),  hssfRow, nc+87, style2);
                            }
                        }if ("MG13".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT()))
                            insertFile(tabla.get(j).getDecision_MG11_12_13MT(),  hssfRow, nc+87, style2);
                     }
                    if ("SG2".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){
                        insertFileD(tabla.get(j).getDf1_MG21_22_23MTd(),  hssfRow, nc+35);
                        insertFileD(tabla.get(j).getDf2_MG21_22_23MTd(),  hssfRow, nc+36);
                        insertFileD(tabla.get(j).getP1_MG21MT(),  hssfRow, nc+37);
                        insertFileD(tabla.get(j).getP2_MG22MT(),  hssfRow, nc+38);
                        insertFileD(tabla.get(j).getP3_MG23MT(),  hssfRow, nc+39);
                        insertFile(tabla.get(j).getDecision_MG21_22_23MT(),  hssfRow, nc+40, style2);
                        if ("MG21".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr211_212_213MTd(),  hssfRow, nc+41);
                            insertFileD(tabla.get(j).getDf2_Gr211_212_213MTd(),  hssfRow, nc+42);
                            insertFileD(tabla.get(j).getP1_Gr211MT(),  hssfRow, nc+43);
                            insertFileD(tabla.get(j).getP2_Gr212MT(),  hssfRow, nc+44);
                            insertFileD(tabla.get(j).getP3_Gr213MT(),  hssfRow, nc+45);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213MT(),  hssfRow, nc+46, style2);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213MT(),  hssfRow, nc+87, style2);
                        }if ("MG22".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr221_222_223MTd(),  hssfRow, nc+47);
                            insertFileD(tabla.get(j).getDf2_Gr221_222_223MTd(),  hssfRow, nc+48);
                            insertFileD(tabla.get(j).getP1_Gr221MT(),  hssfRow, nc+49);
                            insertFileD(tabla.get(j).getP2_Gr222MT(),  hssfRow, nc+50);
                            insertFileD(tabla.get(j).getP3_Gr223MT(),  hssfRow, nc+51);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223MT(),  hssfRow, nc+52, style2);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223MT(),  hssfRow, nc+87, style2);
                        }if ("MG23".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr231_232_233MTd(),  hssfRow, nc+53);
                            insertFileD(tabla.get(j).getDf2_Gr231_232_233MTd(),  hssfRow, nc+54);
                            insertFileD(tabla.get(j).getP1_Gr231MT(),  hssfRow, nc+55);
                            insertFileD(tabla.get(j).getP2_Gr232MT(),  hssfRow, nc+56);
                            insertFileD(tabla.get(j).getP3_Gr233MT(),  hssfRow, nc+57);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233MT(),  hssfRow, nc+58, style2);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233MT(),  hssfRow, nc+87, style2);
                            //System.out.println("****p1, p2, p3 "+tabla.get(j).getP1_Gr231MT()+"\n"+tabla.get(j).getP2_Gr232MT()+"\n"+tabla.get(j).getP3_Gr233MT()+"\n");                            
                            System.out.println(" ++++++++ es 231 o 232:"+ tabla.get(j).getDecision_Gr231_232_233MT() +"****p1, p2, p3 "+tabla.get(j).getP1_Gr231MT()+"\n"+tabla.get(j).getP2_Gr232MT()+"\n"+tabla.get(j).getP3_Gr233MT()+"\n");
                            
                            
                            if((tabla.get(j).getP1_Gr231MT()>tabla.get(j).getP2_Gr232MT())&&(tabla.get(j).getP1_Gr231MT()>tabla.get(j).getP3_Gr233MT())){
//if (Objects.equals("Gr231", tabla.get(j).getDecision_Gr231_232_233MT())) {
                            //if ("Gr231".equalsIgnoreCase(tabla.get(j).getDecision_Gr231_232_233MT())){
                                insertFileD(tabla.get(j).getDf0_sGr2311_2312MTd(),  hssfRow, nc+59); //aquí ya hay ceros en todo 231 y 232 hacia abajo del árbol
                                insertFileD(tabla.get(j).getP1_sGr2311MT(),  hssfRow, nc+60);
                                insertFileD(tabla.get(j).getP2_sGr2312MT(),  hssfRow, nc+61);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312MT(),  hssfRow, nc+62,style2);
                                
                                System.out.println(" es sGr2311 o sGr2312:"+ tabla.get(j).getDecision_sGr2311_2312MT());
                                if (tabla.get(j).getP1_sGr2311MT()>tabla.get(j).getP2_sGr2312MT()) {
                                    insertFileD(tabla.get(j).getDf0_sGr23111_23112MTd(),  hssfRow, nc+63);
                                    insertFileD(tabla.get(j).getP1_sGr23111MT(),  hssfRow, nc+64);
                                    insertFileD(tabla.get(j).getP2_sGr23112MT(),  hssfRow, nc+65);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112MT(),  hssfRow, nc+66, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112MT(),  hssfRow, nc+87, style2);
                                }else//if ("sGr2312".equalsIgnoreCase(tabla.get(j).getDecision_sGr2311_2312MT()))
                                {
                                    insertFileD(tabla.get(j).getDf0_sGr23121_23122MTd(),  hssfRow, nc+67);
                                    insertFileD(tabla.get(j).getP1_sGr23121MT(),  hssfRow, nc+68);
                                    insertFileD(tabla.get(j).getP2_sGr23122MT(),  hssfRow, nc+69);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122MT(),  hssfRow, nc+70, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122MT(),  hssfRow, nc+87, style2);
                                }
                            }if((tabla.get(j).getP2_Gr232MT()>tabla.get(j).getP1_Gr231MT())&&(tabla.get(j).getP2_Gr232MT()>tabla.get(j).getP3_Gr233MT())){         
                            //if (Objects.equals("Gr232", tabla.get(j).getDecision_Gr231_232_233MT())) {
                                insertFileD(tabla.get(j).getDf0_sGr2321_2322MTd(),  hssfRow, nc+71);
                                insertFileD(tabla.get(j).getP1_sGr2321MT(),  hssfRow, nc+72);
                                insertFileD(tabla.get(j).getP2_sGr2322MT(),  hssfRow, nc+73);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322MT(),  hssfRow, nc+74, style2);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322MT(),  hssfRow, nc+87, style2);
                            }if((tabla.get(j).getP3_Gr233MT()>tabla.get(j).getP1_Gr231MT())&&(tabla.get(j).getP3_Gr233MT()>tabla.get(j).getP2_Gr232MT()))
                                insertFile(tabla.get(j).getDecision_Gr231_232_233MT(), hssfRow, nc+87, style2);
                        
                        }
                                                   
                        }
                    //debo guardar la decisión final específica de la muestra (lo que pongo en la última columan del reporte)
                    tectonicSetting[j]=hssfRow.getCell(nc+87).toString();
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

            //reporte2_res();
        } catch (Exception e) {

            Messagebox.show("Error in ReportRobustness.reportMT()" + e);
            e.printStackTrace();
        }
        // tabla.
    }  
    
    public void reportPostemplaM(String fileout) throws IOException {           
            double Sio2maxChange, Tio2maxChange, Al2o3maxChange, FE2O3TmaxChange, MNOmaxChange, 
                    MGOmaxChange, CAOmaxChange, NA2OmaxChange, KK2OmaxChange, PP2O5maxChange;
            String Sio2Cause=null, Tio2Cause=null, Al2o3Cause=null, FE2O3TCause=null, MNOCause=null, 
                    MGOCause=null, CAOCause=null, NA2OCause=null, KK2OCause=null, PP2O5Cause=null;
        try {  
            FileOutputStream fileOut = new FileOutputStream(fileout);
            HSSFWorkbook workbook = new HSSFWorkbook();      
            HSSFSheet worksheet = workbook.createSheet("Report Summary of Post-emplacement Changes (M)");            
            
            HSSFFont font = workbook.createFont();
            font.setBoldweight(font.BOLDWEIGHT_BOLD);
            font.setColor(HSSFColor.RED.index);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setVerticalAlignment(style.VERTICAL_CENTER);
            style.setAlignment(style.ALIGN_CENTER);            
            style.setWrapText(true);
            style.setFont(font); 
            
            //Estilo con centrado vertical, alineaciÃƒÆ’Ã‚Â³n izquierda, ajuste de texto, negrita, color ????
            HSSFFont font2 = workbook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(font.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setVerticalAlignment(style2.VERTICAL_CENTER);
            style2.setAlignment(style2.ALIGN_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);
            
             //Estilo con centrado vertical, alineaciÃƒÆ’Ã‚Â³n izquierda, ajuste de texto, negrita, color ????
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.GREEN.index);
            font3.setBoldweight(font3.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setVerticalAlignment(style3.VERTICAL_CENTER);
            style3.setAlignment(style3.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);
            
            HSSFFont font4 = workbook.createFont();
            font4.setColor(HSSFColor.GREEN.index);
            font4.setBoldweight(font4.BOLDWEIGHT_BOLD);
            HSSFCellStyle style4 = workbook.createCellStyle();
            style4.setVerticalAlignment(style4.VERTICAL_CENTER);
            style4.setAlignment(style4.ALIGN_CENTER);
            style4.setWrapText(true);
            style4.setFont(font4);
           
             HSSFFont font5 = workbook.createFont();
            font5.setColor(HSSFColor.BROWN.index);
            font5.setBoldweight(font5.BOLDWEIGHT_BOLD);
            HSSFCellStyle style5 = workbook.createCellStyle();
            style5.setVerticalAlignment(style5.VERTICAL_CENTER);
            style5.setAlignment(style5.ALIGN_CENTER);
            style5.setWrapText(true);
            style5.setFont(font5);
            
            HSSFRow hssfRow = worksheet.createRow((short) 0);
            int nc = 0;
            insertFile("Consecutive",  hssfRow, nc++,style2);
            insertFile("Region",  hssfRow, nc++,style2);
            insertFile("SampID",  hssfRow, nc++,style2);
            insertFile("SiO2",  hssfRow, nc++,style2);
            insertFile("TiO2",  hssfRow, nc++,style2);
            insertFile("Al2O3",  hssfRow, nc++,style2);
            insertFile("Fe2O3T",  hssfRow, nc++,style2);
            insertFile("MnO",  hssfRow, nc++,style2);
            insertFile("MgO",  hssfRow, nc++,style2);
            insertFile("CaO",  hssfRow, nc++,style2);
            insertFile("Na2O",  hssfRow, nc++,style2);
            insertFile("K2O",  hssfRow, nc++,style2); 
            insertFile("P2O5",  hssfRow, nc++,style2); 
            insertFile("CR",  hssfRow, nc++,style2); 
            insertFile("NB",  hssfRow, nc++,style2); 
            insertFile("NI",  hssfRow, nc++,style2); 
            insertFile("V",  hssfRow, nc++,style2); 
            insertFile("Y",  hssfRow, nc++,style2); 
            insertFile("ZR",  hssfRow, nc++,style2);
            
            insertFile("Adj major start here", hssfRow, nc++, style2);            
            insertFile("SIO2adj", hssfRow, nc++, style2);
            insertFile("TIO2adj", hssfRow, nc++, style2);
            insertFile("AL2O3adj", hssfRow, nc++, style2);
            insertFile("FE2O3Tadj", hssfRow, nc++, style2);
            insertFile("MNOadj", hssfRow, nc++, style2);
            insertFile("MGOadj", hssfRow, nc++, style2);
            insertFile("CAOadj", hssfRow, nc++, style2);
            insertFile("NA2Oadj", hssfRow, nc++, style2);
            insertFile("K2Oadj", hssfRow, nc++, style2);
            insertFile("P2O5adj", hssfRow, nc++, style2);
            
             //cabecera de elementos Major and traza
            insertFile("Ilr major start here", hssfRow, nc++, style2);
            insertFile("ilrTIO2", hssfRow, nc++, style2);
            insertFile("ilrAL2O3", hssfRow, nc++, style2);
            insertFile("ilrFE2O3T", hssfRow, nc++, style2);
            insertFile("ilrMNO", hssfRow, nc++, style2);
            insertFile("ilrMGO", hssfRow, nc++, style2);
            insertFile("ilrCAO", hssfRow, nc++, style2);
            insertFile("ilrNA2O", hssfRow, nc++, style2);
            insertFile("ilrK2O", hssfRow, nc++, style2);
            insertFile("ilrP2O5", hssfRow, nc++, style2);
            
            insertFile("ilrM models start here", hssfRow, nc++, style2);
            insertFile("DF1_SG1-2-3_M", hssfRow, nc++, style5);
            insertFile("DF2_SG1-2-3_M", hssfRow, nc++, style5);
            insertFile("P1_SG1_M", hssfRow, nc++, style5);
            insertFile("P2_SG2_M", hssfRow, nc++, style5);
            insertFile("P3_SG3_M", hssfRow, nc++, style5);
            insertFile("Decision_SG1-2-3_M", hssfRow, nc++, style5);

            insertFile("DF1_MG11-12-13_M", hssfRow, nc++, style3);
            insertFile("DF2_MG11-12-13_M", hssfRow, nc++, style3);
            insertFile("P1_MG11_M", hssfRow, nc++, style3);
            insertFile("P2_MG12_M", hssfRow, nc++, style3);
            insertFile("P3_MG13_M", hssfRow, nc++, style3);
            insertFile("Decision_MG11-12-13_M", hssfRow, nc++, style3);


            insertFile("DF1_Gr111-112-113_M", hssfRow, nc++, style3);
            insertFile("DF2_Gr111-112-113_M", hssfRow, nc++, style3);
            insertFile("P1_Gr111_M", hssfRow, nc++, style3);
            insertFile("P2_Gr112_M", hssfRow, nc++, style3);
            insertFile("P3_Gr113_M", hssfRow, nc++, style3);
            insertFile("Decision_Gr111-112-113_M", hssfRow, nc++, style3);


            insertFile("DF1_sGr1111-1112-1113_M", hssfRow, nc++, style3);
            insertFile("DF2_sGr1111-1112-1113_M", hssfRow, nc++, style3);
            insertFile("P1_sGr1111_M", hssfRow, nc++, style3);
            insertFile("P2_sGr1112_M", hssfRow, nc++, style3);
            insertFile("P3_sGr1113_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1111-1112-1113_M", hssfRow, nc++, style3);


            insertFile("DF0_sGr1121-1122_M", hssfRow, nc++, style3);
            insertFile("P1_1121_M", hssfRow, nc++, style3);
            insertFile("P2_1122_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1121-1122_M", hssfRow, nc++, style3);


            insertFile("DF0_Gr121-122_M", hssfRow, nc++, style3);
            insertFile("P1_Gr121_M", hssfRow, nc++, style3);
            insertFile("P2_Gr122_M", hssfRow, nc++, style3);
            insertFile("Decision_Gr121-122_M", hssfRow, nc++, style3);


            insertFile("DF0_sGr1211-1212_M", hssfRow, nc++, style3);
            insertFile("P1_sGr1211_M", hssfRow, nc++, style3);
            insertFile("P2_sGr1212_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1211-1212_M", hssfRow, nc++, style3);


            insertFile("DF0_sGr1221-1222_M", hssfRow, nc++, style3);
            insertFile("P1_sGr1221_M", hssfRow, nc++, style3);
            insertFile("P2_sGr1222_M", hssfRow, nc++, style3);
            insertFile("Decision_sGr1221-1222_M", hssfRow, nc++, style3);

            insertFile("DF1_MG21-22-23_M", hssfRow, nc++, style4);
            insertFile("DF2_MG21-22-23_M", hssfRow, nc++, style4);
            insertFile("P1_MG21_M", hssfRow, nc++, style4);
            insertFile("P2_MG22_M", hssfRow, nc++, style4);
            insertFile("P3_MG23_M", hssfRow, nc++, style4);
            insertFile("Decision_MG21-22-23_M", hssfRow, nc++, style4);

            insertFile("DF1_Gr211-212-213_M", hssfRow, nc++, style4);
            insertFile("DF2_Gr211-212-213_M", hssfRow, nc++, style4);
            insertFile("P1_Gr211_M", hssfRow, nc++, style4);
            insertFile("P2_Gr212_M", hssfRow, nc++, style4);
            insertFile("P3_Gr213_M", hssfRow, nc++, style4);
            insertFile("Decision_Gr211-212-213_M", hssfRow, nc++, style4);

            insertFile("DF1_Gr221-222-223_M", hssfRow, nc++, style4);
            insertFile("DF2_Gr221-222-223_M", hssfRow, nc++, style4);
            insertFile("P1_Gr221_M", hssfRow, nc++, style4);
            insertFile("P2_Gr222_M", hssfRow, nc++, style4);
            insertFile("P3_Gr223_M", hssfRow, nc++, style4);
            insertFile("Decision_Gr221-222-223_M", hssfRow, nc++, style4);

            insertFile("DF1_Gr231-232-233_M", hssfRow, nc++, style4);
            insertFile("DF2_Gr231-232-233_M", hssfRow, nc++, style4);
            insertFile("P1_Gr231_M", hssfRow, nc++, style4);
            insertFile("P2_Gr232_M", hssfRow, nc++, style4);
            insertFile("P3_Gr233_M", hssfRow, nc++, style4);
            insertFile("Decision_Gr231-232-233_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr2311-2312_M", hssfRow, nc++, style4);
            insertFile("P1_sGr2311_M", hssfRow, nc++, style4);
            insertFile("P2_sGr2312_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr23111_23112_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr23111-23112_M", hssfRow, nc++, style4);
            insertFile("P1_sGr23111_M", hssfRow, nc++, style4);
            insertFile("P2_sGr23112_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr23111-23112_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr23121-23122_M", hssfRow, nc++, style4);
            insertFile("P1_sGr23121_M", hssfRow, nc++, style4);
            insertFile("P2_sGr23122_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr23121-23122_M", hssfRow, nc++, style4);

            insertFile("DF0_sGr2321-2322_M", hssfRow, nc++, style4);
            insertFile("P1_sGr2321_M", hssfRow, nc++, style4);
            insertFile("P2_sGr2322_M", hssfRow, nc++, style4);
            insertFile("Decision_sGr2321-2322_M", hssfRow, nc++, style4);

            insertFile("DF1_MG31-32-33_M", hssfRow, nc++, style5);
            insertFile("DF2_MG31-32-33_M", hssfRow, nc++, style5);
            insertFile("P1_MG31_M", hssfRow, nc++, style5);
            insertFile("P2_MG32_M", hssfRow, nc++, style5);
            insertFile("P3_MG33_M", hssfRow, nc++, style5);
            insertFile("Decision_MG31-32-33_M", hssfRow, nc++, style5);

            insertFile("DF1_Gr311-312-313_M", hssfRow, nc++, style5);
            insertFile("DF2_Gr311-312-313_M", hssfRow, nc++, style5);
            insertFile("P1_Gr311_M", hssfRow, nc++, style5);
            insertFile("P2_Gr312_M", hssfRow, nc++, style5);
            insertFile("P3_Gr313_M", hssfRow, nc++, style5);
            insertFile("Decision_Gr311-312-313_M", hssfRow, nc++, style5);

            insertFile("RESULT_M", hssfRow, nc++, style2);
             
            int r = 1, fin=0; 
            boolean tectonicSettingChanged=false;            
            tectonicSetting=new String[tabla.size()];//para guardar la asignación específica de la tectónica             
            for (int j = 0; j < tabla.size(); j++) {                
                nc = 0;
                hssfRow = worksheet.createRow((short) r++);
                insertFileD(j,  hssfRow, nc++);
                insertFile(" ", hssfRow, nc++, style2);//región
                insertFile(" ", hssfRow, nc++, style2);//sampleID        
                insertFileD(tabla.get(j).getSio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getTio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getAl2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getFe2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMno(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMgo(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCao(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNa2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getK2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getP2o5(),  hssfRow, nc++);
                insertFile(" ", hssfRow, nc++, style2);//trazas que no estoy imprimiendo             
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                insertFile(" ", hssfRow, nc++, style2);                
                //variables de elementos majores y traza
                insertFile(" ", hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getSio2A(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getTio2A(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getAl2o3A(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getFe2o3tA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getMnoA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getMgoA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getCaoA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getNa2oA(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getK2o(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getP2o5A(), hssfRow, nc++);

                    insertFile(" ", hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getIlrTiM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrAlM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrFeTM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMnM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrMgM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrCaM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrNaM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrKM(), hssfRow, nc++);
                    insertFileD(tabla.get(j).getIlrPM(), hssfRow, nc++);
                
                    insertFile(" ", hssfRow, nc++, style2);
                    insertFileD(tabla.get(j).getDf1_SG1_2_3Md(), hssfRow, nc++);//41
                    insertFileD(tabla.get(j).getDf2_SG1_2_3Md(), hssfRow, nc++);//42
                    insertFileD(tabla.get(j).getP1_SG1M(), hssfRow, nc++);//43
                    insertFileD(tabla.get(j).getP2_SG2M(), hssfRow, nc++);//44
                    insertFileD(tabla.get(j).getP3_SG3M(), hssfRow, nc++);//45
                    insertFile(tabla.get(j).getDecision_SG1_2_3M(), hssfRow, nc++,style2);//46                    
                   
                    nc=46;                       
                    if ("SG3".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){
                            //System.out.println("cuando entro a SG3: aplico MG31_32_33 ..."+tabla.get(j).getDecision_MG31_32_33M());
                            insertFileD(tabla.get(j).getDf1_MG31_32_33Md(), hssfRow, nc+75);//75
                            insertFileD(tabla.get(j).getDf2_MG31_32_33Md(), hssfRow, nc+76);
                            insertFileD(tabla.get(j).getP1_MG31M(), hssfRow, nc+77);
                            insertFileD(tabla.get(j).getP2_MG32M(), hssfRow, nc+78);
                            insertFileD(tabla.get(j).getP3_MG33M(), hssfRow, nc+79);
                            insertFile(tabla.get(j).getDecision_MG31_32_33M(), hssfRow, nc+80, style2);                            
                            
                            if ("MG31".equalsIgnoreCase(tabla.get(j).getDecision_MG31_32_33M())){
                                //System.out.println("cuando entro a SG3_ y luego a MG31: aplico Gr311_312_313 ..."+tabla.get(j).getDecision_Gr311_312_313M());
                                insertFileD(tabla.get(j).getDf1_Gr311_312_313Md(), hssfRow, nc+81);
                                insertFileD(tabla.get(j).getDf2_Gr311_312_313Md(), hssfRow, nc+82);
                                insertFileD(tabla.get(j).getP1_Gr311M(), hssfRow, nc+83);
                                insertFileD(tabla.get(j).getP2_Gr312M(), hssfRow, nc+84);
                                insertFileD(tabla.get(j).getP3_Gr313M(), hssfRow, nc+85);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313M(), hssfRow, nc+86, style2);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313M(), hssfRow, nc+87, style2);
                                
                            }else{
                               insertFile(tabla.get(j).getDecision_MG31_32_33M(), hssfRow, nc+87, style2); 
                            //System.out.println("cuando entro a SG3_ y luego NO es MG31: entonces es: "+tabla.get(j).getDecision_MG31_32_33M());
                            }
                        } 
                    if ("SG1".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){                    
                        insertFileD(tabla.get(j).getDf1_MG11_12_13Md(), hssfRow, nc+1);
                        insertFileD(tabla.get(j).getDf2_MG11_12_13Md(), hssfRow, nc+2);
                        insertFileD(tabla.get(j).getP1_MG11M(), hssfRow, nc+3);
                        insertFileD(tabla.get(j).getP2_MG12M(), hssfRow, nc+4);
                        insertFileD(tabla.get(j).getP3_MG13M(), hssfRow, nc+5);
                        insertFile(tabla.get(j).getDecision_MG11_12_13M(), hssfRow, nc+6, style2);
                    
                        if ("MG11".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M())){
                            insertFileD(tabla.get(j).getDf1_Gr111_112_113Md(), hssfRow, nc+7);
                            insertFileD(tabla.get(j).getDf2_Gr111_112_113Md(), hssfRow, nc+8);
                            insertFileD(tabla.get(j).getP1_Gr111M(), hssfRow, nc+9);
                            insertFileD(tabla.get(j).getP2_Gr112M(), hssfRow, nc+10);
                            insertFileD(tabla.get(j).getP3_Gr113M(), hssfRow, nc+11);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113M(), hssfRow, nc+12, style2);
                            
                            if ("Gr111".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M())){
                                insertFileD(tabla.get(j).getDf1_sGr1111_1112_1113Md(), hssfRow, nc+13);                    
                                insertFileD(tabla.get(j).getDf2_sGr1111_1112_1113Md(), hssfRow, nc+14);
                                insertFileD(tabla.get(j).getP1_sGr1111M(), hssfRow, nc+15);
                                insertFileD(tabla.get(j).getP2_sGr1112M(), hssfRow, nc+16);
                                insertFileD(tabla.get(j).getP3_sGr1113M(), hssfRow, nc+17);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113M(), hssfRow, nc+18, style2);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113M(), hssfRow, nc+87, style2);//resultM
                            }
                            if ("Gr112".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M())){
                                insertFileD(tabla.get(j).getDf0_sGr1121_1122Md(), hssfRow, nc+19);
                                insertFileD(tabla.get(j).getP1_sGr1121M(), hssfRow, nc+20);
                                insertFileD(tabla.get(j).getP2_sGr1122M(), hssfRow, nc+21);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122M(), hssfRow, nc+22, style2);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122M(), hssfRow, nc+87, style2);
                            }
                            if ("Gr113".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113M()))
                                insertFile(tabla.get(j).getDecision_Gr111_112_113M(), hssfRow, nc+87, style2);    
                        }if ("MG12".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M())){
                            insertFileD(tabla.get(j).getDf0_Gr121_122Md(), hssfRow, nc+23);
                            insertFileD(tabla.get(j).getP1_Gr121M(), hssfRow, nc+24);
                            insertFileD(tabla.get(j).getP2_Gr122M(), hssfRow, nc+25);
                            insertFile(tabla.get(j).getDecision_Gr121_122M(), hssfRow, nc+26, style2);
                            
                            if ("Gr121".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122M())){
                                insertFileD(tabla.get(j).getDf0_sGr1211_1212Md(), hssfRow, nc+27);
                                insertFileD(tabla.get(j).getP1_sGr1211M(), hssfRow, nc+28);
                                insertFileD(tabla.get(j).getP2_sGr1212M(), hssfRow, nc+29);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212M(), hssfRow, nc+30,style2);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212M(), hssfRow, nc+87,style2);
                               }
                           if ("Gr122".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122M())){
                                insertFileD(tabla.get(j).getDf0_sGr1221_1222Md(), hssfRow, nc+31 );
                                insertFileD(tabla.get(j).getP1_sGr1221M(), hssfRow, nc+32);
                                insertFileD(tabla.get(j).getP2_sGr1222M(), hssfRow, nc+33);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222M(), hssfRow, nc+34, style2);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222M(), hssfRow, nc+87, style2);
                            }
                        }if ("MG13".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13M()))
                            insertFile(tabla.get(j).getDecision_MG11_12_13M(), hssfRow, nc+87, style2);
                     }
                    if ("SG2".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3M())){
                        insertFileD(tabla.get(j).getDf1_MG21_22_23Md(), hssfRow, nc+35);
                        insertFileD(tabla.get(j).getDf2_MG21_22_23Md(), hssfRow, nc+36);
                        insertFileD(tabla.get(j).getP1_MG21M(), hssfRow, nc+37);
                        insertFileD(tabla.get(j).getP2_MG22M(), hssfRow, nc+38);
                        insertFileD(tabla.get(j).getP3_MG23M(), hssfRow, nc+39);
                        insertFile(tabla.get(j).getDecision_MG21_22_23M(), hssfRow, nc+40, style2);
                        if ("MG21".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr211_212_213Md(), hssfRow, nc+41);
                            insertFileD(tabla.get(j).getDf2_Gr211_212_213Md(), hssfRow, nc+42);
                            insertFileD(tabla.get(j).getP1_Gr211M(), hssfRow, nc+43);
                            insertFileD(tabla.get(j).getP2_Gr212M(), hssfRow, nc+44);
                            insertFileD(tabla.get(j).getP3_Gr213M(), hssfRow, nc+45);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213M(), hssfRow, nc+46, style2);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213M(), hssfRow, nc+87, style2);
                        }if ("MG22".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr221_222_223Md(), hssfRow, nc+47);
                            insertFileD(tabla.get(j).getDf2_Gr221_222_223Md(), hssfRow, nc+48);
                            insertFileD(tabla.get(j).getP1_Gr221M(), hssfRow, nc+49);
                            insertFileD(tabla.get(j).getP2_Gr222M(), hssfRow, nc+50);
                            insertFileD(tabla.get(j).getP3_Gr223M(), hssfRow, nc+51);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223M(), hssfRow, nc+52, style2);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223M(), hssfRow, nc+87, style2);
                        }if ("MG23".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23M())){
                            insertFileD(tabla.get(j).getDf1_Gr231_232_233Md(), hssfRow, nc+53);
                            insertFileD(tabla.get(j).getDf2_Gr231_232_233Md(), hssfRow, nc+54);
                            insertFileD(tabla.get(j).getP1_Gr231M(), hssfRow, nc+55);
                            insertFileD(tabla.get(j).getP2_Gr232M(), hssfRow, nc+56);
                            insertFileD(tabla.get(j).getP3_Gr233M(), hssfRow, nc+57);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfRow, nc+58, style2);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfRow, nc+87, style2);
                            //System.out.println("****p1, p2, p3 "+tabla.get(j).getP1_Gr231M()+"\n"+tabla.get(j).getP2_Gr232M()+"\n"+tabla.get(j).getP3_Gr233M()+"\n");                            
                            System.out.println(" ++++++++ es 231 o 232:"+ tabla.get(j).getDecision_Gr231_232_233M() +"****p1, p2, p3 "+tabla.get(j).getP1_Gr231M()+"\n"+tabla.get(j).getP2_Gr232M()+"\n"+tabla.get(j).getP3_Gr233M()+"\n");
                            
                            
                            if((tabla.get(j).getP1_Gr231M()>tabla.get(j).getP2_Gr232M())&&(tabla.get(j).getP1_Gr231M()>tabla.get(j).getP3_Gr233M())){
//if (Objects.equals("Gr231", tabla.get(j).getDecision_Gr231_232_233M())) {
                            //if ("Gr231".equalsIgnoreCase(tabla.get(j).getDecision_Gr231_232_233M())){
                                insertFileD(tabla.get(j).getDf0_sGr2311_2312Md(), hssfRow, nc+59); //aquí ya hay ceros en todo 231 y 232 hacia abajo del árbol
                                insertFileD(tabla.get(j).getP1_sGr2311M(), hssfRow, nc+60);
                                insertFileD(tabla.get(j).getP2_sGr2312M(), hssfRow, nc+61);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312M(), hssfRow, nc+62,style2);
                                
                                System.out.println(" es sGr2311 o sGr2312:"+ tabla.get(j).getDecision_sGr2311_2312M());
                                if (tabla.get(j).getP1_sGr2311M()>tabla.get(j).getP2_sGr2312M()) {
                                    insertFileD(tabla.get(j).getDf0_sGr23111_23112Md(), hssfRow, nc+63);
                                    insertFileD(tabla.get(j).getP1_sGr23111M(), hssfRow, nc+64);
                                    insertFileD(tabla.get(j).getP2_sGr23112M(), hssfRow, nc+65);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112M(), hssfRow, nc+66, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112M(), hssfRow, nc+87, style2);
                                }else//if ("sGr2312".equalsIgnoreCase(tabla.get(j).getDecision_sGr2311_2312M()))
                                {
                                    insertFileD(tabla.get(j).getDf0_sGr23121_23122Md(), hssfRow, nc+67);
                                    insertFileD(tabla.get(j).getP1_sGr23121M(), hssfRow, nc+68);
                                    insertFileD(tabla.get(j).getP2_sGr23122M(), hssfRow, nc+69);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122M(), hssfRow, nc+70, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122M(), hssfRow, nc+87, style2);
                                }
                            }if((tabla.get(j).getP2_Gr232M()>tabla.get(j).getP1_Gr231M())&&(tabla.get(j).getP2_Gr232M()>tabla.get(j).getP3_Gr233M())){         
                            //if (Objects.equals("Gr232", tabla.get(j).getDecision_Gr231_232_233M())) {
                                insertFileD(tabla.get(j).getDf0_sGr2321_2322Md(), hssfRow, nc+71);
                                insertFileD(tabla.get(j).getP1_sGr2321M(), hssfRow, nc+72);
                                insertFileD(tabla.get(j).getP2_sGr2322M(), hssfRow, nc+73);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322M(), hssfRow, nc+74, style2);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322M(), hssfRow, nc+87, style2);
                            }if((tabla.get(j).getP3_Gr233M()>tabla.get(j).getP1_Gr231M())&&(tabla.get(j).getP3_Gr233M()>tabla.get(j).getP2_Gr232M()))
                                insertFile(tabla.get(j).getDecision_Gr231_232_233M(), hssfRow, nc+87, style2);
                        
                        }
                                                   
                    }                                             
                //debo guardar la ASIGNACIÓN específica de CADA muestra (GUARDAR lo que pongo en la última columan del reporte)               
                tectonicSetting[j]=hssfRow.getCell(nc+87).toString();
                //Esta condición debe DETENER el ciclo en la fila donde OCURRE un cambio de tectónica                
                if(j!=0 && !tectonicSetting[0].equalsIgnoreCase(tectonicSetting[j])){
                        fin = j;//guardar el index en donde ocurre el cambio de campo            
                        tectonicSettingChanged=true;
                        break;
                }                              
            }
            
            //crear segunda hoja para el segundo reporte resumido de postemplazamiento            
            worksheet = workbook.createSheet("Summary M"); 
            //hacer un mmÃ©todo que analice y procese la tabla de iteraciones de postempla 
             // para calcular los %maximun tolerable change por cada elemento
             //
            
            
            hssfRow = worksheet.createRow((short) 0);//titulo segunda fila
            insertFile("Element",  hssfRow, 0,style2);
            insertFile("Initial mass in the field (major in % m/m; trace in microg/g)",  hssfRow, 2,style2); //Initial concentration (crudos)         
            insertFile("Final mass in the field (major in % m/m; trace in microg/g)",  hssfRow, 3,style);//Final concentration (crudos)            
            insertFile("Mass change in the laboratory (adj % m/m)",  hssfRow, 4,style3);//Final concentration (ADJ)
            insertFile("Maximum mass change (gain or loss, % m/m) in the field",  hssfRow, 5,style);  //change (crudos)          
            insertFile("Maximum mass change (gain or loss, % m/m) in the laboratory",  hssfRow, 6,style3);//change (ADJ)
            insertFile("Cause for termination",  hssfRow, 7,style2);           
            insertFile("Gain/Loss Value",  hssfRow, 8, style2);  
            
            worksheet.setColumnWidth((short) 1, 2500);
            worksheet.setColumnWidth((short) 2, 5000);
            worksheet.setColumnWidth((short) 3, 6500);
            worksheet.setColumnWidth((short) 4, 6000); 
            worksheet.setColumnWidth((short) 5, 6000);
            worksheet.setColumnWidth((short) 6, 6000);
            worksheet.setColumnWidth((short) 7, 8000); 
            
            if (!tectonicSettingChanged)//SI NO HAY CAMBIO DE TECTÓNICA
                fin=tabla.size()-1;//SE CONSIDERA TODAS LAS FILAS DE MATRIZ POSTEMPLA
            
            //System.out.println(fin + "\t" + index + "\t" + (index-1));
            // change ADJ
            double Sio2maxChangeCrudos=100*((tabla.get(fin).getSio2()-tabla.get(0).getSio2())/tabla.get(0).getSio2());
            double Tio2maxChangeCrudos=100*((tabla.get(fin).getTio2()-tabla.get(0).getTio2())/tabla.get(0).getTio2());
            double Al2o3maxChangeCrudos=100*((tabla.get(fin).getAl2o3()-tabla.get(0).getAl2o3())/tabla.get(0).getAl2o3());            
            double FE2O3TmaxChangeCrudos=100*((tabla.get(fin).getFe2o3()-tabla.get(0).getFe2o3())/tabla.get(0).getFe2o3());            
            double MNOmaxChangeCrudos=100*((tabla.get(fin).getMno()-tabla.get(0).getMno())/tabla.get(0).getMno());            
            double MGOmaxChangeCrudos=100*((tabla.get(fin).getMgo()-tabla.get(0).getMgo())/tabla.get(0).getMgo());            
            double CAOmaxChangeCrudos=100*((tabla.get(fin).getCao()-tabla.get(0).getCao())/tabla.get(0).getCao());            
            double NA2OmaxChangeCrudos=100*((tabla.get(fin).getNa2o()-tabla.get(0).getNa2o())/tabla.get(0).getNa2o());            
            double KK2OmaxChangeCrudos=100*((tabla.get(fin).getK2o()-tabla.get(0).getK2o())/tabla.get(0).getK2o());            
            double PP2O5maxChangeCrudos=100*((tabla.get(fin).getP2o5()-tabla.get(0).getP2o5())/tabla.get(0).getP2o5());            
         
// change ADJ
            Sio2maxChange=100*((tabla.get(fin).getSio2A()-tabla.get(0).getSio2A())/tabla.get(0).getSio2A());
            Tio2maxChange=100*((tabla.get(fin).getTio2A()-tabla.get(0).getTio2A())/tabla.get(0).getTio2A());
            Al2o3maxChange=100*((tabla.get(fin).getAl2o3A()-tabla.get(0).getAl2o3A())/tabla.get(0).getAl2o3A());            
            FE2O3TmaxChange=100*((tabla.get(fin).getFe2o3tA()-tabla.get(0).getFe2o3tA())/tabla.get(0).getFe2o3tA());            
            MNOmaxChange=100*((tabla.get(fin).getMnoA()-tabla.get(0).getMnoA())/tabla.get(0).getMnoA());            
            MGOmaxChange=100*((tabla.get(fin).getMgoA()-tabla.get(0).getMgoA())/tabla.get(0).getMgoA());            
            CAOmaxChange=100*((tabla.get(fin).getCaoA()-tabla.get(0).getCaoA())/tabla.get(0).getCaoA());            
            NA2OmaxChange=100*((tabla.get(fin).getNa2oA()-tabla.get(0).getNa2oA())/tabla.get(0).getNa2oA());            
            KK2OmaxChange=100*((tabla.get(fin).getK2oA()-tabla.get(0).getK2oA())/tabla.get(0).getK2oA());            
            PP2O5maxChange=100*((tabla.get(fin).getP2o5A()-tabla.get(0).getP2o5A())/tabla.get(0).getP2o5A());     
            
            //identificar la causa del paro de iteraciones post-emplacement            
             double minMajor=0.0021;       
            if ((tabla.get(fin).getSio2A() >= 99)) 
                Sio2Cause="(SiO2)adj too large";
            if ((tabla.get(fin).getSio2A() <= 30.0001)) 
                Sio2Cause="(SiO2)adj too small";
            
            if ((tabla.get(fin).getTio2A() >= 99)) 
                Tio2Cause="(TiO2)adj too large";
            if ((tabla.get(fin).getTio2A() <= minMajor)) 
                Tio2Cause="(TiO2)adj too small";
            
            
            if ((tabla.get(fin).getAl2o3A() >= 99)) 
                Al2o3Cause="(Al2O3)adj too large";
            if ((tabla.get(fin).getAl2o3A() <= minMajor)) 
                Al2o3Cause="(Al2O3)adj too small";
            
           if ((tabla.get(fin).getFe2o3tA() >= 99)) 
                FE2O3TCause="(Fe2O3T)adj too large";
            if ((tabla.get(fin).getFe2o3tA() <= minMajor)) 
                FE2O3TCause="(Fe2O3T)adj too small";
            
            
            if ((tabla.get(fin).getMnoA() >= 99)) 
                MNOCause="(MnO)adj too large";
            if ((tabla.get(fin).getMnoA() <= minMajor)) 
                MNOCause="(MnO)adj too small";

            if ((tabla.get(fin).getMgoA() >= 99)) 
                MGOCause="(MgO)adj too large";
            if ((tabla.get(fin).getMgoA() <= minMajor)) 
                MGOCause="(MgO)adj too small";
            
            if ((tabla.get(fin).getCaoA() >= 99)) 
                CAOCause="(CaO)adj too large";
            if ((tabla.get(fin).getCaoA() <= minMajor)) 
                CAOCause="(CaO)adj too small";
            
            if ((tabla.get(fin).getNa2oA() >= 99)) 
                NA2OCause="(Na2O)adj too large";
            if ((tabla.get(fin).getNa2oA() <= minMajor)) 
                NA2OCause="(Na2O)adj too small";

            if ((tabla.get(fin).getK2oA() >= 99)) 
                KK2OCause="(K2O)adj too large";
            if ((tabla.get(fin).getK2oA() <= minMajor)) 
                KK2OCause="(K2O)adj too small";
            
            if ((tabla.get(fin).getP2o5A() >= 99)) 
                PP2O5Cause="(P2O5)adj too large";
            if ((tabla.get(fin).getP2o5A() <= minMajor)) 
                PP2O5Cause="(P2O5)adj too small";
            
            r=1;//reiniciar contador de filas para reusarlo
           
            hssfRow = worksheet.createRow((short) r++);//tercera fila                        
            insertFile("Initial Row: 1",  hssfRow, 2, style2);//col=0
            worksheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 6));
            insertFile("Row: # " + (fin) + " represents the last step before a change occurred",  hssfRow, 3, style3);//col=0
            
            hssfRow = worksheet.createRow((short) r++);//tercera fila                        
            insertFile("Sio2",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getSio2(),  hssfRow, 2);//Initial concentration (crudos)
            insertFileD(tabla.get(fin).getSio2(),  hssfRow, 3);//Final concentration (crudos)            
            insertFileD(tabla.get(fin).getSio2A(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(Sio2maxChangeCrudos,  hssfRow, 5);//change (crudos)
            insertFileD(Sio2maxChange,  hssfRow, 6);//change (crudos)
            insertFile(Sio2Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepSio2(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//cuarta fila
            insertFile("Tio2",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getTio2(),  hssfRow, 2);//Initial concentration (crudos)    
            insertFileD(tabla.get(fin).getTio2(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getTio2A(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(Tio2maxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(Tio2maxChange,  hssfRow, 6);//col=0
            insertFile(Tio2Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepTio2(),  hssfRow, 8);//Initial concentration (crudos)
            
            //aquí seguir cambiando
            //---
            hssfRow = worksheet.createRow((short) r++);//quinta fila
            insertFile("Al2o3",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getAl2o3(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getAl2o3(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getAl2o3A(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(Al2o3maxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(Al2o3maxChange,  hssfRow, 6);//col=0
            insertFile(Al2o3Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepAl2o3(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//sexta fila
            insertFile("FE2O3T",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getFe2o3(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getFe2o3(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getFe2o3tA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(FE2O3TmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(FE2O3TmaxChange,  hssfRow, 6);//col=0
            insertFile(FE2O3TCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepFe2o3(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//septima fila
            insertFile("MNO",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getMno(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getMno(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getMnoA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(MNOmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(MNOmaxChange,  hssfRow, 6);//col=0
            insertFile(MNOCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepMno(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//octava fila
            insertFile("MGO",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getMgo(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getMgo(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getMgoA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(MGOmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(MGOmaxChange,  hssfRow, 6);//col=0
            insertFile(MGOCause,  hssfRow, 7,style2);//col=0
            insertFileD(tabla.get(0).getStepMgo(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//9 fila
            insertFile("CAO",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getCao(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getCao(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getCaoA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(CAOmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(CAOmaxChange,  hssfRow, 6);//col=0
            insertFile(CAOCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepCao(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//10 fila
            insertFile("NA2O",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getNa2o(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getNa2o(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getNa2oA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(NA2OmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(NA2OmaxChange,  hssfRow, 6);//col=0
            insertFile(NA2OCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepNa2o(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//11 fila
            insertFile("K2O",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getK2o(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getK2o(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getK2oA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(KK2OmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(KK2OmaxChange,  hssfRow, 6);//col=0
            insertFile(KK2OCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepK2o(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("P2O5",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0            
            insertFileD(tabla.get(0).getP2o5(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getP2o5(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getP2o5A(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(PP2O5maxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(PP2O5maxChange,  hssfRow, 6);//col=0
            insertFile(PP2O5Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepP2o5(),  hssfRow, 8);//Initial concentration (crudos)
           
            if (tectonicSettingChanged){
                hssfRow = worksheet.createRow((short) r++);//13 fila            
                insertFile("Others causes: Tectonic setting changed ! ",  hssfRow, 7,style);//col=0
            }
           
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (IOException e) {
            Messagebox.show("Error in ReportRobustness.reportPostemplaM()" + e);
            e.printStackTrace();
        }
    }
   
    public void reportPostemplaMT(String fileout) {            
            double Sio2maxChange, Tio2maxChange, Al2o3maxChange, FE2O3TmaxChange, MNOmaxChange, 
                    MGOmaxChange, CAOmaxChange, NA2OmaxChange, KK2OmaxChange, PP2O5maxChange,
                    CRmaxChange, NBmaxChange, NImaxChange, VmaxChange, YmaxChange, ZRmaxChange;
            
            
            String Sio2Cause=null, Tio2Cause=null, Al2o3Cause=null, FE2O3TCause=null, MNOCause=null, 
                    MGOCause=null, CAOCause=null, NA2OCause=null, KK2OCause=null, PP2O5Cause=null,
                    CRCause=null, NBCause=null, NICause=null, VCause=null, YCause=null,ZRCause=null;
        try {  
            FileOutputStream fileOut = new FileOutputStream(fileout);
            HSSFWorkbook workbook = new HSSFWorkbook();      
            HSSFSheet worksheet = workbook.createSheet("Results MT");            
            
            HSSFFont font = workbook.createFont();
            font.setBoldweight(font.BOLDWEIGHT_BOLD);
            font.setColor(HSSFColor.RED.index);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setVerticalAlignment(style.VERTICAL_CENTER);
            style.setAlignment(style.ALIGN_CENTER);            
            style.setWrapText(true);
            style.setFont(font); 
            
            //Estilo con centrado vertical, alineaciÃƒÆ’Ã‚Â³n izquierda, ajuste de texto, negrita, color ????
            HSSFFont font2 = workbook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(font.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setVerticalAlignment(style2.VERTICAL_CENTER);
            style2.setAlignment(style2.ALIGN_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);
            
             //Estilo con centrado vertical, alineaciÃƒÆ’Ã‚Â³n izquierda, ajuste de texto, negrita, color ????
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.GREEN.index);
            font3.setBoldweight(font3.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setVerticalAlignment(style3.VERTICAL_CENTER);
            style3.setAlignment(style3.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);
            
            HSSFFont font4 = workbook.createFont();
            font4.setColor(HSSFColor.GREEN.index);
            font4.setBoldweight(font4.BOLDWEIGHT_BOLD);
            HSSFCellStyle style4 = workbook.createCellStyle();
            style4.setVerticalAlignment(style4.VERTICAL_CENTER);
            style4.setAlignment(style4.ALIGN_CENTER);
            style4.setWrapText(true);
            style4.setFont(font4);
            
             HSSFFont font5 = workbook.createFont();
            font5.setColor(HSSFColor.BROWN.index);
            font5.setBoldweight(font5.BOLDWEIGHT_BOLD);
            HSSFCellStyle style5 = workbook.createCellStyle();
            style5.setVerticalAlignment(style5.VERTICAL_CENTER);
            style5.setAlignment(style5.ALIGN_CENTER);
            style5.setWrapText(true);
            style5.setFont(font5);
            
            
                      
            HSSFRow hssfRow = worksheet.createRow((short) 0);
            int nc = 0;
            insertFile("Consecutive",  hssfRow, nc++,style2);
            insertFile("Region",  hssfRow, nc++,style2);
            insertFile("SampID",  hssfRow, nc++,style2);
            insertFile("SiO2",  hssfRow, nc++,style2);
            insertFile("TiO2",  hssfRow, nc++,style2);
            insertFile("Al2O3",  hssfRow, nc++,style2);
            insertFile("Fe2O3T",  hssfRow, nc++,style2);
            insertFile("MnO",  hssfRow, nc++,style2);
            insertFile("MgO",  hssfRow, nc++,style2);
            insertFile("CaO",  hssfRow, nc++,style2);
            insertFile("Na2O",  hssfRow, nc++,style2);
            insertFile("K2O",  hssfRow, nc++,style2); 
            insertFile("P2O5",  hssfRow, nc++,style2); 
            insertFile("Cr",  hssfRow, nc++,style2);
            insertFile("Nb",  hssfRow, nc++,style2);
            insertFile("Ni",  hssfRow, nc++,style2);
            insertFile("V",  hssfRow, nc++,style2);
            insertFile("Y",  hssfRow, nc++,style2);
            insertFile("Zr",  hssfRow, nc++,style2);
             //cabecera de elementos Major and traza
            insertFile("Adj Major and Trace",  hssfRow, nc++,style2);
            insertFile("SiO2adjmt",  hssfRow, nc++,style2);
            insertFile("TiO2adjmt",  hssfRow, nc++,style2);
            insertFile("Al2O3adjmt",  hssfRow, nc++,style2);
            insertFile("Fe2O3Tadjmt",  hssfRow, nc++,style2);
            insertFile("MnOadjmt",  hssfRow, nc++,style2);
            insertFile("MgOadjmt",  hssfRow, nc++,style2);
            insertFile("CaOadjmt",  hssfRow, nc++,style2);
            insertFile("Na2Oadjmt",  hssfRow, nc++,style2);
            insertFile("K2Oadjmt",  hssfRow, nc++,style2);
            insertFile("P2O5adjmt",  hssfRow, nc++,style2);
            insertFile("Cradjmt",  hssfRow, nc++,style2);
            insertFile("Nbadjmt",  hssfRow, nc++,style2);
            insertFile("Niadjmt",  hssfRow, nc++,style2);
            insertFile("Vadjmt",  hssfRow, nc++,style2);
            insertFile("Yadjmt",  hssfRow, nc++,style2);
            insertFile("ZRadjmt",  hssfRow, nc++,style2);
            
            insertFile("Ilr start here ",  hssfRow, nc++,style2);            
            insertFile("ilrTiO2mt",  hssfRow, nc++,style2);
            insertFile("ilrAl2O3mt",  hssfRow, nc++,style2);
            insertFile("ilrFe2O3Tmt",  hssfRow, nc++,style2);
            insertFile("ilrMnOmt",  hssfRow, nc++,style2);
            insertFile("ilrMgOmt",  hssfRow, nc++,style2);
            insertFile("ilrCaOmt",  hssfRow, nc++,style2);
            insertFile("ilrNa2Omt",  hssfRow, nc++,style2);
            insertFile("ilrK2Omt",  hssfRow, nc++,style2);
            insertFile("ilrP2O5mt",  hssfRow, nc++,style2);
            insertFile("ilrCrmt",  hssfRow, nc++,style2);
            insertFile("ilrNbmt",  hssfRow, nc++,style2);
            insertFile("ilrNimt",  hssfRow, nc++,style2);
            insertFile("ilrVmt",  hssfRow, nc++,style2);
            insertFile("ilrYmt",  hssfRow, nc++,style2);
            insertFile("ilrZrmt",  hssfRow, nc++,style2);            
            
             //Modelos basados elementos Majores-traza
            insertFile("MT models start here", hssfRow, nc++, style2);
            
            insertFile("DF1_SG1-2-3_MT",  hssfRow, nc++, style5);
            insertFile("DF2_SG1-2-3_MT",  hssfRow, nc++, style5);
            insertFile("P1_SG1_MT",  hssfRow, nc++, style5);
            insertFile("P2_SG2_MT",  hssfRow, nc++, style5);
            insertFile("P3_SG3_MT",  hssfRow, nc++, style5);
            insertFile("Decision_SG1-2-3_MT",  hssfRow, nc++, style5);

            insertFile("DF1_MG11-12-13_MT",  hssfRow, nc++, style3);
            insertFile("DF2_MG11-12-13_MT",  hssfRow, nc++, style3);
            insertFile("P1_MG11_MT",  hssfRow, nc++, style3);
            insertFile("P2_MG12_MT",  hssfRow, nc++, style3);
            insertFile("P3_MG13_MT",  hssfRow, nc++, style3);
            insertFile("Decision_MG11-12-13_MT",  hssfRow, nc++, style3);


            insertFile("DF1_Gr111-112-113_MT",  hssfRow, nc++, style3);
            insertFile("DF2_Gr111-112-113_MT",  hssfRow, nc++, style3);
            insertFile("P1_Gr111_MT",  hssfRow, nc++, style3);
            insertFile("P2_Gr112_MT",  hssfRow, nc++, style3);
            insertFile("P3_Gr113_MT",  hssfRow, nc++, style3);
            insertFile("Decision_Gr111-112-113_MT",  hssfRow, nc++, style3);


            insertFile("DF1_sGr1111-1112-1113_MT",  hssfRow, nc++, style3);
            insertFile("DF2_sGr1111-1112-1113_MT",  hssfRow, nc++, style3);
            insertFile("P1_sGr1111_MT",  hssfRow, nc++, style3);
            insertFile("P2_sGr1112_MT",  hssfRow, nc++, style3);
            insertFile("P3_sGr1113_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1111-1112-1113_MT",  hssfRow, nc++, style3);


            insertFile("DF0_sGr1121-1122_MT",  hssfRow, nc++, style3);
            insertFile("P1_1121_MT",  hssfRow, nc++, style3);
            insertFile("P2_1122_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1121-1122_MT",  hssfRow, nc++, style3);


            insertFile("DF0_Gr121-122_MT",  hssfRow, nc++, style3);
            insertFile("P1_Gr121_MT",  hssfRow, nc++, style3);
            insertFile("P2_Gr122_MT",  hssfRow, nc++, style3);
            insertFile("Decision_Gr121-122_MT",  hssfRow, nc++, style3);


            insertFile("DF0_sGr1211-1212_MT",  hssfRow, nc++, style3);
            insertFile("P1_sGr1211_MT",  hssfRow, nc++, style3);
            insertFile("P2_sGr1212_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1211-1212_MT",  hssfRow, nc++, style3);


            insertFile("DF0_sGr1221-1222_MT",  hssfRow, nc++, style3);
            insertFile("P1_sGr1221_MT",  hssfRow, nc++, style3);
            insertFile("P2_sGr1222_MT",  hssfRow, nc++, style3);
            insertFile("Decision_sGr1221-1222_MT",  hssfRow, nc++, style3);

            insertFile("DF1_MG21-22-23_MT",  hssfRow, nc++, style4);
            insertFile("DF2_MG21-22-23_MT",  hssfRow, nc++, style4);
            insertFile("P1_MG21_MT",  hssfRow, nc++, style4);
            insertFile("P2_MG22_MT",  hssfRow, nc++, style4);
            insertFile("P3_MG23_MT",  hssfRow, nc++, style4);
            insertFile("Decision_MG21-22-23_MT",  hssfRow, nc++, style4);

            insertFile("DF1_Gr211-212-213_MT",  hssfRow, nc++, style4);
            insertFile("DF2_Gr211-212-213_MT",  hssfRow, nc++, style4);
            insertFile("P1_Gr211_MT",  hssfRow, nc++, style4);
            insertFile("P2_Gr212_MT",  hssfRow, nc++, style4);
            insertFile("P3_Gr213_MT",  hssfRow, nc++, style4);
            insertFile("Decision_Gr211-212-213_MT",  hssfRow, nc++, style4);

            insertFile("DF1_Gr221-222-223_MT",  hssfRow, nc++, style4);
            insertFile("DF2_Gr221-222-223_MT",  hssfRow, nc++, style4);
            insertFile("P1_Gr221_MT",  hssfRow, nc++, style4);
            insertFile("P2_Gr222_MT",  hssfRow, nc++, style4);
            insertFile("P3_Gr223_MT",  hssfRow, nc++, style4);
            insertFile("Decision_Gr221-222-223_MT",  hssfRow, nc++, style4);

            insertFile("DF1_Gr231-232-233_MT",  hssfRow, nc++, style4);
            insertFile("DF2_Gr231-232-233_MT",  hssfRow, nc++, style4);
            insertFile("P1_Gr231_MT",  hssfRow, nc++, style4);
            insertFile("P2_Gr232_MT",  hssfRow, nc++, style4);
            insertFile("P3_Gr233_MT",  hssfRow, nc++, style4);
            insertFile("Decision_Gr231-232-233_MT",  hssfRow, nc++, style4);

            insertFile("DF0_sGr2311-2312_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr2311_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr2312_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr23111_23112_MT",  hssfRow, nc++, style4);

            insertFile("DF0_sGr23111-23112_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr23111_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr23112_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr23111-23112_MT",  hssfRow, nc++, style4);

            insertFile("DF0_sGr23121-23122_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr23121_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr23122_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr23121-23122_MT",  hssfRow, nc++, style4);


            insertFile("DF0_sGr2321-2322_MT",  hssfRow, nc++, style4);
            insertFile("P1_sGr2321_MT",  hssfRow, nc++, style4);
            insertFile("P2_sGr2322_MT",  hssfRow, nc++, style4);
            insertFile("Decision_sGr2321-2322_MT",  hssfRow, nc++, style4);



            insertFile("DF1_MG31-32-33_MT",  hssfRow, nc++, style5);
            insertFile("DF2_MG31-32-33_MT",  hssfRow, nc++, style5);
            insertFile("P1_MG31_MT",  hssfRow, nc++, style5);
            insertFile("P2_MG32_MT",  hssfRow, nc++, style5);
            insertFile("P3_MG33_MT",  hssfRow, nc++, style5);
            insertFile("Decision_MG31-32-33_MT",  hssfRow, nc++, style5);

            insertFile("DF1_Gr311-312-313_MT",  hssfRow, nc++, style5);
            insertFile("DF2_Gr311-312-313_MT",  hssfRow, nc++, style5);
            insertFile("P1_Gr311_MT",  hssfRow, nc++, style5);
            insertFile("P2_Gr312_MT",  hssfRow, nc++, style5);
            insertFile("P3_Gr313_MT",  hssfRow, nc++, style5);
            insertFile("Decision_Gr311-312-313_MT",  hssfRow, nc++, style5);

            insertFile("RESULT_MT",  hssfRow, nc++, style2);
            
            int r = 1, fin=0; 
            boolean tectonicSettingChanged=false;            
            tectonicSetting=new String[tabla.size()];//para guardar la asignación específica de la tectónica             
            for (int j = 0; j < tabla.size(); j++) {                
                nc = 0;
                hssfRow = worksheet.createRow((short) r++);
                insertFileD(j,  hssfRow, nc++);
                insertFile(" ", hssfRow, nc++, style2);//región
                insertFile(" ", hssfRow, nc++, style2);//sampleID
                insertFileD(tabla.get(j).getSio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getTio2(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getAl2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getFe2o3(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMno(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMgo(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCao(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNa2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getK2o(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getP2o5(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCr(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNb(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNi(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getV(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getY(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getZr(),  hssfRow, nc++);
                
                //variables de elementos majores y traza
                insertFile(" ",  hssfRow, nc++,style2);
                insertFileD(tabla.get(j).getSio2mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getTio2mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getAl2o3mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getFe2o3tmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMnomtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getMgomtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCaomtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNa2omtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getK2omtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getP2o5mtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getCrmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNbmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getNimtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getVmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getYmtA(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getZrmtA(),  hssfRow, nc++);

                insertFile(" ",  hssfRow, nc++,style2);
                insertFileD(tabla.get(j).getIlrTiMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrAlMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrFeTMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrMnMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrMgMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrCaMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrNaMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrKMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrPMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrCrMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrNbMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrNiMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrVMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrYMT(),  hssfRow, nc++);
                insertFileD(tabla.get(j).getIlrZrMT(),  hssfRow, nc++);
                              
                insertFile(" ",  hssfRow, nc++, style2);
                insertFileD(tabla.get(j).getDf1_SG1_2_3MTd(),  hssfRow, nc++);//41
                insertFileD(tabla.get(j).getDf2_SG1_2_3MTd(),  hssfRow, nc++);//42
                insertFileD(tabla.get(j).getP1_SG1MT(),  hssfRow, nc++);//43
                insertFileD(tabla.get(j).getP2_SG2MT(),  hssfRow, nc++);//44
                insertFileD(tabla.get(j).getP3_SG3MT(),  hssfRow, nc++);//45
                insertFile(tabla.get(j).getDecision_SG1_2_3MT(),  hssfRow, nc++,style2);//46
                    
                nc=58;//ES EL NÚMERO DE COLUMNAS QUE ESTÁN ANTES DE LA DECISIÓN DEL PRIMER DIAGRAMA GENERAL, 
          
                if ("SG3".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){
                            //System.out.println("cuando entro a SG3: aplico MG31_32_33 ..."+tabla.get(j).getDecision_MG31_32_33MT());
                            insertFileD(tabla.get(j).getDf1_MG31_32_33MTd(),  hssfRow, nc+75);//75
                            insertFileD(tabla.get(j).getDf2_MG31_32_33MTd(),  hssfRow, nc+76);
                            insertFileD(tabla.get(j).getP1_MG31MT(),  hssfRow, nc+77);
                            insertFileD(tabla.get(j).getP2_MG32MT(),  hssfRow, nc+78);
                            insertFileD(tabla.get(j).getP3_MG33MT(),  hssfRow, nc+79);
                            insertFile(tabla.get(j).getDecision_MG31_32_33MT(),  hssfRow, nc+80, style2);                            
                            
                            if ("MG31".equalsIgnoreCase(tabla.get(j).getDecision_MG31_32_33MT())){
                                //System.out.println("cuando entro a SG3_ y luego a MG31: aplico Gr311_312_313 ..."+tabla.get(j).getDecision_Gr311_312_313MT());
                                insertFileD(tabla.get(j).getDf1_Gr311_312_313MTd(),  hssfRow, nc+81);
                                insertFileD(tabla.get(j).getDf2_Gr311_312_313MTd(),  hssfRow, nc+82);
                                insertFileD(tabla.get(j).getP1_Gr311MT(),  hssfRow, nc+83);
                                insertFileD(tabla.get(j).getP2_Gr312MT(),  hssfRow, nc+84);
                                insertFileD(tabla.get(j).getP3_Gr313MT(),  hssfRow, nc+85);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313MT(),  hssfRow, nc+86, style2);
                                insertFile(tabla.get(j).getDecision_Gr311_312_313MT(),  hssfRow, nc+87, style2);
                                
                            }else{
                               insertFile(tabla.get(j).getDecision_MG31_32_33MT(),  hssfRow, nc+87, style2); 
                            //System.out.println("cuando entro a SG3_ y luego NO es MG31: entonces es: "+tabla.get(j).getDecision_MG31_32_33MT());
                            }
                        } 
                    if ("SG1".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){                    
                        insertFileD(tabla.get(j).getDf1_MG11_12_13MTd(),  hssfRow, nc+1);
                        insertFileD(tabla.get(j).getDf2_MG11_12_13MTd(),  hssfRow, nc+2);
                        insertFileD(tabla.get(j).getP1_MG11MT(),  hssfRow, nc+3);
                        insertFileD(tabla.get(j).getP2_MG12MT(),  hssfRow, nc+4);
                        insertFileD(tabla.get(j).getP3_MG13MT(),  hssfRow, nc+5);
                        insertFile(tabla.get(j).getDecision_MG11_12_13MT(),  hssfRow, nc+6, style2);
                    
                        if ("MG11".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT())){
                            insertFileD(tabla.get(j).getDf1_Gr111_112_113MTd(),  hssfRow, nc+7);
                            insertFileD(tabla.get(j).getDf2_Gr111_112_113MTd(),  hssfRow, nc+8);
                            insertFileD(tabla.get(j).getP1_Gr111MT(),  hssfRow, nc+9);
                            insertFileD(tabla.get(j).getP2_Gr112MT(),  hssfRow, nc+10);
                            insertFileD(tabla.get(j).getP3_Gr113MT(),  hssfRow, nc+11);
                            insertFile(tabla.get(j).getDecision_Gr111_112_113MT(),  hssfRow, nc+12, style2);
                            
                            if ("Gr111".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT())){
                                insertFileD(tabla.get(j).getDf1_sGr1111_1112_1113MTd(),  hssfRow, nc+13);                    
                                insertFileD(tabla.get(j).getDf2_sGr1111_1112_1113MTd(),  hssfRow, nc+14);
                                insertFileD(tabla.get(j).getP1_sGr1111MT(),  hssfRow, nc+15);
                                insertFileD(tabla.get(j).getP2_sGr1112MT(),  hssfRow, nc+16);
                                insertFileD(tabla.get(j).getP3_sGr1113MT(),  hssfRow, nc+17);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113MT(),  hssfRow, nc+18, style2);
                                insertFile(tabla.get(j).getDecision_sGr1111_1112_1113MT(),  hssfRow, nc+87, style2);//resultM
                            }
                            if ("Gr112".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1121_1122MTd(),  hssfRow, nc+19);
                                insertFileD(tabla.get(j).getP1_sGr1121MT(),  hssfRow, nc+20);
                                insertFileD(tabla.get(j).getP2_sGr1122MT(),  hssfRow, nc+21);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122MT(),  hssfRow, nc+22, style2);
                                insertFile(tabla.get(j).getDecision_sGr1121_1122MT(),  hssfRow, nc+87, style2);
                            }
                            if ("Gr113".equalsIgnoreCase(tabla.get(j).getDecision_Gr111_112_113MT()))
                                insertFile(tabla.get(j).getDecision_Gr111_112_113MT(),  hssfRow, nc+87, style2);    
                        }if ("MG12".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT())){
                            insertFileD(tabla.get(j).getDf0_Gr121_122MTd(),  hssfRow, nc+23);
                            insertFileD(tabla.get(j).getP1_Gr121MT(),  hssfRow, nc+24);
                            insertFileD(tabla.get(j).getP2_Gr122MT(),  hssfRow, nc+25);
                            insertFile(tabla.get(j).getDecision_Gr121_122MT(),  hssfRow, nc+26, style2);
                            
                            if ("Gr121".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1211_1212MTd(),  hssfRow, nc+27);
                                insertFileD(tabla.get(j).getP1_sGr1211MT(),  hssfRow, nc+28);
                                insertFileD(tabla.get(j).getP2_sGr1212MT(),  hssfRow, nc+29);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212MT(),  hssfRow, nc+30,style2);
                                insertFile(tabla.get(j).getDecision_sGr1211_1212MT(),  hssfRow, nc+87,style2);
                               }
                           if ("Gr122".equalsIgnoreCase(tabla.get(j).getDecision_Gr121_122MT())){
                                insertFileD(tabla.get(j).getDf0_sGr1221_1222MTd(),  hssfRow, nc+31 );
                                insertFileD(tabla.get(j).getP1_sGr1221MT(),  hssfRow, nc+32);
                                insertFileD(tabla.get(j).getP2_sGr1222MT(),  hssfRow, nc+33);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222MT(),  hssfRow, nc+34, style2);
                                insertFile(tabla.get(j).getDecision_sGr1221_1222MT(),  hssfRow, nc+87, style2);
                            }
                        }if ("MG13".equalsIgnoreCase(tabla.get(j).getDecision_MG11_12_13MT()))
                            insertFile(tabla.get(j).getDecision_MG11_12_13MT(),  hssfRow, nc+87, style2);
                     }
                    if ("SG2".equalsIgnoreCase(tabla.get(j).getDecision_SG1_2_3MT())){
                        insertFileD(tabla.get(j).getDf1_MG21_22_23MTd(),  hssfRow, nc+35);
                        insertFileD(tabla.get(j).getDf2_MG21_22_23MTd(),  hssfRow, nc+36);
                        insertFileD(tabla.get(j).getP1_MG21MT(),  hssfRow, nc+37);
                        insertFileD(tabla.get(j).getP2_MG22MT(),  hssfRow, nc+38);
                        insertFileD(tabla.get(j).getP3_MG23MT(),  hssfRow, nc+39);
                        insertFile(tabla.get(j).getDecision_MG21_22_23MT(),  hssfRow, nc+40, style2);
                        if ("MG21".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr211_212_213MTd(),  hssfRow, nc+41);
                            insertFileD(tabla.get(j).getDf2_Gr211_212_213MTd(),  hssfRow, nc+42);
                            insertFileD(tabla.get(j).getP1_Gr211MT(),  hssfRow, nc+43);
                            insertFileD(tabla.get(j).getP2_Gr212MT(),  hssfRow, nc+44);
                            insertFileD(tabla.get(j).getP3_Gr213MT(),  hssfRow, nc+45);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213MT(),  hssfRow, nc+46, style2);
                            insertFile(tabla.get(j).getDecision_Gr211_212_213MT(),  hssfRow, nc+87, style2);
                        }if ("MG22".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr221_222_223MTd(),  hssfRow, nc+47);
                            insertFileD(tabla.get(j).getDf2_Gr221_222_223MTd(),  hssfRow, nc+48);
                            insertFileD(tabla.get(j).getP1_Gr221MT(),  hssfRow, nc+49);
                            insertFileD(tabla.get(j).getP2_Gr222MT(),  hssfRow, nc+50);
                            insertFileD(tabla.get(j).getP3_Gr223MT(),  hssfRow, nc+51);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223MT(),  hssfRow, nc+52, style2);
                            insertFile(tabla.get(j).getDecision_Gr221_222_223MT(),  hssfRow, nc+87, style2);
                        }if ("MG23".equalsIgnoreCase(tabla.get(j).getDecision_MG21_22_23MT())){
                            insertFileD(tabla.get(j).getDf1_Gr231_232_233MTd(),  hssfRow, nc+53);
                            insertFileD(tabla.get(j).getDf2_Gr231_232_233MTd(),  hssfRow, nc+54);
                            insertFileD(tabla.get(j).getP1_Gr231MT(),  hssfRow, nc+55);
                            insertFileD(tabla.get(j).getP2_Gr232MT(),  hssfRow, nc+56);
                            insertFileD(tabla.get(j).getP3_Gr233MT(),  hssfRow, nc+57);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233MT(),  hssfRow, nc+58, style2);
                            insertFile(tabla.get(j).getDecision_Gr231_232_233MT(),  hssfRow, nc+87, style2);
                            //System.out.println("****p1, p2, p3 "+tabla.get(j).getP1_Gr231MT()+"\n"+tabla.get(j).getP2_Gr232MT()+"\n"+tabla.get(j).getP3_Gr233MT()+"\n");                            
                            System.out.println(" ++++++++ es 231 o 232:"+ tabla.get(j).getDecision_Gr231_232_233MT() +"****p1, p2, p3 "+tabla.get(j).getP1_Gr231MT()+"\n"+tabla.get(j).getP2_Gr232MT()+"\n"+tabla.get(j).getP3_Gr233MT()+"\n");
                            
                            
                            if((tabla.get(j).getP1_Gr231MT()>tabla.get(j).getP2_Gr232MT())&&(tabla.get(j).getP1_Gr231MT()>tabla.get(j).getP3_Gr233MT())){
//if (Objects.equals("Gr231", tabla.get(j).getDecision_Gr231_232_233MT())) {
                            //if ("Gr231".equalsIgnoreCase(tabla.get(j).getDecision_Gr231_232_233MT())){
                                insertFileD(tabla.get(j).getDf0_sGr2311_2312MTd(),  hssfRow, nc+59); //aquí ya hay ceros en todo 231 y 232 hacia abajo del árbol
                                insertFileD(tabla.get(j).getP1_sGr2311MT(),  hssfRow, nc+60);
                                insertFileD(tabla.get(j).getP2_sGr2312MT(),  hssfRow, nc+61);
                                insertFile(tabla.get(j).getDecision_sGr2311_2312MT(),  hssfRow, nc+62,style2);
                                
                                System.out.println(" es sGr2311 o sGr2312:"+ tabla.get(j).getDecision_sGr2311_2312MT());
                                if (tabla.get(j).getP1_sGr2311MT()>tabla.get(j).getP2_sGr2312MT()) {
                                    insertFileD(tabla.get(j).getDf0_sGr23111_23112MTd(),  hssfRow, nc+63);
                                    insertFileD(tabla.get(j).getP1_sGr23111MT(),  hssfRow, nc+64);
                                    insertFileD(tabla.get(j).getP2_sGr23112MT(),  hssfRow, nc+65);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112MT(),  hssfRow, nc+66, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23111_23112MT(),  hssfRow, nc+87, style2);
                                }else//if ("sGr2312".equalsIgnoreCase(tabla.get(j).getDecision_sGr2311_2312MT()))
                                {
                                    insertFileD(tabla.get(j).getDf0_sGr23121_23122MTd(),  hssfRow, nc+67);
                                    insertFileD(tabla.get(j).getP1_sGr23121MT(),  hssfRow, nc+68);
                                    insertFileD(tabla.get(j).getP2_sGr23122MT(),  hssfRow, nc+69);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122MT(),  hssfRow, nc+70, style2);
                                    insertFile(tabla.get(j).getDecision_sGr23121_23122MT(),  hssfRow, nc+87, style2);
                                }
                            }if((tabla.get(j).getP2_Gr232MT()>tabla.get(j).getP1_Gr231MT())&&(tabla.get(j).getP2_Gr232MT()>tabla.get(j).getP3_Gr233MT())){         
                            //if (Objects.equals("Gr232", tabla.get(j).getDecision_Gr231_232_233MT())) {
                                insertFileD(tabla.get(j).getDf0_sGr2321_2322MTd(),  hssfRow, nc+71);
                                insertFileD(tabla.get(j).getP1_sGr2321MT(),  hssfRow, nc+72);
                                insertFileD(tabla.get(j).getP2_sGr2322MT(),  hssfRow, nc+73);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322MT(),  hssfRow, nc+74, style2);
                                insertFile(tabla.get(j).getDecision_sGr2321_2322MT(),  hssfRow, nc+87, style2);
                            }if((tabla.get(j).getP3_Gr233MT()>tabla.get(j).getP1_Gr231MT())&&(tabla.get(j).getP3_Gr233MT()>tabla.get(j).getP2_Gr232MT()))
                                insertFile(tabla.get(j).getDecision_Gr231_232_233MT(), hssfRow, nc+87, style2);
                        
                        }
                                                   
                        } 
                //debo guardar la ASIGNACIÓN específica de CADA muestra (GUARDAR lo que pongo en la última columan del reporte)               
                tectonicSetting[j]=hssfRow.getCell(nc+87).toString();
                //Esta condición debe DETENER el ciclo en la fila donde OCURRE un cambio de tectónica                
                if(j!=0 && !tectonicSetting[0].equalsIgnoreCase(tectonicSetting[j])){
                        fin = j;//guardar el index en donde ocurre el cambio de campo            
                        tectonicSettingChanged=true;
                        break;
                }   
            }
            //crear segunda hoja para el segundo reporte resumido de postemplazamiento            
            worksheet = workbook.createSheet("Summary MT");            
            //hssfRow = worksheet.createRow((short) 1);            
            ///hacer un mmÃ©todo que analice y procese la tabla de iteraciones de postempla 
             // para calcular los %maximun tolerable change por cada elemento                        
            
            //hssfRow = worksheet.createRow((short) 0);//titulo rimera fila
            //insertFile("Robustness post-emplacement changes",  hssfRow, 1);//titulo col=1
                        
            hssfRow = worksheet.createRow((short) 0);//titulo segunda fila
            insertFile("Element",  hssfRow, 0,style2);
            insertFile("Initial mass in the field (major in % m/m; trace in microg/g)",  hssfRow, 2,style2); //Initial concentration (crudos)         
            insertFile("Final mass in the field (major in % m/m; trace in microg/g)",  hssfRow, 3,style);//Final concentration (crudos)                
            insertFile("Mass change in the laboratory (adj % m/m)",  hssfRow, 4,style3);//Final concentration (ADJ)
            insertFile("Maximum mass change (gain or loss, % m/m) in the field",  hssfRow, 5,style);  //change (crudos)          
            insertFile("Maximum mass change (gain or loss, % m/m) in the laboratory",  hssfRow, 6,style3);//change (ADJ)
            insertFile("Cause for termination",  hssfRow, 7,style2);           
            insertFile("Gain/Loss Value",  hssfRow, 8, style2);  
            
            worksheet.setColumnWidth((short) 1, 2500);
            worksheet.setColumnWidth((short) 2, 5000);
            worksheet.setColumnWidth((short) 3, 6500);
            worksheet.setColumnWidth((short) 4, 6000); 
            worksheet.setColumnWidth((short) 5, 6000);
            worksheet.setColumnWidth((short) 6, 6000);
            worksheet.setColumnWidth((short) 7, 8000); 
            
            if (!tectonicSettingChanged)//SI NO HAY CAMBIO DE TECTÓNICA
                fin=tabla.size()-1;//SE CONSIDERA TODAS LAS FILAS DE MATRIZ POSTEMPLA
            
            //fin--;//está tomando un paso adelante cuando rompe
            // change ADJ            
            double Sio2maxChangeCrudos=100*((tabla.get(fin).getSio2()-tabla.get(0).getSio2())/tabla.get(0).getSio2());
            double Tio2maxChangeCrudos=100*((tabla.get(fin).getTio2()-tabla.get(0).getTio2())/tabla.get(0).getTio2());
            double Al2o3maxChangeCrudos=100*((tabla.get(fin).getAl2o3()-tabla.get(0).getAl2o3())/tabla.get(0).getAl2o3());            
            double FE2O3TmaxChangeCrudos=100*((tabla.get(fin).getFe2o3()-tabla.get(0).getFe2o3())/tabla.get(0).getFe2o3());            
            double MNOmaxChangeCrudos=100*((tabla.get(fin).getMno()-tabla.get(0).getMno())/tabla.get(0).getMno());            
            double MGOmaxChangeCrudos=100*((tabla.get(fin).getMgo()-tabla.get(0).getMgo())/tabla.get(0).getMgo());            
            double CAOmaxChangeCrudos=100*((tabla.get(fin).getCao()-tabla.get(0).getCao())/tabla.get(0).getCao());            
            double NA2OmaxChangeCrudos=100*((tabla.get(fin).getNa2o()-tabla.get(0).getNa2o())/tabla.get(0).getNa2o());            
            double KK2OmaxChangeCrudos=100*((tabla.get(fin).getK2o()-tabla.get(0).getK2o())/tabla.get(0).getK2o());            
            double PP2O5maxChangeCrudos=100*((tabla.get(fin).getP2o5()-tabla.get(0).getP2o5())/tabla.get(0).getP2o5());            
            double CRmaxChangeCrudos=100*((tabla.get(fin).getCr()-tabla.get(0).getCr())/tabla.get(0).getCr());
            double NBmaxChangeCrudos=100*((tabla.get(fin).getNb()-tabla.get(0).getNb())/tabla.get(0).getNb());
            double NImaxChangeCrudos=100*((tabla.get(fin).getNi()-tabla.get(0).getNi())/tabla.get(0).getNi());
            double VmaxChangeCrudos=100*((tabla.get(fin).getV()-tabla.get(0).getV())/tabla.get(0).getV());
            double YmaxChangeCrudos=100*((tabla.get(fin).getY()-tabla.get(0).getY())/tabla.get(0).getY());
            double ZRmaxChangeCrudos=100*((tabla.get(fin).getZr()-tabla.get(0).getZr())/tabla.get(0).getZr());            
// change ADJ
            Sio2maxChange=100*((tabla.get(fin).getSio2mtA()-tabla.get(0).getSio2mtA())/tabla.get(0).getSio2mtA());
            Tio2maxChange=100*((tabla.get(fin).getTio2mtA()-tabla.get(0).getTio2mtA())/tabla.get(0).getTio2mtA());
            Al2o3maxChange=100*((tabla.get(fin).getAl2o3mtA()-tabla.get(0).getAl2o3mtA())/tabla.get(0).getAl2o3mtA());            
            FE2O3TmaxChange=100*((tabla.get(fin).getFe2o3tmtA()-tabla.get(0).getFe2o3tmtA())/tabla.get(0).getFe2o3tmtA());            
            MNOmaxChange=100*((tabla.get(fin).getMnomtA()-tabla.get(0).getMnomtA())/tabla.get(0).getMnomtA());            
            MGOmaxChange=100*((tabla.get(fin).getMgomtA()-tabla.get(0).getMgomtA())/tabla.get(0).getMgomtA());            
            CAOmaxChange=100*((tabla.get(fin).getCaomtA()-tabla.get(0).getCaomtA())/tabla.get(0).getCaomtA());            
            NA2OmaxChange=100*((tabla.get(fin).getNa2omtA()-tabla.get(0).getNa2omtA())/tabla.get(0).getNa2omtA());            
            KK2OmaxChange=100*((tabla.get(fin).getK2omtA()-tabla.get(0).getK2omtA())/tabla.get(0).getK2omtA());            
            PP2O5maxChange=100*((tabla.get(fin).getP2o5mtA()-tabla.get(0).getP2o5mtA())/tabla.get(0).getP2o5mtA());            
            CRmaxChange=100*((tabla.get(fin).getCrmtA()-tabla.get(0).getCrmtA())/tabla.get(0).getCrmtA());
            NBmaxChange=100*((tabla.get(fin).getNbmtA()-tabla.get(0).getNbmtA())/tabla.get(0).getNbmtA());
            NImaxChange=100*((tabla.get(fin).getNimtA()-tabla.get(0).getNimtA())/tabla.get(0).getNimtA());
            VmaxChange=100*((tabla.get(fin).getVmtA()-tabla.get(0).getVmtA())/tabla.get(0).getVmtA());
            YmaxChange=100*((tabla.get(fin).getYmtA()-tabla.get(0).getYmtA())/tabla.get(0).getYmtA());
            ZRmaxChange=100*((tabla.get(fin).getZrmtA()-tabla.get(0).getZrmtA())/tabla.get(0).getZrmtA());
            
            double minMajor=0.0021;
            double minTrace=0.000019;
            //identificar la causa del paro de iteraciones postempleza
            if ((tabla.get(fin).getSio2mtA() >= 99)) 
                Sio2Cause="(SiO2)adj too large";
            if ((tabla.get(fin).getSio2mtA() <= 31)) 
                Sio2Cause="(SiO2)adj too small";
            
            if ((tabla.get(fin).getTio2mtA() >= 99)) 
                Tio2Cause="(TiO2)adj too large";
            if ((tabla.get(fin).getTio2mtA() <= minMajor)) 
                Tio2Cause="(TiO2)adj too small";
            
            
            if ((tabla.get(fin).getAl2o3mtA() >= 99)) 
                Al2o3Cause="(Al2O3)adj too large";
            if ((tabla.get(fin).getAl2o3mtA() <= minMajor)) 
                Al2o3Cause="(Al2O3)adj too small";
            
           if ((tabla.get(fin).getFe2o3tmtA() >= 99)) 
                FE2O3TCause="(Fe2O3T)adj too large";
            if ((tabla.get(fin).getFe2o3tA() <= minMajor)) 
                FE2O3TCause="(Fe2O3T)adj too small";
            
            
            if ((tabla.get(fin).getMnomtA() >= 99)) 
                MNOCause="(MnO)adj too large";
            if ((tabla.get(fin).getMnomtA() <= minMajor)) 
                MNOCause="(MnO)adj too small";

            if ((tabla.get(fin).getMgomtA() >= 99)) 
                MGOCause="(MgO)adj too large";
            if ((tabla.get(fin).getMgomtA() <= minMajor)) 
                MGOCause="(MgO)adj too small";
            
            if ((tabla.get(fin).getCaomtA() >= 99)) 
                CAOCause="(CaO)adj too large";
            if ((tabla.get(fin).getCaomtA() <= minMajor)) 
                CAOCause="(CaO)adj too small";
            
            if ((tabla.get(fin).getNa2omtA() >= 99)) 
                NA2OCause="(Na2O)adj too large";
            if ((tabla.get(fin).getNa2omtA() <= minMajor)) 
                NA2OCause="(Na2O)adj too small";

            if ((tabla.get(fin).getK2omtA() >= 99)) 
                KK2OCause="(K2O)adj too large";
            if ((tabla.get(fin).getK2omtA() <= minMajor)) 
                KK2OCause="(K2O)adj too small";
            
            if ((tabla.get(fin).getP2o5mtA() >= 99)) 
                PP2O5Cause="(P2O5)adj too large";
            if ((tabla.get(fin).getP2o5mtA() <= minMajor)) 
                PP2O5Cause="(P2O5)adj too small";
                        
            if ((tabla.get(fin).getCrmtA() <= minTrace)) 
                CRCause="(Cr)adj too small";
            if ((tabla.get(fin).getNbmtA() <= minTrace)) 
                NBCause="(Nb)adj too small";
            if ((tabla.get(fin).getNimtA() <= minTrace)) 
                NICause="(Ni)adj too small";
            if ((tabla.get(fin).getYmtA() <= minTrace)) 
                YCause="(Y)adj too small";
            if ((tabla.get(fin).getZrmtA() <= minTrace)) 
                ZRCause="(Zr)adj too small";
                 
            r=1;//reiniciar contador de filas para reusarlo
            
            hssfRow = worksheet.createRow((short) r++);//tercera fila                        
            insertFile("Initial Row: 1",  hssfRow, 2, style2);//col=0
            worksheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 6));
            insertFile("Row: # " + (fin) + " represents the last step before a change occurred",  hssfRow, 3, style3);//col=0

            hssfRow = worksheet.createRow((short) r++);//tercera fila                        
            insertFile("Sio2",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getSio2(),  hssfRow, 2);//Initial concentration (crudos)
            insertFileD(tabla.get(fin).getSio2(),  hssfRow, 3);//Final concentration (crudos)            
            insertFileD(tabla.get(fin).getSio2mtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(Sio2maxChangeCrudos,  hssfRow, 5);//change (crudos)
            insertFileD(Sio2maxChange,  hssfRow, 6);//change (crudos)
            insertFile(Sio2Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepSio2(),  hssfRow, 8);//Initial concentration (crudos)    
            
            hssfRow = worksheet.createRow((short) r++);//cuarta fila
            insertFile("Tio2",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getTio2(),  hssfRow, 2);//Initial concentration (crudos)    
            insertFileD(tabla.get(fin).getTio2(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getTio2mtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(Tio2maxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(Tio2maxChange,  hssfRow, 6);//col=0
            insertFile(Tio2Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepTio2(),  hssfRow, 8);//Initial concentration (crudos)
            //aquí seguir cambiando
            //---
            hssfRow = worksheet.createRow((short) r++);//quinta fila
            insertFile("Al2o3",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getAl2o3(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getAl2o3(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getAl2o3mtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(Al2o3maxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(Al2o3maxChange,  hssfRow, 6);//col=0
            insertFile(Al2o3Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepAl2o3(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//sexta fila
            insertFile("FE2O3T",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getFe2o3(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getFe2o3(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getFe2o3tmtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(FE2O3TmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(FE2O3TmaxChange,  hssfRow, 6);//col=0
            insertFile(FE2O3TCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepFe2o3(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//septima fila
            insertFile("MNO",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getMno(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getMno(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getMnomtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(MNOmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(MNOmaxChange,  hssfRow, 6);//col=0
            insertFile(MNOCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepMno(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//octava fila
            insertFile("MGO",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getMgo(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getMgo(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getMgomtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(MGOmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(MGOmaxChange,  hssfRow, 6);//col=0
            insertFile(MGOCause,  hssfRow, 7,style2);//col=0
            insertFileD(tabla.get(0).getStepMgo(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//9 fila
            insertFile("CAO",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getCao(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getCao(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getCaomtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(CAOmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(CAOmaxChange,  hssfRow, 6);//col=0
            insertFile(CAOCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepCao(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//10 fila
            insertFile("NA2O",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getNa2o(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getNa2o(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getNa2omtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(NA2OmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(NA2OmaxChange,  hssfRow, 6);//col=0
            insertFile(NA2OCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepNa2o(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//11 fila
            insertFile("K2O",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getK2o(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getK2o(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getK2omtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(KK2OmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(KK2OmaxChange,  hssfRow, 6);//col=0
            insertFile(KK2OCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepK2o(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("P2O5",  hssfRow, 0,style2);//col=0
            //insertFile("(% m/m) ",  hssfRow, 1,style2);//col=0            
            insertFileD(tabla.get(0).getP2o5(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getP2o5(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getP2o5mtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(PP2O5maxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(PP2O5maxChange,  hssfRow, 6);//col=0
            insertFile(PP2O5Cause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepP2o5(),  hssfRow, 8);//Initial concentration (crudos)
            
            ///
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("Cr",  hssfRow, 0,style2);//col=0
            //insertFile("(microg/g)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getCr(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getCr(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getCrmtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(CRmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(CRmaxChange,  hssfRow, 6);//col=0
            insertFile(CRCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepCr(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("Nb",  hssfRow, 0,style2);//col=0
            //insertFile("(microg/g)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getNb(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getNb(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getNbmtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(NBmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(NBmaxChange,  hssfRow, 6);//col=0
            insertFile(NBCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepNb(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("Ni",  hssfRow, 0,style2);//col=0
            //insertFile("(microg/g)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getNi(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getNi(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getNimtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(NImaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(NImaxChange,  hssfRow, 6);//col=0
            insertFile(NICause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepNi(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("V",  hssfRow, 0,style2);//col=0
            //insertFile("(microg/g)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getV(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getV(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getVmtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(VmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(VmaxChange,  hssfRow, 6);//col=0
            insertFile(VCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepV(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("Y",  hssfRow, 0,style2);//col=0
            //insertFile("(microg/g)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getY(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getY(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getYmtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(YmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(YmaxChange,  hssfRow, 6);//col=0
            insertFile(YCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepY(),  hssfRow, 8);//Initial concentration (crudos)
            
            hssfRow = worksheet.createRow((short) r++);//12 fila
            insertFile("ZR",  hssfRow, 0,style2);//col=0
            //insertFile("(microg/g)",  hssfRow, 1,style2);//col=0
            insertFileD(tabla.get(0).getZr(),  hssfRow, 2);//col=0
            insertFileD(tabla.get(fin).getZr(),  hssfRow, 3);//Final concentration (crudos)
            insertFileD(tabla.get(fin).getZrmtA(),  hssfRow, 4);//Final concentration (ADJ)            
            insertFileD(ZRmaxChangeCrudos,  hssfRow, 5);//col=0
            insertFileD(ZRmaxChange,  hssfRow, 6);//col=0
            insertFile(ZRCause,  hssfRow, 7,style2);//col
            insertFileD(tabla.get(0).getStepZr(),  hssfRow, 8);//Initial concentration (crudos)
            
            if (tectonicSettingChanged){
                hssfRow = worksheet.createRow((short) r++);//13 fila            
                insertFile("Others causes: Tectonic setting changed ! ",  hssfRow, 7,style);//col
            }
            // 
            
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

            //reporte2_res();
        } catch (Exception e) {

            Messagebox.show("Error in ReportRobustness.reportPostemplaMT(). " +"\n"+e.toString());
            e.printStackTrace();
        }
        // tabla.
    }
    
//debo ir poniendo mensajes para identificar la falla al escribir el reporte
    
    /*public void insertFile(String name, HSSFCell hssfCell, HSSFRow hssfRow, int nc, HSSFCellStyle style) {        
            try {                
                hssfRow.createCell(nc);
                //hssfCell = hssfRow.getCell(nc);
                hssfCell.setCellValue(name);
                hssfCell.setCellStyle(style);
            } catch (Exception e) {
                Messagebox.show("Error in ReportRobustness.insertFile()" + e);
                e.printStackTrace();
            }
        }
    
    public void insertFile(String name, HSSFSheet  HSSFRow hssfRow, int c, HSSFCellStyle style) {        
        try {
            HSSFCell hssfCell = hssfRow.createCell(c);
            hssfCell.setCellValue(name);
            hssfCell.setCellStyle(style);

        } catch (Exception e) {
            Messagebox.show("Error in ReportRobustness.insertFile()" + e);
            e.printStackTrace();
        }
    }*/
     public void insertFile(String name, HSSFRow hssfRow, int c, HSSFCellStyle style) {        
        try {
            HSSFCell hssfCell = hssfRow.createCell(c);
            hssfCell.setCellValue(name);
            hssfCell.setCellStyle(style);

        } catch (Exception e) {
            Messagebox.show("Error in ReportRobustness.insertFile()" + e);
            e.printStackTrace();
        }
    }

    public void insertFileD(double name, HSSFRow hssfRow, int c) {
        try {            
            HSSFCell hssfCell = hssfRow.createCell(c);       
            hssfCell.setCellValue(name);
        } catch (Exception e) {
            System.out.println("Error in ReportRobustness.insertFileD()"+ name);
            e.printStackTrace();
        }
    }
    
//    public void insertFileStringRound(double name, HSSFSheet  HSSFRow hssfRow, int c) {
//        Redondeo r = new Redondeo(false);
//        try {            
//            HSSFCell hssfCell = hssfRow.createCell(c);            
//            if (name==0)
//                hssfCell.setCellValue(name);
//            else{
//                hssfCell.setCellValue(Double.parseDouble(r.roundWithDP(Double.toString(name), Double.toString(name), false).get(0)));
////                hssfCell.setCellValue(r.direct_rounding(Double.toString(name), 3).get(0));
////                hssfCell.setCellValue(Double.parseDouble(r.redondear(name,3)));
//            }
//            
//        } catch (Exception e) {
//            System.out.println("Error in ReportRobustness.insertFileStringRound()"+ name);
//            e.printStackTrace();
//        }
//    }
//    public void insertFileStringRound1(double num, HSSFSheet  HSSFRow hssfRow, int c) {
//        Redondeo r = new Redondeo(false);
//        try {            
//            HSSFCell hssfCell = hssfRow.createCell(c);            
//            if (num==0)
//                hssfCell.setCellValue(num);
//            else {
//                System.out.println("Para redondeo - " + Double.toString(num));
//                hssfCell.setCellValue(Double.parseDouble(r.roundWithDP(Double.toString(num), Double.toString(num), false).get(0)));
////                hssfCell.setCellValue(r.direct_rounding(Double.toString(num), 1).get(0));
////                hssfCell.setCellValue(Double.parseDouble(r.redondear(String.valueOf(num),1)));
//            }
//        } catch (Exception e) {
//            System.out.println("Error in ReportRobustness.insertFileD()"+ num);
//            e.printStackTrace();
//        }
//    }
}
