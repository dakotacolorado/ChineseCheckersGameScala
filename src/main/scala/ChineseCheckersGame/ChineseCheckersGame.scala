package ChineseCheckersGame

import ChineseCheckersGame.GameState.GameState
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D

class ChineseCheckersGame(numberOfPlayers: Int) {
  require(1 < numberOfPlayers & numberOfPlayers < 7)

  /**
   * Depending on the amount of players a different subset of starting positions will be used.
   */
  private val startingPlayerPositions: Map[Int, List[Int]] = Map(
    2 -> List(1,4),
    3 -> List(1, 3, 5),
    4 -> List(1, 2, 4, 5),
    5 -> List(1, 2, 3, 4, 5),
    6 -> List(1, 2, 3, 4, 5, 6)
  )

  def getNextMoves: Map[Int, Array[(Int, Int)]] = {
    return Map(
      0 -> Array((1,1)),
      1 -> Array((1,1))
    )
  }

  def applyMove(): Any = {

  }

  def getWinningState(playerIndex: Int): Any = {

  }

}
