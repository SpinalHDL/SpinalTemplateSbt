# SpinalHDL Base Project

This repository is a base project to help Spinal users set-up project without knowledge about Scala and SBT.


## If it is your are learning SpinalHDL

You can follow the tutorial on the [Getting Started](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/index.html) page.

More specifically:

* instructions to install tools can be found on the [Install and setup](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/Install%20and%20setup.html#install-and-setup) page
* instructions to get this repository locally are available in the [Create a SpinalHDL project](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/Install%20and%20setup.html#create-a-spinalhdl-project) section.


## TL;DR Things have arleady been set up in my environment, how do I run things to try SpinalHDL?

Once in the `SpinalTemplateSbt` directory, when tools are installed, the commands below can be run to use `sbt`.

```sh
// To generate the Verilog from the example
sbt "runMain projectname.MyTopLevelVerilog"

// To generate the VHDL from the example
sbt "runMain projectname.MyTopLevelVhdl"

// To run the testbench
sbt "runMain projectname.MyTopLevelSim"
```

* The example hardware description is into `hw/spinal/projectname/MyTopLevel.scala`
* The testbench is into `hw/spinal/projectname/MyTopLevelSim.scala`

When you really start working with SpinalHDL, it is recommended (both for comfort and efficiency) to use an IDE, see the [Getting started](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/index.html).


## Mill Support (Experimental)

The [Mill build tool](https://com-lihaoyi.github.io/mill) can be installed and used instead of `sbt`.

```sh
// To generate the Verilog from the example
mill projectname.runMain projectname.MyTopLevelVerilog

// To generate the VHDL from the example
mill projectname.runMain projectname.MyTopLevelVhdl

// To run the testbench
mill projectname.runMain projectname.MyTopLevelSim
```
