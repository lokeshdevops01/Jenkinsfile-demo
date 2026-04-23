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
    stage('deploy'){
      steps{
        sh 'mvn clean deploy'
      }
    }
  }
}
