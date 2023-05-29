package ExpresionAritmetica.Utilerias;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Clase ArbolBin - Genera Arbol Binario regular
 */
public class ArbolBin {
    public Nodo root;


    /**
     *
     * Constructor ArbolBin sin Parametro
     *
     */
    public ArbolBin() {

        root = null;
    }


    /**
     *
     * Constructor ArbolBin con cadena como parametro
     *
     * @param val - Cadena de Caracteres a Ingresar
     */
    public ArbolBin(String val) {

        root = new Nodo(val);
    }

    //Modified BFS: Nodes

    /**
     *
     * Breadth frist - Busca Nodos
     *
     * @param h  Nodo a Analizar
     * @return Nodo a Retornar
     */
    public Nodo breadthFrist(Nodo h) {

        Nodo r = root;

        if (r == h)
            return r;

        Queue<Nodo> queue = new LinkedList<>();

        if (r != null) {
            queue.add(r);

            while (!queue.isEmpty()) {
                r = queue.poll();

                if (r.izq == h || r.der == h)
                    return r;
                else
                if (r.izq != null)
                    queue.add(r.izq);
                if (r.der != null)
                    queue.add(r.der);
            }
        }
        return null;
    }

    //Print postfix notation

    /**
     *
     * Posfija - Imprime notacion posfija
     *
     * @param n  - nodo a imprimir
     */
    public void posfija(Nodo n) {


        if (n.izq != null)
            posfija(n.izq);

        if (n.der != null)
            posfija(n.der);

        System.out.println(n.valor);
    }

}
