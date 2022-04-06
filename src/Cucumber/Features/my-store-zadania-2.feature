Feature: Change user information after login

  Scenario Outline: Make order
    Given User is logged to CodersLab shop
    When User chooses Hummingbird Printed Sweater
    Then User chooses size: "<size>"
    Then User chooses quant: "<quant>"
    Then User adds product to cart
    Then User goes to checkout options
    Then User check address
    Then User chooses PrestaShop
    Then User chooses payment Pay by Check
    Then User clicks order with an obligation to pay
    Then Screenshot with confirmation is made

    Examples:
      | size | quant |
      | M    | 5     |
