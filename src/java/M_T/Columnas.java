/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

/**
 *
 * @author LDG
 */
public class Columnas {

    private Integer consecut;
    private String locality;
    private String sampID;
    
    private String resultM;
    private String resultMT;    
    private double sio2;
    private double tio2;
    private double al2o3;
    private double fe2o3;    
    private double mno;
    private double mgo;
    private double cao;
    private double na2o;
    private double k2o;
    private double p2o5;
    
    private double sio2A;
    private double tio2A;
    private double al2o3A;
    private double fe2o3tA;
    private double mnoA;
    private double mgoA;
    private double caoA;
    private double na2oA;
    private double k2oA;
    private double p2o5A;

    private double cr;
    private double nb;
    private double ni;
    private double v;
    private double y;
    private double zr;

    private double sio2mtA;
    private double tio2mtA;
    private double al2o3mtA;
    private double fe2o3tmtA;
    private double mnomtA;
    private double mgomtA;
    private double caomtA;
    private double na2omtA;
    private double k2omtA;
    private double p2o5mtA;

    private double crmtA;
    private double nbmtA;
    private double nimtA;
    private double vmtA;
    private double ymtA;
    private double zrmtA;

    private double ilrTiM;
    private double ilrAlM;
    private double ilrFeTM;
    private double ilrMnM;
    private double ilrMgM;
    private double ilrCaM;
    private double ilrNaM;
    private double ilrKM;
    private double ilrPM;
    
    private double ilrTiMT;
    private double ilrAlMT;
    private double ilrFeTMT;
    private double ilrMnMT;
    private double ilrMgMT;
    private double ilrCaMT;
    private double ilrNaMT;
    private double ilrKMT;
    private double ilrPMT;
    private double ilrCrMT;
    private double ilrNbMT;
    private double ilrNiMT;
    private double ilrVMT;
    private double ilrYMT;
    private double ilrZrMT;
       
    /******para ROBUSTNESS*************************************************************************/
    private double ucSio2;
    private double ucTio2;
    private double ucAl2o3;
    private double ucFe2o3;
    private double ucMno;
     private double ucMgo;
     private double ucCao;
     private double ucNa2o;
     private double ucK2o;
     private double ucP2o5;    
     private double ucCr;
     private double ucNb;
     private double ucNi;
     private double ucV;
     private double ucY;
     private double ucZr;
     
    private double rsdSio2;
    private double rsdTio2;
    private double rsdAl2o3;
    private double rsdFe2o3;
    private double rsdMno;
    private double rsdMgo;
     private double rsdCao;
     private double rsdNa2o;
     private double rsdK2o;
     private double rsdP2o5;    
     private double rsdCr;
     private double rsdNb;
     private double rsdNi;
     private double rsdV;
     private double rsdY;
     private double rsdZr;
     
    private double stepSio2;
    private double stepTio2;
    private double stepAl2o3;
    private double stepFe2o3;
    private double stepMno;
    private double stepMgo;
     private double stepCao;
     private double stepNa2o;
     private double stepK2o;
     private double stepP2o5;    
     private double stepCr;
     private double stepNb;
     private double stepNi;
     private double stepV;
     private double stepY;
     private double stepZr;
     
    private double df1_SG1_2_3Md;
    private double df2_SG1_2_3Md;
    private double p1_SG1M;
    private double p2_SG2M;
    private double p3_SG3M;
    private String decision_SG1_2_3M;

private double df1_SG1_2_3MTd;
private double df2_SG1_2_3MTd;
private double p1_SG1MT;
private double p2_SG2MT;
private double p3_SG3MT;
private String decision_SG1_2_3MT;

private double df1_MG11_12_13Md;
private double df2_MG11_12_13Md;
private double p1_MG11M;
private double p2_MG12M;
private double p3_MG13M;
private String decision_MG11_12_13M;
private double df1_MG11_12_13MTd;
private double df2_MG11_12_13MTd;
private double p1_MG11MT;
private double p2_MG12MT;
private double p3_MG13MT;
private String decision_MG11_12_13MT;

private double df1_Gr111_112_113Md;
private double df2_Gr111_112_113Md;
private double p1_Gr111M;
private double p2_Gr112M;
private double p3_Gr113M;
private String decision_Gr111_112_113M;
private double df1_Gr111_112_113MTd;
private double df2_Gr111_112_113MTd;
private double p1_Gr111MT;
private double p2_Gr112MT;
private double p3_Gr113MT;
private String decision_Gr111_112_113MT;
private double df1_sGr1111_1112_1113Md;
private double df2_sGr1111_1112_1113Md;
private double p1_sGr1111M;
private double p2_sGr1112M;
private double p3_sGr1113M;
private String decision_sGr1111_1112_1113M;
private double df1_sGr1111_1112_1113MTd;
private double df2_sGr1111_1112_1113MTd;
private double p1_sGr1111MT;
private double p2_sGr1112MT;
private double p3_sGr1113MT;
private String decision_sGr1111_1112_1113MT;
private double df0_sGr1121_1122Md;
private double p1_1121M;
private double p2_1122M;
private String decision_sGr1121_1122M;
private double df0_sGr1121_1122MTd;
private double p1_1121MT;
private double p2_1122MT;
private String decision_sGr1121_1122MT;
private double df0_Gr121_122Md;
private double p1_Gr121M;
private double p2_Gr122M;
private String decision_Gr121_122M;
private double df0_Gr121_122MTd;
private double p1_Gr121MT;
private double p2_Gr122MT;
private String decision_Gr121_122MT;
private double df0_sGr1211_1212Md;
private double p1_sGr1211M;
private double p2_sGr1212M;
private String decision_sGr1211_1212M;
private double df0_sGr1211_1212MTd;
private double p1_sGr1211MT;
private double p2_sGr1212MT;
private String decision_sGr1211_1212MT;
private double df0_sGr1221_1222Md;
private double p1_sGr1221M;
private double p2_sGr1222M;
private String decision_sGr1221_1222M;
private double df0_sGr1221_1222MTd;
private double p1_sGr1221MT;
private double p2_sGr1222MT;
private String decision_sGr1221_1222MT;
private double df1_MG21_22_23Md;
private double df2_MG21_22_23Md;
private double p1_MG21M;
private double p2_MG22M;
private double p3_MG23M;
private String decision_MG21_22_23M;
private double df1_MG21_22_23MTd;
private double df2_MG21_22_23MTd;
private double p1_MG21MT;
private double p2_MG22MT;
private double p3_MG23MT;
private String decision_MG21_22_23MT;
private double df1_Gr211_212_213Md;
private double df2_Gr211_212_213Md;
private double p1_Gr211M;
private double p2_Gr212M;
private double p3_Gr213M;
private String decision_Gr211_212_213M;
private double df1_Gr211_212_213MTd;
private double df2_Gr211_212_213MTd;
private double p1_Gr211MT;
private double p2_Gr212MT;
private double p3_Gr213MT;
private String decision_Gr211_212_213MT;
private double df1_Gr221_222_223Md;
private double df2_Gr221_222_223Md;
private double p1_Gr221M;
private double p2_Gr222M;
private double p3_Gr223M;
private String decision_Gr221_222_223M;
private double df1_Gr221_222_223MTd;
private double df2_Gr221_222_223MTd;
private double p1_Gr221MT;
private double p2_Gr222MT;
private double p3_Gr223MT;
private String decision_Gr221_222_223MT;
private double df1_Gr231_232_233Md;
private double df2_Gr231_232_233Md;
private double p1_Gr231M;
private double p2_Gr232M;
private double p3_Gr233M;
private String decision_Gr231_232_233M;
private double df1_Gr231_232_233MTd;
private double df2_Gr231_232_233MTd;
private double p1_Gr231MT;
private double p2_Gr232MT;
private double p3_Gr233MT;
private String decision_Gr231_232_233MT;
private double df0_sGr2311_2312Md;
private double p1_sGr2311M;
private double p2_sGr2312M;
private String decision_sGr2311_2312M;
private double df0_sGr2311_2312MTd;
private double p1_sGr2311MT;
private double p2_sGr2312MT;
private String decision_sGr2311_2312MT;
private double df0_sGr23111_23112Md;
private double p1_sGr23111M;
private double p2_sGr23112M;
private String decision_sGr23111_23112M;
private double df0_sGr23111_23112MTd;
private double p1_sGr23111MT;
private double p2_sGr23112MT;
private String decision_sGr23111_23112MT;
private double df0_sGr23121_23122Md;
private double p1_sGr23121M;
private double p2_sGr23122M;
private String decision_sGr23121_23122M;
private double df0_sGr23121_23122MTd;
private double p1_sGr23121MT;
private double p2_sGr23122MT;
private String decision_sGr23121_23122MT;
private double df0_sGr2321_2322Md;
private double p1_sGr2321M;
private double p2_sGr2322M;
private String decision_sGr2321_2322M;
private double df0_sGr2321_2322MTd;
private double p1_sGr2321MT;
private double p2_sGr2322MT;
private String decision_sGr2321_2322MT;
private double df1_MG31_32_33Md;
private double df2_MG31_32_33Md;
private double p1_MG31M;
private double p2_MG32M;
private double p3_MG33M;
private String decision_MG31_32_33M;
private double df1_MG31_32_33MTd;
private double df2_MG31_32_33MTd;
private double p1_MG31MT;
private double p2_MG32MT;
private double p3_MG33MT;
private String decision_MG31_32_33MT;
private double df1_Gr311_312_313Md;
private double df2_Gr311_312_313Md;
private double p1_Gr311M;
private double p2_Gr312M;
private double p3_Gr313M;
private String decision_Gr311_312_313M;
private double df1_Gr311_312_313MTd;
private double df2_Gr311_312_313MTd;
private double p1_Gr311MT;
private double p2_Gr312MT;
private double p3_Gr313MT;
private String decision_Gr311_312_313MT;
private String errorReg;
    

