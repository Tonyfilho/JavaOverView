# Build
mvn clean package && docker build -t academy.pt.glintt/helloWord_JavaEE8 .

# RUN

docker rm -f helloWord_JavaEE8 || true && docker run -d -p 8080:8080 -p 4848:4848 --name helloWord_JavaEE8 academy.pt.glintt/helloWord_JavaEE8 