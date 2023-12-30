Feature: Limit Skip Products
  @Project
#  Scenario Outline: Limit skip products with valid parameter
#    Given get limit dan skip with valid parameter limit as <limit> & skip as <skip>
#    When Send request limit dan skip products
#    Then Status code limit dan skip should be 200
#    And Body response limit dan skip products total as <total> & limit as <limit> & skip as <ski>
#    And Validate limit dan skip products json schema "LimitSkipProductsSchema.json"
#    Examples:
#      | limit | skip| total |
#      | 3     | 2    | 20    |

  @Project
  Scenario Outline: Limit skip products with invalid parameter
    Given Limit_skip products with invalid parameter limit as "<chara>" & skip as <skip>
    When Send request limit_skip products invalid
    Then Status codes limit_skip should be 400
    And Body response limit_skip products get "<message>"
    And Validates limit_skip products json schema "LimitSkipProductsInvalidSchema.json"
    Examples:
      | chara | skip | message       |
      | abc   | 2    | Invalid limit |