    public String getErrorReg() {
        return errorReg;
    }

    public Integer getConsecut() {
        return consecut;
    }

    public String getLocality() {
        return locality;
    }

    public String getSampID() {
        return sampID;
    }

    public double getSio2() {
        return sio2;
    }

    public double getTio2() {
        return tio2;
    }

    public double getAl2o3() {
        return al2o3;
    }

    public double getFe2o3() {
        return fe2o3;
    }

    public double getMno() {
        return mno;
    }

    public double getMgo() {
        return mgo;
    }

    public double getCao() {
        return cao;
    }

    public double getNa2o() {
        return na2o;
    }

    public double getK2o() {
        return k2o;
    }

    public double getP2o5() {
        return p2o5;
    }

    public double getSio2A() {
        return sio2A;
    }

    public double getTio2A() {
        return tio2A;
    }

    public double getAl2o3A() {
        return al2o3A;
    }

    public double getFe2o3tA() {
        return fe2o3tA;
    }

    public double getMnoA() {
        return mnoA;
    }

    public double getMgoA() {
        return mgoA;
    }

    public double getCaoA() {
        return caoA;
    }

    public double getNa2oA() {
        return na2oA;
    }

    public double getK2oA() {
        return k2oA;
    }

    public double getP2o5A() {
        return p2o5A;
    }

    public double getCr() {
        return cr;
    }

    public double getNb() {
        return nb;
    }

    public double getNi() {
        return ni;
    }

    public double getV() {
        return v;
    }

    public double getY() {
        return y;
    }

    public double getZr() {
        return zr;
    }

    public double getSio2mtA() {
        return sio2mtA;
    }

    public double getTio2mtA() {
        return tio2mtA;
    }

    public double getAl2o3mtA() {
        return al2o3mtA;
    }

    public double getFe2o3tmtA() {
        return fe2o3tmtA;
    }

    public double getMnomtA() {
        return mnomtA;
    }

    public double getMgomtA() {
        return mgomtA;
    }

    public double getCaomtA() {
        return caomtA;
    }

    public double getNa2omtA() {
        return na2omtA;
    }

    public double getK2omtA() {
        return k2omtA;
    }

    public double getP2o5mtA() {
        return p2o5mtA;
    }

    public double getCrmtA() {
        return crmtA;
    }

    public double getNbmtA() {
        return nbmtA;
    }

    public double getNimtA() {
        return nimtA;
    }

    public double getVmtA() {
        return vmtA;
    }

    public double getYmtA() {
        return ymtA;
    }

    public double getZrmtA() {
        return zrmtA;
    }

    public double getIlrTiM() {
        return ilrTiM;
    }

    public double getIlrAlM() {
        return ilrAlM;
    }

    public double getIlrFeTM() {
        return ilrFeTM;
    }

    public double getIlrMnM() {
        return ilrMnM;
    }

    public double getIlrMgM() {
        return ilrMgM;
    }

    public double getIlrCaM() {
        return ilrCaM;
    }

    public double getIlrNaM() {
        return ilrNaM;
    }

    public double getIlrKM() {
        return ilrKM;
    }

    public double getIlrPM() {
        return ilrPM;
    }

    public double getIlrTiMT() {
        return ilrTiMT;
    }

    public double getIlrAlMT() {
        return ilrAlMT;
    }

    public double getIlrFeTMT() {
        return ilrFeTMT;
    }

    public double getIlrMnMT() {
        return ilrMnMT;
    }

    public double getIlrMgMT() {
        return ilrMgMT;
    }

    public double getIlrCaMT() {
        return ilrCaMT;
    }

    public double getIlrNaMT() {
        return ilrNaMT;
    }

    public double getIlrKMT() {
        return ilrKMT;
    }

    public double getIlrPMT() {
        return ilrPMT;
    }

    public double getIlrCrMT() {
        return ilrCrMT;
    }

    public double getIlrNbMT() {
        return ilrNbMT;
    }

    public double getIlrNiMT() {
        return ilrNiMT;
    }

    public double getIlrVMT() {
        return ilrVMT;
    }

    public double getIlrYMT() {
        return ilrYMT;
    }

    public double getIlrZrMT() {
        return ilrZrMT;
    }

    public double getUcSio2() {
        return ucSio2;
    }

    public double getUcTio2() {
        return ucTio2;
    }

    public double getUcAl2o3() {
        return ucAl2o3;
    }

    public double getUcFe2o3() {
        return ucFe2o3;
    }

    public double getUcMno() {
        return ucMno;
    }

    public double getUcMgo() {
        return ucMgo;
    }

    public double getUcCao() {
        return ucCao;
    }

    public double getUcNa2o() {
        return ucNa2o;
    }

    public double getUcK2o() {
        return ucK2o;
    }

    public double getUcP2o5() {
        return ucP2o5;
    }

    public double getUcCr() {
        return ucCr;
    }

    public double getUcNb() {
        return ucNb;
    }

    public double getUcNi() {
        return ucNi;
    }

    public double getUcV() {
        return ucV;
    }

    public double getUcY() {
        return ucY;
    }

    public double getUcZr() {
        return ucZr;
    }

    public double getRsdSio2() {
        return rsdSio2;
    }

    public double getRsdTio2() {
        return rsdTio2;
    }

    public double getRsdAl2o3() {
        return rsdAl2o3;
    }

    public double getRsdFe2o3() {
        return rsdFe2o3;
    }

    public double getRsdMno() {
        return rsdMno;
    }

    public double getRsdMgo() {
        return rsdMgo;
    }

    public double getRsdCao() {
        return rsdCao;
    }

    public double getRsdNa2o() {
        return rsdNa2o;
    }

    public double getRsdK2o() {
        return rsdK2o;
    }

    public double getRsdP2o5() {
        return rsdP2o5;
    }

    public double getRsdCr() {
        return rsdCr;
    }

    public double getRsdNb() {
        return rsdNb;
    }

    public double getRsdNi() {
        return rsdNi;
    }

    public double getRsdV() {
        return rsdV;
    }

    public double getRsdY() {
        return rsdY;
    }

    public double getRsdZr() {
        return rsdZr;
    }

    public double getStepSio2() {
        return stepSio2;
    }

    public double getStepTio2() {
        return stepTio2;
    }

    public double getStepAl2o3() {
        return stepAl2o3;
    }

    public double getStepFe2o3() {
        return stepFe2o3;
    }

    public double getStepMno() {
        return stepMno;
    }

    public double getStepMgo() {
        return stepMgo;
    }

    public double getStepCao() {
        return stepCao;
    }

    public double getStepNa2o() {
        return stepNa2o;
    }

    public double getStepK2o() {
        return stepK2o;
    }

    public double getStepP2o5() {
        return stepP2o5;
    }

    public double getStepCr() {
        return stepCr;
    }

    public double getStepNb() {
        return stepNb;
    }

    public double getStepNi() {
        return stepNi;
    }

    public double getStepV() {
        return stepV;
    }

    public double getStepY() {
        return stepY;
    }

    public double getStepZr() {
        return stepZr;
    }

    public double getDf1_SG1_2_3Md() {
        return df1_SG1_2_3Md;
    }

    public double getDf2_SG1_2_3Md() {
        return df2_SG1_2_3Md;
    }

    public double getP1_SG1M() {
        return p1_SG1M;
    }

    public double getP2_SG2M() {
        return p2_SG2M;
    }

    public double getP3_SG3M() {
        return p3_SG3M;
    }

    public String getDecision_SG1_2_3M() {
        return decision_SG1_2_3M;
    }

    public double getDf1_SG1_2_3MTd() {
        return df1_SG1_2_3MTd;
    }

    public double getDf2_SG1_2_3MTd() {
        return df2_SG1_2_3MTd;
    }

    public double getP1_SG1MT() {
        return p1_SG1MT;
    }

    public double getP2_SG2MT() {
        return p2_SG2MT;
    }

    public double getP3_SG3MT() {
        return p3_SG3MT;
    }

    public String getDecision_SG1_2_3MT() {
        return decision_SG1_2_3MT;
    }

    public double getDf1_MG11_12_13Md() {
        return df1_MG11_12_13Md;
    }

    public double getDf2_MG11_12_13Md() {
        return df2_MG11_12_13Md;
    }

    public double getP1_MG11M() {
        return p1_MG11M;
    }

    public double getP2_MG12M() {
        return p2_MG12M;
    }

    public double getP3_MG13M() {
        return p3_MG13M;
    }

