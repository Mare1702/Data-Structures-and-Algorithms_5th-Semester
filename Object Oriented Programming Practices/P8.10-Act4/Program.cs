using System;

namespace P8._10_Act4
{
    class Program
    {
        static void Main(string[] args)
        {
            int Horas;
            SistemaPagoBasico PagoBasico = new SistemaPagoBasico();
            SistemaPagoExtra PagoExtra = new SistemaPagoExtra();
            SistemaPagoDoble PagoDoble = new SistemaPagoDoble();
            SistemaPagoTriple PagoTriple = new SistemaPagoTriple();

            Console.Write("¡Bienvenid@ al sistema de cobro!" +
                "\n Por favor ingrese las horas que ha trabajo: ");
            try
            {
                Horas = Convert.ToInt32(Console.ReadLine());
                if (Horas < 0)
                    throw new Exception();
                PagoBasico.SetJornada(Horas);
                Console.Write("El monto a pagar será de: ");
                if (Horas <= 40)
                {
                    PagoBasico.SetJornada(Horas);
                    Console.WriteLine(PagoBasico.Pagando());
                }
                else if (Horas > 40 && Horas < 80)
                {
                    Console.WriteLine("INGRESO IF ELSE");
                    PagoExtra.SetJornada(Horas);
                    Console.WriteLine(PagoExtra.Pagando());
                }
                else if (Horas >= 80 && Horas < 120)
                {
                    PagoDoble.SetJornada(Horas);
                    Console.WriteLine(PagoDoble.Pagando());
                }
                else if (Horas >= 120)
                {
                    try
                    {
                        PagoTriple.SetJornada(Horas);
                        Console.WriteLine(PagoTriple.Pagando());
                    }
                    catch (OverflowException)
                    {
                        Console.WriteLine("Se ha excedido el maximo valor para " +
                            "guardar en la variable flotante 'Pago'");
                    }
                }
                Console.ReadLine();

            }
            catch(FormatException e)
            {
                Console.WriteLine("No se introdujo el formato correcto" +
                    " para el número de horas trabajadas, por favor ingrese" +
                    "un número entero");
            }
            catch (Exception)
            {
                Console.WriteLine("No se introdujo el formato correcto" +
                    " para el número de horas trabajadas, por favor ingrese" +
                    "un número positivo");
            }

            Console.ReadLine();
        }
    }
}