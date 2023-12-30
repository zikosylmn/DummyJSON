Feature: GET ALL PRODUCTS
  @Project
  Scenario: Get all products with valid path
    When Send request get all products
    Then Status code should be 200
    And Response body total should be 100
    And Validate get all product json schema "GetAllProductsSchema.json"

  @Project
  Scenario: Get all products with invalid path
    When Send request get all products with invalid path
    Then Status code should be 404