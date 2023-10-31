pipeline {
    agent any
    tools { maven 'maven' }
    options {
        // only keep 10 logs for no more than 10 days
        buildDiscarder(logRotator(daysToKeepStr: '10', numToKeepStr: '10'))
        // cause the build to time out if it runs for more than 12 hours
        timeout(time: 12, unit: 'HOURS')
        // add timestamps to the log
        timestamps()
    }
    triggers {
        pollSCM '*/5 * * * *'
    }
    stages {
        stage('Checkout') {
          steps {
            checkout scm
          }
        }
        stage('Test') {
          steps {
            bat 'mvn test'
          }
        }
        stage('Build') {
          steps {
            bat 'mvn clean install'
          }
        }
    }

    // the post section is a special collection of stages
    // that are run after all other stages have completed
    post {

    }
}
