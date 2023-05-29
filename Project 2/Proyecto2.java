import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import ExpresionAritmetica.*;
import ExpresionAritmetica.Utilerias.ArbolBin;
import ExpresionAritmetica.Utilerias.Nodo;
import Heap.*;
import ArbolAVL.*;


/**
 * Proyecto2
 *
 * Segundo proyecto para la materia de
 * Estructuras de Datos y Algoritmos II
 *
 * @author Adolfo, Alexis, Mario y Bryan
 * @version 1.0
 *
 */
public class Proyecto2
{

    /**
     *
     * Main (Menu Principal)
     * <br>
     * <br>
     *
     * Este el metodo principal, contiene el acceso a<br>
     * los diferentes algortimos realizados
     *
     * @param args  the args
     */
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int option;

        do
        {
            do
            {
                System.out.println("1. \u00C1rbol AVL");
                System.out.println("2. Heap");
                System.out.println("3. \u00C1rbol de Expresi\u00F3n Aritm\u00E9tica");
                System.out.println("4. Salir");

                option = scan.nextInt();
            }
            while (option < 1 || option > 4);

            switch (option)
            {
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
            }

        }
        while(option != 4);
    }

    //Menu Opcion 1


    /**
     *
     * Metodo de ArbolAVL
     *
     */
    public static void option1()
    {

        Scanner AVLScan = new Scanner(System.in);
        AVL AVLTree = new AVL();
        int AVLOption;
        int AVLvalor;

        do
        {
            do
            {
                System.out.println("1. Agregar Clave");
                System.out.println("2. Buscar un Valor");
                System.out.println("3. Eliminar Clave");
                System.out.println("4. Mostrar Arbol");
                System.out.println("5. Salir");

                AVLOption = AVLScan.nextInt();
            }
            while (AVLOption < 1 || AVLOption > 5);

            switch (AVLOption)
            {
                case 1:
                    System.out.print("Clave a insertar: ");
                    AVLvalor = AVLScan.nextInt();
                    AVLTree.insert(AVLvalor);
                    break;
                case 2:
                    System.out.print("Valor a buscar: ");
                    AVLvalor = AVLScan.nextInt();
                    AVLTree.search(AVLvalor);
                    break;
                case 3:
                    System.out.print("Valor a eliminar: ");
                    AVLvalor = AVLScan.nextInt();
                    AVLTree.delete(AVLvalor);
                    break;
                case 4:
                    AVLTree.breadthFrist(AVLTree.root);
                    break;
            }
        }
        while (AVLOption != 5);
    }

    //Menu Opcion 2


    /**
     *
     * Metodo de Heap
     *
     */
    public static void option2()
    {

        Scanner heapScan = new Scanner(System.in);
        Heap heapTree = new Heap();
        int heapOption;
        int valor;

        do
        {
            do
            {
                System.out.println("1. Agregar clave");
                System.out.println("2. Eliminar Ra\u00EDz");
                System.out.println("3. Mostrar \u00C1rbol");
                System.out.println("4. Salir");

                heapOption = heapScan.nextInt();
            }
            while (heapOption < 1 || heapOption > 4);

            switch (heapOption)
            {
                case 1:
                    System.out.print("Valor a insertar: ");
                    valor = heapScan.nextInt();
                    heapTree.insert(valor);
                    break;
                case 2:
                    heapTree.delMax();
                    break;
                case 3:
                    heapTree.printValues();
                    break;
            }
        }
        while (heapOption != 4);
    }

    //Menu Opcion3

    /**
     *
     * Metodo de Operacion Polaca Inversa
     *
     */
    public static void option3() {

        Scanner aritScan = new Scanner(System.in);
        PolacaInversa aritTree = new PolacaInversa();
        int aritOption;
        ExpresionAritmetica.Utilerias.ArbolBin arbol=new ArbolBin();
        List<Nodo> Recorrido;
        List<String> OPS_OPD=new LinkedList<>();

        do
        {
            do
            {
                System.out.println("1. Agregar expres\u00F3n aritm\u00E9tica.");
                System.out.println("2. Mostrar \u00C1rbol.");
                System.out.println("3. Resolver");
                System.out.println("4. Salir");

                aritOption = aritScan.nextInt();
            }
            while (aritOption < 1 || aritOption > 4);

            switch (aritOption)
            {
                case 1:
                    arbol=aritTree.ArbolExpresion();
                    break;
                case 2:
                    aritTree.BFS(arbol.root);
                    break;
                case 3:
                    Recorrido= aritTree.Recorrido(arbol.root);
                    System.out.println("A continuaci\u00f3n se muestra el recorrido en notaci\u00F3n Post-orden (Post-fija)");
                    for(Nodo imprimir:Recorrido) {
                        System.out.print(imprimir.valor + " ");
                        OPS_OPD.add(imprimir.valor);
                    }
                    aritTree.respuesta(OPS_OPD);
                    System.out.println();
                    break;
            }
        }
        while (aritOption != 4);
    }
}
