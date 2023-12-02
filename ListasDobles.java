package listasdobles;

public class ListasDobles{
	
    public static void main(String[] args){
        Lista lista = new Lista();
        lista.insertaPrimerNodo("R");
        lista.imprimir();
        lista.insertaPrimerNodo("F");
        lista.imprimir();
        System.out.println(lista);
        lista.insertaAntesPrimerNodo("H");
        System.out.println(lista);
        lista.insertaAlFinal("Z");
        System.out.println(lista);
        lista.insertaEntreNodos("T", "R");
        System.out.println(lista);
        lista.insertaAntesPrimerNodo("K");
        System.out.println(lista);
        lista.insertaAlFinal("Ñ");
        System.out.println(lista);
        lista.borrarPrimerNodo();
        System.out.println(lista);
        lista.borrarUltimoNodo();
        System.out.println(lista);
        lista.borrarCualquierNodo("R");
        System.out.println(lista);
//////////////////////////////////////////////////////////////////
// Uso de los nuevos métodos
        Node nodoEnPosicion2 = lista.buscarPorPosicion(2);
        System.out.println("Nodo en posición 2: " + nodoEnPosicion2.name);
        
//Insertar nodo antes del final
        lista.insertarAntesDelFinal("Nuevo");
        // Imprimir la lista después de insertar el nuevo nodo antes del nodo final
        lista.imprimir();
        
//Intercambiar un nodo por otro buscado.
        Node nodo1 =  lista.topBackward;
        Node nodo2 = lista.topForward;
        lista.intercambiarNodos(nodo1, nodo2);
        System.out.print("Intercambio de nodos:");
        // Imprimir la lista después del intercambio
        lista.imprimir();
    }
}