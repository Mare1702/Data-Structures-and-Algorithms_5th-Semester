package Actividad1;

import java.util.LinkedList;

class DGraph extends Graph{
	
	DGraph(int v){
		super(v);
	}
	void addEdge(int v,int w) {
		adjArray[v].add(w);
	}
}
