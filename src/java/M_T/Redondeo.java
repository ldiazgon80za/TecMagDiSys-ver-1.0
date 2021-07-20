package M_T;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.zkoss.zul.Messagebox;

/**
 * Redondeo de datos siguiendo las reglas establecidas por Verma(2005)
 *
 * @author Rex
 *
 */
public class Redondeo {

    boolean Estricto = false;
    boolean Forzar = false; //Define si se forza el cero en la medida de tendencia central

    /**
     * Constructor de la clase
     *
     * @param Estricto - Define el tipo de redondeo a plicar.
     */
    public Redondeo(boolean Estricto) {
        this.Estricto = Estricto;
    }

//    public void main(String args[]) {
////	double data[]= {
////			0.358756,
////			0.685451,
////			0.06692518,
////			0.81554222,
////			0.004014,
////			0.9992450,
////			0.99725,
////			0.55555,
////			0.55455,
////			0.07373429,
////			0.85331539,
////			0.87183714,
////			0.0145545,
////			0.181865,
////			2.97055,
////			0.074455,
////			0.18325001,
////			2.972771,
////			5.55555,
////			4.44500,
////			1.90775,
////			555.454545,
////			77.3888,
////			865.5001
////	};
////	double data2[] = {
////			358756,
////			845001,
////			555555,
////			987654,
////			123456,
////			456500,
////			46195,
////			55555,
////			55455,
////			44444,
////			13579,
////			99550,
////			88550,
////			88450,
////			555555,
////			444500,
////			443500,
////			435500,
////			435000,
////			555454,
////			773888,
////			444500,
////			8655001
////			
////	};
////	
////	String value;
////	for (int a =0;a<data.length;a++){
////		for(int b=4;b>0;b--){
////			value = redondear(data[a],b);
////			System.out.print(value+"	");
////		}
////		System.out.println();
////	}
////	for (int a =0;a<data2.length;a++){
////		for(int b=4;b>0;b--){
////			value = redondear(data2[a],b);
////			System.out.print(value+"	");
////		}
////		System.out.println();
////	}
////	System.out.println(redondear(501.5,60.0)[0]);
////	System.out.println(redondearDisp(3.155));
//
//    }
    /**
     * Redondea un par�metro de dispersi�n
     *
     * @param Disp - Par�metro de dispers�n a redondear.
     * @return
     */
    public String redondearDisp(double Disp) {
        Forzar = false;
        String disp = String.format("%.16f", Disp).replace(',', '.');
        int DigSig = 0;
        int a = 0;

        for (int e = disp.indexOf(".") + 1; e < disp.length() - e; e++) {
            if (disp.charAt(e) == '0') {
                a++;
            } else {
                break;
            }
        }

        String Fracc;
        if (Disp < 10) {//Se redondea para obtener la fracci�n base para el redondeo de los d�gitos significativos
            if (Disp < 1)//si es un n�mero fraccionario < 1
            {
                if (Disp <= .45) {
                    Fracc = redondear(Disp, a + 2);
                } else {
                    Fracc = redondear(Disp, a + 3);
                }
            } else {// Si es un valor >1 y <10
                if (Disp % 1 == 0)// si es entero
                {
                    return String.valueOf(Disp);
                } else {//si no es entero y es >1 y <10
                    Fracc = redondear(Disp, 3);
                    a = 0;
                }
            }
            if (Double.valueOf(Fracc) < 1) {
                if (Disp <= .45) {
                    Fracc = "0." + Fracc.charAt(Fracc.length() - 2) + Fracc.charAt(Fracc.length() - 1);
                } else {
                    Fracc = "0." + Fracc.charAt(Fracc.length() - 3) + Fracc.charAt(Fracc.length() - 2) + Fracc.charAt(Fracc.length() - 1);
                }
            }

        } else {
            Fracc = String.valueOf(Disp).replace(',', '.');
        }

        DigSig = a + 2;
        int x = 0;//Digitos significativos para mayores a 1
        //Regla 7
        if (!Estricto) {
            x++;
            DigSig++;
        }
        //Reglas 4 y 5
        double FraccVal = Double.valueOf(Fracc);
        if (Disp < 1) {
            if (FraccVal <= .45) {
                return redondear(Disp, DigSig);
            } else {
                return redondear(Disp, DigSig - 1);
            }
        } else if (FraccVal <= 4.5) {
            return redondear(Disp, DigSig - 1);//menos 1 por que es mayor a 1
        } else if (FraccVal < 10) {
            return redondear(Disp, DigSig - 2);
        } else {
            if ((FraccVal <= 45) && (Estricto)) {
                return redondear(Disp, 0);
            }
            if ((FraccVal <= 45) && (!Estricto)) {
                return redondear(Disp, 1);
            }
            if ((FraccVal >= 45) && (Estricto) && (FraccVal < 100)) {
                Forzar = true;
                return redondear(Integer.parseInt(redondear(Disp, 0)), 0);
            }
            if ((FraccVal >= 45) && (!Estricto) && (FraccVal < 100)) {
                return redondear(Disp, 0);
            }
            if ((FraccVal >= 100) && (Estricto) && (FraccVal < 450)) {
                return redondear(Integer.parseInt(redondear(Disp, 1)), 0);
            }
        }

        return String.valueOf(Math.round(Disp));

    }

