package RuleEngine

import org.scalatest.GivenWhenThen
import org.scalatest.wordspec.AnyWordSpec

class MoveSpec extends AnyWordSpec with GivenWhenThen {
  "A move" must {
    "throw an InvalidMoveException" when {
      "the sum of move is greater than " in {
        Given("A vector, A=(1, 2)")
        val A = new Vector2DArchive(1, 2)
        When("multiplied with the identity scalar, 1")
        val R = A * 1
        Then("The result, R=A*1, is equal to A")
        assert(R == A)
      }
      "multiplied by the identity scalar" in {
        Given("A vector, A=(1, 2)")
        val A = new Vector2DArchive(1, 2)
        When("multiplied with the identity scalar, 1")
        val R = A * 1
        Then("The result, R=A*1, is equal to A")
        assert(R == A)
      }
    }
  }
}
