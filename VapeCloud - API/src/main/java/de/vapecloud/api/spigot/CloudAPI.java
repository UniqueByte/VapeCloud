package de.vapecloud.api.spigot;

/*
 * Projectname: VapeCloud
 * Created AT: 15.01.2022/12:56
 * Created by Robin B. (RauchigesEtwas)
 */

public class CloudAPI {

    private static CloudAPI instance;

    public CloudAPI() {
        instance = this;
    }

    public static CloudAPI getInstance() {
        return instance;
    }
}