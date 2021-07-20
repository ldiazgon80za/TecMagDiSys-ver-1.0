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
public class Step10_MG21_22_23 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step10_MG21_22_23(Columnas r){
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
        r.setDf1_MG21_22_23Md((0.60995253330916144*ilr1_TiMd)+( -3.85096287439426810*ilr2_AlMd)+( -2.31448694317416590* ilr3_FeTMd)+( 1.78945505998306480*ilr4_MnMd)+( -1.37535744059224550*ilr5_MgMd)+( 0.52337046324005188*ilr6_CaMd)+( -1.80045430274307620*ilr7_NaMd)+( -0.60297936815414588*ilr8_KMd)+( -0.98534011453088555*ilr9_PMd)+( -5.36242198924960610));        
        r.setDf2_MG21_22_23Md((-1.60790651959672640*ilr1_TiMd)+( -2.85274507841955360*ilr2_AlMd)+( -3.36374704174481120* ilr3_FeTMd)+( -2.24526323994824840*ilr4_MnMd)+( -0.04737429114438130*ilr5_MgMd)+( -0.73242311192165543*ilr6_CaMd)+( -1.31490310236417040*ilr7_NaMd)+( -0.11559182184483527*ilr8_KMd)+( -0.83473413081346781*ilr9_PMd)+( 13.89640449211712300));
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_MG21_22_23Md();
        double df2=r.getDf2_MG21_22_23Md();        

        double x1 = df1 - (1.78878254051978480);
        double y1 = df2 - (-0.15692383881586203);
        double x2 = df1 - (0.25981147135219551);
        double y2 = df2 - (0.84628968026630425);
        double x3 = df1 - (-1.33234288657700710);
        double y3 = df2 - (-0.10661479399897722);
        double sG1 = Math.sqrt(x1 * x1 + y1 * y1);
        double sG2 = Math.sqrt(x2 * x2 + y2 * y2);
        double sG3 = Math.sqrt(x3 * x3 + y3 * y3);
        double g1 = Math.exp(-(sG1 * sG1) / 2.0);
        double g2 = Math.exp(-(sG2 * sG2) / 2.0);
        double g3 = Math.exp(-(sG3 * sG3) / 2.0);
        double sumG = g1 + g2 + g3;
        double p1=0,p2=0,p3=0;
        
        //guardar probas
        if (sumG == 0) { //P1_MG21M
            r.setP1_MG21M( 1.0 / 3.0);
            r.setP2_MG22M( 1.0 / 3.0);
            r.setP3_MG23M( 1.0 / 3.0);
        }else{
            r.setP1_MG21M(g1 / sumG);
            r.setP2_MG22M(g2 / sumG);
            r.setP3_MG23M(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
            
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MG21";
        else if((p2>p1)&&(p2>p3))
           res="MG22";
        else if((p3>p1)&&(p3>p2))
           res="MG23";        
   
        r.setDecision_MG21_22_23M(res);
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
        
        r.setDf1_MG21_22_23MTd((1.31776573024288360*ilr1_TiMTd) + (5.00535141072562430*ilr2_AlMTd) + (1.56561758359372920* ilr3_FeTMTd) + (-0.46215300567415196*ilr4_MnMTd) + (1.54089092662821470*ilr5_MgMTd) + (-0.77000072909483286*ilr6_CaMTd) + (1.88353241800821650*ilr7_NaMTd) + (0.65731244502710762*ilr8_KMTd) + (0.92240642500096814*ilr9_PMTd) + (-0.16390406786038755*ilr10_CrMTd) + (-0.74640734053155344*ilr11_NbMTd) + (0.01112597735706727* ilr12_NiMTd) + (-0.78292838497299777*ilr13_VMTd) + (-0.10209992878349197*ilr14_YMTd) + (0.72795798886650176*ilr15_ZrMTd) + (3.24952830923287820));
        r.setDf2_MG21_22_23MTd((-1.22024386287319750*ilr1_TiMTd) + (-2.39898328181830940*ilr2_AlMTd) + (-3.09853444999134500* ilr3_FeTMTd) + (0.67858974912253378*ilr4_MnMTd) + (0.31384916736246377*ilr5_MgMTd) + (2.11277730412069300*ilr6_CaMTd) + (-0.59667738682171911*ilr7_NaMTd) + (-0.77086383810714176*ilr8_KMTd) + (0.15039872371009155*ilr9_PMTd) + (0.01994189531363535*ilr10_CrMTd) + (-0.98988758269280064*ilr11_NbMTd) + (0.27896472109987963* ilr12_NiMTd) + (-0.04019791269051239*ilr13_VMTd) + (0.32796656121220275*ilr14_YMTd) + (2.81064790890209660*ilr15_ZrMTd) + (-3.12556210125662930));        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_MG21_22_23MTd();
        double df2=r.getDf2_MG21_22_23MTd();
        //COL 254
        
        double x1 = df1 - (-1.65292111177737850);
        double y1 = df2 - (-0.21665435035500913);
        double x2 = df1 - (0.33979853189019016);
        double y2 = df2 - (1.15337049490138280);
        double x3 = df1 - (2.10262917649879450);
        double y3 = df2 - (-0.33946711450469724);
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
            r.setP1_MG21MT( 1.0 / 3.0);
            r.setP2_MG22MT( 1.0 / 3.0);
            r.setP3_MG23MT( 1.0 / 3.0);
        }else {
            r.setP1_MG21MT(g1 / sumG);
            r.setP2_MG22MT(g2 / sumG);
            r.setP3_MG23MT(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
                    
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MG21";
        else if((p2>p1)&&(p2>p3))
           res="MG22";
        else if((p3>p1)&&(p3>p2))
           res="MG23";        
   
        r.setDecision_MG21_22_23MT(res);
        r.setResultMT(res);
    }    

   
}

