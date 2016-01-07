package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Dimitar
 */
public class Dijkstra {

    private static Map<Character, Vertex> initGraph() {
        Vertex A = new Vertex('A');
        Vertex B = new Vertex('B');
        Vertex C = new Vertex('C');
        Vertex D = new Vertex('D');
        Vertex E = new Vertex('E');
        Vertex F = new Vertex('F');
        Vertex G = new Vertex('G');
        Vertex H = new Vertex('H');

        A.adjacencies = new Edge[]{
            new Edge(B, 20),
            new Edge(D, 80),
            new Edge(G, 90)
        };

        B.adjacencies = new Edge[]{
            new Edge(F, 10)
        };

        C.adjacencies = new Edge[]{
            new Edge(D, 10),
            new Edge(H, 20)
        };

        D.adjacencies = new Edge[]{
            new Edge(G, 20)
        };

        E.adjacencies = new Edge[]{
            new Edge(B, 50),
            new Edge(G, 30)
        };

        F.adjacencies = new Edge[]{
            new Edge(C, 10),
            new Edge(D, 40)
        };

        G.adjacencies = new Edge[]{
            new Edge(A, 20)
        };

        Map<Character, Vertex> graph = new HashMap<>();
        graph.put('A', A);
        graph.put('B', B);
        graph.put('C', C);
        graph.put('D', D);
        graph.put('E', E);
        graph.put('F', F);
        graph.put('G', G);
        graph.put('H', H);

        return graph;
    }

    static void computeShortestPaths(Vertex source) {
        source.minDistance = 0;

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.add(source);

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();

            if (u.adjacencies != null) {
                for (Edge e : u.adjacencies) {
                    Vertex v = e.target;
                    int weigth = e.weight;

                    int alternatingDistance = u.minDistance + weigth;
                    if (alternatingDistance < v.minDistance) {
                        pq.remove(v);
                        v.minDistance = alternatingDistance;
                        v.previous = u;
                        pq.add(v);
                    }
                }
            }
        }
    }

    static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new LinkedList<>();
        while (target != null) {
            path.add(0, target);
            target = target.previous;
        }
        return path;
    }

    public static void main(String[] args) {
        Map<Character, Vertex> vertices = initGraph();

        computeShortestPaths(vertices.get('A'));

        for (Character key : vertices.keySet()) {
            System.out.print(getShortestPathTo(vertices.get(key)));
            System.out.println(" " + vertices.get(key).minDistance);
        }
    }

}
