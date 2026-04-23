@Library('my-shared-lib') _
pipeline{
  agent any
  tools{
    maven 'maven3.9.15'
    jdk 'java21'
  }
  parameters {
    choice(
      name: 'STAGE_TO_RUN',
      choices: [
        'ALL',
        'CHECKOUT_ONLY',
        'BUILD_ONLY'
        ],
      description: 'Choose which stage to run'
    )
  }
  stages{
    stage('checkout'){
      when {
        expression {
          params.STAGE_TO_RUN in ['ALL', 'CHECKOUT_ONLY']
        }
      }
      steps{
        checkout scm
      }
    }
    stage('package'){
      when {
        expression {
          params.STAGE_TO_RUN in ['ALL', 'BUILD_ONLY']
        }
      }
      steps{
        mavenbuild()
      }
    }
  }
}
