import models.Grid
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Alan on 20/05/2016.
  */
class UtilsTest extends FlatSpec with Matchers {
  val grid = Utils.Utils.populate()
  val board = new Grid(grid)

  "Populate" should "make a grid with 81 cells" in {
    grid.size should be(81)
  }

  "Populate" should "have all cells be empty value" in {
    grid.forall(_._2.value == 0) should be(true)
  }

  "Populate" should "have all cells potentially be 1-9" in {
    grid.forall(_._2.potentials == Set(1, 2, 3, 4, 5, 6, 7, 8, 9)) should be(true)
  }

  "Check row" should "be true when checking empty grid" in {
    Utils.Utils.checkRowForValue(board, 0) should be(true)
  }
}
