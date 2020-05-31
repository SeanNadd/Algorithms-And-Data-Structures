package graphs;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    private Graph adjListGraph;
    private Graph adjMatrixGraph;

    @Before
    public void setUp() throws Exception {
        adjListGraph = new GraphAdjList(new int[]{0,1,2,3,4,5});
        adjListGraph.addEdge(0,1);
        adjListGraph.addEdge(2,3);
        adjListGraph.addEdge(4,3);
        adjListGraph.addEdge(5,4);
        adjListGraph.addEdge(5,3);

        adjMatrixGraph = new GraphAdjMatrix(new int[]{0,1,2,3,4,5});
        adjMatrixGraph.addEdge(0,1);
        adjMatrixGraph.addEdge(2,3);
        adjMatrixGraph.addEdge(4,3);
        adjMatrixGraph.addEdge(5,4);
        adjMatrixGraph.addEdge(5,3);
    }

    @Test
    public void addVertexImpl() {
        assertEquals("Testing adding a vertex in Adjacency List",6, adjListGraph.getNumVertices());
        adjListGraph.addVertex();
        assertEquals("Testing adding a vertex in Adjacency List",7, adjListGraph.getNumVertices());
        assertEquals("Testing adding a vertex in Adjacency Matrix",6, adjMatrixGraph.getNumVertices());
        adjMatrixGraph.addVertex();
        assertEquals("Testing adding a vertex in Adjacency Matrix",7, adjMatrixGraph.getNumVertices());
    }

    @Test
    public void testAddEdgeImpl() {
        adjListGraph.addEdge(1,2);
        adjListGraph.addEdge(1,4);
        adjListGraph.addEdge(3,5);
        assertEquals("Testing get neighbors of 1 in Adjacency List",2, adjListGraph.getNeighbors(1).size());

        adjMatrixGraph.addEdge(1,2);
        adjMatrixGraph.addEdge(1,4);
        assertEquals("Testing get neighbors of 1 in Adjacency Matrix",2,adjMatrixGraph.getNeighbors(1).size());
    }

    @Test
    public void testGetNeighbors() {
        assertEquals("Testing get once removed neighbors of 5 in Adjacency List",2, adjListGraph.getNeighbors(5).size());
        assertEquals("Testing get once removed neighbors of 5 in Adjacency Matrix",2, adjMatrixGraph.getNeighbors(5).size());
    }

    @Test
    public void testGetTwiceRemovedNeighbors(){
        assertEquals("Testing get twice removed neighbors of 5 in Adjacency List", Collections.singletonList(3), adjListGraph.getTwoHopNeighbors(5));
        assertEquals("Testing get twice removed neighbors of 5 in Adjacency Matrix",Collections.singletonList(3), adjMatrixGraph.getTwoHopNeighbors(5));
    }

    @Test
    public void testDegreeSequence(){
        assertEquals("Testing degree sequence in Graph", Arrays.asList(3, 2, 2, 1, 1, 1), adjListGraph.degreeSequence());
    }
}