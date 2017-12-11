package com.example.zhou.job4.model;

/**
 * Created by junbo on 2016/4/6.
 */
public class ApiVersion implements ILottery{
    /**
     * name : fir.im
     * version : 1.0
     * changelog : 更新日志
     * versionShort : 1.0.5
     * build : 6
     * installUrl : http://download.fir.im/v2/app/install/xxxxxxxxxxxxxxxxxxxx?download_token=xxxxxxxxxxxxxxxxxxxxxxxxxxxx
     * install_url : http://download.fir.im/v2/app/install/xxxxxxxxxxxxxxxx?download_token=xxxxxxxxxxxxxxxxxxxxxxxxxxxx
     * update_url : http://fir.im/fir
     * binary : {"fsize":6446245}
     */

    private String name;
    private String version;
    private String changelog;
    private String versionShort;
    private String build;
    private String installUrl;
    private String install_url;
    private String update_url;
    /**
     * fsize : 6446245
     */

    private BinaryEntity binary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    public String getVersionShort() {
        return versionShort;
    }

    public void setVersionShort(String versionShort) {
        this.versionShort = versionShort;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getInstallUrl() {
        return installUrl;
    }

    public void setInstallUrl(String installUrl) {
        this.installUrl = installUrl;
    }

    public String getInstall_url() {
        return install_url;
    }

    public void setInstall_url(String install_url) {
        this.install_url = install_url;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    public BinaryEntity getBinary() {
        return binary;
    }

    public void setBinary(BinaryEntity binary) {
        this.binary = binary;
    }

    public static class BinaryEntity {
        private int fsize;

        public int getFsize() {
            return fsize;
        }

        public void setFsize(int fsize) {
            this.fsize = fsize;
        }
    }
}
