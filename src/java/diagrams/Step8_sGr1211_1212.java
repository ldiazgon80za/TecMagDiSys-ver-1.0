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
public class Step8_sGr1211_1212 extends Diagram2DFs{
   private Columnas r = new Columnas();    
    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step8_sGr1211_1212(Columnas r){
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
        r.setDf0_sGr1211_1212Md((2.63496122356909580*ilr1_TiMd)+(5.18904434967535890*ilr2_AlMd)+(2.46525516578519350* ilr3_FeTMd)+(-0.71484623526754165*ilr4_MnMd)+(-3.26567603887954140*ilr5_MgMd)+(-1.15177227155110210*ilr6_CaMd)+(-0.59547424109030056*ilr7_NaMd)+(-0.15571676986069546*ilr8_KMd)+( -0.50657837645773018*ilr9_PMd)+( 0.05561155176145372));                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_sGr1211_1212Md();
        
        double x1 = df0 - (-0.13250868249157133);
        double y1 = df0 - (1.90463795728682640);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr1211M( 1.0 / 2.0);
            r.setP2_sGr1212M( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr1211M(g1 / sumG);
            r.setP2_sGr1212M(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
                     
        String res=null;
        if (p1>p2)
            res="IA";
        else if(p1<p2)
            res="IAE";
        
         r.setDecision_sGr1211_1212M(res);
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
        r.setDf0_sGr1211_1212MTd((-2.79866766681143590*ilr1_TiMTd) + (-4.54405467978105190*ilr2_AlMTd) + (2.65880971198846530* ilr3_FeTMTd) + (-0.26793979691638520*ilr4_MnMTd) + (-1.43603404482812860*ilr5_MgMTd) + (3.19751606350067520*ilr6_CaMTd) + (1.25355795707046000*ilr7_NaMTd) + (-0.71417124710408542*ilr8_KMTd) + (0.13434268977062438 *ilr9_PMTd) + (0.14971252097642393*ilr10_CrMTd) + (1.44559454083407290*ilr11_NbMTd) + (0.95948575110805312* ilr12_NiMTd) + (0.14642031037506537*ilr13_VMTd) + (-0.12333478627315321*ilr14_YMTd) + (-0.42978082513282301*ilr15_ZrMTd) + (-8.89474585830162570));
        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_sGr1211_1212MTd();
        
        double x1 = df0 - (0.18018483257055884);
        double y1 = df0 - (-2.66228151494705220);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr1211MT( 1.0 / 2.0);
            r.setP2_sGr1212MT( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr1211MT(g1 / sumG);
            r.setP2_sGr1212MT(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
        String res=null;
        if (p1>p2)
            res="IA";
        else if(p1<p2)
            res="IAE";
        
         r.setDecision_sGr1211_1212MT(res);
         r.setResultMT(res);
         
    }   
}

