All questions are implemented under maven java project WeightWatcherTest.
After dowloading or cloning the project please make sure you are using the pom.xml file which I have uploaded in the same project at location(WeightWatcherTest\pom.xml)

Question 1 is implemented in WeightWatcherTest\src\test\java\question1\ReadingFile.java.
ReadingFile.java can be run as independent java applicaiton ReadingFile.java will read this file WeightWatcherTest\src\test\resources\TestData.xlsx

Question 2 is implemented using Page Object in packages WeightWatcherTest\src\test\java\question2\base and WeightWatcherTest\src\test\java\question2\pages. Testcases are in package WeightWatcherTest\src\test\java\question2\testcases.
Testcases can be run individually as TestNG Test or entire suite of testcases can be run through WeightWatcherTest\src\test\resources\runner\testng.xml

Question 3 is implemented in WeightWatcherTest\src\test\java\question3\RandomNum.java RandomNum.java can be run as indepedent java application RandomNum.java will prompt you to enter lower limit and upper limit to generate 500 random numbers.
After generating 500 random numbers it will prompt to enter the nth smallest number to find from these 500 random numbers.
