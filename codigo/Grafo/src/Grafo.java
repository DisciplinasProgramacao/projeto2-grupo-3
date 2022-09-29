import java.io.Serializable;

/*
  MIT License
  <p>
  Copyright(c) 2021 João Caram <caram@pucminas.br>
  <p>
  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:
  <p>
  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.
  <p>
  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples
 */
public abstract class Grafo implements Serializable {

    private static final long serialVersionUID = 7100179587555243994L;
    protected final String nome;
    protected int[] tempoDescoberta;
    public String getNome() {
        return nome;
    }

    public ABB<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ABB<Vertice> vertices) {
        this.vertices = vertices;
    }

    protected int[] tempoTermino;
    protected Vertice[] verticesGrafo;
    protected int tempo = 0;
    protected Integer[] pai;
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     *
     * @param nome nome do grafo
     */
    public Grafo(String nome) {
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public int arrestasNumber(){

        int arrestas = 0;
        Vertice[] v = new Vertice[vertices.size()];
        v = vertices.allElements(v);
        for (Vertice vertice : v) {
            arrestas += vertice.arestasNumber();
        }

        return arrestas;
    }

    public Lista<Vertice> caminhoEureliano() {

        Lista<Vertice> retorno = new Lista<>();
        Vertice[] vetorVertices = new Vertice[vertices.size()];
        vetorVertices = vertices.allElements(vetorVertices);

        for (int i = 0; i < vetorVertices.length; i++) {
            //Retirando desconexos e desconexos com laços
            if (vetorVertices[i].arestasNumber() == 0 || (vetorVertices[i].arestasNumber() == 1 && vetorVertices[i].existeAresta(vetorVertices[i].getId()) != null)) {
                vetorVertices[i] = null;
            }

            if (vetorVertices[i] != null) {
                //Torna as vertices pares pra cada aresta
                if (vetorVertices[i].arestasNumber() % 2 != 0) {
                    for (int j = 0; j < vetorVertices.length; j++) {

                        if (i == j)
                            continue;

                        if (existeAresta(vetorVertices[i].getId(), vetorVertices[j].getId()) == null) {
                            vetorVertices[i].addAresta(vetorVertices[j].getId());
                        }
                    }
                }

                //add arestas pares a lista
                retorno.add(vetorVertices[i]);
            }

        }

        return retorno;
    }

    /**
     * Metodo que diz se o grafo corrente é eureliano
     */

    public void inicializaBuscaProfundidade(Vertice vertice) {

        tempoDescoberta = new int[vertices.size()];
        tempoTermino = new int[vertices.size()];
        pai = new Integer[vertices.size()];

        verticesGrafo = new Vertice[vertices.size()];
        verticesGrafo = vertices.allElements(verticesGrafo);


        for (int i = 0; existeZero(tempoDescoberta); i++) {
            buscaProfundidade(verticesGrafo[i]);
        }
    }

    private void buscaProfundidade(Vertice vertice) {
        tempo += 1;
        tempoDescoberta[vertice.getId()] = tempo;
        Aresta[] vetorArestas = new Aresta[vertice.arestasNumber()];
        vetorArestas = vertice.getArestas().allElements(vetorArestas);

        for (Aresta aresta : vetorArestas) {
            if (tempoDescoberta[aresta.getDestino()] == 0) {
                aresta.visitar();
                pai[aresta.getDestino()] = vertice.getId();
                buscaProfundidade(verticesGrafo[aresta.getDestino()]);
            }
            else if (tempoTermino[aresta.getDestino()] == 0 && aresta.getDestino() != pai[vertice.getId()]) {
                aresta.visitar();
            }
        }
        tempo++;
        tempoTermino[vertice.getId()] = tempo;
    }

    private boolean existeZero(int[] vetor) {
        for (int number : vetor) {
            if (number == 0)
                return true;
        }
        return false;
    }

    //#region metodos
    public boolean euleriano() {
        //Teorema: Um multigrafo M é euleriano se e somente se M é conexo e cada vértice de M tem grau par.
        Vertice[] vetorVertices = new Vertice[vertices.size()];
        vetorVertices = vertices.allElements(vetorVertices);

        for (Vertice vertice : vetorVertices) {
            if (vertice.arestasNumber() == 0)
                return false;

            if (vertice.arestasNumber() % 2 != 0)
                return false;
        }

        return true;
    }

    /**
     * Método que verifica a existencia de uma aresta comum entre dois vértices.
     *
     * @param idVertice id do vertice
     * @return Retorna a aresta em comum caso ela exista, ou retorna NULL caso não exista relação dos vertices com essa aresta.
     */
    public Vertice existeVertice(int idVertice) {
        return this.vertices.find(idVertice);
    }

    /**
     * Método que verifica a existencia de uma aresta comum entre dois vértices.
     *
     * @param verticeA vertice para ser comparado.
     * @param verticeB vertice para ser comparado.
     * @return Retorna a aresta em comum caso ela exista, ou retorna NULL caso não exista relação dos vertices com essa aresta.
     */
    public Aresta existeAresta(int verticeA, int verticeB) {

        //No caso de bidirecional podemos fazer assim. Caso seja unidirecional devemos conferir pros dois lados
        return this.vertices.get(verticeA).existeAresta(verticeB);
    }

    /**
     * Verifica se este é um grafo completo.
     *
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo() {
        Vertice[] vetorVertices = new Vertice[vertices.size()];
        vetorVertices = vertices.allElements(vetorVertices);

        //Verificar isso aqui. Se for um unico vertice com um ciclo é completo ?
        if (vetorVertices.length == 1)
            return true;

        for (int i = 0; i < vetorVertices.length; i++) {

            for (int j = 0; j < vetorVertices.length; j++) {

                if (i == j)
                    continue;

                if (vetorVertices[i].existeAresta(vetorVertices[j].getId()) == null)
                    return false;
            }
        }
        return true;
    }

    /**
     * Método que retorna um subgrafo do grafo atual a partir da lista de vertices dada
     *
     * @param vertices Lista de vertices a ser retornada como grafo.
     * @return Retorna um Grafo.
     */
    public abstract Grafo subGrafo(Lista<Vertice> vertices);

    public int tamanho() {

        var verticesNumber = vertices.size();
        var arestaNumber = 0;

        Vertice[] verticeArray = new Vertice[vertices.size()];
        verticeArray = vertices.allElements(verticeArray);

        for (var v : verticeArray) {
            arestaNumber += v.arestasNumber();
        }

        return arestaNumber + verticesNumber;
    }

    public int verticesNumber(){
        return vertices.size();
    }
    
    /**
     * Método que retorna a ordem do grafo atual
     *
     * @return um valor inteiro representando a ordem do grafo atual.
     */
    public int ordem() {
        return this.vertices.size();
    }
//#endregion
}
