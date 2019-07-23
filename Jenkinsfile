pipeline {
  agent any
  stages {
    stage('S1') {
      steps {
        sh 'echo "First step"'
        echo 'Step Completed'
      }
    }
    stage('S2') {
      parallel {
        stage('S2') {
          steps {
            sh 'echo "Second Stage"'
          }
        }
        stage('S2-1') {
          steps {
            timeout(time: 5)
          }
        }
      }
    }
  }
}