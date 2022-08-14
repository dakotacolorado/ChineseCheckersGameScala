package ChineseCheckersGame
/**
 * <h1>Hexagram</h1>
 * @param radius distance from the center to the inner corner.
 * @see <a href="https://en.wikipedia.org/wiki/Hexagram">Hexagram Wiki</a>
 * @author Dakota Parker
 */
class Hexagram(radius: Int = 4) {
  require(0 < radius)
  /**
   * The regular hexagon points are the 6 corners of a regular hexagon written in the following 2d basis:
   * <ul>
   *  <li>u1 = [1, 0]</li>
   *  <li>u2 = [1/2, Sqrt(3)/2]</li>
   * </ul>
   */
  final val regularHexagonPoints: Array[(Int, Int)] = Array(
    (1, 0), (0, 1), (-1, 1), (-1, 0), (0, -1), (1, -1)
  )

  /**
   * The regular hexagon edges are the lines between nodes of a regular hexagon.  These vector pairs represent six
   * different basis sets for the hexagon.
   */
  private final val regularHexagonEdges: Array[((Int, Int), (Int, Int))] = this.regularHexagonPoints.zipWithIndex.map(
    (point: ((Int, Int), Int)) => (
      point._1,
      this.regularHexagonPoints((point._2 + 1) % 6)
    )
  )

  /**
   * The rhombus grid is the grid of nodes within an regular rhombus where the diagonal length is the hexagram radius.
   */
  //noinspection MapFlatten
  private final val rhombusGrid: Array[(Int, Int)] = (0 to this.radius).map(
    (i: Int) => (1 to this.radius).map(
      (j: Int) => (i, j)
    )
  ).flatten.toArray

  /**
   * The hexagram points are generated by placing a rhombus at each edge of a regular hexagon.  To do this, we
   * transform the rhombus points into the hexagon basis represented by each hexagon edge.  This projects the rhombus
   * onto each edge of the hexagon and creates the hexogram.
   */
  //noinspection MapFlatten
  final val hexagramPoints: Array[(Int, Int)] = this.regularHexagonEdges.map(
    (hexagonEdge: ((Int, Int), (Int, Int))) => this.rhombusGrid.map(
      (rhombusPoint: (Int, Int)) => (
        hexagonEdge._1._1 * rhombusPoint._1 + hexagonEdge._2._1 * rhombusPoint._2,
        hexagonEdge._1._2 * rhombusPoint._1 + hexagonEdge._2._2 * rhombusPoint._2
      )
    )
  ).flatten

  /**
   * Within the rhombus grid defined above, the triangle grid is the upper half of the rhombus.  These are all the
   * points that are strictly above mid-line of the rhombus.
   */
  //noinspection MapFlatten
  private final val triangleGrid: Array[(Int, Int)] = (1 to this.radius)
    .map(
      (i: Int) => ((this.radius - i + 1) to this.radius).map(
        (j: Int) => (i, j)
      )
    )
    .flatten
    .toArray

  /**
   * The hexagram corners are the points strictly outside of the base hexagon of the hexagram (the outer triangles).
   * To get these points we project the triangle grid into the hexagon basis represented by each hexagon edge.
   */
  //noinspection MapFlatten
  final val hexagramCornerPoints: Array[Array[(Int, Int)]] = this.regularHexagonEdges
    .map(
      (hexagonEdge: ((Int, Int), (Int, Int))) => this.triangleGrid.map(
        (rhombusPoint: (Int, Int)) => (
          hexagonEdge._1._1 * rhombusPoint._1 + hexagonEdge._2._1 * rhombusPoint._2,
          hexagonEdge._1._2 * rhombusPoint._1 + hexagonEdge._2._2 * rhombusPoint._2
        )
      )
    )

}
