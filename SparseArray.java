import java.util.List;
import java.util.ArrayList;
public class SparseArray {
    private int numRows;
    private int numCols;
    
    private List<SparseArrayEntry> entries;
    
    public SparseArray() {
        entries = new ArrayList<>();
    }
    
    public int getNumRows() { return numRows; }
    public int getNumCols() { return numCols; }
    
    public int getValueAt(int row, int col) {
        for (SparseArrayEntry a : entries) {
            if (row == a.getRow() && col == a.getCol()) {
                return a.getValue();
            }
        }
        return 0;
    }
    
    public void removeColumn(int col) {
        for (int i = 0; i < entries.size(); i++) {
            SparseArrayEntry a = entries.get(i);
            if (a.getCol() == col) {
                entries.remove(a);
                i--;
            } else if (a.getCol() > col) {
                entries.set(i, new SparseArrayEntry(a.getRow(), a.getCol() - 1, a.getValue()));
            }
        }
        numCols--;
    }
}