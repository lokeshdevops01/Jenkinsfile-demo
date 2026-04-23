def call () {
  stage ('Build using shared library'){
    sh 'mvn clean package'
  }
} 
