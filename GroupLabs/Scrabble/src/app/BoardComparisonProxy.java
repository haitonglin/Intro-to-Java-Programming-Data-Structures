package app;

import java.util.ArrayList;

public class BoardComparisonProxy implements Board {
    private ArrayList<Board> boardlist = new ArrayList<>();
    private int num;

    public BoardComparisonProxy(final ArrayList<Board> boardlist){
        this.boardlist = boardlist;
        num = boardlist.size();
    }

    @Override
    public void setupNewBoard(String wordListFilename, int rows, int columns) {
        for (int i =0; i<num; i++){
        boardlist.get(i).setupNewBoard(wordListFilename, rows, columns);}
    }

    @Override
    public int getRows() {
        // Error: -1
        for (int i =1; i<num; i++){
            int check=boardlist.get(i).getRows();
            if (check != boardlist.get(0).getRows()){return -1;}
        }
        return boardlist.get(0).getRows();
    }

    @Override
    public int getColumns() {
        // Error: -1
        for (int i =1; i<num; i++){
            int check=boardlist.get(i).getColumns();
            if (check != boardlist.get(0).getColumns()){return -1;}
        }
        return boardlist.get(0).getRows();
    }

    @Override
    public char getLetterAt(int row, int col) {
        // Error: X
        for (int i =1; i<num; i++){
            char check=boardlist.get(i).getLetterAt(row, col);
            if (check != boardlist.get(0).getLetterAt(row, col)){return 'X';}
        }
        return boardlist.get(0).getLetterAt(row, col);
    }

    @Override
    public String playWord(Play p, boolean dryRunOnly) {
        // Error: Error
        String[] output = new String[num]; //check return
        String[] currentboards = new String[num]; //check board
        for (int i =0; i<num; i++){
            output[i]=boardlist.get(i).playWord(p, dryRunOnly); //run all playWord
            currentboards[i] = boardlist.get(i).toString();
        }
        for (int i =1; i<num; i++){
            if (output[i] !=null && output[i-1] !=null && currentboards[i] !=null &&currentboards[i] !=null){
                if (output[i].equals(output[i-1]) && currentboards[i].equals(currentboards[i-1])){return output[0];}
            }//return != null; board != null
            if (output[i] !=null && output[i-1] !=null && currentboards[i] ==null &&currentboards[i] ==null){
                if (output[i].equals(output[i-1])){return output[0];}
            }//return != null; board == null
            if (output[i] ==null && output[i-1] ==null && currentboards[i] !=null &&currentboards[i] !=null){
                if (currentboards[i].equals(currentboards[i-1])){return output[0];}
            }//return == null; board != null
            if (output[i] ==null && output[i-1] ==null && currentboards[i] ==null &&currentboards[i] ==null){return null;} //return == null; board == null           
        }
        return "Error";
    }

    public String toString(){
        String s = "";
        for (int i =0; i<num; i++){
            s+= boardlist.get(i);
            s+= "\n";
        }
        return s;
    }
}