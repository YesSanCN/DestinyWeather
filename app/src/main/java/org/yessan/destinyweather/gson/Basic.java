package org.yessan.destinyweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by YesSan on 2017-06-10.
 */

public class Basic {

    @SerializedName( "city" )
    public String cityName;

    @SerializedName( "id" )
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName( "loc" )
        public String updateTime;

    }

}
