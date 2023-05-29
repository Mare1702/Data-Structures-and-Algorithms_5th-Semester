using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Ejemplo1
{
    class Program
    {
        static void Main(string[] args)
        {
            int opc;
            char repetir;    //Como utilizo do-while no es necesario darle un valor
            //ya que la validación la hace hasta que termina de ejecuatr el bloque dentro
            //del ciclo Do-While
            int factorial, resultado = 1, contador, a = 10; //Variables para involucradas en el cálculo del factorial
            do
            {
                Console.WriteLine("Programa Lab 2");
                Console.WriteLine("Selecciona una opción:");
                Console.Write("1.- Factorial de un número usando While\n" +
                    "2.- Factorial de un número usando Do-While\n" +
                    "3.- Factorial de un número usando For\n" +
                    "Opción: ");
                opc = Convert.ToInt32(Console.ReadLine());
                //limpio mis variables *NOTA: cuando epetimos nuesto programa es recomendable
                //limpiar nuestras variables para evitar errores en los cálculos
                resultado = 1;
                contador = 0;
                a = 10;
                factorial = 0;
                switch (opc)
                {
                    case 1:
                        Console.WriteLine("Factorial de un número con WHILE: ");
                        Console.Write("Ingresa el número: ");
                        factorial = Convert.ToInt32(Console.ReadLine());
                        //Proceso que calcula el factorial del número ingresado
                        a = factorial;
                        while (a != 0)
                        {
                            resultado = resultado * a;
                            a--; //realizo un decremento en una unidad
                                 //(equivalente a => a=a-1;
                        }
                        Console.WriteLine("Resultado: {0}! = {1}", factorial, resultado);
                        Console.WriteLine("¿Deseas repetir el programa? Presiona S, en caso contrario presiona N");
                        repetir = Convert.ToChar(Console.ReadLine());
                        break;
                    case 2:
                        a = 1;
                        Console.WriteLine("Factorial de un número con DO-WHILE: ");
                        Console.Write("Ingresa el número: ");
                        factorial = Convert.ToInt32(Console.ReadLine());
                        //Proceso que calcula el factorial del número ingresado
                        contador = factorial;
                        Console.WriteLine("Resultado: {0}, a:{1}", resultado, a);
                        do
                        {
                            resultado = resultado * a;
                            a++; //realizo un incremento en una unidad
                                 //(equivalente a => a=a+1;
                            Console.WriteLine("Resultado: {0}, a:{1}", resultado, a);
                        } while (a <= contador);

                        Console.WriteLine("Resultado: {0}! = {1}", factorial, resultado);
                        Console.WriteLine("¿Deseas repetir el programa? Presiona S, en caso contrario presiona N");
                        repetir = Convert.ToChar(Console.ReadLine());
                        break;
                    case 3:
                        Console.WriteLine("Factorial de un número con FOR: ");
                        Console.Write("Ingresa el número: ");
                        factorial = Convert.ToInt32(Console.ReadLine());
                        //Proceso que calcula el factorial del número ingresado
                        a = factorial;
                        for (int i = 1; i <= factorial; i++)
                        {
                            resultado = resultado * i;
                        }
                        Console.WriteLine("Resultado: {0}! = {1}", factorial, resultado);
                        Console.WriteLine("¿Deseas repetir el programa? Presiona S, en caso contrario presiona N");
                        repetir = Convert.ToChar(Console.ReadLine());
                        break;
                    default:
                        Console.WriteLine("Opción no válida");
                        Console.WriteLine("¿Deseas repetir el programa? Presiona S, en caso contrario presiona N");
                        repetir = Convert.ToChar(Console.ReadLine());
                        break;
                }
            } while (repetir == 'S' || repetir == 's');
        }
    }
}
