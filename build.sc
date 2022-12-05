import mill._, scalalib._

val spinalVersion = "1.8.0"

object projectname extends SbtModule {
  def scalaVersion = "2.12.16"
  override def millSourcePath = os.pwd
  def sources = T.sources(
    millSourcePath / "hw" / "spinal"
  )
  def ivyDeps = Agg(
    ivy"com.github.spinalhdl::spinalhdl-core:$spinalVersion",
    ivy"com.github.spinalhdl::spinalhdl-lib:$spinalVersion"
  )
  def scalacPluginIvyDeps = Agg(ivy"com.github.spinalhdl::spinalhdl-idsl-plugin:$spinalVersion")
}
