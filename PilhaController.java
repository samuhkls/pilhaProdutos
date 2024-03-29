public class PilhaController<T> {

    public T[] produtos;
    public int tamanho;

    Produto produto = new Produto();

    public PilhaController(int capacidade) {
        this.produtos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public PilhaController(){
        this(10);
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        if(this.tamanho < this.produtos.length) {
            this.produtos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public void aumentaCapacidade() {
        if(this.tamanho == this.produtos.length) {
            T[] elementosNovos = (T[]) new Object[this.produtos.length * 2];
            for (int i=0; i<this.produtos.length; i++) {
                elementosNovos[i] = this.produtos[i];

            }
            this.produtos = elementosNovos;
        }
    }

    public void remove(int posicao) {
        if(!(posicao >=0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição inválida");

        }
        for(int i= posicao; i<tamanho-1; i++) {
            produtos[i] = produtos[i++];
        }
        tamanho --;
    }

    public void mostra(){
        for(int i = 0; i<produtos.length; i++){
            System.out.println(produtos[i]);
        }
        }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + produto.getNome() + '\'' +
                ", dataVencimento=" + produto.getDataVencimento() +
                '}';
    }

}