    /**
     * Redondea un valor fraccionario a los decimales indicados.
     *
     * @param value - Valor a redondear.
     * @param d - N�mero de d�gitos significativos.
     * @return El valor redondeado
     */
    public String redondear(double value, int d) {
        if (Double.valueOf(value).isNaN()) {
            System.out.println("El valor a redondear es NaN, se transformo a 0 para su impresi�n");
            return "0";
        }
        if (d > 16) {
            return "Los d�gitos a significativos no deben exceder 15";
        }
        if (value == 0) {
            return String.format("0%." + d + "f", value).replace(',', '.');
        }
        if (value % 1 == 0) //Si el valor es entero
        {
            return redondear((int) value, d);
        }
        return redondear(String.format("%.16f", value).replace(',', '.'), d);
    }

    /**
     * Redondea un valor entero a los decimales indicados.
     *
     * @param value - Valor a redondear.
     * @param d - N�mero de d�gitos significativos.
     * @return El valor redondeado.
     */
    public String redondear(int value, int d) {
        if (d == 0) {
            return String.valueOf(value);
        }
        String valueAux = String.valueOf(value);
        int nAux = valueAux.length();
        if (nAux == d) {
            return valueAux;
        } else if (nAux < d) {
            valueAux = valueAux + ".";
            for (int a = 0; a < d - nAux; a++) {
                valueAux = valueAux + 0;
            }
            return valueAux;
        }

        String aux1 = "";
        String aux2 = "";
        aux1 = valueAux.substring(0, d);
        aux2 = valueAux.substring(d);

        int c = aux2.length();
        int base = 5;
        for (int a = 1; a < c; a++)// cambiar la base a comparar dependiendo del n�mero de d�gitos del resto
        {
            base = base * 10;
        }

        int Aux1 = Integer.parseInt(aux1);
        int Aux2 = Integer.parseInt(aux2);

        //Regla 1 y 2 si es mayor a 1/2 del resto se incrementa, sino se deja igual
        if (Aux2 > base) {
            Aux1++;
        }
        //Regla 3: si es igual a 1/2 del resto se incrementa si el menos significativo es non sino se deja igual
        if (Aux2 == base) {
            if ((Aux1 % 2) != 0)//Se checa si es non
            {
                Aux1++;
            }
        }

        String Value = String.valueOf(Aux1);
        for (int a = 0; a < aux2.length(); a++)//Recorrer el valor a su pocici�n original.
        {
            Value = Value + "0";
        }

        return Value;
    }

