import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Arquivo {
    FileWriter arquivo;
    PrintWriter escreverArquivo;

    public Arquivo(String nomeArquivo) throws IOException {
        init(nomeArquivo);
    }

    private void init(String nomeArquivo) throws IOException {
        this.arquivo = new FileWriter(nomeArquivo);
        escreverArquivo = new PrintWriter(arquivo);
    }

    public void escrever(String texto) {
        escreverArquivo.println(texto);
    }

    public void lerLinha(FileWriter arquivo) {
        Scanner in = new Scanner(new FileReader(arquivo));
        while (in.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
    }
}
