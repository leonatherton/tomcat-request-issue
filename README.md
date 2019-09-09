1. Generate war with 'mvn clean compile war:war' or 'mvn clean package'.

2. Deploy with Tomcat

3. Assuming Tomcat is hosted on localhost:8080, navigate to http://localhost:8080/tomcat-request-issue/

4. Open the JavaScript console in Developer Tools

5. Submit a small file, observe that a response of "Hello World!" is given in the console

6. Submit a file larger than ~6MB, observe that the request fails

7. Uncomment line 40 in DemoServlet, rebuild the war and redeploy it

8. Retry step 6, observing that a response of "Hello World!" is now given