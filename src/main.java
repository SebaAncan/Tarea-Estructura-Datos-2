
public class main {
    public static void main(String[] args){
        AVLK arbol = new AVLK();

        System.out.println("Método Insertar");
        //claves del 2 al 10 sin ordenar
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(6);
        arbol.insertar(8);
        arbol.insertar(10);

        arbol.insertar(3);
        arbol.insertar(5);
        arbol.insertar(7);
        arbol.insertar(9);

        System.out.println("\nÁrbol: ");
        imprimirArbol(arbol);

        /// ///////////////////////////////////////////////////////////
        System.out.println("Método Buscar: ");
        System.out.println("¿Existe la clave 2? " + arbol.buscar(2));
        System.out.println("¿Existe la clave 11? " + arbol.buscar(11));

        /// ///////////////////////////////////////////////////////////
        System.out.println("\nMétodo i-ésimo menor: ");
        System.out.println("1er menor: " + arbol.i_esimo(1));
        System.out.println("5to menor: " + arbol.i_esimo(5));

        System.out.println("11avo menor: " + arbol.i_esimo(11));

        /// ///////////////////////////////////////////////////////////
        System.out.println("Método rotación");
        //al insertar el 1, esto desbalancea el arbol
        System.out.println("Insertar 1");
        arbol.insertar(1);

        System.out.println("Árbol: ");
        imprimirArbol(arbol);

        System.out.println("i-esimo después de la rotación");

        System.out.println("1ero menor: " + arbol.i_esimo(1));
        System.out.println("5to menor: " + arbol.i_esimo(5));

    }

    public static void imprimirArbol(AVLK arbol) {
        int contador =1;
        while(true){
            int clave = arbol.i_esimo(contador);
            if(clave == -1) break;

            System.out.println(clave);
            contador++;
        }
        System.out.println();
    }
}

