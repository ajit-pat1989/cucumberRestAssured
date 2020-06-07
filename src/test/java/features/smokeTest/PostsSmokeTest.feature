  Feature: This feature does smoke test on Posts API call for POST,DELETE and GET operation
    @smokeTest
    Scenario: Test on Posts API call for POST,DELETE and GET operation
    Given I perform POST operation for "/posts" with the body as below
          | id | title               | author              |
          | 6  | Performance Testing | Automation Training |
    And I perform DELETE operation for "/posts/{postid}/"
          | id |
          | 6  |
    And I perform GET operation with path parameter as "/posts/{postid}/"
          | id |
          | 6  |
    Then I should not see the body title as "Performance Testing"