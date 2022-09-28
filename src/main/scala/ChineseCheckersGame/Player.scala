package ChineseCheckersGame

/**
 * A <b>Player</b> has a set of {@link Position}s on the board.
 * @param positions {@link Position}s of the player
 */
class Player(var positions: Array[Position]) {
  /**
   * A <b>Player</b> can make their {@link Move} and change one of their {@link Position}s on the board.
   * @param move {@link Move} the player wants to make
   * @return <b>Player</b> with updated {@link Position}s
   */
  def makeMove(move: Move): Player = new Player(
    positions.map(
      (p: Position) => (if (p == move.position) move.position.makeMove(move) else p)
    )
  )
}