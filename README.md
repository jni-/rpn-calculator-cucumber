Sample RPN Calculator (Cucumber version)
========================================

This sample project aims to demonstrate the following :

* How to write and run acceptance test with cucumber-jvm
* How to test a REST service (using jetty and jersey in this case)
* How to integrate all of this with maven and modules

To see a version with JBehave, head over here : https://github.com/jni-/rpn-calculator

What is a RPN calculator?
=========================

A RPN (Reverse Polish Notation) calculator is a calculator designed to mess with your head. However, it is pretty easy to code.

For example, if you had `1 2 3 + 2 * -`, you would get `-9`. You simple pile numbers from left to right, and when you hit an operator you apply it to the last two numbers. 

The implementation is fairly easy because this project mainly aims to showcase the tools, not the code. 

Here is the [tutorial in haskell](http://learnyouahaskell.com/functionally-solving-problems) where I stole the idea (thanks!).

Current State
=============

Pretty much everything I wanted to showcase has been implemented. Any other ideas?

How to run
==========

You can start all interfaces (only REST for now) with `mvn exec:java -pl rpn-calculator` or by running the `Main` class in your IDE of choice.

Jetty will start on port 8080. Did not see the point to make it configurable for now, submit pull request if you want it.

Example query : `http://localhost:8080/rpn/result?equation=1%202%20%2B`

That's `1 2 +` encoded. Plus sign needs to be encoded into %2B, else it's a space. You modern browser should convert the other spaces for you, so no need for the %20.

How to run tests
================

You can run them via maven with `mvn test` to run only unit tests, or `mvn integration-test` to run Cucumber tests. All of this can be done on the parent project.

You can also run individual tests (including Cucumber features) with the JUnit runner in Eclipse. Not tested in other IDEs, but it should work too.

Note that Cucumber tests are excluded from infinitest's scope.

More info
=========

The code is in english, but the stories are in french. Weird, I know, but that's to showcase the required config to change the langage. There is a lot more you can configure, see the doc.
