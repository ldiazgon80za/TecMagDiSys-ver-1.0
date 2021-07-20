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
public class Step14_sGr2311_2312 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step14_sGr2311_2312(Columnas r){
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
        double r1_1=0.10360055065046;
        double r1_2=0.88179885584747;
        double r1_3=-4.86058216150311;
        double r1_4=-1.52082519971049;
        double r1_5=1.71705891640669;
        double r1_6=1.22306429018703;
        double r1_7=-0.233099633468712;
        double r1_8=-1.95802037348728;
        double r1_9=2.17086481698267;
        double r1_0=5.62166080030086;
System.out.println("----DF0_sGr2311_2312: "+(r1_1*ilr1_TiMd)+(r1_2 *ilr2_AlMd)+( r1_3* ilr3_FeTMd)+( r1_4*ilr4_MnMd)+( r1_5*ilr5_MgMd)+( r1_6 *ilr6_CaMd)+( r1_7*ilr7_NaMd)+( r1_8 *ilr8_KMd)+( r1_9*ilr9_PMd)+(r1_0 ));
        r.setDf0_sGr2311_2312Md((r1_1*ilr1_TiMd)+(r1_2 *ilr2_AlMd)+( r1_3* ilr3_FeTMd)+( r1_4*ilr4_MnMd)+( r1_5*ilr5_MgMd)+( r1_6 *ilr6_CaMd)+( r1_7*ilr7_NaMd)+( r1_8 *ilr8_KMd)+( r1_9*ilr9_PMd)+(r1_0 ));        
        //r.setDf0_sGr2311_2312Md((0.19023479773632762*ilr1_TiMd)+( 1.56274816579763560*ilr2_AlMd)+( -3.87482732029951340* ilr3_FeTMd)+( 0.55394235934325120*ilr4_MnMd)+( 1.05552901813235840*ilr5_MgMd)+( -2.21952723899536200*ilr6_CaMd)+( 0.41795484679370615*ilr7_NaMd)+( -1.99414095781688560*ilr8_KMd)+( 1.89682757074600890*ilr9_PMd)+( -4.18442863877775920) );                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_sGr2311_2312Md();
        
        double x1 = df0 - (-0.113522215133885);
        double y1 = df0 - (1.7980764414003);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr2311M( 1.0 / 2.0);
            r.setP2_sGr2312M( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr2311M(g1 / sumG);
            r.setP2_sGr2312M(g2 / sumG);   
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
        String res=null;
        if (p1>p2)
            res="sGr2311";
        else if(p2>p1)
            res="sGr2312";
        
         r.setDecision_sGr2311_2312M(res);
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
        
        double r1_1=-11.9995549161574;
        double r1_2=-11.5931416208026;
        double r1_3=-22.9085139304387;
        double r1_4=2.10899247400017;
        double r1_5=-4.83689380580189;
        double r1_6=-0.71605374753581;
        double r1_7=1.06678225383334;
        double r1_8=-7.49704873228217;
        double r1_9=4.26824626059449;
        double r1_10=-0.173081514537871;
        double r1_11=1.32955451311616;
        double r1_12=-1.26980248231482;
        double r1_13=-6.86801959601551;
        double r1_14=-8.19493833297865;
        double r1_15=-4.89425913945139;
        double r1_0=95.5180510342501;

         r.setDf0_sGr2311_2312MTd((r1_1 *ilr1_TiMTd) + (r1_2*ilr2_AlMTd) + (r1_3* ilr3_FeTMTd) + (r1_4*ilr4_MnMTd) + 	
                        (r1_5*ilr5_MgMTd) + (r1_6*ilr6_CaMTd) + (r1_7*ilr7_NaMTd) + (r1_8*ilr8_KMTd) + (r1_9*ilr9_PMTd) + 	
                (r1_10*ilr10_CrMTd) + (r1_11*ilr11_NbMTd) + (r1_12* ilr12_NiMTd) + (r1_13*ilr13_VMTd) + (r1_14*ilr14_YMTd) + 	
                (r1_15*ilr15_ZrMTd) + (r1_0));	

        //r.setDf0_sGr2311_2312MTd((-1.34652569304102410*ilr1_TiMTd) + (-2.50385133074865160*ilr2_AlMTd) + (8.26875168480296980* ilr3_FeTMTd) + (-3.42378027041749930*ilr4_MnMTd) + (0.57806003518726734*ilr5_MgMTd) + (0.02113642817243653*ilr6_CaMTd) + (0.48681985926944787*ilr7_NaMTd) + (1.77258634009899270*ilr8_KMTd) + (-1.98310856661258430*ilr9_PMTd) + (-0.48517943077490799*ilr10_CrMTd) + (-0.23130237044882332*ilr11_NbMTd) + (-0.02341887907278683* ilr12_NiMTd) + (0.60197017403543973*ilr13_VMTd) + (0.43317041681103663*ilr14_YMTd) + (0.92078634706752693*ilr15_ZrMTd) + (13.56022029793980400) );
        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_sGr2311_2312MTd();
        double x1 = df0 - (-0.7375341448397279);
        double y1 = df0 - (3.8892633904547296);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr2311MT( 1.0 / 2.0);
            r.setP2_sGr2312MT( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr2311MT(g1 / sumG);
            r.setP2_sGr2312MT(g2 / sumG);            
            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
        String res=null;
        if (p1>p2)
            res="sGr2311";
        else if(p1<p2)
            res="sGr2312";
        
         r.setDecision_sGr2311_2312MT(res);
         r.setResultMT(res);     
    }    

   
}

