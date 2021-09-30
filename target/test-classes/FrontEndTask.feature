Feature: View Cryptocurrency Prices, As a user I want to select 100 rows to view 100 records
    Scenario: Task 1
        Given I launch Coin Market Website
        When Select 100 rows to be viewed from website
        Then I should see 100 rows displayed on the page

    Scenario: Task 2
        Given I launch Coin Market Website
        When I click on filter button
        And I click on Add Filter
        When I filter records by MarketCap and Price
