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
public class Step4_Gr111_112_113 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step4_Gr111_112_113(  Columnas r ){
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
        double r1_1=4.63679905364958;
        double r1_2=3.38961726099819;
        double r1_3=-3.09806901666695;
        double r1_4=3.73311322096105;
        double r1_5=-0.820734364975859;
        double r1_6=-1.33276345790339;
        double r1_7=-1.21819547139673;
        double r1_8=0.0200247511586991;
        double r1_9=-1.13683357086198;
        double r1_0=-22.0854010640027;

        double r2_1=1.38117946880395;
        double r2_2=-1.33924625274856;
        double r2_3=-0.0225171513355092;
        double r2_4=1.13903430312893;
        double r2_5=1.47827912136938;
        double r2_6=1.31016283708318;
        double r2_7=-1.23958188321191;
        double r2_8=1.83526869109553;
        double r2_9=-1.07101146551618;
        double r2_0=-7.7679644208612;

        r.setDf1_Gr111_112_113Md((r1_1*ilr1_TiMd)+(r1_2 *ilr2_AlMd)+( r1_3* ilr3_FeTMd)+( r1_4*ilr4_MnMd)+( r1_5*ilr5_MgMd)+( r1_6 *ilr6_CaMd)+( r1_7*ilr7_NaMd)+( r1_8 *ilr8_KMd)+( r1_9*ilr9_PMd)+(r1_0 ));        
        r.setDf2_Gr111_112_113Md((r2_1*ilr1_TiMd)+(r2_2 *ilr2_AlMd)+( r2_3* ilr3_FeTMd)+( r2_4*ilr4_MnMd)+( r2_5*ilr5_MgMd)+( r2_6 *ilr6_CaMd)+( r2_7*ilr7_NaMd)+( r2_8 *ilr8_KMd)+( r2_9*ilr9_PMd)+(r2_0 ));        
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_Gr111_112_113Md();
        double df2=r.getDf2_Gr111_112_113Md();       
        
        double x1 = df1 - (-0.269329713446773);
        double y1 = df2 - (0.151258972423181);
        double x2 = df1 - (1.37352707352832);
        double y2 = df2 - (0.239580113619113);
        double x3 = df1 - (0.0912970220592193);
        double y3 = df2 - (-0.695589130710384);
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
            r.setP1_Gr111M( 1.0 / 3.0);
            r.setP2_Gr112M( 1.0 / 3.0);
            r.setP3_Gr113M( 1.0 / 3.0);
        }else{
            r.setP1_Gr111M(g1 / sumG);
            r.setP2_Gr112M(g2 / sumG);
            r.setP3_Gr113M(g3 / sumG);
           
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
      
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="Gr111";
        else if((p2>p1)&&(p2>p3))
           res="Gr112";
        else if((p3>p1)&&(p3>p2))
           res="CBA";        
   
        r.setDecision_Gr111_112_113M(res);
        r.setResultM(res);
    }
    
    //para MT
    @Override
    public void  calculaDFsMT(){                        
       //Columnas r = new Columnas();
       // r = getTabla().get(j);
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
        double r1_1=3.92233774696794;
        double r1_2=2.39044657928408;
        double r1_3=-1.21350963750532;
        double r1_4=1.4697660527926;
        double r1_5=1.27581555827377;
        double r1_6=2.59654593081465;
        double r1_7=-1.14516557283661;
        double r1_8=0.161410006898868;
        double r1_9=-0.797716704633559;
        double r1_10=-0.138700539593207;
        double r1_11=-0.121383452483474;
        double r1_12=0.143537921800451;
        double r1_13=-1.14122156023105;
        double r1_14=2.23247485255483;
        double r1_15=0.72405853756799;
        double r1_0=-20.2943081186697;

        double r2_1=0.704247376861273;
        double r2_2=2.40335634882295;
        double r2_3=1.45406249102403;
        double r2_4=-3.18591666012018;
        double r2_5=2.67074534205902;
        double r2_6=-1.55962737887368;
        double r2_7=-0.0488884203168541;
        double r2_8=2.08370674863857;
        double r2_9=-0.246067791038001;
        double r2_10=0.318467706720193;
        double r2_11=0.0292773788207489;
        double r2_12=-0.0701353889865565;
        double r2_13=0.676692864169303;
        double r2_14=2.80688144817551;
        double r2_15=-1.36134372752552;
        double r2_0=-5.22913800030235;
        
        r.setDf1_Gr111_112_113MTd((r1_1 *ilr1_TiMTd) + (r1_2*ilr2_AlMTd) + (r1_3* ilr3_FeTMTd) + (r1_4*ilr4_MnMTd) + 
                (r1_5*ilr5_MgMTd) + (r1_6*ilr6_CaMTd) + (r1_7*ilr7_NaMTd) + (r1_8*ilr8_KMTd) + (r1_9*ilr9_PMTd) + 
                (r1_10*ilr10_CrMTd) + (r1_11*ilr11_NbMTd) + (r1_12* ilr12_NiMTd) + (r1_13*ilr13_VMTd) + (r1_14*ilr14_YMTd) + 
                (r1_15*ilr15_ZrMTd) + (r1_0));
    
        r.setDf1_Gr111_112_113MTd((r2_1 *ilr1_TiMTd) + (r2_2*ilr2_AlMTd) + (r2_3* ilr3_FeTMTd) + (r2_4*ilr4_MnMTd) + 
                (r2_5*ilr5_MgMTd) + (r2_6*ilr6_CaMTd) + (r2_7*ilr7_NaMTd) + (r2_8*ilr8_KMTd) + (r2_9*ilr9_PMTd) + 
                (r2_10*ilr10_CrMTd) + (r2_11*ilr11_NbMTd) + (r2_12* ilr12_NiMTd) + (r2_13*ilr13_VMTd) + (r2_14*ilr14_YMTd) + 
                (r2_15*ilr15_ZrMTd) + (r2_0));

        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_Gr111_112_113MTd();
        double df2=r.getDf2_Gr111_112_113MTd();
        //COL 254
        double m_x1=-0.466692854278527;
        double m_x2=2.03685474195268;
        double m_x3=-0.388642270159114;      

        double m_y1=0.38330931349171;
        double m_y2=0.0405945124772602;
        double m_y3=-1.01025624809655;

        double x1 = df1 - m_x1;
        double x2 = df1 - m_x2;
        double x3 = df1 - m_x3;
        
        double y1 = df2 - m_y1;
        double y2 = df2 - m_y2;
        double y3 = df2 - m_y3;
        
        /*double x1 = df1 - (0.64718650266569711);
        double y1 = df2 - (-0.42266907592921532);
        double x2 = df1 - (-1.57937282630674500);
        double y2 = df2 - (-0.06107614538296113);
        double x3 = df1 - (0.48263641785625211);
        double y3 = df2 - (0.97889593505881756);*/
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
            r.setP1_Gr111MT( 1.0 / 3.0);
            r.setP2_Gr112MT( 1.0 / 3.0);
            r.setP3_Gr113MT( 1.0 / 3.0);
        }else{
            r.setP1_Gr111MT(g1 / sumG);
            r.setP2_Gr112MT(g2 / sumG);
            r.setP3_Gr113MT(g3 / sumG);
        
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="Gr111";
        else if((p2>p1)&&(p2>p3))
           res="Gr112";
        else if((p3>p1)&&(p3>p2))
           res="CBA";        
   
        r.setDecision_Gr111_112_113MT(res);
        r.setResultMT(res);
    }    

   
}

