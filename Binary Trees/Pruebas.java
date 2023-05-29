
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
import java.util.Scanner;
public class Pruebas {

    public static void main(String args[]){
       ArbolBin arbol=null;
        int Nds=0, N=0,NodoHijo=0,NodoBuscado;
        int ValoresNodo[]=null; 
        boolean SalidaTryCatch=false,EncuentroNds=false;
        int opc;
        Scanner Scan=new Scanner(System.in);
        ValoresNodo=new int [150];

        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1,n7,n9);
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);
        
        arbol = new ArbolBin(n1);
        arbol.add(n7,n15,0);//
        arbol.add(n7,n8,1);//
        arbol.add(n9,n4,0);//
        arbol.add(n9,n2,1);//
        arbol.add(n15,n16,1);//
        arbol.add(n8,n3,0);
        System.out.print("La BFS del árbol es:");
        arbol.breadthFrist();
        System.out.println("----------------------------------------------------");
        System.out.print("¿Qué nodo desea buscar? Por favor ingrese su valor (Por favor presione 2 veces enter después de ingresar el dato): ");
        NodoBuscado=Scan.nextInt();
        arbol.FindNodes(NodoBuscado);
    }

    
}
