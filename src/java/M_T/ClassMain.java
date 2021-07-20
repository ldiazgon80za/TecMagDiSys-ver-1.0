/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.lang.Math;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.encoders.ImageFormat;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.AImage;
import org.zkoss.io.Files;
import org.zkoss.util.media.AMedia;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author Abdelaly
 */
public class ClassMain {

    private Integer progreso;
    private String var1;
    private String filePath;
    private String fileout;
    private String fileout2;
    private String fileout3;
    private String fileout4;
    private String fileOutProp;

    private ArrayList<Columnas> tabla;
    private boolean fileopen = false;
    private boolean fileuploadedM = true;
    private boolean fileuploadedMT = true;
    private boolean filePostemplaM = true;
    private boolean filePostemplaMT = true;

    private boolean fileprocess = false;

    private boolean filePropM = true;
    private boolean filePropMT = true;

    private String webContentRoot;

    private boolean graficas = false;
    private boolean grafM = false;
    private boolean grafMT = false;
    private Image myImage;
    private boolean imageDefault = true;

    AMedia fileContent;
    AMedia fileContentimg1;
    AMedia fileContentimg2;
    AMedia fileContent2;
    AMedia fileContent3;
    AMedia fileContentReportMT;
    AMedia fileContent4;
    AMedia fileContentx;
    AMedia fileimagen;

    AImage imagen;
    AImage imagen2;

    @Wire("#test")
    private Window win;
    private String cell1;
    List cellDataList = new ArrayList();
    public HSSFSheet hssfSheet;
    HashMap<String, Integer> headers;
    private String[][] matrizR = null;
    private boolean valid = true;
    private LeerArchivo leerArchivo;
    private LeerArchivoPostempla leerArchivoPostempla;
    private LeerArchivoProp leerArchivoProp;

    private CalculaAdj calculaAdj;
    private CalculaDFsDis calculaDFs;
    private ReportResult reportResult;
    private ReportResum reportResum;
    
    private MatrizPropagacion matrizPropagacion;

    private MatrizPostempla matrizPostempla;

    private boolean hmg = false;
    private boolean sens = false;
    private boolean graficasmt = false;
    private boolean grafmt = false;
    private boolean grafm = false;
    private boolean prop = false;

   
    private ReportRobustness reportPropagation;
    private boolean cambia = false;
    

    public ReportRobustness getReportRobustness() {
        return reportPropagation;
    }

    public void setReportRobustness(ReportRobustness s) {
        this.reportPropagation = s;
    }

    public AMedia getFileContentx() {
        return fileContentx;
    }

    public void setFileContentx(AMedia fileContentx) {
        this.fileContentx = fileContentx;
    }

    public MatrizPropagacion getMatrizpropagacion() {
        return matrizPropagacion;
    }

    public void setMatrizpropagacion(MatrizPropagacion matrizPropagacion) {
        this.matrizPropagacion = matrizPropagacion;
    }

    public ReportResum getReportResum() {
        return reportResum;
    }

    public void setReporte_res(ReportResum r) {
        reportResum = r;
    }

    public String getWebContentRoot() {
        return webContentRoot;
    }

    public void setWebContentRoot(String webContentRoot) {
        this.webContentRoot = webContentRoot;
    }

    public ReportResult getReportResult() {
        return reportResult;
    }

    public void setRep_result(ReportResult r) {
        reportResult = r;
    }

    public boolean isGraficasmt() {
        return graficasmt;
    }

    public void setGraficasmt(boolean graficasmt) {
        this.graficasmt = graficasmt;
    }

    public boolean isGrafmt() {
        return grafmt;
    }

    public void setGrafmt(boolean grafmt) {
        this.grafmt = grafmt;
    }

    public boolean isGrafm() {
        return grafm;
    }

    public void setGrafm(boolean grafm) {
        this.grafm = grafm;
    }

    public AImage getImagen2() {
        return imagen2;
    }

    public void setImagen2(AImage imagen2) {
        this.imagen2 = imagen2;
    }

    public AMedia getFileContentimg2() {
        return fileContentimg2;
    }

