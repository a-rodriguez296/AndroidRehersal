package arf.com.baccus.model;

import java.util.List;

/**
 * Created by arodriguez on 9/6/15.
 */
public class Winery {

    private static Winery sInstance = null:
    private List<Wine> mWines = null;


    public static Winery getInstance(){
        if(sInstance == null){
            sInstance = new Winery();
        }
        return sInstance;
    }

}
