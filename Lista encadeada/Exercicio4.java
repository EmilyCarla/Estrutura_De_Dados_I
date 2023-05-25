public class Exercicio4 {
    public class ListaCircularDuplamenteEncadeada {
        private Celula cabeca;
        private int totalDeElementos;
    
        public ListaCircularDuplamenteEncadeada() {
            this.cabeca = null;
            this.totalDeElementos = 0;
        }
    
        public boolean vazia() {
            return totalDeElementos == 0;
        }
    
        public int contarElementos() {
            return totalDeElementos;
        }
    
        public void inserirEsquerda(Object elemento) {
            Celula novaCelula = new Celula(elemento);
            if (vazia()) {
                cabeca = novaCelula;
                novaCelula.setProxima(novaCelula);
                novaCelula.setAnterior(novaCelula);
            } else {
                novaCelula.setProxima(cabeca);
                novaCelula.setAnterior(cabeca.getAnterior());
                cabeca.getAnterior().setProxima(novaCelula);
                cabeca.setAnterior(novaCelula);
                cabeca = novaCelula;
            }
            totalDeElementos++;
        }
    
        public void concatenar(ListaCircularDuplamenteEncadeada lista) {
            if (lista.vazia()) {
                return;
            }
            if (vazia()) {
                cabeca = lista.cabeca;
            } else {
                Celula ultimaCelula = cabeca.getAnterior();
                Celula primeiraCelulaLista = lista.cabeca;
                Celula ultimaCelulaLista = lista.cabeca.getAnterior();
    
                ultimaCelula.setProxima(primeiraCelulaLista);
                primeiraCelulaLista.setAnterior(ultimaCelula);
    
                ultimaCelulaLista.setProxima(cabeca);
                cabeca.setAnterior(ultimaCelulaLista);
            }
            totalDeElementos += lista.totalDeElementos;
            lista.cabeca = null;
            lista.totalDeElementos = 0;
        }
    
        public void intercalar(ListaCircularDuplamenteEncadeada lista) {
            if (vazia()) {
                cabeca = lista.cabeca;
            } else {
                Celula ultimaCelula = cabeca.getAnterior();
                Celula primeiraCelulaLista = lista.cabeca;
    
                ultimaCelula.setProxima(primeiraCelulaLista);
                primeiraCelulaLista.setAnterior(ultimaCelula);
    
                lista.cabeca.getAnterior().setProxima(cabeca);
                cabeca.setAnterior(lista.cabeca.getAnterior());
            }
            totalDeElementos += lista.totalDeElementos;
            lista.totalDeElementos = 0;
            lista.cabeca = null;
        }
    
        public ListaCircularDuplamenteEncadeada copiar() {
            ListaCircularDuplamenteEncadeada copia = new ListaCircularDuplamenteEncadeada();
            if (vazia()) {
                return copia;
            }
            Celula celulaAtual = cabeca;
            do {
                copia.inserirEsquerda(celulaAtual.getElemento());
                celulaAtual = celulaAtual.getProxima();
            } while (celulaAtual != cabeca);
            return copia;
        }
    }
}
