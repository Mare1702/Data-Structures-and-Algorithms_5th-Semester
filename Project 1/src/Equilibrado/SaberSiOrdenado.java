package Equilibrado;

import java.io.*;
/**
 * Clase para saber si el archivo en cuestión ya se encuentra ordenado.
 * @author Cote Valencia Alexis Daniel
 * @author Recinos Hernández Luis Mario
 * @author Roman Jiménez Adolfo
 */
public class SaberSiOrdenado{
    /**
     * Corrobora si el archivo que se está leyendo se encuentra ordenado recibiendo
     * el nombre del archivo, retorna false si el archivo no está ordenado y true en
     * caso contrario.
     * @param archivo_lectura
     * @return bandera
     */
    public static boolean ordenado(String archivo_lectura)throws IOException, FileNotFoundException{
        boolean bandera=true;
        String lectura1, lectura2;
        FileReader lectura=new FileReader(archivo_lectura);
        BufferedReader cadena=new BufferedReader(lectura);

        lectura1=cadena.readLine();
        while(lectura1!=null&&bandera==true){
            lectura2=cadena.readLine();
            if(lectura2==null){
                lectura1=lectura2;
            }
            else{
                if(lectura1.compareTo(lectura2)<0){
                    lectura1=lectura2;
                    lectura2=cadena.readLine();
                }
                else
                    bandera=false;
            }
            //Mediante el While y el If checamos si el renglón n es mayor al n-1.
        }
        cadena.close();
        return bandera;
    }
}
