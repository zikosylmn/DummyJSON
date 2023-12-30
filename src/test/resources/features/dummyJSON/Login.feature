Feature: Login user & get token
  @Project
  Scenario Outline: Login user with entired data
    Given Login user with entired data "Login.json"
    When Send request login user
    Then Status code login user should be 200
    And Response body login user as id <id> as firstName "<firstName>" as lastName "<lastName>"
    And Validate login user json schema "LoginSchema.json"
    Examples:
  |  id | firstName | lastName |
   | 15  | Jeanne    | Halvorson |

    @Project
    Scenario Outline: Login user with invalid data
      Given Login user with invalid data "LoginInvalid.json"
      When Send request login user invalid
      Then Status code login user should be 400
      And Response body login user invalid "<message>"
      And Validate login user json schema "LoginInvalidSchema.json"
      Examples:
       |message |
      |Missing email or username|