node {

def mvnHome

stage('Prepare') {

git url: 'git@github.com:IBM-Project-Team-C/Indian-Airlines.git', branch: 'final-branch'

mvnHome = tool 'mvn'

}

stage('Build') {

if (isUnix()) {

sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"

} else {

bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)

}

}

stage('Unit Test') {

junit '**/target/surefire-reports/TEST-*.xml'

archive 'target/*.jar'

}

stage('Integration Test') {

if (isUnix()) {

sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean verify"

} else {

bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean verify/)

}

}



stage('Sonar') {
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' sonar:sonar"
      } else {
         bat(/"${mvnHome}\bin\mvn" sonar:sonar/)
      }
   }
   



 stage ('Build Docker Image') {
           if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' k8s:build k8s:resource"
      } else {
         bat(/"${mvnHome}\bin\mvn" k8s:build k8s:resource/)
      }
                
            
        }
		
		stage ('Kubernetes Deploy') {
           
             if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' k8s:deploy"
            }
            else {
         bat(/"${mvnHome}\bin\mvn" k8s:deploy/)
      }
        }

stage('Publish') {
      def server = Artifactory.server 'Artifactory'
      def rtMaven = Artifactory.newMavenBuild()
      rtMaven.tool = 'mvn'
      rtMaven.resolver server: server, releaseRepo: 'libs-release', snapshotRepo: 'libs-snapshot'
      rtMaven.deployer server: server, releaseRepo: 'libs-release-local', snapshotRepo: 'libs-snapshot-local'
      def buildInfo = rtMaven.run pom: 'pom.xml', goals: 'install'
      server.publishBuildInfo buildInfo
}



}