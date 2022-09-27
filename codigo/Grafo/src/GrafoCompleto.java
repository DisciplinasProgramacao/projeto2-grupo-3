public class GrafoCompleto extends Grafo {
    private int ordem;

    //TODO ORDEM DO GRAFO TEM QUE SER CALCULADA DEPOIS DELE ESTAR PREENCHIDO
    public GrafoCompleto(String nome) {
        super(nome);
        ordem = retornaOrdemGrafo();
    }

    /**
     * Cria um grafo Completo de acordo com um número de vértices.
     * @param quantidadeVertices quantidade de vértices que existirão no grafo.
     * @param nome Nome do grafo
     * @return Retorna um grafo completo
     */
    public GrafoCompleto gerarGrafoCompleto(int quantidadeVertices, String nome) {
        int indiceGrafo = 1;
        GrafoCompleto grafoCompleto = new GrafoCompleto(nome);
        Vertice[] vetorVertices = new Vertice[quantidadeVertices];
        for (int i = 0; i < vetorVertices.length; i++) {
            vetorVertices[i] = new Vertice(indiceGrafo);
        }

        vetorVertices = vertices.allElements(vetorVertices);
        for (int i = 0; i < vetorVertices.length; i++) {

            for (int j = 0; j < vetorVertices.length; j++) {
                Aresta aresta = new Aresta(0, j);
                if (i != j) {
                    vetorVertices[i].addAresta(aresta.getDestino());
                }
            }
        }
        for (Vertice vetorVertex : vetorVertices) {
            grafoCompleto.vertices.add(indiceGrafo, vetorVertex);
            indiceGrafo++;
        }
        return grafoCompleto;
    }


    /**
     * Verifica se o grafo satisfaz as condições para ser euleriano
     *
     * @return TRUE caso seja euleriano, FALSE caso não seja
     */
    public boolean euleriano() {
        Vertice[] vetorVertices = new Vertice[vertices.size()];
        vetorVertices = vertices.allElements(vetorVertices);
        for (int i = 0; i < vertices.size(); i++) {
            if (vetorVertices[i].arestasNumber() % 2 != 0) {
                return false;
            }
        }
        return true;
    }


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
