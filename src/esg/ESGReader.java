package esg;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import esg.graph.Event;
import esg.graph.EventSequenceGraph;

public class ESGReader {
    public EventSequenceGraph readInstanceToAList(String filePath) throws IOException {
        List<String> fileAsList;
        try (Stream<String> lines = Files.lines(Paths.get("src", "esg", "examples", filePath))) {
            fileAsList = lines.collect(Collectors.toList());
        }

        HashMap<String, Event> addedEvents = new HashMap<>();

        EventSequenceGraph esg = new EventSequenceGraph();
        for (String s : fileAsList) {
            String[] connectionData = s.trim().split("#");

            Event fromEvent;
            Event toEvent;

            if (!addedEvents.containsKey(connectionData[0])) {
                fromEvent = new Event(connectionData[0].split(","));
                addedEvents.put(connectionData[0], fromEvent);
            } else {
                fromEvent = addedEvents.get(connectionData[0]);
            }

            if (!addedEvents.containsKey(connectionData[1])) {
                toEvent = new Event(connectionData[1].split(","));
                addedEvents.put(connectionData[1], toEvent);
            } else {
                toEvent = addedEvents.get(connectionData[1]);
            }


            if (fromEvent.getComponents().size() != toEvent.getComponents().size()) {
                throw new RuntimeException("Given event sequence esg.graph cannot be created initially because the number of events on each node are not equal to each other.");
            }

            esg.addConnection(fromEvent, toEvent, 0);
        }

        return esg;
    }
}
