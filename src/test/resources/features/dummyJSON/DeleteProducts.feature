Feature: Delete Products
  @Project
  Scenario Outline: Delete products with valid id
    Given Delete products with valid id <id>
    When Send request delete products
    Then Status code should be 200
    And Body response delete products <id>
    And Validate delete products json schema "DeleteProductsSchema.json"
    Examples:
      |id|
      |1 |
      |2 |

  @Project
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id 3000
    When Send request delete products
    Then Status code should be 404
    And Body Response delete products invalid "<message>"
    And Validate delete products json schema "DeleteProductsInvalidSchema.json"
    Examples:
      |message                         |
      |Product with id '3000' not found|



