package ArbolAVL;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Clase de Arbol AVL
 */
public class AVL
{
    public AVLNode root;



    /**
     *
     * Constructor de ArbolAVL
     *
     *
     *
     */
    public AVL()
    {

        root = null;
    }



    /**
     *
     * Insert - Metodo General para la insercion de Nodos
     *
     * @param i - Valor que se desea insertar
     */
    public void insert(int i)
    {

        AVLNode t = root;
        AVLNode n = new AVLNode(i);

        while(t != null)
        {
            n.parent = t;

            if(t.valor != i)
                t = i < t.valor ? t.izq : t.der;
            else
            {
                System.out.println("El valor ya se encuentra en el arbol");
                return;
            }
        }

        if(n.parent == null)
            root = n;
        else if(i < n.parent.valor)
            n.parent.izq = n;
        else
            n.parent.der = n;

        check(n);

        System.out.println("El valor ha sido insertado");
    }



    /**
     *
     * Delete - Metodo General para Eliminar Nodos
     *
     * @param i - Valor que se desea eliminar.
     */
    public void delete(int i)
    {

        AVLNode t = root;
        AVLNode p = null;

        while(t != null)
        {
            if(t.valor == i)
            {
                p = t;
                break;
            }

            t = i < t.valor ? t.izq : t.der;
        }

        if(t != null)
        {
            if(t.der != null)
                t = t.der;

            while(t.izq != null)
            {
                t = t.izq;
            }

            if(p == t)
            {
                if(t == root)
                {
                    root = null;
                }
                else
                {
                    t = t.parent;

                    if(t.izq == t)
                    {
                        t.izq = null;
                        t.h--;
                    }
                    else
                    {
                        t.der = null;
                        t.h++;
                    }

                }
            }
            else
            {
                p.valor = t.valor;
                t.valor = i;

                if(t.der != null)
                {
                    t.valor = t.der.valor;
                    t.der = null;
                    t.h++;
                    t.parent.h++;
                    t = t.parent;
                    rotation(t);
                }
                else
                {
                    t = t.parent;

                    if(t.izq.valor == i)
                    {

                        t.izq = null;
                        t.h--;
                    }
                    else
                    {
                        t.der = null;
                        t.h++;
                    }
                }
                setBal(t);
                check2(t);
            }
        }
        else
        {
            System.out.println("El valor no esta dentro del arbol");
        }
    }



    /**
     *
     * Check - Metodo para revalorar nodos de abajo hacia arriba
     *
     * @param n - Nodo recien ingresado
     */
    public void check(AVLNode n)
    {

        int value;

        while(n != root)
        {
            value = n.valor;
            n = n.parent;
            n.h += value < n.valor ? 1 : -1;

            if(n.h == 0)
                break;

            if(Math.abs(n.h) > 1) {
                rotation(n);
                break;
            }
        }
    }



    /**
     *
     * Rotation - Metodo para evaluar la rotacion de un nodo
     *
     * @param n - Nodo a rotar
     */
    public void rotation(AVLNode n)
    {

        if(n.h > 0)
        {
            if(n.izq.h < 0)
            {
                leftRotation(n.izq);
            }
            rightRotation(n);
        }
        else
        {
            if(n.der.h > 0)
            {
                rightRotation(n.der);
            }
            leftRotation(n);
        }
    }



    /**
     *
     * Check2 - Metodo para reacomodar nodos despues de la eliminacion.
     *
     * @param n - Toma un nodo para ingresarlo
     */
    public void check2(AVLNode n)
    {

        while(n != root)
        {
            if(Math.abs(n.h) > 1)
            {
                rotation(n);
            }

            if(Math.abs(n.h) == 0)
                break;

            n = n.parent;
        }
    }



    /**
     *
     * setBal - Metodo para ajustar balance de un nodo desde sus hijos
     *
     * @param n - Nodo a que se necesita volver a balancear
     */
    public void setBal(AVLNode n)
    {

        n.h = 0;
        if(n.izq != null)
            n.h += n.izq.h + 1;
        if(n.der != null)
            n.h += n.der.h - 1;
    }



    /**
     *
     * Left Rotation - Metodo para ejecutar una rotacion a la izquierda
     *
     * @param n - Nodo desde el cual se ejecutara la rotacion
     */
    public void leftRotation(AVLNode n)
    {

        AVLNode t = n.der;

        if(n.parent == null)
            root = t;
        else
        if(n.parent.der == n)
            n.parent.der = t;
        else
            n.parent.izq = t;

        t.parent = n.parent;
        n.parent = t;

        if(t.izq != null)
        {
            t.izq.parent = n;
            n.der = t.izq;
        }
        else
        {
            n.der = null;
        }

        t.izq = n;

        checkBalance(n);
    }



    /**
     *
     * Right rotation - Metodo para ejecutar la rotacion hacia la derecha
     *
     * @param n  - Nodo con el que se realizara la rotacion.
     */
    public void rightRotation(AVLNode n)
    {

        AVLNode t = n.izq;

        if(n.parent == null)
            root = t;
        else
        if(n.parent.der == n)
            n.parent.der = t;
        else
            n.parent.izq = t;

        t.parent = n.parent;
        n.parent = t;

        if(t.der != null)
        {
            t.der.parent = n;
            n.izq = t.der;
        }
        else
        {
            n.izq = null;
        }

        t.der = n;

        checkBalance(n);
    }



    /**
     *
     * Check balance - Ajusta el Balance de un nodo despues de la rotacion
     *
     * @param n - Nodo al que se le ajustara el balance despues de una rotacion
     */
    public void checkBalance(AVLNode n)
    {

        n.h = 0;

        int value = n.valor;
        n = n.parent;
        n.h += value < n.valor ? 1 : -1;
    }



    /**
     *
     * getNode - Obtiene un Nodo buscado
     *
     * @param i - Valor a buscar dentro del nodo
     * @return Valor booleano dependiendo del resultado
     */
    public boolean getNode(int i)
    {

        AVLNode t = root;

        while(t != null)
        {
            if(t.valor != i)
                t = i < t.valor ? t.izq : t.der;
            else
                return true;
        }
        return false;
    }



    /**
     *
     * Search - Metodo general para la busqueda de nodos
     *
     * @param i  - Valor que se desea buscar
     */
    public void search(int i)
    {

        if(getNode(i))
            System.out.println("El valor " + i + " se encuentra en el arbol");
        else
            System.out.println("El valor " + i + " no se encuentra en el arbol");
    }


    /**
     *
     * Breadth frist - Metodo general para imprimir el arbol de nodos
     *
     * @param raiz - Raiz del Arbol que se prentende imprimir
     */
    public void breadthFrist(AVLNode raiz){

        List<AVLNode> padres=new LinkedList<>();
        AVLNode r = raiz;
        Queue<AVLNode> queue = new LinkedList<>();
        int contador=0;

        if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (AVLNode) queue.poll();
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
    }

    protected void visit(AVLNode n)
    {
        System.out.println(n.valor);
    }
}
