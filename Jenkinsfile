@Library('my-shared-lib') _
pipeline{
  agent any
  tools{
    maven 'maven3.9.15'
    jdk 'java21'
  }
  parameters {
    booleanParam(
      name: 'SKIP_BUILD',
      defaultValue: false,
      description: 'skip the build stage'
    )
  }
  stages{
    stage('checkout'){
      steps{
        checkout scm
      }
    }
    stage('package'){
      when {
        expression { !params.SKIP_BUILD }
      }
      steps{
        mavenbuild()
      }
    }
  }
}
