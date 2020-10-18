package app;

import java.util.*;


public class Graph {
	private HashMap<String, HashSet<String>> st;
    private int E;
    
	public Graph(ArrayList<String> dictionary){
        st = new HashMap<String, HashSet<String>>();     
	}

	public int V() {return st.size();}
	public int E() {return E;}

	private void validateVertex(String v) {if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");}

	public int degree(String v) {
			validateVertex(v);
			return st.get(v).size();
	}

	public void addEdge(String v, String w) {
			if (!hasVertex(v)) addVertex(v);
			if (!hasVertex(w)) addVertex(w);
			if (!hasEdge(v, w)) E++;
			st.get(v).add(w);
			st.get(w).add(v);
	}

	public void addVertex(String v) {if (!hasVertex(v)) st.put(v, new HashSet<String>());}


	public Iterable<String> vertices() {return st.keySet();}


	public Iterable<String> adjacentTo(String v) {
			validateVertex(v);
			return st.get(v);
	}

	
	public boolean hasVertex(String v) {return st.containsKey(v);}

	public boolean hasEdge(String v, String w) {
		validateVertex(v);
		validateVertex(w);
		return st.get(v).contains(w);
	}


	public String toString() {
		StringBuilder s = new StringBuilder();
		for (String v : st.keySet()) {
				s.append(v + ": ");
				for (String w : st.get(v)) {
					s.append(w + " ");
				}
			s.append('\n');
		}
		return s.toString();
	}


}