    /**
     * Redondea una medida de tendencia central con base a un par�metro de
     * dispersi�n.
     *
     * @param Tc - Medida de tendencia central.
     * @param Disp - Par�metro de dispersi�n.
     * @return Los valores redondeados.
     */
    public String[] redondear(double Tc, double Disp) {
        if (Double.valueOf(Disp).isNaN()) {
            Messagebox.show("Error in Report summary. Dispersion is NaN.");
            return new String[]{String.valueOf(Tc), "NaN"};
        }
        String Data[] = new String[2];
        int Ds = 1;
        if (!Estricto) {
            Ds++;
        }
        Data[1] = redondearDisp(Disp);
        if (Forzar) {
            Data[0] = redondear((int) Tc, Ds);
        } else if (Data[1].indexOf(".") != -1) {
            int DigSig = Data[1].length() - Data[1].indexOf(".");
            Data[0] = redondear(Tc, DigSig - 1);
        } else {
            Data[0] = redondear((int) Tc, Ds + 1);
        }

        return Data;
    }

    /**
     * Redondeo para un n�mero con formato ##.##
     *
     * @param valueAux - Valor a redondear.
     * @param d - N�mero de digitos significativos.
     * @return
     */
    public String redondear(String valueAux, int d) {
        //Posible error-------------------
        boolean menor1 = false;
        int inicio = 0;
        if (Double.valueOf(valueAux) < 0) //Si es negativo
        {
            inicio = 1;
        }
        if (Double.valueOf(valueAux) < 1) //si es menor a 1
        {
            menor1 = true;
        }
        int Punto = valueAux.indexOf(".");

        String num;

        String Fracc = "0." + valueAux.substring(Punto + d + 1);
        double FraccVal = Double.valueOf(Fracc);
        if (d != 0) {
            num = valueAux.substring(inicio, Punto) + valueAux.substring(Punto + 1, Punto + d + 1);
        } else {
            num = valueAux.substring(inicio, Punto);
        }

        long Num = Long.parseLong(num);
        long NumAux = Num;
        if ((FraccVal > .5) || ((FraccVal == .5) && (Num % 2 != 0))) {
            Num++;
        }

        valueAux = String.valueOf(Num);
        boolean inc = false;
        if (valueAux.length() > String.valueOf(NumAux).length()) {
            if (valueAux.length() > d) {
                inc = true;
            }
            Punto++;
        }
        if (inicio == 1)//Signo negativo
        {
            Punto--;
        }
        num = "";
        if (menor1) {//si el valor es menor a 1
            if (d == 0) {
                num = valueAux;
            } else {
                if (inc) {
                    num = "1.";
                    for (int a = 0; a < valueAux.length() - 1; a++) {
                        num = num + valueAux.charAt(a + 1);
                    }
                } else {
                    num = "0.";
                    for (int a = 0; a < d - valueAux.length(); a++) {
                        num = num + "0";
                    }
                    num = num + valueAux;
                }
            }
        } else {
            for (int a = 0; a < valueAux.length(); a++) {
                if (Punto == a) {
                    num = num + "." + valueAux.charAt(a);
                } else {
                    num = num + valueAux.charAt(a);
                }
            }
        }
        //Dividir n�mero

        if (inicio == 1) {
            num = "-" + num;
        }
        return num;
    }

