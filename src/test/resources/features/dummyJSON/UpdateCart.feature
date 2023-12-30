Feature: Update a cart
  @Project
  Scenario: Update a cart with valid data
    Given Update a cart with valid data json "UpdateCart.json"
    When Send request update a cart
    Then Status code update a cart should be 200
    And Body response update a cart id=1
    And Validate update a cart json schema "UpdateCartSchema.json"

    @Project
    Scenario: Update a cart with invalid data
      Given Update a cart with invalid data json "UpdateCartInvalid.json"
      When Send request update a cart invalid
      Then Status code update a cart should be 400