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
public class Step13_Gr231_232_233 extends Diagram2DFs{
        private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step13_Gr231_232_233(  Columnas r ){
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
        
        r.setDf1_Gr231_232_233Md((-2.12918212703213690*ilr1_TiMd)+( -7.05148148763819990*ilr2_AlMd)+( -8.50297557446879890* ilr3_FeTMd)+( -3.67032653816447630*ilr4_MnMd)+( 2.05792638984025930*ilr5_MgMd)+( -1.30710315817651890*ilr6_CaMd)+( 1.25481336821221580*ilr7_NaMd)+( 0.34409942066600446*ilr8_KMd)+( -0.10299273044912644*ilr9_PMd)+( 15.04147718247789100));        
        r.setDf2_Gr231_232_233Md((7.00962646233300290*ilr1_TiMd)+( 8.10695238835325500*ilr2_AlMd)+( -9.16358070147641260* ilr3_FeTMd)+( 3.06421054376993940*ilr4_MnMd)+( 1.19227673231915570*ilr5_MgMd)+( -3.46669199539201810*ilr6_CaMd)+( 0.00185340879164999*ilr7_NaMd)+( -1.37735505972226480*ilr8_KMd)+( -0.26439403790863630*ilr9_PMd)+( -23.33991499310838300) );
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_Gr231_232_233Md();
        double df2=r.getDf2_Gr231_232_233Md();        

        double x1 = df1 - (-0.45282534832621657);
        double y1 = df2 - (0.18781582609431169);
        double x2 = df1 - (-0.56044790912699582);
        double y2 = df2 - (-1.20172921951489190);
        double x3 = df1 - (3.35115747862240100);
        double y3 = df2 - (-0.03218753026956378);
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
            r.setP1_Gr231M( 1.0 / 3.0);
            r.setP2_Gr232M( 1.0 / 3.0);
            r.setP3_Gr233M( 1.0 / 3.0);
        }else{
            r.setP1_Gr231M(g1 / sumG);
            r.setP2_Gr232M(g2 / sumG);
            r.setP3_Gr233M(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }        
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="Gr231";
        else if((p2>p1)&&(p2>p3))
           res="Gr232";
        else if((p3>p1)&&(p3>p2))
           res="OIaOPcMOR";        
   
        r.setDecision_Gr231_232_233M(res);
        r.setResultM(res);
    }
    
    //para MT
    @Override
    public void  calculaDFsMT(){                        
       // Columnas r = new Columnas();
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
        
        r.setDf1_Gr231_232_233MTd((-3.1557893305328184*ilr1_TiMTd) + (-13.402100188860780*ilr2_AlMTd) + (3.4025655821986467* ilr3_FeTMTd) + (-5.5574899634126016*ilr4_MnMTd) + (-6.6141385156704002*ilr5_MgMTd) + (2.4473180602789157*ilr6_CaMTd) + (4.1601755975783279*ilr7_NaMTd) + (-0.3751007352308560*ilr8_KMTd) + (-0.9585203360208247*ilr9_PMTd) + (-0.7045741647161414*ilr10_CrMTd) + (-3.7436633422136998*ilr11_NbMTd) + (1.0850462186053853* ilr12_NiMTd) + (-6.1583177733026169*ilr13_VMTd) + (-6.8357374911739477*ilr14_YMTd) + (2.3910032945183031*ilr15_ZrMTd) + (95.4090258111880160));

        r.setDf2_Gr231_232_233MTd((-3.9045559087896287*ilr1_TiMTd) + (1.2776305453345265 *ilr2_AlMTd) + (14.5189674275464370* ilr3_FeTMTd) + (5.6265311089106103*ilr4_MnMTd) + (-8.8180882488145915*ilr5_MgMTd) + (2.1593731475416438*ilr6_CaMTd) + (-0.9304743469428441*ilr7_NaMTd) + (1.3076452614710752*ilr8_KMTd) + (0.6145758081931515*ilr9_PMTd) + (-0.1446248003584866*ilr10_CrMTd) + (-3.0420762261529295*ilr11_NbMTd) + (1.3019904271635576* ilr12_NiMTd) + (0.4503361681331823*ilr13_VMTd) + (-8.3100170345116773*ilr14_YMTd) + (4.6604354369980960*ilr15_ZrMTd) + (25.3503134741411390));
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_Gr231_232_233MTd();
        double df2=r.getDf2_Gr231_232_233MTd();

        double x1 = df1 - (-1.7033142719214851);
        double y1 = df2 - (-0.3928319100418136);
        double x2 = df1 - (1.1209676597416518);
        double y2 = df2 - (2.6001628450141148);
        double x3 = df1 - (4.3633489377485972);
        double y3 = df2 - (-1.0768845800150579);
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
            r.setP1_Gr231MT(1.0 / 3.0);
            r.setP2_Gr232MT(1.0 / 3.0);
            r.setP3_Gr233MT(1.0 / 3.0);
        }else{
            r.setP1_Gr231MT(g1 / sumG);
            r.setP2_Gr232MT(g2 / sumG);
            r.setP3_Gr233MT(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
         String res=null;
        if ((p1>p2)&&(p1>p3))
           res="Gr231";
        else if((p2>p1)&&(p2>p3))
           res="Gr232";
        else if((p3>p1)&&(p3>p2))
           res="OIaOPcMOR";        
   
        r.setDecision_Gr231_232_233MT(res);
        r.setResultMT(res);
        
    }    

   
}

