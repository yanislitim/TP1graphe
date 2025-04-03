package fr.iut45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.AttributeType;
import org.jgrapht.nio.DefaultAttribute;
import org.jgrapht.nio.csv.CSVFormat;
import org.jgrapht.nio.csv.CSVImporter;
import org.jgrapht.nio.dot.DOTExporter;
import org.jgrapht.util.SupplierUtil;

public class Executable {

public static Graph<String, DefaultEdge> loadHeroes() {
Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(SupplierUtil.createStringSupplier(1),
SupplierUtil.DEFAULT_EDGE_SUPPLIER, false);
CSVImporter<String, DefaultEdge> importer = new CSVImporter<>(CSVFormat.EDGE_LIST);
importer.setVertexFactory(id -> id);
importer.importGraph(graph, new File("extrait_marvel.csv"));
return graph;
} 

public static Graph<String, DefaultEdge> SimpleGraph() {
Graph<String, DefaultEdge> graph = new DefaultUndirectedGraph<>(SupplierUtil.createStringSupplier(1),
SupplierUtil.DEFAULT_EDGE_SUPPLIER, false);
return graph;
} 

public static void main(String[] args) throws IOException {
Graph<String, DefaultEdge> graph;
/*
 * graph = loadHeroes();
System.out.println(graph);
Set<String> inactifs = new HashSet<>();
for( String v : graph.vertexSet()){
if(graph.degreeOf(v)<40)
inactifs.add(v);
}
graph.removeAllVertices(inactifs);
 * 
 */
graph = new SimpleGraph<>(DefaultEdge.class);
graph.addVertex("a"); // pour ajouter un noeud
graph.addVertex("b"); // pour ajouter un noeud
graph.addVertex("c"); // pour ajouter un noeud
graph.addVertex("d"); // pour ajouter un noeud
graph.addVertex("e"); // pour ajouter un noeud

graph.addEdge("a","b"); // pour ajouter une arête
graph.addEdge("b","c"); // pour ajouter une arête
graph.addEdge("a","c"); // pour ajouter une arête
graph.addEdge("c","d"); // pour ajouter une arête
graph.addEdge("d","e"); // pour ajouter une arête


DOTExporter<String, DefaultEdge> exporter = new DOTExporter<String, DefaultEdge>();
exporter.setVertexAttributeProvider((x) -> Map.of("label", new DefaultAttribute<>(x, AttributeType.STRING)));
exporter.exportGraph(graph, new FileWriter("graph.dot"));
}

}