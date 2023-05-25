public class Exercicio5 {
    public class ListaEncadeadaCircularComNoCabeca {
        private Celula cabeca;
        private int totalDeElementos;
    
        public ListaEncadeadaCircularComNoCabeca() {
            cabeca = new Celula(null);
            cabeca.setProxima(cabeca);
            cabeca.setAnterior(cabeca);
            totalDeElementos = 0;
        }
    
        public boolean vazia() {
            return totalDeElementos == 0;
        }
    
        public int contarElementos() {
            return totalDeElementos;
        }
    
        public void inserir(Object elemento) {
            Celula nova = new Celula(elemento);
    
            if (vazia()) {
                cabeca.setProxima(nova);
                cabeca.setAnterior(nova);
                nova.setProxima(cabeca);
                nova.setAnterior(cabeca);
            } else {
                Celula ultima = cabeca.getAnterior();
                nova.setProxima(cabeca);
                nova.setAnterior(ultima);
                ultima.setProxima(nova);
                cabeca.setAnterior(nova);
            }
    
            totalDeElementos++;
        }
    
        public void remover(Object elemento) {
            if (vazia()) {
                return;
            }
    
            Celula atual = cabeca.getProxima();
    
            while (atual != cabeca) {
                if (atual.getElemento().equals(elemento)) {
                    Celula anterior = atual.getAnterior();
                    Celula proxima = atual.getProxima();
                    anterior.setProxima(proxima);
                    proxima.setAnterior(anterior);
                    atual.setProxima(null);
                    atual.setAnterior(null);
                    totalDeElementos--;
                    return;
                }
    
                atual = atual.getProxima();
            }
        }
    
        public void imprimir() {
            if (vazia()) {
                System.out.println("Lista vazia");
                return;
            }
    
            Celula atual = cabeca.getProxima();
    
            while (atual != cabeca) {
                System.out.print(atual.getElemento() + " ");
                atual = atual.getProxima();
            }
    
            System.out.println();
        }
    
        private class Celula {
            private Object elemento;
            private Celula anterior;
            private Celula proxima;
    
            public Celula(Object elemento) {
                this.elemento = elemento;
            }
    
            public Object getElemento() {
                return elemento;
            }
    
            public Celula getAnterior() {
                return anterior;
            }
    
            public void setAnterior(Celula anterior) {
                this.anterior = anterior;
            }
    
            public Celula getProxima() {
                return proxima;
            }
    
            public void setProxima(Celula proxima) {
                this.proxima = proxima;
            }
        }
    }
}
