package ChineseCheckersGame

import org.scalatest.GivenWhenThen
import org.scalatest.wordspec.AnyWordSpec

class HexagramSpec extends AnyWordSpec with GivenWhenThen {
  "a hexagram of radius 4" must {
    "not contain points" which {
      "absolute sum to greater than " in {
        Given("A hexagram of radius 4")
        val hexagram = new Hexagram(4)
        assert(1==1)

      }
      "absolute" in {
        assert(1==1)

      }
    }
  }
}

/**
 * The starting positions are the six triangular corners of the hexagram.
 */
//private val startingPositions: List[List[(Int, Int)]] = List (
//  List ((0, 0), (0, 1), (1, 0), (1, 1), (0, 2), (2, 0), (1, 2), (2, 1), (0, 3), (3, 0) ),
//  List ((4, - 4), (4, - 3), (5, - 3), (4, - 2), (5, - 2), (6, - 2), (4, - 1), (5, - 1), (6, - 1), (7, - 1) ),
//  List ((12, 0), (11, 0), (11, 1), (10, 0), (10, 1), (10, 2), (9, 0), (9, 1), (9, 2), (9, 3) ),
//  List ((8, 8), (8, 7), (7, 8), (7, 7), (8, 6), (6, 8), (7, 6), (6, 7), (8, 5), (5, 8) ),
//  List ((0, 12), (0, 11), (1, 11), (0, 10), (1, 10), (2, 10), (0, 9), (1, 9), (2, 9), (3, 9) ),
//  List ((- 4, 4), (- 3, 4), (- 3, 5), (- 2, 4), (- 2, 5), (- 2, 6), (- 1, 4), (- 1, 5), (- 1, 6), (- 1, 7) ),
//  ).map (_.map (p => (p._1 - 4, p._2 - 4) ) )