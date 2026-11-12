FROM eclipse-temurin:17
LABEL maintainer="VagnerSouza2313"
WORKDIR /aplication
COPY target/CadastroPessoas-0.0.1-SNAPSHOT.jar /aplication/CadastroPessoas.jar
ENTRYPOINT ["java", "-jar", "CadastroPessoas.jar"]