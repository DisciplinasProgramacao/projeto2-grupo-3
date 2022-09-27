import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    private static GrafoCompleto grafo;
    @BeforeAll
    public void criarInstancia(){
        grafo = new GrafoCompleto(8, "Grafo completo com 8 vertices");
    }

    @Test
    public void verSeEhRealmenteUmGrafoCompleto(){
        assertEquals(8, grafo.vertices.size());
        //Vertice[]  v = new Vertice[]
        //assertEquals(8, grafo.ver);
    }
}
