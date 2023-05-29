package Equilibrado;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
/**
 * Clase principal para la ejecución del algoritmo Mezcla Equilibrada.
 * @author Cote Valencia Alexis Daniel
 * @author Recinos Hernández Luis Mario
 * @author Roman Jiménez Adolfo
 */
public class MezclaEquilibrada{
    /**
     * Método MezclaEquilibrada tipo void, se añaden throws IOException y FileNotFoundException para ahorrar tiempo y renglones
     * con los try catch
     * @param String archivo_lectura archivo que se ordenará
     */
    public static void MezclaEquilibrada(String archivo_lectura)throws IOException, FileNotFoundException{
        String archivo_escritura, archivo_escritura2, ArchivoOrdenado="./ArchivosMezclaEquilibrada/Archivo Ordenado.txt", Rultimo, Rultimo2;
        Scanner Teclado=new Scanner(System.in);
        boolean bandera= false;
        int i=1;
        PrintWriter fileFinal;

        //Creación de un archivo vacío para agregar el archivo ordenado.
        fileFinal=new PrintWriter(new FileWriter(ArchivoOrdenado, true));

        File Abrir1=new File(archivo_lectura);
        Desktop.getDesktop().open(Abrir1);

        bandera = SaberSiOrdenado.ordenado(archivo_lectura);
        //Se divide por primera vez el archivo a ordenar en f1 y f2 con lectura_escritura.
        //Luego se hace la mezcla de los archivos poniéndo dicha mezcla en f3 con escritura_union.
        if(bandera==false){
            archivo_escritura=("./ArchivosMezclaEquilibrada/f"+i+".txt");
            i++;
            archivo_escritura2=("./ArchivosMezclaEquilibrada/f"+i+".txt");
            i++;
            LecturaEscrituraPrimera.lectura_escritura(archivo_lectura, archivo_escritura, archivo_escritura2);
            archivo_lectura=LecturaEscrituraPrimera.escritura_union(archivo_escritura, archivo_escritura2, i);
        }
        //Ciclo que se ejecutarpa hasta tener el archivo ordenado, dividiendo los archivos y juntándolos con la misma lógica
        //del If anterior llamando en cada iteración a ordenado para ver si el archivo ya se ordenó.
        while(bandera==false){
            i++;
            archivo_escritura=("./ArchivosMezclaEquilibrada/f"+i+".txt");
            i++;
            archivo_escritura2=("./ArchivosMezclaEquilibrada/f"+i+".txt");
            i++;
            LecturaEscritura.lectura_escritura(archivo_lectura, archivo_escritura, archivo_escritura2);
            archivo_lectura=LecturaEscritura.union(archivo_escritura, archivo_escritura2, i);
            bandera=SaberSiOrdenado.ordenado(archivo_lectura);

        }
        FileReader lecturaUltima=new FileReader(archivo_lectura);
        BufferedReader cadenaUltima=new BufferedReader(lecturaUltima);
        Rultimo=cadenaUltima.readLine();
        //Ciclo que se ejecuta para hacer la copia del archivo ordenado omitiendo el último renglón ya que no es necesario.
        while(Rultimo.equals("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~")==false){
            fileFinal.println(Rultimo);
            Rultimo=cadenaUltima.readLine();
        }
        fileFinal.close();
        cadenaUltima.close();
        File Abrir2=new File(ArchivoOrdenado);
        Desktop.getDesktop().open(Abrir2);
    }
}
