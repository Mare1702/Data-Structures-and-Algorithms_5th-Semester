
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edgar
 */
public class ArbolBin {
    Nodo root;
    
    //public  ArbolBin(){}
    
    public ArbolBin(){
        root=null;
    }
    
    public ArbolBin(int val){
        root=new Nodo(val);
    }
    
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
        padre.setIzq(hijo);
	else
        padre.setDer(hijo);
	hijo.setPadre(padre);
    }
    
    protected void visit(Nodo n){
    	if(n.Existe==true)
        	System.out.println(n.valor+" ");
    }	
    
    public void breadthFrist(){
        Nodo r = root;
		Queue<Nodo> queue = new LinkedList();
		if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
				visit(r);
				if(r.izq!=null)
                    queue.add(r.izq);
				if(r.der!=null)
					queue.add(r.der);
            }
		}
    }
    public void RPreorden() {				
    	System.out.println("La notación Pre-orden del árbol será: ");
    	Nodo r=root;
    	IteraPreorden(r);
	}
    public void IteraPreorden(Nodo r) {
    Nodo Muestra;
		if(r!=null) {
			if(r.Existe==true)
				System.out.println(r.valor);
			IteraPreorden(r.izq);
			IteraPreorden(r.der);
		}
    }
    public void RInorden() {				
    	System.out.println("La notación In-orden del árbol será: ");
    	Nodo r=root;
    	IteraInorden(r);
	}
    public void IteraInorden(Nodo r) {
    Nodo Muestra;
		if(r!=null) {
			IteraInorden(r.izq);
			if(r.Existe==true)
				System.out.println(r.valor);
			IteraInorden(r.der);
		}
    }
    public void RPostorden() {				
    	System.out.println("La notación Post-orden del árbol será: ");
    	Nodo r=root;
    	IteraPostorden(r);
	}
    public void IteraPostorden(Nodo r) {
    Nodo Muestra;
		if(r!=null) {
			IteraPostorden(r.izq);
			IteraPostorden(r.der);
			if(r.Existe==true)
				System.out.println(r.valor);
		}
    }
    
    public void showNodes(Nodo padre) {
		if(padre.Existe==true) {
			System.out.println(padre.valor);
			if(padre.izq!=null)
				System.out.println(padre.izq.valor);
			if(padre.der!=null)
				System.out.println(padre.der.valor);
			if(padre.padre!=null)
				System.out.println(padre.padre.valor);
	    }
    }
    public void DelNodes(Nodo objetivo) {
    	Nodo SubArbolIzquierdo, SubArbolDerecho=null,Guardado,Reemplazo;
    	if(objetivo.izq==null&&objetivo.der==null)
    		objetivo.Existe=false;
    	else {
    		try {
	    		SubArbolIzquierdo=objetivo.izq;
	    		SubArbolDerecho=objetivo.izq;
	    		while(SubArbolIzquierdo.der!=null) {
	    			SubArbolDerecho=SubArbolIzquierdo.der;
	    			SubArbolIzquierdo=SubArbolIzquierdo.der;
	    		}
	    		objetivo.valor=SubArbolDerecho.valor;
	    		SubArbolDerecho.Existe=false;
    		}catch(Exception e) {
    			SubArbolDerecho=objetivo.der;
    			SubArbolIzquierdo=objetivo.der;
    			while(SubArbolDerecho.izq!=null) {
    				SubArbolIzquierdo=SubArbolDerecho.izq;
    				SubArbolDerecho=SubArbolDerecho.izq;
    			}
    			objetivo.valor=SubArbolIzquierdo.valor;
    			SubArbolIzquierdo.Existe=false;
    		}
    	}
    }
    public void FindNodes(int NodoBuscado) {    				//TO-DO: DEJAR DE ENCONTRAR NODOS YA ELIMINADOS
    	 Nodo q=root;
    	 boolean NodoEncontrado=false;
    	 Queue<Nodo>QFind=new LinkedList();
    	 if(q!=null) {
    		 QFind.add(q);
				while(!QFind.isEmpty()) {
					q=(Nodo)QFind.poll();
					if(q.valor==NodoBuscado) {
						NodoEncontrado=true;
					}
					if(q.izq!=null)
						QFind.add(q.izq);
					if(q.der!=null)
						QFind.add(q.der);
				}
			}
    	 if(NodoEncontrado==true)
    		 System.out.println("Si");
    	 else
    		 System.out.println("No");
    }   
}
