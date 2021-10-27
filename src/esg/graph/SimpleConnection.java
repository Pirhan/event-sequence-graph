package esg.graph;

public class SimpleConnection<Node> implements Connection<Node> {
    Node from;
    Node to;
    double w;

    public SimpleConnection(Node from, Node to, double w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }

    @Override
    public Node fromNode() {
        return from;
    }

    @Override
    public Node toNode() {
        return to;
    }

    @Override
    public double weight() {
        return w;
    }

    public String toString() {
        return "[" + from + " - " + to + "]";
    }
}
