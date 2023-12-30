Feature: Limit & skip carts
  @Project
  Scenario Outline: Limit & skip carts with valid parameter
    Given Limit & skip carts with valid parameter limit as <limit> & skip as <skip>
    When Send request limit & skip carts
    Then Status code limit & skip should be 200
    And Body response limit & skip carts total as <total> & limit as <limit> & skip as <skip>
    And Validate limit & skip carts json schema "LimitSkipCartsSchema.json"
    Examples:
      | limit | skip | total |
      | 3     | 2    | 20    |

    @Project
    Scenario Outline: Limit & skip carts with invalid parameter
      Given Limit & skip carts with invalid parameter limit as "<chara>" & skip as <skip>
      When Send request limit & skip carts invalid
      Then Status code limit & skip should be 400
      And Body response limit & skip carts get "<message>"
      And Validate limit & skip carts json schema "LimitSkipCartsInvalidSchema.json"
      Examples:
        | chara | skip | message       |
        | abc   | 2    | Invalid limit |