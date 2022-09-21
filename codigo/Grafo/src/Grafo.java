import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.IntegerConversion;

/** 
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
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
public abstract class Grafo {
    public final String nome;
    //Na uml tem um # nessa propriedade e eu não sei o que significa
    private ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome){
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }

    public Aresta existeAresta(int verticeA, int verticeB){
       return null;
    }
    
    /**
     * Verifica se este é um grafo completo. 
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo(){
        boolean resposta = true;
        
       return resposta;
    }

    public abstract Grafo subGrafo(Lista<Vertice> vertices);
    
    public int tamanho(){

        var verticesNumber = vertices.size();
        var arestaNumber = 0;

        Vertice[] verticeArray = new Vertice[vertices.size()];
        verticeArray =vertices.allElements(verticeArray);

        for(var v : verticeArray) {
            arestaNumber += v.arestasNumber();
        }

        return arestaNumber + verticesNumber;
    }

    public int ordem(){
        return this.vertices.size();
    }

}
