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
public class Step15_ssGr23111_23112 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step15_ssGr23111_23112(Columnas r){
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
        double r1_1=-4.54709271044885;
        double r1_2=-11.6221492402359;
        double r1_3=0.696399304722751;
        double r1_4=-1.6877044343896;
        double r1_5=-3.43375486224927;
        double r1_6=-0.0329548832193889;
        double r1_7=-3.70614615248276;
        double r1_8=-0.649644832921136;
        double r1_9=1.87735600010959;
        double r1_0=12.4192554231468;

         r.setDf0_sGr23111_23112Md((r1_1*ilr1_TiMd)+(r1_2 *ilr2_AlMd)+( r1_3* ilr3_FeTMd)+( r1_4*ilr4_MnMd)+( r1_5*ilr5_MgMd)+( r1_6 *ilr6_CaMd)+( r1_7*ilr7_NaMd)+( r1_8 *ilr8_KMd)+( r1_9*ilr9_PMd)+(r1_0 ));        
        //r.setDf0_sGr23111_23112Md((2.87437669471470380*ilr1_TiMd)+( 8.21338583084254740*ilr2_AlMd)+( 2.29427553696666120 * ilr3_FeTMd)+( -0.91835272366029130*ilr4_MnMd)+( 2.80475375290122250*ilr5_MgMd)+( 0.66918563654133434*ilr6_CaMd)+( 2.32394345871083270*ilr7_NaMd)+( 0.41592384353346989*ilr8_KMd)+( -0.24535466554785912*ilr9_PMd)+( -1.59629163573390050));                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_sGr23111_23112Md();
        
        double x1 = df0 - (-0.0874116704461620);
        double y1 = df0 - (2.2803044464214679);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr23111M( 1.0 / 2.0);
            r.setP2_sGr23112M( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr23111M(g1 / sumG);
            r.setP2_sGr23112M(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        String res=null;
        if (p1>p2)
            res="OI";
        else if(p1<p2)
            res="OIcC";
        
         r.setDecision_sGr23111_23112M(res);
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
        //calcular DF0
        double r1_1=36.248345848571;
        double r1_2=115.239921778746;
        double r1_3=15.3572480647013;
        double r1_4=-7.13924879565686;
        double r1_5=1.47945159113507;
        double r1_6=-21.1969353928428;
        double r1_7=3.35900914176711;
        double r1_8=3.40609900484514;
        double r1_9=9.9318510878911;
        double r1_10=1.56550494142126;
        double r1_11=6.82365086134332;
        double r1_12=-2.30704165479738;
        double r1_13=-11.5264924845555;
        double r1_14=1.66050163304756;
        double r1_15=-21.4493000704108;
        double r1_0=-25.5927575956224;
 
        r.setDf0_sGr23111_23112MTd((r1_1 *ilr1_TiMTd) + (r1_2*ilr2_AlMTd) + (r1_3* ilr3_FeTMTd) + (r1_4*ilr4_MnMTd) + 		
                (r1_5*ilr5_MgMTd) + (r1_6*ilr6_CaMTd) + (r1_7*ilr7_NaMTd) + (r1_8*ilr8_KMTd) + (r1_9*ilr9_PMTd) + 		
                (r1_10*ilr10_CrMTd) + (r1_11*ilr11_NbMTd) + (r1_12* ilr12_NiMTd) + (r1_13*ilr13_VMTd) + (r1_14*ilr14_YMTd) + 		
                (r1_15*ilr15_ZrMTd) + (r1_0));		

        //r.setDf0_sGr23111_23112MTd((2.33281655810343970*ilr1_TiMTd) + (4.19015627811059590*ilr2_AlMTd) + (0.94301408408876386* ilr3_FeTMTd) + (0.06298919314764520*ilr4_MnMTd) + (1.88283577064910680*ilr5_MgMTd) + (-1.30456337411974730*ilr6_CaMTd) + (2.66523183067633610*ilr7_NaMTd) + (0.70414930062579817*ilr8_KMTd) + (-0.12360771713133781*ilr9_PMTd) + (0.10789819559787088*ilr10_CrMTd) + (-0.55412873570642118*ilr11_NbMTd) + (-0.65006181031395494* ilr12_NiMTd) + (-0.02020909478515353*ilr13_VMTd) + (-0.15136871143970698*ilr14_YMTd) + (-1.95837505558602350*ilr15_ZrMTd) + (5.50089631083805840) );
        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_sGr23111_23112MTd();
        
        double x1 = df0 - (5.6579005940728564);
        double y1 = df0 - (-29.3061569833623850);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr23111MT( 1.0 / 2.0);
            r.setP2_sGr23112MT( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr23111MT(g1 / sumG);
            r.setP2_sGr23112MT(g2 / sumG);            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
        String res=null;
        if (p1>p2)
            res="OI";
        else if(p1<p2)
            res="OIcC";
        
         r.setDecision_sGr23111_23112MT(res);
         r.setResultMT(res);     
    }    

   
}

