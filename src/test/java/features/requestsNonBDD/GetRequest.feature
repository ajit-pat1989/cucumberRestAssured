Feature:
 To Verify different GET operations using Rest assured API.

  Scenario: Verify the one author of a post
    Given I perform GET operation on for "/posts" URI.
    Then I should see the author name as "Ajit Desai" in actual result
