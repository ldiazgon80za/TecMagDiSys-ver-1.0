package MONTECARLO;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;

/**
 * Devuelve un archivo de texto plano, para escribir en �l.
 * 
 * @version 1.0, 07/07/2012
 * @author Jos� Ra�l Garc�a Giles.
 */
public class TextFile 
{
    /**
     * Escritor del texto en el archivo creado.
     */
    private PrintWriter textWrier;
    /**
     * Nombre del archivo creado (ruta completa).
     */
    public String fileName;
    /**
     * Extensi�n del archivo creado.
     */
    private final String ext = ".txt";
    
    /**
     * Dado el nombre de un archivo de texto plano (extensi�n .txt), crea
     * el archivo, y proporciona el m�todo para imprimir en �l.
     * <br/>
     * Si ya existe un archivo con el nombre dado, se a�ade una extensi�n
     * num�rica al final del nombre, es decir, el archivo es renombrado.
     * 
     * @param fileName Nombre del archivo creado (ruta completa).
     */
    public TextFile(String fileName) 
    {
        File textFile = new File(fileName);
        String fileNameWithOutExt = fileName.substring(0, fileName.length() - 4);
        /*
         * Si el archivo existe, se a�ade una extensi�n (n�mero) para no
         * sobreescribir el archivo existente.
         */
        int add = 1;
        while(textFile.exists())
        {
            textFile = new File( fileNameWithOutExt +(add++) + ext);
        }
        
        try
        {
            FileWriter fileCreator = new FileWriter(textFile);
            textWrier = new PrintWriter(fileCreator);
            this.fileName = textFile.getAbsolutePath();
        }
        catch (IOException e)
        {
            this.fileName = null;
        }
    }
    
    /**
     * Imprime el texto proporcionado, al final del archivo.
     * <br/>
     * El m�todo no a�ade salto de l�nea despu�s de imprimir el texto dado,
     *  por lo que si se desea imprimir, debe incluirse en la cadena dada.
     * 
     * @param string Texto a imprimir, al final del archivo.
     */
    public void writeText(String string)
    {
        textWrier.printf("%s", string);
        textWrier.flush();
    }
    
    /**
     * Cierra el archivo de texto, de forma segura.
     * <br/>
     * Podr�a no usarse este m�todo, pero se corre el riesgo de perder informaci�n.
     */
    public void closeFile()
    {
        textWrier.close();
    }
    
}//Fin Clase TextFile