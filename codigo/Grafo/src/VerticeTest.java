import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VerticeTest {
    @Test
    public void criaVerticeVazio() {
        Vertice vertice = new Vertice(1);
        assertEquals(0, vertice.arestasNumber());
    }

    @Test
    public void adicionaAresta() {
        Vertice vertice = new Vertice(1);
        vertice.addAresta(2);
        assertEquals(1, vertice.arestasNumber());
    }

    @Test
    public void procuraAresta() {
        int indiceAresta = 0;
        Vertice vertice = new Vertice(1);
        for (int i = 0; i < 4; i++) {
            vertice.addAresta(indiceAresta);
            indiceAresta++;
        }
        assertEquals(vertice.getArestas().find(3), vertice.existeAresta(3));
    }

    @Test
    public void deletaAresta() {
        int indiceAresta = 0;
        Vertice vertice = new Vertice(1);
        for (int i = 0; i < 4; i++) {
            vertice.addAresta(indiceAresta);
            indiceAresta++;
        }
        vertice.delAresta(3);
        assertNull(vertice.getArestas().find(3));
    }

    @Test
    public void visitaVertice() {
        Vertice vertice = new Vertice(1);
        vertice.visitar();
        assertTrue(vertice.visitado());
    }

    public void tiraVisita() {
        Vertice vertice = new Vertice(1);
        vertice.visitar();
        vertice.limparVisita();
        assertFalse(vertice.visitado());
    }
}
