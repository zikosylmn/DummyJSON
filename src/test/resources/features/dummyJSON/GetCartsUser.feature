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

    @Project
    Scenario Outline: Get carts of a user with invalid path
      Given Get carts of user with invalid path "<chara>"
      When Send request get carts of a user invalid
      Then Status code get carts of a user should be 400
      And Response body get carts of a user should be "<message>"
      And Validate get carts of a user json schema "GetCartsUserInvalidSchema.json"
      Examples:
        | chara | message               |
        | abc   | Invalid user id 'abc' |