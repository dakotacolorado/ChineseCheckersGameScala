import org.apache.commons.math3.geometry.euclidean.twod.Vector2D

class Position(var i: Short, var j: Short) extends Vector2D(i, j){
  def + (that: Position): Position = new Position(
    (this.i + that.i).toShort,
    (this.j + that.j).toShort
  )

}

var p = new Position(1,1)
var q = new Position(2,2)

p + q).i