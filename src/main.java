import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner tcld = new Scanner(System.in);
        AVLK arbol = new AVLK();
        int opcion = 0;
        int clave = 0;
        while (true){
            System.out.println("Menu");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Imprimir Arbol");
            System.out.println("4. Buscar");
            System.out.println("5. i-esimo menor");
            System.out.println("6. Datos de prueba");
            System.out.println("7. Salir");
            opcion = tcld.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("inserte clave");
                    clave = tcld.nextInt();
                    arbol.insertar(clave);
                    System.out.println("clave " + clave + " insertada");
                    break;
                case 2:
                    System.out.println("inserte clave");
                    clave = tcld.nextInt();
                    if (arbol.buscar(clave)){
                        arbol.eliminar(clave);
                        System.out.println("Clave " + clave + " eliminada");
                    }else {
                        System.out.println("clave no existe");
                    }
                    break;
                case 3:
                    imprimirArbol(arbol);
                    break;
                case 4:
                    System.out.println("inserte clave a buscar");
                    clave = tcld.nextInt();
                    boolean encontrado = arbol.buscar(clave);
                    if (encontrado){
                        System.out.println("Encontrado!");
                    }else {
                        System.out.println("no existe");
                    }
                    break;
                case 5:
                    System.out.println("inserte la posicion i");
                    int i = tcld.nextInt();
                    int res = arbol.i_esimo(i);
                    System.out.println("El " + i + " ésimo menor elemento es: " + res);
                    break;
                case 6:
                    System.out.println("Cargando elementos");
                    System.out.println("Elementos a insertar: 8,6,10,2,3,4,7,20,17");
                    arbol = new AVLK(); //Reseteamos por que el programa se intento suicidar si lo ejecutaba dos veces
                    arbol.insertar(8);
                    arbol.insertar(6);
                    arbol.insertar(10);
                    arbol.insertar(3);
                    arbol.insertar(4);
                    arbol.insertar(7);
                    arbol.insertar(20);
                    arbol.insertar(17);
                    System.out.println("arbol precargado");
                    imprimirArbol(arbol);
                    break;
                case 7:
                    System.out.println("Bye Bye :D");
                    tcld.close();
                    return;

                default:
                    System.out.println("Opcion Invalida");
                    break;
            }
        }

    }

    //movi el imprimir mejor a aVLK

    public static void imprimirArbol(AVLK arbol) {
        System.out.println("Imprimiendo Arbol:");
        if (arbol.getTam() == 0){
            System.out.println("Esta vacio");
            return;
        }
        arbol.imprimirDetalle();
        /*int total = arbol.getTam();
        for (int i = 1 ; i<=total;i++){
            System.out.println(arbol.i_esimo(i) + " ");
        }
        se me ocurrio mejorarlo por que se imprimia feo
         */
        /*
        taba malo gerardo
        int contador =1;
        int clave = arbol.i_esimo(contador);
        while(clave != -1){
            System.out.println(clave + " ");
            contador++;
            clave = arbol.i_esimo(contador);
        }

         */
    }
}

