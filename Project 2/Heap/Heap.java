package Heap;
import ArbolBinario.*;

import java.util.LinkedList;


/**
 * Clase Heap de Arbol Binario de Valor Maximo
 */
public class Heap
{
    Nodo root; /* Nodo raiz de la clase*/
    LinkedList<Nodo> list; /*Lista de nodos que integran el arbol*/
    int nodes; /*Cantidad de nodos contenidos*/



    /**
     *
     * Constructor de la clase Heap sin parametro integrado
     *
     */
    public Heap()
    {

        this.root = null;
        this.list = new LinkedList<>();
        this.nodes = 0;
    }



    /**
     *
     * Insert - Metodo General de Insercion
     *
     * @param i - El valor que se pretende incluir dentro del Arbol
     */
    public void insert(int i)
    {

        if(!search(i))
        {
            Nodo h = new Nodo(i);
            Nodo p;

            list.add(h);
            nodes += 1;

            int index = nodes / 2;

            if(root == null)
            {
                root = p = h;
            }
            else
            {
                p = list.get(index - 1);

                if(nodes % 2 == 0)
                    p.izq = h;
                else
                    p.der = h;
            }

            while(h.valor > p.valor)
            {
                h.valor = p.valor;
                p.valor = i;
                h = p;

                index /= 2;

                p = (index > 0) ? list.get(index - 1) : h;
            }
        }
    }



    /**
     *
     * delMax - Metodo General para Eliminar la Raiz
     *
     */
    public void delMax()
    {

        if (root != null)
        {
            int index = (nodes > 1) ? (nodes / 2) : 1;
            int val = list.getLast().valor;
            root.valor = val;

            Nodo p = root;
            Nodo h = list.get(index - 1);

            if (nodes == 1)
                root = null;
            else if (nodes % 2 == 0)
                h.izq = null;
            else
                h.der = null;

            list.removeLast();
            nodes -= 1;

            while (p.der != null)
            {
                h = p.der.valor > p.izq.valor ? p.der : p.izq;

                p.valor = h.valor;
                h.valor = val;
                p = h;
            }
        }
    }



    /**
     *
     * printValues - Imprime los valores del Arbol para su analisis
     *
     */
    public void printValues()
    {

        for (Nodo n : list)
        {
            if(n == root)
                System.out.println("Raiz---->"+ n.valor);
            else
                System.out.println("Nodo---->"+ n.valor);

            if(n.izq!= null)
                System.out.println("\tI-->"+n.izq.valor);
            if(n.der != null)
                System.out.println("\tD-->"+n.der.valor);
        }
    }



    /**
     *
     * Search - Metodo para buscar un valor dentro del Arbol
     *
     * @param i - Valor A Buscar
     * @return boolean - regresa un bool si el valor se encuentra o no
     */
    public boolean search(int i)
    {

        for (Nodo n: list)
            if(n.valor == i)
                return true;
        return false;
    }
}
