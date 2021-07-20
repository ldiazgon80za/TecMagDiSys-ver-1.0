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
public class Step11_Gr211_212_213 extends Diagram2DFs{
    private Columnas r = new Columnas();    

    public void setR(Columnas r) {
        this.r = r;
    }

    public Columnas getR() {
        return r;
    }
    
    //constructor
    public Step11_Gr211_212_213(  Columnas r ){
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
        
        r.setDf1_Gr211_212_213Md((0.20454462065060966*ilr1_TiMd)+(-0.36046360176843029*ilr2_AlMd)+(-0.48837862998039228* ilr3_FeTMd)+(-1.99994393329501800*ilr4_MnMd)+(1.56357142932131120*ilr5_MgMd)+(-2.11348282794820190*ilr6_CaMd)+(1.57223441063326530*ilr7_NaMd)+(-1.08740074913789100*ilr8_KMd)+( -0.12461655530304849*ilr9_PMd)+( 7.08750525540625990));        
        r.setDf2_Gr211_212_213Md((1.16103533977054910*ilr1_TiMd)+(0.38959832023600877*ilr2_AlMd)+(3.82592886090508700* ilr3_FeTMd)+(-6.09933801824849460*ilr4_MnMd)+(-1.48697652162314740*ilr5_MgMd)+(-0.98570320012017199*ilr6_CaMd)+(-1.36532851698871020*ilr7_NaMd)+( 0.66751436928902930*ilr8_KMd)+( -0.31562633475710805*ilr9_PMd)+( 19.70141938514267800));
        calculaProbabilitiesM();//calcular las probabilidades        
    }
    
    @Override
    public void calculaProbabilitiesM() {
        double df1=r.getDf1_Gr211_212_213Md();
        double df2=r.getDf2_Gr211_212_213Md();        

        double x1 = df1 - (-0.26640933530947652);
        double y1 = df2 - (-0.76383548722860795);
        double x2 = df1 - (-0.54403742599532823);
        double y2 = df2 - (0.08263216690627218);
        double x3 = df1 - (1.18445471874027500);
        double y3 = df2 - (0.03238147058691610);
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
            r.setP1_Gr211M( 1.0 / 3.0);
            r.setP2_Gr212M( 1.0 / 3.0);
            r.setP3_Gr213M( 1.0 / 3.0);
        }else{
            r.setP1_Gr211M(g1 / sumG);
            r.setP2_Gr212M(g2 / sumG);
            r.setP3_Gr213M(g3 / sumG);
        
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
      
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="CBATC";
        else if((p2>p1)&&(p2>p3))
           res="CE";
        else if((p3>p1)&&(p3>p2))
           res="PCE";        
   
        r.setDecision_Gr211_212_213M(res);
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
        
        r.setDf1_Gr211_212_213MTd((-1.29174105436345490*ilr1_TiMTd) + (0.42398253165065297*ilr2_AlMTd) + (-0.44142715453004328* ilr3_FeTMTd) + (1.25789295436031790*ilr4_MnMTd) + (-1.32599662735426980*ilr5_MgMTd) + (4.11188248038094350*ilr6_CaMTd) + (-2.37318762801943790*ilr7_NaMTd) + (0.25297824201151198*ilr8_KMTd) + (0.38856583892850505*ilr9_PMTd) + (-0.37600538278642393*ilr10_CrMTd) + (0.09680279390823575*ilr11_NbMTd) + (0.35646624760633716* ilr12_NiMTd) + (-0.73167575275468066*ilr13_VMTd) + (-0.37853859813273094 *ilr14_YMTd) + (1.05196308386160810*ilr15_ZrMTd) + (1.55723996448829950));
        r.setDf2_Gr211_212_213MTd((-1.24481506477756660*ilr1_TiMTd) + (0.18888044911324037 *ilr2_AlMTd) + (3.17359178776735320* ilr3_FeTMTd) + (-3.86800957979024230*ilr4_MnMTd) + (0.17777841671300620*ilr5_MgMTd) + (-3.26595776754083870*ilr6_CaMTd) + (-1.52061360189667980*ilr7_NaMTd) + (0.42800111553205678*ilr8_KMTd) + (0.30307110075004207*ilr9_PMTd) + (-0.06000088374627659*ilr10_CrMTd) + (0.60544024715123512*ilr11_NbMTd) + (-1.00061187747325510* ilr12_NiMTd) + (1.44451991848342790*ilr13_VMTd) + (-0.60100419256961501*ilr14_YMTd) + (-2.08752373472726970*ilr15_ZrMTd) + (20.30758106139649000));
        calculaProbabilitiesMT();//calcular las probabilidades        
    }
        
    @Override
    public void calculaProbabilitiesMT() {
        double df1=r.getDf1_Gr211_212_213MTd();
        double df2=r.getDf2_Gr211_212_213MTd();
    
        double x1 = df1 - (0.75988523648754169);
        double y1 = df2 - (-1.19093701636820630);
        double x2 = df1 - (0.57689040463552965);
        double y2 = df2 - (0.20016138179836673);
        double x3 = df1 - (-1.28924963010326630);
        double y3 = df2 - (-0.03324508353192002);
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
            r.setP1_Gr211MT( 1.0 / 3.0);
            r.setP2_Gr212MT( 1.0 / 3.0);
            r.setP3_Gr213MT( 1.0 / 3.0);
        }else{
            r.setP1_Gr211MT(g1 / sumG);
            r.setP2_Gr212MT(g2 / sumG);
            r.setP3_Gr213MT(g3 / sumG);
            
            p1=g1 / sumG;
            p2=g2 / sumG;
            p3=g3 / sumG;
        }
        
        String res=null;
        if ((p1>p2)&&(p1>p3))
           res="CBATC";
        else if((p2>p1)&&(p2>p3))
           res="CE";
        else if((p3>p1)&&(p3>p2))
           res="PCE";        
   
        r.setDecision_Gr211_212_213MT(res);
        r.setResultMT(res);
    }    

   
}

