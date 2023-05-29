using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading; //necesaria para usar hilos
using System.Diagnostics;
namespace Actividad4_P12
{
    class Program
    {
        static void Main(string[] args)
        {
            Stopwatch THilos = new Stopwatch();
            Stopwatch TSecuencial = new Stopwatch();
            TSecuencial.Start();
            Console.WriteLine("¡Comienza la vendimia de boletos!");
            VentaCaja1();
            VentaCaja2();
            VentaCaja3();
            VentaCaja4();
            TSecuencial.Stop();
            Console.WriteLine("El programa en serie tomó {0} ms en ejecutarse", TSecuencial.Elapsed.TotalMilliseconds);

            Thread hilo1 = new Thread(new ThreadStart(VentaCaja1));
            Thread hilo2 = new Thread(new ThreadStart(VentaCaja2));
            Thread hilo3 = new Thread(new ThreadStart(VentaCaja3));
            Thread hilo4 = new Thread(new ThreadStart(VentaCaja4));
            THilos.Start();
            Console.WriteLine("¡Comienza la vendimia de boletos!");
          
            THilos.Start();
            hilo1.Start();
            hilo2.Start();
            hilo3.Start();
            hilo4.Start();
            THilos.Stop();
            Console.WriteLine("El programa en paralelo tomó {0} ms en ejecutarse", THilos.Elapsed.TotalMilliseconds);
        }
        static public void VentaCaja1()
        {
            int CuentaBoletos1 = 250;
            for(int i=0;i<CuentaBoletos1; i++)
            {
                Console.WriteLine("Boleto {0} vendido",i);
            }
        }
        static public void VentaCaja2()
        {
            int CuentaBoletos2 = 500;
            for (int i = 250; i < CuentaBoletos2; i++)
            {
                Console.WriteLine("Boleto {0} vendido", i);
            }
        }
        static public void VentaCaja3()
        {
            int CuentaBoletos3= 750;
            for (int i = 500; i < CuentaBoletos3; i++)
            {
                Console.WriteLine("Boleto {0} vendido", i);
            }
        }
        static public void VentaCaja4()
        {
            int CuentaBoletos4 = 1000;
            for (int i = 750; i < CuentaBoletos4; i++)
            {
                Console.WriteLine("Boleto {0} vendido", i);
            }
        }
    }
}
