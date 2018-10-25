package com.hewuqi.miniapp.baiduwenku.service;

public interface WenkuDownloadService {
    String getVCodeId(String src);
    String getDownloadLink(String src);
    void downloadFile(String src);

}