    public String getDecision_MG11_12_13M() {
        return decision_MG11_12_13M;
    }

    public double getDf1_MG11_12_13MTd() {
        return df1_MG11_12_13MTd;
    }

    public double getDf2_MG11_12_13MTd() {
        return df2_MG11_12_13MTd;
    }

    public double getP1_MG11MT() {
        return p1_MG11MT;
    }

    public double getP2_MG12MT() {
        return p2_MG12MT;
    }

    public double getP3_MG13MT() {
        return p3_MG13MT;
    }

    public String getDecision_MG11_12_13MT() {
        return decision_MG11_12_13MT;
    }

    public double getDf1_Gr111_112_113Md() {
        return df1_Gr111_112_113Md;
    }

    public double getDf2_Gr111_112_113Md() {
        return df2_Gr111_112_113Md;
    }

    public double getP1_Gr111M() {
        return p1_Gr111M;
    }

    public double getP2_Gr112M() {
        return p2_Gr112M;
    }

    public double getP3_Gr113M() {
        return p3_Gr113M;
    }

    public String getDecision_Gr111_112_113M() {
        return decision_Gr111_112_113M;
    }

    public double getDf1_Gr111_112_113MTd() {
        return df1_Gr111_112_113MTd;
    }

    public double getDf2_Gr111_112_113MTd() {
        return df2_Gr111_112_113MTd;
    }

    public double getP1_Gr111MT() {
        return p1_Gr111MT;
    }

    public double getP2_Gr112MT() {
        return p2_Gr112MT;
    }

    public double getP3_Gr113MT() {
        return p3_Gr113MT;
    }

    public String getDecision_Gr111_112_113MT() {
        return decision_Gr111_112_113MT;
    }

    public double getDf1_sGr1111_1112_1113Md() {
        return df1_sGr1111_1112_1113Md;
    }

    public double getDf2_sGr1111_1112_1113Md() {
        return df2_sGr1111_1112_1113Md;
    }

    public double getP1_sGr1111M() {
        return p1_sGr1111M;
    }

    public double getP2_sGr1112M() {
        return p2_sGr1112M;
    }

    public double getP3_sGr1113M() {
        return p3_sGr1113M;
    }

    public String getDecision_sGr1111_1112_1113M() {
        return decision_sGr1111_1112_1113M;
    }

    public double getDf1_sGr1111_1112_1113MTd() {
        return df1_sGr1111_1112_1113MTd;
    }

    public double getDf2_sGr1111_1112_1113MTd() {
        return df2_sGr1111_1112_1113MTd;
    }

    public double getP1_sGr1111MT() {
        return p1_sGr1111MT;
    }

    public double getP2_sGr1112MT() {
        return p2_sGr1112MT;
    }

    public double getP3_sGr1113MT() {
        return p3_sGr1113MT;
    }

    public String getDecision_sGr1111_1112_1113MT() {
        return decision_sGr1111_1112_1113MT;
    }

    public double getDf0_sGr1121_1122Md() {
        return df0_sGr1121_1122Md;
    }

    public double getP1_sGr1121M() {
        return p1_1121M;
    }

    public double getP2_sGr1122M() {
        return p2_1122M;
    }

    public String getDecision_sGr1121_1122M() {
        return decision_sGr1121_1122M;
    }

    public double getDf0_sGr1121_1122MTd() {
        return df0_sGr1121_1122MTd;
    }

    public double getP1_sGr1121MT() {
        return p1_1121MT;
    }

    public double getP2_sGr1122MT() {
        return p2_1122MT;
    }

    public String getDecision_sGr1121_1122MT() {
        return decision_sGr1121_1122MT;
    }

    public double getDf0_Gr121_122Md() {
        return df0_Gr121_122Md;
    }

    public double getP1_Gr121M() {
        return p1_Gr121M;
    }

    public double getP2_Gr122M() {
        return p2_Gr122M;
    }

    public String getDecision_Gr121_122M() {
        return decision_Gr121_122M;
    }

    public double getDf0_Gr121_122MTd() {
        return df0_Gr121_122MTd;
    }

    public double getP1_Gr121MT() {
        return p1_Gr121MT;
    }

    public double getP2_Gr122MT() {
        return p2_Gr122MT;
    }

    public String getDecision_Gr121_122MT() {
        return decision_Gr121_122MT;
    }

    public double getDf0_sGr1211_1212Md() {
        return df0_sGr1211_1212Md;
    }

    public double getP1_sGr1211M() {
        return p1_sGr1211M;
    }

    public double getP2_sGr1212M() {
        return p2_sGr1212M;
    }

    public String getDecision_sGr1211_1212M() {
        return decision_sGr1211_1212M;
    }

    public double getDf0_sGr1211_1212MTd() {
        return df0_sGr1211_1212MTd;
    }

    public double getP1_sGr1211MT() {
        return p1_sGr1211MT;
    }

    public double getP2_sGr1212MT() {
        return p2_sGr1212MT;
    }

    public String getDecision_sGr1211_1212MT() {
        return decision_sGr1211_1212MT;
    }

    public double getDf0_sGr1221_1222Md() {
        return df0_sGr1221_1222Md;
    }

    public double getP1_sGr1221M() {
        return p1_sGr1221M;
    }

    public double getP2_sGr1222M() {
        return p2_sGr1222M;
    }

    public String getDecision_sGr1221_1222M() {
        return decision_sGr1221_1222M;
    }

    public double getDf0_sGr1221_1222MTd() {
        return df0_sGr1221_1222MTd;
    }

    public double getP1_sGr1221MT() {
        return p1_sGr1221MT;
    }

    public double getP2_sGr1222MT() {
        return p2_sGr1222MT;
    }

    public String getDecision_sGr1221_1222MT() {
        return decision_sGr1221_1222MT;
    }

    public double getDf1_MG21_22_23Md() {
        return df1_MG21_22_23Md;
    }

    public double getDf2_MG21_22_23Md() {
        return df2_MG21_22_23Md;
    }

    public double getP1_MG21M() {
        return p1_MG21M;
    }

    public double getP2_MG22M() {
        return p2_MG22M;
    }

    public double getP3_MG23M() {
        return p3_MG23M;
    }

    public String getDecision_MG21_22_23M() {
        return decision_MG21_22_23M;
    }

    public double getDf1_MG21_22_23MTd() {
        return df1_MG21_22_23MTd;
    }

    public double getDf2_MG21_22_23MTd() {
        return df2_MG21_22_23MTd;
    }

    public double getP1_MG21MT() {
        return p1_MG21MT;
    }

    public double getP2_MG22MT() {
        return p2_MG22MT;
    }

    public double getP3_MG23MT() {
        return p3_MG23MT;
    }

    public String getDecision_MG21_22_23MT() {
        return decision_MG21_22_23MT;
    }

    public double getDf1_Gr211_212_213Md() {
        return df1_Gr211_212_213Md;
    }

    public double getDf2_Gr211_212_213Md() {
        return df2_Gr211_212_213Md;
    }

    public double getP1_Gr211M() {
        return p1_Gr211M;
    }

    public double getP2_Gr212M() {
        return p2_Gr212M;
    }

    public double getP3_Gr213M() {
        return p3_Gr213M;
    }

    public String getDecision_Gr211_212_213M() {
        return decision_Gr211_212_213M;
    }

    public double getDf1_Gr211_212_213MTd() {
        return df1_Gr211_212_213MTd;
    }

    public double getDf2_Gr211_212_213MTd() {
        return df2_Gr211_212_213MTd;
    }

    public double getP1_Gr211MT() {
        return p1_Gr211MT;
    }

    public double getP2_Gr212MT() {
        return p2_Gr212MT;
    }

    public double getP3_Gr213MT() {
        return p3_Gr213MT;
    }

    public String getDecision_Gr211_212_213MT() {
        return decision_Gr211_212_213MT;
    }

    public double getDf1_Gr221_222_223Md() {
        return df1_Gr221_222_223Md;
    }

    public double getDf2_Gr221_222_223Md() {
        return df2_Gr221_222_223Md;
    }

    public double getP1_Gr221M() {
        return p1_Gr221M;
    }

    public double getP2_Gr222M() {
        return p2_Gr222M;
    }

    public double getP3_Gr223M() {
        return p3_Gr223M;
    }

    public String getDecision_Gr221_222_223M() {
        return decision_Gr221_222_223M;
    }

    public double getDf1_Gr221_222_223MTd() {
        return df1_Gr221_222_223MTd;
    }

    public double getDf2_Gr221_222_223MTd() {
        return df2_Gr221_222_223MTd;
    }

    public double getP1_Gr221MT() {
        return p1_Gr221MT;
    }

    public double getP2_Gr222MT() {
        return p2_Gr222MT;
    }

    public double getP3_Gr223MT() {
        return p3_Gr223MT;
    }

    public String getDecision_Gr221_222_223MT() {
        return decision_Gr221_222_223MT;
    }

    public double getDf1_Gr231_232_233Md() {
        return df1_Gr231_232_233Md;
    }

    public double getDf2_Gr231_232_233Md() {
        return df2_Gr231_232_233Md;
    }

    public double getP1_Gr231M() {
        return p1_Gr231M;
    }

