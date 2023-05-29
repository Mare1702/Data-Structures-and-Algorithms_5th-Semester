
package practica10eda;

import java.io.*;
import java.util.Scanner;


public class Archivo {
    
    public void crearArchivo(String nombre) throws IOException{
        File archivo = new File (nombre);
        if (archivo.exists()){
            System.out.println("Ya existe el archivo.\n");  
        } else{
            FileWriter fw = new FileWriter(archivo);
            System.out.println("Se creó el archivo exitosamente.\n");  
            escribir(nombre, false);
            fw.close();                 
        }
        
    }
    
    public void escribir(String nombre, boolean modo) throws IOException{
        File archivo = new File (nombre);
        if(archivo.exists()){
            FileWriter fw = new FileWriter(archivo, modo);
            Scanner sc= new Scanner(System.in);
            String cadena;
            System.out.println("Añadir contenido: ");
            cadena=sc.nextLine();
            fw.write(cadena);
            fw.close();
        }
        else{
            System.out.println("No existe el archivo.");
        }
        
    }    
    
    public void eliminar(String nombre) throws IOException{
        File archivo = new File (nombre);
        if(archivo.exists()){
            archivo.delete();
        }
        else{
            System.out.println("No existe el archivo.");
        }
    }
    
}


