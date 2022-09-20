import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArestaTest {

    static Aresta aresta;

    @BeforeAll
    public static void criaAresta() {
        aresta = new Aresta(2, 3);
    }

    @Test
    public void criarArestaCorreta() {
        assertEquals(2, aresta.getPeso());
        assertEquals(3, aresta.getDestino());
    }

    @Test
    public void visitaCorreta() {
        aresta.visitar();
        assertTrue(aresta.isVisitada());
    }

    @Test
    public void limpaVisita() {
        aresta.visitar();
        assertTrue(aresta.isVisitada());
        aresta.limparVisita();
        assertFalse(aresta.isVisitada());
    }


}
