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
public class Step17_sGr2321_2322 extends Diagram2DFs{
       private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step17_sGr2321_2322(Columnas r){
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
        //calcular DF0
        double r1_1=6.01417187667794;
        double r1_2=4.22928510336308;
        double r1_3=6.46959692631622;
        double r1_4=3.13859497596617;
        double r1_5=0.515421567365348;
        double r1_6=4.21940144351783;
        double r1_7=4.70812992196154;
        double r1_8=-0.450559246210112;
        double r1_9=-1.3124829451893;
        double r1_0=-20.2747665008043;

        r.setDf0_sGr2321_2322Md((r1_1*ilr1_TiMd)+(r1_2 *ilr2_AlMd)+( r1_3* ilr3_FeTMd)+( r1_4*ilr4_MnMd)+( r1_5*ilr5_MgMd)+( r1_6 *ilr6_CaMd)+( r1_7*ilr7_NaMd)+( r1_8 *ilr8_KMd)+( r1_9*ilr9_PMd)+(r1_0 ));        
        //r.setDf0_sGr2321_2322Md((-0.17768326437632989*ilr1_TiMd)+( -1.69370234327292590*ilr2_AlMd)+( 2.70567551496267630* ilr3_FeTMd)+( -0.42617419166090093*ilr4_MnMd)+( 0.25193314450598725*ilr5_MgMd)+( 1.63338340365976410*ilr6_CaMd)+( 4.58575572699658540*ilr7_NaMd)+( -1.47217023451165540*ilr8_KMd)+( -0.32263554314707704*ilr9_PMd)+( 2.90186276041534440));                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_sGr2321_2322Md();

        double x1 = df0 - (1.5823986996116020);
        double y1 = df0 - (-0.3027468912472067);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr2321M( 1.0 / 2.0);
            r.setP2_sGr2322M( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr2321M(g1 / sumG);
            r.setP2_sGr2322M(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
                
        String res=null;
        if (p1>p2)
            res="OIaMOR";
        else if(p1<p2)
            res="OIcMOR";
        
         r.setDecision_sGr2321_2322M(res);
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
        double r1_1=-5.05202023067999;
        double r1_2=-5.64358706673366;
        double r1_3=-10.5339474707257;
        double r1_4=-6.20430897450166;
        double r1_5=-0.604026438684626;
        double r1_6=-6.08899988194585;
        double r1_7=-3.01624749661377;
        double r1_8=-1.00280107745616;
        double r1_9=2.537908037273;
        double r1_10=-0.591913390315199;
        double r1_11=0.135816079024746;
        double r1_12=-0.533828178665483;
        double r1_13=-1.95713128837263;
        double r1_14=-0.174842074780309;
        double r1_15=-4.11349576660643;
        double r1_0=52.1308744856325;

         r.setDf0_sGr2321_2322MTd((r1_1 *ilr1_TiMTd) + (r1_2*ilr2_AlMTd) + (r1_3* ilr3_FeTMTd) + (r1_4*ilr4_MnMTd) + 	
                (r1_5*ilr5_MgMTd) + (r1_6*ilr6_CaMTd) + (r1_7*ilr7_NaMTd) + (r1_8*ilr8_KMTd) + (r1_9*ilr9_PMTd) + 	
                (r1_10*ilr10_CrMTd) + (r1_11*ilr11_NbMTd) + (r1_12* ilr12_NiMTd) + (r1_13*ilr13_VMTd) + (r1_14*ilr14_YMTd) + 	
                (r1_15*ilr15_ZrMTd) + (r1_0));	
        //r.setDf0_sGr2321_2322MTd((2.27167080200610630*ilr1_TiMTd) + (-0.22921639563391957*ilr2_AlMTd) + (-9.94378791886424020* ilr3_FeTMTd) + (-1.08782967370293850*ilr4_MnMTd) + (-0.46800397347245742*ilr5_MgMTd) + (-3.23777501281111360*ilr6_CaMTd) + (-2.57957209223161190*ilr7_NaMTd) + (-0.22614430813371550*ilr8_KMTd) + (0.48966804302893208*ilr9_PMTd) + (-0.22009109873215871*ilr10_CrMTd) + (0.31451053946251251*ilr11_NbMTd) + (-0.09177212039927105* ilr12_NiMTd) + (-1.76106099119898010*ilr13_VMTd) + (0.54753278043191878*ilr14_YMTd) + (-3.47676788890009410*ilr15_ZrMTd) + (12.16644123022398800));       
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_sGr2321_2322MTd();
        
        double x1 = df0 - (-2.34248779120);
        double y1 = df0 - (0.43921646085);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr2321MT( 1.0 / 2.0);
            r.setP2_sGr2322MT( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr2321MT(g1 / sumG);
            r.setP2_sGr2322MT(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
       String res=null;
        if (p1>p2)
            res="OIaMOR";
        else if(p1<p2)
            res="OIcMOR";
        
         r.setDecision_sGr2321_2322MT(res);
         r.setResultMT(res);     
    }    

   
}

