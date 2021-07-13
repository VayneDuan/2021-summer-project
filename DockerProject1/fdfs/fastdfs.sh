#!/bin/bash
if [ ${GROUP_NUM} -eq 1 ];
then
GROUP_NAME="group1"
elif [ ${GROUP_NUM} -eq 2 ];
then 
GROUP_NAME="group2"
else
GROUP_NAME="tracker"
fi

# new_val=$FASTDFS_IPADDR
# old="com.ikingtech.ch116221"

# sed -i "s/$old/$new_val/g" /etc/fdfs/client.conf
# sed -i "s/$old/$new_val/g" /etc/fdfs/storage.conf
# sed -i "s/$old/$new_val/g" /etc/fdfs/mod_fastdfs.conf

sed -i "s/{GROUP_NAME}/${GROUP_NAME}/g" /etc/fdfs/storage.conf
sed -i "s/{GROUP_NAME}/${GROUP_NAME}/g" /etc/fdfs/mod_fastdfs.conf

cat  /etc/fdfs/client.conf > /etc/fdfs/client.txt
cat  /etc/fdfs/storage.conf >  /etc/fdfs/storage.txt
cat  /etc/fdfs/mod_fastdfs.conf > /etc/fdfs/mod_fastdfs.txt

mv /usr/local/nginx/conf/nginx.conf /usr/local/nginx/conf/nginx.conf.t
cp /etc/fdfs/nginx.conf /usr/local/nginx/conf

if [ ${GROUP_NUM} -eq -1 ];
then
echo "start trackerd"
/etc/init.d/fdfs_trackerd start
else
echo "start storage"
/etc/init.d/fdfs_storaged start
fi

echo "start nginx"
/usr/local/nginx/sbin/nginx 

tail -f  /dev/null