    /////////////////////
    public ArrayList<String> direct_rounding(String c, int sigd) {
        if (c == "") {
            ArrayList<String> a = new ArrayList<String>();
            a.add("");
            a.add("");
            return a;
        }

        String RuleA = "";
        String digits = "";
        String rounded = "";
        int number = 0;

        if (c.indexOf(".") == -1) {
            //case of integer
            int index = 0;
            while (c.charAt(index) == '0') {
                index++;
            }
            digits = c.substring(index);
            int length = digits.length();
            if (length < sigd) {
                rounded = digits + ".";
                for (int i = 0; i < sigd - length; i++) {
                    rounded = rounded + "0";
                }
                RuleA = "";
            } else {
                rounded = digits.substring(0, sigd);
                if (Character.getNumericValue(digits.charAt(sigd)) > 5) {
                    RuleA = "Rule 1";
                    number = Integer.parseInt(rounded);
//                    System.out.println("HOLAAAA ASDFASDF - number " + number + "\t" + rounded);
                    if (number > 0) {
                        number = number + 1;
                    } else {
                        number = number - 1;
                    }
//                    System.out.println("numb " + number);
                    rounded = Integer.toString(number);
//                    System.out.println("rounded " + rounded);
                } else if (Character.getNumericValue(digits.charAt(sigd)) < 5) {
                    RuleA = "Rule 2";
//                    System.out.println("rounded " + rounded);
                } else {
                    int curr = 0;
                    for (int i = sigd + 1; i < length; i++) {
                        if (digits.charAt(i) != '0') {
                            curr = 1;
                            break;
                        }
                    }
                    if (curr == 1) { //of type 50067
                        RuleA = "Rule 1";
                        number = Integer.parseInt(rounded);
                        if (number > 0) {
                            number = number + 1;
                        } else {
                            number = number - 1;
                        }
//                        System.out.println("numb " + number);
                        rounded = Integer.toString(number);
//                        System.out.println("rounded " + rounded);
                    } else {
                        RuleA = "Rule 3";
                        if (Character.getNumericValue(digits.charAt(sigd - 1)) % 2 == 1) {  //odd and 50000.. types
                            number = Integer.parseInt(rounded);
                            if (number > 0) {
                                number = number + 1;
                            } else {
                                number = number - 1;
                            }
//                            System.out.println("numb " + number);
                            rounded = Integer.toString(number);
//                            System.out.println("rounded " + rounded);
                        } else {

                        }
                    }
                }
                for (int i = 0; i < length - sigd; i++) {
                    rounded = rounded + "0";
                }
            }
        } else {
            int deciPos = c.indexOf(".");
            int index = 0;
            while (c.charAt(index) == '0' || c.charAt(index) == '.') {
                index++;
            }
            //String extra = c.substring(0,index);
            int deciZeroes = 0; //number of zeroes after decimal; ex: 0.000567
            if (index > deciPos) {
                deciZeroes = index - deciPos - 1;
                digits = c.substring(index);
            } else {
                digits = c.substring(index, deciPos) + c.substring(deciPos + 1); //extracted number
            }
//            System.out.println("digits: " + digits);
            int length = digits.length();

            if (length <= sigd) {
                rounded = digits;
                for (int i = 0; i < sigd - length; i++) {
                    rounded = rounded + "0";
                }
                RuleA = "";
            } else {
                rounded = digits.substring(0, sigd);
                if (Character.getNumericValue(digits.charAt(sigd)) > 5) {
                    RuleA = "Rule 1";
                    System.out.println(rounded);
                    number = Integer.parseInt(rounded);
                    System.out.println(number);
                    if (number > 0) {
                        number = number + 1;
                    } else {
                        number = number - 1;
                    }
                    System.out.println("numb test ->" + number);
                    rounded = Integer.toString(number);
//                    System.out.println("rounded " + rounded);
                } else if (Character.getNumericValue(digits.charAt(sigd)) < 5) {
                    RuleA = "Rule 2";
//                    System.out.println("rounded " + rounded);
                } else {
                    int curr = 0;
                    for (int i = sigd + 1; i < length; i++) {
                        if (digits.charAt(i) != '0') {
                            curr = 1;
                            break;
                        }
                    }
                    if (curr == 1) { //of type 50067
                        RuleA = "Rule 1";
                        number = Integer.parseInt(rounded);
                        if (number > 0) {
                            number = number + 1;
                        } else {
                            number = number - 1;
                        }
//                        System.out.println("numb " + number);
                        rounded = Integer.toString(number);
//                        System.out.println("rounded " + rounded);
                    } else {
                        RuleA = "Rule 3";
                        if (Character.getNumericValue(digits.charAt(sigd - 1)) % 2 == 1) {  //odd and 50000.. types
//                            number = Integer.parseInt(rounded);
                            if (number > 0) {
                                number = number + 1;
                            } else {
                                number = number - 1;
                            }
//                            System.out.println("numb " + number);
                            rounded = Integer.toString(number);
//                            System.out.println("rounded " + rounded);
                        } else {

                        }
                    }
                }
            }
            if (index > deciPos) {
                for (int i = 0; i < deciZeroes; i++) {
                    rounded = "0" + rounded;
                }
                rounded = "0." + rounded;
            } else {
                if (deciPos - index < rounded.length()) {
                    rounded = rounded.substring(0, deciPos - index) + "." + rounded.substring(deciPos - index);
                } else {
                    int l = rounded.length();
                    for (int i = 0; i < deciPos - index - l; i++) {
                        rounded = rounded + "0";
                    }
                }
            }
        }

        ArrayList<String> a = new ArrayList<String>();
        a.add(rounded);
        a.add(RuleA);
//        System.out.println(a.get(0));
//        System.out.println(a.get(1));
        return a;
    }

