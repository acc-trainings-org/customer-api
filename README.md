# customer-api

### Window User OpenShift CLI Setup
* Go to https://console-openshift-console.apps.awsopenshift.ne-innovation.com and login with oktaidp
* Create your account using Accenture ID and Sign in to the application
* Click on the ? Icon and select Command Line Tools
* Download the oc CLI as per your OS and extract the zipped file to a directory
* Set path environment variables 

### OpenShift CLI Deployment
* Login to OpenShift [OC Login](https://oauth-openshift.apps.awsopenshift.ne-innovation.com/oauth/authorize?client_id=console&redirect_uri=https%3A%2F%2Fconsole-openshift-console.apps.awsopenshift.ne-innovation.com%2Fauth%2Fcallback&response_type=code&scope=user%3Afull&state=89ae6812)
* Copy login command (Top right click on ? mark and then select Command Line Tool) and then after click on Copy Login Command.
* Open Command Line or Terminal and paste the login command.
* ***Frequently used OC commands***

   1. `oc version` - Check OC CLI Version
   2. `oc status` - Check the status
   3. `oc projects` - To see available projects
   4. `oc new-project acctrainings-firstName` - Create new project. Replace firstName with your name.
   5. `oc projects` - check again the project whether it's created
   6. `oc new-app fabric8/s2i-java:latest-java11~https://github.com/acc-trainings/customer-api.git#customer-api-rahul --name=customer-api` - Create new app under your project.
   7. `oc get services` - To get services
   8. `oc get pods` - To check created pods
   9. `oc get routes` - See available routes for your service.
   10. `oc expose svc/customer-api` - Expose/create route for your application.
   11. `oc get route` - This will give you route to access your deployed application.
   12. `http://copyYourUrl/customer-api/swagger-ui.html` copy your url and add and hit on the browser.
   13. `oc get pods` - Get the pod name
   14. `oc logs pod enterYourPodName` - To check logs
   15. `oc delete all --selector app=customer-api` - Delete deployment.

