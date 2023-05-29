import java.util.HashMap;
import java.util.Map;
public class ManejoDeTablasHashEnJava {
	//Atributos
	//Constructores
	HashMap <Integer,String> MapaHash=new HashMap <>();
	//Metodos
	
	public void AdicionDeParesput(){
		System.out.println("\nAgregando valores a nuestra tabla hash introducionendo"
				+ ", como ejemplo un par con la clave '317244331' y el valor "
				+ "'Recinos Hernandez Luis Mario'");
		MapaHash.put(317244331,"Recinos Hernandez Luis Mario");
		System.out.println(MapaHash);
		System.out.println("Agregando unos cuantos valores mas, terminamos con "
				+ "la siguiente tabla: ");
		MapaHash.put(317432233,"Cote Valencia Alexis Daniel");
		MapaHash.put(317443254,"Roman Gutierres Adolfo");
		MapaHash.put(317654890,"Cásares Gutierres Daniel");
		MapaHash.put(343278854,"Flores Figueroa Jaime");
		System.out.println(MapaHash);	
		
	}
	public void BusquedacontainsKey() {
		System.out.println("\n¿Se encuentra en nuestro "
				+ "Mapa Hash el par calve-valor"
				+ " con la clave 317244331? ");
		System.out.println(MapaHash.containsKey(317244331));
		System.out.println("¿Y con la clave 666666666?");
		System.out.println(MapaHash.containsKey(666666666));
	}
	public void BusquedacontainsValue() {
		System.out.println("\n¿Se encuentra en nuestro "
				+ "Mapa Hash el par calve-valor"
				+ " con el valor 'Recinos Hernadez Luis Mario'? ");
		System.out.println(MapaHash.containsValue("Recinos Hernandez Luis Mario"));
		System.out.println("¿Y para el valor 'Lampara roja'?");
		System.out.println(MapaHash.containsValue("Lampara roja"));
	}
	public void ComparacionEquals() {
		System.out.println("\nPara la demostracion del resultado de las "
				+ "comparaciones realizadas por este metodo, generaremos "
				+ "un segundo Mapa Hash");
		HashMap <Integer,String> MapaHashSecunadrio=new HashMap <>();
		MapaHashSecunadrio.put(0, null);
		MapaHashSecunadrio.put(2, "Lampara roja");
		System.out.println("Este mapa secunadio tendra "
				+ "la siguiente estructura: "+MapaHashSecunadrio);
		System.out.println("El resultado entregado por el metodo equals"
				+ " entre nuestro Mapa Hash original y el secundario es:\n"
				+ MapaHash.equals(MapaHashSecunadrio)+"<--- Esto quiere decir"
						+ " que ambos mapas no son iguales");
		System.out.println("Por el contario, si compararmos a nuestro Mapa "
				+ "original con él mismo, obtendremos el siguiente resultado:\n"
				+ MapaHash.equals(MapaHash));
	}
	public void ObtencionValoresget() {
		System.out.println("\n¿A que estudiante pertenecera la clave "
				+ "correspondiente al numero de cuenta 317244331?");
		System.out.println(MapaHash.get(317244331));
		System.out.println("¿Y que tal al numero de cuenta 666666?");
		System.out.println(MapaHash.get(666666));
		System.out.println("Esto quiere decir que no existe un par con esa"
				+ " clave en especifico");
	}
	public void QuitarValoresRemove() {
		System.out.println("\nEn un primer caso, el metodo remove puede "
				+ "funcionar con la entrada una clave, misma"
				+ " que relacionará con un valor para realizar la"
				+ " eliminaion del par");
		System.out.println("Dando como parametro de entrada"
				+ " al metodo la clave 343278854");
		System.out.println("· Pasamos de tener una tabla asi:");
		System.out.println(MapaHash);
		System.out.println(MapaHash.remove(343278854)+"<--El metodo regresa el valor"
				+ " que haya estado relacionado con la clave introducida para "
				+ "indicar que el par correspondiente fue eliminado");
		System.out.println("· A una tabla con los siguientes valores: ");
		System.out.println(MapaHash);
		System.out.println("¿Que pasa al meter como entrada una clave inexistente"
				+ " en la tabla hash?");
		System.out.println(MapaHash.remove(66666666));
		System.out.println("\nExiste otra forma de ocupar del metodo "
				+ "remove que implica a ambos la clave y el valor como "
				+ "parametros de tal forma que la eliminacion solo se "
				+ "llevara a cabo si se encuentra exactamente este par clave-valor "
				+ "dentro de la tabla hash");
		System.out.println("¿Que ocurre cuando pasamos al metodo una clave "
				+ "que no corresponde su verdadero valor en la tabla?");
		
		System.out.println(MapaHash.remove(317654890, "Recinos Hernández Luis Mario")+""
				+ "indica que no se encontro un par clave-valor para eliminar");
		System.out.println("Obtendremos una eliminacion como con nuestro primer "
				+ "intento si colocamos un verdadero par clave-valor");
		System.out.println("· De esta forma pasamos de tener una tabla asi:");
		System.out.println(MapaHash+"<--Indicacion que el metodo encontro un par"
				+ "para eliminar");
		System.out.println(MapaHash.remove(317654890, "Cásares Gutierres Daniel"));
		System.out.println("· A una tabla final con los siguientes valores:");
		System.out.println(MapaHash);
	}
	public void size() {
		System.out.println("Tomando en cuenta uqe ahora tenemos el HashMap:");
		System.out.println(MapaHash);
		System.out.println("¿Cuantos pares hay ahora en nuestra tabla hash?");
		System.out.println("Respuesta= "+MapaHash.size());
	}
}
