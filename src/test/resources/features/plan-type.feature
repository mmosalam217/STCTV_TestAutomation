@PlanType
Feature: Plan types
  I want to test different plan types in different markets

  @DifferentMarkets
  Scenario Outline: Test different plan types in different markets
    Given User navigates to the subscriptions page
    When User selects the country "<country>"
    Then The plan type "<plan>" should exist
    And The price for plan "<plan>" should be "<price>"
    And The currency for plan "<plan>" should be "<currency>"

    Examples: 
      | country | plan | price | currency |
      | Kuwait | Lite | 1.2 | KWD |
      | Kuwait | Classic | 2.5 | KWD |
      | Kuwait | Premium | 4.8 | KWD |
      | KSA | Lite | 15 | SAR |
      | KSA | Classic | 25 | SAR |
      | KSA | Premium | 60 | SAR |    
      | Bahrain | Lite | 2 | BHD |
      | Bahrain | Classic | 3 | BHD |
      | Bahrain | Premium | 6 | BHD |    