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
        stage ('build') {
            steps{
              mavenbuild()
            }
          }
        stage ('Deploy to nexus repo'){
          steps {
            sh 'mvn deploy'
          }
        }
      }
    }
        stage('Deploy to EC2') {
             steps {                  
                     sshagent (['target-ssh-key']){
                       ansiblePlaybook(
                         playbook: '/var/lib/jenkins/workspace/deploy-jar.yml',
                         inventory: '/var/lib/jenkins/workspace/inventory.ini',
                         extras: '-e "ansible_ssh_private_key_file=/var/lib/jenkins/workspace/rolls.pem"'
                         )
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