    public void setFileContentimg2(AMedia fileContentimg2) {
        this.fileContentimg2 = fileContentimg2;
    }

    public AMedia getFileContentimg1() {
        return fileContentimg1;
    }

    public void setFileContentimg1(AMedia fileContentimg1) {
        this.fileContentimg1 = fileContentimg1;
    }

    public AMedia getFileContent() {
        return fileContent;
    }

    public void setFileContent(AMedia fileContent) {
        this.fileContent = fileContent;
    }

    public CalculaDFsDis getCalculaDFsDis() {
        return calculaDFs;
    }

    public void setCalculaDFsDis(CalculaDFsDis calculaDFs) {
        this.calculaDFs = calculaDFs;
    }

    public Image getMyImage() {
        return myImage;
    }

    public void setMyImage(Image myImage) {
        this.myImage = myImage;
    }

    public boolean isGraficas() {
        return graficas;
    }

    public void setGraficas(boolean graficas) {
        this.graficas = graficas;
    }

    public AMedia getFileimagen() {
        return fileimagen;
    }

    public void setFileimagen(AMedia fileimagen) {
        this.fileimagen = fileimagen;
    }

    public AImage getImagen() {
        return imagen;
    }

    public void setImagen(AImage imagen) {
        this.imagen = imagen;
    }

  

    public CalculaAdj getCalculaAdj() {
        return calculaAdj;
    }

    public void setCalculaAdj(CalculaAdj calculaAdj) {
        this.calculaAdj = calculaAdj;
    }

    public boolean isFilePostemplaM() {
        return filePostemplaM;
    }

    public void setFilePostemplaM(boolean f) {
        filePostemplaM = f;
    }

    public boolean isFilePostemplaMT() {
        return filePostemplaMT;
    }

    public void setFilePostemplaMT(boolean f) {
        filePostemplaMT = f;
    }

    public boolean isHmg() {
        return hmg;
    }

    public void setHmg(boolean hmg) {
        this.hmg = hmg;
    }

    public boolean isSens() {
        return sens;
    }

    public void setSens(boolean sens) {
        this.sens = sens;
    }

    public String getFileout4() {
        return fileout4;
    }

    public void setFileout4(String fileout4) {
        this.fileout4 = fileout4;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getFileout3() {
        return fileout3;
    }

    public void setFileout3(String fileout3) {
        this.fileout3 = fileout3;
    }

    public boolean isFileopen() {
        return fileopen;
    }

    public void setFileopen(boolean fileopen) {
        this.fileopen = fileopen;
    }

    public boolean isCambia() {
        return cambia;
    }

    public void setCambia(boolean cambia) {
        this.cambia = cambia;
    }

    public String[][] getMatrizR() {
        return matrizR;
    }

    public void setMatrizR(String[][] matrizR) {
        this.matrizR = matrizR;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public LeerArchivo getLeerArchivo() {
        return leerArchivo;
    }

    public void setLeerArchivo(LeerArchivo leerArchivo) {
        this.leerArchivo = leerArchivo;
    }

    public boolean isFileprocess() {
        return fileprocess;
    }

    public void setFileprocess(boolean fileprocess) {
        this.fileprocess = fileprocess;
    }

    public String getVar1() {
        return var1;
    }

    public HashMap<String, Integer> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, Integer> headers) {
        this.headers = headers;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getCell1() {
        return cell1;
    }

    public void setCell1(String cell1) {
        this.cell1 = cell1;
    }

    public AMedia getFileContent3() {
        return fileContent3;
    }

    public void setFileContent3(AMedia fileContent3) {
        this.fileContent3 = fileContent3;
    }
    
    public AMedia getFileContentReportMT() {
        return fileContentReportMT;
    }

    public void setFileContentReportMT(AMedia fileContent) {
        this.fileContentReportMT = fileContent;
    }

    public AMedia getFileContent4() {
        return fileContent4;
    }

    public void setFileContent4(AMedia fileContent4) {
        this.fileContent4 = fileContent4;
    }

    public AMedia getFileContent2() {
        return fileContent2;
    }

    public void setFileContent2(AMedia fileContent2) {
        this.fileContent2 = fileContent2;
    }

    public boolean isFileuploadedM() {
        return fileuploadedM;
    }

    public void setFileuploadedM(boolean fileuploaded) {
        this.fileuploadedM = fileuploaded;
    }

    public boolean isFileuploadedMT() {
        return fileuploadedMT;
    }

    public void setFileuploadedMT(boolean fileuploaded) {
        this.fileuploadedMT = fileuploaded;
    }

    public boolean isFilePropM() {
        return this.filePropM;
    }

    public void setFilePropM(boolean fileprop) {
        this.filePropM = fileprop;
    }

    public boolean isFilePropMT() {
        return this.filePropMT;
    }

    public void setFilePropMT(boolean fileprop) {
        this.filePropMT = fileprop;
    }

    public Integer getProgreso() {
        return progreso;
    }

    public void setProgreso(Integer progreso) {
        this.progreso = progreso;
    }

    public String getFileout() {
        return fileout;
    }

    public void setFileout(String fileout) {
        this.fileout = fileout;
    }

    public String getFileout2() {
        return fileout2;
    }

    public void setFileout2(String fileout2) {
        this.fileout2 = fileout2;
    }

    public String getFileOutProp() {
        return fileOutProp;
    }

    public void setFileOutProp(String fileout) {
        this.fileOutProp = fileout;
    }

    // seccion es para obtener la sesion aqr ********************************************
    public String getApplicationPath() {
        return Executions.getCurrent().getDesktop().getWebApp().getRealPath("/");
    }

    public String getSessionId() {
        Session zkses = Sessions.getCurrent();
        HttpSession httpses = (HttpSession) zkses.getNativeSession();
        return httpses.getId();
    }

    public void createDir(String dirName) {
        File theDir = new File(dirName);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("creating directory: " + dirName);
            boolean result = false;

            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                //  System.out.println("DIR created");
            }
        }
    }

