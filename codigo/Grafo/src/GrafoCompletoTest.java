import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GrafoCompletoTest {

    @Test
    public void criaCertoGrafo() {
        GrafoCompleto grafo = new GrafoCompleto("Grafo01Teste");
        Vertice[] vetorVertices = new Vertice[5];
        int indiceVertice = 0;
        for (int i = 0; i < vetorVertices.length; i++) {
            vetorVertices[i] = new Vertice(indiceVertice);
            indiceVertice++;
        }
        for (Vertice vetorVertex : vetorVertices) {
            grafo.vertices.add(indiceVertice, vetorVertex);
        }
        grafo.gerarGrafoCompleto(5,"Cruzeiro");
    }
}
