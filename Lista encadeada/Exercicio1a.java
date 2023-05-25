public class Exercicio1a{
    public static void main(String[] args) {
        
        ListaDupla lista1 = new ListaDupla();
        //Adicionar elementos.Ex:
        lista1.Adiciona(1);
        lista1.Adiciona(2);
        lista1.Adiciona(3);

        ListaDupla lista2 = new ListaDupla();
        //Adicionar elementos.Ex:
        lista2.Adiciona(4);
        lista2.Adiciona(5);
        lista2.Adiciona(6);

        System.out.println("Lista 1: " + lista1.imprimir()); 
        System.out.println("Lista 2: " + lista2.imprimir()); 

        // Concatenando lista2 à lista1
        for (int i = 0; i < lista2.tamanho(); i++) {
            Object elemento = lista2.Pega(i);
            lista1.Adiciona(elemento);
        }

        System.out.println("Lista concatenada: " + lista1.imprimir()); 
    }
}