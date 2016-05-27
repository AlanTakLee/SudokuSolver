package models

/**
  * Created by Alan on 20/05/2016.
  */
class Cell(val id: Int, val value: Int) {
  var potentials = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)

  def this(id: Int) {
    this(id, 0)
  }

  def this(vals: (Int, Int)) {
    this(vals._1, vals._2)
    potentials = potentials -- Set(vals._2)
  }
}

class Grid(val board: Map[Int, Cell]) {}