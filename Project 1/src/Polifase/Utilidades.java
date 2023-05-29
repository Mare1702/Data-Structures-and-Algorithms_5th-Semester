package Polifase;
import java.util.ArrayList;
import java.io.*;
/**
 * Clase secundiaria usada por Polifase parala reorganizacion de las claves
 * encontradas tanto en las listas de arreglos como en los archivos
 * auxiliares creados
 * Declaramos los dos contadores para llevar a cabo un ordenamiento por
 * BubbleSort
 * @version 1.0
 * @author Mare
 * @param i Contador para indicar el fin de la lisya a recorres
 * @param j Contador que nos permite comparar una posición n en la lisya con su n+1
 */
public class Utilidades {
    int i=0,j=0;
    /**
     * Mediante dos contadores, este algoritmo recorre todos los lugares dentro de la
     * lista de arreglos comparando todos los pares de valores en el mismo, llamando al
     * método estático 'swap' simpre que un lugar n sea mayor lexicográficamente que
     * su n+1.
     * @param Aux1 Arreglo de un bloque claves que se desean ordenar lexicográficamente
     */

    public void BubbleSort(ArrayList <String>Aux1) {

        for (i=Aux1.size()-1;i>0;i--) {
            for (j=0;j<i;j++) {
                if(Aux1.get(j).compareTo(Aux1.get(j+1))>0) {
                    swap(Aux1,j);
                }
            }
        }
    }

    /**
     * Manejando archivos, se hace uso de booleanos y comparaciones
     * con los separadores introducidos al término de cada bloque
     * para ir escribiendo contenido de dos archivos en otros dos
     * archivos auxiliares de manera intercalara con bloques del
     * doble del tamaño que los bloques origen.
     * @param Arreglo [] Arreglo de dos strings que representarán el nombre del par de archivos auxiliares que se produciran en el método
     * @param uno Archivo auxiliar cuyos bloques queremos intercalar con los de otro archivo auxiliar de la misma iteracion
     * @param dos Segundo archivo auxiliar para intercalar con el parámetro 'uno'
     * @param cont Contador que lleva la cuenta del número de archivos auxiliares que se tienen hasta el momento
     */

    public void Intercalado(String uno, String dos,String []Arreglo, int cont)  throws IOException, FileNotFoundException{

        Arreglo[0]=("./ArchivosPolifase/FP"+cont+".txt");
        cont++;
        Arreglo[1]=("./ArchivosPolifase/FP"+cont+".txt");
        cont++;
        String R1,R2;
        boolean Bandera=true;
        PrintWriter pw1,pw2;
        pw1= new PrintWriter(new FileWriter(Arreglo[0], true));
        pw2= new PrintWriter(new FileWriter(Arreglo[1], true));

        FileReader fr=new FileReader(uno);
        BufferedReader br=new BufferedReader(fr);
        R1= br.readLine();

        FileReader fr2=new FileReader(dos);
        BufferedReader br2=new BufferedReader(fr2);
        R2= br2.readLine();


        while(R1!=null) {
            if(R1.equals("---------------------")) {
                if(R2==null) {
                    if(Bandera==true) {
                        pw1.println(R1);
                        R1=br.readLine();
                    }
                    else {
                        pw2.println(R1);
                        R1=br.readLine();
                    }
                }
                else {
                    if(R2.equals("---------------------")) {
                        if(Bandera==true) {
                            pw1.println(R1);
                            R1=br.readLine();
                            R2=br2.readLine();
                            Bandera=!Bandera;
                        }
                        else {
                            pw2.println(R1);
                            R1=br.readLine();
                            R2=br2.readLine();
                            Bandera=!Bandera;
                        }
                    }
                    else{
                        if(Bandera==true) {
                            pw1.println(R2);
                            R2=br2.readLine();
                        }
                        else {
                            pw2.println(R2);
                            R2=br2.readLine();
                        }
                    }
                }
            }
            else {
                if(R2==null) {

                    if(Bandera==true) {
                        pw1.println(R1);
                        R1=br.readLine();
                    }
                    else {
                        pw2.println(R1);
                        R1=br.readLine();
                    }
                }
                else {
                    if(R2.equals("---------------------")) {

                        if(Bandera==true) {
                            pw1.println(R1);
                            R1=br.readLine();

                        }
                        else {
                            pw2.println(R1);
                            R1=br.readLine();

                        }
                    }
                    else{
                        if(R1.compareTo(R2)<0) {
                            if(Bandera==true) {
                                pw1.println(R1);
                                R1=br.readLine();
                            }
                            else {
                                pw2.println(R1);
                                R1=br.readLine();
                            }
                        }
                        else {
                            if(Bandera==true) {
                                pw1.println(R2);
                                R2=br2.readLine();
                            }
                            else {
                                pw2.println(R2);
                                R2=br2.readLine();
                            }
                        }
                    }
                }
            }
        }
        pw1.close();
        pw2.close();
        br.close();
        br2.close();

    }

    /**
     * Método encargado del intercambio de las posiciones 'n' y 'n+1'
     * dentro de un bloque de claves
     * @param Aux1 Al igual que con BubbleSort, se recive el bloque de claves a ordenar
     * @param j Contador ocupado para referenciar los lugares en el bloque donde se requiera hacer el intercambio
     */

    public static void swap(ArrayList <String>Aux1,int j) {
        String var=Aux1.get(j);
        Aux1.set(j,Aux1.get(j+1));
        Aux1.set(j+1, var);
    }
}
