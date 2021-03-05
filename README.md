# Cucumber-Selenium-Sample
Description: This has a sample BDD test for https://e.ggtimer.com/

Dependencies:
1. Java >= 1.8 should be installed.
2. Maven binaries should be installed.
3. Chrome browser should be installed. 
 
Instructions to run:
1. Clone the repo (https://github.com/avinashawast/EggTimerBDD.git)
2. Navigate to $PROJECT_HOME (EggTimerBDD folder)
3. Run below command:
             mvn clean install
             
Alternatively, we can also run by opening the project in any IDE, and follow below instructions:
1. Right Click on Project.
2. Click 'Run As'
3. Select Maven Install

Highlights:
1. Page Factory is used.
2. Scenario Outline with Examples is used in feature file for BDD.
3. Configurations can be defined in config.properties.

Imporvements:
1. Other browsers support can be extended.
2. Better logging support can be added.

Bugs: 
1. https://e.ggtimer.com/ accepts negative numbers also
2. Accepts string with space, like " morning" [Space is added before morning]
3. Doesn't work for very large numbers eg: 99999999999999999
