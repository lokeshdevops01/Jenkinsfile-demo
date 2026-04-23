pipeline{
  agent any
  tools{
    maven 'maven3.9.15'
    jdk 'java21'
  }
  stages{
    stage('checkout'){
      steps{
        checkout
      }
    }
    stage('package'){
      steps{
        sh 'mvn clean package'
      }
    }
  }
}
