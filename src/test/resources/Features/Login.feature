Feature: QA Success Login
  Scenario: Login successful on sauce demo web
    Given open web url "https://www.saucedemo.com/"
    And Input username "standard_user" and password "secret_sauce"
    When Click login button
    Then Should success login and redirect to homepage