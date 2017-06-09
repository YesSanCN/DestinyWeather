package org.yessan.destinyweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by YesSan on 2017-06-09.
 */

public class HttpUtil {

    public static void sendOkHttpRequest( final String address, okhttp3.Callback callback ) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url( address ).build();

        client.newCall( request ).enqueue( callback );

    }

}
