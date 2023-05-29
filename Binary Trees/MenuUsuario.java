import java.util.*;
public class MenuUsuario {

	public static void main(String[] args) {
		ArbolBin arbol=null;
		ArbolBinBus arbolbus=null;
		Nodo NodoEliminacion=null;
        int Nds=0, N=0,NodoHijo=0,NodoBuscado=0,NodoObjetivo=0,NodoAgregar=0,raiz=0,NodoCrea=0;
        int ValoresNodo[]=null;
        Nodo NodeArray[]=null;
        boolean SalidaTryCatch=false,EncuentroNds=false,FinCreaBus=false;
        Scanner Scan=new Scanner(System.in);
        ValoresNodo=new int [150];
		int opc1,opc2,opc;
		System.out.println("\t\tBienvenido al Menú de usuario");
		do {
			System.out.println("\n\t    ¿Con qué tipo de arbol desea trabajar?");
			System.out.println("\n1. Árbol Binario Base\t2. Árbol Binario de Búsqueda\t3. Árbol B\n\n\t\t\t4. Salir");
			System.out.print("\n\nSu opción->");
			opc1=Scan.nextInt();
			switch(opc1) {
				case 1:
					System.out.println("\t\t\t       TRABAJO CON ÁRBOL BINARIO BASE");
					do {
						Scanner scanner=new Scanner(System.in);
						System.out.println("\n\t\t\t\t    ¿Qué desea hacer?");
						System.out.println("\n1. Crear árbol\t\t   2. Agregar dato\t3. Eliminar dato\t4. Imprimir árbol (BFS)");
						System.out.println("\n5. Notación prefija (preorden)\t6. Notación Infija (Inorden)\t7. Notación Postfija (Postorden)\n\t\t\t\t\t8. Salir");
						System.out.print("\n\nSu opción->");
						opc2=scanner.nextInt();
						switch(opc2){
						case 1:
							System.out.println("\t\t\t\tCREACIÓN DE ÁRBOL");			
							System.out.println("Ingrese el valor de los nodos que conformarán al árbol a crear. Por favor, comience con la raíz del árbol");
					    	System.out.println("Cuando haya terminado de ingresar los nodos, presione cualquier letra para continuar");
					    	do {
						        try { 
						        	System.out.print("-> ");
							        ValoresNodo[N]=Scan.nextInt();
							        N++;   
						        }catch(Exception e){
					        	SalidaTryCatch=true;
						        }  
					    	}while(SalidaTryCatch==false);
					    	NodeArray=new Nodo[150];
					        //Nodo [] NodeArray=new Nodo[N];//MODIFICAION DE 150->N
					        for(int i=0;i<N;i++) {
					        	NodeArray[i]=new Nodo(ValoresNodo[i]);
					        	arbol=new ArbolBin(NodeArray[0]);
					        }
					        Scanner Scan2=new Scanner(System.in);
					        System.out.println("Ahora, por favor ingrese las relaciones de los nodos que acaba de ingresar");
					        for(int i=0;i<N;i++) {
					        	System.out.println("¿El nodo "+ValoresNodo[i]+" tiene algún hijo izquierdo?\n\t1. Si  2. No");
					        	opc=Scan2.nextInt();
					        	if(opc==1) {
					        		System.out.println("¿Cuál de los nodos ingresados?\nNodos ingresados: ");
					        		for(int j=0;j<N;j++) {
					        			if(j!=N-1) {
					        				System.out.print(ValoresNodo[j]);
					        				System.out.print(",");
					        			}
					        			else 
					        				System.out.println(ValoresNodo[j]);
					        		}
					        		Nds=Scan2.nextByte();
					        		if(Nds==ValoresNodo[i]) {
					        			do {
					        				System.out.println("El nodo padre no puede ser hijo de sí mismo, inténtelo de nuevo");
					        				Nds=Scan2.nextInt();
					        			}while(Nds==ValoresNodo[i]);
					        		}
					        		do {
						        		for(int k=0;k<N;k++) {
						        			if(Nds==ValoresNodo[k]) {
						        				EncuentroNds=true;
						        				NodoHijo=k;
						        			}
						        		}
						        		if(EncuentroNds==false) {
						        			System.out.println("Nodo no declarado, inténtelo de nuevo");
						        			Nds=Scan2.nextInt();
						        		}
					        		}while(EncuentroNds!=true);
					        		arbol.add(NodeArray[i], NodeArray[NodoHijo], 0);
					        		System.out.println("INFORMACION GUARDADA");
					        	}
					        	
					        	
					    		System.out.println("Ahora ¿El nodo "+ValoresNodo[i]+" tiene algún hijo derecho?\n\t1. Si  2. No");
					    		opc=Scan2.nextInt();
					        	if(opc==1) {
					        		System.out.println("¿Cuál de los nodos ingresados?");
					        		for(int j=0;j<N;j++) {
					        			if(j!=N-1) {
					        				System.out.print(ValoresNodo[j]);
					        				System.out.print(",");
					        			}
					        			else 
					        				System.out.println(ValoresNodo[j]);
					        		}
					        		Nds=Scan2.nextInt();
					        		if(Nds==ValoresNodo[i]) {
					        			do {
					        				System.out.println("El nodo padre no puede ser hijo de sí mismo, inténtelo de nuevo");
					        				Nds=Scan2.nextInt();
					        			}while(Nds==ValoresNodo[i]);
					        		}
					        		do {
						        		for(int t=0;t<N;t++) {
						        			if(Nds==ValoresNodo[t]) {
						        				EncuentroNds=true;
						        				NodoHijo=t;
						        			}
						        		}
						        		if(EncuentroNds==false) {
						        			System.out.println("Nodo no declarado, inténtelo de nuevo");
						        			Nds=Scan2.nextInt();
						        		}
					        		}while(EncuentroNds!=true);
					        		arbol.add(NodeArray[i], NodeArray[NodoHijo], 1);
					        		System.out.println("INFORMACION GUARDADA");
					        	}
					        	else if(opc==2) {
					        		System.out.println("----------------------------------------------------------------");
					        	}
					        }
							break;
						case 2:
							System.out.println("\t\tAGREGAR DATO");
							System.out.print("Ingrese el valor del nodo que quiera agregar -> ");
							int k=0;
							List <Nodo> ListaCase2=new LinkedList();
							NodoAgregar=scanner.nextInt();
							Nodo NuevoNodo=new Nodo(NodoAgregar);
							Nodo r=arbol.root;
							Nodo Padre;
							Queue<Nodo> ColaCase2=new LinkedList();
							if(r!=null) {
								ColaCase2.add(r);
								while(!ColaCase2.isEmpty()) {
									r=(Nodo)ColaCase2.poll();
									ListaCase2.add(r);
									if(r.izq!=null)
										ColaCase2.add(r.izq);
									if(r.der!=null)
										ColaCase2.add(r.der);
								}
								Padre=ListaCase2.get(ListaCase2.size()-1);
								arbol.add(Padre, NuevoNodo, 0);
							}

							break;
						case 3:
							System.out.println("\t\tELIMINAR DATO");
							System.out.println("¿Qué nodo es el que desea eliminar?");
							for(int j=0;j<N;j++) {
			        			if(j!=N-1) {
			        				System.out.print(ValoresNodo[j]);
			        				System.out.print(",");
			        			}
			        			else 
			        				System.out.println(ValoresNodo[j]);
			        		}
							System.out.print("Por favor ingrese el valor del nodo -> ");
							NodoObjetivo=scanner.nextInt();
							Nodo t=arbol.root;
							Queue<Nodo> Cola=new LinkedList();
							if(t!=null) {
								Cola.add(t);
								while(!Cola.isEmpty()) {
									t=(Nodo)Cola.poll();
									if(t.valor==NodoObjetivo) {
										NodoEliminacion=t;
									}
									if(t.izq!=null)
										Cola.add(t.izq);
									if(t.der!=null)
										Cola.add(t.der);
								}
							}
							arbol.DelNodes(NodoEliminacion);//IMPLEMENTAR BFS PARA REGRESAR COINCIDENCIAS CON NODOOBJETIVO
							break;
						case 4:
							System.out.println("\t\tIMPRIMIR ÁRBOL (BFS)");
							System.out.println("La BFS del arbol creado es: ");
					        arbol.breadthFrist();
					        System.out.println("----------------------------------------------------------------");
							break;
						case 5:
							System.out.println("\t\tNOTACIÓN PREFIJA (PREORDEN)");
							arbol.RPreorden();
					        System.out.println("----------------------------------------------------------------");
							break;
						case 6:
							System.out.println("\t\tNOTACIÓN INFIJA (INORDEN)");
							arbol.RInorden();
					        System.out.println("----------------------------------------------------------------");
							break;
						case 7:
							System.out.println("\t\tNOTACIÓN POSTFIJA (POSTORDEN)");
							arbol.RPostorden();
							System.out.println("----------------------------------------------------------------");
							break;
						case 8:
							System.out.println("SALIDA DE TRABAJO CON ÁRBOLES BINARIOS BASE...");
							break;
						default:
							System.out.println("Opción no válida, por favor inténtelo de nuevo");
						}
					}while (opc2!=8);
					break;
				case 2:
					System.out.println("\t\tTRABAJO CON ÁRBOL BINARIO DE BÚSQUEDA");
					Scanner scanner=new Scanner(System.in);
					do {
						System.out.println("\n\t\t\t\t    ¿Qué desea hacer?");
						System.out.println("\n1. Crear árbol\t\t   2. Agregar dato\t3. Eliminar dato\t4. Buscar");
						System.out.println("\n5. Imprimir árbol (BFS)\t6.Salir");
						System.out.print("\n\nSu opción->");
						opc2=scanner.nextInt();
						switch(opc2){
						case 1:
							System.out.println("\t\t\t\tCREACIÓN DE ÁRBOL");
							System.out.print("Por favor ingrese la raíz del árbol->");
							raiz=scanner.nextInt();
							Nodo PadreB=new Nodo(raiz);
							arbolbus=new ArbolBinBus(PadreB);
							do {
								System.out.print("El arbol tendrá más hijos?\n\t1. Si\t2. No\n-> ");
								opc=scanner.nextInt();
								if(opc==2)
									FinCreaBus=true;
								else {
									System.out.print("¿Qué nodo será el siguiente?\n-> ");
									NodoCrea=scanner.nextInt();
									Nodo Siguiente=new Nodo(NodoCrea);
									arbolbus.add(PadreB, Siguiente);
									System.out.println("NODO AGREGADO");
								}
							}while(FinCreaBus==false);
							
							break;
						case 2:
							System.out.println("\t\tAGREGAR DATO");
							System.out.print("Ingrese el valor del nodo que quiera agregar -> ");
							break;
						case 3:
							System.out.println("\t\tELIMINAR DATO");
							System.out.println("¿Qué nodo es el que desea eliminar?");
							System.out.print("Por favor ingrese el valor del nodo -> ");
							NodoObjetivo=scanner.nextInt();
							Nodo t=arbol.root;
							Queue<Nodo> Cola=new LinkedList();
							if(t!=null) {
								Cola.add(t);
								while(!Cola.isEmpty()) {
									t=(Nodo)Cola.poll();
									if(t.valor==NodoObjetivo) {
										NodoEliminacion=t;
									}
									if(t.izq!=null)
										Cola.add(t.izq);
									if(t.der!=null)
										Cola.add(t.der);
								}
							}
							arbolbus.DelNodes(NodoEliminacion);
							break;
						case 4:
							System.out.println("\t\t\t\tBUSCAR");
							System.out.print("¿Qué nodo desea buscar? Por favor ingrese su valor (Por favor presione 2 veces enter después de ingresar el dato): ");
					        NodoBuscado=Scan.nextInt();
					        arbolbus.FindNodes(NodoBuscado);
							break;
						case 5:
							System.out.println("\t\tIMPRIMIR ÁRBOL (BFS)");
							arbolbus.breadthFrist();
							break;
						case 6:
							System.out.println("SALIDA DE TRABAJO CON ÁRBOLES BINARIOS DE BÚSQUEDA...");
							break;
						default:
							System.out.println("Opción no válida, por favor inténtelo de nuevo");
							break;	
						}
					}while(opc2!=6);
					break;
				case 3:
					System.out.println("\t\tTRABAJO CON ÁRBOL BINARIO B");
					
					break;
				case 4:
					System.out.println("\t\tCiao!");
					break;
				default:
					System.out.println("Opción no valida, inténtelo de nuevo");
			}
		}while(opc1!=4);
	}
}
