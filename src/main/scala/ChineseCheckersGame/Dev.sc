class Hexagram(radius: Int = 4) {

  final val regularHexagonNodes: Array[(Int, Int)] = Array(
    (1, 0), (0, 1), (-1, 1), (-1, 0), (0,-1), (1, -1)
  )

  final val regularHexagonEdges: Array[((Int, Int), (Int, Int))] = this.regularHexagonNodes
    .zipWithIndex
    .map(
      (node: ((Int, Int), Int)) => (
        node._1,
        this.regularHexagonNodes((node._2 + 1) % 6)
      )
    )

  //noinspection MapFlatten
  final val rhombusGrid: Array[(Int, Int)] = (0 to this.radius)
    .map(
      (i: Int) => (1 to this.radius).map(
        (j: Int) => (i,j)
      )
    )
    .flatten
    .toArray

  //noinspection MapFlatten
  final val hexagramPoints: Array[(Int, Int)] = this.regularHexagonEdges
    .map(
      (hexagonEdge: ((Int, Int), (Int, Int))) => this.rhombusGrid.map(
        (rhombusNode: (Int, Int)) => (
          hexagonEdge._1._1 * rhombusNode._1 + hexagonEdge._2._1 * rhombusNode._2,
          hexagonEdge._1._2 * rhombusNode._1 + hexagonEdge._2._2 * rhombusNode._2
        )
      )
    )
    .flatten

  //noinspection MapFlatten
  final val triangleGrid: Array[(Int, Int)] = (1 to this.radius)
    .map(
      (i: Int) => ((this.radius - i + 1) to this.radius).map(
        (j: Int) => (i, j)
      )
    )
    .flatten
    .toArray

  //noinspection MapFlatten
  final val hexagramCornerPoints: Array[Array[(Int, Int)]] = this.regularHexagonEdges
    .map(
      (hexagonEdge: ((Int, Int), (Int, Int))) => this.triangleGrid.map(
        (rhombusNode: (Int, Int)) => (
          hexagonEdge._1._1 * rhombusNode._1 + hexagonEdge._2._1 * rhombusNode._2,
          hexagonEdge._1._2 * rhombusNode._1 + hexagonEdge._2._2 * rhombusNode._2
        )
      )
    )

}

val hexagram = new Hexagram(4)

hexagram.hexagramCornerPoints(0)

for(v <- hexagram.hexagramCornerPoints){
  println(v)
}


for(v <- List(
  List((0,  0), (0,  1), (1,  0), (1,  1), (0,  2), (2,  0), (1 , 2), (2,  1), (0,  3), (3,  0)),
  List((4, -4), (4, -3), (5, -3), (4, -2), (5, -2), (6, -2), (4, -1), (5, -1), (6, -1), (7, -1)),
  List((12, 0), (11, 0), (11, 1), (10, 0), (10, 1), (10, 2), (9,  0), (9,  1), (9,  2), (9,  3)),
  List((8,  8), (8,  7), (7,  8), (7,  7), (8,  6), (6,  8), (7,  6), (6,  7), (8,  5), (5,  8)),
  List((0, 12), (0, 11), (1, 11), (0, 10), (1, 10), (2, 10), (0,  9), (1,  9), (2,  9), (3,  9)),
  List((-4, 4), (-3, 4), (-3, 5), (-2, 4), (-2, 5), (-2, 6), (-1, 4), (-1, 5), (-1, 6), (-1, 7)),
).map(_.map(p => (p._1-4,p._2-4)))){
  println(v)
}