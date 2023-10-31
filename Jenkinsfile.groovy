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
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat(url: 'http://localhost:8181', path: '/demo-jenkins-ci-cd')], war: 'target/*.war'
            }
        }
    }

}
