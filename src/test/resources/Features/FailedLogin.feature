Feature: QA Failed Login Tests
  Scenario: Login failed on sauce demo web
    Given open web url "http://saucedemo.com/"
    And input username "standard_user" and password "wrong_password"
    When click login button
    Then should failed login and showing message password are incorrect