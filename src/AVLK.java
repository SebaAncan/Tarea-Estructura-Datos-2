class AVLK{
    private NodoAVLK raiz;
    AVLK(){ raiz = null;}

    public void insertar(int clave) {
        raiz = insertarAux(raiz, clave);
    }
    public void eliminar(int clave){

    }

    public boolean buscar(int k){
        return false;
    }

    public int i_esimo(int i){
        return 0;
    }


    private NodoAVLK insertarAux(NodoAVLK nodo,int clave){
        if (nodo == null){
            return new NodoAVLK(clave);
        }
        if (clave < nodo.clave) {
            nodo.lchild = insertarAux(nodo.lchild, clave);
        } else if (clave > nodo.clave) {
            nodo.rchild = insertarAux(nodo.rchild, clave);
        } else {
            return nodo;
        }
        return nodo;
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
    private NodoAVLK rotoDerecha(NodoAVLK nodo){
        return null;
    }

    private NodoAVLK rotoIzq(NodoAVLK nodo){
        return null;
    }
}
