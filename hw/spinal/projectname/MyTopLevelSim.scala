package projectname

import spinal.core._
import spinal.core.sim._

object MyTopLevelSim extends App {
  Config.sim.compile(MyTopLevel()).doSim { dut =>
    // Fork a process to generate the reset and the clock on the dut
    dut.clockDomain.forkStimulus(period = 10)

    var modelState = 0
    for (idx <- 0 to 99) {
      // Drive the dut inputs with random values
      dut.io.cond0.randomize()
      dut.io.cond1.randomize()

      // Wait a rising edge on the clock
      dut.clockDomain.waitRisingEdge()

      // Check that the dut values match with the reference model ones
      val modelFlag = modelState == 0 || dut.io.cond1.toBoolean
      assert(dut.io.state.toInt == modelState)
      assert(dut.io.flag.toBoolean == modelFlag)

      // Update the reference model value
      if (dut.io.cond0.toBoolean) {
        modelState = (modelState + 1) & 0xff
      }
    }
  }
}
