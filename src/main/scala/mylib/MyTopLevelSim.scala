package mylib

import spinal.core._
import spinal.sim._
import spinal.core.SimManagedApi._

import scala.util.Random


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
