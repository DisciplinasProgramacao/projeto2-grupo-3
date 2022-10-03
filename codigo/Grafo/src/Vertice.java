import java.io.Serializable;

/**
 * MIT License
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class Vertice implements Serializable{
    //#region Atributos
    private ABB<Aresta> arestas;

    private final int id;
    private boolean visitado;
//#endregion
    //#region Construtor

    /**
     * Construtor para
     * criação de vértice identificado
     *
     * @param id Número/id do vértice a ser criado (atributo final).
     */
    public Vertice(int id) {
        this.id = id;
        this.arestas = new ABB<>();
        this.visitado = false;
    }
    public int arrestasNumber(){
        return this.arestas.size();
    }
    //#endregion
    //#region Métodos

    public void setArestas(ABB<Aresta> arestas) {
        this.arestas = arestas;
    }

    /**
     * Adiciona uma aresta neste vértice para um destino
     * @param destino Vértice de destino
     */
    public boolean addAresta(int destino) {
        return this.arestas.add(destino, new Aresta(0, destino));
    }
    public boolean addAresta(int destino,int peso) {
        return this.arestas.add(destino, new Aresta(peso, destino));
    }
    /**
     * Verifica se já existe aresta entre este vértice e um destino. Método privado
     * @param destino Vértice de destino
     * @return TRUE se existe aresta, FALSE se não
     */
    public Aresta existeAresta(int destino) {
        return this.arestas.find(destino);
    }

    /**
     * Define o grau do vértice de acordo com a quantidade de arestas.
     * @return Um inteiro que representa o grau do vértice.
     */
    public int grau() {
        return this.arestas.size();
    }

    /**
     * Método que define o vértice como visitada
     */
    public void visitar() {
        this.visitado = true;
    }

    /**
     * Método que define o vértice como não visitado
     */
    public void limparVisita() {
        this.visitado = false;
    }

    /**
     * Método que calcula a quantidade de arestas que o vértice possui
     * @return A quantidade de arestas que incidem no vértice
     */
    public int arestasNumber() {
        return this.arestas.size();
    }

    /**
     * Pesquisa se a aresta existe no vértice e a remove das arestas desse vértice caso ela exista.
     * @param destino Para qual outro vértice essa aresta aponta.
     * @return TRUE se existir a aresta e a remoção for feita, FALSE se não existir
     */
    public boolean delAresta(int destino) {

        var retorno = false;

        if (arestas.containsKey(destino)) {
            arestas.remove(destino);
            retorno = true;
        }

        return retorno;
    }
//#endregion
    //#region Getters & Setters
    public ABB<Aresta> getArestas() {
        return arestas;
    }

    public int getId() {
        return id;
    }

    public boolean visitado() {
        return this.visitado;
    }
    //#endregion

    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof GrafoMutavel)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        Vertice v = (Vertice) o;
         
        // Compare the data members and return accordingly
        return arestas.equals(v.getArestas()) && id == v.getId();
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean allArestasVisited() {
        
        Aresta[] a = new Aresta[arestas.size()];
        a = arestas.allElements(a);

        for (Aresta aresta : a) {
            if(!aresta.isVisitada()){
                return false;
            }
        }

        return true;
    }
}
