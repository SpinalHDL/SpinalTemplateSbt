# SpinalHDL Base Project

This repository is a base project to help Spinal users set-up project without knowledge about Scala and SBT.


## If it is your are learning SpinalHDL

You can follow the tutorial on the [Getting Started](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/index.html) page.

More specifically:

* instructions to install tools can be found on the [Install and setup](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/Install%20and%20setup.html#install-and-setup) page
* instructions to get this repository locally are available in the [Create a SpinalHDL project](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/Install%20and%20setup.html#create-a-spinalhdl-project) section.


### TL;DR Things have already been set up in my environment, how do I run things to try SpinalHDL?

Once in the `SpinalTemplateSbt` directory, when tools are installed, the commands below can be run to use `sbt`.

```sh
// To generate the Verilog from the example
sbt "runMain projectname.MyTopLevelVerilog"

// To generate the VHDL from the example
sbt "runMain projectname.MyTopLevelVhdl"

// To run the testbench
sbt "runMain projectname.MyTopLevelSim"
```

* The example hardware description is in `src/main/scala/projectname/MyTopLevel.scala`
* The testbench is in `src/main/scala/spinal/projectname/MyTopLevelSim.scala`

When you really start working with SpinalHDL, it is recommended (both for comfort and efficiency) to use an IDE, see the [Getting started](https://spinalhdl.github.io/SpinalDoc-RTD/master/SpinalHDL/Getting%20Started/index.html).


## If you want to create a new project from this template

### Change project name

You might want to change the project name, which is currently `projectname`. To do so (let's say your actual project name is `myproject`):

* Update `build.sbt` and/or `build.sc` by replacing `projectname` by the name of your project `myproject`. The better is to replace in both (it will always work), but in some contexts you can keep only one of these two files:
    * If you are sure all people only use `sbt`, you can replace only in `build.sbt` and remove `build.sc`
    * If you are sure all people only use `mill`, you can replace only in `build.sc` and remove `build.sbt`
    * Replace in both files for open-source project.
* Rename the `src/main/scala/spinal/projectname` folder to `src/main/scala/spinal/myproject`
* Replace `package projectname` all scala files with `package myproject`

If you want/need separators in the project name then a `.` can be used as a separator, but the folder structure/build files need to be adapted accordingly.
You'll need to follow the rules for Java package names / structure.

### Update this README

Of course you can replace/modify this file to help people with your own project!

### Reinitialize repository

There is no need to keep the git history of the template. The easiest is to remove the `.git` folder and initialize a clean repository:

```sh
rm -rf .git
git init
git add .
git commit -m "Initial project setup"
```

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
