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
public class Step6_sGr1121_1122 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step6_sGr1121_1122(Columnas r){
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
        r.setDf0_sGr1121_1122Md((1.62359876908882960*ilr1_TiMd)+( -2.60334385395934210*ilr2_AlMd)+( -17.56641851026112600* ilr3_FeTMd)+( 5.79475488362940010*ilr4_MnMd)+( -0.69963162191894601*ilr5_MgMd)+( 2.27865320748276940*ilr6_CaMd)+( -9.88078942752585830*ilr7_NaMd)+( -0.37267462939655355*ilr8_KMd)+( -0.91016733896395252*ilr9_PMd)+( -21.26411805713227200));                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_sGr1121_1122Md();
        
        double x1 = df0 - (-2.81633835027382420);
        double y1 = df0 - (0.88649875432349035);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr1121M( 1.0 / 2.0);
            r.setP2_sGr1122M( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr1121M(g1 / sumG);
            r.setP2_sGr1122M(g2 / sumG);            
        
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
            
        String res=null;
        if (p1>p2)
            res="CARS";
        else if(p1<p2)
            res="CATCaRS";
        
         r.setDecision_sGr1121_1122M(res);
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
        r.setDf0_sGr1121_1122MTd((0.25805486111182346*ilr1_TiMTd) + (4.84934909445531750*ilr2_AlMTd) + (16.37186269840424300* ilr3_FeTMTd) + (-5.83215904654511070*ilr4_MnMTd) + (2.80713975566381270*ilr5_MgMTd) + (1.28330027143179760*ilr6_CaMTd) + (10.63914081888223400*ilr7_NaMTd) + (1.55372795347260720*ilr8_KMTd) + (1.49103643761813860 *ilr9_PMTd) + (-0.60764606426744372*ilr10_CrMTd) + (-1.24559869021154150 *ilr11_NbMTd) + (0.19493078274252468* ilr12_NiMTd) + (-3.51810592390344690*ilr13_VMTd) + (0.57339007437819023*ilr14_YMTd) + (0.55004510016712171*ilr15_ZrMTd) + (36.50795651191406700));
        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_sGr1121_1122MTd();
        
        double x1 = df0 - (4.74473264168819500);
        double y1 = df0 - (-0.52719251574310988);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr1121MT( 1.0 / 2.0);
            r.setP2_sGr1122MT( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr1121MT(g1 / sumG);
            r.setP2_sGr1122MT(g2 / sumG);            
        
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
        String res=null;
        if (p1>p2)
            res="CARS";
        else if(p1<p2)
            res="CATCaRS";
        
         r.setDecision_sGr1121_1122MT(res);
         r.setResultMT(res);

    } 
}

