import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class GrafoMutavel extends Grafo {

    public GrafoMutavel(String nome) {
        super(nome);
    }

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o próximo id disponível.
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo. 
     * Não verifica se os vértices pertencem ao grafo.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     */
    public boolean addAresta(int origem, int destino){
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
        }
        
        return adicionou;

    }

    public void salvar (String nomeArquivo) throws IOException{
        FileOutputStream fOut = new FileOutputStream(nomeArquivo);
        ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(this);
        oOut.close();
    }

    public GrafoMutavel carregar(String nomeArquivo) throws IOException, ClassNotFoundException{
        FileInputStream fOut= new FileInputStream(nomeArquivo);
        ObjectInputStream oOut= new ObjectInputStream(fOut);
        GrafoMutavel g = (GrafoMutavel) oOut.readObject();
        oOut.close();

        return g;
    }

    public boolean delAresta(int origem, int destino){

        //Aqui considerei que pode haver um loop. Assim uma aresta vai estar ligada a um unico vertice. 
        //Logo a origem é o destino serão um só. Sendo assim as o return vai ser necessáriamente True e False
        //Não estou seguro que essa lógica esta certa, e estou com sono kkkkk. Logo fiquem  a vontade se quiserem corrigir antes de mim 
        
        Vertice[] verticeArray = new Vertice[vertices.size()];
        verticeArray = vertices.allElements(verticeArray);

        var destinoRemovido = false;
        var origemRemovido = false;

        for(var v : verticeArray) {
            //Acho q isso vai ter que mudar se a gente resolver implementar grafos direcionais
            if(v.delAresta(destino)){
                destinoRemovido = true;
            }
            if(v.delAresta(origem)){
                origemRemovido = true;
            }
        }

        return destinoRemovido || origemRemovido;
    }

    public boolean delVertice(int idVertice){
              
        //Acho q isso vai ter que mudar se a gente resolver implementar grafos direcionais
        return vertices.remove(idVertice);
    }
    
}
