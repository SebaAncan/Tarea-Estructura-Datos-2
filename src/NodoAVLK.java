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
}
