import Equilibrado.*;
import Polifase.*;
import static radixSort.Radix.radixSort;
import java.io.*;
import java.util.*;

public class Menu{
    public static void main(String[] args)throws IOException, FileNotFoundException{
        char opcion, opcion2='s', opcion3;
        String archivo_lectura="";
        Scanner Teclado=new Scanner(System.in);

        do{
            Limpiar();
            System.out.println("Escoja la opci\u00f3n que desea ejecutar:\n\ta) Polifase\n\tb) Mezcla Equilibrada\n\tc) Por distribuci\u00fan(Radix)\n\td) Salir");
            System.out.print("\tElecci\u00f3n: ");
            opcion=Teclado.next().charAt(0);
            Teclado.nextLine();
            if(opcion!='d'&&opcion!='D'){
                System.out.print("\nIngrese el nombre del archivo junto con su extensi\u00f3n: ");
                archivo_lectura=Teclado.useDelimiter("\n").next();
                Limpiar();
            }

            switch(opcion){
                case 'a': case 'A':
                    File directorio=new File("./ArchivosPolifase");
                    deleteDir(directorio);
                    directorio.mkdirs();
                    Limpiar();
                    Polifase.TomaEImpresionDatos(archivo_lectura);
                    System.out.println("\n\n\nPresion Enter para continuar...");
                    break;
                case 'b': case 'B':
                    File directorio1=new File("./ArchivosMezclaEquilibrada");
                    deleteDir(directorio1);
                    directorio1.mkdirs();
                    Limpiar();
                    MezclaEquilibrada.MezclaEquilibrada(archivo_lectura);
                    System.out.println("\n\n\nPresion Enter para continuar...");
                    break;
                case 'c': case 'C':
                    File directorio2=new File("./ArchivosRadixExterno");
                    deleteDir(directorio2);
                    directorio2.mkdirs();
                    Limpiar();
                    radixSort(archivo_lectura);
                    System.out.println("\n\n\nPresion Enter para continuar...");
                    break;
                case 'd': case 'D':
                    opcion2='N';
                    System.out.println("\n\n\nPresion Enter para continuar...");
                    break;
                default:
                    break;
            }
            Teclado.useDelimiter("\n").next();
        }while(opcion2=='s'||opcion2=='S');
        Limpiar();
    }

    public static void Limpiar(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hacer nada*/
        }
    }

    private static void deleteDir(File file)throws IOException, FileNotFoundException{
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                deleteDir(f);
            }
        }
        file.delete();
    }
}
