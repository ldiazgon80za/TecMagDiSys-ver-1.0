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
public class Step7_Gr121_122 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step7_Gr121_122(  Columnas r ){
        this.r=r;
    }    


        
    @Override
    public void  calculaDFsM(){                        
        //Columnas r = new Columnas();
        //r = getTabla().get(j);
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
        r.setDf0_Gr121_122Md((-0.53518489719459272*ilr1_TiMd)+(3.86978374741355280*ilr2_AlMd)+(4.81311828840615250* ilr3_FeTMd)+(-0.71012987683002338*ilr4_MnMd)+(-0.78161604708756416*ilr5_MgMd)+(-3.10626094323820160*ilr6_CaMd)+(1.04197317360594100*ilr7_NaMd)+(0.35902563073983462*ilr8_KMd)+( -1.52175558020140760*ilr9_PMd)+( 8.24889317486830720));                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_Gr121_122Md();
        
        double x1 = df0 - (-0.40115975397988635);
        double y1 = df0 - (1.00324284364318660);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        
        //guardar probas
        if (sumG == 0) { 
            r.setP1_Gr121M( 1.0 / 2.0);
            r.setP2_Gr122M( 1.0 / 2.0);
            
        }else{
            r.setP1_Gr121M(g1 / sumG);
            r.setP2_Gr122M(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        String res=null;
        if (p1>p2)
            res="Gr121";
        else if(p1<p2)
            res="Gr122";
        
         r.setDecision_Gr121_122M(res);
         r.setResultM(res);
    }
    
    //para MT
    @Override
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
        r.setDf0_Gr121_122MTd((-1.44715594018182280*ilr1_TiMTd) + (-3.00410622080604780*ilr2_AlMTd) + (-1.85233181091130760* ilr3_FeTMTd) + (-1.35650123883931210*ilr4_MnMTd) + (-0.22133253481887041*ilr5_MgMTd) + (2.48785359528244990*ilr6_CaMTd) + (-1.91829395337991330*ilr7_NaMTd) + (-0.80754936715097181*ilr8_KMTd) + (1.75101989607190080 *ilr9_PMTd) + (0.08642147062839621*ilr10_CrMTd) + (0.47446228895628162*ilr11_NbMTd) + (0.51834643703636496* ilr12_NiMTd) + (0.28333009586177760*ilr13_VMTd) + (0.47810315869575382*ilr14_YMTd) + (0.74404843086079397*ilr15_ZrMTd) + (-7.45805364060198350));
        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_Gr121_122MTd();
        
        double x1 = df0 - (0.51623724325624742);
        double y1 = df0 - (-1.24535582393777840);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_Gr121MT( 1.0 / 2.0);
            r.setP2_Gr122MT( 1.0 / 2.0);
            
        }else{
            r.setP1_Gr121MT(g1 / sumG);
            r.setP2_Gr122MT(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
        String res=null;
        if (p1>p2)
            res="Gr121";
        else if(p1<p2)
            res="Gr122";
        
         r.setDecision_Gr121_122MT(res);
         r.setResultMT(res);
    }    

   
}

