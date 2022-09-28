package ChineseCheckersGame

import com.google.inject.AbstractModule
import Common.Hexagram


/**
 * <h1>Chinese Checkers Game</h1>
 * To start a new game provide the number of players (2,3,4, or 6). Optionally you can provide a board size (> 0).
 * @param numberOfPlayers Number of players in the game.
 * @param boardSize [4] Inner radius of the hexagram board.
 * @see <a href="https://en.wikipedia.org/wiki/Chinese_checkers">Chinese Checkers Wiki</a>
 * @author Dakota Parker
 */
class ChineseCheckersGame(val players: Array[Player], val boardSize: Int, val turn: Int) extends AbstractModule {

  val hexagram = new Hexagram(boardSize)

  /**
   * Depending on the amount of players a different subset of starting positions will be used.
   */
  private val startingPlayerPositions: Map[Int, Array[Int]] = Map(
    2 -> Array(1, 4),
    3 -> Array(1, 3, 5),
    4 -> Array(1, 2, 4, 5),
    6 -> Array(1, 2, 3, 4, 5, 6)
  )
  def this(numberOfPlayers: Int, boardSize: Int = 4) {
    this(
      startingPlayerPositions(numberOfPlayers).map(
        i => new Player(
          hexagram.hexagramCornerPoints(i).map(
            p => new Position(p._1, p._2)
          ))),
      boardSize,
      0
    )}


  val maxBoardSize = 100
  val maxTurn = 1000
  val maxPlayerCount = 6

  require( 0 < boardSize & boardSize <= maxBoardSize )
  require( 0 < turn & turn <= maxTurn )
  require( 0 < players.length & players.length <= maxPlayerCount )

  /**
   * Represents a bounded int with a fixed length string to uniquely index the game state.
   *
   * @param value coordinate on the game board
   * @return string encoding of coordinate with leading zeros
   */
  def indexBounded(value: Int, memory: Int): String = s"%${memory}s"
    .format(value.toBinaryString)
    .replaceAll(" ", "0")

  /**
   * Each game state needs a unique minimal representation.
   *
   * @return unique string
   */
//  def getGameStateIndex(): String = {
//    return indexBoundedInt(players.length.toShort, maxPlayerCount) +
//      indexBoundedInt(boardSize, maxBoardSize) +
//      indexBoundedInt(turn, maxTurn) +
//      players.map(
//        (player: Player) => player.positions.map(
//          (position: Position) => (
//            indexBoundedInt(position.i, ) + indexBoundedInt(position.j)
//            )
//        ).reduce((p1, p2) => p1 + p2)
//      ).reduce((p1, p2) => p1 + p2)
//  }

  def applyMove(move: Move, playerIndex: Int, positionIndex: Int): ChineseCheckersGame = {
    return new ChineseCheckersGame(
      players.updated(
        playerIndex,
        players(playerIndex).applyMove(move, positionIndex)
      ),
      boardSize,
      turn + 1
    )
  }



}
