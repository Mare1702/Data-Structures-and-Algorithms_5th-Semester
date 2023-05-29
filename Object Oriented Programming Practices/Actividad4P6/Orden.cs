/*
 Plantilla donde se guardarán todos los datos y caracteristicas que forman el concepto
de una orden*/
using System;
namespace P4Actividad4
{
    public class Orden
    {
        //Atributos
        int idOrden;                           //Auxiliar para verificar que todos los objetos sean únicos
        int Mesa = 0, Cantidad = 0;            //Asignaciones hechas desde la reserva de memoria para la clase
        string Bebida, Platillo;               //Atributos de la orden que serán tomados cada que se cree una
        string estadoOrden = "Preparando";     //Referencia de si la orden ya fue entregada o no
                                               //De igual forma, se podrian declarar como atributos otras clases

        //Método Constructor 
        public Orden()
        {
            estadoOrden = "Preparado";          //Asignacióm generada una vez se instancia el objeto, no cuando la clase es creada
        }

        //Métodos Set (Guardado de información)
        public void SetIdOrden(int Cont)
        {
            idOrden = Cont;                    //Los identificadores de cada orden serán establecidos automaticamente por el programa
                                               //idOrden = Convert.ToInt32(Console.ReadLine()); <--Hubiera sido un riesgo de errores humanos de conteo
        }
        public void GuardaPlatillo(String PlatMain)
        {
            Platillo = PlatMain;
        }
        public void GuardaCantidad(int CantidadMain)
        {
            Cantidad = CantidadMain;
        }
        public int GuardaBebida(string BebidaIngresadaEnMain) //Esta función recibe parametros desde la clase en donde fue llamada
        {
            try
            {
                Bebida = BebidaIngresadaEnMain;
                return 1;                       //1 me indica que todo salió bien
            }
            catch
            {
                Console.WriteLine("Error" +
                    " #1: No se puede" +
                    " guardar el valor" +
                    " ingresado de bebida");
                return 0;                       //un 0, generalmente indica que hay problemas
            }
        }
        public void GuardarMesa(int MesaMain)
        {
            Mesa = MesaMain;
        }
        public void ActualizarEstado(string nuevoEstado)
        {
            estadoOrden = nuevoEstado;
        }
        //Métodos Get (Recuperan informacion de una variable dentro de esta clase
        public void LeeIdOrden(){Console.WriteLine(idOrden);}
        public void LeeMesa() { Console.Write(Mesa); }
        public void LeePlatillo() { Console.Write(Platillo); }
        public void LeeCantidad() { Console.Write(Cantidad); }
        public void LeeBebida() { Console.Write(Bebida); }
        public String LeeEstadoOrden() {
            //Console.Write(estadoOrden);
            return estadoOrden;
        }

        public void EnProceso()
        {
            Console.WriteLine("Orden Aceptada por la cocina, iniciando la preparación");
        }
        public void EntregarOrden()
        {
            Console.WriteLine("Su orden acaba de arribar a la mesa: ");
            LeePlatillo();
            Console.WriteLine();
            LeeBebida();
            Console.WriteLine();
            Console.WriteLine("Provecho ;)");
            ActualizarEstado("Entregado"); //estadoOrden = "Entregado";
        }
        //Se agrega un método para buscar el ID
        public int BuscarID(int identificadorOrden)
        {
            if (identificadorOrden == idOrden)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        public string RegresaEstadoOrden() { return estadoOrden; }

    }
}
