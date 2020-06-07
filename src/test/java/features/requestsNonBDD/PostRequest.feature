Feature:
  To Verify different Post operations using Rest assured API.

  Scenario: Verify POST operation for post profile
    Given I perform POST operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | Richard  | 2   |
    Then I should be able to verify response body for "Richard"
