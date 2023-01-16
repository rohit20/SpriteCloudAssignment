Feature: Automating UI Automation Playground

  @WebScenario1 @Batch
  Scenario Outline: Verify the Dynamic ID functionality of Application
    Given User is navigated to application type "<applicationType>"
    Then Title of Page should be "<homePageTitle>"
    And I navigated to Dynamic ID Page
    Then Title of Page should be "<DynamicIDPageTitle>"
    Then I verify and click on element which has dynamic ID
    And User close the browser

    Examples: 
      | applicationType | homePageTitle                 | DynamicIDPageTitle |
      | web             | UI Test Automation Playground | Dynamic ID         |

  @WebScenario2 @Batch
  Scenario Outline: Verify the Dynamic Web Table functionality of Application
    Given User is navigated to application type "<applicationType>"
    Then Title of Page should be "<homePageTitle>"
    And I navigated to Dynamic Table Page
    Then Title of Page should be "<DynamicTablePageTitle>"
    And I verify webtable for chrome option
    And User close the browser

    Examples: 
      | applicationType | homePageTitle                 | DynamicTablePageTitle |
      | web             | UI Test Automation Playground | Dynamic Table         |

  @WebScenario3 @Batch
  Scenario Outline: Verify the Client Side Delay functionality of Application
    Given User is navigated to application type "<applicationType>"
    Then Title of Page should be "<homePageTitle>"
    And I navigated to Client Side Delay Page
    Then Title of Page should be "<ClientSidePageTitle>"
    And I click on trigger button and wait till data appears
    And User close the browser

    Examples: 
      | applicationType | homePageTitle                 | ClientSidePageTitle |
      | web             | UI Test Automation Playground | Client Side Delay   |
