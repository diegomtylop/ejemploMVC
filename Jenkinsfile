pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'echo "Hello world"'
                sh 'mvn --version'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                    pwd
                '''
            }
        }
    }
}
