node {

    // Configure tools
    def jdkHome = tool name: 'JDK21', type: 'hudson.model.JDK'
    def mvnHome = tool name: 'Maven', type: 'hudson.tasks.Maven$MavenInstallation'

    env.JAVA_HOME = jdkHome
    env.PATH = "${jdkHome}\\bin;${mvnHome}\\bin;${env.PATH}"

    try {

        stage('Checkout') {
            checkout scm
        }

        stage('Install Dependencies') {
            bat 'npm install'
        }

        stage('Start App') {
            bat 'start /B npm start'
            sleep(time: 10, unit: 'SECONDS')
        }

        stage('Run Tests') {
            bat 'cd ui-test\\ui-test && mvn test'
        }

    } finally {
        // Optional cleanup (recommended if app keeps running)
        stage('Cleanup') {
            bat 'taskkill /F /IM node.exe || exit 0'
        }
    }
}