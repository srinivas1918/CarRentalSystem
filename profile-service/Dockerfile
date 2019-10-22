#it is a multi stage docker file
#first stage, On the first stage it downloads JDK from Oracle’s, but it can make sense to store your own copy somewhere closer to your build server since it isn’t that small — a little bit less then 200mb. So, it is downloaded, unziped and ready to be used.
FROM debian:9-slim AS builder

RUN set -ex && \
    apt-get update && apt-get install -y wget unzip && \
    wget https://download.java.net/java/GA/jdk11/9/GPL/openjdk-11.0.2_linux-x64_bin.tar.gz -nv -O jdk.tar.gz -nv && \
    mkdir -p /opt/jdk && \
    tar zxvf jdk.tar.gz -C /opt/jdk --strip-components=1 && \
    rm jdk.tar.gz && \
    rm /opt/jdk/lib/src.zip

RUN /opt/jdk/bin/jlink \
    --module-path /opt/jdk/jmods \
    --verbose \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
    --output /opt/jdk-minimal \
    --compress 2 \
    --no-header-files

# Second stage, add only our custom jdk11 distro and our app
# On the second stage it copies results from previous one
FROM debian:9-slim
COPY --from=builder /opt/jdk-minimal /opt/jdk-minimal

ENV JAVA_HOME=/opt/jdk-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"
COPY ./build/libs/profile-service-0.1-SNAPSHOT.jar /profile-service-0.1-SNAPSHOT.jar 
EXPOSE 80
ENTRYPOINT ["java", "-jar", "profile-service-0.1-SNAPSHOT.jar"]
