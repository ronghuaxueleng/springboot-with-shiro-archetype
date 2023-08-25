FROM openjdk:8

MAINTAINER caoqiang<caoqiang@jiuqi.com.cn>

# Define working directory.
WORKDIR /work/project

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV JAVA_OPTS "-server -Xms128m -Xmx1024m"

ADD ./springboot.jar springboot.jar

# Define default command.
#CMD java -jar dicomServer.jar
