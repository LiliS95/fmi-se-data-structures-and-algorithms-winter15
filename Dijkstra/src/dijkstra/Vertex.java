package dijkstra;

/**
 *
 * @author Dimitar
 */
public class Vertex implements Comparable<Vertex> {

    public final char name;
    public Edge[] adjacencies;
    public int minDistance = Integer.MAX_VALUE;
    public Vertex previous;

    public Vertex(char name) {
        this.name = name;
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(minDistance, o.minDistance);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
