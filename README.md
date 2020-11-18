
1) To test TaskManager application, i have created a Gradle project named "TaskManager".
2) Framework is designed using Java and Selenium/Cucumber libraries.
3) Test cases are writtern in Gherkin language(given,when,then), which are user/business friendly and easy to understand.

Below are detailed usage of each file.

1. build.gradle --> Load depency libraries including Selenium,cucumber,yaml etc.. and task calling autoamation tests.
2. environment.properties --> Contains details which browser to launch, url, test report location etc.
3. taskmanager.yml --> Contains details about web elements properties.
4. com/mahajana/runner/features/taskManagerTest.feature --> Test cases to need to get executed.
5. com/mahajana/steps/MyStepdefs.java --> Test code to called internally, corresponding to taskManagerTest.feature
6. com/mahajana/runner/FeatureTest.java --> runner class, which call test bases on tags (@test1)
7. com/mahajana/functions/DriverFactory.java --> Class which initializes web driver instance
8. com/mahajana/functions/PageFileParser.java --> Class helps to create web element instance at run time based on parameters.


***********Test Execution Steps***********

1. Automation project is build as Gradle project, it will call a Gradle task name "runFirstTime" from build.gradle.
2. To execute the test cases, create a Gradle task from Run/Edit Configuration [intellij].
   a. Specify Gradle project as "TaskManager"
   b. Tasks as "runFirstTime"
3. Bases on whichever test has "@test1" tag in "taskManagerTest.feature", will get executed.
4. Test Report will get generated at below location after execution gets completed.   
    target/cucumber-reports/report.html
    
       
***********Issue found***********
Login Page-
1) able to login using credentials which is not actual email id.

Landing Page - 
a.
1) try to add task with task title as Blank "NULL" it will give messaged as Task title is required.
2) Now give the task title but error message still disappear
b. Able to add same name task..
My day Page :-
1) without adding any task, My day page shows a task (Test Task 1)
2) When adding task along with Due date, its not allowing task to get added.
without due date, it works good.    
    
    
    