package Utils

import models.{Cell, Grid}

/**
  * Created by Alan on 20/05/2016.
  */
object Utils {
  def populate() = {
    (0 to 80).map(x => x -> new Cell(x)).toMap
  }

  def checkRowForValue(game: Grid, id: Int): Boolean = {
    val current = game.board(id)
    if (current.value == 0) return true

    val rowNumber = id / 9
    val row = (0 to 8) map ((x: Int) => game.board((rowNumber * 9) + x))
    val valid = row.filter(cell => cell.value > 0 && cell.id != current.id)
    val found = valid.filter(_.value == current.value)
    found.isEmpty
  }

  def checkColForValue(game: Grid, id: Int): Boolean = {
    val current = game.board(id)
    if (current.value == 0) return true

    val column = (0 to 80 by 9) map ((x: Int) => game.board((id + x) % 81))
    val valid = column.filter(cell => cell.value > 0 && cell.id != current.id)
    val found = valid.filter(_.value == current.value)
    found.isEmpty
  }
}
