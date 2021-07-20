//REPORTE RESUMIDO
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

import M_T.Columnas;
import static java.awt.Color.RED;
import static java.awt.Color.red;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.util.CellRangeAddress;
import org.zkoss.zul.Messagebox;

/**
 *
 * @author Abde
 */
public class ReportResum {

    private ArrayList<Columnas> tabla;

    

    public ReportResum(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    
    //REPORTE RESUMIDO
    public void repM(String fileout, String[][] tablaRes) {
        Redondeo r = new Redondeo(false);        
       
        //countingProbabilitiesM();
        try {
            //falta hacer un ciclo para cada una de las muestras ahora solo lo hace para la primera 
            FileOutputStream fileOut = new FileOutputStream(fileout);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Report summary");

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, negrita, color ???? 
            HSSFFont font = workbook.createFont();
            font.setBoldweight(font.BOLDWEIGHT_BOLD);
            font.setColor(HSSFColor.BLACK.index);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setVerticalAlignment(style.VERTICAL_CENTER);
            style.setFont(font);

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, ajuste de texto, negrita, color ????
            HSSFFont font2 = workbook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(font.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setVerticalAlignment(style2.VERTICAL_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, color ????
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.GREEN.index);
            font3.setBoldweight(font.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setVerticalAlignment(style3.VERTICAL_CENTER);
            style3.setAlignment(style3.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);

            worksheet.setColumnWidth((short) 0, 2000);
            worksheet.setColumnWidth((short) 1, 4000);
            worksheet.setColumnWidth((short) 2, 2000);
            worksheet.setColumnWidth((short) 3, 2000);
            worksheet.setColumnWidth((short) 4, 2000);
                      
            worksheet.setColumnWidth((short) 5, 200);            
            worksheet.setColumnWidth((short) 6, 2000);
            worksheet.setColumnWidth((short) 7, 2000);
            worksheet.setColumnWidth((short) 8, 2000);
            
            worksheet.setColumnWidth((short) 9, 200);
            worksheet.setColumnWidth((short) 10, 2000);
            worksheet.setColumnWidth((short) 11, 2000);
            worksheet.setColumnWidth((short) 12, 2000);
            
            worksheet.setColumnWidth((short) 13, 200);            
            worksheet.setColumnWidth((short) 14, 2000);
            worksheet.setColumnWidth((short) 15, 2000);
            worksheet.setColumnWidth((short) 16, 2000);

            worksheet.setColumnWidth((short) 17, 200);//            --
            worksheet.setColumnWidth((short) 18, 2000);
            worksheet.setColumnWidth((short) 19, 2000);
            worksheet.setColumnWidth((short) 20, 2000);
            
            worksheet.setColumnWidth((short) 21, 200); //
            worksheet.setColumnWidth((short) 22, 6000);
            
            //worksheet.setDefaultRowHeight((short) 800);
            
           
            worksheet.addMergedRegion(new CellRangeAddress(0,0,2,4));//First division into three SuperGroups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,6,8));//Second division into three Main Groups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,10,12));//Third division into Groups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,14,16));//Fourth division into Subgroups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,18,20));//Fitth division into Subgroups
            
            worksheet.addMergedRegion(new CellRangeAddress(1,2,0,0));
            worksheet.addMergedRegion(new CellRangeAddress(1,2,1,1));
            worksheet.addMergedRegion(new CellRangeAddress(1,2,22,22));
            
            //0 renglón        
            HSSFRow row1 = worksheet.createRow((short) 0);//1
            HSSFCell cellA1 = row1.createCell(0);
            HSSFCell cellA2;
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Model type");

            cellA1 = row1.createCell(1);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Total number of samples");
            
            cellA1 = row1.createCell(2);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("First division into three SuperGroups");
            
            
            cellA1 = row1.createCell(6);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Second division into three Main Groups");
            
            cellA1 = row1.createCell(10);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Third division into Groups");
            
            cellA1 = row1.createCell(14);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Fourth division into Subgroups");
            
            cellA1 = row1.createCell(18);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Fifth division into groups");
            
            
            cellA1 = row1.createCell(22);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Inference about the most probable tectonic setting");
            
            HSSFRow row2 = worksheet.createRow((short) 1);//segundo renglón encabezados personalizados de acuerdo al input
            HSSFRow row3 = worksheet.createRow((short) 2);//tercer fila, modelo ilrMd            
                                
            cellA1 = row2.createCell(0);// fila de conteos de diagram (M) 
            cellA1.setCellStyle(style3); cellA1.setCellValue("ilrMd"); 
            
            if(tablaRes[1][0]!=null){//Total number of samples
                cellA1 = row2.createCell(1);
                cellA1.setCellStyle(style3);cellA1.setCellValue(tablaRes[1][0]);//Total number of samples
            }                       
            
            //1°
            if(tablaRes[0][1]!=null){ 
                cellA1 = row2.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[0][1]);//SG1             
                cellA1 = row2.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[0][2]);            
                cellA1 = row2.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][3]);                               
                
                //ahora los totales clasificados
                cellA1 = row3.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[1][1]);//SG1             
                cellA1 = row3.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[1][2]);            
                cellA1 = row3.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][3]); 
                
             }
            if(tablaRes[0][4]!=null){
            //2°
                cellA1 = row2.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][4]); 
                cellA1 = row2.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][5]); 
                cellA1 = row2.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][6]); 

                cellA1 = row3.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][4]); 
                cellA1 = row3.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][5]); 
                cellA1 = row3.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][6]);             
            }
            //3°
            cellA1 = row2.createCell(10);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(10);cellA2.setCellStyle(style);            
            if(tablaRes[0][7]!=null){
                cellA1.setCellValue(tablaRes[0][7]);
                cellA2.setCellValue(tablaRes[1][7]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(11);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(11);cellA2.setCellStyle(style);     
            if(tablaRes[0][8]!=null){
                cellA1.setCellValue(tablaRes[0][8]);
                cellA2.setCellValue(tablaRes[1][8]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(12);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(12);cellA2.setCellStyle(style);     
            if(tablaRes[0][9]!=null){
                cellA1.setCellValue(tablaRes[0][9]);
                cellA2.setCellValue(tablaRes[1][9]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(14);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(14);cellA2.setCellStyle(style);     
            //4°
            if(tablaRes[0][10]!=null){
                cellA1.setCellValue(tablaRes[0][10]); 
                cellA2.setCellValue(tablaRes[1][10]);             
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(15);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(15);cellA2.setCellStyle(style);   
            if(tablaRes[0][11]!=null){
                cellA1.setCellValue(tablaRes[0][11]);
                cellA2.setCellValue(tablaRes[1][11]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(16);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(16);cellA2.setCellStyle(style);  
            if(tablaRes[0][12]!=null){
                cellA1.setCellValue(tablaRes[0][12]); 
                cellA2.setCellValue(tablaRes[1][12]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }           
            
             //5°
            cellA1 = row2.createCell(18);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(18);cellA2.setCellStyle(style);  
            if(tablaRes[0][13]!=null){
                cellA1.setCellValue(tablaRes[0][13]); 
                cellA2.setCellValue(tablaRes[1][13]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            cellA1 = row2.createCell(19);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(19);cellA2.setCellStyle(style);  
            if(tablaRes[0][14]!=null){
                cellA1.setCellValue(tablaRes[0][14]); 
                cellA2.setCellValue(tablaRes[1][14]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
                        
            cellA1 = row2.createCell(20);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(20);cellA2.setCellStyle(style);  
            if(tablaRes[0][15]!=null){
                cellA1.setCellValue(tablaRes[0][15]); 
                cellA2.setCellValue(tablaRes[1][15]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            //DECISION FINAL
            if(tablaRes[1][16]!=null){                
                cellA1 = row2.createCell(22);cellA1.setCellStyle(style3);
                cellA1.setCellValue(tablaRes[1][16]);                             
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (IOException e) {
            Messagebox.show("Error in Report Summary** " + e);
        }
    }

         //REPORTE RESUMIDO
    public void repMT(String fileout, String[][] tablaResMT) {
        Redondeo r = new Redondeo(false);        
       
        //countingProbabilitiesM();
        try {
            //falta hacer un ciclo para cada una de las muestras ahora solo lo hace para la primera 
            FileOutputStream fileOut = new FileOutputStream(fileout);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Report summary");

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, negrita, color ???? 
            HSSFFont font = workbook.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setColor(HSSFColor.BLACK.index);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style.setFont(font);

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, ajuste de texto, negrita, color ????
            HSSFFont font2 = workbook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2;
            style2 = workbook.createCellStyle();
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, color ????
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.GREEN.index);
            font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);

            worksheet.setColumnWidth((short) 0, 2000);
            worksheet.setColumnWidth((short) 1, 4000);
            worksheet.setColumnWidth((short) 2, 2000);
            worksheet.setColumnWidth((short) 3, 2000);
            worksheet.setColumnWidth((short) 4, 2000);
                      
            worksheet.setColumnWidth((short) 5, 200);            
            worksheet.setColumnWidth((short) 6, 2000);
            worksheet.setColumnWidth((short) 7, 2000);
            worksheet.setColumnWidth((short) 8, 2000);
            
            worksheet.setColumnWidth((short) 9, 200);
            worksheet.setColumnWidth((short) 10, 2000);
            worksheet.setColumnWidth((short) 11, 2000);
            worksheet.setColumnWidth((short) 12, 2000);
            
            worksheet.setColumnWidth((short) 13, 200);            
            worksheet.setColumnWidth((short) 14, 2000);
            worksheet.setColumnWidth((short) 15, 2000);
            worksheet.setColumnWidth((short) 16, 2000);

            worksheet.setColumnWidth((short) 17, 200);//            --
            worksheet.setColumnWidth((short) 18, 2000);
            worksheet.setColumnWidth((short) 19, 2000);
            worksheet.setColumnWidth((short) 20, 2000);
            
            worksheet.setColumnWidth((short) 21, 200); //
            worksheet.setColumnWidth((short) 22, 6000);
            
            //worksheet.setDefaultRowHeight((short) 800);
            
           
            worksheet.addMergedRegion(new CellRangeAddress(0,0,2,4));//First division into three SuperGroups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,6,8));//Second division into three Main Groups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,10,12));//Third division into Groups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,14,16));//Fourth division into Subgroups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,18,20));//Fitth division into Subgroups
            
            worksheet.addMergedRegion(new CellRangeAddress(1,2,0,0));
            worksheet.addMergedRegion(new CellRangeAddress(1,2,1,1));
            worksheet.addMergedRegion(new CellRangeAddress(1,2,22,22));
            
            worksheet.addMergedRegion(new CellRangeAddress(4,5,0,0));
            worksheet.addMergedRegion(new CellRangeAddress(4,5,1,1));
            worksheet.addMergedRegion(new CellRangeAddress(4,5,22,22));
            
            //0 renglón        
            HSSFRow row1 = worksheet.createRow((short) 0);//1
            HSSFCell cellA1 = row1.createCell(0);
            HSSFCell cellA2;
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Model type");

            cellA1 = row1.createCell(1);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Total number of samples");
            
            cellA1 = row1.createCell(2);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("First division into three SuperGroups");
            
            
            cellA1 = row1.createCell(6);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Second division into three Main Groups");
            
            cellA1 = row1.createCell(10);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Third division into Groups");
            
            cellA1 = row1.createCell(14);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Fourth division into Subgroups");
            
            cellA1 = row1.createCell(18);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Fifth division into groups");
            
            
            cellA1 = row1.createCell(22);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Inference about the most probable tectonic setting");
            
            /******************************************
             * //MT
             */            
            HSSFRow row2 = worksheet.createRow((short) 1);//segunda fila, modelo ilrMd
            HSSFRow row3 = worksheet.createRow((short) 2);//tercer fila, modelo ilrMd         
            cellA1 = row2.createCell(0);// (MT)
            cellA1.setCellStyle(style3); cellA1.setCellValue("ilrMTd"); 
                                
            if(tablaResMT[1][0]!=null){//Total number of samples
                cellA1 = row2.createCell(1);
                cellA1.setCellStyle(style3);cellA1.setCellValue(tablaResMT[1][0]);//Total number of samples
            }                       
            
            //1°
            if(tablaResMT[0][1]!=null){ 
                cellA1 = row2.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[0][1]);//SG1             
                cellA1 = row2.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[0][2]);            
                cellA1 = row2.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][3]);                               
                
                //ahora los totales clasificados
                cellA1 = row3.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[1][1]);//SG1             
                cellA1 = row3.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[1][2]);            
                cellA1 = row3.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][3]); 
                
             }
            if(tablaResMT[0][4]!=null){
            //2°
                cellA1 = row2.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][4]); 
                cellA1 = row2.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][5]); 
                cellA1 = row2.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][6]); 

                cellA1 = row3.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][4]); 
                cellA1 = row3.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][5]); 
                cellA1 = row3.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][6]);             
            }
            //3°
            cellA1 = row2.createCell(10);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(10);cellA2.setCellStyle(style);            
            if(tablaResMT[0][7]!=null){
                cellA1.setCellValue(tablaResMT[0][7]);
                cellA2.setCellValue(tablaResMT[1][7]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(11);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(11);cellA2.setCellStyle(style);     
            if(tablaResMT[0][8]!=null){
                cellA1.setCellValue(tablaResMT[0][8]);
                cellA2.setCellValue(tablaResMT[1][8]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(12);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(12);cellA2.setCellStyle(style);     
            if(tablaResMT[0][9]!=null){
                cellA1.setCellValue(tablaResMT[0][9]);
                cellA2.setCellValue(tablaResMT[1][9]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(14);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(14);cellA2.setCellStyle(style);     
            //4°
            if(tablaResMT[0][10]!=null){
                cellA1.setCellValue(tablaResMT[0][10]); 
                cellA2.setCellValue(tablaResMT[1][10]);             
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(15);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(15);cellA2.setCellStyle(style);   
            if(tablaResMT[0][11]!=null){
                cellA1.setCellValue(tablaResMT[0][11]);
                cellA2.setCellValue(tablaResMT[1][11]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(16);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(16);cellA2.setCellStyle(style);  
            if(tablaResMT[0][12]!=null){
                cellA1.setCellValue(tablaResMT[0][12]); 
                cellA2.setCellValue(tablaResMT[1][12]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }           
            
             //5°
            cellA1 = row2.createCell(18);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(18);cellA2.setCellStyle(style);  
            if(tablaResMT[0][13]!=null){
                cellA1.setCellValue(tablaResMT[0][13]); 
                cellA2.setCellValue(tablaResMT[1][13]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            cellA1 = row2.createCell(19);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(19);cellA2.setCellStyle(style);  
            if(tablaResMT[0][14]!=null){
                cellA1.setCellValue(tablaResMT[0][14]); 
                cellA2.setCellValue(tablaResMT[1][14]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
                        
            cellA1 = row2.createCell(20);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(20);cellA2.setCellStyle(style);  
            if(tablaResMT[0][15]!=null){
                cellA1.setCellValue(tablaResMT[0][15]); 
                cellA2.setCellValue(tablaResMT[1][15]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            //DECISION FINAL
            if(tablaResMT[1][16]!=null){                
                cellA1 = row2.createCell(22);cellA1.setCellStyle(style3);
                cellA1.setCellValue(tablaResMT[1][16]);                             
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (IOException e) {
            Messagebox.show("Error in Report Summary** " + e);
        }
    }



     //REPORTE RESUMIDO
    public void repMMT(String fileout, String[][] tablaRes, String[][] tablaResMT) {
        Redondeo r = new Redondeo(false);        
       
        //countingProbabilitiesM();
        try {
            //falta hacer un ciclo para cada una de las muestras ahora solo lo hace para la primera 
            FileOutputStream fileOut = new FileOutputStream(fileout);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Report summary");

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, negrita, color ???? 
            HSSFFont font = workbook.createFont();
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            font.setColor(HSSFColor.BLACK.index);
            HSSFCellStyle style = workbook.createCellStyle();
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style.setFont(font);

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, ajuste de texto, negrita, color ????
            HSSFFont font2 = workbook.createFont();
            font2.setColor(HSSFColor.BLUE.index);
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle style2;
            style2 = workbook.createCellStyle();
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style2.setWrapText(true);
            style2.setFont(font2);

            //Estilo con centrado vertical, alineaciÃƒÂ³n izquierda, color ????
            HSSFFont font3 = workbook.createFont();
            font3.setColor(HSSFColor.GREEN.index);
            font3.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle style3 = workbook.createCellStyle();
            style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style3.setWrapText(true);
            style3.setFont(font3);

            worksheet.setColumnWidth((short) 0, 2000);
            worksheet.setColumnWidth((short) 1, 4000);
            worksheet.setColumnWidth((short) 2, 2000);
            worksheet.setColumnWidth((short) 3, 2000);
            worksheet.setColumnWidth((short) 4, 2000);
                      
            worksheet.setColumnWidth((short) 5, 200);            
            worksheet.setColumnWidth((short) 6, 2000);
            worksheet.setColumnWidth((short) 7, 2000);
            worksheet.setColumnWidth((short) 8, 2000);
            
            worksheet.setColumnWidth((short) 9, 200);
            worksheet.setColumnWidth((short) 10, 2000);
            worksheet.setColumnWidth((short) 11, 2000);
            worksheet.setColumnWidth((short) 12, 2000);
            
            worksheet.setColumnWidth((short) 13, 200);            
            worksheet.setColumnWidth((short) 14, 2000);
            worksheet.setColumnWidth((short) 15, 2000);
            worksheet.setColumnWidth((short) 16, 2000);

            worksheet.setColumnWidth((short) 17, 200);//            --
            worksheet.setColumnWidth((short) 18, 2000);
            worksheet.setColumnWidth((short) 19, 2000);
            worksheet.setColumnWidth((short) 20, 2000);
            
            worksheet.setColumnWidth((short) 21, 200); //
            worksheet.setColumnWidth((short) 22, 6000);
            
            //worksheet.setDefaultRowHeight((short) 800);
            
           
            worksheet.addMergedRegion(new CellRangeAddress(0,0,2,4));//First division into three SuperGroups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,6,8));//Second division into three Main Groups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,10,12));//Third division into Groups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,14,16));//Fourth division into Subgroups
            worksheet.addMergedRegion(new CellRangeAddress(0,0,18,20));//Fitth division into Subgroups
            
            worksheet.addMergedRegion(new CellRangeAddress(1,2,0,0));
            worksheet.addMergedRegion(new CellRangeAddress(1,2,1,1));
            worksheet.addMergedRegion(new CellRangeAddress(1,2,22,22));
            
            worksheet.addMergedRegion(new CellRangeAddress(4,5,0,0));
            worksheet.addMergedRegion(new CellRangeAddress(4,5,1,1));
            worksheet.addMergedRegion(new CellRangeAddress(4,5,22,22));
            
            //0 renglón        
            HSSFRow row1 = worksheet.createRow((short) 0);//1
            HSSFCell cellA1 = row1.createCell(0);
            HSSFCell cellA2;
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Model type");

            cellA1 = row1.createCell(1);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Total number of samples");
            
            cellA1 = row1.createCell(2);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("First division into three SuperGroups");
            
            
            cellA1 = row1.createCell(6);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Second division into three Main Groups");
            
            cellA1 = row1.createCell(10);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Third division into Groups");
            
            cellA1 = row1.createCell(14);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Fourth division into Subgroups");
            
            cellA1 = row1.createCell(18);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Fifth division into groups");
            
            
            cellA1 = row1.createCell(22);
            cellA1.setCellStyle(style2);
            cellA1.setCellValue("Inference about the most probable tectonic setting");
            
            HSSFRow row2 = worksheet.createRow((short) 1);//segunda fila, modelo ilrMd
            HSSFRow row3 = worksheet.createRow((short) 2);//tercer fila, modelo ilrMd            
            
            cellA1 = row2.createCell(0);// (M) 
            cellA1.setCellStyle(style3); cellA1.setCellValue("ilrMd"); 
            
            
            if(tablaRes[1][0]!=null){//Total number of samples
                cellA1 = row2.createCell(1);
                cellA1.setCellStyle(style3);cellA1.setCellValue(tablaRes[1][0]);//Total number of samples
            }                       
            
            //1°
            if(tablaRes[0][1]!=null){ 
                cellA1 = row2.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[0][1]);//SG1             
                cellA1 = row2.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[0][2]);            
                cellA1 = row2.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][3]);                               
                
                //ahora los totales clasificados
                cellA1 = row3.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[1][1]);//SG1             
                cellA1 = row3.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaRes[1][2]);            
                cellA1 = row3.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][3]); 
                
             }
            if(tablaRes[0][4]!=null){
            //2°
                cellA1 = row2.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][4]); 
                cellA1 = row2.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][5]); 
                cellA1 = row2.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[0][6]); 

                cellA1 = row3.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][4]); 
                cellA1 = row3.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][5]); 
                cellA1 = row3.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaRes[1][6]);             
            }
            //3°
            cellA1 = row2.createCell(10);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(10);cellA2.setCellStyle(style);            
            if(tablaRes[0][7]!=null){
                cellA1.setCellValue(tablaRes[0][7]);
                cellA2.setCellValue(tablaRes[1][7]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(11);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(11);cellA2.setCellStyle(style);     
            if(tablaRes[0][8]!=null){
                cellA1.setCellValue(tablaRes[0][8]);
                cellA2.setCellValue(tablaRes[1][8]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(12);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(12);cellA2.setCellStyle(style);     
            if(tablaRes[0][9]!=null){
                cellA1.setCellValue(tablaRes[0][9]);
                cellA2.setCellValue(tablaRes[1][9]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(14);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(14);cellA2.setCellStyle(style);     
            //4°
            if(tablaRes[0][10]!=null){
                cellA1.setCellValue(tablaRes[0][10]); 
                cellA2.setCellValue(tablaRes[1][10]);             
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(15);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(15);cellA2.setCellStyle(style);   
            if(tablaRes[0][11]!=null){
                cellA1.setCellValue(tablaRes[0][11]);
                cellA2.setCellValue(tablaRes[1][11]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(16);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(16);cellA2.setCellStyle(style);  
            if(tablaRes[0][12]!=null){
                cellA1.setCellValue(tablaRes[0][12]); 
                cellA2.setCellValue(tablaRes[1][12]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }           
            
             //5°
            cellA1 = row2.createCell(18);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(18);cellA2.setCellStyle(style);  
            if(tablaRes[0][13]!=null){
                cellA1.setCellValue(tablaRes[0][13]); 
                cellA2.setCellValue(tablaRes[1][13]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            cellA1 = row2.createCell(19);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(19);cellA2.setCellStyle(style);  
            if(tablaRes[0][14]!=null){
                cellA1.setCellValue(tablaRes[0][14]); 
                cellA2.setCellValue(tablaRes[1][14]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
                        
            cellA1 = row2.createCell(20);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(20);cellA2.setCellStyle(style);  
            if(tablaRes[0][15]!=null){
                cellA1.setCellValue(tablaRes[0][15]); 
                cellA2.setCellValue(tablaRes[1][15]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            //DECISION FINAL
            if(tablaRes[1][16]!=null){                
                cellA1 = row2.createCell(22);cellA1.setCellStyle(style3);
                cellA1.setCellValue(tablaRes[1][16]);                             
            }
            /******************************************
             * //MT
             */            
            row2 = worksheet.createRow((short) 4);//cuarta fila, modelo ilrMT       
            row3 = worksheet.createRow((short) 5);//quinta fila, modelo ilrMd       
            cellA1 = row2.createCell(0);// (M)
            cellA1.setCellStyle(style3); cellA1.setCellValue("ilrMTd"); 
                                
            if(tablaResMT[1][0]!=null){//Total number of samples
                cellA1 = row2.createCell(1);
                cellA1.setCellStyle(style3);cellA1.setCellValue(tablaResMT[1][0]);//Total number of samples
            }                       
            
            //1°
            if(tablaResMT[0][1]!=null){ 
                cellA1 = row2.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[0][1]);//SG1             
                cellA1 = row2.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[0][2]);            
                cellA1 = row2.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][3]);                               
                
                //ahora los totales clasificados
                cellA1 = row3.createCell(2);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[1][1]);//SG1             
                cellA1 = row3.createCell(3);
                cellA1.setCellStyle(style); cellA1.setCellValue(tablaResMT[1][2]);            
                cellA1 = row3.createCell(4);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][3]); 
                
             }
            if(tablaResMT[0][4]!=null){
            //2°
                cellA1 = row2.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][4]); 
                cellA1 = row2.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][5]); 
                cellA1 = row2.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[0][6]); 

                cellA1 = row3.createCell(6);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][4]); 
                cellA1 = row3.createCell(7);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][5]); 
                cellA1 = row3.createCell(8);
                cellA1.setCellStyle(style);cellA1.setCellValue(tablaResMT[1][6]);             
            }
            //3°
            cellA1 = row2.createCell(10);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(10);cellA2.setCellStyle(style);            
            if(tablaResMT[0][7]!=null){
                cellA1.setCellValue(tablaResMT[0][7]);
                cellA2.setCellValue(tablaResMT[1][7]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(11);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(11);cellA2.setCellStyle(style);     
            if(tablaResMT[0][8]!=null){
                cellA1.setCellValue(tablaResMT[0][8]);
                cellA2.setCellValue(tablaResMT[1][8]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(12);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(12);cellA2.setCellStyle(style);     
            if(tablaResMT[0][9]!=null){
                cellA1.setCellValue(tablaResMT[0][9]);
                cellA2.setCellValue(tablaResMT[1][9]); 
             }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(14);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(14);cellA2.setCellStyle(style);     
            //4°
            if(tablaResMT[0][10]!=null){
                cellA1.setCellValue(tablaResMT[0][10]); 
                cellA2.setCellValue(tablaResMT[1][10]);             
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(15);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(15);cellA2.setCellStyle(style);   
            if(tablaResMT[0][11]!=null){
                cellA1.setCellValue(tablaResMT[0][11]);
                cellA2.setCellValue(tablaResMT[1][11]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }
            
            cellA1 = row2.createCell(16);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(16);cellA2.setCellStyle(style);  
            if(tablaResMT[0][12]!=null){
                cellA1.setCellValue(tablaResMT[0][12]); 
                cellA2.setCellValue(tablaResMT[1][12]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            }           
            
             //5°
            cellA1 = row2.createCell(18);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(18);cellA2.setCellStyle(style);  
            if(tablaResMT[0][13]!=null){
                cellA1.setCellValue(tablaResMT[0][13]); 
                cellA2.setCellValue(tablaResMT[1][13]);                         
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            cellA1 = row2.createCell(19);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(19);cellA2.setCellStyle(style);  
            if(tablaResMT[0][14]!=null){
                cellA1.setCellValue(tablaResMT[0][14]); 
                cellA2.setCellValue(tablaResMT[1][14]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
                        
            cellA1 = row2.createCell(20);cellA1.setCellStyle(style);
            cellA2 = row3.createCell(20);cellA2.setCellStyle(style);  
            if(tablaResMT[0][15]!=null){
                cellA1.setCellValue(tablaResMT[0][15]); 
                cellA2.setCellValue(tablaResMT[1][15]); 
            }else{
                cellA1.setCellValue("---");
                cellA2.setCellValue("---"); 
            } 
            
            //DECISION FINAL
            if(tablaResMT[1][16]!=null){                
                cellA1 = row2.createCell(22);cellA1.setCellStyle(style3);
                cellA1.setCellValue(tablaResMT[1][16]);                             
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (IOException e) {
            Messagebox.show("Error in Report Summary** " + e);
        }
    }


    
}