    @AfterCompose
    public void initSetup(@ContextParam(ContextType.VIEW) Component view) {
        String sessionId = this.getSessionId();   // esto es para obtener el id de sesion al inicion del programa
        webContentRoot = this.getApplicationPath();
        this.createDir(webContentRoot + "/tmp");
        this.createDir(webContentRoot + "/tmp/" + sessionId);
        this.webContentRoot += "/tmp/" + sessionId + "/"; //ruta completa
        Selectors.wireComponents(view, this, false);
    }

    public void messProcessed() {
        Clients.clearBusy();
        Messagebox.show("The file has been successfully processed. \n Please check the reports.");
        progreso = 100;
    }

    public void messValidated() {
        Messagebox.show("The file has been successfully validated. \n Now the data can be processed.");
    }
// *********************************************************************   

    /**
     * ****************************
     * Discrminate tectonic setting ****************************
     */
    @Command
    @NotifyChange({"fileuploadedMT", "tabla", "headers", "fileopen"})
    public void openMT(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();
        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }
        if (upEvent != null) {
            Media media = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH); // Note: zero based!
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePath = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/");
            String yearPath = "\\" + "XLSs" + "\\" + year + "\\" + month + "\\"
                    + day + "\\";
            filePath = filePath + yearPath;
            File baseDir = new File(filePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }

            Files.copy(new File(filePath + media.getName()), media.getStreamData());

            fileopen = true;
            fileuploadedMT = false;
            //fileprocess = true;

            filePath = filePath + media.getName();

