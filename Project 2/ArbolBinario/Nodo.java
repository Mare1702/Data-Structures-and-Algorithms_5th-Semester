package ArbolBinario;

/**
 * Clase Nodo
 */
public class Nodo
{
    public int valor;
    public Nodo izq;
    public Nodo der;



    /**
     *
     * Constructor de Nodo sin parametro.
     *
     */
    public Nodo()
    {

        this.izq = null;
        this.der = null;
    }



    /**
     *
     * Constructor de Nodo con Parametro a ingresar
     *
     * @param data - Valor a Ingresar
     */
    public Nodo(int data)
    {

        this(data,null,null);
    }



    /**
     *
     * Constructor de Nodo con Parametros Diversos
     *
     * @param data  - Valor a Ingresar
     * @param lt  - Nodo izquierdo
     * @param rt  - Nodo Derecho
     */
    public Nodo(int data, Nodo lt, Nodo rt)
    {

        this.valor = data;
        this.izq = lt;
        this.der = rt;
    }



    /**
     *
     * setIzq - Setter de nodo izquierdo
     *
     * @param izq  the izq
     */
    public void setIzq(Nodo izq)
    {

        this.izq = izq;
    }



    /**
     *
     * setDer - Setter de nodo derecho
     *
     * @param der  the der
     */
    public void setDer(Nodo der)
    {

        this.der = der;
    }
}
