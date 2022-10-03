public class GrafoNaoPonderado extends GrafoMutavel{
    
    public GrafoNaoPonderado(String nome) {
        super(nome);
    }
    
    private GrafoNaoPonderado(String nome, ABB<Vertice> lista) {
        super(nome);
        this.vertices = lista;
    }

    /**
     * Método que cria um subgrafo a partir da lista de vertices de entrada
     * @param vertices Lista de vertices a ser retornada como grafo.
     * @return um subgrafo não ponderado
     */
    @Override
    public GrafoNaoPonderado subGrafo(Lista<Vertice> vertices) {
        ABB<Vertice> lista = new ABB<>();
        Vertice[] verticesOriginal = new Vertice[this.vertices.size()];
        verticesOriginal = this.vertices.allElements(verticesOriginal);
       
        for(int i=0; i<verticesOriginal.length; i++){
            if(!vertices.exist(verticesOriginal[i])){
                
                verticesOriginal[i] = null;
                
                for(int j=0; j<verticesOriginal.length; j++){
                    if(i==j)
                        continue;
                    verticesOriginal[j].delAresta(i);
                }
                
                verticesOriginal[i] = null;
            }
            if(verticesOriginal[i] != null){
                lista.add(verticesOriginal[i].getId(), verticesOriginal[i]);
            }
        }

        return new GrafoNaoPonderado("Subgrafo do grafo " + this.nome , lista);

    }
}
