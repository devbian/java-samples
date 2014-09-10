java ee的一些例子
========

servlet_start: 里面是一些servlet的知识点，cookie，session，filter, jdbc

spring_rest: 使用spring 以及 spring boot来编写一个rest风格的web，参照 http://spring.io/guides/gs/rest-service/
            完成后，可以mvn clean package & java -jar xxx.jar 来启动一下便携站点，不用配置tomcat，然后，通过http://localhost:8080/greeting来访问。
            对于改变boot启动的端口，http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#howto-change-the-http-port有很好的解释，
            一种是可以使用src/main/resources/application.properties，加入server.port = 8090；另一种，是设置一个环境变量“SERVER_PORT”，值为想要的端口，重新启动程序即可。