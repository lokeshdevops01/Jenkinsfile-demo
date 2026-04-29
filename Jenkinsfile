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
    stage ('parallel jobs') {
      parallel {
        stage ('Unit Test') {
          steps {
              dir ('test-ws'){
              checkout scm
              sh 'mvn clean test'
            }
          }
        }
        stage ('Sonarqube scan'){
          steps {
            dir ('sonar-ws'){
              withSonarQubeEnv('sonarqube') {
                checkout scm
                sh 'mvn verify sonar:sonar'
              }        
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
