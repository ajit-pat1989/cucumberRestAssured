Feature:
  Verify different GET operations using Rest assured API.

  Scenario: Verify the one author of a post
    Given I perform GET operation on for "/post"
    And I perform GET for the post number "5"
    Then I should see the author name as "UFTTraining"

  Scenario: Verify list of authors of a post
    Given I perform GET operation on for "/post"
    Then I should see the author names

  Scenario: Verify the parameter of GET
    Given I perform GET operation on for "/post"
    Then I should verify the GET parameter

  Scenario: Verify the query parameter of GET
    Given I perform GET operation on for "/post"
    Then I should verify the GET query parameter

  Scenario: Verify the query parameter of GET
    Given I perform GET operation on for "/post"
    Then I should verify the GET query parameter