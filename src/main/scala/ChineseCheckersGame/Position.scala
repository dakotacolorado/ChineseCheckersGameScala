package ChineseCheckersGame

/**
 * A <b>Position</b> in the {@link ChineseCheckersGame} is a 2d-Vector within a {@link Common.Hexagram} lattice.
 * @param i coordinate 1
 * @param j coordinate 2
 */
class Position(var i: Int, var j: Int) {
  /**
   * A {@link Player} can {@link Move} a <b>Position</b>.
   * @param move {@link Move} the player wants to make
   * @return <b>Position</b> with updated coordinates
   */
  def makeMove(move: Move): Position = new Position(move.i + i, move.j + j)

}

