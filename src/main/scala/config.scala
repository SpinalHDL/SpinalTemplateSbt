import spinal.core

package object config {
  import core._

  val spinal = SpinalConfig(
    defaultConfigForClockDomains = ClockDomainConfig(
      resetActiveLevel = LOW
    ),
    onlyStdLogicVectorAtTopLevelIo = true
  )

  val sim = core.sim.SimConfig.withConfig(spinal).withFstWave
}
