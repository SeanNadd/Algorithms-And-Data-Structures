package graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GraphAdjMatrixTest {

    Graph adjMatrixGraph;

    @Before
    public void setUp() throws Exception {
        adjMatrixGraph = new GraphAdjMatrix(new int[]{0,1,2,3,4,5});
        adjMatrixGraph.addEdge(0,1);
        adjMatrixGraph.addEdge(2,3);
        adjMatrixGraph.addEdge(4,3);
        adjMatrixGraph.addEdge(5,4);
        adjMatrixGraph.addEdge(5,3);
    }

    @Test
    public void addVertexImpl() {
        assertEquals("Testing adding a vertex",6,adjMatrixGraph.getNumVertices());
        adjMatrixGraph.addVertex();
        assertEquals("Testing adding a vertex",7,adjMatrixGraph.getNumVertices());
    }

    @Test
    public void testAddEdgeImpl() {
        adjMatrixGraph.addEdge(1,2);
        adjMatrixGraph.addEdge(1,4);
        adjMatrixGraph.print();
        assertEquals("Testing get neighbors of 1",2,adjMatrixGraph.getNeighbors(1).size());
    }

    @Test
    public void getNeighbors() {
        assertEquals("Testing get neighbors of 5",2,adjMatrixGraph.getNeighbors(5).size());
    }
}
