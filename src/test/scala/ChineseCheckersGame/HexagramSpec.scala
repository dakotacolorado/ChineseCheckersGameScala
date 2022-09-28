package ChineseCheckersGame

import Common.Hexagram
import org.scalatest.GivenWhenThen
import org.scalatest.wordspec.AnyWordSpec

class HexagramSpec extends AnyWordSpec with GivenWhenThen  {
  def hexagrams = (1 to 10).map(r => new Hexagram(r))

  "a hexagram" must {
    "be centered on the origin" in {
      val hexagramCentroids = this.hexagrams.map(
        H => H.hexagramPoints.map(p => p._1 + p._2).sum
      )
      hexagramCentroids.foreach(c => assert(c == 0))
    }
    "be symmetric about the origin" in {
      this.hexagrams.foreach(
        H => ( H.hexagramPoints.foreach(
            p => ( assert(H.hexagramPoints contains (-p._1, -p._2)) )
        ))
      )
    }
    "not contain duplicate points" in {
      this.hexagrams.foreach(H =>
        H.hexagramPoints.groupBy(p => p).foreach(
          g => assert(g._2.length == 1)
        ))
    }
  }
  "a hexagram of radius = r" must {
    "not contain points" which {
      "absolute sum to greater than 3*r" in {
        this.hexagrams.foreach( H=>
          H.hexagramPoints.foreach(
            p => assert(p._1.abs + p._2.abs <= H.radius * 3)
          ))
      }
    }
  }
}