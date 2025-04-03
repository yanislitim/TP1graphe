import static org.junit.Assert.assertEquals;

import java.lang.reflect.Executable;
import org.jgrapht.*;
import org.jgrapht.graph.DefaultEdge;
import org.junit.Test;
import org.junit.*;

public class ProprietesGraphTest {
    @Test
    public void testGetString(){
        Graph<String, DefaultEdge> g = Executable.exo1;
        System.out.println(g);
        ProprietesGraph p = new ProprietesGraph();
        String s = "{a,b,c,d,e}, {a--b,a--c,b--c,c--d,d--e}";
        assertEquals(s, p.getString(g));
    }
}