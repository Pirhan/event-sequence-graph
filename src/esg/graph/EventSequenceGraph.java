package esg.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EventSequenceGraph implements Graph<Event> {
    private HashMap<Event, List<Connection<Event>>> connections;

    public EventSequenceGraph() {
        this.connections = new HashMap<>();
    }

    public EventSequenceGraph(EventSequenceGraph esg) {
        this.connections = new HashMap<>();

        for (Event event : esg.getConnections().keySet()) {
            this.connections.put(event, esg.getConnections().get(event));
        }
    }

    public HashMap<Event, List<Connection<Event>>> getConnections() {
        return connections;
    }

    @Override
    public List<Connection<Event>> getConnections(Event fromNode) {
        return connections.get(fromNode);
    }

    public void addConnection(Connection<Event> connection) {
        if (!connections.containsKey(connection.fromNode())) {
            connections.put(connection.fromNode(), new ArrayList<>());
        }

        connections.get(connection.fromNode()).add(connection);
    }

    public void addConnection(Event from, Event to, double w) {
        addConnection(new SimpleConnection<>(from, to, w));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Event connection : connections.keySet()) {
            result.append(connection).append(" -> ").append(
                    connections.get(connection).stream().map(event -> String.valueOf(event.toNode())).collect(
                            Collectors.joining(" | ")
                    )
            ).append("\n");
        }
        return result.toString();
    }
}
