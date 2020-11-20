@test
Feature: Login and Validation check for Task Manager Application

  Background:User access task mananger application and provide credentials,login and land on My day page
    Given user Access Task manager application via browser
    When user inputs "user" in the field "email"
    And  user inputs "user" in the field "password"
    And user click "Login" button
    Then user should land on "My day" page


    # Validate Add Task
    @test1
    Scenario Outline: Validate add task
    Given user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    When user click "Add" button
    Then user should see "taskTitle" on the page


    Examples:
      | taskTitle   | taskDescription     |
      | AddTask     | Task to be Added    |


      # Validate Remove Task
    @test1
  Scenario Outline: Validate remove  task
  Given user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    When user click "Add" button
    And user Remove the "<taskTitle>"
    Then user should not see see "<taskTitle>" on the page


    Examples:
      | taskTitle   | taskDescription     |
      | RemoveTask  | Task to be Removed  |


      # Validate ALL Task page
   @test1
  Scenario Outline: Validate ALL Task page
    Given user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    When user click "Add" button
    And user click on "All Tasks" Page
    Then user should see "All Tasks" on the page
    And user should see "<taskTitle>" on the page


    Examples:
      | taskTitle   | taskDescription     |
      | AllPageTask | Task for All page   |


     # Validate Favourite Task page
  @test1
  Scenario Outline: Validate Favourite Task page
    Given user inputs "<taskTitle>" in the field "Task title"
    And user inputs "<taskDescription>" in the field "Task description"
    When user make that task as Important
    And user click "Add" button
    And user click on "Important Tasks" Page
    Then user should see "Important Tasks" on the page
    And user should see "<taskTitle>" on the page


    Examples:
      | taskTitle   | taskDescription     |
      | MyFavTask   | My fav. Task        |

