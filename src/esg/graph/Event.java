package esg.graph;

import java.util.*;

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

        if (this.components.contains("[")) {
            this.components = new ArrayList<>();
            this.components.add("[");
        }
        if (this.components.contains("]")) {
            this.components = new ArrayList<>();
            this.components.add("]");
        }
    }

    public List<String> getComponents() {
        return components;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        return this.toString().equals(o.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder toStringReturnValue = new StringBuilder();

        for (String component : components) {
            toStringReturnValue.append(component);
        }

        String returnValue = toStringReturnValue.toString();

        if (returnValue.equals("[")) {
            returnValue = "START";
        }
        else if (returnValue.equals("]")) {
            returnValue = "END";
        }

        return returnValue;
    }
}
