//package RuleEngine
//
//import org.scalatest.GivenWhenThen
//import org.scalatest.wordspec.AnyWordSpec
//
//class Vector2DSpec extends AnyWordSpec with GivenWhenThen {
//  "A vector" must {
//    "not change" when {
//      "added to the identity vector" in {
//        Given("A vector, A=(1, 2)")
//        val A = new Vector2DArchive(1, 2)
//        When("multiplied with the identity scalar, 1")
//        val R = A * 1
//        Then("The result, R=A*1, is equal to A")
//        assert(R == A)
//      }
//      "multiplied by the identity scalar" in {
//        Given("A vector, A=(1, 2)")
//        val A = new Vector2DArchive(1, 2)
//        When("multiplied with the identity scalar, 1")
//        val R = A * 1
//        Then("The result, R=A*1, is equal to A")
//        assert(R == A)
//      }
//    }
//  }
//}
