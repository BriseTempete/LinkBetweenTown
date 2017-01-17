package arbres;

import java.util.*;

import graphe.*;

public class SpanningTree {
    
    public static Collection<Arc> kruskal(UnionFind u, GrapheEuclidien g){
    	List<Arc> col=new LinkedList<Arc>();
    	List<Arc> allArc=g.tousLesArcs();
    	Comparator<Arc> ac=new ArcComparator();
    	Collections.sort(allArc,ac);
    	for (Arc e : allArc) {
    		if (!u.find(e.source).equals(u.find(e.target))) {
    			u.union(e.source,e.target);
    			col.add(e);
    			}
    		}
    	return col;
    }
    
    public static Collection<Collection<Arc>> kruskal(GrapheEuclidien g){
    	HashMap<Ville,Collection<Arc>> arcList=new HashMap<Ville,Collection<Arc>>();
    	UnionFind u=new UnionFind();
    	Collection<Arc> raw=kruskal(u,g);
    	for (Arc e :raw) {
    		if (arcList.get(u.find(e.source))==null) {
    			Collection<Arc> L=new LinkedList<Arc>();
    			arcList.put(u.find(e.source), L);  			
    			arcList.get(u.find(e.source)).add(e);
    		}
    		else {
    			arcList.get(u.find(e.source)).add(e);
    		}
    	}
    	return arcList.values();
    }
    
    public static Collection<Arc> primTree(HashSet<Ville> nonVisited, Ville start, GrapheEuclidien g){
    	Collection<Arc> col=new LinkedList<Arc>();
    	Comparator<Arc> comparator = new ArcComparator();
    	int taille=nonVisited.size();
    	PriorityQueue<Arc> q=new PriorityQueue<Arc>(taille,comparator);
    	List<Arc> begin=g.arcsSortant(start);
    	for (Arc e:begin) {
    		q.add(e);
    	}
    	nonVisited.remove(start);
    	while (q.size()!=0) {
    		Arc a=q.poll();
    		Ville u=a.target;
    		if (nonVisited.contains(u)) {
    			nonVisited.remove(u);
    			col.add(a);
    			for (Arc e:g.arcsSortant(u)) {
    				q.add(e);
    			}
    		}
    		
    	}
    	return col;
    }
    
    public static Ville getOne(HashSet<Ville> hv) {
    	List<Ville> list = new ArrayList<Ville>(hv);
    	return list.get(0);
    }
    public static Collection<Collection<Arc>> primForest(GrapheEuclidien g){
    	HashSet<Ville> nonVisited=new HashSet<Ville>();
    	Collection<Collection<Arc>> output=new LinkedList<Collection<Arc>>();
    	for (Ville v:g.villes()) {
    		nonVisited.add(v);
    	}
    	while (nonVisited.size()>0) {
    		Ville v=getOne(nonVisited);
    		Collection<Arc> col=primTree(nonVisited,v,g);
    		if (col.size()>0) {
    			output.add(col);
    		}
    		for (Arc a:col) {
    			nonVisited.remove(a.source);
    			nonVisited.remove(a.target);
    		}
    	}
    	return output;
    }
    
   
}
