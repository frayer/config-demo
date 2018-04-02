cp ../target/config-demo-*.jar ./config-demo.jar
docker build -t config-demo:latest --build-arg JAR_FILE=config-demo.jar .
rm ./config-demo.jar
