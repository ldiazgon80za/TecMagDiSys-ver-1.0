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
public class Step16_ssGr23121_23122 extends Diagram2DFs{
   private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step16_ssGr23121_23122(Columnas r){
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
        double r1_1=0.532439193797197;
        double r1_2=-0.819489504725901;
        double r1_3=2.42385955855334;
        double r1_4=1.85944633071959;
        double r1_5=1.57954066319992;
        double r1_6=2.53643176802791;
        double r1_7=3.08715168828152;
        double r1_8=2.72124461125812;
        double r1_9=0.330967963542706;
        double r1_0=-12.9404327891482;
        
        r.setDf0_sGr23121_23122Md((r1_1*ilr1_TiMd)+(r1_2 *ilr2_AlMd)+( r1_3* ilr3_FeTMd)+( r1_4*ilr4_MnMd)+( r1_5*ilr5_MgMd)+( r1_6 *ilr6_CaMd)+( r1_7*ilr7_NaMd)+( r1_8 *ilr8_KMd)+( r1_9*ilr9_PMd)+(r1_0 ));        

        //r.setDf0_sGr23121_23122Md((-0.99634458505708590*ilr1_TiMd)+( 0.53612685923228587*ilr2_AlMd)+( 0.04996874543739850* ilr3_FeTMd)+( -5.12844943368565610*ilr4_MnMd)+( -0.53612523862126515*ilr5_MgMd)+( -3.13820942875037990*ilr6_CaMd)+( 0.15217284324436489*ilr7_NaMd)+( -1.89901340044216220*ilr8_KMd)+( -0.23650938799062438*ilr9_PMd)+( 22.95901174176539100) );                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_sGr23121_23122Md();
        
        double x1 = df0 - (1.4830230984110333);
        double y1 = df0 - (-2.4494875895103565);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr23121M( 1.0 / 2.0);
            r.setP2_sGr23122M( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr23121M(g1 / sumG);
            r.setP2_sGr23122M(g2 / sumG);  
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
             
        String res=null;
        if (p1>p2)
            res="OIaOP";
        else if(p1<p2)
            res="OP";
        
         r.setDecision_sGr23121_23122M(res);
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
        double r1_1=-4.48092554889874;
        double r1_2=-9.11467605325032;
        double r1_3=-0.68101961969711;
        double r1_4=-5.61114004968818;
        double r1_5=1.15806945090019;
        double r1_6=3.86954017332412;
        double r1_7=4.97882017524827;
        double r1_8=-0.992757026858162;
        double r1_9=2.70258069402005;
        double r1_10=-1.93472549028351;
        double r1_11=-0.239670035535114;
        double r1_12=-0.257661403634935;
        double r1_13=-1.76182666073545;
        double r1_14=-10.4867581675817;
        double r1_15=0.487674201878449;
        double r1_0=96.9120177741821;
        
        r.setDf0_sGr23121_23122MTd((r1_1 *ilr1_TiMTd) + (r1_2*ilr2_AlMTd) + (r1_3* ilr3_FeTMTd) + (r1_4*ilr4_MnMTd) + 		
                (r1_5*ilr5_MgMTd) + (r1_6*ilr6_CaMTd) + (r1_7*ilr7_NaMTd) + (r1_8*ilr8_KMTd) + (r1_9*ilr9_PMTd) + 		
                (r1_10*ilr10_CrMTd) + (r1_11*ilr11_NbMTd) + (r1_12* ilr12_NiMTd) + (r1_13*ilr13_VMTd) + (r1_14*ilr14_YMTd) + 		
                (r1_15*ilr15_ZrMTd) + (r1_0));	

        //r.setDf0_sGr23121_23122MTd((-1.24339152720066440*ilr1_TiMTd) + (4.28488128772126940*ilr2_AlMTd) + (2.78888446102596130* ilr3_FeTMTd) + (-6.70324706901088430*ilr4_MnMTd) + (1.48075808545224330*ilr5_MgMTd) + (-2.38423935703985410*ilr6_CaMTd) + (-1.59238539666594250*ilr7_NaMTd) + (-1.28079270884350360*ilr8_KMTd) + (-0.29556128270821108*ilr9_PMTd) + (1.35316430968833320*ilr10_CrMTd) + (1.29162371361563720*ilr11_NbMTd) + (-0.22992173487050757* ilr12_NiMTd) + (1.52210691034489610*ilr13_VMTd) + (4.49793570516402760*ilr14_YMTd) + (1.47004244819391580*ilr15_ZrMTd) + (-15.63359774188211300) );        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_sGr23121_23122MTd();
        
        double x1 = df0 - (2.1325179739060758);
        double y1 = df0 - (-4.9758752724474817);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr23121MT( 1.0 / 2.0);
            r.setP2_sGr23122MT( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr23121MT(g1 / sumG);
            r.setP2_sGr23122MT(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
       String res=null;
        if (p1>p2)
            res="OIaOP";
        else if(p1<p2)
            res="OP";
        
         r.setDecision_sGr23121_23122MT(res);
         r.setResultMT(res);     
    }    

   
}

