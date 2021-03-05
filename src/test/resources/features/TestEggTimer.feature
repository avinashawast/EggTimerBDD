Feature: E2E tests for EggTimer website

Scenario Outline: Verify if timer is working properly
Given Eggtimer website is available
And Homepage is loaded properly
When User enters "<time>" and clicks Start button
Then Countdown timer should start
And Counter should decrement by 1 second till <expectedTimeTaken> seconds 
    
    Examples:
      |time      | expectedTimeTaken | 
      |25        |     25          |
      |2 minutes |     120         |
      |15 seconds|     15          | 

