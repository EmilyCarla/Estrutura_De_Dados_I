public class Exercicio3abcde {
    public class ListaEncadeadaCircular {
        private Celula cabeca;
        private int totalDeElementos;
    
        public ListaEncadeadaCircular() {
            this.cabeca = null;
            this.totalDeElementos = 0;
        }
    
        public boolean vazia() {
            return totalDeElementos == 0;
        }
    
        //a)
        public int contarElementos() {
            return totalDeElementos;
        }
    

        //b)
        public void inserirEsquerda(Object elemento) {
            Celula novaCelula = new Celula(elemento);
            if (vazia()) {
                cabeca = novaCelula;
                novaCelula.setProxima(novaCelula);
            } else {
                novaCelula.setProxima(cabeca);
                Celula ultimaCelula = cabeca;
                while (ultimaCelula.getProxima() != cabeca) {
                    ultimaCelula = ultimaCelula.getProxima();
                }
                ultimaCelula.setProxima(novaCelula);
                cabeca = novaCelula;
            }
            totalDeElementos++;
        }
    

        //c)
        public void concatenar(ListaEncadeadaCircular lista) {
            if (lista.vazia()) {
                return;
            }
            if (vazia()) {
                cabeca = lista.cabeca;
            } else {
                Celula ultimaCelula = cabeca;
                while (ultimaCelula.getProxima() != cabeca) {
                    ultimaCelula = ultimaCelula.getProxima();
                }
                ultimaCelula.setProxima(lista.cabeca);
            }
            totalDeElementos += lista.totalDeElementos;
            lista.cabeca = null;
            lista.totalDeElementos = 0;
        }
    

        //d)
        public void intercalar(ListaEncadeadaCircular lista) {
            if (vazia()) {
                cabeca = lista.cabeca;
            } else {
                Celula ultimaCelula = cabeca;
                while (ultimaCelula.getProxima() != cabeca) {
                    ultimaCelula = ultimaCelula.getProxima();
                }
                ultimaCelula.setProxima(lista.cabeca);
                lista.cabeca.setAnterior(ultimaCelula);
                lista.cabeca = null;
            }
            totalDeElementos += lista.totalDeElementos;
            lista.totalDeElementos = 0;
        }
    


        //e)
        public ListaEncadeadaCircular copiar() {
            ListaEncadeadaCircular copia = new ListaEncadeadaCircular();
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
