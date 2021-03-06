# JPaint - Java Graphics Creation Program 
**JPaint** is a rudimentary 2D graphics drawing program developed for DePaul's Object-oriented Software Development Course (SE 350).

This project was written with **S.O.L.I.D.** principles in mind and incorporates multiple design patterns.

![jpaint](https://user-images.githubusercontent.com/34048414/142079195-d2113a59-f1af-40a9-9b0d-3103d9cbf0ed.png)

## Features:
* Create three different shapes (Rectangle, Ellipse, and Triangle)
* Shape shading types (Outline, Filled-in, Outline and Filled-in)
* Color menu with 13 different colors
* Click and drag interface for drawing shapes
* Click and drag interface for selecting shapes
* Click and drag interface for moving shapes
* Selecting shapes creates dashed outline around it
* Copy selected shapes
* Paste copied shapes
* Delete selected shapes
* Undo and redo for most actions

## Design patterns used:
* Command interface for most user actions (See implementations of [ICommand.java](src/main/java/controller/interfaces/ICommand.java))
* Static factory for creating command instances (See [CommandFactory.java](src/main/java/controller/command/CommandFactory.java))
* Decorator interface for drawing different shapes according to their shading types (See implementations of [ShapeDecorator.java](src/main/java/view/interfaces/ShapeDecorator.java))
* Null Object pattern for the end of the decorator chain (See [NullDrawer.java](src/main/java/view/draw/NullDrawer.java))
