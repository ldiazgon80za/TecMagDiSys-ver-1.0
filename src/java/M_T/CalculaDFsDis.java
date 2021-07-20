/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M_T;

import java.util.ArrayList;
import org.zkoss.zul.Messagebox;
import diagrams.*;
import java.text.Collator;

/**
 *
 * @author LDG
 */
public class CalculaDFsDis {

    private ArrayList<Columnas> tabla;
    private String[][] tablaResumen;

    public void setTablaResumen(String[][] tablaResumen) {
        this.tablaResumen = tablaResumen;
    }

    public String[][] getTablaResumen() {
        return tablaResumen;
    }

    public CalculaDFsDis(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public ArrayList<Columnas> getTabla() {
        return tabla;
    }

    public void setTabla(ArrayList<Columnas> tabla) {
        this.tabla = tabla;
    }

    public void diagramM() {
        ArrayList pSG1_Step2 = new ArrayList<Object>();
        ArrayList pSG2_Step2 = new ArrayList<Object>();
        ArrayList pSG3_Step2 = new ArrayList<Object>();
        ArrayList pMG11_Step3 = new ArrayList<Object>();
        ArrayList pMG12_Step3 = new ArrayList<Object>();
        ArrayList pMG13_Step3 = new ArrayList<Object>();

        ArrayList pGr111_Step4 = new ArrayList<Object>();
        ArrayList pGr112_Step4 = new ArrayList<Object>();
        ArrayList pGr113_Step4 = new ArrayList<Object>();

        ArrayList psGr1111_Step5 = new ArrayList<Object>();
        ArrayList psGr1112_Step5 = new ArrayList<Object>();
        ArrayList psGr1113_Step5 = new ArrayList<Object>();

        ArrayList psGr1121_Step6 = new ArrayList<Object>();
        ArrayList psGr1122_Step6 = new ArrayList<Object>();

        ArrayList pGr121_Step7 = new ArrayList<Object>();
        ArrayList pGr122_Step7 = new ArrayList<Object>();
        ArrayList psGr1211_Step8 = new ArrayList<Object>();
        ArrayList psGr1212_Step8 = new ArrayList<Object>();
        ArrayList psGr1221_Step9 = new ArrayList<Object>();
        ArrayList psGr1222_Step9 = new ArrayList<Object>();
        ArrayList pMG21_Step10 = new ArrayList<Object>();
        ArrayList pMG22_Step10 = new ArrayList<Object>();
        ArrayList pMG23_Step10 = new ArrayList<Object>();
        ArrayList p_Gr211_Step11 = new ArrayList<Object>();
        ArrayList p_Gr212_Step11 = new ArrayList<Object>();
        ArrayList p_Gr213_Step11 = new ArrayList<Object>();
        ArrayList pGr221_Step12 = new ArrayList<Object>();
        ArrayList pGr222_Step12 = new ArrayList<Object>();
        ArrayList pGr223_Step12 = new ArrayList<Object>();
        ArrayList pGr231_Step13 = new ArrayList<Object>();
        ArrayList pGr232_Step13 = new ArrayList<Object>();
        ArrayList pGr233_Step13 = new ArrayList<Object>();
        ArrayList psGr2311_Step14 = new ArrayList<Object>();
        ArrayList psGr2312_Step14 = new ArrayList<Object>();
        ArrayList pssGr23111_Step15 = new ArrayList<Object>();
        ArrayList pssGr23112_Step15 = new ArrayList<Object>();
        ArrayList pssGr23121_Step16 = new ArrayList<Object>();
        ArrayList pssGr23122_Step16 = new ArrayList<Object>();
        ArrayList psGr2321_Step17 = new ArrayList<Object>();
        ArrayList psGr2322_Step17 = new ArrayList<Object>();
        ArrayList pMG31_Step18 = new ArrayList<Object>();
        ArrayList pMG32_Step18 = new ArrayList<Object>();
        ArrayList pMG33_Step18 = new ArrayList<Object>();
        ArrayList pGr311_Step19 = new ArrayList<Object>();
        ArrayList pGr312_Step19 = new ArrayList<Object>();
        ArrayList pGr313_Step19 = new ArrayList<Object>();

        Columnas r = new Columnas();
        Step2_SG1_2_3 SG1_2_3;
        //queda pendiente declarar todos los objetos del árbol antes del ciclo y dentro solo terminar la instancia   
        for (int j = 0; j < tabla.size(); j++) {
            r = tabla.get(j);
            SG1_2_3 = new Step2_SG1_2_3(r);//diagrama nodo raíz
            SG1_2_3.calculaDFsM();
            r = SG1_2_3.getR();//actualizo r con lo que fue calculado en el diagrama anterior
            //double p1, p2, p3;//después mejoraré las condiciones, que se basen en probabilides y no en cadenas
            //p1=r.getP1_SG1M();             p1=r.getP2_SG2M();            p3=r.getP3_SG3M();

            if ("SG1".equalsIgnoreCase(r.getDecision_SG1_2_3M())) {
                pSG1_Step2.add(r.getP1_SG1M());//sumar probab de muestras clasificadas 
                Step3_MG11_12_13 MG11_12_13 = new Step3_MG11_12_13(r);
                MG11_12_13.calculaDFsM();
                r = MG11_12_13.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG11".equalsIgnoreCase(r.getDecision_MG11_12_13M())) {
                    pMG11_Step3.add(r.getP1_MG11M());//sumar probab de muestras clasificadas    
                    Step4_Gr111_112_113 Gr111_112_113 = new Step4_Gr111_112_113(r);
                    Gr111_112_113.calculaDFsM();
                    r = Gr111_112_113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr111".equalsIgnoreCase(r.getDecision_Gr111_112_113M())) {
                        pGr111_Step4.add(r.getP1_Gr111M());//sumar probab de muestras clasificadas 
                        Step5_sGr1111_1112_1113 sGr1111_1112_1113 = new Step5_sGr1111_1112_1113(r);
                        sGr1111_1112_1113.calculaDFsM();
                        r = sGr1111_1112_1113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CA, CAE,CATC
                        if ("CA".equalsIgnoreCase(r.getDecision_sGr1111_1112_1113M())) {
                            psGr1111_Step5.add(r.getP1_sGr1111M());//sumar probab de muestras clasificadas     
                        }
                        if ("CAE".equalsIgnoreCase(r.getDecision_sGr1111_1112_1113M())) {
                            psGr1112_Step5.add(r.getP2_sGr1112M());//sumar probab de muestras clasificadas
                        }
                        if ("CATC".equalsIgnoreCase(r.getDecision_sGr1111_1112_1113M())) {
                            psGr1113_Step5.add(r.getP3_sGr1113M());//sumar probab de muestras clasificadas                     
                        }
                    }
                    if ("Gr112".equalsIgnoreCase(r.getDecision_Gr111_112_113M())) {
                        pGr112_Step4.add(r.getP2_Gr112M());//sumar probab de muestras clasificadas                         
                        Step6_sGr1121_1122 sGr1121_1122 = new Step6_sGr1121_1122(r);
                        sGr1121_1122.calculaDFsM();
                        r = sGr1121_1122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CARS, CATCaRS                       
                        if ("CARS".equalsIgnoreCase(r.getDecision_sGr1121_1122M())) {
                            psGr1121_Step6.add(r.getP1_sGr1121M());//sumar probab de muestras clasificadas     
                        }
                        if ("CATCaRS".equalsIgnoreCase(r.getDecision_sGr1121_1122M())) {
                            psGr1122_Step6.add(r.getP2_sGr1122M());//sumar probab de muestras clasificadas  
                        }
                    }
                    //if ("Col".equalsIgnoreCase(r.getDecision_Gr111_112_113M()))
                    //Ya llegó a una hoja Col
                    if ("CBA".equalsIgnoreCase(r.getDecision_Gr111_112_113M())) {
                        pGr113_Step4.add(r.getP3_Gr113M());//sumar probab de muestras clasificadas 
                    }
                }
                if ("MG12".equalsIgnoreCase(r.getDecision_MG11_12_13M())) {
                    pMG12_Step3.add(r.getP2_MG12M());//sumar probab de muestras clasificadas 
                    Step7_Gr121_122 Gr121_122 = new Step7_Gr121_122(r);
                    Gr121_122.calculaDFsM();
                    r = Gr121_122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr121".equalsIgnoreCase(r.getDecision_Gr121_122M())) {
                        pGr121_Step7.add(r.getP1_Gr121M());//sumar probab de muestras clasificadas  
                        Step8_sGr1211_1212 sGr1211_1212 = new Step8_sGr1211_1212(r);
                        sGr1211_1212.calculaDFsM();
                        r = sGr1211_1212.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IA, IAE
                        if ("IA".equalsIgnoreCase(r.getDecision_sGr1211_1212M())) {
                            psGr1211_Step8.add(r.getP1_sGr1211M());//sumar probab de muestras clasificadas 
                        }
                        if ("IAE".equalsIgnoreCase(r.getDecision_sGr1211_1212M())) {
                            psGr1212_Step8.add(r.getP2_sGr1212M());//sumar probab de muestras clasificadas
                        }
                    }
                    if ("Gr122".equalsIgnoreCase(r.getDecision_Gr121_122M())) {
                        pGr122_Step7.add(r.getP2_Gr122M());//sumar probab de muestras clasificadas  
                        Step9_sGr1221_1222 sGr1221_1222 = new Step9_sGr1221_1222(r);
                        sGr1221_1222.calculaDFsM();
                        r = sGr1221_1222.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IBA, IBAB
                        if ("IBA".equalsIgnoreCase(r.getDecision_sGr1221_1222M())) {
                            psGr1221_Step9.add(r.getP1_sGr1221M());//sumar probab de muestras clasificadas         
                        }
                        if ("IBAB".equalsIgnoreCase(r.getDecision_sGr1221_1222M())) {
                            psGr1222_Step9.add(r.getP2_sGr1222M());//sumar probab de muestras clasificadas  
                        }
                    }
                }
                if ("Col".equalsIgnoreCase(r.getDecision_MG11_12_13M()))//OK
                {
                    pMG13_Step3.add(r.getP3_MG13M());//sumar probab de muestras clasificadas 
                }
            }
            if ("SG2".equalsIgnoreCase(r.getDecision_SG1_2_3M())) {
                pSG2_Step2.add(r.getP1_SG1M());//sumar probab de muestras clasificadas como SG2
                Step10_MG21_22_23 MG21_22_23 = new Step10_MG21_22_23(r);
                MG21_22_23.calculaDFsM();
                r = MG21_22_23.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG21".equalsIgnoreCase(r.getDecision_MG21_22_23M())) {
                    pMG21_Step10.add(r.getP1_MG21M());
                    Step11_Gr211_212_213 Gr211_212_213 = new Step11_Gr211_212_213(r);
                    Gr211_212_213.calculaDFsM();
                    r = Gr211_212_213.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas: CBATC, CE, PCE
                    if ("CBATC".equalsIgnoreCase(r.getDecision_Gr211_212_213M())) {
                        p_Gr211_Step11.add(r.getP1_Gr211M());
                    }
                    if ("CE".equalsIgnoreCase(r.getDecision_Gr211_212_213M())) {
                        p_Gr212_Step11.add(r.getP2_Gr212M());
                    }
                    if ("PCE".equalsIgnoreCase(r.getDecision_Gr211_212_213M())) {
                        p_Gr213_Step11.add(r.getP3_Gr213M());
                    }
                }
                if ("MG22".equalsIgnoreCase(r.getDecision_MG21_22_23M())) {
                    pMG22_Step10.add(r.getP2_MG22M());
                    Step12_Gr221_222_223 Gr221_222_223 = new Step12_Gr221_222_223(r);
                    Gr221_222_223.calculaDFsM();
                    r = Gr221_222_223.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas : CR, CSSF, CRS
                    if ("CR".equalsIgnoreCase(r.getDecision_Gr221_222_223M())) {
                        pGr221_Step12.add(r.getP1_Gr221M());
                    }
                    if ("CSSF".equalsIgnoreCase(r.getDecision_Gr221_222_223M())) {
                        pGr222_Step12.add(r.getP2_Gr222M());
                    }
                    if ("CRS".equalsIgnoreCase(r.getDecision_Gr221_222_223M())) {
                        pGr223_Step12.add(r.getP3_Gr223M());
                    }
                }
                if ("MG23".equalsIgnoreCase(r.getDecision_MG21_22_23M())) {
                    pMG23_Step10.add(r.getP3_MG23M());
                    Step13_Gr231_232_233 Gr231_232_233 = new Step13_Gr231_232_233(r);
                    Gr231_232_233.calculaDFsM();
                    r = Gr231_232_233.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr231".equalsIgnoreCase(r.getDecision_Gr231_232_233M())) {
                        pGr231_Step13.add(r.getP1_Gr231M());
                        Step14_sGr2311_2312 sGr2311_2312 = new Step14_sGr2311_2312(r);
                        sGr2311_2312.calculaDFsM();
                        r = sGr2311_2312.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        if ("sGr2311".equalsIgnoreCase(r.getDecision_sGr2311_2312M())) {
                            psGr2311_Step14.add(r.getP1_sGr2311M());
                            Step15_ssGr23111_23112 sGr23111_23112 = new Step15_ssGr23111_23112(r);
                            sGr23111_23112.calculaDFsM();
                            r = sGr23111_23112.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OI, OIcC
                            if ("OI".equalsIgnoreCase(r.getDecision_sGr23111_23112M())) {
                                pssGr23111_Step15.add(r.getP1_sGr23111M());
                            }
                            if ("OIcC".equalsIgnoreCase(r.getDecision_sGr23111_23112M())) {
                                pssGr23112_Step15.add(r.getP2_sGr23112M());
                            }
                        }
                        if ("sGr2312".equalsIgnoreCase(r.getDecision_sGr2311_2312M())) {
                            psGr2312_Step14.add(r.getP2_sGr2312M());
                            Step16_ssGr23121_23122 sGr23121_23122 = new Step16_ssGr23121_23122(r);
                            sGr23121_23122.calculaDFsM();
                            r = sGr23121_23122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OIaOP, OP  
                            if ("OIaOP".equalsIgnoreCase(r.getDecision_sGr23121_23122M())) {
                                pssGr23121_Step16.add(r.getP1_sGr23121M());
                            }
                            if ("OP".equalsIgnoreCase(r.getDecision_sGr23121_23122M())) {
                                pssGr23122_Step16.add(r.getP2_sGr23122M());
                            }
                        }
                    }
                    if ("Gr232".equalsIgnoreCase(r.getDecision_Gr231_232_233M())) {
                        pGr232_Step13.add(r.getP2_Gr232M());
                        Step17_sGr2321_2322 sGr2321_2322 = new Step17_sGr2321_2322(r);
                        sGr2321_2322.calculaDFsM();
                        r = sGr2321_2322.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: OIaMOR, OIcMOR 
                        if ("OIaMOR".equalsIgnoreCase(r.getDecision_sGr2321_2322M())) {
                            psGr2321_Step17.add(r.getP1_sGr2321M());
                        }
                        if ("OIcMOR".equalsIgnoreCase(r.getDecision_sGr2321_2322M())) {
                            psGr2322_Step17.add(r.getP2_sGr2322M());
                        }
                    }
                    if ("OIaOPcMOR".equalsIgnoreCase(r.getDecision_Gr231_232_233M())) {
                        pGr233_Step13.add(r.getP3_Gr233M());//Ya llegó a la  hoja: OIaOPcMOR                                        
                    }
                }

            }
            if ("SG3".equalsIgnoreCase(r.getDecision_SG1_2_3M())) {
                pSG3_Step2.add(r.getP1_SG1M());//sumar probab de muestras clasificadas como SG3
                Step18_MG31_32_33 MG31_32_33 = new Step18_MG31_32_33(r);
                MG31_32_33.calculaDFsM();
                r = MG31_32_33.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG31".equalsIgnoreCase(r.getDecision_MG31_32_33M())) {
                    pMG31_Step18.add(r.getP1_MG31M());
                    Step19_Gr311_312_313 Gr311_312_313 = new Step19_Gr311_312_313(r);
                    Gr311_312_313.calculaDFsM();
                    r = Gr311_312_313.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas:MOR, MORo, MORS
                    if ("MOR".equalsIgnoreCase(r.getDecision_Gr311_312_313M())) {
                        pGr311_Step19.add(r.getP1_Gr311M());//Ya llegó a la  hoja
                    }
                    if ("MORo".equalsIgnoreCase(r.getDecision_Gr311_312_313M())) {
                        pGr312_Step19.add(r.getP2_Gr312M());//Ya llegó a la  hoja
                    }
                    if ("MORS".equalsIgnoreCase(r.getDecision_Gr311_312_313M())) {
                        pGr313_Step19.add(r.getP3_Gr313M());//Ya llegó a la  hoja
                    }
                }
                //MG32 y MG33 Ya llegaron a sus hojas: MORcOI y MORFZ
                if ("MORcOI".equalsIgnoreCase(r.getDecision_MG31_32_33M())) {
                    pMG32_Step18.add(r.getP2_MG32M());
                }
                if ("MORFZ".equalsIgnoreCase(r.getDecision_MG31_32_33M())) {
                    pMG33_Step18.add(r.getP3_MG33M());
                }
            }
        }
        ///**************** RESUMEN hacer conteo por mayoría************      
        System.out.println("1a divisón");
        tablaResumen = new String[2][17];
        tablaResumen[0][1] = "SG1";
        tablaResumen[0][2] = "SG2";
        tablaResumen[0][3] = "SG3";
        tablaResumen[1][0] = String.valueOf(pSG1_Step2.size() + pSG2_Step2.size() + pSG3_Step2.size());
        tablaResumen[1][1] = String.valueOf(pSG1_Step2.size());
        tablaResumen[1][2] = String.valueOf(pSG2_Step2.size());
        tablaResumen[1][3] = String.valueOf(pSG3_Step2.size());
        int SG1=pSG1_Step2.size(), SG2=pSG2_Step2.size(), SG3=pSG3_Step2.size();
        if ((SG1 > SG2) && (SG1 > SG3)) {
            System.out.println("segunda divisón");
            //segunda división --SG1 es mayoría
            tablaResumen[0][4] = "MG11";
            tablaResumen[0][5] = "MG12";
            tablaResumen[0][6] = "MG13";
            int MG11 = pMG11_Step3.size(), MG12 = pMG12_Step3.size(), MG13 = pMG13_Step3.size();
            tablaResumen[1][4] = String.valueOf(MG11);
            tablaResumen[1][5] = String.valueOf(MG12);
            tablaResumen[1][6] = String.valueOf(MG13);
            if ((MG11 > MG12) && (MG11 > MG13)) {//3a Div --MG11 mayoría                               
                tablaResumen[0][7] = "Gr111";
                tablaResumen[0][8] = "Gr112";
                tablaResumen[0][9] = "Gr113";
                int Gr111 = pGr111_Step4.size(), Gr112 = pGr112_Step4.size(), Gr113 = pGr113_Step4.size();
                tablaResumen[1][7] = String.valueOf(Gr111);
                tablaResumen[1][8] = String.valueOf(Gr112);
                tablaResumen[1][9] = String.valueOf(Gr113);
                if ((Gr111 > Gr112) && (Gr111 > Gr113)) {//4a Div Gr111 mayoria                                   
                    tablaResumen[0][10] = "sGr1111";
                    tablaResumen[0][11] = "sGr1112";
                    tablaResumen[0][12] = "sGr1113";
                    int sGr1111 = psGr1111_Step5.size(), sGr1112 = psGr1112_Step5.size(), sGr1113 = psGr1113_Step5.size();
                    tablaResumen[1][10] = String.valueOf(sGr1111);
                    tablaResumen[1][11] = String.valueOf(sGr1112);
                    tablaResumen[1][12] = String.valueOf(sGr1113);
                    //desisión final 
                    if ((sGr1111 > sGr1112) && (sGr1111 > sGr1113)) {
                        tablaResumen[1][16] = "CA";
                    }
                    if ((sGr1112 > sGr1111) && (sGr1112 > sGr1113)) {
                        tablaResumen[1][16] = "CAE";
                    }
                    if ((sGr1113 > sGr1111) && (sGr1113 > sGr1112)) {
                        tablaResumen[1][16] = "CATC";
                    }
                } else if ((Gr112 > Gr111) && (Gr112 > Gr113)){
                    //cuarta división --Gr112 es mayoria
                    tablaResumen[0][10] = "sGr1121";
                    tablaResumen[0][11] = "sGr1122";
                    tablaResumen[1][10] = String.valueOf(psGr1121_Step6.size());
                    tablaResumen[1][11] = String.valueOf(psGr1122_Step6.size());
                    //desisión final 
                    if (psGr1121_Step6.size() > psGr1122_Step6.size()) {
                        tablaResumen[1][16] = "CARS";
                    } else {
                        tablaResumen[1][16] = "CATCaRS";
                    }
                } else {//cuarta división --Gr113 es mayoria 
                    tablaResumen[1][16] = "CBA";//ya llegó a la desisión final
                }
            }//OK revisado hasta aquí            
            else if  ((MG12 > MG11) && (MG12 > MG13)) {
                tablaResumen[0][7] = "Gr121";
                tablaResumen[0][8] = "Gr122";
                tablaResumen[1][7] = String.valueOf(pGr121_Step7.size());
                tablaResumen[1][8] = String.valueOf(pGr122_Step7.size());
                if (pGr121_Step7.size() > pGr122_Step7.size()) {//Gr121
                    tablaResumen[0][10] = "sGr1211";
                    tablaResumen[0][11] = "sGr1212";
                    tablaResumen[1][10] = String.valueOf(psGr1211_Step8.size());
                    tablaResumen[1][11] = String.valueOf(psGr1212_Step8.size());
                    //Ya llegó a las hojas: IA, IAE
                    if (psGr1211_Step8.size() > psGr1212_Step8.size()) {
                        tablaResumen[1][16] = "IA";
                    } else {
                        tablaResumen[1][16] = "IAE";
                    }
                } else {//Gr122
                    tablaResumen[0][10] = "sGr1221";
                    tablaResumen[0][11] = "sGr1222";
                    tablaResumen[1][10] = String.valueOf(psGr1221_Step9.size());
                    tablaResumen[1][11] = String.valueOf(psGr1222_Step9.size());
                    //Ya llegó a las hojas: IBA, IBAB
                    if (psGr1221_Step9.size() > psGr1222_Step9.size()) {
                        tablaResumen[1][16] = "IBA";
                    } else {
                        tablaResumen[1][16] = "IBAB";
                    }
                } 
            } else if ((MG13 > MG11) && (MG13 > MG12)) {//Ya llegó a la hoja: Col                
                tablaResumen[1][16] = "Col";
            }
        }        
            if ((SG2 > SG1) && (SG2 > SG3)) {//2a Div --SG2 es mayoría
                System.out.println("segunda divisón");
                //segunda división --SG1 es mayoría
                tablaResumen[0][4] = "MG21";
                tablaResumen[0][5] = "MG22";
                tablaResumen[0][6] = "MG23";
                tablaResumen[1][4] = String.valueOf(pMG21_Step10.size());
                tablaResumen[1][5] = String.valueOf(pMG22_Step10.size());
                tablaResumen[1][6] = String.valueOf(pMG23_Step10.size());
                if ((pMG21_Step10.size() > pMG22_Step10.size()) && (pMG21_Step10.size() > pMG23_Step10.size())) {//3a Div --MG21 es mayoría
                    tablaResumen[0][7] = "Gr211";
                    tablaResumen[0][8] = "Gr212";
                    tablaResumen[0][9] = "Gr213";
                    tablaResumen[1][7] = String.valueOf(p_Gr211_Step11.size());
                    tablaResumen[1][8] = String.valueOf(p_Gr212_Step11.size());
                    tablaResumen[1][9] = String.valueOf(p_Gr213_Step11.size());
                    //Ya llegó a las hojas: CBATC, CE, PCE
                    if ((p_Gr211_Step11.size() > p_Gr212_Step11.size()) && (p_Gr211_Step11.size() > p_Gr213_Step11.size())) {
                        tablaResumen[1][16] = "CBATC";
                    }
                    if ((p_Gr212_Step11.size() > p_Gr211_Step11.size()) && (p_Gr212_Step11.size() > p_Gr213_Step11.size())) {
                        tablaResumen[1][16] = "CE";
                    }
                    if ((p_Gr213_Step11.size() > p_Gr211_Step11.size()) && (p_Gr213_Step11.size() > p_Gr212_Step11.size())) {
                        tablaResumen[1][16] = "PCE";
                    }
                }
                if ((pMG22_Step10.size() > pMG21_Step10.size()) && (pMG22_Step10.size() > pMG23_Step10.size())) {//3a Div --MG22 es mayoría
                    tablaResumen[0][7] = "Gr221";
                    tablaResumen[0][8] = "Gr222";
                    tablaResumen[0][9] = "Gr223";
                    tablaResumen[1][7] = String.valueOf(pGr221_Step12.size());
                    tablaResumen[1][8] = String.valueOf(pGr222_Step12.size());
                    tablaResumen[1][9] = String.valueOf(pGr223_Step12.size());
                    //Ya llegó a las hojas : CR, CSSF, CRS
                    if ((pGr221_Step12.size() > pGr222_Step12.size()) && (pGr221_Step12.size() > pGr223_Step12.size())) {
                        tablaResumen[1][16] = "CR";
                    }
                    if ((pGr222_Step12.size() > pGr221_Step12.size()) && (pGr222_Step12.size() > pGr223_Step12.size())) {
                        tablaResumen[1][16] = "CSSF";
                    }
                    if ((pGr223_Step12.size() > pGr221_Step12.size()) && (pGr223_Step12.size() > pGr222_Step12.size())) {
                        tablaResumen[1][16] = "CRS";
                    }
                }
                if ((pMG23_Step10.size() > pMG21_Step10.size()) && (pMG23_Step10.size() > pMG22_Step10.size())) {//3a Div --MG23 es mayoría
                    tablaResumen[0][7] = "Gr231";
                    tablaResumen[0][8] = "Gr232";
                    tablaResumen[0][9] = "Gr233";
                    tablaResumen[1][7] = String.valueOf(pGr231_Step13.size());
                    tablaResumen[1][8] = String.valueOf(pGr232_Step13.size());
                    tablaResumen[1][9] = String.valueOf(pGr233_Step13.size());
                    if ((pGr231_Step13.size() > pGr232_Step13.size()) && (pGr231_Step13.size() > pGr233_Step13.size())) {//4a Div --Gr231
                        tablaResumen[0][10] = "sGr2311";
                        tablaResumen[0][11] = "sGr2312";
                        tablaResumen[1][10] = String.valueOf(psGr2311_Step14.size());
                        tablaResumen[1][11] = String.valueOf(psGr2312_Step14.size());
                        if (psGr2311_Step14.size() > psGr2312_Step14.size()) {//5a Div --sGr2311
                            tablaResumen[0][13] = "ssGr23111";
                            tablaResumen[0][14] = "ssGr23112";
                            tablaResumen[1][13] = String.valueOf(pssGr23111_Step15.size());
                            tablaResumen[1][14] = String.valueOf(pssGr23112_Step15.size());
                            if (pssGr23111_Step15.size() > pssGr23112_Step15.size()) {
                                tablaResumen[1][16] = "OI";
                            } else {
                                tablaResumen[1][16] = "OIcC";
                            }
                        }
                        if (psGr2312_Step14.size() > psGr2311_Step14.size()) {
                            tablaResumen[0][13] = "ssGr23121";
                            tablaResumen[0][14] = "ssGr23122";
                            tablaResumen[1][13] = String.valueOf(pssGr23121_Step16.size());
                            tablaResumen[1][14] = String.valueOf(pssGr23122_Step16.size());
                            //Ya llegó a las hojas: OIaOP, OP 
                            if (pssGr23121_Step16.size() > pssGr23122_Step16.size()) {
                                tablaResumen[1][16] = "OIaOP";
                            } else {
                                tablaResumen[1][16] = "OP";
                            }
                        }
                    }
                    if ((pGr232_Step13.size() > pGr231_Step13.size()) && (pGr232_Step13.size() > pGr233_Step13.size())) {//4a Div --Gr232 
                        tablaResumen[0][10] = "sGr2321";
                        tablaResumen[0][11] = "sGr2322";
                        tablaResumen[1][10] = String.valueOf(psGr2321_Step17.size());
                        tablaResumen[1][11] = String.valueOf(psGr2322_Step17.size());
                        //Ya llegó a las hojas: OIaMOR, OIcMOR 
                        if (psGr2321_Step17.size() > psGr2322_Step17.size()) {
                            tablaResumen[1][16] = "OIaMOR";
                        } else {
                            tablaResumen[1][16] = "OIcMOR";
                        }
                    }
                    if ((pGr233_Step13.size() > pGr231_Step13.size()) && (pGr233_Step13.size() > pGr232_Step13.size()))//4a Div --Gr233                    
                    //Ya llegó a la  hoja: OIaOPcMOR
                    {
                        tablaResumen[1][16] = "OIaOPcMOR";
                    }
                }

            }
            if ((pSG3_Step2.size() > pSG1_Step2.size()) && (pSG3_Step2.size() > pSG2_Step2.size())) {//2a Div --SG3 es mayoría
                System.out.println("segunda divisón");
                //segunda división --SG1 es mayoría
                tablaResumen[0][4] = "MG31";
                tablaResumen[0][5] = "MG32";
                tablaResumen[0][6] = "MG33";
                //i1, i2, i3 ponerlo en MT y correr nuevamente.. si funciona cambiar todo el programa
                int i1 = pMG31_Step18.size(), i2 = pMG32_Step18.size(), i3 = pMG33_Step18.size();
                tablaResumen[1][4] = String.valueOf(i1);
                tablaResumen[1][5] = String.valueOf(i2);
                tablaResumen[1][6] = String.valueOf(i3);
                //pero no pone la inferencia final
                //MG32 y MG33 Ya llegaron a sus hojas: MORcOI y MORFZ                              
                if ((i2 > i1) && (i2 > i3))//3a Div --MG31 es mayoría
                {
                    tablaResumen[1][16] = "MORcOI";
                }
                if ((i3 > i1) && (i3 > i2)) {
                    tablaResumen[1][16] = "MORFZ";
                }
                if ((i1 > i2) && (i1 > i3)) {//3a Div --MG31 es mayoría
                    //MG31
                    tablaResumen[0][7] = "Gr311";
                    tablaResumen[0][8] = "Gr312";
                    tablaResumen[0][9] = "Gr313";
                    i1 = pGr311_Step19.size();
                    i2 = pGr312_Step19.size();
                    i3 = pGr313_Step19.size();
                    tablaResumen[1][7] = String.valueOf(i1);
                    tablaResumen[1][8] = String.valueOf(i2);
                    tablaResumen[1][9] = String.valueOf(i3);
                    //Ya llegó a las hojas:MOR, MORo, MORS
                    if ((i1 > i2) && (i1 > i3)) {
                        tablaResumen[1][16] = "MOR";
                    }
                    if ((i2 > i1) && (i2 > i3)) {
                        tablaResumen[1][16] = "MORo";
                    }
                    if ((i3 > i2) && (i3 > i1)) {
                        tablaResumen[1][16] = "MORS";
                    }
                }//MG31
            }//SG3
            //if al final no se escribió nada en la inferencia final 
            if (tablaResumen[1][16] == null) {
                tablaResumen[1][16] = "Undefined";
            }

       
    }//método
    

    public void diagramMT() {
        ArrayList pSG1_Step2 = new ArrayList<Object>();
        ArrayList pSG2_Step2 = new ArrayList<Object>();
        ArrayList pSG3_Step2 = new ArrayList<Object>();
        ArrayList pMG11_Step3 = new ArrayList<Object>();
        ArrayList pMG12_Step3 = new ArrayList<Object>();
        ArrayList pMG13_Step3 = new ArrayList<Object>();

        ArrayList pGr111_Step4 = new ArrayList<Object>();
        ArrayList pGr112_Step4 = new ArrayList<Object>();
        ArrayList pGr113_Step4 = new ArrayList<Object>();

        ArrayList psGr1111_Step5 = new ArrayList<Object>();
        ArrayList psGr1112_Step5 = new ArrayList<Object>();
        ArrayList psGr1113_Step5 = new ArrayList<Object>();

        ArrayList psGr1121_Step6 = new ArrayList<Object>();
        ArrayList psGr1122_Step6 = new ArrayList<Object>();

        ArrayList pGr121_Step7 = new ArrayList<Object>();
        ArrayList pGr122_Step7 = new ArrayList<Object>();
        ArrayList psGr1211_Step8 = new ArrayList<Object>();
        ArrayList psGr1212_Step8 = new ArrayList<Object>();
        ArrayList psGr1221_Step9 = new ArrayList<Object>();
        ArrayList psGr1222_Step9 = new ArrayList<Object>();
        ArrayList pMG21_Step10 = new ArrayList<Object>();
        ArrayList pMG22_Step10 = new ArrayList<Object>();
        ArrayList pMG23_Step10 = new ArrayList<Object>();
        ArrayList p_Gr211_Step11 = new ArrayList<Object>();
        ArrayList p_Gr212_Step11 = new ArrayList<Object>();
        ArrayList p_Gr213_Step11 = new ArrayList<Object>();
        ArrayList pGr221_Step12 = new ArrayList<Object>();
        ArrayList pGr222_Step12 = new ArrayList<Object>();
        ArrayList pGr223_Step12 = new ArrayList<Object>();
        ArrayList pGr231_Step13 = new ArrayList<Object>();
        ArrayList pGr232_Step13 = new ArrayList<Object>();
        ArrayList pGr233_Step13 = new ArrayList<Object>();
        ArrayList psGr2311_Step14 = new ArrayList<Object>();
        ArrayList psGr2312_Step14 = new ArrayList<Object>();
        ArrayList pssGr23111_Step15 = new ArrayList<Object>();
        ArrayList pssGr23112_Step15 = new ArrayList<Object>();
        ArrayList pssGr23121_Step16 = new ArrayList<Object>();
        ArrayList pssGr23122_Step16 = new ArrayList<Object>();
        ArrayList psGr2321_Step17 = new ArrayList<Object>();
        ArrayList psGr2322_Step17 = new ArrayList<Object>();
        ArrayList pMG31_Step18 = new ArrayList<Object>();
        ArrayList pMG32_Step18 = new ArrayList<Object>();
        ArrayList pMG33_Step18 = new ArrayList<Object>();
        ArrayList pGr311_Step19 = new ArrayList<Object>();
        ArrayList pGr312_Step19 = new ArrayList<Object>();
        ArrayList pGr313_Step19 = new ArrayList<Object>();

        Columnas r = new Columnas();
        Step2_SG1_2_3 SG1_2_3;
        //queda pendiente declarar todos los objetos del árbol antes del ciclo y dentro solo terminar la instancia   
        for (int j = 0; j < tabla.size(); j++) {
            r = tabla.get(j);
            SG1_2_3 = new Step2_SG1_2_3(r);//diagrama nodo raíz
            SG1_2_3.calculaDFsMT();
            r = SG1_2_3.getR();//actualizo r con lo que fue calculado en el diagrama anterior
            if ("SG1".equalsIgnoreCase(r.getDecision_SG1_2_3MT())) {
                pSG1_Step2.add(r.getP1_SG1MT());//sumar probab de muestras clasificadas 
                Step3_MG11_12_13 MG11_12_13 = new Step3_MG11_12_13(r);
                MG11_12_13.calculaDFsMT();
                r = MG11_12_13.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG11".equalsIgnoreCase(r.getDecision_MG11_12_13MT())) {
                    pMG11_Step3.add(r.getP1_MG11MT());//sumar probab de muestras clasificadas    
                    Step4_Gr111_112_113 Gr111_112_113 = new Step4_Gr111_112_113(r);
                    Gr111_112_113.calculaDFsMT();
                    r = Gr111_112_113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr111".equalsIgnoreCase(r.getDecision_Gr111_112_113MT())) {
                        pGr111_Step4.add(r.getP1_Gr111MT());//sumar probab de muestras clasificadas 
                        Step5_sGr1111_1112_1113 sGr1111_1112_1113 = new Step5_sGr1111_1112_1113(r);
                        sGr1111_1112_1113.calculaDFsMT();
                        r = sGr1111_1112_1113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CA, CAE,CATC
                        if ("CA".equalsIgnoreCase(r.getDecision_sGr1111_1112_1113MT())) {
                            psGr1111_Step5.add(r.getP1_sGr1111MT());//sumar probab de muestras clasificadas     
                        }
                        if ("CAE".equalsIgnoreCase(r.getDecision_sGr1111_1112_1113MT())) {
                            psGr1112_Step5.add(r.getP2_sGr1112MT());//sumar probab de muestras clasificadas
                        }
                        if ("CATC".equalsIgnoreCase(r.getDecision_sGr1111_1112_1113MT())) {
                            psGr1113_Step5.add(r.getP3_sGr1113MT());//sumar probab de muestras clasificadas                                             
                        }
                    }
                    if ("Gr112".equalsIgnoreCase(r.getDecision_Gr111_112_113MT())) {
                        pGr112_Step4.add(r.getP2_Gr112MT());//sumar probab de muestras clasificadas 
                        Step6_sGr1121_1122 sGr1121_1122 = new Step6_sGr1121_1122(r);
                        sGr1121_1122.calculaDFsMT();
                        r = sGr1121_1122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CARS, CATCaRS                       
                        if ("CARS".equalsIgnoreCase(r.getDecision_sGr1121_1122MT())) {
                            psGr1121_Step6.add(r.getP1_sGr1121MT());//sumar probab de muestras clasificadas     
                        }
                        if ("CATCaRS".equalsIgnoreCase(r.getDecision_sGr1121_1122MT())) {
                            psGr1122_Step6.add(r.getP2_sGr1122MT());//sumar probab de muestras clasificadas  
                        }
                    }
                    if ("CBA".equalsIgnoreCase(r.getDecision_Gr111_112_113MT())) {
                        pGr113_Step4.add(r.getP3_Gr113MT());//sumar probab de muestras clasificadas 
                    }
                }
                if ("MG12".equalsIgnoreCase(r.getDecision_MG11_12_13MT())) {
                    pMG12_Step3.add(r.getP2_MG12MT());//sumar probab de muestras clasificadas 
                    Step7_Gr121_122 Gr121_122 = new Step7_Gr121_122(r);
                    Gr121_122.calculaDFsMT();
                    r = Gr121_122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr121".equalsIgnoreCase(r.getDecision_Gr121_122MT())) {
                        pGr121_Step7.add(r.getP1_Gr121MT());//sumar probab de muestras clasificadas   
                        Step8_sGr1211_1212 sGr1211_1212 = new Step8_sGr1211_1212(r);
                        sGr1211_1212.calculaDFsMT();
                        r = sGr1211_1212.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IA, IAE
                        if ("IA".equalsIgnoreCase(r.getDecision_sGr1211_1212MT())) {
                            psGr1211_Step8.add(r.getP1_sGr1211MT());//sumar probab de muestras clasificadas 
                        }
                        if ("IAE".equalsIgnoreCase(r.getDecision_sGr1211_1212MT())) {
                            psGr1212_Step8.add(r.getP2_sGr1212MT());//sumar probab de muestras clasificadas
                        }
                    }
                    if ("Gr122".equalsIgnoreCase(r.getDecision_Gr121_122MT())) {
                        pGr122_Step7.add(r.getP2_Gr122MT());//sumar probab de muestras clasificadas   
                        Step9_sGr1221_1222 sGr1221_1222 = new Step9_sGr1221_1222(r);
                        sGr1221_1222.calculaDFsMT();
                        r = sGr1221_1222.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IBA, IBAB
                        if ("IBA".equalsIgnoreCase(r.getDecision_sGr1221_1222MT())) {
                            psGr1221_Step9.add(r.getP1_sGr1221MT());//sumar probab de muestras clasificadas         
                        }
                        if ("IBAB".equalsIgnoreCase(r.getDecision_sGr1221_1222MT())) {
                            psGr1222_Step9.add(r.getP2_sGr1222MT());//sumar probab de muestras clasificadas  
                        }
                    }
                }
                if ("Col".equalsIgnoreCase(r.getDecision_MG11_12_13MT())) {
                    pMG13_Step3.add(r.getP3_MG13MT());//sumar probab de muestras clasificadas                 
                }
            }
            if ("SG2".equalsIgnoreCase(r.getDecision_SG1_2_3MT())) {
                pSG2_Step2.add(r.getP1_SG1MT());//sumar probab de muestras clasificadas como SG2
                Step10_MG21_22_23 MG21_22_23 = new Step10_MG21_22_23(r);
                MG21_22_23.calculaDFsMT();
                r = MG21_22_23.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG21".equalsIgnoreCase(r.getDecision_MG21_22_23MT())) {
                    pMG21_Step10.add(r.getP1_MG21MT());
                    Step11_Gr211_212_213 Gr211_212_213 = new Step11_Gr211_212_213(r);
                    Gr211_212_213.calculaDFsMT();
                    r = Gr211_212_213.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas: CBATC, CE, PCE
                    if ("CBATC".equalsIgnoreCase(r.getDecision_Gr211_212_213MT())) {
                        p_Gr211_Step11.add(r.getP1_Gr211MT());
                    }
                    if ("CE".equalsIgnoreCase(r.getDecision_Gr211_212_213MT())) {
                        p_Gr212_Step11.add(r.getP2_Gr212MT());
                    }
                    if ("PCE".equalsIgnoreCase(r.getDecision_Gr211_212_213MT())) {
                        p_Gr213_Step11.add(r.getP3_Gr213MT());
                    }
                }
                if ("MG22".equalsIgnoreCase(r.getDecision_MG21_22_23MT())) {
                    pMG22_Step10.add(r.getP2_MG22MT());
                    Step12_Gr221_222_223 Gr221_222_223 = new Step12_Gr221_222_223(r);
                    Gr221_222_223.calculaDFsMT();
                    r = Gr221_222_223.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas : CR, CSSF, CRS
                    if ("CR".equalsIgnoreCase(r.getDecision_Gr221_222_223MT())) {
                        pGr221_Step12.add(r.getP1_Gr221MT());
                    }
                    if ("CSSF".equalsIgnoreCase(r.getDecision_Gr221_222_223M())) {
                        pGr222_Step12.add(r.getP2_Gr222MT());
                    }
                    if ("CRS".equalsIgnoreCase(r.getDecision_Gr221_222_223M())) {
                        pGr223_Step12.add(r.getP3_Gr223MT());
                    }
                }
                if ("MG23".equalsIgnoreCase(r.getDecision_MG21_22_23MT())) {
                    pMG23_Step10.add(r.getP3_MG23MT());
                    Step13_Gr231_232_233 Gr231_232_233 = new Step13_Gr231_232_233(r);
                    Gr231_232_233.calculaDFsMT();
                    r = Gr231_232_233.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr231".equalsIgnoreCase(r.getDecision_Gr231_232_233MT())) {
                        pGr231_Step13.add(r.getP1_Gr231MT());
                        Step14_sGr2311_2312 sGr2311_2312 = new Step14_sGr2311_2312(r);
                        sGr2311_2312.calculaDFsMT();
                        r = sGr2311_2312.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        if ("sGr2311".equalsIgnoreCase(r.getDecision_sGr2311_2312MT())) {
                            psGr2311_Step14.add(r.getP1_sGr2311MT());
                            Step15_ssGr23111_23112 sGr23111_23112 = new Step15_ssGr23111_23112(r);
                            sGr23111_23112.calculaDFsMT();
                            r = sGr23111_23112.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OI, OIcC
                            if ("OI".equalsIgnoreCase(r.getDecision_sGr23111_23112MT())) {
                                pssGr23111_Step15.add(r.getP1_sGr23111MT());
                            }
                            if ("OIcC".equalsIgnoreCase(r.getDecision_sGr23111_23112MT())) {
                                pssGr23112_Step15.add(r.getP2_sGr23112MT());
                            }
                        }
                        if ("sGr2312".equalsIgnoreCase(r.getDecision_sGr2311_2312MT())) {
                            psGr2312_Step14.add(r.getP2_sGr2312MT());
                            Step16_ssGr23121_23122 sGr23121_23122 = new Step16_ssGr23121_23122(r);
                            sGr23121_23122.calculaDFsMT();
                            r = sGr23121_23122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OIaOP, OP    
                            if ("OIaOP".equalsIgnoreCase(r.getDecision_sGr23121_23122MT())) {
                                pssGr23121_Step16.add(r.getP1_sGr23121MT());
                            }
                            if ("OP".equalsIgnoreCase(r.getDecision_sGr23121_23122MT())) {
                                pssGr23122_Step16.add(r.getP2_sGr23122MT());
                            }
                        }
                    }
                    if ("Gr232".equalsIgnoreCase(r.getDecision_Gr231_232_233MT())) {
                        pGr232_Step13.add(r.getP2_Gr232MT());
                        Step17_sGr2321_2322 sGr2321_2322 = new Step17_sGr2321_2322(r);
                        sGr2321_2322.calculaDFsMT();
                        r = sGr2321_2322.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: OIaMOR, OIcMOR 
                        if ("OIaMOR".equalsIgnoreCase(r.getDecision_sGr2321_2322MT())) {
                            psGr2321_Step17.add(r.getP1_sGr2321MT());
                        }
                        if ("OIcMOR".equalsIgnoreCase(r.getDecision_sGr2321_2322MT())) {
                            psGr2322_Step17.add(r.getP2_sGr2322MT());
                        }
                    }
                    if ("OIaOPcMOR".equalsIgnoreCase(r.getDecision_Gr231_232_233MT())) {
                        pGr233_Step13.add(r.getP3_Gr233MT());//Ya llegó a la  hoja: OIaOPcMOR                                        
                    }
                }

            }
            if ("SG3".equalsIgnoreCase(r.getDecision_SG1_2_3MT())) {
                pSG3_Step2.add(r.getP1_SG1MT());//sumar probab de muestras clasificadas como SG3
                Step18_MG31_32_33 MG31_32_33 = new Step18_MG31_32_33(r);
                MG31_32_33.calculaDFsMT();
                r = MG31_32_33.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG31".equalsIgnoreCase(r.getDecision_MG31_32_33MT())) {
                    pMG31_Step18.add(r.getP1_MG31MT());
                    Step19_Gr311_312_313 Gr311_312_313 = new Step19_Gr311_312_313(r);
                    Gr311_312_313.calculaDFsMT();
                    r = Gr311_312_313.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas:MOR, MORo, MORS
                    if ("MOR".equalsIgnoreCase(r.getDecision_Gr311_312_313MT())) {
                        pGr311_Step19.add(r.getP1_Gr311MT());//Ya llegó a la  hoja
                    }
                    if ("MORo".equalsIgnoreCase(r.getDecision_Gr311_312_313MT())) {
                        pGr312_Step19.add(r.getP2_Gr312MT());//Ya llegó a la  hoja
                    }
                    if ("MORS".equalsIgnoreCase(r.getDecision_Gr311_312_313MT())) {
                        pGr313_Step19.add(r.getP3_Gr313MT());//Ya llegó a la  hoja
                    }
                }
                //MG32 y MG33 Ya llegaron a sus hojas: MORcOI y MORFZ
                if ("MORcOI".equalsIgnoreCase(r.getDecision_MG31_32_33MT())) {
                    pMG32_Step18.add(r.getP2_MG32MT());
                }
                if ("MORFZ".equalsIgnoreCase(r.getDecision_MG31_32_33MT())) {
                    pMG33_Step18.add(r.getP3_MG33MT());
                }
            }
        }
        ///**************** ahora hacer conteo por mayoría************      

        System.out.println("1a divisón");
        tablaResumen = new String[2][17];
        tablaResumen[0][1] = "SG1";
        tablaResumen[0][2] = "SG2";
        tablaResumen[0][3] = "SG3";
        tablaResumen[1][0] = String.valueOf(pSG1_Step2.size() + pSG2_Step2.size() + pSG3_Step2.size());
        tablaResumen[1][1] = String.valueOf(pSG1_Step2.size());
        tablaResumen[1][2] = String.valueOf(pSG2_Step2.size());
        tablaResumen[1][3] = String.valueOf(pSG3_Step2.size());
        if ((pSG1_Step2.size() > pSG2_Step2.size()) && (pSG1_Step2.size() > pSG3_Step2.size())) {
            System.out.println("segunda divisón");
            //segunda división --SG1 es mayoría
            tablaResumen[0][4] = "MG11";
            tablaResumen[0][5] = "MG12";
            tablaResumen[0][6] = "MG13";
            tablaResumen[1][4] = String.valueOf(pMG11_Step3.size());
            tablaResumen[1][5] = String.valueOf(pMG12_Step3.size());
            tablaResumen[1][6] = String.valueOf(pMG13_Step3.size());
            if ((pMG11_Step3.size() > pMG12_Step3.size()) && (pMG11_Step3.size() > pMG13_Step3.size())) {//3a Div --MG11 mayoría                               
                tablaResumen[0][7] = "Gr111";
                tablaResumen[0][8] = "Gr112";
                tablaResumen[0][9] = "Gr113";
                tablaResumen[1][7] = String.valueOf(pGr111_Step4.size());
                tablaResumen[1][8] = String.valueOf(pGr112_Step4.size());
                tablaResumen[1][9] = String.valueOf(pGr113_Step4.size());
                if ((pGr111_Step4.size() > pGr112_Step4.size()) && (pGr111_Step4.size() > pGr113_Step4.size())) {//4a Div Gr111 mayoria                                   
                    tablaResumen[0][10] = "sGr1111";
                    tablaResumen[0][11] = "sGr1112";
                    tablaResumen[0][12] = "sGr1113";
                    tablaResumen[1][10] = String.valueOf(psGr1111_Step5.size());
                    tablaResumen[1][11] = String.valueOf(psGr1112_Step5.size());
                    tablaResumen[1][12] = String.valueOf(psGr1113_Step5.size());
                    //desisión final 
                    if ((psGr1111_Step5.size() > psGr1112_Step5.size()) && (psGr1111_Step5.size() > psGr1113_Step5.size())) {
                        tablaResumen[1][16] = "CA";
                    }
                    if ((psGr1112_Step5.size() > psGr1111_Step5.size()) && (psGr1112_Step5.size() > psGr1113_Step5.size())) {
                        tablaResumen[1][16] = "CAE";
                    }
                    if ((psGr1113_Step5.size() > psGr1111_Step5.size()) && (psGr1113_Step5.size() > psGr1112_Step5.size())) {
                        tablaResumen[1][16] = "CATC";
                    }
                } else if ((pGr112_Step4.size() > pGr111_Step4.size()) && (pGr112_Step4.size() > pGr113_Step4.size())) {
                    //cuarta división --Gr112 es mayoria
                    tablaResumen[0][10] = "sGr1121";
                    tablaResumen[0][11] = "sGr1122";
                    tablaResumen[1][10] = String.valueOf(psGr1121_Step6.size());
                    tablaResumen[1][11] = String.valueOf(psGr1122_Step6.size());
                    //desisión final 
                    if (psGr1121_Step6.size() > psGr1122_Step6.size()) {
                        tablaResumen[1][16] = "CARS";
                    } else {
                        tablaResumen[1][16] = "CATCaRS";
                    }
                } else {//cuarta división --Gr113 es mayoria 
                    tablaResumen[1][16] = "CBA";//ya llegó a la desisión final
                }
            }//OK revisado hasta aquí
            else if ((pMG12_Step3.size() > pMG11_Step3.size()) && (pMG12_Step3.size() > pMG13_Step3.size())) {
                tablaResumen[0][7] = "Gr121";
                tablaResumen[0][8] = "Gr122";
                tablaResumen[1][7] = String.valueOf(pGr121_Step7.size());
                tablaResumen[1][8] = String.valueOf(pGr122_Step7.size());
                if (pGr121_Step7.size() > pGr122_Step7.size()) {//Gr121
                    tablaResumen[0][10] = "sGr1211";
                    tablaResumen[0][11] = "sGr1212";
                    tablaResumen[1][10] = String.valueOf(psGr1211_Step8.size());
                    tablaResumen[1][11] = String.valueOf(psGr1212_Step8.size());
                    //Ya llegó a las hojas: IA, IAE
                    if (psGr1211_Step8.size() > psGr1212_Step8.size()) {
                        tablaResumen[1][16] = "IA";
                    } else {
                        tablaResumen[1][16] = "IAE";
                    }
                } else {//Gr122
                    tablaResumen[0][10] = "sGr1221";
                    tablaResumen[0][11] = "sGr1222";
                    tablaResumen[1][10] = String.valueOf(psGr1221_Step9.size());
                    tablaResumen[1][11] = String.valueOf(psGr1222_Step9.size());
                    //Ya llegó a las hojas: IBA, IBAB
                    if (psGr1221_Step9.size() > psGr1222_Step9.size()) {
                        tablaResumen[1][16] = "IA";
                    } else {
                        tablaResumen[1][16] = "IBAB";
                    }
                }
            } else //Ya llegó a la hoja: Col
            {
                tablaResumen[1][16] = "Col";
            }
        }
        if ((pSG2_Step2.size() > pSG1_Step2.size()) && (pSG2_Step2.size() > pSG3_Step2.size())) {//2a Div --SG2 es mayoría
            System.out.println("segunda divisón");
            //segunda división --SG1 es mayoría
            tablaResumen[0][4] = "MG21";
            tablaResumen[0][5] = "MG22";
            tablaResumen[0][6] = "MG23";
            tablaResumen[1][4] = String.valueOf(pMG21_Step10.size());
            tablaResumen[1][5] = String.valueOf(pMG22_Step10.size());
            tablaResumen[1][6] = String.valueOf(pMG23_Step10.size());
            if ((pMG21_Step10.size() > pMG22_Step10.size()) && (pMG21_Step10.size() > pMG23_Step10.size())) {//3a Div --MG21 es mayoría
                tablaResumen[0][7] = "Gr211";
                tablaResumen[0][8] = "Gr212";
                tablaResumen[0][9] = "Gr213";
                tablaResumen[1][7] = String.valueOf(p_Gr211_Step11.size());
                tablaResumen[1][8] = String.valueOf(p_Gr212_Step11.size());
                tablaResumen[1][9] = String.valueOf(p_Gr213_Step11.size());
                //Ya llegó a las hojas: CBATC, CE, PCE
                if ((p_Gr211_Step11.size() > p_Gr212_Step11.size()) && (p_Gr211_Step11.size() > p_Gr213_Step11.size())) {
                    tablaResumen[1][16] = "CBATC";
                }
                if ((p_Gr212_Step11.size() > p_Gr211_Step11.size()) && (p_Gr212_Step11.size() > p_Gr213_Step11.size())) {
                    tablaResumen[1][16] = "CE";
                }
                if ((p_Gr213_Step11.size() > p_Gr211_Step11.size()) && (p_Gr213_Step11.size() > p_Gr212_Step11.size())) {
                    tablaResumen[1][16] = "PCE";
                }
            }
            if ((pMG22_Step10.size() > pMG21_Step10.size()) && (pMG22_Step10.size() > pMG23_Step10.size())) {//3a Div --MG22 es mayoría
                tablaResumen[0][7] = "Gr221";
                tablaResumen[0][8] = "Gr222";
                tablaResumen[0][9] = "Gr223";
                tablaResumen[1][7] = String.valueOf(pGr221_Step12.size());
                tablaResumen[1][8] = String.valueOf(pGr222_Step12.size());
                tablaResumen[1][9] = String.valueOf(pGr223_Step12.size());
                //Ya llegó a las hojas : CR, CSSF, CRS
                if ((pGr221_Step12.size() > pGr222_Step12.size()) && (pGr221_Step12.size() > pGr223_Step12.size())) {
                    tablaResumen[1][16] = "CR";
                }
                if ((pGr222_Step12.size() > pGr221_Step12.size()) && (pGr222_Step12.size() > pGr223_Step12.size())) {
                    tablaResumen[1][16] = "CSSF";
                }
                if ((pGr223_Step12.size() > pGr221_Step12.size()) && (pGr223_Step12.size() > pGr222_Step12.size())) {
                    tablaResumen[1][16] = "CRS";
                }
            }
            if ((pMG23_Step10.size() > pMG21_Step10.size()) && (pMG23_Step10.size() > pMG22_Step10.size())) {//3a Div --MG23 es mayoría
                tablaResumen[0][7] = "Gr231";
                tablaResumen[0][8] = "Gr232";
                tablaResumen[0][9] = "Gr233";
                tablaResumen[1][7] = String.valueOf(pGr231_Step13.size());
                tablaResumen[1][8] = String.valueOf(pGr232_Step13.size());
                tablaResumen[1][9] = String.valueOf(pGr233_Step13.size());
                if ((pGr231_Step13.size() > pGr232_Step13.size()) && (pGr231_Step13.size() > pGr233_Step13.size())) {//4a Div --Gr231
                    tablaResumen[0][10] = "sGr2311";
                    tablaResumen[0][11] = "sGr2312";
                    tablaResumen[1][10] = String.valueOf(psGr2311_Step14.size());
                    tablaResumen[1][11] = String.valueOf(psGr2312_Step14.size());
                    if (psGr2311_Step14.size() > psGr2312_Step14.size()) {//5a Div --sGr2311
                        tablaResumen[0][13] = "ssGr23111";
                        tablaResumen[0][14] = "ssGr23112";
                        tablaResumen[1][13] = String.valueOf(pssGr23111_Step15.size());
                        tablaResumen[1][14] = String.valueOf(pssGr23112_Step15.size());
                        if (pssGr23111_Step15.size() > pssGr23112_Step15.size()) {
                            tablaResumen[1][16] = "OI";
                        } else {
                            tablaResumen[1][16] = "OIcC";
                        }
                    }
                    if (psGr2312_Step14.size() > psGr2311_Step14.size()) {
                        tablaResumen[0][13] = "ssGr23121";
                        tablaResumen[0][14] = "ssGr23122";
                        tablaResumen[1][13] = String.valueOf(pssGr23121_Step16.size());
                        tablaResumen[1][14] = String.valueOf(pssGr23122_Step16.size());
                        //Ya llegó a las hojas: OIaOP, OP 
                        if (pssGr23121_Step16.size() > pssGr23122_Step16.size()) {
                            tablaResumen[1][16] = "OIaOP";
                        } else {
                            tablaResumen[1][16] = "OP";
                        }
                    }
                }
                if ((pGr232_Step13.size() > pGr231_Step13.size()) && (pGr232_Step13.size() > pGr233_Step13.size())) {//4a Div --Gr232 
                    tablaResumen[0][10] = "sGr2321";
                    tablaResumen[0][11] = "sGr2322";
                    tablaResumen[1][10] = String.valueOf(psGr2321_Step17.size());
                    tablaResumen[1][11] = String.valueOf(psGr2322_Step17.size());
                    //Ya llegó a las hojas: OIaMOR, OIcMOR 
                    if (psGr2321_Step17.size() > psGr2322_Step17.size()) {
                        tablaResumen[1][16] = "OIaMOR";
                    } else {
                        tablaResumen[1][16] = "OIcMOR";
                    }
                }
                if ((pGr233_Step13.size() > pGr231_Step13.size()) && (pGr233_Step13.size() > pGr232_Step13.size()))//4a Div --Gr233                    
                //Ya llegó a la  hoja: OIaOPcMOR
                {
                    tablaResumen[1][16] = "OIaOPcMOR";
                }
            }

        }
        if ((pSG3_Step2.size() > pSG1_Step2.size()) && (pSG3_Step2.size() > pSG2_Step2.size())) {//2a Div --SG3 es mayoría
            System.out.println("segunda divisón");
            //segunda división --SG1 es mayoría
            tablaResumen[0][4] = "MG31";
            tablaResumen[0][5] = "MG32";
            tablaResumen[0][6] = "MG33";
            tablaResumen[1][4] = String.valueOf(pMG31_Step18.size());
            tablaResumen[1][5] = String.valueOf(pMG32_Step18.size());
            tablaResumen[1][6] = String.valueOf(pMG33_Step18.size());
            if ((pMG31_Step18.size() > pMG32_Step18.size()) && (pMG31_Step18.size() > pMG33_Step18.size())) {//3a Div --MG31 es mayoría
                tablaResumen[0][7] = "Gr311";
                tablaResumen[0][8] = "Gr312";
                tablaResumen[0][9] = "Gr313";
                tablaResumen[1][7] = String.valueOf(pGr311_Step19.size());
                tablaResumen[1][8] = String.valueOf(pGr312_Step19.size());
                tablaResumen[1][9] = String.valueOf(pGr313_Step19.size());
                //Ya llegó a las hojas:MOR, MORo, MORS
                if ((pGr311_Step19.size() > pGr312_Step19.size()) && (pGr311_Step19.size() > pGr313_Step19.size())) {
                    tablaResumen[1][16] = "MOR";
                }
                if ((pGr312_Step19.size() > pGr311_Step19.size()) && (pGr312_Step19.size() > pGr313_Step19.size())) {
                    tablaResumen[1][16] = "MORo";
                }
                if ((pGr313_Step19.size() > pGr312_Step19.size()) && (pGr313_Step19.size() > pGr311_Step19.size())) {
                    tablaResumen[1][16] = "MORS";
                }
            } //MG32 y MG33 Ya llegaron a sus hojas: MORcOI y MORFZ
            else if ((pMG32_Step18.size() > pMG31_Step18.size()) && (pMG32_Step18.size() > pMG33_Step18.size()))//3a Div --MG31 es mayoría
            {
                tablaResumen[1][16] = "MORcOI";
            } else if ((pMG33_Step18.size() > pMG31_Step18.size()) && (pMG33_Step18.size() > pMG32_Step18.size())) {
                tablaResumen[1][16] = "MORFZ";
            }
        }
        //if al final no se escribió nada en la inferencia final 
        if (tablaResumen[1][16] == null) {
            tablaResumen[1][16] = "Undefined";
        }

