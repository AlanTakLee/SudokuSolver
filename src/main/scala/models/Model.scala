package models

/**
  * Created by Alan on 20/05/2016.
  */
class Cell {
  val potentials = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val value = 0
  val id = -1
}

object Grid {
  val board = Map[Int, Cell]()
}