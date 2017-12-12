package com.example.zhou.job4.bean;

/**
 * Created by zhou on 2017/12/7.
 */

public class JobBean {


    /**
     * data : {"id":"346","url":"https://www.baidu.com/","type":"android","show_url":"0","appid":"358509","comment":"华为时时彩","createAt":"2017-11-06 09:53:19","updateAt":"2017-11-07 15:45:45"}
     * rt_code : 200
     */

    private DataBean data;
    private String rt_code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getRt_code() {
        return rt_code;
    }

    public void setRt_code(String rt_code) {
        this.rt_code = rt_code;
    }

    public static class DataBean {
        /**
         * id : 346
         * url : https://www.baidu.com/
         * type : android
         * show_url : 0
         * appid : 358509
         * comment : 华为时时彩
         * createAt : 2017-11-06 09:53:19
         * updateAt : 2017-11-07 15:45:45
         */

        private String id;
        private String url;
        private String type;
        private String show_url;
        private String appid;
        private String comment;
        private String createAt;
        private String updateAt;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getShow_url() {
            return show_url;
        }

        public void setShow_url(String show_url) {
            this.show_url = show_url;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCreateAt() {
            return createAt;
        }

        public void setCreateAt(String createAt) {
            this.createAt = createAt;
        }

        public String getUpdateAt() {
            return updateAt;
        }

        public void setUpdateAt(String updateAt) {
            this.updateAt = updateAt;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", url='" + url + '\'' +
                    ", type='" + type + '\'' +
                    ", show_url='" + show_url + '\'' +
                    ", appid='" + appid + '\'' +
                    ", comment='" + comment + '\'' +
                    ", createAt='" + createAt + '\'' +
                    ", updateAt='" + updateAt + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "JobBean{" +
                "data=" + data +
                ", rt_code='" + rt_code + '\'' +
                '}';
    }
}
