package esg;

import esg.graph.Connection;
import esg.graph.Event;
import esg.graph.EventSequenceGraph;

import java.util.List;

public class KSequenceExecutor {
    EventSequenceGraph baseEventSequenceGraph;

    public KSequenceExecutor(EventSequenceGraph baseEventSequenceGraph) {
        this.baseEventSequenceGraph = baseEventSequenceGraph;
    }

    public EventSequenceGraph executeKSequenceOnEventSequenceGraph(EventSequenceGraph eventSequenceGraphToBeProcessed, int level) {
        for (int i = 0; i < level; i++) {
            EventSequenceGraph eventSequenceGraph = new EventSequenceGraph();

            for (Event fromNode : eventSequenceGraphToBeProcessed.getConnections().keySet()) {
                List<Connection<Event>> fromNodeConnections = eventSequenceGraphToBeProcessed.getConnections(fromNode);

                for (Connection<Event> fromNodeConnection : fromNodeConnections) {
                    Event toNode = fromNodeConnection.toNode();

                    List<Connection<Event>> toNodeConnections = eventSequenceGraphToBeProcessed.getConnections(toNode);

                    if (toNodeConnections != null) {
                        for (Connection<Event> toNodeConnection : toNodeConnections) {
                            Event toNode2 = toNodeConnection.toNode();

                            Event newFromNode = new Event();

                            for (int l = 0; l + i < fromNode.getComponents().size(); l++) {
                                newFromNode.addToComponents(fromNode.getComponents().get(l));
                            }

                            for (int l = 0; l < toNode.getComponents().size(); l++) {
                                newFromNode.addToComponents(toNode.getComponents().get(l));
                            }

                            Event newToNode = new Event();

                            for (int l = 0; l + i < toNode.getComponents().size(); l++) {
                                newToNode.addToComponents(toNode.getComponents().get(l));
                            }

                            for (int l = 0; l < toNode2.getComponents().size(); l++) {
                                newToNode.addToComponents(toNode2.getComponents().get(l));
                            }

                            if(newFromNode.getComponents().size() == i + 2) {
                                eventSequenceGraph.addConnection(newFromNode, newToNode, 0);
                            }
                        }
                    }
                }
            }

            eventSequenceGraphToBeProcessed = eventSequenceGraph;
        }

        return eventSequenceGraphToBeProcessed;
    }

    public EventSequenceGraph executeKSequenceOnBaseEventSequenceGraph(int level) {
        return executeKSequenceOnEventSequenceGraph(new EventSequenceGraph(baseEventSequenceGraph), level - 1);
    }
}
