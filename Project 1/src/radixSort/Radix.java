package radixSort;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Radix para ordenar listas por numero de cuenta en archivos .txt
 *
 * @author Adolf
 * @author Alexis
 * @author Mario
 * @version 1.0
 */

public class Radix {
    /***
     * Metodo principal: Itera con un do-while el archivo ingresado para ordernar lista por medio de RadixSort.
     *
     * @param location Contiene la direccion del archivo principal a ordenar
     * @throws IOException Envia excepcion si la direccion del archivo es inexistente
     */

    public static void radixSort(String location) throws IOException {
        /*
         Creamos lista de Buffers para escribir archivos finales
         */
        File Abrir1=new File(location);
        Desktop.getDesktop().open(Abrir1);

        List<BufferedWriter> holders = new ArrayList<>();

        /*
        Variable string para nombre de archivos
         */
        String name;

        /*
         * Crea archivos de texto donde escribir las iteraciones durante
         * el ciclo del algoritmo y deposita el buffer de cada archivo creado
         * dentro de la lista "holders".
         */
        for (int i = 0; i < 10; i++) {
            name = "./ArchivosRadixExterno/iteraciones" + i + ".txt";
            BufferedWriter f = new BufferedWriter(new FileWriter(name));
            holders.add(f);
        }

        /*
        Lleva la ciclos de las iteraciones a realizar e indica el digito
        con el que se esta trabajando de derecha a izquierda.
         */
        int times = 0;
        int maxLength = 0;

        radixLoop(location, times, holders, maxLength);

        /*
        Cierra los buffers de escritura en los archivos que
        contienen las iteraciones realizadas por el algoritmo
         */
        for (BufferedWriter w: holders) {
            w.close();
        }
    }

    /***
     * radixGet, devuelve digito a ordenar.<br>
     * Evalua la longitud del numero de cuenta y si es menor a 6 agrega ceros a la izquierda.<br>
     *
     * <ul>
     *   <li>Coffee</li>
     *   <li>Tea</li>
     *   <li>Milk</li>
     * </ul>
     *
     * @param account Numero de cuenta de donde extraeremos el digito a ordenar.
     * @param times Cantidad de iteraciones hasta este momento.
     * @return Digito entero del numero de cuenta en la posicion dependiendo de la iteracion.
     */

    public static int radixGet(int account, int times, int maxLength){
        StringBuilder digit = new StringBuilder(String.valueOf(account));

        while(digit.length() < maxLength) {
            digit.insert(0, "0");
        }

        String[] digits = digit.toString().split("");

        return Integer.parseInt(digits[(maxLength - 1) - times]);
    }

    /**
     * Ordena archivos en funcion del numero de cuenta <br>
     *
     * @param location Direccion del archivo que contiene la informacion a ordenar.
     * @param times Numero de iteracion global, la cual va desde 0 a 6.
     * @param holders Lista de buffers que escriben iteraciones en archivos.
     * @throws IOException Lanza excepcion en caso de que la direccion del archivo sea erronea.
     */

    public static void radixLoop(String location, int times, List<BufferedWriter> holders, int maxLength) throws IOException {

        String name;

        do
        {
            List<BufferedWriter> writers = new ArrayList<>();
            List<File> files = new ArrayList<>();

            List<String> elements;
            String line;

            int account;
            int digit;
            int iteration = 0;

            File file = new File(location);
            Scanner sc = new Scanner(file);

            BufferedWriter tmpw = new BufferedWriter(new FileWriter("./ArchivosRadixExterno/info2.txt"));
            File tmpf = new File("./ArchivosRadixExterno/info2.txt");

            for (int i = 0; i < 10; i++) {
                name = "a" + i + ".txt";
                BufferedWriter w = new BufferedWriter(new FileWriter(name));
                writers.add(w);
                File f = new File(name);
                files.add(f);
            }

            do {
                try {
                    line = sc.nextLine();
                    elements = Arrays.asList(line.split(","));

                    try{
                        account = Integer.parseInt(elements.get(2));
                    }catch (NumberFormatException e){
                        account = Integer.parseInt(elements.get(2).substring(1));
                    }

                    if(times == 0){
                        int length = (int) Math.log10(account) + 1;
                        if(length > maxLength){
                            maxLength = length;
                        }
                    }

                    digit = radixGet(account, times, maxLength);

                    writers.get(digit).write(line + "\n");
                    holders.get(digit).write(line + "\n");
                }
                catch (NoSuchElementException e) {
                    for (BufferedWriter h: holders) {
                        h.write("***************\n");
                    }
                    break;
                }
            }
            while (true);

            for (BufferedWriter w: writers) {
                w.close();
            }

            //System.out.println("\n*****");
            //System.out.println("\tCiclo: " + (times + 1));
            //System.out.println("*****\n");

            do {
                sc = new Scanner(files.get(iteration));

              //  System.out.println("Archivo: iteracion" + iteration + ".txt");

                do {
                    try {
                        line = sc.nextLine();
                     //   System.out.println(line);
                        tmpw.write(line + "\n");
                    }
                    catch (NoSuchElementException e) {
                     //   System.out.println("------------------------");
                        iteration++;
                        break;
                    }
                }
                while (true);
            }
            while (iteration != 10);

            tmpw.close();

            if(tmpf.renameTo(file)) {
                times++;

                if(times == maxLength) {
                    for (File f: files) {
                        f.delete();
                    }
                }
            }
            times++;
        }
        while(times != maxLength);
        File Abrir2=new File("./ArchivosRadixExterno/info2.txt");
        Desktop.getDesktop().open(Abrir2);

        //System.out.println("Longitud maxima de cuenta: " + maxLength);
    }
}
