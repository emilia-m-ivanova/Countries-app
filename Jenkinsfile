pipeline {
    agent { node { label 'app' } }
    environment {
        PATH = "/opt/apache-maven-3.8.7/bin:$PATH"
    }
    stages {
        stage('Clone') {
            steps {
            sh 'git clone https://github.com/emilia-m-ivanova/countries-app.git'
        }
        }
        stage('Build') {
            steps {
                sh 'cd countries-app; mvn clean package -Dmaven.test.skip=true'
                }
            }
        stage('Run') {
        steps{
        sh 'cd countries-app; docker-compose up'
        }
       }
     }
}