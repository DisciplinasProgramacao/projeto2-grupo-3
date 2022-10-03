import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GrafoPonderadoTest {

    private static GrafoPonderado grafo;

    @BeforeAll
    public static void criarGrafoPonderado(){
        grafo = new GrafoPonderado("Grafo Ponderado");
        
        grafo.addVertice(1);
        grafo.addVertice(2);
        grafo.addVertice(3);
        grafo.addVertice(4);
        grafo.addVertice(5);

        grafo.addAresta(1, 2);
        grafo.addAresta(2, 1);
        grafo.addAresta(1, 4);
        grafo.addAresta(4, 1);
        grafo.addAresta(4, 5);
        grafo.addAresta(5, 4);
    }

    @Test
    public void salverEmUmArquivoEcarregar() throws IOException, ClassNotFoundException{

        grafo.salvar("Grafo Ponderado");
        var path = Paths.get("Grafo Ponderado");
        assertTrue(Files.exists(path));
        GrafoPonderado g = new GrafoPonderado(grafo.getNome());
        g.carregar("Grafo Ponderado");
        assertTrue(grafo.equals(g));
    }

    @Test
    public void testaTamnho(){
        assertEquals(grafo.tamanho(), 12);
    }

    @Test
    public void insercaoArresta(){

        assertEquals(grafo.verticesNumber(), 5);
        assertEquals(grafo.arrestasNumber(), 6);
    }
}