//++imprimir tabla
        System.out.println("debería imprimir la tabla a continuación:");
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 16; j++) {
                if (tablaResumen[i][j] != null) {
                    System.out.print(i + " " + j + ": " + tablaResumen[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }

    public void diagramMsinTablaResumen() {

        Columnas r = new Columnas();
        Step2_SG1_2_3 SG1_2_3;
        //queda pendiente declarar todos los objetos del árbol antes del ciclo y dentro solo terminar la instancia   
        for (int j = 0; j < tabla.size(); j++) {
            r = tabla.get(j);
            SG1_2_3 = new Step2_SG1_2_3(r);//diagrama nodo raíz
            SG1_2_3.calculaDFsM();
            r = SG1_2_3.getR();//actualizo r con lo que fue calculado en el diagrama anterior
            //double p1, p2, p3;//después mejoraré las condiciones, que se basen en probabilides y no en cadenas
            //p1=r.getP1_SG1M();             p1=r.getP2_SG2M();            p3=r.getP3_SG3M();

            if ("SG1".equalsIgnoreCase(r.getDecision_SG1_2_3M())) {
                Step3_MG11_12_13 MG11_12_13 = new Step3_MG11_12_13(r);
                MG11_12_13.calculaDFsM();
                r = MG11_12_13.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG11".equalsIgnoreCase(r.getDecision_MG11_12_13M())) {
                    Step4_Gr111_112_113 Gr111_112_113 = new Step4_Gr111_112_113(r);
                    Gr111_112_113.calculaDFsM();
                    r = Gr111_112_113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr111".equalsIgnoreCase(r.getDecision_Gr111_112_113M())) {
                        Step5_sGr1111_1112_1113 sGr1111_1112_1113 = new Step5_sGr1111_1112_1113(r);
                        sGr1111_1112_1113.calculaDFsM();
                        r = sGr1111_1112_1113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CA, CAE,CATC                                            
                    }
                    if ("Gr112".equalsIgnoreCase(r.getDecision_Gr111_112_113M())) {
                        Step6_sGr1121_1122 sGr1121_1122 = new Step6_sGr1121_1122(r);
                        sGr1121_1122.calculaDFsM();
                        r = sGr1121_1122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CARS, CATCaRS     
                    }
                    //if ("CBA".equalsIgnoreCase(r.getDecision_Gr111_112_113M()))
                    //Ya llegó a una hoja Col                  

                }
                if ("MG12".equalsIgnoreCase(r.getDecision_MG11_12_13M())) {
                    Step7_Gr121_122 Gr121_122 = new Step7_Gr121_122(r);
                    Gr121_122.calculaDFsM();
                    r = Gr121_122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr121".equalsIgnoreCase(r.getDecision_Gr121_122M())) {
                        Step8_sGr1211_1212 sGr1211_1212 = new Step8_sGr1211_1212(r);
                        sGr1211_1212.calculaDFsM();
                        r = sGr1211_1212.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IA, IAE
                    }
                    if ("Gr122".equalsIgnoreCase(r.getDecision_Gr121_122M())) {
                        Step9_sGr1221_1222 sGr1221_1222 = new Step9_sGr1221_1222(r);
                        sGr1221_1222.calculaDFsM();
                        r = sGr1221_1222.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IBA, IBAB
                    }
                }

            }
            if ("SG2".equalsIgnoreCase(r.getDecision_SG1_2_3M())) {
                Step10_MG21_22_23 MG21_22_23 = new Step10_MG21_22_23(r);
                MG21_22_23.calculaDFsM();
                r = MG21_22_23.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG21".equalsIgnoreCase(r.getDecision_MG21_22_23M())) {
                    Step11_Gr211_212_213 Gr211_212_213 = new Step11_Gr211_212_213(r);
                    Gr211_212_213.calculaDFsM();
                    r = Gr211_212_213.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas: CBATC, CE, PCE
                }
                if ("MG22".equalsIgnoreCase(r.getDecision_MG21_22_23M())) {
                    Step12_Gr221_222_223 Gr221_222_223 = new Step12_Gr221_222_223(r);
                    Gr221_222_223.calculaDFsM();
                    r = Gr221_222_223.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas : CR, CSSF, CRS
                }
                if ("MG23".equalsIgnoreCase(r.getDecision_MG21_22_23M())) {
                    Step13_Gr231_232_233 Gr231_232_233 = new Step13_Gr231_232_233(r);
                    Gr231_232_233.calculaDFsM();
                    r = Gr231_232_233.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr231".equalsIgnoreCase(r.getDecision_Gr231_232_233M())) {
                        Step14_sGr2311_2312 sGr2311_2312 = new Step14_sGr2311_2312(r);
                        sGr2311_2312.calculaDFsM();
                        r = sGr2311_2312.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        if ("sGr2311".equalsIgnoreCase(r.getDecision_sGr2311_2312M())) {
                            Step15_ssGr23111_23112 sGr23111_23112 = new Step15_ssGr23111_23112(r);
                            sGr23111_23112.calculaDFsM();
                            r = sGr23111_23112.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OI, OIcC
                        }
                        if ("sGr2312".equalsIgnoreCase(r.getDecision_sGr2311_2312M())) {
                            Step16_ssGr23121_23122 sGr23121_23122 = new Step16_ssGr23121_23122(r);
                            sGr23121_23122.calculaDFsM();
                            r = sGr23121_23122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OIaOP, OP  
                        }
                    }
                    if ("Gr232".equalsIgnoreCase(r.getDecision_Gr231_232_233M())) {
                        Step17_sGr2321_2322 sGr2321_2322 = new Step17_sGr2321_2322(r);
                        sGr2321_2322.calculaDFsM();
                        r = sGr2321_2322.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: OIaMOR, OIcMOR 
                    }
                }

            }
            if ("SG3".equalsIgnoreCase(r.getDecision_SG1_2_3M())) {
                Step18_MG31_32_33 MG31_32_33 = new Step18_MG31_32_33(r);
                MG31_32_33.calculaDFsM();
                r = MG31_32_33.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG31".equalsIgnoreCase(r.getDecision_MG31_32_33M())) {
                    Step19_Gr311_312_313 Gr311_312_313 = new Step19_Gr311_312_313(r);
                    Gr311_312_313.calculaDFsM();
                    r = Gr311_312_313.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas:MOR, MORo, MORS
                }
                //MG32 y MG33 Ya llegaron a sus hojas: MORcOI y MORFZ
            }
        }
        ///**************** ahora hacer conteo por mayoría************      

    }

    public void diagramMTsinTablaResumen() {
        Columnas r = new Columnas();
        Step2_SG1_2_3 SG1_2_3;
        //queda pendiente declarar todos los objetos del árbol antes del ciclo y dentro solo terminar la instancia   
        for (int j = 0; j < tabla.size(); j++) {
            r = tabla.get(j);
            SG1_2_3 = new Step2_SG1_2_3(r);//diagrama nodo raíz
            SG1_2_3.calculaDFsMT();
            r = SG1_2_3.getR();//actualizo r con lo que fue calculado en el diagrama anterior
            if ("SG1".equalsIgnoreCase(r.getDecision_SG1_2_3MT())) {
                Step3_MG11_12_13 MG11_12_13 = new Step3_MG11_12_13(r);
                MG11_12_13.calculaDFsMT();
                r = MG11_12_13.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG11".equalsIgnoreCase(r.getDecision_MG11_12_13MT())) {
                    Step4_Gr111_112_113 Gr111_112_113 = new Step4_Gr111_112_113(r);
                    Gr111_112_113.calculaDFsMT();
                    r = Gr111_112_113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr111".equalsIgnoreCase(r.getDecision_Gr111_112_113MT())) {
                        Step5_sGr1111_1112_1113 sGr1111_1112_1113 = new Step5_sGr1111_1112_1113(r);
                        sGr1111_1112_1113.calculaDFsMT();
                        r = sGr1111_1112_1113.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CA, CAE,CATC                                            
                    }
                    if ("Gr112".equalsIgnoreCase(r.getDecision_Gr111_112_113MT())) {
                        Step6_sGr1121_1122 sGr1121_1122 = new Step6_sGr1121_1122(r);
                        sGr1121_1122.calculaDFsMT();
                        r = sGr1121_1122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: CARS, CATCaRS            
                    }

                }
                if ("MG12".equalsIgnoreCase(r.getDecision_MG11_12_13MT())) {
                    Step7_Gr121_122 Gr121_122 = new Step7_Gr121_122(r);
                    Gr121_122.calculaDFsMT();
                    r = Gr121_122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr121".equalsIgnoreCase(r.getDecision_Gr121_122MT())) {
                        Step8_sGr1211_1212 sGr1211_1212 = new Step8_sGr1211_1212(r);
                        sGr1211_1212.calculaDFsMT();
                        r = sGr1211_1212.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IA, IAE
                    }
                    if ("Gr122".equalsIgnoreCase(r.getDecision_Gr121_122MT())) {
                        Step9_sGr1221_1222 sGr1221_1222 = new Step9_sGr1221_1222(r);
                        sGr1221_1222.calculaDFsMT();
                        r = sGr1221_1222.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: IBA, IBAB  
                    }
                }

            }
            if ("SG2".equalsIgnoreCase(r.getDecision_SG1_2_3MT())) {
                Step10_MG21_22_23 MG21_22_23 = new Step10_MG21_22_23(r);
                MG21_22_23.calculaDFsMT();
                r = MG21_22_23.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG21".equalsIgnoreCase(r.getDecision_MG21_22_23MT())) {
                    Step11_Gr211_212_213 Gr211_212_213 = new Step11_Gr211_212_213(r);
                    Gr211_212_213.calculaDFsMT();
                    r = Gr211_212_213.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas: CBATC, CE, PCE
                }
                if ("MG22".equalsIgnoreCase(r.getDecision_MG21_22_23MT())) {
                    Step12_Gr221_222_223 Gr221_222_223 = new Step12_Gr221_222_223(r);
                    Gr221_222_223.calculaDFsMT();
                    r = Gr221_222_223.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas : CR, CSSF, CRS
                }
                if ("MG23".equalsIgnoreCase(r.getDecision_MG21_22_23MT())) {
                    Step13_Gr231_232_233 Gr231_232_233 = new Step13_Gr231_232_233(r);
                    Gr231_232_233.calculaDFsMT();
                    r = Gr231_232_233.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    if ("Gr231".equalsIgnoreCase(r.getDecision_Gr231_232_233MT())) {
                        Step14_sGr2311_2312 sGr2311_2312 = new Step14_sGr2311_2312(r);
                        sGr2311_2312.calculaDFsMT();
                        r = sGr2311_2312.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        if ("sGr2311".equalsIgnoreCase(r.getDecision_sGr2311_2312MT())) {
                            Step15_ssGr23111_23112 sGr23111_23112 = new Step15_ssGr23111_23112(r);
                            sGr23111_23112.calculaDFsMT();
                            r = sGr23111_23112.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OI, OIcC
                        }
                        if ("sGr2312".equalsIgnoreCase(r.getDecision_sGr2311_2312MT())) {
                            Step16_ssGr23121_23122 sGr23121_23122 = new Step16_ssGr23121_23122(r);
                            sGr23121_23122.calculaDFsMT();
                            r = sGr23121_23122.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                            //Ya llegó a las hojas: OIaOP, OP  
                        }
                    }
                    if ("Gr232".equalsIgnoreCase(r.getDecision_Gr231_232_233MT())) {
                        Step17_sGr2321_2322 sGr2321_2322 = new Step17_sGr2321_2322(r);
                        sGr2321_2322.calculaDFsMT();
                        r = sGr2321_2322.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                        //Ya llegó a las hojas: OIaMOR, OIcMOR 
                    }
                }

            }
            if ("SG3".equalsIgnoreCase(r.getDecision_SG1_2_3MT())) {
                Step18_MG31_32_33 MG31_32_33 = new Step18_MG31_32_33(r);
                MG31_32_33.calculaDFsMT();
                r = MG31_32_33.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                if ("MG31".equalsIgnoreCase(r.getDecision_MG31_32_33MT())) {
                    Step19_Gr311_312_313 Gr311_312_313 = new Step19_Gr311_312_313(r);
                    Gr311_312_313.calculaDFsMT();
                    r = Gr311_312_313.getR();//actualizo r con lo que fue calculado en el diagrama anterior
                    //Ya llegó a las hojas:MOR, MORo, MORS
                }
                //MG32 y MG33 Ya llegaron a sus hojas: MORcOI y MORFZ                
            }
        }
    }

}
