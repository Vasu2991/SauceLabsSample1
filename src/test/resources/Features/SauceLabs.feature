Feature: SauceLabs
 

    Scenario Outline: Verify a item can be added to a cart in saucelabs
    Given User launched sauce labs application "<TC>"
    When User selected any item and added a item to the cart "<TC>"
    And User goes to the cart page to submit the order "<TC>"
    And User clicks on chekout and places the order "<TC>"
    
     Examples: 
      | TC | 
      | 1 | 
      #| 2 |
      #| 3 |
   
    

   