    public double getP2_Gr232M() {
        return p2_Gr232M;
    }

    public double getP3_Gr233M() {
        return p3_Gr233M;
    }

    public String getDecision_Gr231_232_233M() {
        return decision_Gr231_232_233M;
    }

    public double getDf1_Gr231_232_233MTd() {
        return df1_Gr231_232_233MTd;
    }

    public double getDf2_Gr231_232_233MTd() {
        return df2_Gr231_232_233MTd;
    }

    public double getP1_Gr231MT() {
        return p1_Gr231MT;
    }

    public double getP2_Gr232MT() {
        return p2_Gr232MT;
    }

    public double getP3_Gr233MT() {
        return p3_Gr233MT;
    }

    public String getDecision_Gr231_232_233MT() {
        return decision_Gr231_232_233MT;
    }

    public double getDf0_sGr2311_2312Md() {
        return df0_sGr2311_2312Md;
    }

    public double getP1_sGr2311M() {
        return p1_sGr2311M;
    }

    public double getP2_sGr2312M() {
        return p2_sGr2312M;
    }

    public String getDecision_sGr2311_2312M() {
        return decision_sGr2311_2312M;
    }

    public double getDf0_sGr2311_2312MTd() {
        return df0_sGr2311_2312MTd;
    }

    public double getP1_sGr2311MT() {
        return p1_sGr2311MT;
    }

    public double getP2_sGr2312MT() {
        return p2_sGr2312MT;
    }

    public String getDecision_sGr2311_2312MT() {
        return decision_sGr2311_2312MT;
    }

    public double getDf0_sGr23111_23112Md() {
        return df0_sGr23111_23112Md;
    }

    public double getP1_sGr23111M() {
        return p1_sGr23111M;
    }

    public double getP2_sGr23112M() {
        return p2_sGr23112M;
    }

    public String getDecision_sGr23111_23112M() {
        return decision_sGr23111_23112M;
    }

    public double getDf0_sGr23111_23112MTd() {
        return df0_sGr23111_23112MTd;
    }

    public double getP1_sGr23111MT() {
        return p1_sGr23111MT;
    }

    public double getP2_sGr23112MT() {
        return p2_sGr23112MT;
    }

    public String getDecision_sGr23111_23112MT() {
        return decision_sGr23111_23112MT;
    }

    public double getDf0_sGr23121_23122Md() {
        return df0_sGr23121_23122Md;
    }

    public double getP1_sGr23121M() {
        return p1_sGr23121M;
    }

    public double getP2_sGr23122M() {
        return p2_sGr23122M;
    }

    public String getDecision_sGr23121_23122M() {
        return decision_sGr23121_23122M;
    }

    public double getDf0_sGr23121_23122MTd() {
        return df0_sGr23121_23122MTd;
    }

    public double getP1_sGr23121MT() {
        return p1_sGr23121MT;
    }

    public double getP2_sGr23122MT() {
        return p2_sGr23122MT;
    }

    public String getDecision_sGr23121_23122MT() {
        return decision_sGr23121_23122MT;
    }

    public double getDf0_sGr2321_2322Md() {
        return df0_sGr2321_2322Md;
    }

    public double getP1_sGr2321M() {
        return p1_sGr2321M;
    }

    public double getP2_sGr2322M() {
        return p2_sGr2322M;
    }

    public String getDecision_sGr2321_2322M() {
        return decision_sGr2321_2322M;
    }

    public double getDf0_sGr2321_2322MTd() {
        return df0_sGr2321_2322MTd;
    }

    public double getP1_sGr2321MT() {
        return p1_sGr2321MT;
    }

    public double getP2_sGr2322MT() {
        return p2_sGr2322MT;
    }

    public String getDecision_sGr2321_2322MT() {
        return decision_sGr2321_2322MT;
    }

    public double getDf1_MG31_32_33Md() {
        return df1_MG31_32_33Md;
    }

    public double getDf2_MG31_32_33Md() {
        return df2_MG31_32_33Md;
    }

    public double getP1_MG31M() {
        return p1_MG31M;
    }

    public double getP2_MG32M() {
        return p2_MG32M;
    }

    public double getP3_MG33M() {
        return p3_MG33M;
    }

    public String getDecision_MG31_32_33M() {
        return decision_MG31_32_33M;
    }

    public double getDf1_MG31_32_33MTd() {
        return df1_MG31_32_33MTd;
    }

    public double getDf2_MG31_32_33MTd() {
        return df2_MG31_32_33MTd;
    }

    public double getP1_MG31MT() {
        return p1_MG31MT;
    }

    public double getP2_MG32MT() {
        return p2_MG32MT;
    }

    public double getP3_MG33MT() {
        return p3_MG33MT;
    }

    public String getDecision_MG31_32_33MT() {
        return decision_MG31_32_33MT;
    }

    public double getDf1_Gr311_312_313Md() {
        return df1_Gr311_312_313Md;
    }

    public double getDf2_Gr311_312_313Md() {
        return df2_Gr311_312_313Md;
    }

    public double getP1_Gr311M() {
        return p1_Gr311M;
    }

    public double getP2_Gr312M() {
        return p2_Gr312M;
    }

    public double getP3_Gr313M() {
        return p3_Gr313M;
    }

    public String getDecision_Gr311_312_313M() {
        return decision_Gr311_312_313M;
    }

    public double getDf1_Gr311_312_313MTd() {
        return df1_Gr311_312_313MTd;
    }

    public double getDf2_Gr311_312_313MTd() {
        return df2_Gr311_312_313MTd;
    }

    public double getP1_Gr311MT() {
        return p1_Gr311MT;
    }

    public double getP2_Gr312MT() {
        return p2_Gr312MT;
    }

    public double getP3_Gr313MT() {
        return p3_Gr313MT;
    }

    public String getDecision_Gr311_312_313MT() {
        return decision_Gr311_312_313MT;
    }

    public void setErrorReg(String errorReg) {
        this.errorReg = errorReg;
    }

