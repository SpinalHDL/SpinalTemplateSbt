ThisBuild / version := "1.0"
ThisBuild / organization := "org.example"

import com.typesafe.config._
val conf = ConfigFactory.parseFile(new File("version.conf")).resolve()
ThisBuild / scalaVersion := conf.getString("scalaVersion")
val spinalVersion = conf.getString("spinalVersion")

val spinalCore = "com.github.spinalhdl" %% "spinalhdl-core" % spinalVersion
val spinalLib = "com.github.spinalhdl" %% "spinalhdl-lib" % spinalVersion
val spinalIdslPlugin = compilerPlugin("com.github.spinalhdl" %% "spinalhdl-idsl-plugin" % spinalVersion)

lazy val projectname = (project in file("."))
  .settings(
    Compile / scalaSource := baseDirectory.value / "hw" / "spinal",
    libraryDependencies ++= Seq(spinalCore, spinalLib, spinalIdslPlugin)
  )

fork := true
