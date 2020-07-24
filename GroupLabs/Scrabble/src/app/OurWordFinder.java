package app;

import java.util.*;
import edu.princeton.cs.introcs.In;

public class OurWordFinder implements WordFinder{
    private HashMap<String, LinkedList<String>> wordmap = new HashMap<>();
    private static ArrayList<String> letterseq = new ArrayList<>();


    public void setupIndex(String wordListFilename, int maxWordLength) {
      In wordfile = new In("sowpods.txt");
        String[] words = wordfile.readAllLines();
        for (int i = 0; i < words.length; i++){
            if ( words[i].length() <= maxWordLength) addword(words[i]);
        }

    }


    public static String sortletters(String word){
        char[] wordarray = word.toCharArray();
        Arrays.sort(wordarray);
        String output = "";
        for (char c : wordarray){
            output += c;
        }
        return output;
    }


    public void addword(String word){
        String key = "";
        for (int i = 0; i < word.length(); i++){
            //take the letter in the key out from the word
            String withoutl = word.substring(0, i) + word.substring(i+1, word.length());
            String sortedletters = sortletters(withoutl);
            //constructing key
            key = word.charAt(i) + "_" + i + "_" + sortedletters;
            //if key exist, add value; otherwise create new key-value pair
            if (wordmap.containsKey(key)) { wordmap.get(key).add(word);}
            else {
                LinkedList<String> value = new LinkedList<>();
                value.add(word);
                wordmap.put(key, value);
            }

        }
    
    }

    

public SortedSet<Candidate> findCandidates(Board board, List<String> lettersInHand) {
    SortedSet<Candidate> candidates = new TreeSet<>();
    letterseq.clear();

    ArrayList<String> suoyou = suoyou(lettersInHand);

    //unsure about the empty is 0 or '0'
    char empty = board.getLetterAt(0, 0); 

    for (int i = 0; i < board.getRows(); i++){
        for (int j = 0; j < board.getColumns(); j++){

            if (board.getLetterAt(i, j) != empty) {
                //horizontal
                for (int k = 0; k < j ; k++){ //check by column
                    for (int l = 0; l < suoyou.size(); l++){ //check each possible key
                        String key = "";
                        key += board.getLetterAt(i, j) + "_" + (j-k) + "_" + suoyou.get(l); //construct key

                        if (wordmap.containsKey(key)){

                            List<String> temp = new LinkedList<>();
                            temp = wordmap.get(key); //get all the possible words with the same key

                            for (String s : temp){ //check all possibilities
                                Play play = new Play(i, k, s, false); //false: horizontal
                                if ((k+s.length()) <= board.getColumns()){
                                
                                    String pw = board.playWord(play, true);
                                    if (pw != null){candidates.add(new Candidate(play, pw));} //add in candidate
                                }
                            }
                        }
                    }
                }

                //vertical
                //the process is almost identical as above
                for (int k = 0; k < i ; k++){
                    for (int l = 0; l < suoyou.size(); l++){

                        String key = "";
                        key += board.getLetterAt(i, j) + "_" + (i-k) + "_" + suoyou.get(l);

                        if (wordmap.containsKey(key)){

                            List<String> temp = new LinkedList<>();
                            temp = wordmap.get(key);

                            for (String s : temp){
                                Play play = new Play(k, j, s, true); //vertical
                                if ((k+s.length()) <= board.getRows()){

                                    String pw = board.playWord(play, true); 
                                    if (pw != null){candidates.add(new Candidate(play, pw));}
                                }
                            }
                        }
                    }
                }
            }
        }    
    }
    
    return candidates;
}

    
    public  ArrayList<String> suoyou (List<String> lettersInHand){
        String letters = "";
        for (String s : lettersInHand) {
            letters += s;
        }

       String lettersinorder =sortletters(letters);

       List<Character> data = new ArrayList<>();
        for (int i = 0; i < lettersinorder.length(); i++){
            data.add(lettersinorder.charAt(i));
        }
    
       for(int i = 1; i < data.size(); i++)
       selection(data, new ArrayList<Character>(), data.size(), i);

       return letterseq;
    }

    
    public  static void selection(List<Character> charlist, List<Character> cl2, int n, int k) {
		List<Character> newcharlist;
        List<Character> copyWorkSpace;
        String s = "";
		if(cl2.size() == k) {
            for(Character c : cl2)
                s +=c;
                s = sortletters(s);
                letterseq.add(s);
		}
		for(int i = 0; i < charlist.size(); i++) {
			newcharlist = new ArrayList<Character>(charlist);
			copyWorkSpace = new ArrayList<Character>(cl2);
			
			copyWorkSpace.add(newcharlist.get(i));
			for(int j = i; j >=  0; j--)
				newcharlist.remove(j);
			selection(newcharlist, copyWorkSpace, n, k);
		}
		
	}


}
