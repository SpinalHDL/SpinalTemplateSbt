name := "SpinalTemplateSbt"

version := "1.0"

scalaVersion := "2.11.12"

EclipseKeys.withSource := true

libraryDependencies ++= Seq(
  "com.github.spinalhdl" % "spinalhdl-core_2.11" % "1.4.0",
  "com.github.spinalhdl" % "spinalhdl-lib_2.11" % "1.4.0",
  compilerPlugin("com.github.spinalhdl" % "spinalhdl-idsl-plugin_2.11" % "1.4.0")
)

fork := true
