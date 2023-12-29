Feature: Get a single carts
  @Task
  Scenario Outline: Get a single carts with valid path
    Given Get a single carts with valid <id>
    When Send request get a single carts
    Then Status code get a single carts should be 200
    And Response body should be <id>
    And Validate get a single carts json schema "GetSingleCartsSchema.json"
    Examples:
    |id|
    |1 |

    @Task
    Scenario Outline: Get a single carts with invalid path
      Given Get a single carts with invalid path "<chara>"
      When Send request get a single carts invalid
      Then Status code get a single carts should be 404
      Examples:
        | chara |
        | abc   |






