package arbres;

import graphe.Ville;

import java.util.HashMap;

import carte.Carte;

// Q1

public class UnionFind {
	//parent relation, parent.put(src,dst) indicates that src points to dst
    private HashMap<Ville,Ville> parent;

    public UnionFind(){
    	parent=new HashMap<Ville,Ville>();
        }
    
    public Ville find( Ville src ){
    	Ville ville=src;
    	int distance=0;
    	while (parent.get(ville)!=null && !parent.get(ville).equals(ville)) {
    		ville=parent.get(ville);
    		distance++;}
    	if (parent.get(ville)!=null &&distance>2) {
    		parent.put(src, ville);
    	}
    	if (parent.get(ville)==null) {
    		parent.put(ville, ville);
    	}
    	return ville;
    }
    
    public void union( Ville v0, Ville v1 ){
        Ville father0=find(v0);
        Ville father1=find(v1);
        parent.put(father0, father1);
    }
}
