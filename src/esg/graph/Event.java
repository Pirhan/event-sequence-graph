package esg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
    private List<String> components;

    public Event(String[] components) {
        this.components = new ArrayList<>();

        this.components.addAll(Arrays.asList(components));
    }

    public Event() {
        this.components = new ArrayList<>();
    }

    public void addToComponents(String component) {
        this.components.add(component);
    }

    public List<String> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder toStringReturnValue = new StringBuilder();

        for (String component : components) {
            toStringReturnValue.append(component);
        }

        return toStringReturnValue.toString();
    }
}
