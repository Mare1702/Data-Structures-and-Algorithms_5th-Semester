using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProyectoFinalPOO//Calendario
{
    public class Administrador : Usuario
    {
        public Administrador(string NombreCompleto, string Contraseña, string User, long NumeroTrabajador, Empresa Dependencia, String CorreoElectronico, long Celular)
        {
            this.NombreCompleto = NombreCompleto;
            this.Contraseña = Contraseña;
            this.User = User;
            this.NumeroTrabajador = NumeroTrabajador;
            this.Dependencia = Dependencia;
            this.CorreoElectronico = CorreoElectronico;
            this.Celular = Celular;
        }
        public Administrador(string NombreCompleto, string Contraseña, string User, long NumeroTrabajador, String CorreoElectronico, long Celular)
        {
            this.NombreCompleto = NombreCompleto;
            this.Contraseña = Contraseña;
            this.User = User;
            this.NumeroTrabajador = NumeroTrabajador;
            this.CorreoElectronico = CorreoElectronico;
            this.Celular = Celular;
        }
        //Atributos
        public long NumeroTrabajador, Celular;
        public string CorreoElectronico;
        public Empresa Dependencia;
        //Getters
        public void GetCompleteInfo()
        {
            Console.WriteLine("Nombre Completo del Administrador: " +NombreCompleto);
            Console.WriteLine("Contraseña:" +Contraseña);
            Console.WriteLine("Usuario: " + User);
            Console.WriteLine("Número de Trabajador: "+NumeroTrabajador);
            Console.WriteLine("Número de Celular: "+Celular);
            Console.WriteLine("CorreoElectrónico: "+CorreoElectronico);
            if (Dependencia != null)
                Console.WriteLine("Dependencia: " + Dependencia.NombreCompleto);
            else
                Console.WriteLine("Dependencia: -Sin asignar-");
        }
        public void GetNumeroTrabajador() { Console.WriteLine(NumeroTrabajador); }
        public void GetCelular() { Console.WriteLine(Celular); }
        public void GetCorreoElectronico() { Console.WriteLine(CorreoElectronico); }
        public void GetDependencia() { Console.WriteLine(Dependencia.NombreCompleto); }
        //Setters
        public void SetNumeroTrabajador(int NT) { NumeroTrabajador = NT; }
        public void SetCelular(int TEL) { Celular = TEL; }
        public void SetCorreoElectronico(string EMAIL) { CorreoElectronico = EMAIL; }
        public void SetDependencia(Empresa DEPENDENCIA) { Dependencia = DEPENDENCIA; Asignado = true; } //Al momento de asignar una dependencia al administrador, este pasará a ser 'asignado' por que dejará de ser elegible para asignar a alguna empresa sin representante (case 4)
    }
}