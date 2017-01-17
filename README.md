# LinkBetweenTown
Implementation of Dijkstra's algorithm

We will implement algorithms over a particular type of graph, where nodes
represent cities on a map and arcs are drawn between neighbouring cities (adjacencies are
not determined by road connections, but instead by the geodesic distance, precisely two
cities are considered as adjacent if their geodesic distance is smaller than a certain maximal
value).Two classical algorithms are implemented, Kruskal’s algorithm and
Prim’s algorithm. They find the minimum spanning tree in each connected component of
the graph of cities, whose arcs are weighted by the geodesic distance.

The class Ville represents a city on the map by its name and coordinates (latitude,
longitude).
The class Arc represents a link between two neighbouring cities.
The class ArcComparator compares two Arc objects according to their length.
The class GrapheEuclidien represents a graph with all the cities on a map as vertices
and arcs between close neighbors (based on geodesic distance.)

How to use the code: Download Dijkstra.zip and unzip it within a
Java project (within the src folder if the project has one). This will create three packages
called arbres, carte and graphe, and a Test class. Assume fr.txt is in the root of your folder.
In the Main class execute:
-- test2() to give the result of Kruskal's algorithm: arcs in the minimum spanning forest are in orange on the map.
-- test3() to give the components of the previous forest
-- test4(ville V) to use Prim's algorithm to build the minimum spanning tree beginning with V.
-- test5() to do the same with a forest.
