import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class GrafoPonderadoTest {

    private static GrafoPonderado grafo;

    @BeforeAll
    public void criarGrafoPonderado(){
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
        grafo.addAresta(5, 5);
    }

    @Test
    public void salverEmUmArquivoEcarregar() throws IOException, ClassNotFoundException{
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
        grafo.addAresta(5, 5);

        grafo.salvar("Grafo Ponderado");
        var path = Paths.get("Grafo Ponderado");
        assertTrue(Files.exists(path));
        GrafoPonderado g = new GrafoPonderado(grafo.getNome());
        g.carregar("Grafo Ponderado");
        assertTrue(grafo.equals(g));
    }

    @Test
    public void testaTamnho(){
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

        assertEquals(grafo.tamanho(), 12);
    }

    @Test
    public void insercaoArresta(){
        grafo = new GrafoPonderado("Grafo Ponderado");
        
        grafo.addVertice(1);
        grafo.addVertice(2);
        
        grafo.addAresta(1, 2);
        grafo.addAresta(2, 1);
        
        assertEquals(grafo.verticesNumber(), 2);

        assertEquals(grafo.arrestasNumber(), 2);
    }
}
