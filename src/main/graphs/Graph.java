package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Graph {

    private int numVertices;
    private int numEdges;

    public Graph() {
        numVertices = 0;
        numEdges = 0;
    }

    public void addVertex(){
        addVertexImpl();
        numVertices++;
    }

    public void addEdge(int v, int w){
        addEdgeImpl(v,w);
        numEdges++;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }

    public List<Integer> degreeSequence() {
        List<Integer> degreeSequence = new ArrayList<>();
        for(int i = 0; i < getNumVertices(); i++){
            degreeSequence.add(i);
            degreeSequence.set(i , 0);
            for(Integer in :getInNeighbors(i)) degreeSequence.set(i, degreeSequence.get(i) + 1);
            for(Integer out : getNeighbors(i)) degreeSequence.set(i, degreeSequence.get(i) + 1);
        }
        Collections.sort(degreeSequence);
        Collections.reverse(degreeSequence);
        return degreeSequence;
    }

    public abstract void addVertexImpl();
    public abstract void addEdgeImpl(int v, int w);
    public abstract List<Integer> getNeighbors(int v);
    public abstract List<Integer> getTwoHopNeighbors(int v);
    public abstract List<Integer> getInNeighbors(int v);
    public abstract void print();
}