    public ArrayList<String> roundWithDP(String c_str, String d_str, boolean strict) {

        boolean auxFlag = false;
        
        if (c_str.equals(d_str))
            auxFlag = true;
        if (c_str == "" || d_str == "") {
            ArrayList<String> a = new ArrayList<String>();
            a.add("");
            a.add("");
            a.add("");
            a.add("");
            a.add("");
            a.add("");
            return a;
        }
        String auxSignC = "";
        String auxSignD = "";
        
        if(c_str.contains("-")){
            auxSignC = "-";
            c_str = c_str.substring(1, c_str.length());
        }
        if(d_str.contains("-")){
            auxSignD = "-";
            d_str = d_str.substring(1, d_str.length());
        }
        
        
        String dr = "";
        double c = Double.parseDouble(c_str);
        double d = Double.parseDouble(d_str);
        String RuleA1 = "";
        String RuleA2 = "";
        String RuleB = "";
        String RuleC = "";
        ArrayList list = new ArrayList();
        if (strict) {
            RuleC = "Rule 6";
            if (d <= 0.45) {
                RuleB = "Rule 4";
                list = direct_rounding(d_str, 2);
            } else if (d > 1 && d <= 4.5) {
                RuleB = "Rule 5";
                list = direct_rounding(d_str, 2);
            } else if (d > 0.45 && d <= 1) {
                RuleB = "Rule 4";
                list = direct_rounding(d_str, 1);
            } else if (d > 4.5) {
                RuleB = "Rule 5";
                list = direct_rounding(d_str, 1);
            }
        } else {
            RuleC = "Rule 9";
            if (d <= 0.45) {
                RuleB = "Rule 7";
                list = direct_rounding(d_str, 3);
            } else if (d > 1 && d <= 4.5) {
                RuleB = "Rule 8";
                list = direct_rounding(d_str, 3);
            } else if (d > 0.45 && d <= 1) {
                RuleB = "Rule 7";
                list = direct_rounding(d_str, 2);
            } else if (d > 4.5) {
                RuleB = "Rule 8";
                list = direct_rounding(d_str, 2);
            }
        }
        dr = list.get(0).toString();
        RuleA1 = list.get(1).toString();
//        System.out.println("dr: " + RuleA1);

        int sigd = 0;
        if (dr.indexOf(".") == -1) {
            sigd = 0;
        } else {
            sigd = dr.length() - (dr.indexOf(".") + 1);
        }

        //String c_str = Double.toString(c);
        int predeci = c_str.indexOf(".");
        if (c_str.charAt(0) == '0' && predeci == 1) {
            predeci--;
            int t = 2;
            while (c_str.charAt(t) == '0') {
                predeci--;
                t++;
            }
        }
        System.out.println("pd " + predeci + "\t" + sigd);
        list = direct_rounding(c_str, predeci + sigd);
        c_str = list.get(0).toString();
        RuleA2 = list.get(1).toString();
        //check for special cases too
        ArrayList<String> a = new ArrayList<String>();
        System.out.println(c_str);
        if(auxSignC.contains("-")  || auxSignC.contains("-") || auxFlag){
            String s = "";
            if(auxSignC.isEmpty())
                s = "-";
            else if(auxSignD.isEmpty())
                s = "-";
            else
                s= "-";
            c_str = s.concat(c_str);
        }
            
        a.add(c_str);
        a.add(dr);
        a.add(RuleC);
        a.add(RuleB);
        a.add(RuleA1);
        a.add(RuleA2);
        
        return a;

    }

