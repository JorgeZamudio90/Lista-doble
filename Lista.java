package listasdobles;

/**
 *
 * @author alexc
 */
public class Lista{
    Node topForward;
    Node topBackward;

    //Métodos para los casos de inserción de nodos
public boolean insertaPrimerNodo(String dato){
    if (topForward == null) { //La lista está vacía
        topForward = new Node();
        topForward.name = dato;
        topForward.previous = null;
        topForward.next = null;
        topBackward = topForward;
        return true;
    }else {
        return false;
    }
}

public void imprimir(){
    System.out.print("[X]"); 
    for (Node temp = this.topForward; temp != null; temp = temp.next){
        System.out.print(" <- [ " + temp.name + " ] -> ");
    }
    System.out.print("[X]\n"); 
}
	
public String toString(){
    String cadAux = "[X]";
    for (Node temp = this.topForward; temp != null; temp = temp.next){
        cadAux += " <- [ " + temp.name + " ] -> ";
    }
    cadAux += "[X]\n"; 
    return cadAux;
}

public void insertaAntesPrimerNodo(String nombre){
    Node temp; 
    temp = new Node ();
    temp.name = nombre;
    temp.next = this.topForward;
    this.topForward.previous = temp;
    this.topForward = temp;
    temp = null;
}

public void insertaAlFinal(String nombre){
    Node temp = new Node ();
    temp.name = nombre;
    temp.next = null;
    temp.previous = this.topBackward;
    this.topBackward.next = temp;
    this.topBackward = temp;
    temp = null;
}

public boolean insertaEntreNodos(String nombre, String buscado){
    Node temp = new Node();
    temp.name = nombre;
    Node temp2 = this.topForward;
    //boolean NodoNoEncontrado = true;
    while ( (temp2 != null) && temp2.name.equals(buscado) == false ) {	
        temp2 = temp2.next;
    }
    if (temp2 != null){  //Nodo buscado se encontró
        temp.next = temp2.next;
        temp2.next = temp;
        temp.previous = temp2;
        temp.next.previous = temp;
        temp = null;
        temp2 = null;
        return true;
    }else return false;
    } 
	
//Métodos de borrado
public void borrarPrimerNodo(){
    this.topForward = this.topForward.next;
    this.topForward.previous.next = null;
    this.topForward.previous = null;
}

public void borrarUltimoNodo(){
    this.topBackward = this.topBackward.previous;
    this.topBackward.next.previous = null;
    this.topBackward.next = null;
}

	
//Borrar cualquier nodo que no sea el primero
public boolean borrarCualquierNodo(String buscado){
    Node temp = this.topForward;

    while ( (temp != null) && temp.name.equals(buscado) == false ) {	
        temp = temp.next;
    }
    if (temp != null){  //Nodo buscado se encontró
        temp.next = temp.next.next;
        temp.next.previous.previous = null;
        temp.next.previous.next = null;
        temp.next.previous = temp;
        temp = null;
        return true;
    }else return false;
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Método para buscar un nodo por su posición
    public Node buscarPorPosicion(int posicion) {
        Node temp = this.topForward;
        int contador = 0;

        while (temp != null && contador < posicion) {
            temp = temp.next;
            contador++;
        }

        return temp;
    }
    
    // Método para insertar un nuevo nodo antes del nodo final
    public void insertarAntesDelFinal(String nombre) {
        Node nuevoNodo = new Node();
        nuevoNodo.name = nombre;
        nuevoNodo.next = null;

        if (topForward == null) {
            // La lista está vacía, el nuevo nodo será el primer y último nodo
            nuevoNodo.previous = null;
            topForward = nuevoNodo;
            topBackward = nuevoNodo;
        } else {
            // La lista no está vacía, agregamos el nuevo nodo antes del nodo final
            nuevoNodo.previous = topBackward;
            topBackward.next = nuevoNodo;
            topBackward = nuevoNodo;
        }
    }

// Método para intercambiar dos nodos
    public void intercambiarNodos(Node nodo1, Node nodo2) {
        // Verificar si los nodos son nulos o iguales
        if (nodo1 == null || nodo2 == null || nodo1 == nodo2) {
            System.out.println("Los nodos son nulos o iguales. No se puede realizar el intercambio.");
            return;
        }

        // Intercambiar nodos
        Node tempPrevious1 = nodo1.previous;
        Node tempNext1 = nodo1.next;

        nodo1.previous = nodo2.previous;
        nodo1.next = nodo2.next;

        nodo2.previous = tempPrevious1;
        nodo2.next = tempNext1;

        // Actualizar enlaces de nodos adyacentes
        if (nodo1.previous != null) {
            nodo1.previous.next = nodo1;
        } else {
            topForward = nodo1; // Actualizar el puntero al primer nodo si es necesario
        }

        if (nodo1.next != null) {
            nodo1.next.previous = nodo1;
        }

        if (nodo2.previous != null) {
            nodo2.previous.next = nodo2;
        } else {
            topForward = nodo2; // Actualizar el puntero al primer nodo si es necesario
        }

        if (nodo2.next != null) {
            nodo2.next.previous = nodo2;
        }
    }

}