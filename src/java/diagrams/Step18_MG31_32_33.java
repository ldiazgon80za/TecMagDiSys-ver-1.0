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
public class Step18_MG31_32_33 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step18_MG31_32_33(Columnas r){
        this.r=r;
    }
    
    @Override
    public void  calculaDFsM(){
        double ilr1_TiMd = r.getIlrTiM();
        double ilr2_AlMd = r.getIlrAlM();
        double ilr3_FeTMd = r.getIlrFeTM();
        double ilr4_MnMd = r.getIlrMnM();
        double ilr5_MgMd = r.getIlrMgM();
        double ilr6_CaMd = r.getIlrCaM();
        double ilr7_NaMd = r.getIlrNaM();
        double ilr8_KMd = r.getIlrKM();
        double ilr9_PMd = r.getIlrPM();
        //calcular DF1 y DF2
        r.setDf1_MG31_32_33Md((9.01003568162628810*ilr1_TiMd) + ( 8.55560914302356320*ilr2_AlMd) + (2.26140104690051260* ilr3_FeTMd) + (-1.49713588682848480*ilr4_MnMd) + (-2.08806175327474940*ilr5_MgMd) + (1.41329675506384690*ilr6_CaMd) + (-6.32334865523756310*ilr7_NaMd) + (1.05246353809122040*ilr8_KMd) + (-2.68225061549970430*ilr9_PMd) + (-3.78328027528005340));        
        r.setDf2_MG31_32_33Md((-7.57298261020454430*ilr1_TiMd) + ( -0.36657451614887432*ilr2_AlMd) + (2.35589365816780780* ilr3_FeTMd) + (-1.18444298540000850*ilr4_MnMd) + (-2.78690448809858540*ilr5_MgMd) + (-6.07653478856326770*ilr6_CaMd) + (-3.75514625055158070*ilr7_NaMd) + (0.53112473527249360*ilr8_KMd) + (1.38706805059937750*ilr9_PMd) + (14.16827571389400100));
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_MG31_32_33Md();
        double df2=r.getDf2_MG31_32_33Md();        

        double x1 = df1 - (-0.11315937305301027);
        double y1 = df2 - (0.39098413990198111);
        double x2 = df1 - (-0.85615360025197962);
        double y2 = df2 - (-0.86739749819166789);
        double x3 = df1 - (2.83931627973403610);
        double y3 = df2 - (-0.52954976993610714);
        double sG1 = Math.sqrt(x1 * x1 + y1 * y1);
        double sG2 = Math.sqrt(x2 * x2 + y2 * y2);
        double sG3 = Math.sqrt(x3 * x3 + y3 * y3);
        double g1 = Math.exp(-(sG1 * sG1) / 2.0);
        double g2 = Math.exp(-(sG2 * sG2) / 2.0);
        double g3 = Math.exp(-(sG3 * sG3) / 2.0);
        double sumG = g1 + g2 + g3;
        double p1=0,p2=0,p3=0;
        
        //guardar probas
        if (sumG == 0) { //P1_MG31M
            r.setP1_MG31M( 1.0 / 3.0);
            r.setP2_MG32M( 1.0 / 3.0);
            r.setP3_MG33M( 1.0 / 3.0);
        }else{
            r.setP1_MG31M(g1 / sumG);
            r.setP2_MG32M(g2 / sumG);
            r.setP3_MG33M(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MG31";
        else if((p2>p1)&&(p2>p3))
           res="MORcOI";
        else if((p3>p1)&&(p3>p2))
           res="MORFZ";        
   
        r.setDecision_MG31_32_33M(res);
        r.setResultM(res);
    }
    
    //para MT
    @Override
    public void  calculaDFsMT(){  
        double ilr1_TiMTd = r.getIlrTiMT();
        double ilr2_AlMTd = r.getIlrAlMT();
        double ilr3_FeTMTd = r.getIlrFeTMT();
        double ilr4_MnMTd = r.getIlrMnMT();
        double ilr5_MgMTd = r.getIlrMgMT();
        double ilr6_CaMTd = r.getIlrCaMT();
        double ilr7_NaMTd = r.getIlrNaMT();
        double ilr8_KMTd = r.getIlrKMT();
        double ilr9_PMTd = r.getIlrPMT();
        double ilr10_CrMTd = r.getIlrCrMT();
        double ilr11_NbMTd = r.getIlrNbMT();
        double ilr12_NiMTd = r.getIlrNiMT();
        double ilr13_VMTd = r.getIlrVMT();
        double ilr14_YMTd = r.getIlrYMT();
        double ilr15_ZrMTd = r.getIlrZrMT();
        //calcular DF1 y DF2
        
        r.setDf1_MG31_32_33MTd((-6.71112555416518400 * ilr1_TiMTd) + (-6.05691471617013730 * ilr2_AlMTd) + (-4.78280069396068800 * ilr3_FeTMTd) + (2.03903504646831910 * ilr4_MnMTd) + (3.62585743538004120 * ilr5_MgMTd) + (-1.89511283906031740 * ilr6_CaMTd) + (5.01647192490744320 * ilr7_NaMTd) + (0.24702109390442856 * ilr8_KMTd) + (4.33531249544462400 * ilr9_PMTd) + (-0.45557039923676995 * ilr10_CrMTd) + (-0.84290175251359567 * ilr11_NbMTd) + (-0.63807155113630309 * ilr12_NiMTd) + (1.81400331551655890 * ilr13_VMTd) + (1.53980826241476750 * ilr14_YMTd) + (-3.92112774189082860 * ilr15_ZrMTd) + (2.62868410457877740));
        r.setDf2_MG31_32_33MTd((10.03487657864624300 * ilr1_TiMTd) + (-0.49840018544211312 * ilr2_AlMTd) + (-5.73532863476872730 * ilr3_FeTMTd) + (0.93831083135772042* ilr4_MnMTd) + (5.69141308771720490 * ilr5_MgMTd) + (1.77953697718657610 * ilr6_CaMTd) + (2.83019230945145010 * ilr7_NaMTd) + (-1.30047402928555300 * ilr8_KMTd) + (-1.88179263459510810 * ilr9_PMTd) + (-0.86401632984678201 * ilr10_CrMTd) + (-1.00287970910360260 * ilr11_NbMTd) + (-2.56456492390735180 * ilr12_NiMTd) + (-6.92431450494465480 * ilr13_VMTd) + (-0.88470481292827485 * ilr14_YMTd) + (0.96256493437656021 * ilr15_ZrMTd) + (25.79613327864064200));
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_MG31_32_33MTd();
        double df2=r.getDf2_MG31_32_33MTd();
               
        double x1 = df1 - (1.44113210625728700);
        double y1 = df2 - (-1.73456315232245470);
        double x2 = df1 - (1.41613230756712130);
        double y2 = df2 - (3.94457531334086300);
        double x3 = df1 - (-4.12489052405843810);
        double y3 = df2 - (-0.01561994365686914);
        
        double sG1 = Math.sqrt(x1 * x1 + y1 * y1);
        double sG2 = Math.sqrt(x2 * x2 + y2 * y2);
        double sG3 = Math.sqrt(x3 * x3 + y3 * y3);
        double g1 = Math.exp(-(sG1 * sG1) / 2.0);
        double g2 = Math.exp(-(sG2 * sG2) / 2.0);
        double g3 = Math.exp(-(sG3 * sG3) / 2.0);
        double sumG = g1 + g2 + g3;
        double p1=0,p2=0,p3=0;
        //asignar las probab
        if (sumG == 0) {
            r.setP1_MG31MT( 1.0 / 3.0);
            r.setP2_MG32MT( 1.0 / 3.0);
            r.setP3_MG33MT( 1.0 / 3.0);
        }else {
            r.setP1_MG31MT(g1 / sumG);
            r.setP2_MG32MT(g2 / sumG);
            r.setP3_MG33MT(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MG31";
        else if((p2>p1)&&(p2>p3))
           res="MORcOI";
        else if((p3>p1)&&(p3>p2))
           res="MORFZ";        
   
        r.setDecision_MG31_32_33MT(res);
        r.setResultMT(res);
    }  
}

