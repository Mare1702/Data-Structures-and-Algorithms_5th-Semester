using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProyectoFinalPOO//Calendario
{
    public class Empresa : Usuario
    {
        
        public Empresa(string NombreCompleto, string Contraseña, string User, Administrador Representante)
        {
            this.NombreCompleto = NombreCompleto;
            this.Contraseña = Contraseña;
            this.User = User;
            this.Representante = Representante;
        }
        public Empresa(string NombreCompleto, string Contraseña, string User)
        {
            this.NombreCompleto = NombreCompleto;
            this.Contraseña = Contraseña;
            this.User = User;
        }
        //Atributos
        public Administrador Representante;
        //Getters
        public void GetCompleteInfo()
        {
            Console.WriteLine("Nombre de la empresa: "+NombreCompleto);
            Console.WriteLine("Contraseña: " + Contraseña);
            Console.WriteLine("Usuario: " + User);
            if (Representante != null)
            {
                Console.WriteLine("Datos del representante: ");
                Console.WriteLine("\t" + Representante.NombreCompleto);
                Console.WriteLine("\t" + Representante.CorreoElectronico);
                Console.WriteLine("\t" + Representante.Celular);
            }
            else
            {
                Console.WriteLine("Datos del representante: ");
                Console.WriteLine("\t-Sin asignar-");
            }
        }
        public void GetNombreCompletoRepresentante() { Console.WriteLine(Representante.NombreCompleto); }
        public void GetCorreoElectronicoRepresentante() { Console.WriteLine(Representante.NombreCompleto); }
        public void GetCelularRepresentante() { Console.WriteLine(Representante.NombreCompleto); }
        //Setter
        public void SetRepresentante(Administrador REPRESENTANTE) { Representante = REPRESENTANTE; Asignado = true; }//Justo como con los administradores, al asignar un representante para la empresa, esta pasará a ser 'asignada' y dejará de ser elegible para asignar como dependencia de algun adminstrador dado de alta (case 8)
    }
}