@cxo
Feature: Login

  Scenario: Login with valid credential
    Given User open the cxo web
    When  User input "KENANGAN123" as company id, "11NEUTY" as user id, "Ardian08!" as password
    Then  User click login button
    When  User input otp number 123456
    And   User click verifikasi
    Then  User redirect to dashboard menu
