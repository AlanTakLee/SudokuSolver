package main

import Utils.Utils
import models.Grid

/**
  * Created by Alan on 20/05/2016.
  */
object Application {
  def main(): Unit = {
    val thisGame = new Grid(Utils.populate())

  }
}
