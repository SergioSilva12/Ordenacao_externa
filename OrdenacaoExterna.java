import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OrdenacaoExterna {

    public static void ordencaoExterna() {
        String linha;
        int tamanhoBloco = 50;
        int[] bloco = new int[tamanhoBloco];
        int indice = 0;
        int valorBloco = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("entrada.txt"))) {
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
}