public class BellmanFord {

    static final int INF = 999999;

    public static void bellmanFord(int[][] arestas, int vertices, int origem) {

        int[] distancia = new int[vertices];

        for(int i = 0; i < vertices; i++) {
            distancia[i] = INF;
        }

        distancia[origem] = 0;

        for (int i = 1; i < vertices; i++) {
            for (int j = 0; j < arestas.length; j++) {

                int u = arestas[j][0];
                int v = arestas[j][1];
                int peso = arestas[j][2];

                if (distancia[u] + peso < distancia[v]){
                    distancia[v] = distancia[u] + peso;
                }
            }
        }

        for (int j = 0; j < arestas.length; j++) {

            int u = arestas[j][0];
            int v = arestas[j][1];
            int peso = arestas[j][2];

            if (distancia[u] + peso < distancia[v]) {
                System.out.println("Existe ciclo negativo");
                return;
            }
        }

        imprimirDistancia(distancia);

    }

    public static void imprimirDistancia(int[] distancia) {

        for (int i = 0; i < distancia.length; i++) {
            System.out.println("Vertice " + i + " = " + distancia[i]);
        }

    }

    public static void main(String[] args) {
        //A = 0, B = 1, C = 2, D = 3, E = 4
        int vertices = 5;
        int[][] arestas = {
                {0,1,4},
                {0,3,2},

                {1,2,2},
                {1,3,3},
                {1,4,3},

                {3,1,1},
                {3,2,4},
                {3,4,5},

                {4,2,-5}
        };

        bellmanFord(arestas, vertices, 0);

    }
}