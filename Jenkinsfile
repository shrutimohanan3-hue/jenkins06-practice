pipeline {
    agent any

    tools {
        jdk 'JDK'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Dependencies') {
            steps {
                bat 'npm install'
            }
        }

        stage('Start App') {
            steps {
                bat 'start /B npm start'
                sleep 10
            }
        }

        stage('Run Tests') {
            steps {
                bat 'cd ui-test\\ui-test && mvn test'
            }
        }
    }
}