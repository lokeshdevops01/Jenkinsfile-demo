@Library('my-shared-lib') _
pipeline{
  agent any
  tools{
    maven 'maven3.9.15'
    jdk 'java21'
  }
  stages{
    stage('checkout'){
      steps{
        checkout scm
      }
    }
    stage ('sonarcube scan'){
      steps {
        withSonarQubeEnv('sonarqube') {
          sh 'mvn sonar:sonar'
        }        
      }
    }
    stage ('parallel jobs') {
      parallel {
        stage ('Unit Test') {
          steps {
            checkout scm
            sh 'mvn clean test'
          }
        }
        stage('SonarQube Scan') { 
            steps { 
                withSonarQubeEnv('sonarqube') { 
                    sh ''' 
                    mvn clean verify org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594:sonar \
                    -Dsonar.projectKey=simple-java \
                    -Dsonar.projectName=simple-java 
                    ''' 
                } 
            } 
        } 
        stage ('build') {
            steps{
              mavenbuild()
            }
          }        
          stage('Deploy to Nexus') {
              steps {                  
                      sh 'mvn clean deploy'
                  }
              }
          }
        }
      stage ('post build') {
        steps {
          echo ("Build Completed Successfully")
        }
      }
  }
}
