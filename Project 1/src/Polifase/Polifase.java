package Polifase;
import java.awt.*;
import java.util.*;
import java.io.*;

/**
 *Genera los arreglos de listas necesarios para almacenar y segmentar las claves del
 * archivo de texto a ordenar, asi como tambien se instancian objetos para el uso de
 * clases secundarias para la reordencaicon de las claves y su impresion en archivos
 * auxiliares
 * @version 1.0, 23/10/21
 * @authors Adolfo, Alexis, Mario
 */


public class Polifase {

    /**
     *  Clase principal para el algoritmo Polifase, recibe el nombre y extension del
     * archivo a ordenar por medio de una string ingresada por el usuario para
     * empezar a seccionar el mismo en bloques ordenados que, al ser intercalados
     * de manera recursiva generarán finalmente un archivo ordenado
     */

    public static void TomaEImpresionDatos(String EntradaArchivo) {
        String cad;
        //String EntradaArchivo;

        int TamBloque=4,NumArchivosAux=0;
        int NumLineas=0,ElemBloque=0;

        ArrayList <String>F1 =new ArrayList<String>();
        ArrayList <String>F2 =new ArrayList<String>();
        //ArrayList <String>F3 =new ArrayList<String>();
        ArrayList <String>Aux1 =new ArrayList<String>();
        ArrayList <String>Aux2 =new ArrayList<String>();
        //ArrayList <String>Array1 =new ArrayList<String>();
        boolean Bandera=false;
        Utilidades Sort =new Utilidades();
        ManejoArchivo FileMngmt =new ManejoArchivo();

        //System.out.println("Algoritmo de ordenamiento "
                //+ "externo Polifase");
        String lec1, lec2;
        int i=1;

        String [] Arreglo= {null,null} ;

        lec1 =("./ArchivosPolifase/FP"+i+".txt");
        i++;
        lec2=("./ArchivosPolifase/FP"+i+".txt");
        i++;

        File Archivo=new File(EntradaArchivo);
        //INGRESO DE F0 POR EL USUARIO
        try {														//Como trabajamos con lectura de archivos, siempre se usa try-catch
            Desktop.getDesktop().open(Archivo);
            //   System.out.println("Este es el contenido del"
                    //+ " Archivo:");
            FileReader fr =new FileReader (Archivo);
            BufferedReader br = new BufferedReader(fr);
            cad=br.readLine();

            do {

                ElemBloque=0;
                while(ElemBloque<4){
                    if(cad!=null) {
             //           System.out.println(cad);//F1
                        Aux1.add(cad);
                    }
                    cad=br.readLine();
                    NumLineas++;
                    ElemBloque++;
                }

                Sort.BubbleSort(Aux1);								//ORDENAMIENTO BUBBLESORT CON AUX1
                F1.addAll(Aux1);
                F1.add("---------------------");
                Aux1.clear();


                ElemBloque=0;
                while(ElemBloque<4) {
                    if(cad!=null) {
                //        System.out.println(cad);
                        Aux2.add(cad);
                    }
                    cad=br.readLine();
                    NumLineas++;
                    ElemBloque++;
                }

                Sort.BubbleSort(Aux2);								//ORDENAMIENTO BUBBLESORT CON AUX2
                F2.addAll(Aux2);
                F2.add("---------------------");
                Aux2.clear();
            }while(cad!=null);

         //   System.out.println("Este archivo tiene un total"
                    //+ " de "+NumLineas+" claves");



            FileMngmt.Escritura(F1,TamBloque,lec1);		//Escritura e impresion de nuestro primer ARCHIVO auxiliar
            //FileMngmt.Lectura(NumArchivosAux);
            //NumArchivosAux++;											//Aumento de la 'i' para la creacion del nombre de cada archivo auxiliar

            FileMngmt.Escritura(F2,TamBloque,lec2);		//Escritura e impresion de nuestro segundo ARCHIVO auxiliar
            //FileMngmt.Lectura(NumArchivosAux);

            TamBloque=TamBloque*2;									//Con cada creacion de archivos auxiliares, se asegura que los siguientes tengan el doble de tamaño

            Sort.Intercalado(lec1, lec2, Arreglo, i);

            Bandera=FileMngmt.SaberVacio(Arreglo);

            while(Bandera==false) {
                lec1=Arreglo[0];
                lec2=Arreglo[1];
                i++;
                i++;

                TamBloque=TamBloque*2;
                Sort.Intercalado(lec1, lec2,Arreglo, i);
                Bandera=FileMngmt.SaberVacio(Arreglo);
            }
            File Abrir1=new File(Arreglo[0]);
            Desktop.getDesktop().open(Abrir1);

            File f =new File (Arreglo[1]);
            f.delete();


        }
        catch(IOException e) {
            System.out.println("Error Polifase");
        }
    }
}
