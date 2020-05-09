import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        for(int i = 0; i<3; ++i){
            char[] chars = new char[3];
            for(int j = 0; j<3; ++j){
                char c = board[i][j];
                chars[j] = c;
            }
            System.out.println(chars);
        }
        System.out.println("===============================================");


        System.out.println(longestConsecutive(board));
    }
    public static char[][] longestConsecutive(char[][] board) {
        List<Integer> storedValues = null;
        for(int i = 0; i<3; ++i){
            storedValues = new ArrayList<>();
            for(int j = 0; j<3; ++j){
                if(board[i][j] != '.'){
                   storedValues.add(Integer.parseInt(Character.toString(board[i][j])));
               } else {
                   // go though the row values
                   storedValues.addAll(getAllRowElements(board, i, j+1));
                   //go through the column values
                   storedValues.addAll(getAllColumnsElements(board, 0, j));

                   //go through the remaing 4 positions in the sub-box
                   storedValues.addAll(getAllRemainingSubBoxValues(board, i, j));

                 //  System.out.println("for item "+i+","+j);
                   // append the first value not exisitng in storedValues as a solution to this position
                   board[i][j] = getPositionCharacters(storedValues);
                    System.out.println("board["+i+"]["+j+"] :"+board[i][j]);

                    //Add the new value to storedValues
                   storedValues.add(Integer.parseInt(Character.toString(board[i][j])));
                }
            }
        }
        for(int i = 0; i<3; ++i){
            char[] chars = new char[3];
            for(int j = 0; j<3; ++j){
                char c = board[i][j];
                chars[j] = c;
            }
            System.out.println(chars);
        }
        return board;
    }

    private static char getPositionCharacters(List<Integer> storedValues) {
        char res = ' ';
        for(int i=1; i<=9;++i){
            if(!storedValues.contains(i)){
                res = String.valueOf(i).charAt(0);
            }else
                System.out.print(i + " | ");

        }
        System.out.println();

        return res;
    }

    private static List<Integer> getAllRemainingSubBoxValues(char[][] board, int row, int col) {
        List<Integer> storedValues  = new ArrayList<>();
        for(int i=0; i<3;++i) {
            if(i != row ){
                for(int j=0; j<3;++j) {
                    if(j != col){
                    if(board[i][j] != '.'){
                        int val = Integer.parseInt(Character.toString(board[i][j]));
                        storedValues.add(val);
                    }
                }
            }
            }
        }
        return storedValues;
    }

    private static List<Integer> getAllRowElements(char[][] board, int istart, int jstart){
        List<Integer> storedValues = new ArrayList<>();
        while(jstart < 9) {
            if (board[istart][jstart] != '.') {
                int val = Integer.parseInt(Character.toString(board[istart][jstart]));
                storedValues.add(val);
            }
            jstart++;
        }
        return storedValues;
    }

    private static List<Integer> getAllColumnsElements(char[][] board, int istart, int jstart){
        List<Integer> storedValues = new ArrayList<>();
        while(istart<9) {
            if (board[istart][jstart] != '.') {
                int val = Integer.parseInt(Character.toString(board[istart][jstart]));
                storedValues.add(val);
            }
            istart++;
        }
        return storedValues;
    }

}
