using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace Actividad1P11
{
    class Program
    {
        static void Main(string[] args)
        {
            int opc,opcMenu, Intentos = 1, Score=0, k=0;
            String Nombre;
            String[] Puntajes = new string[150];
            Console.WriteLine("Bienvenid@ al juego de las adivinanzas");
            do
            {
                Console.WriteLine("¿Qué desea hacer?\n1. Jugar\t2. Ver puntajes\t3. Salir");
                opcMenu = Convert.ToInt32(Console.ReadLine());
                switch (opcMenu)
                {
                    case 1:
                        Intentos = 1;
                        Console.WriteLine("Hay un solo número ganador entre un conjunto del 1 al 30");
                        Console.WriteLine("¡Intente adivinar el correcto!");
                        do
                        {
                            Console.Write("Intento " + Intentos);
                            Console.WriteLine(" ");
                            opc = Convert.ToInt32(Console.ReadLine());
                            if (opc != 19)
                            {
                                Console.WriteLine("¡Respuesta incorrecta!");
                                Intentos++;
                            }
                        } while (opc != 19);
                        Console.WriteLine("¡Acertaste!");
                        Console.WriteLine("Registre su nombre con su puntaje");
                        Nombre = Console.ReadLine();
                        if (Intentos < 6)
                            Score = 100;
                        else if (Intentos > 5 && Intentos < 16)
                            Score = 100 - 35;
                        else if (Intentos > 15 && Intentos < 27)
                            Score = 100 - 50;
                        else if (Intentos > 26)
                            Score = 100 - 100;

                        if (Intentos == 1)
                            Score = Score + 150;
                        else if (Intentos > 1 && Intentos < 6)
                            Score = Score + 10;
                        else if (Intentos > 5 && Intentos < 16)
                            Score = Score + 4;
                        else if (Intentos > 15 && Intentos < 27)
                            Score = Score + 2;
                        else if (Intentos > 26)
                            Score = Score + 1;
                        Console.WriteLine("Usuario:  Nombre: " + Nombre + " | Intentos Requeridos: " + Intentos + " | Puntaje: " + Score);
                        Puntajes[k] = ("Nombre: "+Nombre+ " | Intentos: "+Intentos+" | Puntaje: "+Score);
                        k++;
                        break;
                    case 2:
                       
                        Console.WriteLine("Los puntajes obtenidos son: ");
                        StreamWriter punt = File.CreateText("Puntajes");
                        for (int i = 0; i < k + 1; i++)
                        {
                            punt.WriteLine(Puntajes[i]);
                            Console.WriteLine(Puntajes[i]);
                        }
                        punt.Close();
                        break;
                    case 3:
                        Console.WriteLine("¡Gracias por jugar!");
                        break;
                    default:
                        Console.WriteLine("Opción no válida, por favor ingrese una correcta");
                        break;
                }
            } while (opcMenu != 3);
        }
    }
}
