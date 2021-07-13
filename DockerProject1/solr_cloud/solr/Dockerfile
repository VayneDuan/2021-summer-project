FROM solr:8.9.0 AS solr_app
ARG SOLR_VERSION=8.9.0
ARG TimeZone=Asia/Shanghai
# USER root
# RUN mkdir /opt/solr/server/solr/configsets/myconfig/
COPY ./conf/ /opt/solr/server/solr/configsets/myconfig/conf/
COPY ./plugin/ik/ik-analyzer-8.3.0.jar ./plugin/ik/ik-analyzer-solr7-7.x.jar /opt/solr-$SOLR_VERSION/server/solr-webapp/webapp/WEB-INF/lib/
COPY ./plugin/ik/ik-config/* "/opt/solr-$SOLR_VERSION/server/solr-webapp/webapp/WEB-INF/classes/"
# COPY ../../mysql/utils/mysql-connector-java-8.0.23.tar.gz /opt/solr-$SOLR_VERSION/server/solr-webapp/webapp/WEB-INF/lib/
WORKDIR /opt/
RUN wget https://downloads.mysql.com/archives/get/p/3/file/mysql-connector-java-8.0.23.tar.gz; \
    cp mysql-connector-java-8.0.23/mysql-connector-java-8.0.23.jar /opt/solr-$SOLR_VERSION/server/solr-webapp/webapp/WEB-INF/lib/; \
    rm -rf mysql-connector-java-8.0.23/


ENTRYPOINT [ "solr-precreate" ]
CMD [ "mycore",  "/opt/solr/server/solr/configsets/myconfig" ]
USER $SOLR_USER
