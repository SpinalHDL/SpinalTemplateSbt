package mylib

import spinal.core._

object MyTopLevelVerilog extends App {
  config.spinal.generateVerilog(MyTopLevel())
}

object MyTopLevelVhdl extends App {
  config.spinal.generateVhdl(MyTopLevel())
}
