import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    private static GrafoCompleto grafo;

    @BeforeAll
    public static void criarInstancia() {
        grafo = new GrafoCompleto(6, "Grafo completo com 6 vertices");
    }

    @Test
    public void verSeEhRealmenteUmGrafoCompleto() {
        boolean resposta = true;
        Vertice[] vetorVertices = new Vertice[grafo.vertices.size()];
        vetorVertices = grafo.vertices.allElements(vetorVertices);
        for (Vertice vetorVertex : vetorVertices) {
            if (vetorVertex.arestasNumber() != (grafo.ordem() - 1))
                resposta = false;
        }
        assertTrue(resposta);
    }
}
