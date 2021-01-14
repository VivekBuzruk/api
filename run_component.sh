java -jar target/api.jar --spring.config.location=application.properties -Djasypt.encryptor.password=hygieiasecret
# java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/api.jar --spring.config.location=application.properties -Djasypt.encryptor.password=hygieiasecret
# Working New
# java -Xdebug -agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n -jar target/api.jar --spring.config.location=application.properties -Djasypt.encryptor.password=hygieiasecret
