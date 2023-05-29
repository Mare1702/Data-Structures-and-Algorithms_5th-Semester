package ArbolBinario;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 * Clase Arbol Binario
 */
public class ArbolBin {
    Nodo root;


    /**
     *
     * Constructor de ArbolBinario sin parametro
     *
     */
    public ArbolBin() {

        root = null;
    }


    /**
     *
     * Constructor de Arbol Binaro con Raiz y Parametro Entero
     *
     * @param val  - Valor a colocar como raiz
     */
    public ArbolBin(int val) {

        root = new Nodo(val);
    }


    /**
     *
     * Constructor de Binario - Asocia un nodo al nodo raiz
     *
     * @param root  Nodo Raiz
     */
    public ArbolBin(Nodo root) {

        this.root = root;
    }


    /**
     *
     * Add - Agrega
     *
     * @param padre  the padre
     * @param hijo  the hijo
     * @param lado  the lado
     */
    public void add(Nodo padre, Nodo hijo, int lado) {

        if (lado == 0)
            padre.setIzq(hijo);
        else
            padre.setDer(hijo);
    }

    //add value


    /**
     *
     * Add
     *
     */
    public void add()
    {

        Scanner scan = new Scanner(System.in);
        int index, side, val;

        LinkedList<Nodo> nodeList = nodeList();

        //Arbol: [ 1 6 8 9 7 2 ]

        System.out.print("Valor: ");
        val = scan.nextInt();

        System.out.print("Padre: ");
        index = scan.nextInt();

        System.out.print("Lado: ");
        side = scan.nextInt();

        Nodo h = new Nodo(val);

        for (Nodo nodo: nodeList)
        {
            if (nodo.valor == index)
            {
                if(side == 0)
                {
                    h.izq = nodo.izq;
                    nodo.izq = h;
                }
                else
                {
                    h.der = nodo.der;
                    nodo.der = h;
                }
            }
        }
    }

    protected void visit(Nodo n) {
        System.out.println(n.valor + " ");
    }

    //Original BFS

    /**
     *
     * Breadth frist
     *
     */
    public void breadthFrist() {

        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();

        if (r != null) {
            queue.add(r);

            while (!queue.isEmpty()) {
                r = queue.poll();
                visit(r);

                if (r.izq != null)
                    queue.add(r.izq);
                if (r.der != null)
                    queue.add(r.der);
            }
        }
    }

    //Original BFS

    /**
     *
     * Node list
     *
     * @return LinkedListNodo;
     */
    public LinkedList<Nodo> nodeList() {

        Nodo r = root;
        Queue<Nodo> queue = new LinkedList<>();
        LinkedList<Nodo> nodos = new LinkedList<>();

        System.out.print("Arbol: [ "); // Arbol: [ 1 6 8 9 7 2 ]
        if (r != null) {
            queue.add(r);

            while (!queue.isEmpty()) {
                r = queue.poll();
                nodos.add(r);
                System.out.print(r.valor + " ");

                if (r.izq != null)
                    queue.add(r.izq);
                if (r.der != null)
                    queue.add(r.der);
            }
            System.out.print("]\n");
        }
        return nodos;
    }

    //Modified BFS: Nodes

    /**
     *
     * Breadth frist
     *
     * @param h  the h
     * @return Nodo
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

    //BFS looks for value

    /**
     *
     * Breadth frist
     *
     * @param n  the n
     */
    public void breadthFrist(int n) {

        Nodo r = root;

        String found = "no";

        Queue<Nodo> queue = new LinkedList<>();

        if (r != null) {
            queue.add(r);

            while (!queue.isEmpty()) {
                r = queue.poll();

                if (r.valor == n) {
                    found = "si";
                    break;
                } else {
                    if (r.izq != null)
                        queue.add(r.izq);
                    if (r.der != null)
                        queue.add(r.der);
                }
            }
        }
        System.out.println(found);
    }



    /**
     *
     * Delete node
     *
     * @param i  the i
     */
    public void deleteNode(int i)
    {

        Nodo n = searchNode(i);
        deleteNode(n);
    }



    /**
     *
     * Search node
     *
     * @param n  the n
     * @return Nodo
     */
    public Nodo searchNode(int n) {

        Nodo r = root;

        Queue<Nodo> queue = new LinkedList<>();

        if (r != null) {
            queue.add(r);

            while (!queue.isEmpty()) {
                r = queue.poll();

                if (r.valor == n)
                {
                    return r;
                }
                else
                {
                    if (r.izq != null)
                        queue.add(r.izq);
                    if (r.der != null)
                        queue.add(r.der);
                }
            }
        }
        return null;
    }

    //Deletes specific node

    /**
     *
     * Delete node
     *
     * @param h  the h
     */
    public void deleteNode(Nodo h) {

        if (h != null)
            if (h.izq == null && h.der == null)
            {
                Nodo p = breadthFrist(h);

                if (p == null)
                    return;

                switchNodes(p, h);
            }
            else
            {
                switchNodes(h);
            }
    }

    //Leaf node rearrange

    /**
     *
     * Switch nodes
     *
     * @param p  the p
     * @param h  the h
     */
    public void switchNodes(Nodo p, Nodo h) {

        do {
            if (h.izq == null && h.der == null) {
                if (p == h)
                    root = null;
                else if (p.izq == h)
                    p.izq = null;
                else
                    p.der = null;
                break;
            }
            else
                p = h;
            if (h.izq != null) {
                h.valor = h.izq.valor;
                h = h.izq;
            } else {
                h.valor = h.der.valor;
                h = h.der;
            }
        }
        while (true);
    }

    //Node rearrange

    /**
     *
     * Switch nodes
     *
     * @param h  the h
     */
    public void switchNodes(Nodo h) {

        Nodo p = root;

        do {
            if (h.izq == null && h.der == null)
            {
                if (p.izq == h)
                    p.izq = null;
                else
                    p.der = null;
                break;
            }
            else
            {
                p = h;

                if (h.izq != null)
                {
                    h.valor = h.izq.valor;
                    h = h.izq;
                }
                else
                {
                    h.valor = h.der.valor;
                    h = h.der;
                }
            }
        }
        while (true);
    }

    //General notation print method


    /**
     *
     * Notation
     *
     * @param s  the s
     */
    public void notation(String s)
    {

        Nodo n = root;

        switch (s)
        {
            case "prefija":
                prefija(n);
                break;
            case "infija":
                infija(n);
                break;
            case "posfija":
                posfija(n);
                break;
            default:
                break;
        }
    }

    //Prints prefix notation

    /**
     *
     * Prefija
     *
     * @param n  the n
     */
    public void prefija(Nodo n) {

        System.out.println(n.valor);

        if (n.izq != null)
            prefija(n.izq);

        if (n.der != null)
            prefija(n.der);
    }

    //Prints infix notation

    /**
     *
     * Infija
     *
     * @param n  the n
     */
    public void infija(Nodo n) {

        if (n.izq != null)
            infija(n.izq);

        System.out.println(n.valor);

        if (n.der != null)
            infija(n.der);
    }

    //Print postfix notation

    /**
     *
     * Posfija
     *
     * @param n  the n
     */
    public void posfija(Nodo n) {


        if (n.izq != null)
            posfija(n.izq);

        if (n.der != null)
            posfija(n.der);

        System.out.println(n.valor);
    }
}
