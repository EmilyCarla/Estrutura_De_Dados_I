public class Exercicio2 {
    public class ListaDupla {
        private Celula cabeca;
        private int totalDeElementos;
    
        public ListaDupla() {
            this.cabeca = new Celula(null);
            this.totalDeElementos = 0;
            this.cabeca.setProxima(this.cabeca);
            this.cabeca.setAnterior(this.cabeca);
        }
    
        public boolean vazia() {
            return totalDeElementos == 0;
        }
    
        public int tamanho() {
            return totalDeElementos;
        }
    
        public void inserirInicio(Object elemento) {
            Celula novaCelula = new Celula(elemento);
            Celula primeiraCelula = cabeca.getProxima();
    
            novaCelula.setAnterior(cabeca);
            novaCelula.setProxima(primeiraCelula);
    
            cabeca.setProxima(novaCelula);
            primeiraCelula.setAnterior(novaCelula);
    
            totalDeElementos++;
        }
    
        public void inserirFim(Object elemento) {
            if (vazia()) {
                inserirInicio(elemento);
            } else {
                Celula novaCelula = new Celula(elemento);
                Celula ultimaCelula = cabeca.getAnterior();
    
                novaCelula.setAnterior(ultimaCelula);
                novaCelula.setProxima(cabeca);
    
                ultimaCelula.setProxima(novaCelula);
                cabeca.setAnterior(novaCelula);
    
                totalDeElementos++;
            }
        }
    
        public Object buscar(int posicao) {
            if (posicao >= 0 && posicao < totalDeElementos) {
                Celula celulaAtual = cabeca.getProxima();
                for (int i = 0; i < posicao; i++) {
                    celulaAtual = celulaAtual.getProxima();
                }
                return celulaAtual.getElemento();
            }
            throw new IllegalArgumentException("Posição inválida");
        }
    
        public void remover(int posicao) {
            if (posicao >= 0 && posicao < totalDeElementos) {
                Celula celulaAtual = cabeca.getProxima();
                for (int i = 0; i < posicao; i++) {
                    celulaAtual = celulaAtual.getProxima();
                }
    
                Celula celulaAnterior = celulaAtual.getAnterior();
                Celula celulaProxima = celulaAtual.getProxima();
    
                celulaAnterior.setProxima(celulaProxima);
                celulaProxima.setAnterior(celulaAnterior);
    
                totalDeElementos--;
            } else {
                throw new IllegalArgumentException("Posição inválida");
            }
        }
    }
}
