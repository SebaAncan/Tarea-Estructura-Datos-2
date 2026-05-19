public class AVLK {
    private NodoAVLK raiz;

    public AVLK() { raiz = null; }

    public void insertar(int clave) { raiz = insertarRec(raiz, clave); }

    private NodoAVLK insertarRec(NodoAVLK nodo, int clave) {
        if (nodo == null) {
            return new NodoAVLK(clave);
        }
        if (clave < nodo.clave) {
            nodo.lchild = insertarRec(nodo.lchild, clave);
        } else if (clave > nodo.clave) {
            nodo.rchild = insertarRec(nodo.rchild, clave);
        } else {
            return nodo;
        }

        updateNodo(nodo);
        int balance = getBalance(nodo);

        // Caso Izq Izq
        if (balance > 1 && clave < nodo.lchild.clave) return rotoDerecha(nodo);

        // Caso Der Der
        if (balance < -1 && clave > nodo.rchild.clave) return rotoIzq(nodo);

        // Caso Izq Der
        if (balance > 1 && clave > nodo.lchild.clave) {
            nodo.lchild = rotoIzq(nodo.lchild);
            return rotoDerecha(nodo);
        }

        // Caso Der Izq
        if (balance < -1 && clave < nodo.rchild.clave) {
            nodo.rchild = rotoDerecha(nodo.rchild);
            return rotoIzq(nodo);
        }

        return nodo;
    }

    public void eliminar(int clave) { raiz = eliminarRec(raiz, clave); }

    private NodoAVLK eliminarRec(NodoAVLK nodo, int clave) {
        if (nodo == null) return null;

        if (clave < nodo.clave) {
            nodo.lchild = eliminarRec(nodo.lchild, clave);
        } else if (clave > nodo.clave) {
            nodo.rchild = eliminarRec(nodo.rchild, clave);
        } else {
            // Nodo encontrado
            if (nodo.lchild == null || nodo.rchild == null) {
                // Caso 0 o 1 hijo
                NodoAVLK temp = (nodo.lchild != null) ? nodo.lchild : nodo.rchild;

                if (temp == null) {
                    return null; // Si era hoja, se desconecta
                } else {
                    nodo = temp; // Si tenía un hijo, toma su lugar y se balancea
                }
            } else {
                // Caso 2 hijos
                NodoAVLK temp = buscaMayorIzq(nodo.lchild);
                nodo.clave = temp.clave;
                nodo.lchild = eliminarRec(nodo.lchild, temp.clave);
            }
        }

        if (nodo == null) return null;

        updateNodo(nodo);
        int balance = getBalance(nodo);

        if (balance > 1 && getBalance(nodo.lchild) >= 0) return rotoDerecha(nodo);

        if (balance > 1 && getBalance(nodo.lchild) < 0) {
            nodo.lchild = rotoIzq(nodo.lchild);
            return rotoDerecha(nodo);
        }
        if (balance < -1 && getBalance(nodo.rchild) <= 0) return rotoIzq(nodo);

        if (balance < -1 && getBalance(nodo.rchild) > 0) {
            nodo.rchild = rotoDerecha(nodo.rchild);
            return rotoIzq(nodo);
        }
        return nodo;
    }

    public boolean buscar(int k) { return buscarRec(raiz, k); }

    private boolean buscarRec(NodoAVLK nodo, int k) {
        if (nodo == null) return false;
        if (k == nodo.clave) return true;

        if (k < nodo.clave) {
            return buscarRec(nodo.lchild, k);
        } else {
            return buscarRec(nodo.rchild, k);
        }
    }

    public int i_esimo(int i) {
        return i_esimoRec(raiz, i);
    }

    private int i_esimoRec(NodoAVLK nodo, int i) {
        if (nodo == null) {
            System.out.println("Fuera de rango");
            return -1;
        }
        int pesoIzq = getPeso(nodo.lchild);
        if (i == pesoIzq + 1) {
            return nodo.clave;
        } else if (i <= pesoIzq) {
            return i_esimoRec(nodo.lchild, i);
        } else {
            return i_esimoRec(nodo.rchild, i - (pesoIzq + 1));
        }
    }

    // Métodos auxiliares
    private int getAltura(NodoAVLK nodo) {

        if (nodo == null){
            return 0;
        }
        return nodo.altura;
    }

    private int getPeso(NodoAVLK nodo) {
        if (nodo == null){
            return 0;
        }
        return nodo.peso;
    }

    private void updateNodo(NodoAVLK nodo) {
        if (nodo != null) {
            nodo.altura = Math.max(getAltura(nodo.lchild), getAltura(nodo.rchild)) + 1;
            nodo.peso = getPeso(nodo.lchild) + getPeso(nodo.rchild) + 1;
            nodo.balan = (short) (getAltura(nodo.lchild) - getAltura(nodo.rchild));
        }
    }

    private int getBalance(NodoAVLK nodo) {
        if (nodo == null){
            return 0;
        }
        return (getAltura(nodo.lchild) - getAltura(raiz.rchild));

    }

    private NodoAVLK buscaMayorIzq(NodoAVLK nodo) {
        if (nodo.rchild == null) return nodo;
        return buscaMayorIzq(nodo.rchild);
    }

    private NodoAVLK rotoDerecha(NodoAVLK nodo) {
        NodoAVLK temp = nodo.lchild;
        nodo.lchild = temp.rchild;
        temp.rchild = nodo;

        updateNodo(nodo);
        updateNodo(temp);

        return temp;
    }

    private NodoAVLK rotoIzq(NodoAVLK nodo) {
        NodoAVLK temp = nodo.rchild;
        nodo.rchild = temp.lchild;
        temp.lchild = nodo;

        updateNodo(nodo);
        updateNodo(temp);

        return temp;
    }

    public int getTam() {
        if (raiz== null){
            return 0;
        }
        return raiz.peso;
    }
}