Feature: Add Product
  @Project
  Scenario: Add Product with valid data
        Given Post add product with valid json "AddProducts.json"
        When Send request post add products
        Then Status code add products should be 200
        And Response body add products id=101
        And Validate add product json schema "AddProductsSchema.json"

  @Project
  Scenario Outline: Add Product with invalid data
    Given Post add product with invalid json "InvalidAddProducts.json"
    When Send request post add products
    Then Status code add products should be 400
    And Response body add products message "<message>"
    And Validate add product json schema "AddProductsSchema.json"
    Examples:
    |message             |
    | invalid tittle     |