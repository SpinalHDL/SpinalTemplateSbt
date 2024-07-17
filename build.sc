import mill._, scalalib._

import com.typesafe.config._
import java.io.File
val conf = ConfigFactory.parseFile(new File("version.conf")).resolve()
val spinalVersion = conf.getString("spinalVersion")

object projectname extends SbtModule {
  def scalaVersion = conf.getString("scalaVersion")
  override def millSourcePath = os.pwd
  def sources = T.sources(
    millSourcePath / "hw" / "spinal"
  )
  def ivyDeps = Agg(
    ivy"com.github.spinalhdl::spinalhdl-core:$spinalVersion",
    ivy"com.github.spinalhdl::spinalhdl-lib:$spinalVersion",
    ivy"com.github.spinalhdl::spinalhdl-tester:$spinalVersion"
  )
  def scalacPluginIvyDeps = Agg(ivy"com.github.spinalhdl::spinalhdl-idsl-plugin:$spinalVersion")
}
