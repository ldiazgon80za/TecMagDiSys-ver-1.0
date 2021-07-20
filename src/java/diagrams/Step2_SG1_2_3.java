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

public class Step2_SG1_2_3 extends Diagram2DFs{    
    
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step2_SG1_2_3(  Columnas r ){
        this.r=r;
    }
    public void  calculaDFsM() {   
        
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
        r.setDf1_SG1_2_3Md((ilr1_TiMd * (-1.82934916639097910)) + (ilr2_AlMd * (1.24164544044592360)) + (ilr3_FeTMd * (2.72637137859525640)) + (ilr4_MnMd * (0.66477645052824108)) + (ilr5_MgMd * (-0.58742600119829691)) + (ilr6_CaMd * (2.16395071869641910)) + (ilr7_NaMd * (1.32484193341307010)) + (ilr8_KMd * (-0.30441032440236615)) + (ilr9_PMd * (0.15008795993366544)) + (3.48099157766325360));        
        r.setDf2_SG1_2_3Md((ilr1_TiMd * (-0.47628650968430242)) + (ilr2_AlMd * (-1.31345784690815080)) + (ilr3_FeTMd * (-1.55836344523765960)) + (ilr4_MnMd * (-0.62928436346671901)) + (ilr5_MgMd * (-0.25132736896471997)) + (ilr6_CaMd * (1.53065066965345480)) + (ilr7_NaMd * (0.82246673413329674)) + (ilr8_KMd * (-1.54002190233678000)) + (ilr9_PMd * (0.60445499261745228)) + (4.50434087374618390));        
        calculaProbabilitiesM();//calcular las probabilidades        
    }    
    
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_SG1_2_3Md();
        double df2=r.getDf2_SG1_2_3Md();        

        double x1 = df1 - (-1.15912301006207);
        double y1 = df2 - (0.467485211189294);
        double x2 = df1 - (1.06128355896314);
        double y2 = df2 - (0.208234527721014);
        double x3 = df1 - (-0.382593072129282); 
        double y3 = df2 - (-2.2499237591285);
        double sG1 = Math.sqrt(x1 * x1 + y1 * y1);
        double sG2 = Math.sqrt(x2 * x2 + y2 * y2);
        double sG3 = Math.sqrt(x3 * x3 + y3 * y3);
        double g1 = Math.exp(-(sG1 * sG1) / 2.0);
        double g2 = Math.exp(-(sG2 * sG2) / 2.0);
        double g3 = Math.exp(-(sG3 * sG3) / 2.0);
        double sumG = g1 + g2 + g3;
        double p1=0,p2=0,p3=0;
        //guardar probas
        if (sumG == 0) {
            r.setP1_SG1M( 1.0 / 3.0);
            r.setP2_SG2M( 1.0 / 3.0);
            r.setP3_SG3M( 1.0 / 3.0);
        }else{
            r.setP1_SG1M(g1 / sumG);
            r.setP2_SG2M(g2 / sumG);
            r.setP3_SG3M(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
      
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="SG1";
        else if((p2>p1)&&(p2>p3))
           res="SG2";
        else if((p3>p1)&&(p3>p2))
           res="SG3";        
   
        r.setDecision_SG1_2_3M(res);
        r.setResultM(res);
    }
    
    //para MT
    public void  calculaDFsMT(){                        
        //Columnas r = new Columnas();
        //r = getTabla().get(j);
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
        r.setDf1_SG1_2_3MTd((1.10529278913281900*ilr1_TiMTd) + (-0.40272077753940094*ilr2_AlMTd) + (-1.71542282911944670* ilr3_FeTMTd) + (-1.17550928807050050*ilr4_MnMTd) + (-0.21305682659244507*ilr5_MgMTd) + (-0.60225333223867883*ilr6_CaMTd) + (-1.69302487633849320*ilr7_NaMTd) + (-0.06917975678417430*ilr8_KMTd) + (-0.24271925455021851*ilr9_PMTd) + (-0.10660120063214959*ilr10_CrMTd) + (0.76584698936932871*ilr11_NbMTd) + (0.46403498946516858* ilr12_NiMTd) + (-0.62700943233021600*ilr13_VMTd) + (-0.02298557620619171*ilr14_YMTd) + (0.08872084799160550*ilr15_ZrMTd) + (-3.17113203044346690));
        r.setDf2_SG1_2_3MTd((-1.62584738370188900*ilr1_TiMTd) + (-0.30789086371283797*ilr2_AlMTd) + (0.20214279859247958* ilr3_FeTMTd) + (-0.74358871329139431*ilr4_MnMTd) + (0.55421457593932988*ilr5_MgMTd) + (1.04413429792013960*ilr6_CaMTd) + (1.18910936814039530*ilr7_NaMTd) + (-1.50488201708347690*ilr8_KMTd) + (1.17184245420789380*ilr9_PMTd) + (0.42131853773375960*ilr10_CrMTd) + (0.36559402984838063*ilr11_NbMTd) + (0.35347409797612334* ilr12_NiMTd) + (0.87477012814262867*ilr13_VMTd) + (1.84962349223316740*ilr14_YMTd) + (0.90768676165702056*ilr15_ZrMTd) + (-15.53548310883102700));        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
    
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_SG1_2_3MTd();
        double df2=r.getDf2_SG1_2_3MTd();
        
        double x1 = df1 - (1.33382403605492210);
        double y1 = df2 - (0.54119134169190986);
        double x2 = df1 - (-1.47357360653566110);
        double y2 = df2 - (0.19756810014719051);
        double x3 = df1 - (0.59036808613487324);
        double y3 = df2 - (-3.61635904510949220);
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
            r.setP1_SG1MT( 1.0 / 3.0);
            r.setP2_SG2MT( 1.0 / 3.0);
            r.setP3_SG3MT( 1.0 / 3.0);
        }else {
            r.setP1_SG1MT(g1 / sumG);
            r.setP2_SG2MT(g2 / sumG);
            r.setP3_SG3MT(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="SG1";
        else if((p2>p1)&&(p2>p3))
           res="SG2";
        else if((p3>p1)&&(p3>p2))
           res="SG3";        
   
        r.setDecision_SG1_2_3MT(res);
        r.setResultMT(res);
    }
       
}
  