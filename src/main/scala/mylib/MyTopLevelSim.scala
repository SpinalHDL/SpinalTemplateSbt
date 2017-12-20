package mylib

import spinal.core._
import spinal.sim._
import spinal.core.sim._

import scala.util.Random


//MyTopLevel's testbench
object MyTopLevelSim {
  def main(args: Array[String]) {
    SimConfig(new MyTopLevel).withWave.doManagedSim{dut =>

      //Fork a process to generate the reset and the clock on the dut
      dut.clockDomain.forkStimulus(period = 10)


      var modelState = 0
      var idx = 0
      while(idx < 100){
        //Generate random values to drive the reference model and the dut
        val cond0, cond1 = Random.nextBoolean()

        //Drive the dut inputs
        dut.io.cond0 #= cond0
        dut.io.cond1 #= cond1

        //Wait a rising edge on the clock
        dut.clockDomain.waitRisingEdge()

        //Update the reference model values
        if(cond0) {
          modelState = (modelState + 1) & 0xFF
        }
        val modelFlag = modelState == 0 || cond1

        //Check that the dut values match with the reference model ones
        assert(dut.io.state.toInt == modelState)
        assert(dut.io.flag.toBoolean == modelFlag)

        idx += 1
      }
    }
  }
}
