Feature: Get carts of a user
  @Project
  Scenario Outline: Get carts of a user with valid path
    Given Get carts of a user with valid path <id>
    When Send request get carts of a user
    Then Status code get carts of a user should be 200
    And Body response get carts of a user should be <idProduct>
    And Validate get carts of a user json schema "GetCartsUserSchema.json"
    Examples:
      | id | idProduct |
      | 5  | 19        |
