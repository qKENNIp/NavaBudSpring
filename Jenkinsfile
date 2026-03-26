pipeline {
    agent any

    tools {
        maven 'Maven-3.8'
        jdk 'JDK-21'
    }

    environment {
        APP_NAME = 'NavaBudSpring'
        JAR_NAME = 'NavaBudSpring-0.0.1-SNAPSHOT.jar'
    }

    stages {

        stage('Checkout') {
            steps {
                echo "📥 Получаем код..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "🔨 Компилируем Spring Boot проект..."
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Запускаем тесты..."
                // -Dspring.autoconfigure.exclude - отключаем БД во время тестов
                sh '''
                    mvn test \
                    -Dspring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration,\
org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
                '''
            }
            post {
                always {
                    junit allowEmptyResults: true,
                          testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo "📦 Собираем JAR..."
                sh 'mvn package -DskipTests'
            }
            post {
                success {
                    archiveArtifacts artifacts: "target/${JAR_NAME}",
                                     fingerprint: true
                    echo "✅ JAR собран: ${JAR_NAME}"
                }
            }
        }
    }

    post {
        success {
            echo '✅ Пайплайн завершён успешно!'
        }
        failure {
            echo '❌ Пайплайн упал! Смотри логи выше.'
        }
        always {
            cleanWs() // чистим workspace после билда
        }
    }
}
