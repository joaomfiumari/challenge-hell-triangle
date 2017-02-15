
Hell Triangle or Euler Project 67
#Description
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)

#Programming Language:
Java was my choice as programming language because is the programming language that I am more experienced with. I've chose JDK8 because is the updated version. For this reason I had the option to use Streams and other features but I've decided to not use so I would let my code more readable.

#Package manager and Test Framework:

Maven was used as my package manager. JUnit(v4.12) was the test framework used, and I also used a continuous integration host (Travis CI) to automate the build and tests. So as soon as I update my code repository on GitHub, the build and all the tests are upload on my CI host (Travis CI) 

#Run config:

mvn test inside the directory or just see at:

[![Build Status](https://travis-ci.org/joaomfiumari/challenge-hell-triangle.svg?branch=master)](https://travis-ci.org/joaomfiumari/challenge-hell-triangle)