            this.leerArchivo = new LeerArchivo();
            this.leerArchivo.leeMT(filePath, cambia);
            this.tabla = this.leerArchivo.getTabla();
            this.headers = this.leerArchivo.getHeaders();
            messValidated();
        }

    }

    @Command
    @NotifyChange({"fileuploadedM", "tabla", "headers", "fileopen"})
    public void openM(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx) throws IOException {
        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();
        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }
        if (upEvent != null) {
            Media media = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH); // Note: zero based!
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePath = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/");
            String yearPath = "\\" + "XLSs" + "\\" + year + "\\" + month + "\\"
                    + day + "\\";
            filePath = filePath + yearPath;
            File baseDir = new File(filePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            Files.copy(new File(filePath + media.getName()), media.getStreamData());
            fileopen = true;
            fileuploadedM = false;
            filePath = filePath + media.getName();
            this.leerArchivo = new LeerArchivo();
            this.leerArchivo.leeM(filePath, cambia);
            this.tabla = this.leerArchivo.getTabla();
            this.headers = this.leerArchivo.getHeaders();
            messValidated();
            System.out.println("***********   deb");
        }
    }
    @Command
    @NotifyChange({"progreso", "fileContent","fileContent3", "fileContentReportMT", "tabla", "grafm", "grafmt"})
    public void processMT() throws IOException {
        String[][] tablaRes, tablaResMT;
        //grafm = true;
        grafmt = true;
        //M
        /*calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();
        
        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramM();
        tabla = calculaDFs.getTabla();        
        tablaRes=calculaDFs.getTablaResumen();//obtengo la tabla de conteos    
        */
        //MT
        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrMT();
        tabla = calculaAdj.getTabla();

        this.calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMT();
        tabla = calculaDFs.getTabla();
        tablaResMT=calculaDFs.getTablaResumen();//obtengo la tabla de conteos    
        //reporte general M
        /*fileprocess = true;//para habilitar menu de figuras        
        
        reportResult = new ReportResult(tabla);
        reportResult.reportM(filePath);
        fileContent3=showXLSresult("_M");//hace referencia a fileContent3      
        */
        //reporte general MT        
        reportResult = new ReportResult(tabla);
        reportResult.reportMT(filePath);
        fileContentReportMT = showXLSresult("_MT");
        
        //reporte resumido M y MT
        fileout = webContentRoot + "Report_Resum";       
        reportResum = new ReportResum(tabla); 
        fileout = webContentRoot + "Summary MT.xls";
        //reportResum.repM(fileout,tablaRes); 
        reportResum.repMT(fileout,tablaResMT);
        fileContent=showFileOut(fileout);//hace referencia a fileContent

        fileprocess = true;//para habilitar menu de figuras
        messProcessed();
    }
    
    
    /*    @Command
    @NotifyChange({"progreso", "fileContent","fileContent3", "fileContentReportMT", "tabla", "grafm", "grafmt"})
    public void processMT_QUE INTENTABA GUARDAR DOS REPORTES M Y MT () throws IOException {
        String[][] tablaRes, tablaResMT;
        grafm = true;
        grafmt = true;
        //M
        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();
        
        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramM();
        tabla = calculaDFs.getTabla();        
        tablaRes=calculaDFs.getTablaResumen();//obtengo la tabla de conteos    
        
        //MT
        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrMT();
        tabla = calculaAdj.getTabla();

        this.calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMT();
        tabla = calculaDFs.getTabla();
        tablaResMT=calculaDFs.getTablaResumen();//obtengo la tabla de conteos    
        //reporte general M
        fileprocess = true;//para habilitar menu de figuras        
        
        reportResult = new ReportResult(tabla);
        reportResult.reportM(filePath);
        fileContent3=showXLSresult("_M");//hace referencia a fileContent3      
        
        //reporte general MT
        String fileoutMT = webContentRoot + "Report_Resum_mmmTT";  
        reportResult = new ReportResult(tabla);
        reportResult.reportMT(fileoutMT);
//solo queda pendiente saber si es necesario que sea global: String fileoutMT
        fileContentReportMT = showFileOut(fileoutMT);
        
        //reporte resumido M y MT
        fileout = webContentRoot + "Report_Resum";       
        reportResum = new ReportResum(tabla); 
        fileout = webContentRoot + "Summary MT.xls";
        reportResum.repM(fileout,tablaRes); 
        reportResum.repMMT(fileout,tablaRes, tablaResMT);
        fileContent=showFileOut(fileout);//hace referencia a fileContent

        fileprocess = true;//para habilitar menu de figuras
        messProcessed();
    }*/
 /*   @Command
    @NotifyChange({"progreso", "fileContent", "fileContentReportMT", "tabla", "grafm", "grafmt"})
    public void processMTold() throws IOException {
        grafm = true;
        grafmt = true;

        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrM();
       
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramM();
        tabla = calculaDFs.getTabla();
        //
        
        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrMT();
        tabla = calculaAdj.getTabla();

        this.calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMT();
        tabla = calculaDFs.getTabla();

        fileprocess = true;//para habilitar menu de figuras        
        fileout = webContentRoot + "Report_Resum";
        
        reportResult = new ReportResult(tabla);
        reportResult.reportM(filePath);
        fileContent = showXLSresult();
       
        reportResult = new ReportResult(tabla);
        reportResult.reportMT(filePath);
       fileContentReportMT = showXLSresult();
//procesaArchivoMT("ilr");
        messProcessed();
    }*/

    @Command
    @NotifyChange({"progreso", "fileContent", "fileContent3", "tabla", "grafm","tablaRes","fileout"})
    public void processM() throws IOException {
        grafm = true;
        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramM();
        tabla = calculaDFs.getTabla();        
        String[][] tablaRes=calculaDFs.getTablaResumen();//obtengo la tabla de conteos    
        
        reportResult = new ReportResult(tabla);
        reportResult.reportM(filePath);
        fileContent3=showXLSresult("_M");//hace referencia a fileContent3      
        
        reportResum = new ReportResum(tabla); 
        fileout = webContentRoot + "Summary M.xls";
        reportResum.repM(fileout,tablaRes); 
        fileContent=showFileOut(fileout);//hace referencia a fileContent

        fileprocess = true;//para habilitar menu de figuras
        messProcessed();
    }

    /**
     * ***********************************
     * Post-emplacement ***********************************
     */
    @Command
    @NotifyChange({"filePostemplaM", "tabla", "headers", "fileopen"})
    public void openPostemplaM(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
            throws IOException {

        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();
        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }
        if (upEvent != null) {
            Media media = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH); // Note: zero based!
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePath = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/");
            String yearPath = "\\" + "XLSs" + "\\" + year + "\\" + month + "\\"
                    + day + "\\";
            filePath = filePath + yearPath;
            File baseDir = new File(filePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            Files.copy(new File(filePath + media.getName()), media.getStreamData());

            fileopen = true; //duda si lo quito o no            
            filePostemplaM = false;   //filePostemplaM sustituye a fileuploadedM

            filePath = filePath + media.getName();

            this.leerArchivoPostempla = new LeerArchivoPostempla();
            this.leerArchivoPostempla.lee(filePath, false);//false=M mayor
            this.tabla = this.leerArchivoPostempla.getTabla();
            this.headers = this.leerArchivoPostempla.getHeaders();
            messValidated();
        }
    }

    @Command
    @NotifyChange({"filePostemplaMT", "tabla", "headers", "fileopen"})
    public void openPostemplaMT(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
            throws IOException {

        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();
        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }
        if (upEvent != null) {
            Media media = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH); // Note: zero based!
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePath = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/");
            String yearPath = "\\" + "XLSs" + "\\" + year + "\\" + month + "\\"
                    + day + "\\";
            filePath = filePath + yearPath;
            File baseDir = new File(filePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            Files.copy(new File(filePath + media.getName()), media.getStreamData());
            fileopen = true;
            filePostemplaMT = false;

            filePath = filePath + media.getName();

            this.leerArchivoPostempla = new LeerArchivoPostempla();
            this.leerArchivoPostempla.lee(filePath, true);//true=MT 
            this.tabla = this.leerArchivoPostempla.getTabla();
            this.headers = this.leerArchivoPostempla.getHeaders();
            messValidated();
        }
    }

    @Command
    @NotifyChange({"tabla", "fileContent3"})
    public void processPostemplaM() throws IOException {
        filePostemplaM = true;//
        matrizPostempla = new MatrizPostempla(tabla);
        matrizPostempla.runPostemplaM();
        tabla = matrizPostempla.getTabla();

        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMsinTablaResumen();
        tabla = calculaDFs.getTabla();
        
        fileOutProp = webContentRoot + "Post-emplacement_Report_M.xls";
        reportPropagation = new ReportRobustness(tabla);
        reportPropagation.reportPostemplaM(fileOutProp);        
        fileContent3 = this.showFileOut(fileOutProp);
        messProcessed();
    }

    @Command
    @NotifyChange({"tabla", "fileContent3",})
    public void processPostemplaMT() throws IOException {
        filePostemplaMT = true;//
        matrizPostempla = new MatrizPostempla(tabla);
        matrizPostempla.runPostemplaMT();
        tabla = matrizPostempla.getTabla();

        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrMT();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMTsinTablaResumen();
        tabla = calculaDFs.getTabla();
        
        fileOutProp = webContentRoot + "Post-emplacement_Report_MT.xls";
        this.reportPropagation = new ReportRobustness(tabla);
        reportPropagation.reportPostemplaMT(fileOutProp);        
        fileContent3 = this.showFileOut(fileOutProp);
        messProcessed();
    }

    /**
     * ***********************************
     * Propagation ***********************************
     */
    @Command
    @NotifyChange({"filePropM", "leerArchivoProp", "tabla", "headers", "fileopen"})
    public void openPropagationM(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
            throws IOException {

        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();
        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }
        if (upEvent != null) {
            Media media = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH); // Note: zero based!
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePath = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/");
            String yearPath = "\\" + "XLSs" + "\\" + year + "\\" + month + "\\"
                    + day + "\\";
            filePath = filePath + yearPath;
            File baseDir = new File(filePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            Files.copy(new File(filePath + media.getName()), media.getStreamData());

            fileopen = true;
            filePropM = false;

            filePath = filePath + media.getName();

            this.leerArchivoProp = new LeerArchivoProp();
            this.leerArchivoProp.lee(filePath);
            this.tabla = this.leerArchivoProp.getTabla();
            this.headers = this.leerArchivoProp.getHeaders();
            messValidated();
        }

    }

    @Command
    @NotifyChange({"filePropMT", "leerArchivoProp", "tabla", "headers", "fileopen"})
    public void openPropagationMT(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx)
            throws IOException {

        UploadEvent upEvent = null;
        Object objUploadEvent = ctx.getTriggerEvent();
        if (objUploadEvent != null && (objUploadEvent instanceof UploadEvent)) {
            upEvent = (UploadEvent) objUploadEvent;
        }
        if (upEvent != null) {
            Media media = upEvent.getMedia();
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH); // Note: zero based!
            int day = now.get(Calendar.DAY_OF_MONTH);
            filePath = Executions.getCurrent().getDesktop().getWebApp()
                    .getRealPath("/");
            String yearPath = "\\" + "XLSs" + "\\" + year + "\\" + month + "\\"
                    + day + "\\";
            filePath = filePath + yearPath;
            File baseDir = new File(filePath);
            if (!baseDir.exists()) {
                baseDir.mkdirs();
            }
            Files.copy(new File(filePath + media.getName()), media.getStreamData());

            fileopen = true;
            filePropMT = false;

            filePath = filePath + media.getName();

            this.leerArchivoProp = new LeerArchivoProp();
            this.leerArchivoProp.lee(filePath);
            this.tabla = this.leerArchivoProp.getTabla();
            this.headers = this.leerArchivoProp.getHeaders();
            messValidated();
        }

    }

   /* @Command
    @NotifyChange({"tabla", "fileContent", "fileContent3", "fileOutProp"})
    public void processPropagationM() throws IOException {
        filePropM = true;//        
        matrizPropagacion = new MatrizPropagacion(tabla);
        matrizPropagacion.converMatrizM();
        tabla = matrizPropagacion.getTabla();

        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramM();
        tabla = calculaDFs.getTabla();

        //reporte de resultados
        fileOutProp = webContentRoot + "PropReport.xls";
        reportPropagation = new ReportRobustness(tabla);
        //reportPropagation.reportPropagationM(fileOutProp);
        fileContent3 = this.showXLS(fileOutProp);

        //report summary  
        fileout = webContentRoot + "Report summary";
        reportResum = new ReportResum(tabla);
        //reportResum.repM(fileout);
        
        fileContent = showXLS(fileout);

        messProcessed();
    }*/
    @Command //
    @NotifyChange({"tabla", "fileContent", "fileContent3", "fileOutProp"})
    public void processPropagationM() throws IOException {
        filePropMT = true;
        String[][] tablaResum;
        matrizPropagacion = new MatrizPropagacion(tabla);
        matrizPropagacion.converMatrizM();//Â¿quÃ© hace converMatrizMT() a partir de la concentraciÃ³n inicial??
        tabla = matrizPropagacion.getTabla();

        //MT
        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramM();
        tabla = calculaDFs.getTabla();
        tablaResum=calculaDFs.getTablaResumen();//obtengo la tabla de conteos  
       
        //report results
        fileOutProp = webContentRoot + "PropReport.xls";
        reportPropagation = new ReportRobustness(tabla);
        reportPropagation.reportpropagationM(fileOutProp);        
        fileContent3 = this.showFileOut(fileOutProp);

       //reporte resumido              
        reportResum = new ReportResum(tabla); 
        fileout = webContentRoot + "Summary M.xls";        
        reportResum.repM(fileout,tablaResum);
        fileContent=showFileOut(fileout);//hace referencia a fileContent
        
        messProcessed();
    }
    
    
    @Command //
    @NotifyChange({"tabla", "fileContent", "fileContent3", "fileOutProp"})
    public void processPropagationMT() throws IOException {
        filePropMT = true;
        String[][] tablaResum;
        matrizPropagacion = new MatrizPropagacion(tabla);
        matrizPropagacion.converMatrizMT();//Â¿quÃ© hace converMatrizMT() a partir de la concentraciÃ³n inicial??
        tabla = matrizPropagacion.getTabla();

        //MT
        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrMT();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMT();
        tabla = calculaDFs.getTabla();
        tablaResum=calculaDFs.getTablaResumen();//obtengo la tabla de conteos  
       
        //report results
        fileOutProp = webContentRoot + "PropReport.xls";
        reportPropagation = new ReportRobustness(tabla);
        reportPropagation.reportPropagationMT(fileOutProp);
        fileContent3 = this.showFileOut(fileOutProp);

       //reporte resumido              
        reportResum = new ReportResum(tabla); 
        fileout = webContentRoot + "Summary MT.xls";        
        reportResum.repMT(fileout,tablaResum);
        fileContent=showFileOut(fileout);//hace referencia a fileContent
        
        messProcessed();
    }
