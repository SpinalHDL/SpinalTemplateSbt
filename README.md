Spinal Base Project
============
This repository is a base SBT project added to help non Scala/SBT native people in their first steps.

## Basics, without any IDE

You need to install Java JDK and SBT

```sh
sudo apt-get install openjdk-8-jdk

echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 2EE0EA64E40A89B84B2DF73499E82A75642AC823
sudo apt-get update
sudo apt-get install sbt
```

If you want to run the scala written testbench, you have to be on linux and have Verilator installed (a recent version) :

```sh
sudo apt-get install git make autoconf g++ flex bison -y  # First time prerequisites
git clone http://git.veripool.org/git/verilator   # Only first time
unsetenv VERILATOR_ROOT  # For csh; ignore error if on bash
unset VERILATOR_ROOT  # For bash
cd verilator
git pull        # Make sure we're up-to-date
git tag         # See what versions exist
autoconf        # Create ./configure script
./configure
make -j$(nproc)
sudo make install
cd ..
echo "DONE"

```

Clone or download this repository.

```sh
git clone https://github.com/SpinalHDL/SpinalBaseProject.git
```

Open a terminal in the root of it and run "sbt run". At the first execution, the process could take some seconds

```sh
cd SpinalBaseProject

//If you want to generate the Verilog of your design
sbt "run-main mylib.MyTopLevelVerilog"

//If you want to generate the VHDL of your design
sbt "run-main mylib.MyTopLevelVhdl"

//If you want to run the scala written testbench
sbt "run-main mylib.MyTopLevelSim"
```

The top level spinal code is defined into src\main\scala\mylib

## Basics, with Intellij IDEA and its scala plugin

You need to install :

- Java JDK 8
- SBT
- Intellij IDEA (the free Community Edition is good enough)
- Intellij IDEA Scala plugin (when you run Intellij IDEA the first time, he will ask you about it)

And do the following :

- Clone or download this repository.
- In Intellij IDEA, "import project" with the root of this repository, Import project from external model SBT
- In addition maybe you need to specify some path like JDK to Intellij
- In the project (Intellij project GUI), go in src/main/scala/mylib/MyTopLevel.scala, right click on MyTopLevelVerilog, "Run MyTopLevelVerilog"

Normally, this must generate an MyTopLevel.v output files.

## Basics, with Eclipse and its scala plugin

You need to install :

- Java JDK
- Scala
- SBT
- Eclipse (tested with Mars.2 - 4.5.2)
- [scala plugin](http://scala-ide.org/) (tested with 4.4.1)

And do the following :

- Clone or download this repository.
- Run ```sbt eclipse``` in the ```SpinalBaseProject``` directory.
- Import the eclipse project from eclipse.
- In the project (eclipse project GUI), right click on src/main/scala/mylib/MyTopLevel.scala, right click on MyTopLevelVerilog, and select run it

Normally, this must generate output file ```MyTopLevel.v```.

