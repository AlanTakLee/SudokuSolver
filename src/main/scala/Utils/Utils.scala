package Utils

import models.{Cell, Grid}

/**
  * Created by Alan on 20/05/2016.
  */
object Utils {
  def populate() = {
    (0 to 81).map(x => x -> makeDefaultCell(x)).toMap
  }

  def makeDefaultCell(id: Int): Cell = {new Cell(id)}

  def checkRowForValue(game: Grid, id: Int): Boolean = {
    val row = (0 to 9) map ((x: Int) => game.board((id + x) % 9))
    val current = game.board(id)
    val valid = row.filter(_.value > 0)
    val found = valid.filter(_.value == current.value)
    found.isEmpty
  }

  def checkColForValue(game: Grid, id: Int): Boolean = {
    val column = (0 to 81 by 9) map ((x: Int) => game.board(id + x))
    val current = game.board(id)
    val valid = column.filter(_.value > 0)
    val found = valid.filter(_.value == current.value)
    found.isEmpty
  }
}