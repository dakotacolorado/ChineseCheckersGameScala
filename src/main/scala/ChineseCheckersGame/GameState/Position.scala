package ChineseCheckersGame.GameState

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D

class Position(i: Int, j: Int) extends Vector2D(i, j){
  def getPositionIndex(): String = {
    return "1"
  }
}

