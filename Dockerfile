FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Копируем JAR в контейнер
COPY target/*.jar app.jar

# Пробрасываем порт
EXPOSE 8080

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]
