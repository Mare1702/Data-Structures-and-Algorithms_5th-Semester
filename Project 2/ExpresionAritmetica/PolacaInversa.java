package ExpresionAritmetica;

import ExpresionAritmetica.Utilerias.*;
import java.util.*;


/**
 * The class Polaca inversa
 */
public class PolacaInversa {

    /**
     *
     * Constructor.
     * Método que nos permite hacer la captura de la operación a realizar y empezar a darle formato
     *
     *
     *

    //Método que nos permite hacer la captura de la operación a realizar y empezar a darle formato
    public static ArbolBin ArbolExpresion(
     */
    public PolacaInversa(){}

    public static ArbolBin ArbolExpresion(){

        String operacion, union="";
        Scanner Teclado=new Scanner(System.in);
        List<String> polacafinal=new LinkedList<>();
        List<String> aux=new LinkedList<>();
        String[] CADENAS;
        int indice=0, OpenPar=0;
        boolean bandera=true;
        Auxiliares var=new Auxiliares();

        System.out.println("Ingrese la operaci\u00F3n matem\u00E1tica que desea resolver, dicha operaci\u00F3n debe estar separada por par\u00E9ntesis");
        System.out.println("como el siguiente ejemplo ((5+5)*(7/(8+(23+9)))), deber\u00E1 agrupar todas las operaciones del mismo \u00EDndole (como se");
        System.out.println("muestra en el ejemplo, de lo contrario la expresión podría resolverse de forma err\u00F3nea y el algoritmo no se hace respon-");
        System.out.println("sable). Si desea hacer potencias use el car\u00E1ter \"\u02C4\" y si quiere hacer una ra\u00EDz use el car\u00E1ter \"\u00BF\",");
        System.out.println("para esta operaci\u00F3n matem\u00E1tica debe escribirla de la siguiente forma \"\u00BFnum\" d\u00F3nde num es el n\u00FAmero a");
        System.out.println("calcular la ra\u00EDz cuadrada.");
        operacion=Teclado.nextLine();

        String[] polaca=operacion.split("");

        for (String revision:polaca) {
            switch (revision){
                case "0":
                    aux.add(revision);
                    break;
                case "1":
                    aux.add(revision);
                    break;
                case "2":
                    aux.add(revision);
                    break;
                case "3":
                    aux.add(revision);
                    break;
                case "4":
                    aux.add(revision);
                    break;
                case "5":
                    aux.add(revision);
                    break;
                case "6":
                    aux.add(revision);
                    break;
                case "7":
                    aux.add(revision);
                    break;
                case "8":
                    aux.add(revision);//a[1]=8 a[2]=8
                    break;
                case "9":
                    aux.add(revision);
                    break;
                default:
                    if(aux.isEmpty())
                        polacafinal.add(revision);
                    else {
                        for (String revision2:aux) {
                            union=union+revision2;
                        }
                        polacafinal.add(union);
                        aux.clear();
                        polacafinal.add(revision);

                        union="";
                    }
                    break;
            }
        }
        indice=polacafinal.size();
        CADENAS=new String[indice];
        indice=0;
        for(String cadenas:polacafinal){
            if(cadenas.equals("(")&&bandera)
                OpenPar++;
            if(cadenas.equals(")"))
                bandera=false;
            CADENAS[indice++]=cadenas;
        }
        ArbolBin arbol=CrearArbol(CADENAS, OpenPar, var);
        return arbol;
    }


    /**
     *  BFS
     *  Método que nos permite llamar a breadthFrist del código Auxiliares
     *
     * @param raiz  the raiz
     */
    public void BFS(Nodo raiz){

        Auxiliares var=new Auxiliares();
        var.breadthFrist(raiz);
    }


    /**
     *
     * Recorrido
     * Método que nos permite llamar a recorrido del código Auxiliares
     *
     * @param node  the node
     * @return List
     */
    public List<Nodo> Recorrido(Nodo node){

        Auxiliares var=new Auxiliares();
        return var.recorrido(node);
    }


    /**
     *
     * Crear arbol
     * Método que nos permite hacer la creación del Árbol Binario de Expresiones Aritméticas
     *
     * @param expresion  the expresion
     * @param OpenPar  the open par
     * @param var  the var
     * @return ArbolBin
     */
    public static ArbolBin CrearArbol(String[] expresion, int OpenPar, Auxiliares var){

        int lugar=0, alto=expresion.length;
        ArbolBin arbol=new ArbolBin("a");
        ArbolBin auxiliar=new ArbolBin();
        Nodo nodoActual=arbol.root;
        Stack<Nodo> stackFathers=new Stack<>();
        boolean correcto, bandera=true;

        if(OpenPar>1) {
            bandera = false;
            OpenPar--;
        }
        correcto=var.formaCorrecta(expresion);
        if(!correcto)
            lugar=alto;
        stackFathers.push(nodoActual);
        for(;lugar<alto;lugar++){
            if(expresion[lugar].equals("(")){
                nodoActual.izq=new Nodo();
                stackFathers.push(nodoActual);
                nodoActual=nodoActual.izq;
            }
            if(!expresion[lugar].equals("+")&&!expresion[lugar].equals("-")&&!expresion[lugar].equals("*")&&!expresion[lugar].equals("/")&&!expresion[lugar].equals("^")&&!expresion[lugar].equals("¿")) {
                if(!expresion[lugar].equals(")")&&!expresion[lugar].equals("(")) {
                    if (nodoActual != auxiliar.root)
                        nodoActual.valor = expresion[lugar];
                    if (!stackFathers.isEmpty())
                        arbol.root = stackFathers.pop();
                    nodoActual = arbol.root;
                }
            }
            if(expresion[lugar].equals("+")||expresion[lugar].equals("-")||expresion[lugar].equals("*")||expresion[lugar].equals("/")||expresion[lugar].equals("^")||expresion[lugar].equals("¿")){
                nodoActual.valor=expresion[lugar];
                nodoActual.der=new Nodo();
                if(bandera) {
                    auxiliar.root=nodoActual;
                    bandera=false;
                }
                stackFathers.push(nodoActual);
                nodoActual=nodoActual.der;
            }
            if(expresion[lugar].equals(")")){
                if(OpenPar>1)
                    OpenPar--;
                if(OpenPar==1) {
                    bandera = true;
                    OpenPar=0;
                }
                if(!stackFathers.isEmpty())
                    nodoActual=stackFathers.pop();
            }
        }
        return auxiliar;
    }



    /**
     *
     * Respuesta
     * Método que nos permite llamar a resolver del código Auxiliares
     * @param OPS_OPD  the  OP s_ OPD
     */
    public static void respuesta(List<String> OPS_OPD){

        Auxiliares var=new Auxiliares();
        var.resolver(OPS_OPD);
    }
}
