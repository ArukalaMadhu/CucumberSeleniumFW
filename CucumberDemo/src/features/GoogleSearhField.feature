Feature: Google Homepage
This feature verifies the Search input field on Google Homepage
@smokeTest
@E2E
Scenario Outline: Open Google Home page and verify Search input field
# Data driven with Simple Data Driven -- without example Keyword
Given Open google "http://google.com" 
# Data driven with Example keyword
When I verify google home page "<title>" 
# Data Map
Then I verify that the page displays search text box
|name|
|q|
#|m|
And the page displays Google Search button
# Data Driven Using Tables
Then the page displays Im Feeling Lucky button
|hplogo|
|hplogo|


Examples:
	|title|
	|Google|
#	|Google|

#@smokeTest
#Scenario: Check Gmail Login Page
#Given Open Gmail "http://gmail.com" 
#
#Scenario: Check Facebook Login Page
#Given Open Facebook "http://facebook.com" 
#
#@E2E
#Scenario: Check Google Home Page
#Given Open google "http://google.com" 
#


# Data Driven Testing Using Cucumber
# 1. Simple Data Driven -- without example Keyword
# 2. With Example keyword
# 3. Using Tables


