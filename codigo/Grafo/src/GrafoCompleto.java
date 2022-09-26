public class GrafoCompleto extends Grafo {
    private int ordem;

    public GrafoCompleto(String nome) {
        super(nome);
        ordem = retornaOrdemGrafo();
    }


    public GrafoCompleto gerarGrafoCompleto() {
        GrafoCompleto grafoCompleto = new GrafoCompleto("Grafo 01");
        Vertice[] vetorVertices = new Vertice[vertices.size()];
        vetorVertices = vertices.allElements(vetorVertices);
        for (int i = 0; i < vetorVertices.length; i++) {

            for (int j = 0; j < vetorVertices.length; j++) {
                Aresta aresta = new Aresta(0, j);
                if (i != j) {
                    vetorVertices[i].addAresta(aresta.getDestino());
                }
            }

        }

        return null;
    }
//TODO euleriano incompleto

    /**
     * Verifica se o grafo satisfaz as condições para ser euleriano
     *
     * @return TRUE caso seja euleriano, FALSE caso não seja
     */


    //TODO Não consegui pensar em como fazer o subgrafo
    @Override
    public Grafo subGrafo(Lista<Vertice> vertices) {
        return null;
    }

    /**
     * Método utilizado para pegar o maior grau dentre os vertices disponiveis no grafo.
     */
    private void verificaMaiorGrau() {
        int maiorGrau = 0;
        GrafoCompleto grafo = new GrafoCompleto(nome);
        Vertice[] vetorVertices = new Vertice[vertices.size()];
        grafo.vertices.allElements(vetorVertices);
        for (Vertice vetorVertex : vetorVertices) {
            if (vetorVertex.arestasNumber() > maiorGrau)
                maiorGrau = vetorVertex.arestasNumber();
        }
    }

    /**
     * percorre todos os vértices do grafo e retorna a maior ordem dentre eles.
     *
     * @return um número inteiro que representa o maior grau do grafo
     */
    private int retornaOrdemGrafo() {
        return this.vertices.size();
    }
}
