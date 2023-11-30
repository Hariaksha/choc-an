User Manual
This document is a user manual describing how to use the Chocoholics Anonymous data processing software. This software system was created by 7 Computer Science undergraduate students. More information about the project history and goals can be found in the README.md file. 

Section 1: Necessary Downloads
Before using the software, several prerequisites must be installed on your system. First, Eclipse must be downloaded from the official website (https://www.eclipse.org/ide/). Eclipse is an Integrated Development Environment (IDE) created specifically for Java software development. 

Then, you can either download Git separately for version control on this website (https://git-scm.com/downloads), or you can simply download a version of Eclipse that has Git client. We recommend the latter. 

Afterwards, you must download a Java Development Kit (JDK) from the Oracle website (https://www.oracle.com/java/technologies/downloads/). This JDK is not necessary to run Eclipse, but it is needed to develop software in Java. 

Lastly, you will need to create a Bitbucket account to initally access the repository online. Bitbucket can be found at bitbucket.org, and it is a product of Atlassian. Bitbucket is used for collaboration and versioning. When you create your Bitbucket account, you will receive an app password that you must not forget; this password will be used to push and pull, as well as to clone repositories.

Section 2: Cloning the Repository
First, you must open the software Eclipse and the website Bitbucket on your computer. Note that you will see a "Git" side and a "Java" side for development on Eclipse. The Git side allows you to push and pull updates to the repository, and the Java side allows you to interact with Java projects. 

On Bitbucket, find the correct URL for the repository. The correct one for this project is: https://bitbucket.org/tklocklear/fall2023team3/src/master/. Once you are at this URL, click "Clone," make sure that the format is HTTPS and not SSH, and click the copy button to copy the command used to clone the repository. The command should look like "git clone https://Username@bitbucket.org/tklocklear/fall2023team3.git," where "Username" represents your actual username. 

Next, go to Eclipse and click "File," "Import," "Projects from Git," and "Clone URI." Here, you will input the copied command from Bitbucket as well as your Bitbucket username and App Password. From this point on, you may continue clicking "Next" and keep the default settings. However, if you wish, you may choose where in your file directory system your repository will be stored. At the end, click "Finish" to finally import the project. 

Section 3: Build the Java archive (JAR) file
In Eclipse, right-click on the Main.java Java source file. This can be found in the "src" folder within the "Team3_Implementation" folder. Click "Export" from the menu of options, and click on "Runnable JAR file" under "Java." Choose the desired settings and the export destination folder, and then click on "Finish."

Section 4: Run the Program
start

Section 5: Testing Features
start

Section 6: Running Tests
To run tests for the ChocAn program, follow these steps:

1. In Eclipse, right-click on the project and select "Run As" > "JUnit Test."

2. This will execute any unit tests that are available in the project. Review the test results in the JUnit tab in Eclipse to ensure the program functions correctly.

Section 7: Conclusion
You have successfully learned how to run and test the ChocAn program. If you encounter any issues or have questions about the program's functionality, refer to the program's documentation or seek assistance from your development team or instructor. Happy testing!
