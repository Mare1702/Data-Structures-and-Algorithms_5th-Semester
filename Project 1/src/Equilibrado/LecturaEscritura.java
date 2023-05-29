package Equilibrado;

import java.io.*;
/**
 * Clase para dividir y unir los n-archivos creados despues de hacerlo la primera vez.
 * @author Cote Valencia Alexis Daniel
 * @author Recinos Hernández Luis Mario
 * @author Roman Jiménez Adolfo
 */
public class LecturaEscritura{
    /**
     * Método lectura_escritura para dividir el archivo f3 (f6, f9, f12, f3n); se añaden throws IOException y FileNotFoundException
     * para ahorrar tiempo y renglones con los try catch.
     * @param archivo_lectura nombre del archivo que se va a dividir
     * @param archivo_escritura nombre del archivo (f4, f7, f10, f13, f(3n+1))
     * @param archivo_escritura2 nombre del archivo (f5, f8, f11, f14, f(3n+2))
     */
    public static void lectura_escritura(String archivo_lectura, String archivo_escritura, String archivo_escritura2)throws IOException, FileNotFoundException{
        boolean bandera=true;
        PrintWriter fileOut, fileOut2;
        String R1;

        fileOut=new PrintWriter(new FileWriter(archivo_escritura, true));
        fileOut2=new PrintWriter(new FileWriter(archivo_escritura2, true));

        FileReader lectura=new FileReader(archivo_lectura);
        BufferedReader cadena=new BufferedReader(lectura);
        R1=cadena.readLine();
        /**
         * Ciclo para poder dividir el archivo f(3n) en dos archivos f(3n+1) y f(3n+2)
         */
        while(R1!=null){
            if(R1.equals("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~")){
                if(bandera==true){
                    fileOut.println(R1);
                    R1=cadena.readLine();
                    bandera=!bandera;
                }
                else{
                    fileOut2.println(R1);
                    R1=cadena.readLine();
                    bandera=!bandera;
                }
            }
            else{
                if(bandera==true){
                    fileOut.println(R1);
                    R1=cadena.readLine();
                }
                else{
                    fileOut2.println(R1);
                    R1=cadena.readLine();
                }
            }
        }
        cadena.close();
        fileOut.close();
        fileOut2.close();
    }
    /**
     * Método para la unión de los archivos f(3n+1) y f(3n+2) en uno llamado f(3n); se añaden throws IOException y FileNotFoundException
     * para ahorrar tiempo y renglones con los try catch.
     * @param archivo1 nombre del archivo f(3n+1)
     * @param archivo2 nombre del archivo f(3n+2)
     * @param i variable para indicar el número de archivo creado.
     * @return archivo3 regresa el nombre del archivo f(3n)
     */
    public static String union(String archivo1, String archivo2, int i)throws IOException, FileNotFoundException{
        PrintWriter fileOut3;
        String R1, R2, archivo3=("./ArchivosMezclaEquilibrada/f"+i+".txt");
        fileOut3=new PrintWriter(new FileWriter(archivo3, true));

        FileReader lectura=new FileReader(archivo1);
        BufferedReader cadena=new BufferedReader(lectura);
        FileReader lectura2=new FileReader(archivo2);
        BufferedReader cadena2=new BufferedReader(lectura2);

        R1=cadena.readLine();
        R2=cadena2.readLine();
        //Ciclo encargado de la unión de los archivos f(3n+1) y f(3n+2) para crear f(2n)
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
