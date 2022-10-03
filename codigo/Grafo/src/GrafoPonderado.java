public class GrafoPonderado extends GrafoMutavel {

    public GrafoPonderado(String nome){
        super(nome);
    }
    private GrafoPonderado(String nome, ABB<Vertice> lista) {
        super(nome);
        this.vertices = lista;
    }

    /**
     * Cria um subgrafo de acordo com os vértices de entrada
     * @param vertices Lista de vertices a ser retornada como grafo.
     * @return um subgrafo ponderado
     */
    @Override
    public GrafoPonderado subGrafo(Lista<Vertice> vertices) {
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

        return new GrafoPonderado("Subgrafo do grafo " + this.nome , lista);
    }

    public boolean addAresta(int origem, int destino, int peso) {

        boolean adicionou = false;

        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);

        if (saida != null && chegada != null) {
            saida.addAresta(destino,peso);
            chegada.addAresta(origem, peso);
            adicionou = true;
        }

        return adicionou;
    }
}
