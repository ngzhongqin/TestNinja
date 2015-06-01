

CLASSPATH="${CLASSPATH}:lib/jxl.jar"
CLASSPATH="${CLASSPATH}:lib/log4j-1.2.17.jar"
CLASSPATH="$CLASSPATH:lib/xml-apis-1.4.01.jar"
CLASSPATH=$CLASSPATH:lib/xercesImpl-2.11.0.jar
CLASSPATH=$CLASSPATH:lib/xalan-2.7.1.jar
CLASSPATH=$CLASSPATH:lib/testng-6.8.5.jar
CLASSPATH=$CLASSPATH:lib/serializer-2.7.1.jar
CLASSPATH=$CLASSPATH:lib/selenium-java-2.45.0.jar
CLASSPATH=$CLASSPATH:lib/selenium-java-2.45.0-srcs.jar
CLASSPATH=$CLASSPATH:lib/sac-1.3.jar
CLASSPATH=$CLASSPATH:lib/protobuf-java-2.4.1.jar
CLASSPATH=$CLASSPATH:lib/phantomjsdriver-1.2.1.jar
CLASSPATH=$CLASSPATH:lib/operadriver-1.5.jar
CLASSPATH=$CLASSPATH:lib/netty-3.5.7.Final.jar
CLASSPATH=$CLASSPATH:lib/nekohtml-1.9.21.jar
CLASSPATH=$CLASSPATH:lib/junit-dep-4.11.jar
CLASSPATH=$CLASSPATH:lib/jna-platform-3.4.0.jar
CLASSPATH=$CLASSPATH:lib/jna-3.4.0.jar
CLASSPATH=$CLASSPATH:lib/jetty-websocket-8.1.8.jar
CLASSPATH=$CLASSPATH:lib/jcommander-1.29.jar
CLASSPATH=$CLASSPATH:lib/ini4j-0.5.2.jar
CLASSPATH=$CLASSPATH:lib/httpmime-4.3.6.jar
CLASSPATH=$CLASSPATH:lib/httpcore-4.3.3.jar
CLASSPATH=$CLASSPATH:lib/httpclient-4.3.6.jar
CLASSPATH=$CLASSPATH:lib/htmlunit-core-js-2.15.jar
CLASSPATH=$CLASSPATH:lib/htmlunit-2.15.jar
CLASSPATH=$CLASSPATH:lib/hamcrest-library-1.3.jar
CLASSPATH=$CLASSPATH:lib/hamcrest-core-1.3.jar
CLASSPATH=$CLASSPATH:lib/guava-18.0.jar
CLASSPATH=$CLASSPATH:lib/gson-2.3.1.jar
CLASSPATH=$CLASSPATH:lib/cssparser-0.9.14.jar
CLASSPATH=$CLASSPATH:lib/commons-logging-1.1.3.jar
CLASSPATH=$CLASSPATH:lib/commons-lang3-3.3.2.jar
CLASSPATH=$CLASSPATH:lib/commons-jxpath-1.3.jar
CLASSPATH=$CLASSPATH:lib/commons-io-2.4.jar
CLASSPATH=$CLASSPATH:lib/commons-exec-1.1.jar
CLASSPATH=$CLASSPATH:lib/commons-collections-3.2.1.jar
CLASSPATH=$CLASSPATH:lib/commons-codec-1.9.jar
CLASSPATH=$CLASSPATH:lib/cglib-nodep-2.1_3.jar
CLASSPATH=$CLASSPATH:lib/bsh-1.3.0.jar
CLASSPATH=$CLASSPATH:lib/apache-mime4j-0.6.jar
CLASSPATH="${CLASSPATH}:TestNinja.jar"

echo $CLASSPATH

export CLASSPATH

java -cp $CLASSPATH sg.ninjavan.autotest.Main  > logs/console.log $