/*
    @Command //
    @NotifyChange({"tabla", "fileContent", "fileContent3", "fileOutProp"})
    public void processPropagationMandMT() throws IOException {
        filePropMT = true;
        matrizPropagacion = new MatrizPropagacion(tabla);
        matrizPropagacion.converMatrizMT();//Â¿quÃ© hace converMatrizMT() a partir de la concentraciÃ³n inicial??
        tabla = matrizPropagacion.getTabla();

        calculaAdj = new CalculaAdj(tabla);
        calculaAdj.ajusteIlrMT();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMT();
        tabla = calculaDFs.getTabla();

        //report results
        fileOutProp = webContentRoot + "PropReport.xls";
        reportPropagation = new ReportRobustness(tabla);
        // reportPropagation.reportPropagationMandMT(fileOutProp);        
        fileContent3 = this.showXLS(fileOutProp);

        //report summary  
        fileout = webContentRoot + "Report summary";
        reportResum = new ReportResum(tabla);
       // reportResum.repOnlyM(fileout);//después corregir 
        fileContent = showXLS(fileout);

        messProcessed();
    }

    @Command //
    @NotifyChange({"tabla", "fileContent", "fileContent2", "fileContent3", "fileContent4", "fileOutProp"})
    public void processPropagationMTtooM() throws IOException {
        processPropagationM();
        processPropagationMT();
    }*/

  

    /*public void procesaArchivoMT(String trans) throws IOException {
        grafm = true;
        grafmt = true;

        calculaAdj = new CalculaAdj(tabla);        
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);        
        calculaDFs.diagramM();       
        tabla = calculaDFs.getTabla();
        
        calculaAdj = new CalculaAdj(tabla);        
        calculaAdj.ajusteIlrMT();
        tabla = calculaAdj.getTabla();

        this.calculaDFs = new CalculaDFsDis(tabla);
        calculaDFs.diagramMT();
        tabla = calculaDFs.getTabla();
              
        fileprocess = true;//para habilitar menu de figuras
        reportesMT(tabla);

    }

   
    public void procesaArchivoM(String trans) throws IOException {
        grafm = true;
        //grafmt = true;

        calculaAdj = new CalculaAdj(tabla);        
        calculaAdj.ajusteIlrM();
        tabla = calculaAdj.getTabla();

        calculaDFs = new CalculaDFsDis(tabla);        
        calculaDFs.diagramM(); 
        tabla = calculaDFs.getTabla();
        
        fileprocess = true;//para habilitar menu de figuras
        reportesM(tabla);
    }

    
    public void reportesMT(ArrayList<ColumnasDis> tabla) throws IOException {
        fileout = webContentRoot + "Report_Resum";
        reportResum = new ReportResum(tabla);        
        reportResum.rep(fileout);
        showXLS(fileout);        

       reportResult = new ReportResult(tabla);        
       reportResult.reportMT(filePath);        
       fileContent3 = showXLSresult();
       
    }
public void reportesM(ArrayList<ColumnasDis> tabla) throws IOException {
        fileout = webContentRoot + "Report_Resum";
        reportResum = new ReportResum(tabla);        
        reportResum.repOnlyM(fileout);        
        showXLS(fileout);

        reportResult = new ReportResult(tabla);        
        reportResult.reportM(filePath);        
        fileContent3 = showXLSresult();
    }  */
    public  AMedia showFileOut(String archivoGuardar) throws IOException {
        File f = new File(archivoGuardar);
        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fs = new FileInputStream(f);
        fs.read(buffer);
        fs.close();
        ByteArrayInputStream is = new ByteArrayInputStream(buffer);
        AMedia fileContent = new AMedia(archivoGuardar, "xls", "application/xls", is);
        return fileContent;
    }
    public AMedia showXLS(String fileout) throws IOException {
        File f = new File(fileout);
        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fs = new FileInputStream(f);
        fs.read(buffer);
        fs.close();
        ByteArrayInputStream is = new ByteArrayInputStream(buffer);
        AMedia fileContent = new AMedia("SummaryOKKK", "xls", "application/xls", is);
        return fileContent;
    }
    public AMedia showXLSresultProp(String fileout) throws IOException {
        File f = new File(fileOutProp);
        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fs = new FileInputStream(f);
        fs.read(buffer);
        fs.close();
        ByteArrayInputStream is = new ByteArrayInputStream(buffer);
        AMedia fileContent = new AMedia("Propagation", "xls", "application/xls", is);
        return fileContent;
    }

    public AMedia showXLSresult(String nombre) throws IOException {
        File f = new File(filePath);//hace referencia al archivo de entrada

        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fs = new FileInputStream(f);
        fs.read(buffer);
        fs.close();
        ByteArrayInputStream is = new ByteArrayInputStream(buffer);
        AMedia fileContentx = new AMedia("Report_Result_"+nombre, "xls", "application/xls", is);
        return fileContentx;
    }

    public AMedia showing(String fileoutim) throws IOException {

        File f = new File(fileoutim);

        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fs = new FileInputStream(f);
        fs.read(buffer);
        fs.close();
        ByteArrayInputStream is = new ByteArrayInputStream(buffer);
        fileimagen = new AMedia(fileoutim, "jpeg", "application/jpeg", is);

        return fileimagen;
    }

    /*public AMedia showXLSprop(String fileout) throws IOException {
        File f = new File(fileout);
        //Messagebox.show("---showXLSprop f:"+f.getName()+f.getPath());
        byte[] buffer = new byte[(int) f.length()];
        FileInputStream fs = new FileInputStream(f);
        fs.read(buffer);
        fs.close();
        ByteArrayInputStream is = new ByteArrayInputStream(buffer);
        fileContent3 = new AMedia("Report_PROP", "xls", "application/xls", is);
        //Messagebox.show("showXLSprop: "+fileContent3);
        return fileContent3;        
    Â¨*/
}
