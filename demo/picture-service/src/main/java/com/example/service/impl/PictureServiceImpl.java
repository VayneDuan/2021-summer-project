package com.example.service.impl;

import com.example.service.PictureService;
import org.apache.dubbo.config.annotation.Service;
import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

@Service(version ="1.0.0")
public class PictureServiceImpl implements PictureService {
    @Override
    public String uploadPic(String picUrl) {
        TrackerServer ts;
        StorageServer ss;
        try {
            ClientGlobal.init("fastdfs.conf");
            TrackerClient tc = new TrackerClient();
            ts = tc.getTrackerServer();
            ss = tc.getStoreStorage(ts);

            StorageClient sc = new StorageClient(ts, ss);
            String [] result = sc.upload_file(picUrl, "jpg", null);
            String rtUrl = "";
            for(int i=0;i< result.length;i++){
                if(i != 0){
                    rtUrl += "/";
                }
                rtUrl += result[i];
            }
            return rtUrl;
        } catch (IOException | MyException e) {
            e.printStackTrace();
            return null;
        }
    }
}
