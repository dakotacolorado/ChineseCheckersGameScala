package ChineseCheckersGame

class Player(var positions: Array[Position]) {
  def applyMove(move: Move, positionIndex: Int): Player = new Player(
    positions.updated(
      positionIndex,
      positions(positionIndex).applyMove(move)
    )
  )

}