package ExpresionAritmetica.Utilerias;


/**
 * Clase Nodo sin Parent
 */
public class Nodo
{
    public String valor;
    public Nodo izq;
    public Nodo der;

    /**
     *
     * Constructor de Clase Nodo
     *
     */
    public Nodo()
    {

        this.izq = null;
        this.der = null;
    }

    /**
     *
     * Constructor de Nodo con parametro de String
     *
     * @param data - Cadena de Caracteres Para Ingresar al Nodo
     */
    public Nodo(String data)
    {
        this(data,null,null);
    }



    /**
     *
     * Nodo con parametros diversos
     *
     * @param data  - Cadena de Caracters a ingresar
     * @param lt  - Nodo Izquierdo
     * @param rt  - Nodo Derecho
     */
    public Nodo(String data, Nodo lt, Nodo rt)
    {

        this.valor = data;
        this.izq = lt;
        this.der = rt;
    }
}
