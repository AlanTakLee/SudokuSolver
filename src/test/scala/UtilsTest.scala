import models.{Cell, Grid}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Alan on 20/05/2016.
  */
class UtilsTest extends FlatSpec with Matchers {
  val grid = Utils.Utils.populate()
  val board = new Grid(grid)
  val testBoardUnsolved = IndexedSeq(
    0, 5, 2, 0, 0, 6, 0, 0, 0,
    1, 6, 0, 9, 0, 0, 0, 0, 4,
    0, 4, 9, 8, 0, 3, 6, 2, 0,
    4, 0, 0, 0, 0, 0, 8, 0, 0,
    0, 8, 3, 2, 0, 1, 5, 9, 0,
    0, 0, 1, 0, 0, 0, 0, 0, 2,
    0, 9, 7, 3, 0, 5, 2, 4, 0,
    2, 0, 0, 0, 0, 9, 0, 5, 6,
    0, 0, 0, 1, 0, 0, 9, 7, 0
  )


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

  "Check col" should "be true when checking empty grid" in {
    Utils.Utils.checkColForValue(board, 0) should be(true)
  }

  "Check row and col" should "be true when checking an unsolved board" in {
    val x = (Stream from 0).zip(testBoardUnsolved).toMap.map(a => a._1 -> new Cell(a))
    val thisGrid = new Grid(x)
    val y = x.map(curCell => Utils.Utils.checkColForValue(thisGrid, curCell._1))
    val z = x.map(curCell => Utils.Utils.checkRowForValue(thisGrid, curCell._1))
    y.find(_ == false) should be(None)
    z.find(_ == false) should be(None)
  }
}
