package ExpresionAritmetica.Utilerias;
import java.util.*;

/**
 * Clase Auxilares - Contiene los metodos auxialiares del arbol binario
 */

public class Auxiliares extends ArbolBin{

    public static List<Nodo> PostOrden=new LinkedList<>();
    Stack<Double>operandos=new Stack<>();
    int contador;

    /**
     * onstructor vacío para realizar instancias
     */

    public Auxiliares(){}

    /**
     *
     * BreadthFrist -
     *
     * Recorrido del árbol e impresiones de pantalla que nos indican al nodo hijo derecho, izquierdo, al padre y a la raíz
     * @param raiz Toma la raiz del arbol para iterar
     * @return Nodo
     */

    public Nodo breadthFrist(Nodo raiz){
        List<Nodo> padres=new LinkedList<>();
        Nodo r = raiz;
        Queue<Nodo> queue = new LinkedList<>();
        int contador=0;

        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
                if(r.izq!=null&&r.der!=null) {
                    padres.add(r);
                    padres.add(r);
                }
                else {
                    if(r.izq!=null||r.der!=null)
                        padres.add(r);
                }
                if(r==raiz) {
                    System.out.println("Raiz---->"+r.valor);
                }
                if(r.izq!=null&&r.der!=null){
                    System.out.println("("+padres.get(contador).valor+")--I-->"+r.izq.valor);
                    contador++;
                    System.out.println("("+padres.get(contador).valor+")--D-->"+r.der.valor);
                    contador++;
                }
                else{
                    if(r.izq!=null||r.der!=null){
                        if(r.izq!=null){
                            System.out.println("("+padres.get(contador).valor+")--I-->"+r.izq.valor);
                        }
                        else{
                            System.out.println("("+padres.get(contador).valor+")--D-->"+r.der.valor);
                        }
                        contador++;
                    }
                }
                if(r.izq!=null)
                    queue.add(r.izq);
                if(r.der!=null)
                    queue.add(r.der);
            }
        }
        return raiz;
    }

    /**
     *
     * formaCorrecta
     * Corrobora que la expresión a resolver mediante árbol binario cumpla con el formato correcto
     * @param expresion Expresion dentro de un arreglo
     * @return Regresa Verdadero o Falso
     */


    public boolean formaCorrecta(String[] expresion){
        int alto=expresion.length, lugar=0, parAbre=0, parCierra=0;

        for(String PAR: expresion){
            if(PAR.equals("("))
                parAbre++;
            if(PAR.equals(")"))
                parCierra++;
        }

        for(; lugar<alto; lugar++) {
            if (lugar == 0 && (expresion[lugar + 1].equals("+") || expresion[lugar + 1].equals("-") || expresion[lugar + 1].equals("*") || expresion[lugar + 1].equals("/") || expresion[lugar + 1].equals("^")|| expresion[lugar + 1].equals("¿"))) {
                System.out.println("\nLa expresi\u00F3n es incorrecta ya que no puede iniciar la expresi\u00F3n matem\u00E1tica con operandos.");
                return false;
                //+5/8
            }
            if (expresion[alto - 1].equals("+") || expresion[alto - 1].equals("-") || expresion[alto - 1].equals("*") || expresion[alto - 1].equals("/") || expresion[alto - 1].equals("^") || expresion[alto - 1].equals("¿")) {
                System.out.println("\nLa expresi\u00F3n es incorrecta ya que no puede terminar la expresi\u00F3n matem\u00E1tica con operandos.");
                return false;
                //5/8*
            }
            if (!expresion[0].equals("(")) {
                System.out.println("\nLa expresi\u00F3n es incorrecta ya que debe iniciar con par\u00E9ntesis tal como en el ejemplo.");
                return false;
                //5/8)
            }
            if(expresion[lugar].equals("(")) {
                if (expresion[lugar + 1].equals("+") || expresion[lugar + 1].equals("*") || expresion[lugar + 1].equals("/") || expresion[lugar + 1].equals("^")) {
                    System.out.println("La expresi\u00F3n es incorrecta ya que no puede haber operandos despu\u00E9s de un par\u00E9ntesis.");
                    System.out.println("A menos que sea \"\u00BF\" para denotar la ra\u00EDz.");
                    return false;
                    //(+5    (/5
                } else if (expresion[lugar + 1].equals("-")) {
                    System.out.println("La expresi\u00F3n es incorrecta, si desea ingresar n\u00FAmeros negativos reformule la expresi\u00F3n.");
                    return false;
                    //(-8
                }
            }
            if(parAbre!=parCierra) {
                System.out.println("\nLa expresi\u00F3n es incorrecta ya que no contiene el mismo n\u00FAmero de par\u00E9ntesis que abren y cierran.");
                return false;
                //((()))
            }
        }
        return true;
    }

    /**
     * Recorrido -
     * Método que nos permite llamar al método posfija
     * @param node Nodo por el cual se generara el recorrido
     * @return Regresa lista de nodos
     */

    public List<Nodo> recorrido(Nodo node){
        PostOrden.clear();
        posfija(node);
        return PostOrden;
    }

    /**
     * posfija
     * Método para realizar el recorrido del árbol en notación Post-Orden/Post-Fija
     * @param node Nodo de iteracion posfija
     */

    public void posfija(Nodo node){
        if(node.izq!=null)
            posfija(node.izq);
        if(node.der!=null)
            posfija(node.der);
        PostOrden.add(node);
    }

    /**
     * Resolver
     * Método que nos permite realizar la resolución de nuestro árbol usando la lista PostOrden
     */


    public void resolver(List<String> OPS_OPD){
        int posicion=0, Size=OPS_OPD.size();
        String valor=OPS_OPD.get(posicion);

        do{
            if(valor!=null){
                if (!valor.equals("¿")){//¿16
                    if(valor.equals("+") || valor.equals("-") || valor.equals("*") || valor.equals("/") || valor.equals("^")) {
                        contador=2;
                        operacion(valor.charAt(0));
                        posicion++;
                    }
                    else{
                        operandos.push(Double.parseDouble(valor));
                        posicion++;
                    }
                }
                else {
                    contador=1;
                    posicion++;
                    operacion(valor.charAt(0));
                }
                try {
                    valor = OPS_OPD.get(posicion);
                }catch (Exception e){}
            }else
                valor=OPS_OPD.get(++posicion);
        }while(posicion<Size);
        System.out.println("\nEl resultado es: "+operandos.pop());
    }

    /**
     * Operacion -
     * Método que nos permite revisar cuál operación matemática se va a realizar
     */
    //
    public void operacion(char op){
        if(contador==2){
            double b=operandos.pop();
            double a=operandos.pop();
            switch (op){
                case '+':
                    operandos.push(a+b);
                    break;
                case '-':
                    operandos.push(a-b);
                    break;
                case '*':
                    operandos.push(a*b);
                    break;
                case '/':
                    operandos.push(a/b);
                    break;
                case '^':
                    operandos.push(Math.pow(a,b));
                    break;
            }
        }
        else if(contador==1){
            double a=operandos.pop();
            operandos.push(Math.sqrt(a));
        }
    }
}
