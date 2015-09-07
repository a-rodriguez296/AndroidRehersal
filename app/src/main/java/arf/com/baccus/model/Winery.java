package arf.com.baccus.model;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import arf.com.baccus.R;

/**
 * Created by arodriguez on 9/6/15.
 */
public class Winery {

    private static Winery sInstance = null;
    private List<Wine> mWines = null;


    public static Winery getInstance(){
        if(sInstance == null){
            sInstance = new Winery();
        }
        return sInstance;
    }


    public Winery(){

        Wine vegabal = new Wine("Vegaval","Tinto", R.drawable.logo_facebook,"Casillero del diablo", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);
        Wine bembibre = new Wine("Bembibre","Tinto",R.drawable.logo_facebook,"Bembibre", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);
        Wine zarate = new Wine("Zárate","Tinto",R.drawable.logo_facebook,"Casillero del diablo", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);
        Wine champagne = new Wine("Chapagne","Tinto",R.drawable.logo_facebook,"Casillero del diablo", "http://eltiempo.com","adsfasdfadsf1","Valdepeñas",3);

        mWines = Arrays.asList(new Wine[]{vegabal, bembibre, zarate, champagne});
    }

    public Wine getWine(int index){
        return mWines.get(index);
    }

    public int getWineCount(){
        return mWines.size();
    }


}
