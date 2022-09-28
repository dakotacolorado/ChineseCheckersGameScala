package Common

/**
 * <h1><code>ShortVector2D</code></h1>
 * Description: <a href="https://en.wikipedia.org/wiki/Euclidean_vector">Euclidean Vector</a> of size 2 with Short values.
 *
 * @author Dakota Parker
 */
class ShortVector2D(val i: Short, val j: Short) {
  /**
   * <b>Equality</b>
   *
   * @param that vector to compare.
   * @return aggregated equality of the vector element pairs.
   */
  def == (that: ShortVector2D): Boolean = this.i == that.i & this.j == that.i

  /**
   * <b>Vector Addition</b>
   *
   * @param that vector to add.
   * @return element-wise addition of the vectors.
   */
  def + (that: ShortVector2D): ShortVector2D = new ShortVector2D((this.i + that.i).toShort, (this.j + that.j).toShort)

  /**
   * <b>Vector Subtraction</b>
   *
   * @param that vector to subtract.
   * @return element-wise subtraction of the vectors.
   */
  def -(that: ShortVector2D): ShortVector2D = new ShortVector2D((this.i - that.i).toShort, (this.j - that.j).toShort)

  /**
   * <b>Scalar Multiplication</b>
   * <p>A vector may be multiplied, or re-scaled, by an integer.</p>
   *
   * @param scalar scalar integer to multiply.
   * @return element-wise multiplication of scalar on vector.
   */
  def * (scalar: Short) = new ShortVector2D((this.i*scalar).toShort, (this.j*scalar).toShort)

}
