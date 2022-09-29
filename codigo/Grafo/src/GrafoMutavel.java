import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class GrafoMutavel extends Grafo {

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     * @param nome  nome do grafo
     */
    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o próximo id disponível.
     * @return TRUE caso add a vertice, e FALSE caso não add
     */
    public boolean addVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     *
     * @param origem  Vértice de origem
     * @param destino Vértice de destino
     * @return TRUE caso add a aresta, FALSE caso não add
     */
    public boolean addAresta(int origem, int destino) {

        boolean adicionou = false;

        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);

        if (saida != null && chegada != null) {
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
        }

        return adicionou;
    }

    /**
     *Salva um arquivo que representa um grafo
     * 
     * @param nomeArquivo  nome do arquivo a ser salvo
     */
    public void salvar(String nomeArquivo) throws IOException {
        FileOutputStream fOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(this);
        oOut.close();
    }

    /**
     * Lê um arquivo que representa um grafo
     * 
     * @param nomeArquivo  nome do arquivo a ser lido
     */
    public void carregar(String nomeArquivo) throws IOException, ClassNotFoundException{
        FileInputStream fOut= new FileInputStream(nomeArquivo);
        ObjectInputStream oOut= new ObjectInputStream(fOut);
        GrafoMutavel g = (GrafoMutavel) oOut.readObject();
        this.vertices = g.vertices;
        oOut.close();
    }

    /**
     * Deleta arquivo a partir de origem e destiino
     * 
     * @param origem int que representa a origem da aresta
     * @param destino int que representa o destino da arest
     * @return retorna TRUE caso a exclusão seja bem sucedida e FALSE caso contrario
     */
    public boolean delAresta(int origem, int destino) {

        Vertice[] verticeArray = new Vertice[vertices.size()];
        verticeArray = vertices.allElements(verticeArray);

        Vertice orige = this.vertices.get(origem);
        Vertice dest = this.vertices.get(destino);

        return orige.delAresta(origem) && dest.delAresta(destino);
    }

    /**
     * Deleta arquivo a partir de origem e destiino
     * 
     * @param idVertice int que representa o id do vertice
     * @return retorna TRUE caso a exclusão seja bem sucedida e FALSE caso contrario
     */
    public boolean delVertice(int idVertice) {

        //Acho q isso vai ter que mudar se a gente resolver implementar grafos direcionais
        return vertices.remove(idVertice);
    }

    @Override
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
        GrafoMutavel g = (GrafoMutavel) o;
         
        // Compare the data members and return accordingly
        return vertices.equals(g.getVertices()) && nome.equals(g.getNome());
    }
}
