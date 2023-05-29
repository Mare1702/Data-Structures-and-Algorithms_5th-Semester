
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProyectoFinalPOO//Calendario
{
    public class Usuario
    {
        public Usuario() { }
        //Atributos
        public String NombreCompleto, Contraseña, User;
        public Boolean Asignado = false;
        //Getters
        public void GetNombreCompleto() { Console.WriteLine(NombreCompleto); }
        public void GetContraseña() { Console.WriteLine(Contraseña); }
        public void GetUser() { Console.WriteLine(User); }
        //Setters
        public void SetNombreCompleto(String NP) { NombreCompleto = NP; }
        public void SetConstraseña(String Contra) { Contraseña = Contra; }
        public void SetUser(String usuario) { User = usuario; }


    }
}
