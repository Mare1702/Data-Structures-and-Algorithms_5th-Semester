using System;
namespace P8._10_Act4
{
    public class SistemaPagoDoble : SistemaPagoBasico
    {
        public override void SetJornada(int Horas)
        {
            Jornada = Horas;
        }
        public override float Pagando()
        {
            Console.WriteLine("Sobreescritura de metodo Pagando");
            Pago = Jornada * (187.43f + 21)+100;
            return Pago;
        }
    }
}
