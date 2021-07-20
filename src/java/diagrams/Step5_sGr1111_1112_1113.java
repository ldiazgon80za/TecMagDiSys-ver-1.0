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
public class Step5_sGr1111_1112_1113 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step5_sGr1111_1112_1113(Columnas r){
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
          
        r.setDf1_sGr1111_1112_1113Md((1.72563790532193280*ilr1_TiMd)+( 1.69714402041701360*ilr2_AlMd)+( -0.56300257997183978* ilr3_FeTMd)+( -5.15070296703466380*ilr4_MnMd)+( -0.15258604314018470*ilr5_MgMd)+( -1.17002139566246280*ilr6_CaMd)+( 0.66928562612238496*ilr7_NaMd)+( -0.24391102452894939*ilr8_KMd)+( 0.36275473647440898*ilr9_PMd)+( 13.72062963920663100));        
        r.setDf2_sGr1111_1112_1113Md((0.73331799985269119*ilr1_TiMd)+( 2.94699032961910270*ilr2_AlMd)+( 0.32622240421178966* ilr3_FeTMd)+( -0.11194578422532529*ilr4_MnMd)+( -0.07227329045353069*ilr5_MgMd)+( 2.74666000071919300*ilr6_CaMd)+( -0.21711293439724375*ilr7_NaMd)+( 1.89255992034592470*ilr8_KMd)+( -1.50963026825025830*ilr9_PMd)+( 3.79035412760539000));
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_sGr1111_1112_1113Md();
        double df2=r.getDf2_sGr1111_1112_1113Md();        
        
        double x1 = df1 - (0.32392777436428588);
        double y1 = df2 - (0.04489228416068025);
        double x2 = df1 - (-0.45465416787979684);
        double y2 = df2 - (-1.61074369052458620);
        double x3 = df1 - (-1.15170729728608);
        double y3 = df2 - (0.19437729846545038);
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
            r.setP1_sGr1111M( 1.0 / 3.0);
            r.setP2_sGr1112M( 1.0 / 3.0);
            r.setP3_sGr1113M( 1.0 / 3.0);
        }else{
            r.setP1_sGr1111M(g1 / sumG);
            r.setP2_sGr1112M(g2 / sumG);
            r.setP3_sGr1113M(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="CA";
        else if((p2>p1)&&(p2>p3))
            res="CAE";
        else if((p3>p1)&&(p3>p2))
            res="CATC";        
   
        r.setDecision_sGr1111_1112_1113M(res);
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
        
        r.setDf1_sGr1111_1112_1113MTd((0.84829139738850645*ilr1_TiMTd) + (-1.63118799509949470*ilr2_AlMTd) + (1.33282646212704940* ilr3_FeTMTd) + (-2.50528273006692940*ilr4_MnMTd) + (-4.48097651762907210*ilr5_MgMTd) + (0.12061631295385351*ilr6_CaMTd) + (-1.13788619606151360*ilr7_NaMTd) + (-0.32573225623985602*ilr8_KMTd) + (-0.19234914527163569*ilr9_PMTd) + (0.10303361562534523*ilr10_CrMTd) + (-1.29794410997379120 *ilr11_NbMTd) + (0.32978429036487955* ilr12_NiMTd) + (-1.01016351374639050*ilr13_VMTd) + (-3.14195102619991660*ilr14_YMTd) + (1.80323087111908610*ilr15_ZrMTd) + (27.39560296858260500));                
        r.setDf2_sGr1111_1112_1113MTd((3.33496333175799360*ilr1_TiMTd) + (4.57862137647657090*ilr2_AlMTd) + (2.87629772856259610* ilr3_FeTMTd) + (-0.24965411161747783*ilr4_MnMTd) + (-0.36283629060406841*ilr5_MgMTd) + (-0.14379594950650457*ilr6_CaMTd) + (-0.96912111311329208*ilr7_NaMTd) + (1.40961131541478140*ilr8_KMTd) + (-1.97981018862454740*ilr9_PMTd) + (0.58688648352816375*ilr10_CrMTd) + (0.60517886557191813 *ilr11_NbMTd) + (-1.50508254453440450* ilr12_NiMTd) + (-2.22143425605512770*ilr13_VMTd) + (-1.04886255954892200*ilr14_YMTd) + (-0.32295510618268197*ilr15_ZrMTd) + (11.41062570665239100));
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_sGr1111_1112_1113MTd();
        double df2=r.getDf2_sGr1111_1112_1113MTd();
        //COL 254
  
        double x1 = df1 - (0.41774314131149382);
        double y1 = df2 - (0.03370233870769113);
        double x2 = df1 - (-1.15207136437049940);
        double y2 = df2 - (-2.31208865854244470);
        double x3 = df1 - (-1.80191313061727240);
        double y3 = df2 - (0.40707155901007219);
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
            r.setP1_sGr1111MT( 1.0 / 3.0);
            r.setP2_sGr1112MT( 1.0 / 3.0);
            r.setP3_sGr1113MT( 1.0 / 3.0);
        }else{
            r.setP1_sGr1111MT(g1 / sumG);
            r.setP2_sGr1112MT(g2 / sumG);
            r.setP3_sGr1113MT(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="CA";
        else if((p2>p1)&&(p2>p3))
            res="CAE";
        else if((p3>p1)&&(p3>p2))
            res="CATC";        
   
        r.setDecision_sGr1111_1112_1113MT(res);
        r.setResultMT(res);
    }    

   
}