    public void setConsecut(Integer consecut) {
        this.consecut = consecut;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setSampID(String sampID) {
        this.sampID = sampID;
    }

    public void setSio2(double sio2) {
        this.sio2 = sio2;
    }

    public void setTio2(double tio2) {
        this.tio2 = tio2;
    }

    public void setAl2o3(double al2o3) {
        this.al2o3 = al2o3;
    }

    public void setFe2o3(double fe2o3) {
        this.fe2o3 = fe2o3;
    }

    public void setMno(double mno) {
        this.mno = mno;
    }

    public void setMgo(double mgo) {
        this.mgo = mgo;
    }

    public void setCao(double cao) {
        this.cao = cao;
    }

    public void setNa2o(double na2o) {
        this.na2o = na2o;
    }

    public void setK2o(double k2o) {
        this.k2o = k2o;
    }

    public void setP2o5(double p2o5) {
        this.p2o5 = p2o5;
    }

    public void setSio2A(double sio2A) {
        this.sio2A = sio2A;
    }

    public void setTio2A(double tio2A) {
        this.tio2A = tio2A;
    }

    public void setAl2o3A(double al2o3A) {
        this.al2o3A = al2o3A;
    }

    public void setFe2o3tA(double fe2o3tA) {
        this.fe2o3tA = fe2o3tA;
    }

    public void setMnoA(double mnoA) {
        this.mnoA = mnoA;
    }

    public void setMgoA(double mgoA) {
        this.mgoA = mgoA;
    }

    public void setCaoA(double caoA) {
        this.caoA = caoA;
    }

    public void setNa2oA(double na2oA) {
        this.na2oA = na2oA;
    }

    public void setK2oA(double k2oA) {
        this.k2oA = k2oA;
    }

    public void setP2o5A(double p2o5A) {
        this.p2o5A = p2o5A;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public void setNb(double nb) {
        this.nb = nb;
    }

    public void setNi(double ni) {
        this.ni = ni;
    }

    public void setV(double v) {
        this.v = v;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZr(double zr) {
        this.zr = zr;
    }

    public void setSio2mtA(double sio2mtA) {
        this.sio2mtA = sio2mtA;
    }

    public void setTio2mtA(double tio2mtA) {
        this.tio2mtA = tio2mtA;
    }

    public void setAl2o3mtA(double al2o3mtA) {
        this.al2o3mtA = al2o3mtA;
    }

    public void setFe2o3tmtA(double fe2o3tmtA) {
        this.fe2o3tmtA = fe2o3tmtA;
    }

    public void setMnomtA(double mnomtA) {
        this.mnomtA = mnomtA;
    }

    public void setMgomtA(double mgomtA) {
        this.mgomtA = mgomtA;
    }

    public void setCaomtA(double caomtA) {
        this.caomtA = caomtA;
    }

    public void setNa2omtA(double na2omtA) {
        this.na2omtA = na2omtA;
    }

    public void setK2omtA(double k2omtA) {
        this.k2omtA = k2omtA;
    }

    public void setP2o5mtA(double p2o5mtA) {
        this.p2o5mtA = p2o5mtA;
    }

    public void setCrmtA(double crmtA) {
        this.crmtA = crmtA;
    }

    public void setNbmtA(double nbmtA) {
        this.nbmtA = nbmtA;
    }

    public void setNimtA(double nimtA) {
        this.nimtA = nimtA;
    }

    public void setVmtA(double vmtA) {
        this.vmtA = vmtA;
    }

    public void setYmtA(double ymtA) {
        this.ymtA = ymtA;
    }

    public void setZrmtA(double zrmtA) {
        this.zrmtA = zrmtA;
    }

    public void setIlrTiM(double ilrTiM) {
        this.ilrTiM = ilrTiM;
    }

    public void setIlrAlM(double ilrAlM) {
        this.ilrAlM = ilrAlM;
    }

    public void setIlrFeTM(double ilrFeTM) {
        this.ilrFeTM = ilrFeTM;
    }

    public void setIlrMnM(double ilrMnM) {
        this.ilrMnM = ilrMnM;
    }

    public void setIlrMgM(double ilrMgM) {
        this.ilrMgM = ilrMgM;
    }

    public void setIlrCaM(double ilrCaM) {
        this.ilrCaM = ilrCaM;
    }

    public void setIlrNaM(double ilrNaM) {
        this.ilrNaM = ilrNaM;
    }

    public void setIlrKM(double ilrKM) {
        this.ilrKM = ilrKM;
    }

    public void setIlrPM(double ilrPM) {
        this.ilrPM = ilrPM;
    }

    public void setIlrTiMT(double ilrTiMT) {
        this.ilrTiMT = ilrTiMT;
    }

    public void setIlrAlMT(double ilrAlMT) {
        this.ilrAlMT = ilrAlMT;
    }

    public void setIlrFeTMT(double ilrFeTMT) {
        this.ilrFeTMT = ilrFeTMT;
    }

    public void setIlrMnMT(double ilrMnMT) {
        this.ilrMnMT = ilrMnMT;
    }

    public void setIlrMgMT(double ilrMgMT) {
        this.ilrMgMT = ilrMgMT;
    }

    public void setIlrCaMT(double ilrCaMT) {
        this.ilrCaMT = ilrCaMT;
    }

    public void setIlrNaMT(double ilrNaMT) {
        this.ilrNaMT = ilrNaMT;
    }

    public void setIlrKMT(double ilrKMT) {
        this.ilrKMT = ilrKMT;
    }

    public void setIlrPMT(double ilrPMT) {
        this.ilrPMT = ilrPMT;
    }

    public void setIlrCrMT(double ilrCrMT) {
        this.ilrCrMT = ilrCrMT;
    }

    public void setIlrNbMT(double ilrNbMT) {
        this.ilrNbMT = ilrNbMT;
    }

    public void setIlrNiMT(double ilrNiMT) {
        this.ilrNiMT = ilrNiMT;
    }

    public void setIlrVMT(double ilrVMT) {
        this.ilrVMT = ilrVMT;
    }

    public void setIlrYMT(double ilrYMT) {
        this.ilrYMT = ilrYMT;
    }

    public void setIlrZrMT(double ilrZrMT) {
        this.ilrZrMT = ilrZrMT;
    }

    public void setUcSio2(double ucSio2) {
        this.ucSio2 = ucSio2;
    }

    public void setUcTio2(double ucTio2) {
        this.ucTio2 = ucTio2;
    }

    public void setUcAl2o3(double ucAl2o3) {
        this.ucAl2o3 = ucAl2o3;
    }

    public void setUcFe2o3(double ucFe2o3) {
        this.ucFe2o3 = ucFe2o3;
    }

    public void setUcMno(double ucMno) {
        this.ucMno = ucMno;
    }

    public void setUcMgo(double ucMgo) {
        this.ucMgo = ucMgo;
    }

    public void setUcCao(double ucCao) {
        this.ucCao = ucCao;
    }

    public void setUcNa2o(double ucNa2o) {
        this.ucNa2o = ucNa2o;
    }

    public void setUcK2o(double ucK2o) {
        this.ucK2o = ucK2o;
    }

    public void setUcP2o5(double ucP2o5) {
        this.ucP2o5 = ucP2o5;
    }

    public void setUcCr(double ucCr) {
        this.ucCr = ucCr;
    }

    public void setUcNb(double ucNb) {
        this.ucNb = ucNb;
    }

    public void setUcNi(double ucNi) {
        this.ucNi = ucNi;
    }

    public void setUcV(double ucV) {
        this.ucV = ucV;
    }

    public void setUcY(double ucY) {
        this.ucY = ucY;
    }

    public void setUcZr(double ucZr) {
        this.ucZr = ucZr;
    }

    public void setRsdSio2(double rsdSio2) {
        this.rsdSio2 = rsdSio2;
    }

    public void setRsdTio2(double rsdTio2) {
        this.rsdTio2 = rsdTio2;
    }

    public void setRsdAl2o3(double rsdAl2o3) {
        this.rsdAl2o3 = rsdAl2o3;
    }

    public void setRsdFe2o3(double rsdFe2o3) {
        this.rsdFe2o3 = rsdFe2o3;
    }

    public void setRsdMno(double rsdMno) {
        this.rsdMno = rsdMno;
    }

    public void setRsdMgo(double rsdMgo) {
        this.rsdMgo = rsdMgo;
    }

    public void setRsdCao(double rsdCao) {
        this.rsdCao = rsdCao;
    }

    public void setRsdNa2o(double rsdNa2o) {
        this.rsdNa2o = rsdNa2o;
    }

    public void setRsdK2o(double rsdK2o) {
        this.rsdK2o = rsdK2o;
    }

    public void setRsdP2o5(double rsdP2o5) {
        this.rsdP2o5 = rsdP2o5;
    }

    public void setRsdCr(double rsdCr) {
        this.rsdCr = rsdCr;
    }

    public void setRsdNb(double rsdNb) {
        this.rsdNb = rsdNb;
    }

    public void setRsdNi(double rsdNi) {
        this.rsdNi = rsdNi;
    }

    public void setRsdV(double rsdV) {
        this.rsdV = rsdV;
    }

    public void setRsdY(double rsdY) {
        this.rsdY = rsdY;
    }

    public void setRsdZr(double rsdZr) {
        this.rsdZr = rsdZr;
    }

    public void setStepSio2(double stepSio2) {
        this.stepSio2 = stepSio2;
    }

    public void setStepTio2(double stepTio2) {
        this.stepTio2 = stepTio2;
    }

    public void setStepAl2o3(double stepAl2o3) {
        this.stepAl2o3 = stepAl2o3;
    }

    public void setStepFe2o3(double stepFe2o3) {
        this.stepFe2o3 = stepFe2o3;
    }

    public void setStepMno(double stepMno) {
        this.stepMno = stepMno;
    }

    public void setStepMgo(double stepMgo) {
        this.stepMgo = stepMgo;
    }

    public void setStepCao(double stepCao) {
        this.stepCao = stepCao;
    }

    public void setStepNa2o(double stepNa2o) {
        this.stepNa2o = stepNa2o;
    }

    public void setStepK2o(double stepK2o) {
        this.stepK2o = stepK2o;
    }

    public void setStepP2o5(double stepP2o5) {
        this.stepP2o5 = stepP2o5;
    }

    public void setStepCr(double stepCr) {
        this.stepCr = stepCr;
    }

    public void setStepNb(double stepNb) {
        this.stepNb = stepNb;
    }

    public void setStepNi(double stepNi) {
        this.stepNi = stepNi;
    }

    public void setStepV(double stepV) {
        this.stepV = stepV;
    }

    public void setStepY(double stepY) {
        this.stepY = stepY;
    }

    public void setStepZr(double stepZr) {
        this.stepZr = stepZr;
    }

    public void setDf1_SG1_2_3Md(double df1_SG1_2_3Md) {
        this.df1_SG1_2_3Md = df1_SG1_2_3Md;
    }

    public void setDf2_SG1_2_3Md(double df2_SG1_2_3Md) {
        this.df2_SG1_2_3Md = df2_SG1_2_3Md;
    }

    public void setP1_SG1M(double p1_SG1M) {
        this.p1_SG1M = p1_SG1M;
    }

    public void setP2_SG2M(double p2_SG2M) {
        this.p2_SG2M = p2_SG2M;
    }

    public void setP3_SG3M(double p3_SG3M) {
        this.p3_SG3M = p3_SG3M;
    }

    public void setDecision_SG1_2_3M(String decision_SG1_2_3M) {
        this.decision_SG1_2_3M = decision_SG1_2_3M;
    }

    public void setDf1_SG1_2_3MTd(double df1_SG1_2_3MTd) {
        this.df1_SG1_2_3MTd = df1_SG1_2_3MTd;
    }

    public void setDf2_SG1_2_3MTd(double df2_SG1_2_3MTd) {
        this.df2_SG1_2_3MTd = df2_SG1_2_3MTd;
    }

    public void setP1_SG1MT(double p1_SG1MT) {
        this.p1_SG1MT = p1_SG1MT;
    }

    public void setP2_SG2MT(double p2_SG2MT) {
        this.p2_SG2MT = p2_SG2MT;
    }

    public void setP3_SG3MT(double p3_SG3MT) {
        this.p3_SG3MT = p3_SG3MT;
    }

    public void setDecision_SG1_2_3MT(String decision_SG1_2_3MT) {
        this.decision_SG1_2_3MT = decision_SG1_2_3MT;
    }

    public void setDf1_MG11_12_13Md(double df1_MG11_12_13Md) {
        this.df1_MG11_12_13Md = df1_MG11_12_13Md;
    }

    public void setDf2_MG11_12_13Md(double df2_MG11_12_13Md) {
        this.df2_MG11_12_13Md = df2_MG11_12_13Md;
    }

    public void setP1_MG11M(double p1_MG11M) {
        this.p1_MG11M = p1_MG11M;
    }

    public void setP2_MG12M(double p2_MG12M) {
        this.p2_MG12M = p2_MG12M;
    }

    public void setP3_MG13M(double p3_MG13M) {
        this.p3_MG13M = p3_MG13M;
    }

    public void setDecision_MG11_12_13M(String decision_MG11_12_13M) {
        this.decision_MG11_12_13M = decision_MG11_12_13M;
    }

    public void setDf1_MG11_12_13MTd(double df1_MG11_12_13MTd) {
        this.df1_MG11_12_13MTd = df1_MG11_12_13MTd;
    }

    public void setDf2_MG11_12_13MTd(double df2_MG11_12_13MTd) {
        this.df2_MG11_12_13MTd = df2_MG11_12_13MTd;
    }

    public void setP1_MG11MT(double p1_MG11MT) {
        this.p1_MG11MT = p1_MG11MT;
    }

    public void setP2_MG12MT(double p2_MG12MT) {
        this.p2_MG12MT = p2_MG12MT;
    }

    public void setP3_MG13MT(double p3_MG13MT) {
        this.p3_MG13MT = p3_MG13MT;
    }

    public void setDecision_MG11_12_13MT(String decision_MG11_12_13MT) {
        this.decision_MG11_12_13MT = decision_MG11_12_13MT;
    }

    public void setDf1_Gr111_112_113Md(double df1_Gr111_112_113Md) {
        this.df1_Gr111_112_113Md = df1_Gr111_112_113Md;
    }

    public void setDf2_Gr111_112_113Md(double df2_Gr111_112_113Md) {
        this.df2_Gr111_112_113Md = df2_Gr111_112_113Md;
    }

    public void setP1_Gr111M(double p1_Gr111M) {
        this.p1_Gr111M = p1_Gr111M;
    }

    public void setP2_Gr112M(double p2_Gr112M) {
        this.p2_Gr112M = p2_Gr112M;
    }

    public void setP3_Gr113M(double p3_Gr113M) {
        this.p3_Gr113M = p3_Gr113M;
    }

    public void setDecision_Gr111_112_113M(String decision_Gr111_112_113M) {
        this.decision_Gr111_112_113M = decision_Gr111_112_113M;
    }
    public void setDecision_Gr111_112_113MT(String decision_Gr111_112_113MT) {
        this.decision_Gr111_112_113MT = decision_Gr111_112_113MT;
    }
    public void setDf1_Gr111_112_113MTd(double df1_Gr111_112_113MTd) {
        this.df1_Gr111_112_113MTd = df1_Gr111_112_113MTd;
    }

    public void setDf2_Gr111_112_113MTd(double df2_Gr111_112_113MTd) {
        this.df2_Gr111_112_113MTd = df2_Gr111_112_113MTd;
    }

    public void setP1_Gr111MT(double p1_Gr111MT) {
        this.p1_Gr111MT = p1_Gr111MT;
    }

    public void setP2_Gr112MT(double p2_Gr112MT) {
        this.p2_Gr112MT = p2_Gr112MT;
    }

    public void setP3_Gr113MT(double p3_Gr113MT) {
        this.p3_Gr113MT = p3_Gr113MT;
    }

        
    public void setDf1_sGr1111_1112_1113Md(double df1_sGr1111_1112_1113Md) {
        this.df1_sGr1111_1112_1113Md = df1_sGr1111_1112_1113Md;
    }

    public void setDf2_sGr1111_1112_1113Md(double df2_sGr1111_1112_1113Md) {
        this.df2_sGr1111_1112_1113Md = df2_sGr1111_1112_1113Md;
    }

    public void setP1_sGr1111M(double p1_sGr1111M) {
        this.p1_sGr1111M = p1_sGr1111M;
    }

    public void setP2_sGr1112M(double p2_sGr1112M) {
        this.p2_sGr1112M = p2_sGr1112M;
    }

    public void setP3_sGr1113M(double p3_sGr1113M) {
        this.p3_sGr1113M = p3_sGr1113M;
    }

    public void setDecision_sGr1111_1112_1113M(String decision_sGr1111_1112_1113M) {
        this.decision_sGr1111_1112_1113M = decision_sGr1111_1112_1113M;
    }

    public void setDf1_sGr1111_1112_1113MTd(double df1_sGr1111_1112_1113MTd) {
        this.df1_sGr1111_1112_1113MTd = df1_sGr1111_1112_1113MTd;
    }

    public void setDf2_sGr1111_1112_1113MTd(double df2_sGr1111_1112_1113MTd) {
        this.df2_sGr1111_1112_1113MTd = df2_sGr1111_1112_1113MTd;
    }

    public void setP1_sGr1111MT(double p1_sGr1111MT) {
        this.p1_sGr1111MT = p1_sGr1111MT;
    }

    public void setP2_sGr1112MT(double p2_sGr1112MT) {
        this.p2_sGr1112MT = p2_sGr1112MT;
    }

    public void setP3_sGr1113MT(double p3_sGr1113MT) {
        this.p3_sGr1113MT = p3_sGr1113MT;
    }

    public void setDecision_sGr1111_1112_1113MT(String decision_sGr1111_1112_1113MT) {
        this.decision_sGr1111_1112_1113MT = decision_sGr1111_1112_1113MT;
    }

    public void setDf0_sGr1121_1122Md(double df0_sGr1121_1122Md) {
        this.df0_sGr1121_1122Md = df0_sGr1121_1122Md;
    }

    public void setP1_sGr1121M(double p1_1121M) {
        this.p1_1121M = p1_1121M;
    }

    public void setP2_sGr1122M(double p2_1122M) {
        this.p2_1122M = p2_1122M;
    }

    public void setDecision_sGr1121_1122M(String decision_sGr1121_1122M) {
        this.decision_sGr1121_1122M = decision_sGr1121_1122M;
    }

    public void setDf0_sGr1121_1122MTd(double df0_sGr1121_1122MTd) {
        this.df0_sGr1121_1122MTd = df0_sGr1121_1122MTd;
    }

    public void setP1_sGr1121MT(double p1_1121MT) {
        this.p1_1121MT = p1_1121MT;
    }

    public void setP2_sGr1122MT(double p2_1122MT) {
        this.p2_1122MT = p2_1122MT;
    }

    public void setDecision_sGr1121_1122MT(String decision_sGr1121_1122MTd) {
        this.decision_sGr1121_1122MT = decision_sGr1121_1122MTd;
    }

    public void setDf0_Gr121_122Md(double df0_Gr121_122Md) {
        this.df0_Gr121_122Md = df0_Gr121_122Md;
    }

    public void setP1_Gr121M(double p1_Gr121M) {
        this.p1_Gr121M = p1_Gr121M;
    }

    public void setP2_Gr122M(double p2_Gr122M) {
        this.p2_Gr122M = p2_Gr122M;
    }

    public void setDecision_Gr121_122M(String decision_Gr121_122M) {
        this.decision_Gr121_122M = decision_Gr121_122M;
    }

    public void setDf0_Gr121_122MTd(double df0_Gr121_122MTd) {
        this.df0_Gr121_122MTd = df0_Gr121_122MTd;
    }

    public void setP1_Gr121MT(double p1_Gr121MT) {
        this.p1_Gr121MT = p1_Gr121MT;
    }

    public void setP2_Gr122MT(double p2_Gr122MT) {
        this.p2_Gr122MT = p2_Gr122MT;
    }

    public void setDecision_Gr121_122MT(String decision_Gr121_122MT) {
        this.decision_Gr121_122MT = decision_Gr121_122MT;
    }

    public void setDf0_sGr1211_1212Md(double df0_sGr1211_1212Md) {
        this.df0_sGr1211_1212Md = df0_sGr1211_1212Md;
    }

    public void setP1_sGr1211M(double p1_sGr1211M) {
        this.p1_sGr1211M = p1_sGr1211M;
    }

    public void setP2_sGr1212M(double p2_sGr1212M) {
        this.p2_sGr1212M = p2_sGr1212M;
    }

    public void setDecision_sGr1211_1212M(String decision_sGr1211_1212M) {
        this.decision_sGr1211_1212M = decision_sGr1211_1212M;
    }

    public void setDf0_sGr1211_1212MTd(double df0_sGr1211_1212MTd) {
        this.df0_sGr1211_1212MTd = df0_sGr1211_1212MTd;
    }

    public void setP1_sGr1211MT(double p1_sGr1211MT) {
        this.p1_sGr1211MT = p1_sGr1211MT;
    }

    public void setP2_sGr1212MT(double p2_sGr1212MT) {
        this.p2_sGr1212MT = p2_sGr1212MT;
    }

    public void setDecision_sGr1211_1212MT(String decision_sGr1211_1212MT) {
        this.decision_sGr1211_1212MT = decision_sGr1211_1212MT;
    }

    public void setDf0_sGr1221_1222Md(double df0_sGr1221_1222Md) {
        this.df0_sGr1221_1222Md = df0_sGr1221_1222Md;
    }

    public void setP1_sGr1221M(double p1_sGr1221M) {
        this.p1_sGr1221M = p1_sGr1221M;
    }

    public void setP2_sGr1222M(double p2_sGr1222M) {
        this.p2_sGr1222M = p2_sGr1222M;
    }

    public void setDecision_sGr1221_1222M(String decision_sGr1221_1222M) {
        this.decision_sGr1221_1222M = decision_sGr1221_1222M;
    }

    public void setDf0_sGr1221_1222MTd(double df0_sGr1221_1222MTd) {
        this.df0_sGr1221_1222MTd = df0_sGr1221_1222MTd;
    }

    public void setP1_sGr1221MT(double p1_sGr1221MT) {
        this.p1_sGr1221MT = p1_sGr1221MT;
    }

    public void setP2_sGr1222MT(double p2_sGr1222MT) {
        this.p2_sGr1222MT = p2_sGr1222MT;
    }

    public void setDecision_sGr1221_1222MT(String decision_sGr1221_1222MT) {
        this.decision_sGr1221_1222MT = decision_sGr1221_1222MT;
    }

    public void setDf1_MG21_22_23Md(double df1_MG21_22_23Md) {
        this.df1_MG21_22_23Md = df1_MG21_22_23Md;
    }

    public void setDf2_MG21_22_23Md(double df2_MG21_22_23Md) {
        this.df2_MG21_22_23Md = df2_MG21_22_23Md;
    }

    public void setP1_MG21M(double p1_MG21M) {
        this.p1_MG21M = p1_MG21M;
    }

    public void setP2_MG22M(double p2_MG22M) {
        this.p2_MG22M = p2_MG22M;
    }

    public void setP3_MG23M(double p3_MG23M) {
        this.p3_MG23M = p3_MG23M;
    }

    public void setDecision_MG21_22_23M(String decision_MG21_22_23M) {
        this.decision_MG21_22_23M = decision_MG21_22_23M;
    }

    public void setDf1_MG21_22_23MTd(double df1_MG21_22_23MTd) {
        this.df1_MG21_22_23MTd = df1_MG21_22_23MTd;
    }

    public void setDf2_MG21_22_23MTd(double df2_MG21_22_23MTd) {
        this.df2_MG21_22_23MTd = df2_MG21_22_23MTd;
    }

    public void setP1_MG21MT(double p1_MG21MT) {
        this.p1_MG21MT = p1_MG21MT;
    }

    public void setP2_MG22MT(double p2_MG22MT) {
        this.p2_MG22MT = p2_MG22MT;
    }

    public void setP3_MG23MT(double p3_MG23MT) {
        this.p3_MG23MT = p3_MG23MT;
    }

    public void setDecision_MG21_22_23MT(String decision_MG21_22_23MT) {
        this.decision_MG21_22_23MT = decision_MG21_22_23MT;
    }

    public void setDf1_Gr211_212_213Md(double df1_Gr211_212_213Md) {
        this.df1_Gr211_212_213Md = df1_Gr211_212_213Md;
    }

    public void setDf2_Gr211_212_213Md(double df2_Gr211_212_213Md) {
        this.df2_Gr211_212_213Md = df2_Gr211_212_213Md;
    }

    public void setP1_Gr211M(double p1_Gr211M) {
        this.p1_Gr211M = p1_Gr211M;
    }

    public void setP2_Gr212M(double p2_Gr212M) {
        this.p2_Gr212M = p2_Gr212M;
    }

    public void setP3_Gr213M(double p3_Gr213M) {
        this.p3_Gr213M = p3_Gr213M;
    }

    public void setDecision_Gr211_212_213M(String decision_Gr211_212_213M) {
        this.decision_Gr211_212_213M = decision_Gr211_212_213M;
    }

    public void setDf1_Gr211_212_213MTd(double df1_Gr211_212_213MTd) {
        this.df1_Gr211_212_213MTd = df1_Gr211_212_213MTd;
    }

    public void setDf2_Gr211_212_213MTd(double df2_Gr211_212_213MTd) {
        this.df2_Gr211_212_213MTd = df2_Gr211_212_213MTd;
    }

    public void setP1_Gr211MT(double p1_Gr211MT) {
        this.p1_Gr211MT = p1_Gr211MT;
    }

    public void setP2_Gr212MT(double p2_Gr212MT) {
        this.p2_Gr212MT = p2_Gr212MT;
    }

    public void setP3_Gr213MT(double p3_Gr213MT) {
        this.p3_Gr213MT = p3_Gr213MT;
    }

    public void setDecision_Gr211_212_213MT(String decision_Gr211_212_213MT) {
        this.decision_Gr211_212_213MT = decision_Gr211_212_213MT;
    }

    public void setDf1_Gr221_222_223Md(double df1_Gr221_222_223Md) {
        this.df1_Gr221_222_223Md = df1_Gr221_222_223Md;
    }

    public void setDf2_Gr221_222_223Md(double df2_Gr221_222_223Md) {
        this.df2_Gr221_222_223Md = df2_Gr221_222_223Md;
    }

    public void setP1_Gr221M(double p1_Gr221M) {
        this.p1_Gr221M = p1_Gr221M;
    }

    public void setP2_Gr222M(double p2_Gr222M) {
        this.p2_Gr222M = p2_Gr222M;
    }

    public void setP3_Gr223M(double p3_Gr223M) {
        this.p3_Gr223M = p3_Gr223M;
    }

    public void setDecision_Gr221_222_223M(String decision_Gr221_222_223M) {
        this.decision_Gr221_222_223M = decision_Gr221_222_223M;
    }

    public void setDf1_Gr221_222_223MTd(double df1_Gr221_222_223MTd) {
        this.df1_Gr221_222_223MTd = df1_Gr221_222_223MTd;
    }

    public void setDf2_Gr221_222_223MTd(double df2_Gr221_222_223MTd) {
        this.df2_Gr221_222_223MTd = df2_Gr221_222_223MTd;
    }

    public void setP1_Gr221MT(double p1_Gr221MT) {
        this.p1_Gr221MT = p1_Gr221MT;
    }

    public void setP2_Gr222MT(double p2_Gr222MT) {
        this.p2_Gr222MT = p2_Gr222MT;
    }

    public void setP3_Gr223MT(double p3_Gr223MT) {
        this.p3_Gr223MT = p3_Gr223MT;
    }

    public void setDecision_Gr221_222_223MT(String decision_Gr221_222_223MT) {
        this.decision_Gr221_222_223MT = decision_Gr221_222_223MT;
    }

    public void setDf1_Gr231_232_233Md(double df1_Gr231_232_233Md) {
        this.df1_Gr231_232_233Md = df1_Gr231_232_233Md;
    }

    public void setDf2_Gr231_232_233Md(double df2_Gr231_232_233Md) {
        this.df2_Gr231_232_233Md = df2_Gr231_232_233Md;
    }

    public void setP1_Gr231M(double p1_Gr231M) {
        this.p1_Gr231M = p1_Gr231M;
    }

    public void setP2_Gr232M(double p2_Gr232M) {
        this.p2_Gr232M = p2_Gr232M;
    }

    public void setP3_Gr233M(double p3_Gr233M) {
        this.p3_Gr233M = p3_Gr233M;
    }

    public void setDecision_Gr231_232_233M(String decision_Gr231_232_233M) {
        this.decision_Gr231_232_233M = decision_Gr231_232_233M;
    }

    public void setDf1_Gr231_232_233MTd(double df1_Gr231_232_233MTd) {
        this.df1_Gr231_232_233MTd = df1_Gr231_232_233MTd;
    }

    public void setDf2_Gr231_232_233MTd(double df2_Gr231_232_233MTd) {
        this.df2_Gr231_232_233MTd = df2_Gr231_232_233MTd;
    }

    public void setP1_Gr231MT(double p1_Gr231MT) {
        this.p1_Gr231MT = p1_Gr231MT;
    }

    public void setP2_Gr232MT(double p2_Gr232MT) {
        this.p2_Gr232MT = p2_Gr232MT;
    }

    public void setP3_Gr233MT(double p3_Gr233MT) {
        this.p3_Gr233MT = p3_Gr233MT;
    }

    public void setDecision_Gr231_232_233MT(String decision_Gr231_232_233MT) {
        this.decision_Gr231_232_233MT = decision_Gr231_232_233MT;
    }

    public void setDf0_sGr2311_2312Md(double df0_sGr2311_2312Md) {
        this.df0_sGr2311_2312Md = df0_sGr2311_2312Md;
    }

    public void setP1_sGr2311M(double p1_sGr2311M) {
        this.p1_sGr2311M = p1_sGr2311M;
    }

    public void setP2_sGr2312M(double p2_sGr2312M) {
        this.p2_sGr2312M = p2_sGr2312M;
    }

    public void setDecision_sGr2311_2312M(String decision_sGr2311_2312M) {
        this.decision_sGr2311_2312M = decision_sGr2311_2312M;
    }

    public void setDf0_sGr2311_2312MTd(double df0_sGr2311_2312MTd) {
        this.df0_sGr2311_2312MTd = df0_sGr2311_2312MTd;
    }

    public void setP1_sGr2311MT(double p1_sGr2311MT) {
        this.p1_sGr2311MT = p1_sGr2311MT;
    }

    public void setP2_sGr2312MT(double p2_sGr2312MT) {
        this.p2_sGr2312MT = p2_sGr2312MT;
    }

    public void setDecision_sGr2311_2312MT(String decision_sGr2311_2312MT) {
        this.decision_sGr2311_2312MT = decision_sGr2311_2312MT;
    }

    public void setDf0_sGr23111_23112Md(double df0_sGr23111_23112Md) {
        this.df0_sGr23111_23112Md = df0_sGr23111_23112Md;
    }

    public void setP1_sGr23111M(double p1_sGr23111M) {
        this.p1_sGr23111M = p1_sGr23111M;
    }

    public void setP2_sGr23112M(double p2_sGr23112M) {
        this.p2_sGr23112M = p2_sGr23112M;
    }

    public void setDecision_sGr23111_23112M(String decision_sGr23111_23112M) {
        this.decision_sGr23111_23112M = decision_sGr23111_23112M;
    }

    public void setDf0_sGr23111_23112MTd(double df0_sGr23111_23112MTd) {
        this.df0_sGr23111_23112MTd = df0_sGr23111_23112MTd;
    }

    public void setP1_sGr23111MT(double p1_sGr23111MT) {
        this.p1_sGr23111MT = p1_sGr23111MT;
    }

    public void setP2_sGr23112MT(double p2_sGr23112MT) {
        this.p2_sGr23112MT = p2_sGr23112MT;
    }

    public void setDecision_sGr23111_23112MT(String decision_sGr23111_23112MT) {
        this.decision_sGr23111_23112MT = decision_sGr23111_23112MT;
    }

    public void setDf0_sGr23121_23122Md(double df0_sGr23121_23122Md) {
        this.df0_sGr23121_23122Md = df0_sGr23121_23122Md;
    }

    public void setP1_sGr23121M(double p1_sGr23121M) {
        this.p1_sGr23121M = p1_sGr23121M;
    }

    public void setP2_sGr23122M(double p2_sGr23122M) {
        this.p2_sGr23122M = p2_sGr23122M;
    }

    public void setDecision_sGr23121_23122M(String decision_sGr23121_23122M) {
        this.decision_sGr23121_23122M = decision_sGr23121_23122M;
    }

    public void setDf0_sGr23121_23122MTd(double df0_sGr23121_23122MTd) {
        this.df0_sGr23121_23122MTd = df0_sGr23121_23122MTd;
    }

    public void setP1_sGr23121MT(double p1_sGr23121MT) {
        this.p1_sGr23121MT = p1_sGr23121MT;
    }

    public void setP2_sGr23122MT(double p2_sGr23122MT) {
        this.p2_sGr23122MT = p2_sGr23122MT;
    }

    public void setDecision_sGr23121_23122MT(String decision_sGr23121_23122MT) {
        this.decision_sGr23121_23122MT = decision_sGr23121_23122MT;
    }

    public void setDf0_sGr2321_2322Md(double df0_sGr2321_2322Md) {
        this.df0_sGr2321_2322Md = df0_sGr2321_2322Md;
    }

    public void setP1_sGr2321M(double p1_sGr2321M) {
        this.p1_sGr2321M = p1_sGr2321M;
    }

    public void setP2_sGr2322M(double p2_sGr2322M) {
        this.p2_sGr2322M = p2_sGr2322M;
    }

    public void setDecision_sGr2321_2322M(String decision_sGr2321_2322M) {
        this.decision_sGr2321_2322M = decision_sGr2321_2322M;
    }

    public void setDf0_sGr2321_2322MTd(double df0_sGr2321_2322MTd) {
        this.df0_sGr2321_2322MTd = df0_sGr2321_2322MTd;
    }

    public void setP1_sGr2321MT(double p1_sGr2321MT) {
        this.p1_sGr2321MT = p1_sGr2321MT;
    }

    public void setP2_sGr2322MT(double p2_sGr2322MT) {
        this.p2_sGr2322MT = p2_sGr2322MT;
    }

    public void setDecision_sGr2321_2322MT(String decision_sGr2321_2322MT) {
        this.decision_sGr2321_2322MT = decision_sGr2321_2322MT;
    }

    public void setDf1_MG31_32_33Md(double df1_MG31_32_33Md) {
        this.df1_MG31_32_33Md = df1_MG31_32_33Md;
    }

    public void setDf2_MG31_32_33Md(double df2_MG31_32_33Md) {
        this.df2_MG31_32_33Md = df2_MG31_32_33Md;
    }

    public void setP1_MG31M(double p1_MG31M) {
        this.p1_MG31M = p1_MG31M;
    }

    public void setP2_MG32M(double p2_MG32M) {
        this.p2_MG32M = p2_MG32M;
    }

    public void setP3_MG33M(double p3_MG33M) {
        this.p3_MG33M = p3_MG33M;
    }

    public void setDecision_MG31_32_33M(String decision_MG31_32_33M) {
        this.decision_MG31_32_33M = decision_MG31_32_33M;
    }

    public void setDf1_MG31_32_33MTd(double df1_MG31_32_33MTd) {
        this.df1_MG31_32_33MTd = df1_MG31_32_33MTd;
    }

    public void setDf2_MG31_32_33MTd(double df2_MG31_32_33MTd) {
        this.df2_MG31_32_33MTd = df2_MG31_32_33MTd;
    }

    public void setP1_MG31MT(double p1_MG31MT) {
        this.p1_MG31MT = p1_MG31MT;
    }

    public void setP2_MG32MT(double p2_MG32MT) {
        this.p2_MG32MT = p2_MG32MT;
    }

    public void setP3_MG33MT(double p3_MG33MT) {
        this.p3_MG33MT = p3_MG33MT;
    }

    public void setDecision_MG31_32_33MT(String decision_MG31_32_33MT) {
        this.decision_MG31_32_33MT = decision_MG31_32_33MT;
    }

    public void setDf1_Gr311_312_313Md(double df1_Gr311_312_313Md) {
        this.df1_Gr311_312_313Md = df1_Gr311_312_313Md;
    }

    public void setDf2_Gr311_312_313Md(double df2_Gr311_312_313Md) {
        this.df2_Gr311_312_313Md = df2_Gr311_312_313Md;
    }

    public void setP1_Gr311M(double p1_Gr311M) {
        this.p1_Gr311M = p1_Gr311M;
    }

    public void setP2_Gr312M(double p2_Gr312M) {
        this.p2_Gr312M = p2_Gr312M;
    }

    public void setP3_Gr313M(double p3_Gr313M) {
        this.p3_Gr313M = p3_Gr313M;
    }

    public void setDecision_Gr311_312_313M(String decision_Gr311_312_313M) {
        this.decision_Gr311_312_313M = decision_Gr311_312_313M;
    }

    public void setDf1_Gr311_312_313MTd(double df1_Gr311_312_313MTd) {
        this.df1_Gr311_312_313MTd = df1_Gr311_312_313MTd;
    }

    public void setDf2_Gr311_312_313MTd(double df2_Gr311_312_313MTd) {
        this.df2_Gr311_312_313MTd = df2_Gr311_312_313MTd;
    }

    public void setP1_Gr311MT(double p1_Gr311MT) {
        this.p1_Gr311MT = p1_Gr311MT;
    }

    public void setP2_Gr312MT(double p2_Gr312MT) {
        this.p2_Gr312MT = p2_Gr312MT;
    }

    public void setP3_Gr313MT(double p3_Gr313MT) {
        this.p3_Gr313MT = p3_Gr313MT;
    }

    public void setDecision_Gr311_312_313MT(String decision_Gr311_312_313MT) {
        this.decision_Gr311_312_313MT = decision_Gr311_312_313MT;
    }

    

    public void setResultM(String resultM) {
        this.resultM = resultM;
    }

    public void setResultMT(String resultMT) {
        this.resultMT = resultMT;
    }

    public void setP1_1121M(double p1_1121M) {
        this.p1_1121M = p1_1121M;
    }

    public void setP2_1122M(double p2_1122M) {
        this.p2_1122M = p2_1122M;
    }

    public void setP1_1121MT(double p1_1121MT) {
        this.p1_1121MT = p1_1121MT;
    }

    public void setP2_1122MT(double p2_1122MT) {
        this.p2_1122MT = p2_1122MT;
    }

    public String getResultM() {
        return resultM;
    }

    public String getResultMT() {
        return resultMT;
    }

    public double getP1_1121M() {
        return p1_1121M;
    }

    public double getP2_1122M() {
        return p2_1122M;
    }

    public double getP1_1121MT() {
        return p1_1121MT;
    }

    public double getP2_1122MT() {
        return p2_1122MT;
    }
    
  
    /******para funciones de discrminacion*************************************************************************/
  

}
