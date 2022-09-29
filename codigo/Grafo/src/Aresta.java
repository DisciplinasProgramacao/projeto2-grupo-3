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

public class Aresta implements Serializable{

    //#region Atributos
    private final int peso;
    private int destino;
    private boolean visitada;
    //#endregion

    /**
     * Construtor para arestas com ou sem peso
     *
     * @param peso    Peso da aresta
     * @param destino Vértice de destino
     */
    public Aresta(int peso, int destino) {
        this.peso = peso;
        this.destino = destino;
        this.visitada = false;
    }
    //#region Métodos públicos

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

    /**
    * Marca a arresta como visitada
    */
    public void visitar() {
        this.visitada = true;
    }

    /**
    * Desmarca arresta da condição de visitada.
    */
    public void limparVisita() {
        this.visitada = false;
    }

    //#endregion
    //#region Getters and Setters
    /**
     * Método de acesso para o destino da aresta
     *
     * @return the destino
     */
    public int getDestino() {return this.destino;}
    /**
     * Método de acesso para o peso da aresta
     *
     * @return the peso
     */
    public int getPeso() {return this.peso;}
    public boolean isVisitada() {
        return this.visitada;
    }
    //#endregion

    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Aresta)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        Aresta a = (Aresta) o;
         
        // Compare the data members and return accordingly
        return peso == a.getPeso() && destino == a.getDestino();
    }
}
