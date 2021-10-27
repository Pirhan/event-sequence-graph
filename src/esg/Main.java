package esg;

import esg.graph.EventSequenceGraph;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ESGReader problemInstanceReader = new ESGReader();

        try {
            EventSequenceGraph baseEsg = problemInstanceReader.readInstanceToAList("GraphLevel1");

            KSequenceExecutor kse = new KSequenceExecutor(baseEsg);

            System.out.println(kse.executeKSequenceOnBaseEventSequenceGraph(2).getConnections());

        } catch (IOException e) {
            System.out.println("Please input a valid file path.");
        }
    }
}
