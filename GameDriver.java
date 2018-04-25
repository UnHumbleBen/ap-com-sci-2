public class GameDriver {
    private GameState state;
    
    public GameDriver(GameState initial) {
        state = initial;
    }
    
    public void play() {
        System.out.println(state);
        while (!state.isGameOver()) {
            Player currentPlayer = state.getCurrentPlayer();
            String nextMove = currentPlayer.getNextMove(state);
            System.out.println(currentPlayer.getName());
            System.out.println(nextMove);
            state.makeMove(nextMove);
        }
        Player winner = state.getWinner();
        if (winner != null) {
            System.out.println(winner.getName() + " wins");
        } else {
            System.out.println("Game ends in a draw");
        }
    }
}