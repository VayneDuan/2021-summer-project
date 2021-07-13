# centos 7
FROM centos:7 AS base
# run
RUN yum install git gcc gcc-c++ make automake autoconf libtool pcre pcre-devel zlib zlib-devel openssl-devel wget vim -y \
  &&    cd /usr/local/src  \
  &&    git clone https://gitee.com/fastdfs100/libfastcommon.git --depth 1        \
  &&    git clone https://gitee.com/fastdfs100/fastdfs.git --depth 1    \
  &&    git clone https://gitee.com/fastdfs100/fastdfs-nginx-module.git --depth 1   \
  &&    wget http://nginx.org/download/nginx-1.15.4.tar.gz    \
  &&    tar -zxvf nginx-1.15.4.tar.gz    \
  # &&    mkdir /home/dfs   \
  &&    cd /usr/local/src/  \
  &&    cd libfastcommon/   \
  &&    ./make.sh && ./make.sh install  \
  &&    cd ../  \
  &&    cd fastdfs/   \
  &&    ./make.sh && ./make.sh install  \
  &&    cd ../  \
  &&    cd nginx-1.15.4/  \
  &&    ./configure --add-module=/usr/local/src/fastdfs-nginx-module/src/   \
  &&    make && make install  \
  &&    mkdir -p /fastdfs/client

# export config
# VOLUME /etc/fdfs

RUN ln -s /usr/local/src/fastdfs/init.d/fdfs_trackerd /etc/init.d/fdfs_trackerd \
  && ln -s /usr/local/src/fastdfs/init.d/fdfs_storaged /etc/init.d/fdfs_storaged 

# add configure files
ADD conf/client.conf /etc/fdfs/client.conf
ADD conf/http.conf /etc/fdfs/http.conf
ADD conf/mime.types /etc/fdfs/mime.types
ADD conf/storage.conf /etc/fdfs/storage.conf
ADD conf/tracker.conf /etc/fdfs/tracker.conf
ADD conf/mod_fastdfs.conf /etc/fdfs/mod_fastdfs.conf

# add startup script
ADD fastdfs.sh /home
RUN chmod +x /home/fastdfs.sh

# EXPOSE 22122 23000 8888 80
ENTRYPOINT ["/home/fastdfs.sh"]


FROM base AS tracker
ADD conf/nginx_tracker.conf /etc/fdfs/nginx.conf
EXPOSE 22122 8888



FROM base AS storage
ADD conf/nginx_storage.conf /etc/fdfs/nginx.conf
EXPOSE 23000 8888