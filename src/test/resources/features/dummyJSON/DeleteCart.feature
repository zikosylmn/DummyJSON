Feature: Delete a cart
  @Project
  Scenario Outline: Delete a cart with valid path
    Given Delete a cart with valid path <id>
    When Send request delete a cart
    Then Status code delete a cart should be 200
    And Body response delete a cart <id>
    And Validate delete a cart json schema "DeleteCartSchema.json"
    Examples:
    |id|
    |1 |

    @Project
    Scenario Outline: Delete a cart with invalid path
      Given Delete a cart with invalid path "abc"
      When Send request delete a cart invalid
      Then Status code delete a cart should be 404
      And Body Response delete a cart invalid "<message>"
      And Validate delete a cart json schema "DeleteCartInvalidSchema.json"
      Examples:
      |message |
      |Cart with id 'abc' not found |
