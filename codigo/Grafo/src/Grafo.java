import java.io.Serializable;

/**
 * MIT License
 * <p>
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * Classe básica para um Grafo simples
 */
public abstract class Grafo implements Serializable {

    private static final long serialVersionUID = 7100179587555243994L;
    protected final String nome;
    //Na uml tem um # nessa propriedade e eu não sei o que significa
    protected ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome) {
        this.nome = nome;
        this.vertices = new ABB<>();
    }

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
    public Aresta existeAresta(Vertice verticeA, Vertice verticeB) {
        Aresta[] arestasVertice1 = new Aresta[verticeA.arestasNumber()];
        Aresta[] arestasVertice2 = new Aresta[verticeB.arestasNumber()];
        verticeA.getArestas().allElements(arestasVertice1);
        verticeB.getArestas().allElements(arestasVertice2);

        for (Aresta aresta : arestasVertice1) {
            for (Aresta value : arestasVertice2) {
                if (aresta.equals(value))
                    return aresta;
            }
        }
        return null;
    }

    /**
     * Verifica se este é um grafo completo.
     *
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo() {
        Vertice[] vetorVertices = new Vertice[vertices.size()];
        vetorVertices = vertices.allElements(vetorVertices);
        for (int i = 0; i < vetorVertices.length; i++) {
            if (vetorVertices[i].arestasNumber() % 2 != 0)
                return false;
        }
        return true;
    }

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

    public int ordem() {
        return this.vertices.size();
    }

}
