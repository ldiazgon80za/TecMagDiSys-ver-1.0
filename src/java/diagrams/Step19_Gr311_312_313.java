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
public class Step19_Gr311_312_313 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step19_Gr311_312_313(  Columnas r ){
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
        
        r.setDf1_Gr311_312_313Md((-9.76443653395580920*ilr1_TiMd) + ( -6.84617045542853210*ilr2_AlMd) + (5.30292287193234820* ilr3_FeTMd) + (1.05465582961201810*ilr4_MnMd) + (-0.44679221084748005*ilr5_MgMd) + (-0.14094127714002339*ilr6_CaMd) + (5.71363817039252630*ilr7_NaMd) + (1.14607523726141540*ilr8_KMd) + (-1.09103368271981900*ilr9_PMd) + (12.29195006547052100));        
        r.setDf2_Gr311_312_313Md((24.32630457107928000*ilr1_TiMd) + ( 14.26004985042870000*ilr2_AlMd) + (16.56799340968449700* ilr3_FeTMd) + (5.24920310469788200*ilr4_MnMd) + (6.66197152939800840*ilr5_MgMd) + (19.26617448691340700*ilr6_CaMd) + (6.03943456501803230*ilr7_NaMd) + (0.45944807336154503*ilr8_KMd) + (-1.04576301086283330*ilr9_PMd) + (-57.26393790064489100));
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_Gr311_312_313Md();
        double df2=r.getDf2_Gr311_312_313Md();        

        double x1 = df1 - (-0.51861455405930279);        
        double y1 = df2 - (0.28294949549818682);        
        double x2 = df1 - (1.27818138162172620);        
        double y2 = df2 - (-0.10784739850097935);        
        double x3 = df1 - (-0.93425169146090425);
        double y3 = df2 - (-1.92752070276494440);
        double sG1 = Math.sqrt(x1 * x1 + y1 * y1);
        double sG2 = Math.sqrt(x2 * x2 + y2 * y2);
        double sG3 = Math.sqrt(x3 * x3 + y3 * y3);
        double g1 = Math.exp(-(sG1 * sG1) / 2.0);
        double g2 = Math.exp(-(sG2 * sG2) / 2.0);
        double g3 = Math.exp(-(sG3 * sG3) / 2.0);
        double sumG = g1 + g2 + g3;
        double p1=0,p2=0,p3=0; 
        //guardar probas
        if (sumG == 0) { //P1_MG11M
            r.setP1_Gr311M( 1.0 / 3.0);
            r.setP2_Gr312M( 1.0 / 3.0);
            r.setP3_Gr313M( 1.0 / 3.0);
        }else{
            r.setP1_Gr311M(g1 / sumG);
            r.setP2_Gr312M(g2 / sumG);
            r.setP3_Gr313M(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MOR";
        else if((p2>p1)&&(p2>p3))
           res="MORo";
        else if((p3>p1)&&(p3>p2))
           res="MORS";        
   
        r.setDecision_Gr311_312_313M(res);
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
        
        r.setDf1_Gr311_312_313MTd((5.97562752892286310 * ilr1_TiMTd) + (6.57141687658692230 * ilr2_AlMTd) + (-8.23962612763490650 * ilr3_FeTMTd) + (-0.41480845301674241 * ilr4_MnMTd) + (2.90201946159769620 * ilr5_MgMTd) + (-1.85145299624104860 * ilr6_CaMTd) + (-2.93379451209392440 * ilr7_NaMTd) + (-0.43734707959993446 * ilr8_KMTd) + (1.40602477463019100 * ilr9_PMTd) + (-0.32099271287853115 * ilr10_CrMTd) + (-0.16963614714439904 * ilr11_NbMTd) + (-3.08854811337935950 * ilr12_NiMTd) + (-7.33744036752498550 * ilr13_VMTd) + (12.50751592243640400 * ilr14_YMTd) + (-7.09570604747810220 * ilr15_ZrMTd) + (-9.59398465844147450));

        r.setDf2_Gr311_312_313MTd((14.99108364614473400 * ilr1_TiMTd) + (17.85280395636491600 * ilr2_AlMTd) + (9.08778738920207550 * ilr3_FeTMTd) + (-1.51227125521018780 * ilr4_MnMTd) + (4.40267460547706780 * ilr5_MgMTd) + (-9.88600284241034720 * ilr6_CaMTd) + (0.17932277204106542 * ilr7_NaMTd) + (-0.60261664063459219 * ilr8_KMTd) + (-1.70050792193707000 * ilr9_PMTd) + (1.97225725641080900 * ilr10_CrMTd) + (-0.18454276437215930 * ilr11_NbMTd) + (-5.42140522387826170 * ilr12_NiMTd) + (-0.23508958876536409 * ilr13_VMTd) + (-2.05107578199051720 * ilr14_YMTd) + (-1.48859695545602460 * ilr15_ZrMTd) + (10.93337333153852800));
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_Gr311_312_313MTd();
        double df2=r.getDf2_Gr311_312_313MTd();

        double x1 = df1 - (0.87174359459799078);        
        double y1 = df2 - (0.85426134151597743);        
        double x2 = df1 - (-4.70182170025018560);        
        double y2 = df2 - (0.52198536265977502);        
        double x3 = df1 - (0.25635057927796367);        
        double y3 = df2 - (-2.95473728709602490);
        double sG1 = Math.sqrt(x1 * x1 + y1 * y1);
        double sG2 = Math.sqrt(x2 * x2 + y2 * y2);
        double sG3 = Math.sqrt(x3 * x3 + y3 * y3);
        double g1 = Math.exp(-(sG1 * sG1) / 2.0);
        double g2 = Math.exp(-(sG2 * sG2) / 2.0);
        double g3 = Math.exp(-(sG3 * sG3) / 2.0);
        double sumG = g1 + g2 + g3;
        double p1=0,p2=0,p3=0; 
        //asignar las probab
        if (sumG == 0) { //P1_MG11M
            r.setP1_Gr311MT(1.0 / 3.0);
            r.setP2_Gr312MT(1.0 / 3.0);
            r.setP3_Gr313MT(1.0 / 3.0);
        }else{
            r.setP1_Gr311MT(g1 / sumG);
            r.setP2_Gr312MT(g2 / sumG);
            r.setP3_Gr313MT(g3 / sumG);
           
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MOR";
        else if((p2>p1)&&(p2>p3))
           res="MORo";
        else if((p3>p1)&&(p3>p2))
           res="MORS";        
   
        r.setDecision_Gr311_312_313MT(res);
        r.setResultMT(res);
    }      
}

