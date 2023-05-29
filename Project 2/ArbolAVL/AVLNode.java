package ArbolAVL;


/**
 *  Clase AVL node
 */
public class AVLNode
{
    AVLNode parent; /* Nodo padre */
    int valor; /* valor contenido en el nodo*/
    AVLNode izq; /*Nodo hijo izquierdo */
    AVLNode der; /*Nodo hijo derecho */
    int h; /* Altura del nodo*/


    /**
     *
     * Constructor del nodoAVL sin parametro
     *
     */
    public AVLNode() {

        this.parent = null;
        this.izq = null;
        this.der = null;
        this.h = 0;
    }



    /**
     *
     * Constructor del NodoAVL con parametro a incluir dentro del nodo
     *
     * @param i - Valor a incluir dentro del nodo
     */
    public AVLNode(int i)
    {

        this.parent = null;
        this.valor = i;
        this.izq = null;
        this.der = null;
        this.h = 0;
    }

}
