using System;
namespace P8._10_Act4
{
    public class SistemaPagoBasico
    {
        public SistemaPagoBasico() { }
        //Atributos
        public int Jornada;
        public float Pago;
        //Setter
        public virtual void SetJornada(int Horas) { Jornada = Horas; }
        //Getters
        public virtual void GetJornanda() { Console.WriteLine(Jornada); }

        public virtual float Pagando()
        {
            Pago = Jornada * 187.43f;
            return Pago;
        }
    }
}
