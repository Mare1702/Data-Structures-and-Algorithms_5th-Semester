package Actividad1;

import java.util.Scanner;

class main1 {

	public static void main(String[] args) {
		int opc, Vrtc,NdCnxn,Cst;
		int Nds[]=null;
		int NdsD[]=null;
		int NdsP[];
		Scanner Scan=new Scanner(System.in);
		
		System.out.println("\t\tEDA II - Práctica 6-7");
		System.out.println("\t\t  Menú de usuario");
		System.out.println("1. Generación de grafo no dirigido\t2. Generación de grafo dirigido"
				+ "\n3.Generación de grafo ponderado");
		System.out.print("Por favor seleccione una opción: ");
		opc=Scan.nextInt();
		switch(opc) {
		
			case 1:
				System.out.println("Generación de grafo no dirigido");
				System.out.print("Ingrese la cantidad de nodos que tendrá el grafo: ");
				Vrtc=Scan.nextInt();
				Nds=new int [Vrtc];
				Graph graph=new Graph(Vrtc);
				System.out.print("Ahora ");
				for(int i=0;i<Vrtc;i++) {
					System.out.println("ingrese la cantidad de aristas que salen del nodo "+i);
					Nds[i]=Scan.nextInt();
					for(int j=0;j<Nds[i];j++) {
						System.out.println("¿A qué nodo se dirigirá la arista "+j+" del nodo "+i+"?");
						NdCnxn=Scan.nextInt();
						graph.addEdge(i, NdCnxn);
					}
				}
				System.out.println("El grafo generado fue: ");
				graph.printGraph(graph);	
				System.out.println("\nINGRESO A DFS");
				graph.DFS(5);
			break;
			
			case 2:
				System.out.println("Generación de grafo dirigido");
				System.out.print("Ingrese la cantidad de nodos que tendrá el grafo: ");
				Vrtc=Scan.nextInt();
				NdsD=new int [Vrtc];
				DGraph dgraph=new DGraph(Vrtc);
				System.out.print("Ahora ");
				for(int i=0;i<Vrtc;i++) {
					System.out.println("ingrese la cantidad de aristas que salen del nodo "+i);
					NdsD[i]=Scan.nextInt();
					for(int j=0;j<NdsD[i];j++) {
						System.out.println("¿A qué nodo se dirigirá la arista "+j+" del nodo "+i+"?");
						NdCnxn=Scan.nextInt();
						dgraph.addEdge(i, NdCnxn);
					}
				}
				System.out.println("El grafo generado fue: ");
				dgraph.printGraph(dgraph);
				break;
			
			case 3:
				System.out.println("Generación de grafo ponderado");
				System.out.print("Ingrese la cantidad de nodos que tendrá el grafo: ");
				Vrtc=Scan.nextInt();
				NdsD=new int [Vrtc];
				PGraph pgraph=new PGraph(Vrtc);
				System.out.print("Ahora ");
				for(int i=0;i<Vrtc;i++) {
					System.out.println("ingrese la cantidad de aristas que salen del nodo "+i);
					NdsD[i]=Scan.nextInt();
					for(int j=0;j<NdsD[i];j++) {
						System.out.println("¿A qué nodo se dirigirá la arista "+j+" del nodo "+i+"?");
						NdCnxn=Scan.nextInt();
						System.out.println("¿Cuál será el costo de dicha arista?");
						Cst=Scan.nextInt();
						pgraph.addEdge(i, NdCnxn,Cst);
					}
				}
				System.out.println("El grafo generado fue: ");
				pgraph.printGraph(pgraph);
				break;
		}
		
	}
}
 


/*
 * int V =5;
		Graph graph=new Graph(V);
		graph.addEdge(0,1);
		graph.addEdge(0,4);
		graph.addEdge(1,2);
		graph.addEdge(1,3);
		graph.addEdge(1,4);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.printGraph(graph);
 * 
 */