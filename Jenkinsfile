pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean verify -Ptarget-default'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify -Ptarget-4_5-mars'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
