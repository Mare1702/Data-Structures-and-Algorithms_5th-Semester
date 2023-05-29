using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading; //necesaria para usar hilos
using System.Diagnostics;

namespace Hilos
{
    class Program
    {
        static void Main(string[] args)
        {
            Stopwatch tiempoSecuencial = new Stopwatch();
            Stopwatch tiempoHilos = new Stopwatch();

            tiempoSecuencial.Start();
            Console.WriteLine("Programa Secuencial/Serial");
            CalcularDivision();
            CalcularMulti();
            tiempoSecuencial.Stop();
            Console.WriteLine("El programa secuencial tomó {0} ms en ejecutarse", 
                tiempoSecuencial.Elapsed.TotalMilliseconds);

            Thread hilo1 = new Thread(new ThreadStart(CalcularDivisionHilos));
            Thread hilo2 = new Thread(new ThreadStart(CalcularMultiHilos));

            tiempoHilos.Start();
            Console.WriteLine("Programa con Hilos");
            hilo1.Start();
            hilo2.Start();
            /*
             * Hilo Principal (Main)
             *      ->Hilo1 Trabaja
             *      ->Hilo2 Trabaja
             * 
             */ 

            tiempoHilos.Stop();
            Console.WriteLine("El programa con hilos tomó {0} ms en ejecutarse",
                tiempoHilos.Elapsed.TotalMilliseconds);

            Thread hilo3 = new Thread(new ThreadStart(Tabla1));
            Thread hilo4 = new Thread(new ThreadStart(Tabla2));
            hilo3.Start();
            hilo4.Start();

            Console.ReadLine();
        }

        static public void CalcularDivision()
        {
            double numero = 10000;
            double resultado = 1;
            for(int i= 1; i<numero; i++)
            {
                resultado = resultado * (numero / i);
            }
            Console.WriteLine("El resultado es: "+resultado);
        }

        static public void CalcularMulti()
        {
            int num1 = 179;
            double num2 = 0;
            for(int i= -20; i<=150; i++)
            {
                if (i == 0)
                {

                }
                else
                {
                    num2 =num2 + (num1 + i) * (num1 / (i * 2));
                }
            }
            Console.WriteLine("El resultado de la multiplicación es: " + num2);
        }

        static public void CalcularDivisionHilos()
        {
            Stopwatch st = new Stopwatch();
            st.Start();
            double numero = 10000;
            double resultado = 1;
            for (int i = 1; i < numero; i++)
            {
                resultado = resultado * (numero / i);
            }
            st.Stop();
            Console.WriteLine("El resultado es: " + resultado +
                "\nHilo 1 tardó {0} ms en ejecutarse",
                st.Elapsed.TotalMilliseconds);
        }

        static public void CalcularMultiHilos()
        {
            Stopwatch st = new Stopwatch();
            st.Start();
            int num1 = 179;
            double num2 = 0;
            for (int i = -20; i <= 150; i++)
            {
                if (i == 0)
                {

                }
                else
                {
                    num2 = num2 + (num1 + i) * (num1 / (i * 2));
                }
            }
            st.Stop();
            Console.WriteLine("El resultado de la multiplciación es: " + num2 +
                "\nHilo 2 tardó {0} ms en ejecutarse",
                st.Elapsed.TotalMilliseconds);
            Console.WriteLine("El resultado de la multiplicación es: " + num2);
        }

        static void Tabla1()
        {
            int cont = 1;
            for(int i=0; i<=10; i++)
            {
                Console.WriteLine("Hilo 3: {0}x{1}={2}",cont,i,cont*i);
                cont++;
            }
        }
        static void Tabla2()
        {
            int cont = 10;
            for (int i = 0; i <= 10; i++)
            {
                Console.WriteLine("Hilo 4: {0}x{1}={2}", cont, i, cont * i);
                cont++;
            }
        }

    }
}
