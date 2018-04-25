import java.util.*;
public class RandomPlayer extends Player {
    public RandomPlayer (String name) {
        super(name);
    }
    
    public String getNextMove(GameState state) {
        ArrayList<String> moves = state.getCurrentMoves();
        if (moves.size() == 0) return "no move";
        return moves.get((int) (Math.random() * moves.size()));
    }
}