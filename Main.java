public class Main {
    public static void main(String[] args) {

        GerarNumeros.gerador("entrada.txt", 200); // roda isso aqui primeiro
        OrdenacaoExterna.gerarBlocosOrdenados("entrada.txt"); //depois isso
        OrdenacaoExterna.intercalarBlocos(); // e por último isso aqui para intercalar a ordenação
    }
}