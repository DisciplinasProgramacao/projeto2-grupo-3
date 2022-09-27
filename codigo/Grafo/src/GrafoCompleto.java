public class GrafoCompleto extends Grafo {

    private int ordem;

    public GrafoCompleto(String nome) {
        super(nome);
        vertices = new ABB<>();
    }

    /**
     * Cria um grafo Completo de acordo com um número de vértices.
     * @param ordem quantidade de vértices que existirão no grafo.
     * @param nome Nome do grafo
     */
    public GrafoCompleto(int ordem, String nome) {
        
        super(nome);
        this.ordem = ordem;
        vertices = new ABB<>();

        Vertice[] v = new Vertice[this.ordem];

        for(int i=0; i<v.length; i++){
            v[i] = new Vertice(i);
            for(int j=0; j<v.length; j++){
                if(i==j)
                    continue;
                v[i].addAresta(j);
            }
        }

        for (Vertice vertice : v) {
            vertices.add(vertice.getId(), vertice);
        }
    }
    
    @Override
    public Grafo subGrafo(Lista<Vertice> vertices) {
        return new GrafoCompleto(vertices.size(), "Grafo completo tamanho "+ vertices.size());
    }
}
