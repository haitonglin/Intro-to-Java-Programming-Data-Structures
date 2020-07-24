package app;

import edu.princeton.cs.introcs.In;

public class SmartBoard implements Board{
    private String[] lines;
    private char[][] board;
    private int rows;
    private int columns;

    public SmartBoard(){}

    public void setupNewBoard(String wordListFilename, int rows, int columns){
		lines = new In(wordListFilename).readAllStrings();
        this.rows = rows; this.columns = columns;
        board = new char[rows][columns];
    }

    public String toString() {
        String s = "";
        for (int i =0; i< rows; i++){
            for (int j =0; j< columns; j++){
                if (board[i][j]==0){s+="_";}
                else {s+=board[i][j];}
            }
            s= s+ "\n";
        }
        return s;
    }
    
    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public char getLetterAt(int row, int col){
        if (board[row][col]==0) return '0';
        else return board[row][col];
    }

    
    public String playWord(Play p, boolean dryRunOnly){
        
        char[][] copy = new char[rows][columns];
        boolean heshi =false; String s = ""; String output = "";
        for (int i =0; i<rows; i++){
            for (int j =0; j<columns; j++){
                if (board[i][j]==0){copy[i][j]='_';}
                else {copy[i][j]= board[i][j];}
            }
        }

        if (p.isVertical()==true){
            if(p.getWord().length()>(rows-p.getRow())) {return null;}
                for (int i =0; i< p.getWord().length(); i++){
                    if(copy[p.getRow()+i][p.getCol()]=='_'){
                        copy[p.getRow()+i][p.getCol()]=Character.toLowerCase(p.getWord().charAt(i));
                        output += copy[p.getRow()+i][p.getCol()];}
                    else if (copy[p.getRow()+i][p.getCol()]!='_' && copy[p.getRow()+i][p.getCol()]!= Character.toLowerCase(p.getWord().charAt(i))){return null;}
                }
        }
        else {
            if(p.getWord().length()>(columns-p.getCol())) {return null;}
                for (int i =0; i< p.getWord().length(); i++){
                    if(copy[p.getRow()][p.getCol()+i]=='_'){copy[p.getRow()][p.getCol()+i]=Character.toLowerCase(p.getWord().charAt(i));
                    output+= copy[p.getRow()][p.getCol()+i];}
                    else if (copy[p.getRow()][p.getCol()+i]!='_' && copy[p.getRow()][p.getCol()+i]!= Character.toLowerCase(p.getWord().charAt(i))){return null;}
                }
        }

        for (int i =0; i<rows; i++){
            for (int j =0; j<columns; j++){
                if (copy[i][j]==0){s+="_";}
                else {s = s+ copy[i][j];}
            }
            s = s+ "_";
        }

        for (int i =0; i<columns; i++){
            for (int j =0; j<rows; j++){
                if (copy[j][i]==0){s+="_";}
                else {s = s+ copy[j][i];}
            }
            s = s+ "_";
        }
        
        String[] allwords = s.split("_");
        for (int i =0; i < allwords.length; i++){
            if (allwords[i].length()>1){
                heshi = findit(allwords[i],lines);
                if (heshi == false){break;}
            }
        }

        if (dryRunOnly == false && heshi ==true){board = copy; return output;}
        else if (dryRunOnly == false && heshi ==false){return null;}
        else if (dryRunOnly == true && heshi ==true){return output;}
        else {return null;}
    }

    public boolean findit(String word, String[] list){
        return findit(word, list, 0, list.length);
    }
    
    public boolean findit(String word, String[] list, int a, int b){
        if (b<=a) return false;
            int mid = a + (b-a)/2;
            int cmp = list[mid].compareTo(word);
            if (cmp>0) {return findit(word, list, a , mid);}
            else if (cmp<0) {return findit(word,list,mid+1,b);}
            else {return true;}
        }

}