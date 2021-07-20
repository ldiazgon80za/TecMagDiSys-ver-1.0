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
public class Step12_Gr221_222_223 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step12_Gr221_222_223(  Columnas r ){
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
        
        r.setDf1_Gr221_222_223Md((-0.11620946128105290*ilr1_TiMd)+( -6.47620500515196710*ilr2_AlMd)+( -5.60845557420633070* ilr3_FeTMd)+( -0.21296035770338190*ilr4_MnMd)+( 0.03234810443170917*ilr5_MgMd)+( -2.44862827851164560*ilr6_CaMd)+( 0.00824251452706818*ilr7_NaMd)+( -1.15862850727307930*ilr8_KMd)+( -0.35975494237015876*ilr9_PMd)+( -0.16295026634890220));        
        r.setDf2_Gr221_222_223Md((0.07748635596407701*ilr1_TiMd)+( 1.22959051216846430*ilr2_AlMd)+( -5.91308780070965500* ilr3_FeTMd)+( -4.01574503400312640*ilr4_MnMd)+( 1.56792441010905080*ilr5_MgMd)+( -1.31455043773338250*ilr6_CaMd)+( 0.22642102637524586*ilr7_NaMd)+( -0.26126768725338501*ilr8_KMd)+( 0.43585781625607384*ilr9_PMd)+( 14.13085267236209800));
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_Gr221_222_223Md();
        double df2=r.getDf2_Gr221_222_223Md();        

        double x1 = df1 - (-0.56512640315079909);
        double y1 = df2 - (0.13256256051059090);
        double x2 = df1 - (-0.57745178284884258);
        double y2 = df2 - (-2.03624746248741140);
        double x3 = df1 - (1.69435679937921440);
        double y3 = df2 - (-0.00202248913319103);
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
            r.setP1_Gr221M( 1.0 / 3.0);
            r.setP2_Gr222M( 1.0 / 3.0);
            r.setP3_Gr223M( 1.0 / 3.0);
        }else{
            r.setP1_Gr221M(g1 / sumG);
            r.setP2_Gr222M(g2 / sumG);
            r.setP3_Gr223M(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
     
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="CR";
        else if((p2>p1)&&(p2>p3))
           res="CRS";
        else if((p3>p1)&&(p3>p2))
           res="CSSF";        
   
        r.setDecision_Gr221_222_223M(res);
        r.setResultM(res);
    }
    
    //para MT
    @Override
    public void  calculaDFsMT(){                        
        //Columnas r = new Columnas();
        //r = getTabla().get(j);
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
        
        r.setDf1_Gr221_222_223MTd((-0.83759367732248247*ilr1_TiMTd) + (-6.81773388538687010*ilr2_AlMTd) + (-7.72053814461520190* ilr3_FeTMTd) + (-0.52567185564183383*ilr4_MnMTd) + (-1.28406568544659530*ilr5_MgMTd) + (-2.36088243139210350*ilr6_CaMTd) + (-0.66202710777944695*ilr7_NaMTd) + (-2.44802831892254960*ilr8_KMTd) + (-1.14819217683390980 *ilr9_PMTd) + (0.62131962167849819*ilr10_CrMTd) + (1.95111705075277350*ilr11_NbMTd) + (-0.33603430142279123* ilr12_NiMTd) + (-2.13486772602834090*ilr13_VMTd) + (2.92970560596248530*ilr14_YMTd) + (-2.22609589716749310*ilr15_ZrMTd) + (-8.67259595572656040) );

        r.setDf2_Gr221_222_223MTd((-5.64706003146702070*ilr1_TiMTd) + (-9.07214184226170770*ilr2_AlMTd) + (4.61126686279351720* ilr3_FeTMTd) + (1.55300651411385320*ilr4_MnMTd) + (-3.47599915989595230*ilr5_MgMTd) + (3.47498163442738490*ilr6_CaMTd) + (0.30323682112262734*ilr7_NaMTd) + (-0.15764512936275712*ilr8_KMTd) + (0.21903306075337783 *ilr9_PMTd) + (0.52191070384210569*ilr10_CrMTd) + (0.79203250534807379*ilr11_NbMTd) + (-0.77512089390293759* ilr12_NiMTd) + (0.59762843046854974*ilr13_VMTd) + (-1.95985626750514990*ilr14_YMTd) + (-1.31013232698905640*ilr15_ZrMTd) + (12.87238896024030800) );
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_Gr221_222_223MTd();
        double df2=r.getDf2_Gr221_222_223MTd();
   
        double x1 = df1 - (-0.6210590289958553);
        double y1 = df2 - (-0.08781910798596115);
        double x2 = df1 - (-0.25580491557112595);
        double y2 = df2 - (1.56590668084362680);
        double x3 = df1 - (2.84568903920814260);
        double y3 = df2 - (-0.04619518829893110);
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
            r.setP1_Gr221MT(1.0 / 3.0);
            r.setP2_Gr222MT(1.0 / 3.0);
            r.setP3_Gr223MT(1.0 / 3.0);
        }else{
            r.setP1_Gr221MT(g1 / sumG);
            r.setP2_Gr222MT(g2 / sumG);
            r.setP3_Gr223MT(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="CR";
        else if((p2>p1)&&(p2>p3))
           res="CRS";
        else if((p3>p1)&&(p3>p2))
           res="CSSF";        
   
        r.setDecision_Gr221_222_223MT(res);
        r.setResultMT(res);
    }    

   
}

