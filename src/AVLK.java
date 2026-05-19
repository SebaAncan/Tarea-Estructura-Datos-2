class AVLK{
    private NodoAVLK raiz;
    AVLK(){ raiz = null;}

    public void insertar(int clave) {
        raiz = insertarAux(raiz, clave);
    }



    public boolean buscar(int k) { return buscarRec(raiz, k); }

    private boolean buscarRec(NodoAVLK nodo, int k){
        if(nodo == null) return false;

        if(k == nodo.clave) return true;

        if(k < nodo.clave){
            return buscarRec(nodo.lchild, k);
        } else {
            return buscarRec(nodo.rchild, k);
        }
    }

    public int i_esimo(int i){
        return i_esimoAux(raiz, i);
    }

    private int i_esimoAux(NodoAVLK nodo, int i){
        if (nodo == null){
            System.out.println("Fuera de rango");
            return -1;
        }
        int pesoIzq = getPeso(nodo.lchild);
        if (i == pesoIzq + 1){
            return nodo.clave;
        }else if (i <= pesoIzq){
            return i_esimoAux(nodo.lchild , i);
        } else {
            return i_esimoAux(nodo.rchild, i);
        }
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
        updateNodo(nodo);

        int balan = getBalance(nodo);

        //Caso Izq-Izq
        if(balan > 1 && clave < nodo.lchild.clave) return rotoDerecha(nodo);

        //Caso Der-Der
        if(balan < -1 && clave > nodo.rchild.clave) return rotoIzq(nodo);

        //Caso Izq-Der
        if(balan > 1 && clave > nodo.lchild.clave){
            nodo.rchild = rotoDerecha(nodo.lchild) ;
            return rotoDerecha(nodo);
        }

        //Caso Der-Izq
        if(balan < -1 && clave < nodo.rchild.clave){
            nodo.rchild = rotoDerecha(nodo.rchild);
            return rotoIzq(nodo);
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

    private NodoAVLK rotoDerecha(NodoAVLK nodo){
        //implementado a partir de lo visto en clases
        NodoAVLK temp = nodo.lchild;
        nodo.lchild = temp.rchild;
        temp.rchild = nodo;

        updateNodo(nodo);
        updateNodo(temp);

        return temp;
    }

    private NodoAVLK rotoIzq(NodoAVLK nodo){
        //implementado a partir de lo visto en clases
        NodoAVLK temp = nodo.rchild;
        nodo.rchild = temp.lchild;
        temp.lchild = nodo;

        updateNodo(nodo);
        updateNodo(temp);

        return temp;
    }
}
