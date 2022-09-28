package ChineseCheckersGame


class Position(var i: Int, var j: Int) {
  def applyMove(move: Move): Position = new Position(move.i + i, move.j + j)


}

