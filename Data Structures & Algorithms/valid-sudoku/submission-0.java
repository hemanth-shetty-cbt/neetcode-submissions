class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] box = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char c = board[i][j];
                if (c == '.') continue;          
                // skip empty cells

                int boxIndex = (i / 3) * 3 + (j / 3);

                // If already present in ANY of the three groups → invalid
                if (rows[i].contains(c) ||
                    cols[j].contains(c) ||
                    box[boxIndex].contains(c)) {
                    return false;
                }

                // Otherwise record it in all three
                rows[i].add(c);
                cols[j].add(c);
                box[boxIndex].add(c);
            }
        }
        return true;
    }
}
