Feature: Update Product
  @Project
  Scenario: Update Product with valid data
    Given Put update product with valid json "UpdateProducts.json"
    When Send request put update products
    Then Status code update products should be 200
    And Response body update products id=1
    And Validate update product json schema "UpdateProductsSchema.json"

  @Project
  Scenario Outline: Update Product with invalid data
    Given Update product with invalid json "InvalidUpdateProducts.json"
    When Send request post update products
    Then Status code update products should be 400
    And Response body update products message "<message>"
    And Validate update product json schema "UpdateProductsSchema.json"
    Examples:
      |message             |
      | invalid tittle     |