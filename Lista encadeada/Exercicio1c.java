public class Exercicio1c {
    void intercalarListasOrdenadas(ListaDupla lista1, ListaDupla lista2) {
        ListaDupla intercalada = new ListaDupla();
    
        Celula atual1 = lista1.Primeira;
        Celula atual2 = lista2.Primeira;
    
        while (atual1 != null && atual2 != null) {
            Comparable elemento1 = (Comparable) atual1.getElemento(); //Comparable= éuma interface de comparação 
            Comparable elemento2 = (Comparable) atual2.getElemento();
    
            if (elemento1.compareTo(elemento2) <= 0) { //compareTo= método de comparação criado pela interface Comparable/compara o objeto atual com o objeto passado como parametro
                intercalada.Adiciona(elemento1);
                atual1 = atual1.getProxima();
            } else {
                intercalada.Adiciona(elemento2);
                atual2 = atual2.getProxima();
            }
        }
    
        while (atual1 != null) {
            intercalada.Adiciona(atual1.getElemento());
            atual1 = atual1.getProxima();
        }
    
        while (atual2 != null) {
            intercalada.Adiciona(atual2.getElemento());
            atual2 = atual2.getProxima();
        }
    
        System.out.println("Lista intercalada: " + intercalada.imprimir());
    } 
}
