import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    private static GrafoCompleto grafo;

    @BeforeAll
    public static void criarInstancia() {
        grafo = new GrafoCompleto(8, "Grafo completo com 8 vertices");
    }

    @Test
    public void verSeEhRealmenteUmGrafoCompleto() {
        boolean resposta = true;
        Vertice[] vetorVertices = new Vertice[grafo.vertices.size()];
        vetorVertices = grafo.vertices.allElements(vetorVertices);
        for (int i = 0; i < vetorVertices.length; i++) {
            if (vetorVertices[i].arestasNumber() != (grafo.ordem() - 1))
                resposta = false;
        }
        assertTrue(resposta);
    }
}
