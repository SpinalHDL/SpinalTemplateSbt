# SpinalHDL Base Project

This repository is a base project to help Spinal users set-up project without knowledge about Scala and SBT.


## If it is your are learning SpinalHDL

You can follow the tutorial on the [Getting Started](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/index.html) page.

More specifically:

* instructions to install tools can be found on the [Install and setup](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/Install%20and%20setup.html#install-and-setup) page
* instructions to get this repository locally are available in the [Create a SpinalHDL project](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/Install%20and%20setup.html#create-a-spinalhdl-project) section.


### TL;DR Things have arleady been set up in my environment, how do I run things to try SpinalHDL?

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


## If you want to create a new project from this template

### Change project name

You might want to change the project name, which is currently `projectname`. To do so (let's say your actual project name is `myproject`; it must be all lowercase with no separators):

* Update `build.sbt` and/or `build.sc` by replacing `projectname` by the name of your project `myproject` (1 occurrence in each file). The better is to replace in both (it will always work), but in some contexts you can keep only one of these two files:
    * If you are sure all people only use `sbt`, you can replace only in `build.sbt` and remove `build.sc`
    * If you are sure all people only use `mill`, you can replace only in `build.sc` and remove `build.sbt`
    * Replace in both files for open-source project.
* Put all your scala files into `hw/spinal/myproject/` (remove the unused `hw/spinal/projectname/` folder)
* Start all your scala files with `package myproject`


### Change project structure

You can change the project structure as you want. The only restrictions (from Scala environment) are (let's say your actual project name is `myproject`):

* you must have a `myproject` folder and files in it must start with `package myproject`
* if you have a file in a subfolder `myproject/somepackage/MyElement.scala` it must start with `package myproject.somepackage`.
* `sbt` and `mill` must be run right in the folder containing their configurations (recommended to not move these files)

Once the project structure is modified, update configurations:

* In `build.sbt` and/or `build.sc` (see above) replace `/ "hw" / "spinal"` by the new path to the folder containing the `myproject` folder.
* In the spinal configuration file (if you kept it, by default it is in `projectname/Config.scala`) change the path in `targetDirectory = "hw/gen"` to the directory where you want generated files to be written. If you don't use a config or if it doesn't contain this element, generated files will be written in the root directory.


### Update this README

Of course you can replace/modify this file to help people with your own project!


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
