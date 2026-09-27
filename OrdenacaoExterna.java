import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OrdenacaoExterna {

    public static void gerarBlocosOrdenados(String caminho) {
        String linha;
        int tamanhoBloco = 50;
        int[] bloco = new int[tamanhoBloco];
        int indice = 0;
        int valorBloco = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            while ((linha = br.readLine()) != null) {
                bloco[indice] = Integer.parseInt(linha);
                indice++;

                if (indice == tamanhoBloco) {
                    valorBloco++;
                    MergeSort.mergeSort(bloco);

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("bloco " + valorBloco))) {
                        for (int numero : bloco) {
                            bw.write(Integer.toString(numero));
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException();
                    }
                    indice = 0;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void intercalarBlocos() {
        int quantidadeBlocos = 4;
        BufferedReader[] arquivos = new BufferedReader[quantidadeBlocos];

        int[] valoresAtuais = new int[quantidadeBlocos];
        boolean[] blocosEsgotados = new boolean[quantidadeBlocos];

        try {
            for (int i = 0; i < quantidadeBlocos; i++) {
                int numeroBlocos = 1 + i;
                arquivos[i] = new BufferedReader(new FileReader("bloco " + numeroBlocos));

                
                String linha = arquivos[i].readLine();
                if (linha != null) {
                    valoresAtuais[i] = Integer.parseInt(linha);
                    blocosEsgotados[i] = false;
                } else {
                    blocosEsgotados[i] = true; 
                }
            }

            try (BufferedWriter bwFinal = new BufferedWriter(new FileWriter("saida_final.txt"))) {

                while (true) {
                    int menorValor = Integer.MAX_VALUE;
                    int indiceMenor = -1;

                    for (int i = 0; i < quantidadeBlocos; i++) {
                        if (!blocosEsgotados[i] && valoresAtuais[i] < menorValor) {
                            menorValor = valoresAtuais[i];
                            indiceMenor = i;
                        }
                    }

                    
                    if (indiceMenor == -1) {
                        break; 
                    }

                    bwFinal.write(Integer.toString(menorValor));
                    bwFinal.newLine();

                    String proximaLinha = arquivos[indiceMenor].readLine();
                    if (proximaLinha != null) {
                        valoresAtuais[indiceMenor] = Integer.parseInt(proximaLinha);
                    } else {
                        blocosEsgotados[indiceMenor] = true; 
                    }
                }
            }

          
            for (int i = 0; i < quantidadeBlocos; i++) {
                arquivos[i].close();
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro de I/O na intercalação: " + e.getMessage(), e);
        }
    }
}