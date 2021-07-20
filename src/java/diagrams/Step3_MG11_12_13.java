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
public class Step3_MG11_12_13 extends Diagram2DFs{
        private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step3_MG11_12_13(Columnas r){
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
        r.setDf1_MG11_12_13Md((2.00624997805031360*ilr1_TiMd) + (5.44840052077502610*ilr2_AlMd) + (-1.61488098496653270* ilr3_FeTMd) + (-2.81218315719325850*ilr4_MnMd) + (1.54116536202680670*ilr5_MgMd) + (-7.04859513556573080*ilr6_CaMd) + (-0.44174604537473816*ilr7_NaMd) + (0.07224668502306146*ilr8_KMd) + (0.26994798748384152*ilr9_PMd) + (3.31698444885262940));        
        r.setDf2_MG11_12_13Md((0.26535768569781476*ilr1_TiMd)+(8.14197623324888480*ilr2_AlMd)+( 2.02817227859992060* ilr3_FeTMd)+( -1.02443579333572040*ilr4_MnMd)+( -0.44570096182841584*ilr5_MgMd)+( -6.52155038327244710*ilr6_CaMd)+( -0.65875821922912647*ilr7_NaMd)+( -0.46960506172017596*ilr8_KMd)+( -0.42008158414208790*ilr9_PMd)+( 6.77464282361022980));
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_MG11_12_13Md();
        double df2=r.getDf2_MG11_12_13Md();        

        double x1 = df1 - (-0.631435493542257);
        double y1 = df2 - (-0.138299119920148);
        double x2 = df1 - (0.768015146094585);
        double y2 = df2 - (0.0535889129888512);
        double x3 = df1 - (-1.40440888733791);
        double y3 = df2 - (1.69538852902994);
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
            r.setP1_MG11M( 1.0 / 3.0);
            r.setP2_MG12M( 1.0 / 3.0);
            r.setP3_MG13M( 1.0 / 3.0);
        }else{
            r.setP1_MG11M(g1 / sumG);
            r.setP2_MG12M(g2 / sumG);
            r.setP3_MG13M(g3 / sumG);
        
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
                    
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MG11";
        else if((p2>p1)&&(p2>p3))
           res="MG12";
        else if((p3>p1)&&(p3>p2))
           res="Col";        
   
        r.setDecision_MG11_12_13M(res);
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
        
        r.setDf1_MG11_12_13MTd((2.04443536606326810*ilr1_TiMTd) + (4.01093757539039770*ilr2_AlMTd) + (0.34169172744410653* ilr3_FeTMTd) + (-4.12035884025514500*ilr4_MnMTd) + (1.12737649946094740*ilr5_MgMTd) + (-6.31379123919037170*ilr6_CaMTd) + (-1.25647715729700620*ilr7_NaMTd) + (-0.19371653197296332*ilr8_KMTd) + (-0.06343825420288399*ilr9_PMTd) + (0.10856421445775911*ilr10_CrMTd) + (-0.05705751745444113*ilr11_NbMTd) + (-0.72525826494711410* ilr12_NiMTd) + (-1.89382423832557680*ilr13_VMTd) + (-0.29948734915416303*ilr14_YMTd) + (-0.15828867948444941*ilr15_ZrMTd) + (20.57468220555092100));
        r.setDf2_MG11_12_13MTd((-0.54902575397841091*ilr1_TiMTd) + (-7.02280402710571750*ilr2_AlMTd) + (-0.46211982399958051* ilr3_FeTMTd) + (-0.26950822629615656*ilr4_MnMTd) + (0.12675144315710282*ilr5_MgMTd) + (7.60285101804307040*ilr6_CaMTd) + (-0.02287133270324806*ilr7_NaMTd) + (0.22815482524290595*ilr8_KMTd) + (0.00803492775310386*ilr9_PMTd) + (-0.73842194942347694*ilr10_CrMTd) + (0.48204496362667415 *ilr11_NbMTd) + (0.52159209793990602* ilr12_NiMTd) + (-1.60130922196533110*ilr13_VMTd) + (0.34034073559636435*ilr14_YMTd) + (-0.64251147390606689*ilr15_ZrMTd) + (5.16762634587114440));        
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_MG11_12_13MTd();
        double df2=r.getDf2_MG11_12_13MTd();
        //COL 254
        
        double x1 = df1 - (-0.66064488796918397);
        double y1 = df2 - (0.22285898268574744);
        double x2 = df1 - (0.96025719729257375);
        double y2 = df2 - (-0.11159411051122348);
        double x3 = df1 - (-1.72355194536396890);
        double y3 = df2 - (-2.34703473645026150);
        double sG1 = Math.sqrt(x1 * x1 + y1 * y1);
        double sG2 = Math.sqrt(x2 * x2 + y2 * y2);
        double sG3 = Math.sqrt(x3 * x3 + y3 * y3);
        double g1 = Math.exp(-(sG1 * sG1) / 2.0);
        double g2 = Math.exp(-(sG2 * sG2) / 2.0);
        double g3 = Math.exp(-(sG3 * sG3) / 2.0);
        double sumG = g1 + g2 + g3;
        double p1=0,p2=0,p3=0;
        //asignar las probab
        if (sumG == 0) {
            r.setP1_MG11MT( 1.0 / 3.0);
            r.setP2_MG12MT( 1.0 / 3.0);
            r.setP3_MG13MT( 1.0 / 3.0);
        }else {
            r.setP1_MG11MT(g1 / sumG);
            r.setP2_MG12MT(g2 / sumG);
            r.setP3_MG13MT(g3 / sumG);
         
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
         String res=null;
        if ((p1>p2)&&(p1>p3))
           res="MG11";
        else if((p2>p1)&&(p2>p3))
           res="MG12";
        else if((p3>p1)&&(p3>p2))
           res="Col";        
   
        r.setDecision_MG11_12_13MT(res);
        r.setResultMT(res);
    }    

   
}

