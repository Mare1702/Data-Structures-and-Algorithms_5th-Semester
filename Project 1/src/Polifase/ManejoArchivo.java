package Polifase;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;

/**
 * Clase secundaria dedicada al manejo de archivos, desde la escritura de
 * datos en ellos, hasta la aplicacion de criterios para conocer si estos
 * se encuentran vacíos o no.
 * @version 1.0 19/10/21
 * @author Alexis, Mario y Adolfo
 *
 */

public class ManejoArchivo {
    /**
     * Método para transcribir el contenido de una lista de claves a uno de
     * los archivos auxiliares
     * @param Archivo Lista de claves strings para transcribir su contenido
     * @param b Cantidad de espacios que se tendrán que llenar con el contenido de la lista de claves, esto representa el tamaño de bloque actural (ocupado para hacer pruebas)
     * @param nombre String representativo del nombre del archivo auxiliar a crear
     */


    public void Escritura(ArrayList <String>Archivo,int b,String nombre) {

        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter pw;
        int Bloque=0;

        try
        {
            f = new File(nombre);
            fw = new FileWriter(nombre, true);
            bw=new BufferedWriter(fw);
            pw = new PrintWriter(fw);


            for (int j=0; j < Archivo.size(); j++) {
                if(Archivo.get(j)!=null) {
                    pw.println(Archivo.get(j));
                    Bloque++;
                }
            }
            pw.close();
            bw.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para verificar si un archivo está vacío
     * @param Arreglo Arreglo de Strings que contiene al par de archivos auxiliares con los que se estén trabajando actualmente
     * @return El estado del booleano 'Bandera'
     * @throws IOException
     * @throws FileNotFoundException
     */

    public boolean SaberVacio(String [] Arreglo) throws IOException, FileNotFoundException{
        File f=new File(Arreglo[1]);
        boolean Bandera=false;

        if(f.length()==0) {
            Bandera=true;
        }
        return Bandera;
    }
}
