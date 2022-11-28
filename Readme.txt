# home-task-employee-api

This program runs 3 tests that test a system for introducing and creating employees

The tests check using the API

Test 1.
Reads and receives the list of all employees

Test 2.
Creates a new employee by using the model to create Jason, and returns the ID of the new employee.

Test 3.
Makes a call with an employee's ID (in our case the new employee) and receives back a model with all the employee's data.

##########################

I used the log4j2.xml file to display the logs, both in the console and in the app.log file

I used Retry which runs up to 4 times (3 + the first run) to ensure the test passes,
Because many times the test doesn't pass and gets a 429 because there are too many requests.

I made documentation for all functions, and also created an HTML file for documentation organized by javaDoc to view navigate here: file://../javaDoc/index.html

I used a listener for extent properties to output a summary file of the run. The file is here: file://../test-output/index.html
