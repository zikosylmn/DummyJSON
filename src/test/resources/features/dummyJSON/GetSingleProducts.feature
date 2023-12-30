Feature: GET SINGLE PRODUCTS
  @Project
  Scenario Outline: Get single products with valid id
    Given Get single products with valid <id>
    When Send request get single products
    Then Status code should be 200
    And Response body single products id should be <id>
    And Validate get single products json schema "GetSingleProductsSchema.json"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Project
  Scenario Outline: Get single products with invalid id
    Given Get single products with invalid id <id>
    When Send request get single products
    Then Status code should be 404
    And Validate get single products json schema "GetSingleProductInvalidIdSchema.json"
    Examples:
      | id   |
      | 200  |

  @Project
  Scenario: Get single products with invalid path
    When Send request get single products with invalid path
    Then Status code should be 404