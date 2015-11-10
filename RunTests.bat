cd C:\Users\Vladimir\Documents\Eclipse\Java-for-testers\addressbook-selenium-tests
java -cp .\bin;"C:\Program Files\xstream-1.4.8\lib\xstream-1.4.8.jar";"C:\Program Files\xstream-1.4.8\lib\xstream\xmlpull-1.1.3.1.jar";"C:\Program Files\xstream-1.4.8\lib\xstream\xpp3_min-1.1.4c.jar";"C:\Program Files\Java\selenium-server-standalone-2.47.1.jar" -Dconfig=default.properties org.testng.TestNG mySuite.xml > RunTestsReport.txt
pause
