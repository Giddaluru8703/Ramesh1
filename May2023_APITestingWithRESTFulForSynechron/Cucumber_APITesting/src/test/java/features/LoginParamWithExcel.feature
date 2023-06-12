Feature: Login into yahoo

Scenario Outline: Login into yahoo with valid credentials1

Given user is in the login page
When user enter valid cretialas as follows <RowNum>
And clicks on signin button
Then successfully login should happen

Examples:
|RowNum|
|2|
|3|
|4|
|5|
|6|
|7|