package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjMatrix extends Graph {

    private int[][] adjMatrix;

    public GraphAdjMatrix(int[] v) {
        this.adjMatrix = new int[v.length][v.length];
        setNumVertices(v.length);
    }

    @Override
    public void addVertexImpl() {
        int v = getNumVertices();
        if(v >= adjMatrix.length){
            int[][] newAdjMatrix = new int[v*2][v*2];
            for (int i = 0; i < adjMatrix.length; i++){
                for (int j = 0; j< adjMatrix.length; j++){
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix[v].length; i++){
            adjMatrix[v][i] = 0;
        }
    }

    @Override
    public void addEdgeImpl(int v, int w) {
        adjMatrix[v][w] = 1;
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return getNeighbors(v, new ArrayList<>());
    }

    @Override
    public List<Integer> getTwoHopNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<>();
        for(int i = 0; i < adjMatrix[v].length; i++){
            for(int j = 0; j < adjMatrix[v][i]; j++){
                if(adjMatrix[v][i] >= 1){
                    getNeighbors(i,neighbors);
                }
            }
        }
        return neighbors;
    }

    @Override
    public List<Integer> getInNeighbors(int v) {
        List<Integer> inNeighbors = new ArrayList<Integer>();
        for (int i = 0; i < getNumVertices(); i ++) {
            for (int j=0; j< adjMatrix[i][v]; j++) {
                inNeighbors.add(i);
            }
        }
        return inNeighbors;
    }

    private List<Integer> getNeighbors(int v, List<Integer> current){
        for(int i = 0; i < adjMatrix[v].length; i++){
            for(int j = 0; j < adjMatrix[v][i]; j++){
                if(adjMatrix[v][i] >= 1) current.add(i);
            }
        }
        return current;
    }

    @Override
    public void print(){
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();

        }
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}
