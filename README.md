# oozie_notification

git clone https://github.com/HaNeul-Kim/oozie_notification

cd oozie_notification

mvn clean install -DskipTests

cp target/oozie_notification.war $CATALINA_HOME/webapps/<APP>

cd $CATALINA_HOME/webapps/<APP>

jar xvf oozie_notification.war

=== TOMCAT logback 설정

cp $CATALINA_HOME/webapps/<APP>/WEB-INF/lib/slf4j-api-*.jar $CATALINA_HOME/lib/

cp $CATALINA_HOME/webapps/<APP>/WEB-INF/lib/jul-to-slf4j-*.jar $CATALINA_HOME/lib/

cp $CATALINA_HOME/webapps/<APP>/WEB-INF/lib/logback-classic-*.jar $CATALINA_HOME/lib/

cp $CATALINA_HOME/webapps/<APP>/WEB-INF/lib/logback-core-*.jar $CATALINA_HOME/lib/

cp $CATALINA_HOME/conf/logging.properties $CATALINA_HOME/conf/logging.properties.bak

# 아래 두 명령어 중 하나만 해준다. 같은 의미임.
echo "handlers = org.slf4j.bridge.SLF4JBridgeHandler" | tee -a $CATALINA_HOME/conf/logging.properties

echo "handlers = org.slf4j.bridge.SLF4JBridgeHandler" >> $CATALINA_HOME/conf/logging.properties

# VERSION 은 각자 환경에 맞게 바꾼다.
echo "CLASSPATH=\$CATALINA_HOME/lib/jul-to-slf4j-VERSION.jar:\$CATALINA_HOME/lib/slf4j-api-VERSION.jar:\$CATALINA_HOME/lib/logback-classic-VERSION.jar:\$CATALINA_HOME/lib/logback-core-VERSION.jar" >> $CATALINA_HOME/bin/setenv.sh

=== mysql 설정

mysql -u<USER> -p < import.sql

=== put hdfs

hdfs dfs -put input ${nameNode}/user/gpadmin/oozie/wordcount
