Feature: Add a new cart
  @Project
  Scenario: Add a new cart with valid data
    Given Add a new cart with valid data json "AddNewCart.json"
    When Send request add a new cart
    Then Status code add a new cart should be 200
    And Response body add a new cart id=21
    And Validate add a new cart json schema "AddNewCartSchema.json"

    @Project
    Scenario Outline: Add a new cart with invalid data
      Given Add a new cart with invalid data id json "AddNewCartInvalid.json"
      When Send request add a new cart invalid
      Then Status code add a new cart should be 404
      And Body Response add a new cart invalid "<message>"
      And Validate add a new cart invalid json schema "AddNewCartInvalidSchema.json"
      Examples:
        | message                          |
        | User with id '1000000' not found |