Feature: QA Login without inputting username, just password
  Scenario: Login failed cause not input username
    Given open web url "http://saucedemo.com/"
    And input password "secret_sauce"
    When click login button
    Then should failed login and showing message password are incorrect