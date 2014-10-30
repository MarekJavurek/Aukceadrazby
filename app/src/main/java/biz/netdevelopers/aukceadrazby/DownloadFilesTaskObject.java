package biz.netdevelopers.aukceadrazby;

import java.net.URL;

public class DownloadFilesTaskObject {
    private URL url;
    private String destination; // ex.: "/sdcard/file_name.extension"

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
