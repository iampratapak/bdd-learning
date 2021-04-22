Feature: Calculator Mathematical Operations

  Narrative: The Calculator controller provides functionality to do addition operation

  Scenario Outline: Verify that addition of 2 numbers are correct
    Given calculator service is running
    When invoke get api with "<input1>" and "<input2>"
    Then verify the response "<response>"
    And verify result "<result>"

    Examples:
    |input1|input2|response|result|
    |1     |2     |200     |3     |
    |-3    |-6    |200     |-9    |
    |-8    |4     |200     |-4    |
    |-4    |8     |200     |4     |
    |0     |0     |200     |0     |

  Scenario Outline: Verify that 5 as input1 throws exception
    Given calculator service is running
    When invoke get api with "<input1>" and "<input2>"
    Then verify the response "<response>"
    And verify error message "<errorMessage>"

    Examples:
    |input1|input2|response|errorMessage|
    |5     |2     |500     |Internal Server Error|