    ////////////////
    private int min = 10;
    private int max = 1000000000;
    private int factor = 10;

    private int factorValue;
    private String roundedValue;
    private int significantDigits;

    //private static boolean strict = false;
    private boolean strict = false;
    //private static boolean flexible = true;
    private boolean flexible = true;


    /**
     * Funcion para obtener el valor redoneado de la tendencia central
     * @param val valor de la tendencia central
     * @param test valor de la dispersion
     * @return valor de media redondeado al aplicar la condicion de: flexible o estricto
     */
    public String roundingLocation(double val, double test) {
        roundingScale(test);
        
        double valCopy = val;
        //En caso de no tener un valor asignado
        if (Double.valueOf(val).isNaN() || (val == 0) || (Double.toString(val).equals(""))) {
            return "";
        }
        valCopy /= getFactorValue();
        BigDecimal bdTest = new BigDecimal(Double.valueOf(valCopy));
        bdTest = bdTest.setScale(getSignificantDigits(), BigDecimal.ROUND_HALF_UP);
        valCopy = Double.parseDouble(bdTest.toString()) * getFactorValue();
        return Double.toString(valCopy);
    }

    /**
     * Funcion para obtener el factor divisor del numero para aplicar el
     * redondeo: flexible o estricto
     *
     * @param val numero a redondear con puntos decimales
     * @return cadena con numero redondeado
     */
    public String roundingScale(double val) {
        double valCopy = val;
        System.out.println(val);
        
        //En caso de no tener un valor asignado
        if (Double.valueOf(val).isNaN() || (Double.toString(val).equals(""))) {
            setSignificantDigits(0);
            setFactorValue(1);
            return "";
        }
        if( val == 0 || val == 0.0)
            return "0";

        boolean useOfFactor = false;
        int divisor = 1;
        for (int i = min; i < max; i *= factor) {
            if (Math.abs(val) < 1) {
                setFactorValue(divisor);
                countingZeros(val);
                //System.out.println(val + "\t" + i);
                break;
            } else {
                divisor = i;
                val = valCopy / divisor;
                useOfFactor = true;
            }
        }
        return roundedValue(useOfFactor);
    }

    /**
     * Funcion para contar los ceros despues del punto decimal, en caso de haber
     * sido un valor inicial con 0s despues del punto decimal, p. ej. 0.000123,
     * 0.0234... etc
     *
     * @param val numero menor a 1 con puntos decimales
     */
    private void countingZeros(double val) {
        int a = 0;
        String aux = Double.toString(val);
        int size = aux.length() - (aux.indexOf(".") + 1);
        String disp = String.format("%." + size + "f", val).replace(',', '.');
        for (int e = disp.indexOf(".") + 1; e < disp.length() - e; e++) {
            if (disp.charAt(e) == '0') {
                a++;
            } else {
                break;
            }
        }
        setRoundedValue(roundingConditions(disp, a));
    }

