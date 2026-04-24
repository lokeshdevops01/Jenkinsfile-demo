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
    stage ('parallel job') {
      parallel {
        stage('package'){
          steps{
              mavenbuild()
          }
        }
        stage ('unit test') {
          steps {
            echo 'running unit tests'
          }
        }
        stage ('code scan') {
          steps {
            echo 'code scan by sonar cube'
          }
        }
      }
    }
    stage ('post-build') {
      steps {
        echo "Build Completed Successfully"
      }
    }
  }
}
