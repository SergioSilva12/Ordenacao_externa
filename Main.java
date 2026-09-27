import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int registros = 200;
        Random r = new Random();
        String caminho = "entrada.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (int i = 0; i < registros; i++) {
                int numeroAleatorio = r.nextInt(1000);
                writer.write(Integer.toString(numeroAleatorio));
                writer.newLine();
            }
            writer.close();
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}