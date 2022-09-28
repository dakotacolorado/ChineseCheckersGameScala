package ChineseCheckersGame

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D

/**
 * A <b>Move</b> in the {@link ChineseCheckersGame} is a 2d-Vector representing the change of a {@link Position}.
 *
 * @param i change in i coordinate
 * @param j change in j coordinate
 * @param position {@link Position} the <b>Move</b> is applied to
 */
class Move(val i: Int, val  j: Int, val position: Position) extends Vector2D(i, j)