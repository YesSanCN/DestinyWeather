package org.yessan.destinyweather.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.yessan.destinyweather.db.City;
import org.yessan.destinyweather.db.County;
import org.yessan.destinyweather.db.Province;

/**
 * Created by YesSan on 2017-06-09.
 */

public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     **/
    public static boolean handleProvinceResponse( final String response ) {

        if ( !TextUtils.isEmpty( response ) ) {

            try {

                JSONArray allProvinces = new JSONArray( response );

                for ( int n = 0; n < allProvinces.length(); ++n ) {

                    JSONObject provinceObject = allProvinces.getJSONObject( n );

                    Province province = new Province();
                    province.setProvinceName( provinceObject.getString( "name" ) );
                    province.setProvinceCode( provinceObject.getInt( "id" ) );

                    province.save();

                }

                return true;

            } catch ( JSONException e ) {

                e.printStackTrace();

            }

        }

        return false;

    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse( final String response, final int provinceId ) {

        if ( !TextUtils.isEmpty( response ) ) {

            try {

                JSONArray allCities = new JSONArray( response );

                for ( int n = 0; n < allCities.length(); ++n ) {

                    JSONObject cityObject = allCities.getJSONObject( n );

                    City city = new City();
                    city.setCityName( cityObject.getString( "name" ) );
                    city.setCityCode( cityObject.getInt( "id" ) );
                    city.setProvinceId( provinceId );

                    city.save();

                }

                return true;

            } catch ( JSONException e ) {

                e.printStackTrace();

            }

        }

        return false;

    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse( final String response, final int cityId ) {

        if ( !TextUtils.isEmpty( response ) ) {

            try {

                JSONArray allCounties = new JSONArray( response );

                for ( int n = 0; n < allCounties.length(); ++n ) {

                    JSONObject countyObject = allCounties.getJSONObject( n );

                    County county = new County();
                    county.setCountyName( countyObject.getString( "name" ) );
                    county.setWeatherId( countyObject.getString( "weather_id" ) );
                    county.setCityId( cityId );

                    county.save();

                }

                return true;

            } catch ( JSONException e ) {

                e.printStackTrace();

            }

        }

        return false;

    }

}
