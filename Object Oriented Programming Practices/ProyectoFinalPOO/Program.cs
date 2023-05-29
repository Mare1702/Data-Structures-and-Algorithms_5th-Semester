/*
                Console.WriteLine("\t     1. Adiministradores\t2. Empresas\t3. Salir");
                Console.Write("Su opción--> ");
                =Convert.ToInt32(Console.ReadLine());
                do
                {
                    switch()
                    {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            Console.WriteLine("Opción no válida, por favor intente de nuevo...");
                            break;
                    }
                }while(!=);
*/

/*LISTA DE USUARIOS-CONTRASEÑAS PRECARGADAS - EMPRESAS
 *         NOMBRE            USUARIO             CONTRASEÑA                      REPRESENTANTE               
 *           HP             HPInc.Wow         CosSnSkJd435c-2       Jesús Jair Camacho Alfaro(SUPERADMIN)
 *      Office Depot     MuchosMueblesAqui   iCsfnr5467NHF.sfg-Asd             Baeza Alvarez Isaura   
 *      Hiper Lumen    PapeleriaPeroGrande        cndk34.ds               Castañeda Aranda Alma Adriana
 */

/*LISTA DE USUARIOS-CONTRASEÑAS PRECARGADAS - ADMINISTRADORES
 *                  NOMBRE                       USUARIO         CONTRASEÑA             NUMERO DE TRABAJADOR        CORREO ELECTRONICO         CELULAR            DEPENDENCIA
 * Jesús Jair Camacho Alfaro(SUPERADMIN)         CECAdmon     C3C&2116unam_4d00ñ               3243532          FridayLover4Ever@gmail.com    5526585229              HP
 *          Baeza Alvarez Isaura                 IsaWow      Melon_Asegurado_2001              53476876       IsauraGrandeIsaura@gmail.com   5523759964         Office Depot
 *      Castañeda Aranda Alma Adriana             Ow.Dri        TodoMeHabla263                 3456782           Adri_Adr_Ad_A@gmail.com     5532123685         Hiper lumen
 */


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProyectoFinalPOO //Calendario
{
    class Program //ejecucion 
    {
        public static void Main(String[] args)
        {
            //MENU GENERAL I y II
            string UsuarioMenu1, ContraseñaMenu1;
            int opcMenu, opc = 0, opc2=0, opcMenuSuperUsuario, opcMenuUsuario;
            int ContadorAdministradores = 0, ContadorEmpresas = 0; //Contadores a ocupar cada que se agregue o elimine un administrador o empresa del sistema
            Boolean DatosErroneosMenuII = false;//Accionará un mensaje de error al iniciar sesion como administrador con usuario y/o contraseñas inconrrectas 
            List<Empresa> ListaEmpresas = new List<Empresa>();
            List<Administrador> ListaAdministradores = new List<Administrador>();//Listas de objetos destinadas a guardar llevar cuenta de las instancias a las clases 'Empresa' y 'Administrador'
            
            //MENU GENERAL III
            int opcMenuIII = 0;
            string BienvenidaUsuario = "";
            string InicioSesionEmpresa, InicioSesionEmpresaContra;
            Boolean InicioSesionExitoso = false;

            //MENU GENERAL IV
            int opcMenuEmpresa;
            Empresa EmpresaUsuaria;

            //MENU II - CASE 4
            int opcAsignarRepresentante; //Ocupado para toma de decision: ¿Hay algun administrador en el sistema para asignar como represntante de la nueva empresa?            
            string NNombreE, NContraselaE, NConfirmacionE, NUserE;//Atributos de la nueva empresa que generará el usuario, estas serán pasadas al constructor de la clase 'Empresa'
            Administrador NRepresentanteE=null;//Atributo de tipo 'Administrador' para la nueva empresa generada, esta variable podrá ser pasada al constructor de 'Empresa'
            int ExisteAdministradorSinAsignar=0;//Empleado para mostrar opciones de asignacion de representante a la nueva empresa agregada en case 4 de menu II
            string UsuarioAsignacionNuevoRepresentante; //User ingresado por el usuario para asignar un Representante a una nueva empresa
            Boolean ConfirmacionContraseña = false;//Ocupada para validar si la confirmación de la contraseña es igual a la contraseña ingresada previamente
            int IndexAdministradorAsignar=0;

            //MENU II - CASE 5
            string UsuarioEmpresaEditar;//Usuario por el que s eidentificará a la empresa que el usuario querrá modificar 
            Boolean SinEmpresaEditar=true;//Será cambiada a 'false' si es que 'UsuarioEmpresaEditar' coincide con algún nombre de usuario de empresa registrado en el sistema
            Empresa EmpresaEditar;//Copia de los datos de la empresa a modificar
            int IndexEmpresaModificar=0;//Indica la posicion en la lista de la empresa que se modificará. Esta será copiada a 'EmpresaEditar' y posteriormente eliminada para ser reeemplazada por la copia actualizada de 'EmpresaEditar' 
            string MNombreCompleto, MContraseña, MUser, MConfirmacion="*",MUsuarioRepresentante;//Atributos a modificar para la empresa seleccionada.
            Administrador MRepresentante=null;
            Boolean RepresenantesDisponibles=false;
            int IndexAdministradorParaAsignar = 0;

            //MENU II - CASE 8
            string NNombreA, NContraseñaA, NConfirmacionA, NUserA, NCorreoElectronicoA;
            long NCelularA, NNumeroTrabajadorA;
            string UsuarioAsignacionNuevaDependencia; //User ingresado por el usuario para asignar una dependencia al nuevo adminstrador
            Boolean ConfirmacionContraseñaAdminstrador=false;
            int ExisteEmpresaSinAsignar=0, opcAsignarDependencia=0;
            Empresa NDependenciaA=null;
            int IndexEmpresaAsignar = 0;

            //MENU II - CASE 9
            string UserAdministradorElimnar;

            //PRECARGA DE ADMINISTRADORES Y EMPRESAS
            Empresa HP = new Empresa("HP","CosSnSkJd435c-2","HPInc.Wow");
            ListaEmpresas.Add(HP);
            ContadorEmpresas++;
            Administrador SuperAdministrador = new Administrador("Jesús Jair Camacho Alfaro", "C3C&2116unam_4d00ñ", "CECAdmon", 3243532, "FridayLover4Ever@gmail.com", 5526585229);
            ListaAdministradores.Add(SuperAdministrador);
            ContadorAdministradores++;
            SuperAdministrador.SetDependencia(HP);
            HP.SetRepresentante(SuperAdministrador);

            Empresa OfficeDepot = new Empresa("Office Depot","iCsfnr5467NHF.sfg-Asd","MuchosMueblesAqui");
            ListaEmpresas.Add(OfficeDepot);
            ContadorEmpresas++;
            Administrador BaezaAlvarezIsaura = new Administrador("Baeza Alvarez Isaura","Melon_Asegurado_2001","IsaWow",53476876,"IsauraGrandeIsaura@gmail.com",5523759964);
            ListaAdministradores.Add(BaezaAlvarezIsaura);
            ContadorAdministradores++;
            BaezaAlvarezIsaura.SetDependencia(OfficeDepot);
            OfficeDepot.SetRepresentante(BaezaAlvarezIsaura);

            Empresa HiperLumen = new Empresa("Hiper Lumen", "cndk34.ds", "PapeleriaPeroGrande");
            ListaEmpresas.Add(HiperLumen);
            ContadorEmpresas++;
            Administrador CastañedaArandaAlmaAdriana = new Administrador("Castañeda Aranda Alma Adriana", "TodoMeHabla263","Ow.Dri", 3456782, "Adri_Adr_Ad_A@gmail.com",5532123685);
            ListaAdministradores.Add(CastañedaArandaAlmaAdriana);
            ContadorAdministradores++;
            CastañedaArandaAlmaAdriana.SetDependencia(HiperLumen);
            HiperLumen.SetRepresentante(CastañedaArandaAlmaAdriana);




            Console.WriteLine("\t\t\tCENTRO DE EXPOSICIONES Y CONVENCIONES");
            Console.WriteLine("\t\t\t   SISTEMA DE APARTADO DE SALAS");
            Console.Write("\n");
            Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
            do
            {
                Console.WriteLine("¿Qué tipo de servicio requiere?");
                Console.WriteLine("\t     1. Adiministradores\t2. Empresas\t3. Salir");
                Console.Write("Su opción--> ");
                opcMenu = Convert.ToInt32(Console.ReadLine());
                switch (opcMenu)                                                                                                                                                                   //MENU I (¿Qué servicio desea?)
                {
                    case 1:
                        Console.WriteLine("\t\t\t  MENÚ ADMINISTRADOR");
                        Console.WriteLine("INICIO DE SESIÓN");
                        Console.Write("Usuario: ");
                        UsuarioMenu1=Console.ReadLine();
                        Console.Write("Contraseña: ");
                        ContraseñaMenu1=Console.ReadLine();
                        foreach(Administrador p in ListaAdministradores)
                        {
                            if (UsuarioMenu1 == p.User && ContraseñaMenu1 == p.Contraseña)
                            {
                                if (UsuarioMenu1 == SuperAdministrador.User && ContraseñaMenu1 == SuperAdministrador.Contraseña)                                                                   //Panel de Super Administrador (Incluye el opciones para agregar y eliminar a otros administradores)
                                {
                                    Console.WriteLine("Bienvenido, Ingeniero Jair\n");
                                    do
                                    {
                                        Console.WriteLine("¿Qué desea hacer?");
                                        Console.WriteLine("\t 1. Ver Horarios   2. Descargar Horario  3. Publicar Horario  4. Agregar Empresa  5. Editar Empresa\n" +
                                            "\t 6. Asignar Horario  7. Ver Usuarios  8. Alta Administrador  9. Eliminar Adminstrador  10. Salir");
                                        opcMenuSuperUsuario = Convert.ToInt32(Console.ReadLine());
                                        switch (opcMenuSuperUsuario)                                                                                                                               //MENU II (Panel de administrador)
                                        {
                                            case 1:       
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                Console.WriteLine("AGREGAR EMPRESA\n");
                                                Console.WriteLine("Por favor, ingrese los datos comppletos de la empresa: ");
                                                Console.Write("Nombre de la empresa: ");
                                                NNombreE = Console.ReadLine();
                                                Console.Write("Agregue un usuario para la empresa: ");
                                                NUserE = Console.ReadLine();
                                                do
                                                {
                                                    Console.Write("Establezca una contraseña para la empresa: ");
                                                    NContraselaE = Console.ReadLine();
                                                    Console.Write("Confirme la contraseña: ");
                                                    NConfirmacionE = Console.ReadLine();
                                                    if (NConfirmacionE == NContraselaE)
                                                    {
                                                        ConfirmacionContraseña = true;
                                                    }
                                                    else
                                                        Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                                                } while (ConfirmacionContraseña == false);
                                                foreach (Administrador q in ListaAdministradores)
                                                {
                                                    if (q.Asignado == false)
                                                        ExisteAdministradorSinAsignar = 1;
                                                }
                                                if (ExisteAdministradorSinAsignar == 1)
                                                {
                                                    Console.WriteLine("¿Hay algún administrador en el sistema que será asignado como representante de esta empresa?");
                                                    Console.WriteLine("1. Si  2. No");
                                                    opcAsignarRepresentante = Convert.ToInt32(Console.ReadLine());
                                                    if (opcAsignarRepresentante == 1)
                                                    {
                                                     
                                                            Console.WriteLine("Ingrese el usuario del administrador a asignar como representante de la empresa");
                                                            Console.WriteLine("Los administradores disponibles para ser asignados como respresentantes son:\n");
                                                            foreach (Administrador w in ListaAdministradores)
                                                            {
                                                                if (w.Asignado == false)
                                                                {
                                                                    w.GetCompleteInfo();
                                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");
                                                                }
                                                            }
                                                            Console.Write("\nUsuario del representante: ");
                                                            UsuarioAsignacionNuevoRepresentante = Console.ReadLine();
                                                            foreach (Administrador e in ListaAdministradores)
                                                            {                                                                
                                                                if (UsuarioAsignacionNuevoRepresentante == e.User)
                                                                {
                                                                    NRepresentanteE = e;                                                                    
                                                                }
                                                                IndexAdministradorAsignar++;
                                                            }
                                                        
                                                        Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);//Campo de representante tiene que ser establecido desde el usuario del administrador introducido por el usuario
                                                        Temporal.SetRepresentante(NRepresentanteE);//Se ocupa SetRepresentante para cambiar el estado de la nueva empresa a 'asignada'
                                                        ListaEmpresas.Add(Temporal);
                                                        ContadorEmpresas++;
                                                        ListaAdministradores[IndexAdministradorAsignar-1].SetDependencia(Temporal);
                                                    }
                                                    else
                                                    {
                                                        Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);
                                                        ListaEmpresas.Add(Temporal);
                                                        ContadorEmpresas++;
                                                        Console.WriteLine("\nEl representante para esta empresa quedará pendiente, este podrá ser asignado mas adelante " +
                                                            "cuando se agregue otro administrador al sistema");
                                                    }
                                                }
                                                else
                                                {
                                                    Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);
                                                    ListaEmpresas.Add(Temporal);
                                                    ContadorEmpresas++;
                                                    Console.WriteLine("\nEl representante para esta empresa quedará pendiente, este podrá ser asignado mas adelante " +
                                                        "cuando se agregue otro administrador al sistema");
                                                }
                                                break;
                                            case 5:
                                                Console.WriteLine("EDITAR EMPRESA\n");                                                
                                                Console.WriteLine("Las empresas registradas en el sistema son: \n");
                                                foreach (Empresa r in ListaEmpresas)
                                                {
                                                    r.GetCompleteInfo();
                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");

                                                }
                                                Console.Write("Por favor, ingrese el usuario de la empresa que desee editar: ");
                                                UsuarioEmpresaEditar = Console.ReadLine();
                                                for(int t=0;t<ContadorEmpresas;t++)
                                                {
                                                    if (UsuarioEmpresaEditar == ListaEmpresas[t].User)
                                                    {
                                                        IndexEmpresaModificar = t;
                                                        SinEmpresaEditar = false;
                                                    }      
                                                }
                                                if (SinEmpresaEditar == true)
                                                    Console.WriteLine("El usuario ingresado no pertenece a ninguna empresa dentro del sistema, por favor inténtelo de nuevo");
                                                else
                                                {
                                                    EmpresaEditar = ListaEmpresas[IndexEmpresaModificar];
                                                    ListaEmpresas.RemoveAt(IndexEmpresaModificar);
                                                    ContadorEmpresas--;
                                                    Console.WriteLine("\n\nPor favor, ingrese los nuevos datos para la empresa "+EmpresaEditar.NombreCompleto);
                                                    Console.WriteLine("En caso de no querer realizar cambios para algún campo en específico, coloque un asterisco (*) para dejar los datos originales");
                                                    Console.Write("\nNombre de la empresa: ");
                                                    MNombreCompleto = Console.ReadLine();
                                                    if (MNombreCompleto == "*")
                                                        MNombreCompleto = EmpresaEditar.NombreCompleto;
                                                    Console.Write("Usuario de la empresa: ");
                                                    MUser = Console.ReadLine();
                                                    if (MUser == "*")
                                                        MUser = EmpresaEditar.User;
                                                    do
                                                    {
                                                        Console.Write("Contraseña de la empresa: ");
                                                        MContraseña = Console.ReadLine();
                                                        if (MContraseña == "*")
                                                        {
                                                            MContraseña = EmpresaEditar.Contraseña;
                                                            break;
                                                        }
                                                        else
                                                        {
                                                            Console.Write("Por favor confirme la contraseña: ");
                                                            MConfirmacion = Console.ReadLine();
                                                            if (MContraseña != MConfirmacion)
                                                                Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                                                        }
                                                    } while (MContraseña != MConfirmacion);//MODIFICACION
                                                    MRepresentante = EmpresaEditar.Representante;
                                                    foreach(Administrador y in ListaAdministradores)
                                                    {
                                                        if (y.Asignado == false)
                                                            RepresenantesDisponibles = true;
                                                    }
                                                    if (RepresenantesDisponibles == true)
                                                    {
                                                        do
                                                        {
                                                            Console.WriteLine("Ingrese el nuevo representante de la empresa, los adminstradores disponibles para ser asignados como representantes son: ");
                                                            foreach (Administrador w in ListaAdministradores)
                                                            {
                                                                if (w.Asignado == false)
                                                                    w.GetCompleteInfo();
                                                            }
                                                            Console.WriteLine("Para no realizar cmabios ingresar un asterisco (*)");
                                                            MUsuarioRepresentante = Console.ReadLine();
                                                            if (MUsuarioRepresentante != "*")
                                                            {
                                                                foreach (Administrador t in ListaAdministradores)
                                                                {
                                                                    if (MUsuarioRepresentante == t.User && t.Asignado == false)
                                                                    {
                                                                        MRepresentante = t;
                                                                    }
                                                                    else
                                                                        Console.WriteLine("EL adminstrador ingresado no puede ser asignado como represetnante, inténtelo de nuevo");
                                                                    IndexAdministradorParaAsignar++;
                                                                }
                                                            }
                                                            else
                                                                MRepresentante = EmpresaEditar.Representante;
                                                        } while (MRepresentante == null);
                                                        Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                                        EmpresaModificada.SetRepresentante(MRepresentante);
                                                        ListaEmpresas.Add(EmpresaModificada);
                                                        ContadorEmpresas++;
                                                        if(IndexAdministradorParaAsignar!=0)
                                                            ListaAdministradores[IndexAdministradorParaAsignar-1].SetDependencia(EmpresaModificada);
                                                    }
                                                    else
                                                    {
                                                        Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                                        EmpresaModificada.SetRepresentante(MRepresentante);//MODIFICDO
                                                        ListaEmpresas.Add(EmpresaModificada);
                                                        ContadorEmpresas++;
                                                        Console.WriteLine("\nPor el momento no existen adminstradores libres para ser asignados como representante de esta empresa\n");
                                                        Console.WriteLine("\t\t\tINFORMACIÓN GUARDADA");
                                                    }

                                                }
                                                break;
                                            case 6:
                                                break;
                                            case 7:
                                                Console.WriteLine("LISTA DE ADMINISTRADORES\n");
                                                foreach (Administrador d in ListaAdministradores)
                                                {
                                                    d.GetCompleteInfo();
                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
                                                }
                                                Console.WriteLine("LISTA DE EMPRESAS\n");
                                                foreach (Empresa d in ListaEmpresas)
                                                {
                                                    d.GetCompleteInfo();
                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
                                                }
                                                Console.WriteLine("Número de empresas: " + ContadorEmpresas);
                                                Console.WriteLine("Número de adminstradores: " + ContadorAdministradores);
                                                break;
                                            case 8:
                                                Console.WriteLine("REGISTRO DE NUEVO ADMINISTRADOR\n");
                                                Console.WriteLine("Por favor ingrese los datos del nuevo administrador");
                                                Console.Write("Nombre completo del Administrador: ");
                                                NNombreA = Console.ReadLine();
                                                Console.Write("Agregue un usuario para identificar al administrador: ");
                                                NUserA = Console.ReadLine();
                                                do
                                                {
                                                    Console.Write("Establezca una contraseña para el administrador: ");
                                                    NContraseñaA = Console.ReadLine();
                                                    Console.Write("Confirme la contraseña: ");
                                                    NConfirmacionA = Console.ReadLine();
                                                    if (NConfirmacionA == NContraseñaA)
                                                    {
                                                        ConfirmacionContraseñaAdminstrador = true;
                                                    }
                                                    else
                                                        Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                                                } while (ConfirmacionContraseñaAdminstrador == false);
                                                Console.Write("Número de trabajador del Administrador: ");
                                                NNumeroTrabajadorA = Convert.ToInt64(Console.ReadLine());
                                                Console.Write("Ingrese el correo electrónico del administrador: ");
                                                NCorreoElectronicoA = Console.ReadLine();
                                                Console.Write("Ingrese el número telefónico del nuevo administrador: ");
                                                NCelularA = Convert.ToInt64(Console.ReadLine());


                                                foreach (Empresa q in ListaEmpresas)
                                                {
                                                    if (q.Asignado == false)
                                                        ExisteEmpresaSinAsignar = 1;
                                                }
                                                if (ExisteEmpresaSinAsignar == 1)
                                                {
                                                    Console.WriteLine("¿Hay alguna empresa en el sistema que será asignada como dependencia de este administrador?");
                                                    Console.WriteLine("1. Si  2. No");
                                                    opcAsignarDependencia = Convert.ToInt32(Console.ReadLine());
                                                    if (opcAsignarDependencia == 1)
                                                    {
                                                        do
                                                        {
                                                            Console.WriteLine("Ingrese el usuario de la empresa a asignar como dependencia del administrador");
                                                            Console.WriteLine("Las empresas disponibles para ser asignadas como dependencia son:");
                                                            foreach (Empresa w in ListaEmpresas)
                                                            {
                                                                if (w.Asignado == false)
                                                                    w.GetCompleteInfo();
                                                            }
                                                            Console.Write("Usuario de la empresa: ");
                                                            UsuarioAsignacionNuevaDependencia = Console.ReadLine();
                                                            foreach (Empresa e in ListaEmpresas)
                                                            {
                                                                if (UsuarioAsignacionNuevaDependencia == e.User)
                                                                    NDependenciaA = e;
                                                                IndexEmpresaAsignar++;
                                                            }
                                                        } while (NDependenciaA != null);
                                                        Administrador Temporal = new Administrador(NNombreA, NContraseñaA, NUserA, NNumeroTrabajadorA, NCorreoElectronicoA, NCelularA);//El campo de la dependencia tiene que ser establecido desde el usuario de la empresa introducida por el usuario
                                                        Temporal.SetDependencia(NDependenciaA);//Se ocupa SetDepenedncia para cambiar el estado del nuevo administrador a 'asignado'
                                                        ListaAdministradores.Add(Temporal);
                                                        ContadorAdministradores++;
                                                        ListaEmpresas[IndexEmpresaAsignar-1].SetRepresentante(Temporal);
                                                    }
                                                    else
                                                    {
                                                        Administrador Temporal = new Administrador(NNombreA, NContraseñaA, NUserA, NNumeroTrabajadorA, NCorreoElectronicoA, NCelularA);
                                                        ListaAdministradores.Add(Temporal);
                                                        ContadorAdministradores++;
                                                        Console.WriteLine("\nLa dependencia  para este adminstrador quedará pendiente, esta podrá ser asignada mas adelante " +
                                                            "cuando se agregue otra empresa al sistema");
                                                    }
                                                }
                                                else
                                                {
                                                    Administrador Temporal = new Administrador(NNombreA, NContraseñaA, NUserA,NNumeroTrabajadorA,NCorreoElectronicoA,NCelularA);
                                                    ListaAdministradores.Add(Temporal);
                                                    ContadorAdministradores++;
                                                    Console.WriteLine("\nLa dependencia  para este adminstrador quedará pendiente, esta podrá ser asignada mas adelante " +
                                                        "cuando se agregue otra empresa al sistema");
                                                }


                                                break;
                                            case 9:
                                                Console.WriteLine("ELIMINACION DE ADMINISTRADOR\n");
                                                Console.WriteLine("Por favor, ingrese el usuario del administrador que será eleimiando del sistema");
                                                Console.WriteLine("Los administradores registrados en el sitema hasta el momento son:\n");
                                                foreach (Administrador u in ListaAdministradores)
                                                {
                                                    u.GetCompleteInfo();
                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");
                                                }
                                                Console.Write("El usuario del adminsitrador a eliminar: ");
                                                UserAdministradorElimnar = Console.ReadLine();
                                                for(int n=0; n<ContadorAdministradores;n++)
                                                {
                                                    if (UserAdministradorElimnar == ListaAdministradores[n].User)
                                                        ListaAdministradores.Remove(ListaAdministradores[n]);
                                                }
                                                ContadorAdministradores--;
                                                Console.WriteLine("Administrador "+UserAdministradorElimnar+" eliminado");
                                                break;
                                            case 10:
                                                Console.WriteLine("Regresando a menú superior...");
                                                break;
                                            default:
                                                Console.WriteLine("Opción no válida, por favor intente de nuevo...");
                                                break;
                                        }
                                    } while (opcMenuSuperUsuario != 10);
                                }
                                else                                                                                                                                                                //Panel de Adminstrador común
                                {
                                    foreach(Administrador v in ListaAdministradores)
                                    {
                                        if (UsuarioMenu1==p.User)
                                            BienvenidaUsuario=p.NombreCompleto;
                                    }
                                    Console.WriteLine("Bienvenidx, usuarix "+BienvenidaUsuario);
                                    do
                                    {
                                        Console.WriteLine("¿Qué desea hacer?");
                                        Console.WriteLine("\t 1. Ver Horarios   2. Descargar Horario  3. Publicar Horario  4. Agregar Empresa  5. Editar Empresa\n" +                                   //MENU III
                                            "\t 6. Asignar Horario  7. Ver Usuarios  8. Salir");
                                        opcMenuUsuario = Convert.ToInt32(Console.ReadLine());
                                        switch (opcMenuUsuario)
                                        {
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
                                                Console.WriteLine("AGREGAR EMPRESA\n");
                                                Console.WriteLine("Por favor, ingrese los datos comppletos de la empresa: ");
                                                Console.Write("Nombre de la empresa: ");
                                                NNombreE = Console.ReadLine();
                                                Console.Write("Agregue un usuario para la empresa: ");
                                                NUserE = Console.ReadLine();
                                                do
                                                {
                                                    Console.Write("Establezca una contraseña para la empresa: ");
                                                    NContraselaE = Console.ReadLine();
                                                    Console.Write("Confirme la contraseña: ");
                                                    NConfirmacionE = Console.ReadLine();
                                                    if (NConfirmacionE == NContraselaE)
                                                    {
                                                        ConfirmacionContraseña = true;
                                                    }
                                                    else
                                                        Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                                                } while (ConfirmacionContraseña == false);
                                                foreach (Administrador q in ListaAdministradores)
                                                {
                                                    if (q.Asignado == false)
                                                        ExisteAdministradorSinAsignar = 1;
                                                }
                                                if (ExisteAdministradorSinAsignar == 1)
                                                {
                                                    Console.WriteLine("¿Hay algún administrador en el sistema que será asignado como representante de esta empresa?");
                                                    Console.WriteLine("1. Si  2. No");
                                                    opcAsignarRepresentante = Convert.ToInt32(Console.ReadLine());
                                                    if (opcAsignarRepresentante == 1)
                                                    {

                                                        Console.WriteLine("Ingrese el usuario del administrador a asignar como representante de la empresa");
                                                        Console.WriteLine("Los administradores disponibles para ser asignados como respresentantes son:\n");
                                                        foreach (Administrador w in ListaAdministradores)
                                                        {
                                                            if (w.Asignado == false)
                                                            {
                                                                w.GetCompleteInfo();
                                                                Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");
                                                            }
                                                        }
                                                        Console.Write("\nUsuario del representante: ");
                                                        UsuarioAsignacionNuevoRepresentante = Console.ReadLine();
                                                        foreach (Administrador e in ListaAdministradores)
                                                        {
                                                            if (UsuarioAsignacionNuevoRepresentante == e.User)
                                                            {
                                                                NRepresentanteE = e;
                                                            }
                                                            IndexAdministradorAsignar++;
                                                        }
                                                        Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);//Campo de representante tiene que ser establecido desde el usuario del administrador introducido por el usuario
                                                        Temporal.SetRepresentante(NRepresentanteE);//Se ocupa SetRepresentante para cambiar el estado de la nueva empresa a 'asignada'
                                                        ListaEmpresas.Add(Temporal);
                                                        ContadorEmpresas++;
                                                        ListaAdministradores[IndexAdministradorAsignar - 1].SetDependencia(Temporal);
                                                    }
                                                    else
                                                    {
                                                        Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);
                                                        ListaEmpresas.Add(Temporal);
                                                        ContadorEmpresas++;
                                                        Console.WriteLine("\nEl representante para esta empresa quedará pendiente, este podrá ser asignado mas adelante " +
                                                            "cuando se agregue otro administrador al sistema");
                                                    }
                                                }
                                                else
                                                {
                                                    Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);
                                                    ListaEmpresas.Add(Temporal);
                                                    ContadorEmpresas++;
                                                    Console.WriteLine("\nEl representante para esta empresa quedará pendiente, este podrá ser asignado mas adelante " +
                                                        "cuando se agregue otro administrador al sistema");
                                                }
                                                break;
                                            case 5:
                                                Console.WriteLine("EDITAR EMPRESA\n");
                                                Console.WriteLine("Las empresas registradas en el sistema son: \n");
                                                foreach (Empresa r in ListaEmpresas)
                                                {
                                                    r.GetCompleteInfo();
                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");

                                                }
                                                Console.Write("Por favor, ingrese el usuario de la empresa que desee editar: ");
                                                UsuarioEmpresaEditar = Console.ReadLine();
                                                for (int t = 0; t < ContadorEmpresas; t++)
                                                {
                                                    if (UsuarioEmpresaEditar == ListaEmpresas[t].User)
                                                    {
                                                        IndexEmpresaModificar = t;
                                                        SinEmpresaEditar = false;
                                                    }
                                                }
                                                if (SinEmpresaEditar == true)
                                                    Console.WriteLine("El usuario ingresado no pertenece a ninguna empresa dentro del sistema, por favor inténtelo de nuevo");
                                                else
                                                {
                                                    EmpresaEditar = ListaEmpresas[IndexEmpresaModificar];
                                                    ListaEmpresas.RemoveAt(IndexEmpresaModificar);
                                                    ContadorEmpresas--;
                                                    Console.WriteLine("\n\nPor favor, ingrese los nuevos datos para la empresa " + EmpresaEditar.NombreCompleto);
                                                    Console.WriteLine("En caso de no querer realizar cambios para algún campo en específico, coloque un asterisco (*) para dejar los datos originales");
                                                    Console.Write("\nNombre de la empresa: ");
                                                    MNombreCompleto = Console.ReadLine();
                                                    if (MNombreCompleto == "*")
                                                        MNombreCompleto = EmpresaEditar.NombreCompleto;
                                                    Console.Write("Usuario de la empresa: ");
                                                    MUser = Console.ReadLine();
                                                    if (MUser == "*")
                                                        MUser = EmpresaEditar.User;
                                                    do
                                                    {
                                                        Console.Write("Contraseña de la empresa: ");
                                                        MContraseña = Console.ReadLine();
                                                        if (MContraseña == "*")
                                                        {
                                                            MContraseña = EmpresaEditar.Contraseña;
                                                            break;
                                                        }
                                                        else
                                                        {
                                                            Console.Write("Por favor confirme la contraseña: ");
                                                            MConfirmacion = Console.ReadLine();
                                                            if (MContraseña != MConfirmacion)
                                                                Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                                                        }
                                                    } while (MContraseña != MConfirmacion);//MODIFICACION
                                                    MRepresentante = EmpresaEditar.Representante;
                                                    foreach (Administrador y in ListaAdministradores)
                                                    {
                                                        if (y.Asignado == false)
                                                            RepresenantesDisponibles = true;
                                                    }
                                                    if (RepresenantesDisponibles == true)
                                                    {
                                                        do
                                                        {
                                                            Console.WriteLine("Ingrese el nuevo representante de la empresa, los adminstradores disponibles para ser asignados como representantes son: ");
                                                            foreach (Administrador w in ListaAdministradores)
                                                            {
                                                                if (w.Asignado == false)
                                                                    w.GetCompleteInfo();
                                                            }
                                                            Console.WriteLine("Para no realizar cmabios ingresar un asterisco (*)");
                                                            MUsuarioRepresentante = Console.ReadLine();
                                                            if (MUsuarioRepresentante != "*")
                                                            {
                                                                foreach (Administrador t in ListaAdministradores)
                                                                {
                                                                    if (MUsuarioRepresentante == t.User && t.Asignado == false)
                                                                    {
                                                                        MRepresentante = t;
                                                                    }
                                                                    else
                                                                        Console.WriteLine("EL adminstrador ingresado no puede ser asignado como represetnante, inténtelo de nuevo");
                                                                    IndexAdministradorParaAsignar++;
                                                                }
                                                            }
                                                            else
                                                                MRepresentante = EmpresaEditar.Representante;
                                                        } while (MRepresentante == null);
                                                        Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                                        EmpresaModificada.SetRepresentante(MRepresentante);
                                                        ListaEmpresas.Add(EmpresaModificada);
                                                        ContadorEmpresas++;
                                                        ListaAdministradores[IndexAdministradorParaAsignar - 1].SetDependencia(EmpresaModificada);
                                                    }
                                                    else
                                                    {
                                                        Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                                        EmpresaModificada.SetRepresentante(MRepresentante);//MODIFICDO
                                                        ListaEmpresas.Add(EmpresaModificada);
                                                        ContadorEmpresas++;
                                                        Console.WriteLine("\nPor el momento no existen adminstradores libres para ser asignados como representante de esta empresa\n");
                                                        Console.WriteLine("\t\t\tINFORMACIÓN GUARDADA");
                                                    }
                                                }
                                                break;
                                            case 6:
                                                break;
                                            case 7:
                                                Console.WriteLine("LISTA DE ADMINISTRADORES\n");
                                                foreach (Administrador d in ListaAdministradores)
                                                {
                                                    d.GetCompleteInfo();
                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
                                                }
                                                Console.WriteLine("LISTA DE EMPRESAS\n");
                                                foreach (Empresa d in ListaEmpresas)
                                                {
                                                    d.GetCompleteInfo();
                                                    Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
                                                }
                                                Console.WriteLine("Número de empresas: " + ContadorEmpresas);
                                                Console.WriteLine("Número de adminstradores: " + ContadorAdministradores);
                                                break;
                                            case 8:
                                                Console.WriteLine("Regresando a menú superior...");
                                                break;
                                            default:
                                                Console.WriteLine("Opción no válida, por favor intente de nuevo...");
                                                break;
                                        }
                                    } while (opcMenuUsuario != 8);
                                    //Copia deL panel de superadministrador, excluyendo a los cases 8 y 9
                                }
                            }
                            else
                                DatosErroneosMenuII = true;
                        }
                        if (DatosErroneosMenuII == true)
                        {
                            Console.WriteLine("\nLa contraseña o usuario ingresados son incorrectos, por favor inténtelo de nuevo\n");
                            Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
                        }
                        break;
                    case 2:
                        Console.WriteLine("\t\t\t  MENÚ EMPRESAS");                                                                                                                                  //MENU IV
                        String opcion = null;//RESIDUO DE PROGRAMA DEL CHEF ALEXIS
                        // SeleccionarDia(false, opcion, "HP", "Alexis Cote", "Programación Paralela");
                        Console.WriteLine("¿La empresa ya cuenta con un perfil registrado en el sistema?");
                        Console.WriteLine("\t1.Si\t2.No");
                        opcMenuIII=Convert.ToInt32(Console.ReadLine());
                        if (opcMenuIII == 1)
                        {
                            Console.WriteLine("INCIO DE SESION");
                            Console.Write("Usuario de la empresa: ");
                            InicioSesionEmpresa = Console.ReadLine();
                            Console.Write("Contraseña de la empresa: ");
                            InicioSesionEmpresaContra = Console.ReadLine();
                            foreach(Empresa z in ListaEmpresas)//Oportunidad para try-cath: Al eliminar algun elemnto de la lista de empresas, este 'foreach' generará una excepcion por la modificacion de sus limites de ejecucion 
                            {
                                if (InicioSesionEmpresa == z.User && InicioSesionEmpresaContra == z.Contraseña)
                                {
                                    EmpresaUsuaria = z;//Empresa que está ocupando el sistema, será de esta la informacion que se muestre, los horarios que se apartarán y los que se mostrarán como ya apartados
                                    InicioSesionExitoso = true;
                                    do
                                    {
                                        Console.WriteLine("¿Qué desea hacer?");
                                        Console.WriteLine("1. Editar información\t2. Reservar horario\t3. Ver horarios reservados por la empresa\n4. Salir");
                                        Console.Write("Su opción: ");
                                        opcMenuEmpresa = Convert.ToInt32(Console.ReadLine());
                                        switch (opcMenuEmpresa)
                                        {
                                            case 1:
                                                Console.WriteLine("EDITAR INFORMACIÓN");
                                                Console.WriteLine("Ingrese la nueva información para "+EmpresaUsuaria.NombreCompleto);
                                                Console.WriteLine("Si desea mantener la información origianl, ingrese un asteristco (*)");
                                                Console.Write("\nNombre de la empresa: ");
                                                MNombreCompleto = Console.ReadLine();
                                                if (MNombreCompleto == "*")
                                                    MNombreCompleto = EmpresaUsuaria.NombreCompleto;
                                                Console.Write("Usuario de la empresa: ");
                                                MUser = Console.ReadLine();
                                                if (MUser == "*")
                                                    MUser = EmpresaUsuaria.User;
                                                do
                                                {
                                                    Console.Write("Contraseña de la empresa: ");
                                                    MContraseña = Console.ReadLine();
                                                    if (MContraseña == "*")
                                                    {
                                                        MContraseña = EmpresaUsuaria.Contraseña;
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        Console.Write("Por favor confirme la contraseña: ");
                                                        MConfirmacion = Console.ReadLine();
                                                        if (MContraseña != MConfirmacion)
                                                            Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                                                    }
                                                } while (MContraseña != MConfirmacion);
                                                MRepresentante = EmpresaUsuaria.Representante;
                                                foreach (Administrador y in ListaAdministradores)
                                                {
                                                    if (y.Asignado == false)
                                                        RepresenantesDisponibles = true;
                                                }
                                                if (RepresenantesDisponibles == true)
                                                {
                                                    do
                                                    {
                                                        Console.WriteLine("Ingrese el nuevo representante de la empresa, los adminstradores disponibles para ser asignados como representantes son: ");
                                                        foreach (Administrador w in ListaAdministradores)
                                                        {
                                                            if (w.Asignado == false)
                                                                w.GetCompleteInfo();
                                                        }
                                                        Console.WriteLine("Para no realizar cmabios ingresar un asterisco (*)");
                                                        MUsuarioRepresentante = Console.ReadLine();
                                                        if (MUsuarioRepresentante != "*")
                                                        {
                                                            foreach (Administrador t in ListaAdministradores)
                                                            {
                                                                if (MUsuarioRepresentante == t.User && t.Asignado == false)
                                                                {
                                                                    MRepresentante = t;
                                                                }
                                                                else
                                                                    Console.WriteLine("EL adminstrador ingresado no puede ser asignado como represetnante, inténtelo de nuevo");
                                                                IndexAdministradorParaAsignar++;
                                                            }
                                                        }
                                                        else
                                                            MRepresentante = EmpresaUsuaria.Representante;
                                                    } while (MRepresentante == null);
                                                    Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                                    EmpresaModificada.SetRepresentante(MRepresentante);
                                                    ListaEmpresas.Add(EmpresaModificada);
                                                    ContadorEmpresas++;
                                                    ListaAdministradores[IndexAdministradorParaAsignar - 1].SetDependencia(EmpresaModificada);
                                                }
                                                else
                                                {
                                                    Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                                    EmpresaModificada.SetRepresentante(MRepresentante);//MODIFICDO
                                                    ListaEmpresas.Add(EmpresaModificada);
                                                    ContadorEmpresas++;
                                                    Console.WriteLine("\nPor el momento no existen adminstradores libres para ser asignados como representante de esta empresa\n");
                                                    Console.WriteLine("\t\t\tINFORMACIÓN GUARDADA");
                                                }
                                                break;
                                            case 2:
                                                Console.WriteLine("RESERVAR HORARIO");
                                                break;
                                            case 3:
                                                Console.WriteLine("VER HORARIOS RESERVADOS POR LA EMPRESA");
                                                break;
                                            case 4:
                                                Console.WriteLine("Regresando a menú superior...");
                                                break;
                                            default:
                                                Console.WriteLine("Opción no válida, por favor intente de nuevo...");
                                                break;

                                        }
                                    } while (opcMenuEmpresa != 4);
                                }
                            }
                            if (InicioSesionExitoso == false)
                                Console.WriteLine("El usuario o contraseña ingresadas no son correctos, por favor inténtelo de nuevo");
                        }
                        if (opcMenuIII == 2)
                        {
                            Console.WriteLine("CREACION DE PERFIL PARA UNA NUEVA EMPRESA");
                            Console.WriteLine("Por favor, ingrese los datos comppletos de la empresa: ");
                            Console.Write("Nombre de la empresa: ");
                            NNombreE = Console.ReadLine();
                            Console.Write("Agregue un usuario para la empresa: ");
                            NUserE = Console.ReadLine();
                            do
                            {
                                Console.Write("Establezca una contraseña para la empresa: ");
                                NContraselaE = Console.ReadLine();
                                Console.Write("Confirme la contraseña: ");
                                NConfirmacionE = Console.ReadLine();
                                if (NConfirmacionE == NContraselaE)
                                {
                                    ConfirmacionContraseña = true;
                                }
                                else
                                    Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                            } while (ConfirmacionContraseña == false);
                            foreach (Administrador q in ListaAdministradores)
                            {
                                if (q.Asignado == false)
                                    ExisteAdministradorSinAsignar = 1;
                            }
                            if (ExisteAdministradorSinAsignar == 1)
                            {
                                Console.WriteLine("¿Hay algún administrador en el sistema que será asignado como representante de esta empresa?");
                                Console.WriteLine("1. Si  2. No");
                                opcAsignarRepresentante = Convert.ToInt32(Console.ReadLine());
                                if (opcAsignarRepresentante == 1)
                                {

                                    Console.WriteLine("Ingrese el usuario del administrador a asignar como representante de la empresa");
                                    Console.WriteLine("Los administradores disponibles para ser asignados como respresentantes son:\n");
                                    foreach (Administrador w in ListaAdministradores)
                                    {
                                        if (w.Asignado == false)
                                        {
                                            w.GetCompleteInfo();
                                            Console.WriteLine("\t  ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■\n");
                                        }
                                    }
                                    Console.Write("\nUsuario del representante: ");
                                    UsuarioAsignacionNuevoRepresentante = Console.ReadLine();
                                    foreach (Administrador e in ListaAdministradores)
                                    {
                                        if (UsuarioAsignacionNuevoRepresentante == e.User)
                                        {
                                            NRepresentanteE = e;
                                        }
                                        IndexAdministradorAsignar++;
                                    }

                                    Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);//Campo de representante tiene que ser establecido desde el usuario del administrador introducido por el usuario
                                    Temporal.SetRepresentante(NRepresentanteE);//Se ocupa SetRepresentante para cambiar el estado de la nueva empresa a 'asignada'
                                    ListaEmpresas.Add(Temporal);
                                    ContadorEmpresas++;
                                    ListaAdministradores[IndexAdministradorAsignar - 1].SetDependencia(Temporal);
                                    EmpresaUsuaria = Temporal;
                                }
                                else
                                {
                                    Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);
                                    ListaEmpresas.Add(Temporal);
                                    ContadorEmpresas++;
                                    Console.WriteLine("\nEl representante para esta empresa quedará pendiente, este podrá ser asignado mas adelante " +
                                        "cuando se agregue otro administrador al sistema");
                                    EmpresaUsuaria = Temporal;
                                }
                            }
                            else
                            {
                                Empresa Temporal = new Empresa(NNombreE, NContraselaE, NUserE);
                                ListaEmpresas.Add(Temporal);
                                ContadorEmpresas++;
                                Console.WriteLine("\nEl representante para esta empresa quedará pendiente, este podrá ser asignado mas adelante " +
                                    "cuando se agregue otro administrador al sistema");
                                EmpresaUsuaria = Temporal;
                            }
                            
                            do
                            {
                                Console.WriteLine("¿Qué desea hacer?");
                                Console.WriteLine("1. Editar información\t2. Reservar horario\t3. Ver horarios reservados por la empresa\n4. Salir");
                                Console.Write("Su opción: ");
                                opcMenuEmpresa = Convert.ToInt32(Console.ReadLine());
                                switch (opcMenuEmpresa)
                                {
                                    case 1:
                                        Console.WriteLine("EDITAR INFORMACIÓN");
                                        Console.WriteLine("Ingrese la nueva información para " + EmpresaUsuaria.NombreCompleto);
                                        Console.WriteLine("Si desea mantener la información origianl, ingrese un asteristco (*)");
                                        Console.Write("\nNombre de la empresa: ");
                                        MNombreCompleto = Console.ReadLine();
                                        if (MNombreCompleto == "*")
                                            MNombreCompleto = EmpresaUsuaria.NombreCompleto;
                                        Console.Write("Usuario de la empresa: ");
                                        MUser = Console.ReadLine();
                                        if (MUser == "*")
                                            MUser = EmpresaUsuaria.User;
                                        do
                                        {
                                            Console.Write("Contraseña de la empresa: ");
                                            MContraseña = Console.ReadLine();
                                            if (MContraseña == "*")
                                            {
                                                MContraseña = EmpresaUsuaria.Contraseña;
                                                break;
                                            }
                                            else
                                            {
                                                Console.Write("Por favor confirme la contraseña: ");
                                                MConfirmacion = Console.ReadLine();
                                                if (MContraseña != MConfirmacion)
                                                    Console.WriteLine("Las contraseñas no coinciden, por favor inténtelo de nuevo");
                                            }
                                        } while (MContraseña != MConfirmacion);
                                        MRepresentante = EmpresaUsuaria.Representante;
                                        foreach (Administrador y in ListaAdministradores)
                                        {
                                            if (y.Asignado == false)
                                                RepresenantesDisponibles = true;
                                        }
                                        if (RepresenantesDisponibles == true)
                                        {
                                            do
                                            {
                                                Console.WriteLine("Ingrese el nuevo representante de la empresa, los adminstradores disponibles para ser asignados como representantes son: ");
                                                foreach (Administrador w in ListaAdministradores)
                                                {
                                                    if (w.Asignado == false)
                                                        w.GetCompleteInfo();
                                                }
                                                Console.WriteLine("Para no realizar cmabios ingresar un asterisco (*)");
                                                MUsuarioRepresentante = Console.ReadLine();
                                                if (MUsuarioRepresentante != "*")
                                                {
                                                    foreach (Administrador t in ListaAdministradores)
                                                    {
                                                        if (MUsuarioRepresentante == t.User && t.Asignado == false)
                                                        {
                                                            MRepresentante = t;
                                                        }
                                                        else
                                                            Console.WriteLine("EL adminstrador ingresado no puede ser asignado como represetnante, inténtelo de nuevo");
                                                        IndexAdministradorParaAsignar++;
                                                    }
                                                }
                                                else
                                                    MRepresentante = EmpresaUsuaria.Representante;
                                            } while (MRepresentante == null);
                                            Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                            EmpresaModificada.SetRepresentante(MRepresentante);
                                            ListaEmpresas.Add(EmpresaModificada);
                                            ContadorEmpresas++;
                                            ListaAdministradores[IndexAdministradorParaAsignar - 1].SetDependencia(EmpresaModificada);
                                        }
                                        else
                                        {
                                            Empresa EmpresaModificada = new Empresa(MNombreCompleto, MContraseña, MUser);
                                            EmpresaModificada.SetRepresentante(MRepresentante);//MODIFICDO
                                            ListaEmpresas.Add(EmpresaModificada);
                                            ContadorEmpresas++;
                                            Console.WriteLine("\nPor el momento no existen adminstradores libres para ser asignados como representante de esta empresa\n");
                                            Console.WriteLine("\t\t\tINFORMACIÓN GUARDADA");
                                        }
                                        break;
                                    case 2:
                                        Console.WriteLine("RESERVAR HORARIO");
                                        break;
                                    case 3:
                                        Console.WriteLine("VER HORARIOS RESERVADOS POR LA EMPRESA");
                                        break;
                                    case 4:
                                        Console.WriteLine("Regresando a menú superior...");
                                        break;
                                    default:
                                        Console.WriteLine("Opción no válida, por favor intente de nuevo...");
                                        break;

                                }
                            } while (opcMenuEmpresa != 4);


                        }
                        else
                            Console.WriteLine("Opcion no válida, por favor inténtelo de nuevo");
                        break;
                    case 3:
                        opc = 3;
                        Console.WriteLine("¡Gracias por ocupar nuestros servicios!");
                        break;
                    default:
                        Console.WriteLine("Opción no válida, por favor intente de nuevo...");
                        break;
                }
            } while (opc != 3);            
        }        
    }
}
