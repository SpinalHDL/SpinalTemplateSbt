package mylib

import spinal.core._

object MyTopLevelVerilog extends App {
  // Generate the MyTopLevel's Verilog
  SpinalVerilog(MyTopLevel())
}

object MyTopLevelVhdl extends App {
  // Generate the MyTopLevel's VHDL
  SpinalVhdl(MyTopLevel())
}

// Custom SpinalHDL configuration with synchronous reset instead of the default asynchronous one
// This configuration can be resued everywhere
object MySpinalConfig
    extends SpinalConfig(
      defaultConfigForClockDomains = ClockDomainConfig(resetKind = SYNC)
    )

object MyTopLevelVerilogWithCustomConfig extends App {
  // Generate the MyTopLevel's Verilog using the above custom configuration.
  MySpinalConfig.generateVerilog(MyTopLevel())
}
