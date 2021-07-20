package M_T;

import java.math.BigDecimal;

/**
 * Redondeo de datos siguiendo las reglas establecidas por Verma(2005) y Verma
 * (2016)
 *
 * @author Mauricio Rosales
 */
public class RoundingLogic {

    private static int min = 10;
    private static int max = 1000000000;
    private static int factor = 10;

    private static int factorValue;
    private static String roundedValue;
    private static int significantDigits;

    //private static boolean strict = false;
    private static boolean strict = true;
    //private static boolean flexible = true;
    private static boolean flexible = false;

    public static void main(String[] args) {
        double val = 2843.6465;
        //double val2 = 0.00996443654;
        //double val = 465.3654;
        double val2 = 125.6654;
        //double val = 0.0001253654;

        System.out.println(roundingScale(val2));
        System.out.println(roundingLocation(val, val2));

        double[] means = {69.29402669, 0.096320258, 13.54723431, 1.447052924, 0.010805502, 0.389535666, 1.408210828, 0.275845135, 5.28599203, 99.65220142574};
        double[] test = {0.0, /*2.350371832,*/ 0.012919017, 0.482500794, 0.229458864, 0.002682637, 0.390644386, 0.074927729, 0.065751994, 0.056242644, 99.65220142574};
        for (int i = 0; i < means.length; i++) {
            //System.out.println(roundingScale(test[i]));
            //System.out.println(String.valueOf(test[i]) + " \t " + redondear(test[i], 3) + " \t " + redondear(test[i], 0));
            System.out.println(means[i] + " \t " + roundingLocation(means[i], test[i]) + "\t\t" + test[i] + "\t" + roundingScale(test[i]));
        }
    }

    /**
     * Funcion para obtener el valor redoneado de la tendencia central
     * @param val valor de la tendencia central
     * @param test valor de la dispersion
     * @return valor de media redondeado al aplicar la condicion de: flexible o estricto
     */
    private static String roundingLocation(double val, double test) {
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
    private static String roundingScale(double val) {
        double valCopy = val;
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
    private static void countingZeros(double val) {
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
    private static String roundingConditions(String disp, int a) {
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

    private static String roundedValue(boolean useOfFactor) {
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
    public static String getRoundedValue() {
        return roundedValue;
    }

    public static void setRoundedValue(String roundedValue) {
        RoundingLogic.roundedValue = roundedValue;
    }

    public static int getFactorValue() {
        return factorValue;
    }

    public static void setFactorValue(int factorValue) {
        RoundingLogic.factorValue = factorValue;
    }

    public static int getSignificantDigits() {
        return significantDigits;
    }

    public static void setSignificantDigits(int significantDigits) {
        RoundingLogic.significantDigits = significantDigits;
    }
}// End of Redondeo
