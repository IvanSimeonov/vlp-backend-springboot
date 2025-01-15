FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /vlp

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline -DskipTests

COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /vlp

ARG JAR_FILE=/vlp/target/*jar
COPY --from=builder ${JAR_FILE} /vlp/*.jar
COPY userAssignments ./userAssignments
COPY userCourseImages ./userCourseImages
COPY usersProfileImages ./usersProfileImages

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/vlp/*.jar"]
