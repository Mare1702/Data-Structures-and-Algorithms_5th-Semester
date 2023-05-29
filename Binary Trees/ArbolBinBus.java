
public class ArbolBinBus extends ArbolBin {
	public ArbolBinBus(int val){
		super(val);
	}
	public ArbolBinBus(Nodo root) {
		super(root);
	}
	 public void add(Nodo padre, Nodo hijo){
		 while(padre.izq!=null&&padre.der!=null) {
			if(padre.valor<hijo.valor) {
		        while(padre.der!=null) {
		        	padre=padre.der;
		        	add(padre,hijo);
		        }
	        	padre.setDer(hijo);
			}
			else {
				while(padre.izq!=null) {
					padre=padre.izq;
					add(padre,hijo);
				}
		        padre.setIzq(hijo);
		        //hijo.setPadre(padre);
			}
		 }
 	}
}
