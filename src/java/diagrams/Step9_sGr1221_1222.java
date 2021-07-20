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
public class Step9_sGr1221_1222 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step9_sGr1221_1222(Columnas r){
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
        r.setDf0_sGr1221_1222Md((2.85562643073542200*ilr1_TiMd)+(5.59134539859330020*ilr2_AlMd)+(-4.21792757314288740* ilr3_FeTMd)+(1.07073645275239390*ilr4_MnMd)+(0.49119777655016844*ilr5_MgMd)+(-3.17661064603818000*ilr6_CaMd)+(-1.33148018618581410*ilr7_NaMd)+( 0.65972146510382057*ilr8_KMd)+( -0.49052230189939661*ilr9_PMd)+( -9.37286125445834980));                
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df0=r.getDf0_sGr1221_1222Md();
        
        double x1 = df0 - (-0.35165106869978757);
        double y1 = df0 - (0.71241226871308250);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr1221M( 1.0 / 2.0);
            r.setP2_sGr1222M( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr1221M(g1 / sumG);
            r.setP2_sGr1222M(g2 / sumG);            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        
        String res=null;
        if (p1>p2)
            res="IBA";
        else if(p1<p2)
            res="IBAB";
        
         r.setDecision_sGr1221_1222M(res);
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
        r.setDf0_sGr1221_1222MTd((-0.77934284945806576*ilr1_TiMTd) + (-2.14359387698523650*ilr2_AlMTd) + (-2.94277907630343090* ilr3_FeTMTd) + (2.44718059668245670*ilr4_MnMTd) + (-4.29030601726970500*ilr5_MgMTd) + (3.57105209942448760*ilr6_CaMTd) + (0.78054475946266100*ilr7_NaMTd) + (0.85972264045340818*ilr8_KMTd) + (0.93939114004343871 *ilr9_PMTd) + (0.01167768869244653*ilr10_CrMTd) + (-0.18629810782446127*ilr11_NbMTd) + (1.12723799360151620* ilr12_NiMTd) + (-1.80805252507221100*ilr13_VMTd) + (2.73273085907777210*ilr14_YMTd) + (-3.89539502879734730*ilr15_ZrMTd) + (-10.36911501027243600));
        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df0=r.getDf0_sGr1221_1222MTd();
        
        double x1 = df0 - (-0.45462078428568375);
        double y1 = df0 - (0.72133164439991759);
                
        double g1 = Math.exp(-(x1 * x1) / 2.0);
        double g2 = Math.exp(-(y1 * y1) / 2.0);
        
        double sumG = g1 + g2;
        double p1=0,p2=0;
        //guardar probas
        if (sumG == 0) { 
            r.setP1_sGr1221MT( 1.0 / 2.0);
            r.setP2_sGr1222MT( 1.0 / 2.0);
            
        }else{
            r.setP1_sGr1221MT(g1 / sumG);
            r.setP2_sGr1222MT(g2 / sumG);            
            p1=g1 / sumG;
            p2=g2 / sumG;
        }
        String res=null;
        if (p1>p2)
            res="IBA";
        else if(p1<p2)
            res="IBAB";
        
         r.setDecision_sGr1221_1222MT(res);
         r.setResultMT(res);        
    }  
}

