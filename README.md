# Project 4: Extra Credit TM

* Author: Andrew Rafla/Joshua Holden
* Class: CS361 Section 2
* Semester: Fall 2016

## Overview

This program simulates a TM, and can simulate the TM on an input, with either an initial tape, or starting with an empty tape. It has a bi-infinite tape, and the tape uses the symbol '0' to represent a blank character. This program has only been tested with 1-9 non-halting states and and alphabet of {0-9}.

## Compiling and Using

To compile, go to the root project directory and do the command

$ javac */*.java

this project is in the p1Extra package, so to run

$ java p1Extra.TMSimulator <input file>

the format for the input file can be found on Dr. Elena Sherman's blackboard page.

## Discussion

This project was probably the simplest one we've had this semester, with the exception of maybe the DFA one. We were able to use a skeleton of Andrew's Transition class to create a transition object for the TM, which was important because each state had to store lots of information for each transition(tostate, readsymbol, writesymbol, and tape direction). The TMState class was nearly identical to that from the other projects, and the TM class was also pretty similar, as far as creating states went. The main thing we had to implement in this file was the simulate method. We originally were using a LinkedList to store our Cells, because of the ListIterator functionality, and because we could easily add to the beginning or end of the tape. We began by using the ListIterator to move the tape head, however, we quickly realized this wouldn't work because we had to modify the list every time we added a new cell, which would throw a ConcurrentModificationException. We tried to get around this by creating a new ListIterator every time we modifyed the list, but this seemed inefficient, and we ran into issues because a call to next() then previous() and vise versa would return the same element, since the cursor sat between cells rather than on one. We finally decided to just add an indexing variable called tapeIndex, and just do a get() call on the list. After having this solution for a day it dawned on us that we were not using the correct data structure for this, because every get() call had a complexity of O(n). We switched to an ArrayList because it had a constant complexity for get() and add(). This significantly sped up the runtime of our simulator.

## Extra Credit

This is an extra credit project.

## Sources used

Previous project files.
