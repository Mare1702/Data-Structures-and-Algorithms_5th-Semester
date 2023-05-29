import java.util.Scanner;
import java.util.*;
public class MenuPractica {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opc;
		System.out.println("-----Bienvenido-----");
		System.out.println("Menu de la practica #5");
		
		do {
			System.out.println("****************************");
			System.out.println("1) Manejo de Tablas "
					+ "Hash en Java  2)Funcion hash"
					+ " por modulo  3)Encadenamiento  4)Salir");
			System.out.println("\nPor favor seleccione alguna"
					+ " de las clases (favor de presionar enter 2 veces)...");
			opc=scan.nextInt();
			switch(opc){
			case 1:
				ManejoDeTablasHashEnJava obj1=new ManejoDeTablasHashEnJava();
				System.out.println("\n\n****************************");
				System.out.println("\t\t\tIngreso a tablas hash en java");
				System.out.println("En primer lugar, necesitamos de una tabla"
						+ "Hash con la que trabajar, para ello podemos ocupar"
						+ " del metodo 'put<K,V>', que toma dos parametros, una "
						+ "calve y un valor para unirlos y almacenarlos como "
						+ "una entidad llamada 'par clave-valor'");
				obj1.AdicionDeParesput();
				System.out.println("\nUso de metodo 'containsKey<K>' para"
						+ " comprobar si un par clave-valor existe"
						+ " segun una clave en especifico");
				obj1.BusquedacontainsKey();
				System.out.println("\nUso de metodo 'containsValue<V>' para"
						+ "comprobar si un par clave-valor existe"
						+ "segun una valor en especifico");
				obj1.BusquedacontainsValue();
				System.out.println("\nUso de metodo 'equals<objeto>' para comparacion"
						+ " de nuestro Mapa Hash con algun otro objeto");
				obj1.ComparacionEquals();
				System.out.println("\nUso de metodo 'get<K>' para la obtencion de"
						+ "de algun valor segun una clave de entrada");
				obj1.ObtencionValoresget();
				System.out.println("\nOcupando ahora el metodo 'remove' para "
						+ "quitar un par clave-valor de nuestra tabla hash");
				obj1.QuitarValoresRemove();
				System.out.println("Finalmente, ocupamos el metodo 'size' para "
						+ "obtener un entero representativo de la cantidad"
						+ " de pares clave-valor almacenada en nuestra tabla hash");
				obj1.size();
			break;
			case 2:
				int opc2;
				HashMódulo obj2=new HashMódulo();
				List<Double> lista1 = new ArrayList<>();	
				for(int i=0;i<21;i++) {
					lista1.add(i, null);
				}
				System.out.println("Arreglo inicializado:");
				for(int i=0;i<21;i++) {
					System.out.println(lista1.get(i));
				}
				System.out.println("\n\n****************************");
				System.out.println("Ingreso funciones hash por modulo");
				
				do {
					System.out.println("¿Que desea hacer?\nPor favor "
							+ "seleccione una opcion del menu:");
					System.out.println("1)Agregar elementos a la lista  "
							+ "2)Imprimir lista  3)Buscar elementos");
					opc2=scan.nextInt();
					switch(opc2) {
					case 1:
						System.out.print("Por favor ingrese la clave"
								+ " que quiera ingresar)-->");
						Double d=scan.nextDouble();
						lista1.add(d);
					break;
					case 2:
						System.out.println("La lista hasta ahora es:");
						for(int i=0;i<21;i++) {
							System.out.println(lista1.get(i));
						}
					break;
					case 3:
					break;
					}
				}while(opc2!=4);
			break;
			case 3:
				System.out.println("\n\n****************************");
				System.out.println("Ingreso a encadenamiento");
			break;	
			case 4:
				System.out.println("\n\n****************************");
				System.out.println("Ciao!");
			break;
			}
		}while(opc!=4);
	}
}
