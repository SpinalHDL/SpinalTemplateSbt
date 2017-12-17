/*
 * SpinalHDL
 * Copyright (c) Dolu, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 */

package MyCode

import spinal.core._
import spinal.lib._
import spinal.sim._
import spinal.core.SimManagedApi._

import scala.util.Random

//Hardware definition
class MyTopLevel extends Component {
  val io = new Bundle {
    val cond0 = in  Bool
    val cond1 = in  Bool
    val flag  = out Bool
    val state = out UInt(8 bits)
  }
  val counter = Reg(UInt(8 bits)) init(0)

  when(io.cond0){
    counter := counter + 1
  }

  io.state := counter
  io.flag  := (counter === 0) | io.cond1
}

//Generate the MyTopLevel's Verilog
object MyTopLevelVerilog {
  def main(args: Array[String]) {
    SpinalVerilog(new MyTopLevel)
  }
}

//Generate the MyTopLevel's VHDL
object MyTopLevelVhdl {
  def main(args: Array[String]) {
    SpinalVhdl(new MyTopLevel)
  }
}

//MyTopLevel's testbench
object MyTopLevelSim {
  def main(args: Array[String]) {
    SimConfig(new MyTopLevel).withWave.doManagedSim{dut =>

      //Fork a process to generate the reset and the clock on the dut
      fork{
        dut.clockDomain.assertReset()
        dut.clockDomain.fallingEdge()
        sleep(10)
        dut.clockDomain.disassertReset()
        sleep(10)
        while(true){
          dut.clockDomain.clockToggle()
          sleep(5)
        }
      }


      var idx = 0
      while(idx < 100){
        //Generate random values to drive the reference model and the dut
        val cond0, cond1 = Random.nextBoolean()
        val oldState = dut.io.state.toInt

        //Drive the dut inputs
        dut.io.cond0 #= cond0
        dut.io.cond1 #= cond1

        //Wait a rising edge on the clock
        dut.clockDomain.waitRisingEdge()

        //Calculate the reference model values
        val modelState = if(cond0) (oldState + 1) & 0xFF else oldState
        val modelFlag = modelState == 0 || cond1

        //Check that the dut values match with the reference model ones
        assert(dut.io.state.toInt == modelState)
        assert(dut.io.flag.toBoolean == modelFlag)

        idx += 1
      }
    }
  }
}