    /**
     * Funcion donde se determina si el redondeo sera flexible o estricto
     *
     * @param disp numero con formato de cadena
     * @param a cantidad de ceros despues de punto decimal (si fuera el caso...)
     * @return
     */
    private String roundingConditions(String disp, int a) {
        int significativo = 0;
        if (strict && !flexible) {
            significativo = 2;
        }
        if (!strict && flexible) {
            significativo = 1;
        }

        String digitos = disp.substring((disp.indexOf(".") + 1 + a));
        String aux = "";
        String rounded = "";
        char[] z = digitos.toCharArray();
        for (int i = 0; i < z.length; i++) {
            if (i == 2) {
                aux += (".") + z[i];
            } else {
                aux += z[i];
            }
        }

        if (Double.valueOf(aux) < 45) {
            BigDecimal bdTest = new BigDecimal(Double.valueOf(aux));
            bdTest = bdTest.setScale(1, BigDecimal.ROUND_HALF_UP);
            rounded = bdTest.toString();
            rounded = rounded.replace(".", "");
            String help = ".";

            if (a > 0) {
                for (int i = 0; i < a; i++) {
                    help += "0";
                }
            }
            help += rounded;
            int digits = a + 4 - significativo;
            setSignificantDigits(digits);

            bdTest = new BigDecimal(Double.valueOf(help));
            bdTest = bdTest.setScale(digits, BigDecimal.ROUND_HALF_UP);

            return bdTest.toString();
        } else if (Double.valueOf(aux) < 99.9) {
            BigDecimal bdTest = new BigDecimal(Double.valueOf(aux));
            bdTest = bdTest.setScale(0, BigDecimal.ROUND_HALF_UP);
            rounded = bdTest.toString();
            rounded = rounded.replace(".", "");
            String help = ".";

            if (a > 0) {
                for (int i = 0; i < a; i++) {
                    help += "0";
                }
            }

            help += rounded;
            int digits = a + 3 - significativo;
            setSignificantDigits(digits);

            bdTest = new BigDecimal(Double.valueOf(help));
            bdTest = bdTest.setScale(digits, BigDecimal.ROUND_HALF_UP);

            return bdTest.toString();
        } else {
            BigDecimal bdTest = new BigDecimal(Double.valueOf(aux));
            bdTest = bdTest.setScale(0, BigDecimal.ROUND_HALF_UP);
            rounded = bdTest.toString();
            rounded = rounded.replace(".", "");
            if (Double.parseDouble(rounded) == 100) {
                a--;
                String help = ".";

                if (a > 0) {
                    for (int i = 0; i < a; i++) {
                        help += "0";
                    }
                    help += rounded;
                    int digits = a + 4 - significativo;
                    setSignificantDigits(digits);

                    bdTest = new BigDecimal(Double.valueOf(help));
                    bdTest = bdTest.setScale(digits, BigDecimal.ROUND_HALF_UP);

                    return bdTest.toString();
                } else {
                    if (significativo == 1) {
                        setSignificantDigits(2);
                        return rounded = "1.00";
                    } else {
                        setSignificantDigits(1);
                        return rounded = "1.0";
                    }
                }
            } else {
                String help = ".";

                if (a > 0) {
                    for (int i = 0; i < a; i++) {
                        help += "0";
                    }
                }
                help += rounded;
                int digits = a + 3 - significativo;
                setSignificantDigits(digits);

                bdTest = new BigDecimal(Double.valueOf(help));
                bdTest = bdTest.setScale(digits, BigDecimal.ROUND_HALF_UP);
                return bdTest.toString();
            }

        }
    }

    private String roundedValue(boolean useOfFactor) {
        int val2 = (Integer.toString(getFactorValue()).length() - 1);
        if (useOfFactor) {
            System.out.println(getRoundedValue() + "\t" + getFactorValue());
            String val = Double.toString(Double.parseDouble(getRoundedValue()) * getFactorValue());
            return val;
        } else {
            return getRoundedValue();
        }
    }

    ////////////////////////////////////////
    ////////////////////////////////////////
    public String getRoundedValue() {
        return roundedValue;
    }

    public void setRoundedValue(String roundedValue) {
        this.roundedValue = roundedValue;
    }

    public int getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(int factorValue) {
        this.factorValue = factorValue;
    }

    public int getSignificantDigits() {
        return significantDigits;
    }

    public void setSignificantDigits(int significantDigits) {
        this.significantDigits = significantDigits;
    }
}
