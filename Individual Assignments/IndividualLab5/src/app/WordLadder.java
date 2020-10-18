package app;

import java.util.*;
import edu.princeton.cs.introcs.*;

public class WordLadder {
private HashMap<String, String>  prev = new HashMap<String, String>();
private HashMap<String, Integer> dist = new HashMap<String, Integer>();

    //run BFS in graph G from given source vertex s
    public WordLadder(Graph G, String s) {
        ArrayDeque<String> queue = new ArrayDeque<String>();
	    queue.add(s);
        dist.put(s, 0);
            
        while (!queue.isEmpty()) {
            String v = queue.pop();

		    for (String w : G.adjacentTo(v)) {
			    if (!dist.containsKey(w)) {
			        queue.add(w);
			        dist.put(w, 1 + dist.get(v));
			        prev.put(w, v);
                }
            }
        }
    }

    // is v reachable from the source s?
	public boolean hasPathTo(String v) {
		return dist.containsKey(v);
	}

	// return the length of the shortest path from v to s
	public int distanceTo(String v) {
		if (!hasPathTo(v))
			return Integer.MAX_VALUE;
		return dist.get(v);
	}


    //return the length of the shortest path from v to s
    public Iterable<String> pathTo(String v) {
		ArrayDeque<String> path = new ArrayDeque<String>();
		while (v != null && dist.containsKey(v)) {
			path.push(v);
			v = prev.get(v);
		}
		return path;
	}


    //to check if word1 and word2 can be connected on the graph
    public static boolean isNeighbor(String word1, String word2) {
        assert word1.length() == word2.length();
        int differ = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) differ++;
            if (differ > 1) return false;
        }
        return true;
    }



	public static void main(String[] args) {
        //loading the txt and select the 5 letter words to form a dictionary
        String[] words = new In("sowpods.txt").readAllStrings();
        ArrayList<String> dictionary = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
			if (words[i].length()==5) {
				dictionary.add(words[i]);
			}
		}
        
        //create a new graph and load the graph with the words from the dictionary
        Graph G = new Graph(dictionary);
        for (String word1 : dictionary ) {
            for (String word2 : dictionary) {
                if (word1.length() == word2.length()) {
                    if (word1.compareTo(word2) < 0 && isNeighbor(word1, word2)) {
                        G.addEdge(word1, word2);
                    }
                }
            }
        }
            
        //initialize BFS
        WordLadder pf = new WordLadder(G, args[0]);

        //print the shortest path
        String t = args[1];
		for (String v : pf.pathTo(t)) {
				System.out.println("  " + v);
        }
            
	}

}
