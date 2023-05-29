package practica10eda;

import java.io.IOException;
import java.util.Scanner;

public class Practica10EDA{

    
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner (System.in);
        int o;
        String nombre;
        Archivo arch = new Archivo();
        System.out.println("Archivos :D");
        do{
            System.out.println("\n1.Crear Archivo\n2.Sobreescribir en el archivo\n3.Añadir contenido en el archivo\n4.Elimina el archivo\n5.Salir\n");
            o=sc.nextInt();
            switch(o){
                case 1:
                    System.out.println("Ingresa el Nombre del archivo con su extension: ");
                    nombre=sc.next();
                    arch.crearArchivo(nombre);
                    break;
                case 2:
                    System.out.println("Ingresa el Nombre del archivo con su extension:");
                    nombre=sc.next();
                    arch.escribir(nombre, false);
                    break;
                case 3:
                    System.out.println("Ingresa el Nombre del archivo con su extension:");
                    nombre=sc.next();
                    arch.escribir(nombre, true);
                    break;
                case 4:
                    System.out.println("Ingresa el Nombre del archivo con su extension:");
                    nombre=sc.next();
                    arch.eliminar(nombre);
                    break;
                default:
                    if (o!=5){
                        System.out.println("Opción inválida.");
                    }
                    break;
            }
        }while(o!=5);
    }
    
}

