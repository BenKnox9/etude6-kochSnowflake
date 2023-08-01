# Etude 3 - KochSnowflake
#### Ben Knox 3938210

## Description
My Koch snowflake starts off as an equilateral triangle in order 1. As orders increase each line will be split into 3 segments, another equilateral triangle will then be added with the base where the middle segment was, however the base will not be drawn. This process will be repeated for every line and will be repeated depending on what order is chosen by the user. My program uses two Jframes to achieve this. First is the selectOrder frame, which has a Jbutton, JLabel, and JTextField. This frame will prompt the user to enter their desired order for the snowflake. Once an order is entered the snowflake will be drawn in its own frame, however will throw an error if what is entered isn't a number. I took inspiration for the recursion pattern from a few places I found online which will be linked below.

## Running the code 
After compiling and running the selectOrder frame will apear where you can enter the desired order. An error will be thrown if a non digit is entered in the text box but otherwise all will work smoothly.

## Overview
Overall this code can accomplish the task at hand rather quickly, achieving up to order 12 within a reasonable time frame. Of course the snowflake isn't perfect as you can sometimes see lines which are slightly off, I have credited this to having to cast most numbers to an int as while using g2D.drawline you must draw to int coordinates. Apart from this the program works well.

## Resources
https://craftofcoding.wordpress.com/tag/recursive-pattern/  -  recursion


