# Assignment-1-Decide

Java version : V21.0.2
JUnit : V5.8.1
Gradle : V8.5

## Description

DECIDE() will generate a boolean signal which determines whether an interceptor should be
launched based upon input radar tracking information. This radar tracking information is available
at the instant the function is called.

DECIDE() determines which combination of the several possible Launch Interceptor Condi￾tions (LIC’s) are relevant to the immediate situation.

### CMV

The fifteen elements of a Conditions Met Vector(CMV) will be assigned boolean values true or false,
Each of the functions represents a **Launch Interceptor Condition** (LIC)
these function can be found in src/CMV.java.

### LCM

The LCM is a 15x15 symmetric input matrix with elements valued ANDD, ORR, or NOTUSED.

### PUM

The combination of **Logical Connector Matrix** (LCM), and CMV is stored in the Preliminary Unlocking
Matrix (PUM), a 15x15 symmetric matrix. This can be found in src/PUM.java

### PUV

**Preliminary Unlocking Vector** (PUV) represents which LIC actually matters
in this particular launch determination. Each element of the UV indicates how to combine the PUM
values to form the corresponding element of the **Final Unlocking Vector** (FUV),

### FUV

**Final Unlocking Vector** (FUV) is a 15-element
vector. If, and only if, all the values in the FUV are true, should the launch-unlock signal be
generated.

## Contributions

| Name   | Contribution                       |
| ------ | ---------------------------------- |
| Kalle  | Implemented 3 of the CMV functions |
| Linus  | Implemented 3 of the CMV functions |
| Martin | Implemented 3 of the CMV functions |
| Burcu  | Implemented 3 of the CMV functions |
| JJ     | Implemented 3 of the CMV functions |

## Way of working

| Way of working | Details                                                                                                                                                                      |
| -------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Principals     | We agreed that we should follow good coding practices as stated in the lectures, and practice them throughout our assignments                                                |
| Foundations    | We had to create an issue everytime we wanted to edit the main branch and create a seperate branch to work on issue before creating a pull request to merge it back to main. |
| In Use         | We introduced Gradle, JUnit and JavaDocs to help us in our testing and documenting of the Assignment                                                                         |

| **In Place** | The practice was adopted by all our team members and we worked well together to implement the deliverables. We do not hesistate to voice out our ideas if we feel that something could be improved.
