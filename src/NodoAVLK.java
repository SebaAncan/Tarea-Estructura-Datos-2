public class NodoAVLK {
    //Me base en el codigo que nos dieron en el test 2
    int clave;
    int peso;
    int altura;
    NodoAVLK lchild;
    short balan;
    NodoAVLK rchild;
    NodoAVLK(int clave){
        this.clave = clave;
        this.peso = 1;   // peso 1 para las hojas recien creadas
        this.altura = 1; // Altura inicial
        this.lchild = null;
        this.rchild = null;
    }

    private int getAltura(NodoAVLK nodo){
        if (nodo == null){
            return 0;
        }else{
            return nodo.altura;
        }
    }
    private int getPeso(NodoAVLK nodo){
        if (nodo == null){
            return 0;
        }else {
            return nodo.peso;
        }
    }

    private void updateNodo(NodoAVLK nodo){
        if (nodo!=null){
            nodo.altura = Math.max(getAltura(nodo.lchild),getAltura(nodo.rchild)) + 1;
            nodo.peso = getPeso(nodo.lchild) + getPeso(nodo.rchild) + 1;
        }
    }

    private int getBalance(NodoAVLK nodo){
        if (nodo == null){
            return 0;
        }else {
            return (getAltura(nodo.lchild) - getAltura(nodo.rchild));
        }
    }
     //AGregar funciones de rotar
}
