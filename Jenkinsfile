node {

def mvnHome

stage('Prepare') {

git url: 'git@github.com:IBM-Project-Team-C/Indian-Airlines.git', branch: 'Integrated-branch'

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


stage('Deploy') {

sh 'curl -u admin:admin -T target/**.war "http://localhost:5050/manager/text/deploy?path=/ibmdevops&update=true"';

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

stage("Smoke Test"){

sh 'curl --retry-delay 10 --retry 5 "http://localhost:5050/ibmdevops/api/v1/flight"';

}

}