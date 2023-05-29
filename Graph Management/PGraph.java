package Actividad1;


import java.util.*;

class PGraph extends Graph{
	LinkedList<Integer> Costo[];
	PGraph(int v){
		V=v;
		adjArray=new LinkedList[v];
		Costo=new LinkedList[v];
		
		for(int i=0;i<v;++i) {
			adjArray[i]=new LinkedList();
			Costo[i]=new LinkedList();
		}
	}
	void addEdge(int v,int w,int y) {
		adjArray[v].add(w);
		Costo[v].add(y);
	}
	void printGraph(Graph graph) {
			for(int v=0;v<graph.V;v++) {
				System.out.println("Lista de Adyacencia del vertice "+v);
				System.out.println(v);
				for(Integer node: graph.adjArray[v]) {
					System.out.println(" -> "+node);
				}
			}
			System.out.println("Los costos de cada arista serán: ");
			for(int j=0;j<graph.V;j++) {
				System.out.println(" -> "+Costo[j]);
			}
			System.out.println("Respectivamente");
			System.out.println("\n");
		}
	}
