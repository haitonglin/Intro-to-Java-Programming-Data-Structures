package app;

class Genome{
    //instance variables
    private int numberofnu;
    private boolean[] genoarray;
    
    //constructor
    public Genome(String genome) {
        numberofnu = genome.length();  //numberofnu is a count (1 based)
        genoarray= new boolean[genome.length()*2]; 
        for (int i = 0; i < genome.length(); i++){
            if (genome.charAt(i) == 'A') {genoarray[2*i] = true; genoarray[2*i+1] = true;}
            else if (genome.charAt(i) == 'T') {genoarray[2*i] = true; genoarray[2*i+1] = false;}
            else if (genome.charAt(i) == 'C') {genoarray[2*i] = false; genoarray[2*i+1] = true;}
            else if (genome.charAt(i) == 'G') {genoarray[2*i] = false; genoarray[2*i+1] = false;}
        }
    }

    //method 1
    public void addNucleotide(char nucleotide){ 
        //doubling the length once filled up
        if (this.numberofnu * 2 == this.genoarray.length) {
            boolean[] newArray = new boolean[this.genoarray.length * 2];
            for (int i = 0; i < this.genoarray.length; i++){
                newArray[i] = this.genoarray[i];
            }
            this.genoarray = newArray;
        }       
        //adding the nucleotide in
        if (nucleotide == 'A') {
            this.genoarray[2 * numberofnu] = true;
            this.genoarray[2 * numberofnu + 1] = true;
            numberofnu += 1;
        }
        if (nucleotide == 'T') {
            this.genoarray[2 * numberofnu] = true;
            this.genoarray[2 * numberofnu + 1] = false;
            numberofnu += 1;
        }
        if (nucleotide == 'C') {
            this.genoarray[2 * numberofnu] = false;
            this.genoarray[2 * numberofnu + 1] = true;
            numberofnu += 1;
        }
        if (nucleotide == 'G') {
            this.genoarray[2 * numberofnu] = false;
            this.genoarray[2 * numberofnu + 1] = false;
            numberofnu += 1;
        }
    }


    //method 2
    public char nucleotideAt(int j){  //int j is an index (0 based)
        char nu = '0';
        if (genoarray[2*j] && genoarray[2*j+1]) {nu = 'A';} 
        else if (genoarray[2*j] && !genoarray[2*j+1]) {nu = 'T';}
        else if (!genoarray[2*j] && genoarray[2*j+1]) {nu = 'C';}
        else if (!genoarray[2*j] && !genoarray[2*j+1]) {nu = 'G';}
        return nu;
    }

    //method 3
    public boolean isPotentialGene(){ 
        //convert boolean[] back to a string
        String genostring = ""; 
        for (int i = 0; i < numberofnu; i++) { //int i is an index (0 based)
            if (genoarray[2*i] && genoarray[2*i+1]) genostring += "A";
            else if (genoarray[2*i] && !genoarray[2*i+1]) genostring += "T";
            else if (!genoarray[2*i] && genoarray[2*i+1]) genostring += "C";
            else if (!genoarray[2*i] && !genoarray[2*i+1]) genostring += "G";
        }

        /** decide if it is potential gene
         *  CITATION: I have referred to program3.1.1 on the textbook
         because I'm not very sure when it will be gene*/

        if (genostring.length() % 3 != 0) return false;
        if (!genostring.startsWith("ATG")) return false;
        for (int i = 3; i < genostring.length() - 3; i++){
            if (i % 3 == 0){
                String codon = genostring.substring(i, i+3);
                    if (codon.equals("TAA")) return false;
                    if (codon.equals("TAG")) return false;
                    if (codon.equals("TGA")) return false;
            }
        }
        if (genostring.endsWith("TAA")) return true;
        if (genostring.endsWith("TAG")) return true;
        if (genostring.endsWith("TGA")) return true;

        return false;
    }


    //method 4
    public boolean isWatsonCrickPalindrome(){
        //convert boolean[] back to a string
        String genostring = ""; 
        for (int i = 0; i < numberofnu; i++) { //int i is 0 based
            if (genoarray[2*i] && genoarray[2*i+1]) genostring += "A";
            else if (genoarray[2*i] && !genoarray[2*i+1]) genostring += "T";
            else if (!genoarray[2*i] && genoarray[2*i+1]) genostring += "C";
            else if (!genoarray[2*i] && !genoarray[2*i+1]) genostring += "G";
        }
        //get the Watson-Crick complement
        String complement = "";
        for (int i = 0; i < genostring.length(); i++){
            char ch = genostring.charAt(i);
            if (ch == 'A') complement += "T";
            else if (ch == 'C') complement += "G";
            else if (ch == 'T') complement += "A";
            else if (ch == 'G') complement += "C";
        }
        /** get the reverse complement
         * CITATION: I have referred to the following page since I didn't know how to reverse String
         * https://moometric.com/development/java/reverse-a-string-in-java/ */

         StringBuilder reverse = new StringBuilder(complement);
         String reversecom = reverse.reverse().toString();

        return reversecom.equals(genostring);
    }

    //test client
    public static void main(String[] args) {
        Genome test = new Genome("AGC");
        //Genome test = new Genome("ATGCGCCTGCGTCTGTACTAG");
        test.addNucleotide('T');
        System.out.println("The nucleotide at 2 is: " + test.nucleotideAt(2));
        System.out.println("Can the genome be gene? " + test.isPotentialGene());
        System.out.println("Is it a Watson-Crick Palindrome? " + test.isWatsonCrickPalindrome());
    }
}