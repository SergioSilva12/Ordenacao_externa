import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GerarNumeros {
    public static void gerador(String caminho, int registros) {
        Random r = new Random();
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (int i = 0; i < registros; i++) {
                int numeroAleatorio = r.nextInt(1000);
                bw.write(Integer.toString(numeroAleatorio));
                bw.newLine();
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
    
}
