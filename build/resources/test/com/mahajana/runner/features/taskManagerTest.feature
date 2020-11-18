@test
Feature: Login and Validation check for Task Manager Application

  Background:
#    Given user Access Task manager application via browser

  #validate Landing page
   @test1
  Scenario Outline: Sign-in to TaskManger application and perform different validations
    Given user Access Task manager application via browser
    When user inputs "<email>" in the field "email"
    And  user inputs "<password>" in the field "password"
    And user click "Login" button
    Then user should land on "My day" page

    Examples:
      | email   | password  |
      | user    | user      |


    # Validate Add Task
    @test1
    Scenario Outline: Validate add and remove a task
    Given user Access Task manager application via browser
    When user inputs "<email>" in the field "email"
    And  user inputs "<password>" in the field "password"
    And user click "Login" button
    And user should land on "My day" page
    And user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    And user click "Add" button
    Then user should see "taskTitle" on the page


    Examples:
      | email   | password  | taskTitle   | taskDescription     |
      | user    | user      | AddTask     | Task to be Added    |


      # Validate Remove Task
    @test1
  Scenario Outline: Validate add and remove a task
    Given user Access Task manager application via browser
    When user inputs "<email>" in the field "email"
    And  user inputs "<password>" in the field "password"
    And user click "Login" button
    And user should land on "My day" page
    And user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    And user click "Add" button
    And user Remove the "<taskTitle>"
    Then user should not see see "<taskTitle>" on the page


    Examples:
      | email   | password  | taskTitle   | taskDescription     |
      | user    | user      | RemoveTask  | Task to be Removed  |


      # Validate ALL Task page
  @test1
  Scenario Outline: Validate add and remove a task
    Given user Access Task manager application via browser
    When user inputs "<email>" in the field "email"
    And  user inputs "<password>" in the field "password"
    And user click "Login" button
    And user should land on "My day" page
    And user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    And user click "Add" button
    And user click on "All Tasks" Page
    Then user should see "All Tasks" on the page
    And user should see "<taskTitle>" on the page


    Examples:
      | email   | password  | taskTitle   | taskDescription     |
      | user    | user      | AllPageTask | Task for All page   |


     # Validate Favourite Task page
  @test1
  Scenario Outline: Validate add and remove a task
    Given user Access Task manager application via browser
    When user inputs "<email>" in the field "email"
    And  user inputs "<password>" in the field "password"
    And user click "Login" button
    And user should land on "My day" page
    And user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    And user make that task as Important
    And user click "Add" button
    And user click on "Important Tasks" Page
    Then user should see "Important Tasks" on the page
    And user should see "<taskTitle>" on the page


    Examples:
      | email   | password  | taskTitle   | taskDescription     |
      | user    | user      | MyFavTask   | My fav. Task        |

