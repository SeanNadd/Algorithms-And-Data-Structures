package graphs;

import java.util.*;

public class GraphAdjList extends  Graph{
    private Map<Integer, ArrayList<Integer>> adjListMap;

    public GraphAdjList(int[] v) {
        adjListMap = new HashMap<>();
        for (Integer i : v)
            addVertex();
    }

    @Override
    public void addVertexImpl() {
        ArrayList<Integer> neighbors = new ArrayList<>();
        adjListMap.put(getNumVertices(), neighbors);
    }

    @Override
    public void addEdgeImpl(int v, int w) {
        adjListMap.get(v).add(w);
    }

    @Override
    public List<Integer> getNeighbors(int v) {
        return getNeighbors(v, new ArrayList<>());
    }

    @Override
    public List<Integer> getInNeighbors(int v) {
        List<Integer> inNeighbors = new ArrayList<Integer>();
        for (int u : adjListMap.keySet()) {
            for (int w : adjListMap.get(u)) {
                if (v == w) {
                    inNeighbors.add(u);
                }
            }
        }
        return inNeighbors;
    }

    @Override
    public List<Integer> getTwoHopNeighbors(int v) {
        List<Integer> oneHop = new ArrayList<>(adjListMap.get(v));
        List<Integer> twoHop = new ArrayList<>();
        for(Integer n : oneHop) getNeighbors(n, twoHop);
        return twoHop;
    }

    private List<Integer> getNeighbors(int v, List<Integer> current){
        current.addAll(adjListMap.get(v));
        return current;
    }

    @Override
    public void print() { //TODO figure this out
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(adjListMap.get(0));
        while(!q.isEmpty()) {
            ArrayList<Integer> curr = q.remove();
            for (Integer i : curr) {
                if(visited.add(i)) {
                    q.add(adjListMap.get(i));
                    System.out.print(i + "\t");
                }
            }
            System.out.println();
        }
    }
}
