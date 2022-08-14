package RuleEngine
/**
 * <h1><code>Vector2D</code></h1>
 * Description: <a href="https://en.wikipedia.org/wiki/Euclidean_vector">Euclidean Vector</a> of size 2.
 *
 * @author Dakota Parker
 * @deprecated
 */
class Vector2DArchive(val i: Int, val j: Int) {
  /**
   * <b>Equality</b>
   *
   * @param that vector to compare.
   * @return aggregated equality of the vector element pairs.
   */
  def == (that: Vector2DArchive): Boolean = this.i == that.i & this.j == that.i

  /**
   * <b>Vector Addition</b>
   *
   * @param that vector to add.
   * @return element-wise addition of the vectors.
   */
  def + (that: Vector2DArchive): Vector2DArchive = new Vector2DArchive(this.i + that.i, this.j + that.j)

  /**
   * <b>Vector Subtraction</b>
   *
   * @param that vector to subtract.
   * @return element-wise subtraction of the vectors.
   */
  def -(that: Vector2DArchive): Vector2DArchive = new Vector2DArchive(this.i - that.i, this.j - that.j)

  /**
   * <b>Scalar Multiplication</b>
   * <p>A vector may be multiplied, or re-scaled, by an integer.</p>
   *
   * @param scalar scalar integer to multiply.
   * @return element-wise multiplication of scalar on vector.
   */
  def * (scalar: Int) = new Vector2DArchive(this.i*scalar, this.j*scalar)



}
