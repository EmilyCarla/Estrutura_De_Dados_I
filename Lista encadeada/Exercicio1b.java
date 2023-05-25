public class Exercicio1b {
    public static void main(String[] args) {
        ListaDupla listaOriginal = new ListaDupla();
        //Adicionar elementos.Ex:
        listaOriginal.Adiciona(1);
        listaOriginal.Adiciona(2);
        listaOriginal.Adiciona(3);
        listaOriginal.Adiciona(4);
        listaOriginal.Adiciona(5);
    
        System.out.println("Lista original: " + listaOriginal.imprimir()); 
    
        // Separando a lista em duas novas listas
        ListaDupla lista1 = new ListaDupla();
        ListaDupla lista2 = new ListaDupla();
    
        for (int i = 0; i < listaOriginal.tamanho(); i++) {
            Object elemento = listaOriginal.Pega(i);
            if (i % 2 == 0) {
                lista1.Adiciona(elemento);
            } else {
                lista2.Adiciona(elemento);
            }
        }
    
        System.out.println("Lista 1: " + lista1.imprimir()); 
        System.out.println("Lista 2: " + lista2.imprimir()); 
    }
}

