FROM openjdk:18-jdk-slim
ARG JAR_FILE=target/PokemonApi-1.0.0.jar
COPY ${JAR_FILE} pokemon_api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "pokemon_api.jar"]
