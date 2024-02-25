# Enigma

Project for practice 1 of the High Performance Computing course,
the project is based on the optimization of an algorithm based on the encryption machine
enigma. In this case we will focus on the decryption part, for this we were provided with
a codebase located in the "Version_original" directory where the algorithm was already prepared
for test execution. To optimize the original code, MPI had to be used as a technology
message passing for processes with distributed memory.

## Installation:

To install the project, you simply have to download the zip of the project and unzip it, if you have
permissions is simply worth making a clone on your machine.

You will also have to have MPI and Make installed:
```bash
  $ sudo apt-get install openmpi-bin openmpi-common openssh-client openssh-server libopenmpi1.3 libopenmpi-dbg libopenmpi-dev;
  $ sudo apt-get install make;
```
## Execution:

To run the test code simply in the project root you have to use the command:

```bash
  $ make
```

In case you want to run each version separately, you move to each folder and execute the same command inside them.