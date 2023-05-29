using System;

namespace P4Actividad4
{
    class Program
    {
        static void Main(string[] args)
        {
            int opc = 0, Mesa = 0, Cantidad = 0, i = 0;
            int Cont = 0;                                               //Irá incrementadno conforme se vayan revisando las ordenes
            string BebidaIngresadaEnMain, PlatMain;
            int CantidadMain,MesaMain;
            Orden Ordenes = new Orden();                                //Se crea un solo objeto (Mesa, Cantidad, Bebida, Platillo)
            Orden[] ordenesCocina = new Orden[20];                      //Generación de arreglo de objetos, en cada posicion se genera un espacio para instanciar otro objeto

            Console.WriteLine("Inicializando el sistema");

            ordenesCocina[Cont] = new Orden();            
            ordenesCocina[Cont].SetIdOrden(Cont);
            BebidaIngresadaEnMain = "Té de Hierbabuena tibiecito";
            ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);
            MesaMain = 32;
            ordenesCocina[Cont].GuardarMesa(MesaMain);
            PlatMain = "Carnitas asadas sin huesito";
            ordenesCocina[Cont].GuardaPlatillo(PlatMain);
            CantidadMain = 297;
            ordenesCocina[Cont].GuardaCantidad(CantidadMain);
            Cont++;
            ordenesCocina[Cont] = new Orden();
            ordenesCocina[Cont].SetIdOrden(Cont);
            BebidaIngresadaEnMain = "Agua de Horchata con un toque de canela";
            ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);
            MesaMain = 33;
            ordenesCocina[Cont].GuardarMesa(MesaMain);
            PlatMain = "Cebollitas Cambray con estofado";
            ordenesCocina[Cont].GuardaPlatillo(PlatMain);
            CantidadMain = 380;
            ordenesCocina[Cont].GuardaCantidad(CantidadMain);
            Cont++;
            ordenesCocina[Cont] = new Orden();
            ordenesCocina[Cont].SetIdOrden(Cont);
            BebidaIngresadaEnMain = "Jamaica";
            ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);
            MesaMain = 34;
            ordenesCocina[Cont].GuardarMesa(MesaMain);
            PlatMain = "Pescado Empapelado";
            ordenesCocina[Cont].GuardaPlatillo(PlatMain);
            CantidadMain = 180;
            ordenesCocina[Cont].GuardaCantidad(CantidadMain);
            Cont++;

            ordenesCocina[Cont] = new Orden();
            ordenesCocina[Cont].SetIdOrden(Cont);
            BebidaIngresadaEnMain = "Té de Hierbabuena tibiecito";
            ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);
            MesaMain = 35;
            ordenesCocina[Cont].GuardarMesa(MesaMain);
            PlatMain = "Carnitas asadas sin huesito";
            ordenesCocina[Cont].GuardaPlatillo(PlatMain);
            CantidadMain = 297;
            ordenesCocina[Cont].GuardaCantidad(CantidadMain);
            ordenesCocina[Cont].EntregarOrden();
            Cont++;
            ordenesCocina[Cont] = new Orden();
            ordenesCocina[Cont].SetIdOrden(Cont);
            BebidaIngresadaEnMain = "Jarritos de limón con cereza";
            ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);
            MesaMain = 36;
            ordenesCocina[Cont].GuardarMesa(MesaMain);
            PlatMain = "Ensalada de atún con mayonesa";
            ordenesCocina[Cont].GuardaPlatillo(PlatMain);
            CantidadMain = 70;
            ordenesCocina[Cont].GuardaCantidad(CantidadMain);
            ordenesCocina[Cont].EntregarOrden();
            Cont++;
            ordenesCocina[Cont] = new Orden();
            ordenesCocina[Cont].SetIdOrden(Cont);
            BebidaIngresadaEnMain = "Agüita de Limón";
            ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);
            MesaMain = 37;
            ordenesCocina[Cont].GuardarMesa(MesaMain);
            PlatMain = "Albóndigas con ensalada";
            ordenesCocina[Cont].GuardaPlatillo(PlatMain);
            CantidadMain = 140;
            ordenesCocina[Cont].GuardaCantidad(CantidadMain);
            ordenesCocina[Cont].EntregarOrden();
            Cont++;
            ordenesCocina[Cont] = new Orden();
            ordenesCocina[Cont].SetIdOrden(Cont);
            BebidaIngresadaEnMain = "Agua de mango";
            ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);
            MesaMain = 38;
            ordenesCocina[Cont].GuardarMesa(MesaMain);
            PlatMain = "Coctel de camarón";
            ordenesCocina[Cont].GuardaPlatillo(PlatMain);
            CantidadMain = 302;
            ordenesCocina[Cont].GuardaCantidad(CantidadMain);
            ordenesCocina[Cont].EntregarOrden();
            Cont++;

            Console.WriteLine("Bienvenid@ al sitema de gestión " +
                "del restaurante 'El equipazo 6' :]");
            Console.WriteLine("\t\t<3 Menú de opciones <3");
            Console.WriteLine("1. Ingresar nueva orden\t\t4." +
                " Revisar " +
                "Órdenes pendientes\t\t3. Entregar una orden\t\t2. Resumen de órdenes del día\t\t5.Salir");
            do
            {
                Console.WriteLine("¿Qué desea hacer?");
                opc = Convert.ToInt32(Console.ReadLine());
                switch (opc)
                {
                    case 1: //Anotar nueva orden

                        Console.WriteLine("Por favor, ingrese " +
                            "la nueva orden");
                        ordenesCocina[Cont] = new Orden();              //Dentro de nuestro arreglo de objetos, nuestro arreglo de órdenes s
                        ordenesCocina[Cont].SetIdOrden(Cont);           //Se llama el metodo para guardar la nueva orden y se le manda nuestro contador 'Cont' para que el sistema sepa qué orden se esta guardando

                        Console.Write("Por favor ingrese su bebida: ");
                        BebidaIngresadaEnMain = Console.ReadLine();    
                        ordenesCocina[Cont].GuardaBebida(BebidaIngresadaEnMain);

                        Console.Write("Ingres la mesa a la que pertenece la orden: "); MesaMain=Convert.ToInt32(Console.ReadLine());
                        ordenesCocina[Cont].GuardarMesa(MesaMain);

                        Console.Write("Ingrese el platillo: ");PlatMain = Console.ReadLine();
                        ordenesCocina[Cont].GuardaPlatillo(PlatMain);

                        Console.Write("Ingrese el costo total de la orden: ");CantidadMain = Convert.ToInt32(Console.ReadLine());
                        ordenesCocina[Cont].GuardaCantidad(CantidadMain);

                        Cont++;
                        Console.WriteLine("¡Orden anotada!");
                    break;

                    case 2: //Revisar ordenes hasta el momento

                        if (Cont == 0)
                        {
                            Console.WriteLine("No " +                   //Si nuestro contador está en 0, significa que no hay ordenes para mostrar
                                "hay ordenes en el " +
                                "sistema :o");
                        }
                        else
                        {
                            Console.WriteLine("Las ordenes hasta ahora son:");
                            for (i = 0; i < Cont; i++)
                            {
                                Console.WriteLine("-----------------------");
                                Console.Write("Id: ");
                                ordenesCocina[i].LeeIdOrden();
                                Console.Write("\nMesa: ");
                                ordenesCocina[i].LeeMesa();
                                Console.Write("\nPlatillo: ");
                                ordenesCocina[i].LeePlatillo();
                                Console.Write("\nCantidad: ");
                                ordenesCocina[i].LeeCantidad();
                                Console.Write("\nBebida: ");
                                ordenesCocina[i].LeeBebida();
                                Console.Write("\nStatus: ");
                                String q=ordenesCocina[i].RegresaEstadoOrden();
                                Console.Write(q);
                                Console.WriteLine("\n-----------------------");
                            }

                        
                        }
                    break;

                    case 3:
                        Console.WriteLine("¿Qué orden se entregará?, por favor ingrese el id");
                        int id = Convert.ToInt32(Console.ReadLine());
                        if (id > Cont)
                        {
                            Console.WriteLine("ID no encontrado");
                        }
                        else if (id < 0)
                        {
                            Console.WriteLine("Dato no válido");
                        }
                        else
                        {
                            //Validar si la orden asociada al id no ha sido entregada
                            int existeID;
                            string estado;
                            for (int y = 0; y < Cont; y++)
                            {
                                existeID = ordenesCocina[y].BuscarID(id);      
                                if (existeID == 1)
                                {
                                    estado = ordenesCocina[y].RegresaEstadoOrden(); //Empleamos nuestro método para regresar el estado de nuestras ordenes para comprobar si la que se pide ya fue entregada o no 
                                    if (estado == "Entregado")
                                    {
                                        Console.WriteLine("La orden " + id +
                                            " ya fué entregada");
                                    }
                                    else
                                    {
                                        ordenesCocina[y].EntregarOrden();
                                    }
                                }
                                else
                                {
                                    Console.WriteLine("¡No existe la orden!");
                                }
                            }
                        }
                        break;
                    case 4:
                        Console.WriteLine("Las órdenes que faltan por entregar son: ");
                        Boolean Bandera=false;
                        if (Cont == 0)
                        {
                            Console.WriteLine("No " +                   //Si nuestro contador está en 0, significa que no hay ordenes para mostrar
                                "hay ordenes en el " +
                                "sistema :o");
                        }
                        else
                        {
                            Console.WriteLine("Las ordenes hasta ahora son:");
                            for (i = 0; i < Cont; i++)
                            {
                                if (ordenesCocina[i].LeeEstadoOrden()=="Preparado")
                                {
                                    Bandera = true;
                                    Console.WriteLine("-----------------------");
                                    Console.Write("Id: ");
                                    ordenesCocina[i].LeeIdOrden();
                                    Console.Write("\nMesa: ");
                                    ordenesCocina[i].LeeMesa();
                                    Console.Write("\nPlatillo: ");
                                    ordenesCocina[i].LeePlatillo();
                                    Console.Write("\nCantidad: ");
                                    ordenesCocina[i].LeeCantidad();
                                    Console.Write("\nBebida: ");
                                    ordenesCocina[i].LeeBebida();
                                    Console.Write("\nStatus: ");
                                    String q = ordenesCocina[i].RegresaEstadoOrden();
                                    Console.Write(q);
                                    Console.WriteLine("\n-----------------------");
                                }
                            }
                            if (Bandera == false)
                            {
                                Console.WriteLine("Todas las órdenes han sido entregadas :]");
                            }

                        }
                        break;
                    case 5:
                        Console.WriteLine("¡Ciao!");
                    break;

                }
            } while (opc != 5);

            Console.WriteLine();
        }
    }
}
