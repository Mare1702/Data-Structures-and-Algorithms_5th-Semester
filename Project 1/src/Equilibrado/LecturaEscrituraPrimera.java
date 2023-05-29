package Equilibrado;

import java.io.*;
/**
 * Método para dividir y unir por primera vez el arhcivo que se desea ordenar
 * @author Cote Valencia Alexis Daniel
 * @author Recinos Hernández Luis Mario
 * @author Roman Jiménez Adolfo
 */
public class LecturaEscrituraPrimera{
    /**
     * Método para dividir el archivo a ordenar en los archivos f1 y f2; se añaden throws IOException y FileNotFoundException
     * para ahorrar tiempo y renglones con los try catch.
     * @param archivo_lectura nombre del archivo que se va a ordenar y dividir por primera vez
     * @param archivo1 nombre del archivo (f1) en el que se divide el archivo original
     * @param archivo2 nombre del arvhico (f2) en el que se divide el archivo original
     */
    public static void lectura_escritura(String archivo_lectura, String archivo1, String archivo2)throws IOException, FileNotFoundException{
        boolean bandera=true;
        PrintWriter fileOut, fileOut2;
        String lectura1, lectura2;

        fileOut = new PrintWriter(new FileWriter(archivo1, true));
        fileOut2 = new PrintWriter(new FileWriter(archivo2, true));
        FileReader lectura=new FileReader(archivo_lectura);
        BufferedReader cadena=new BufferedReader(lectura);

        lectura1=cadena.readLine();
        //Ciclo encargado de la comparación de arreglos ya ordenados en el archivo original para poder dividir
        //dicho archivo en bloques y almacenar los bloques en f1 y f2
        while(lectura1!=null){
            lectura2=cadena.readLine();
            if(lectura2==null){
                if(bandera==true){
                    fileOut.print(lectura1);
                    lectura1=lectura2;
                }
                else{
                    fileOut2.print(lectura1);
                    lectura1=lectura2;
                }
            }
            else{
                if(lectura1.compareTo(lectura2)<0){
                    if(bandera==true){
                        fileOut.println(lectura1);
                        lectura1=lectura2;
                    }
                    else{
                        fileOut2.println(lectura1);
                        lectura1=lectura2;
                    }
                }
                else{
                    if(bandera==true){
                        fileOut.println(lectura1);
                        lectura1="~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n";
                        fileOut.print(lectura1);
                        lectura1=lectura2;
                        bandera=!bandera;
                    }
                    else{
                        fileOut2.println(lectura1);
                        lectura1="~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~\n";
                        fileOut2.print(lectura1);
                        lectura1=lectura2;
                        bandera=!bandera;
                    }
                }
            }
        }
        cadena.close();
        fileOut.close();
        fileOut2.close();
    }
    /**
     * Método para unir los archivos f1 y f2 creados en el méotodo anterior en un archivo llamado f3; se añaden throws IOException y FileNotFoundException
     * para ahorrar tiempo y renglones con los try catch.
     * @param archivo1 nombre del primer archivo creado (f1)
     * @param archivo2 nombre del segundo archivo creado (f2)
     * @param i contador del número de archivos creados
     * @return archivo3 nombre del archivo creado (f3) tras la unión de f1 y f2
     */
    public static String escritura_union(String archivo1, String archivo2, int i)throws IOException, FileNotFoundException{
        PrintWriter fileOut3;
        String R1, R2, archivo3=("./ArchivosMezclaEquilibrada/f"+i+".txt");
        fileOut3=new PrintWriter(new FileWriter(archivo3, true));

        FileReader lectura=new FileReader(archivo1);
        BufferedReader cadena=new BufferedReader(lectura);
        FileReader lectura2=new FileReader(archivo2);
        BufferedReader cadena2=new BufferedReader(lectura2);

        R1=cadena.readLine();
        R2=cadena2.readLine();
        //Ciclo para mezclar el archivo f1 y f2 en f3
        while(R1!=null){
            if(R1.equals("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~")){
                if(R2==null){
                    fileOut3.println(R1);
                    R1=cadena.readLine();
                }
                else{
                    if(R2.equals("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~")){
                        fileOut3.println(R2);
                        R1=cadena.readLine();
                        R2=cadena2.readLine();
                    }
                    else{
                        fileOut3.println(R2);
                        R2=cadena2.readLine();
                    }
                }
            }
            else{
                if(R2==null){
                    fileOut3.println(R1);
                    R1=cadena.readLine();
                }
                else{
                    if(R2.equals("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~")){
                        fileOut3.println(R1);
                        R1=cadena.readLine();
                    }
                    else{
                        if(R1.compareTo(R2)<0){
                            fileOut3.println(R1);
                            R1=cadena.readLine();
                        }
                        else{
                            fileOut3.println(R2);
                            R2=cadena2.readLine();
                        }
                    }
                }
            }
        }
        fileOut3.close();
        cadena.close();
        cadena2.close();
        return archivo3;
    }
}
