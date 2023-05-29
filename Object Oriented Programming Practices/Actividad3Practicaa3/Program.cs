using System;

namespace actividadnumerosaleatorios
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] Tiradas = new int[100];
            int i, elBueno, Repeticiones = 0;
            Console.WriteLine("¡¡Observación de repeticiones en el lanzamiento de un dado!!\n\n");
            Console.WriteLine("¡Presiona Enter para lanzar los dados!\n\n");
            Console.Read();
            Random aleatorio = new Random();
            for (i = 0; i < Tiradas.Length; i++)
            {
                Tiradas[i] = aleatorio.Next(1, 6);
                Console.WriteLine("{0}\t", Tiradas[i]) ;
            }
            
            Console.WriteLine("¡¡¡El primer número sacado en los dados fue: {0}!!!", Tiradas[0]);
            elBueno = Tiradas[0];
            for (i = 0; i < Tiradas.Length; i++)
            {
                if (Tiradas[i] == elBueno)
                {
                    Repeticiones++;
                }
            }
            Console.WriteLine("¡¡¡Las veces que se repitió el {0} entre las 100 tiradas del dado fueron {1}!!!", elBueno, Repeticiones);
            Console.Read();

        }
    }
}