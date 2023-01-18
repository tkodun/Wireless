
@tag
Feature: Test to scrape the content of site
  
  Scenario: I counted the number of product displayed
    Given I navigate to url
    And I assert the logo is displayed
    When I grab the title of site
    Then I counted the number of product displayed
  
  Scenario: I want to get only prices of products displayed
    Given I navigate to url
    And I assert the logo is displayed
    When I grab the title of site
    Then I grab all the prices displayed
     
   Scenario: I want to sort the price in desending order
    Given I navigate to url
    And I assert the logo is displayed
    When I grab the title of site
    Then I grab all the prices displayed
    And I order by annual price
    
    
  Scenario: I want to create a JSON array of product options
    Given I navigate to url
    Then I write parkage details in a JSON format.
  