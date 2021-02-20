# customer-api

### Window User OpenShift CLI Setup
* 

### OpenShift CLI Deployment
* Login to OpenShift [OC Login](https://oauth-openshift.apps.awsopenshift.ne-innovation.com/oauth/authorize?client_id=console&redirect_uri=https%3A%2F%2Fconsole-openshift-console.apps.awsopenshift.ne-innovation.com%2Fauth%2Fcallback&response_type=code&scope=user%3Afull&state=89ae6812)
* Copy login command (Top right click on ? mark and then select Command Line Tool) and then after click on Copy Login Command.
* Open Command Line or Terminal and paste the login command.
* Type following commands
   `oc version` - Check OC CLI Version
   `oc status` - Check the status
   `oc projects` - To see available projects
   `oc new project acctrainings-firstName` - Create new project. Replace firstName with your name.
   `oc projects` - check again the project whether it's created.
   `oc new-app fabric8/s2i-java:latest-java11~https://github.com/acc-trainings/customer-api.git#customer-api-rahul --name=customer-api` - Create new app under your     project.

