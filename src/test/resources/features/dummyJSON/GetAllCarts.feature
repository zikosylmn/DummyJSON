Feature: Get All Carts
  @Project
  Scenario: Get all carts with valid path
    Given Get all carts with valid path
    When Send request get all carts
    Then Status code get all carts should be 200
    And Response body should be total 20
    And Validate get all carts json schema "GetAllCartsSchema.json"

    @Project
    Scenario: Get all carts with invalid path
      Given Get all carts with invalid path
      When Send request get all carts invalid path
      Then Status code get all carts should be 404