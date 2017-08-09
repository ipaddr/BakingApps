package ipaddr.mobile.ipaddr.id.bakingapps.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by iip on 7/25/17.
 */

public class DisplayUtil {

    public static boolean isSW600dp(Activity activity){
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;

        float widthDpi = metrics.xdpi;
        float heightDpi = metrics.ydpi;
        float widthInches = widthPixels / widthDpi;
        float heightInches = heightPixels / heightDpi;

        //a² + b² = c²
        //The size of the diagonal in inches is equal to the square root of the height in inches squared plus the width in inches squared.
        double diagonalInches = Math.sqrt(
                (widthInches * widthInches)
                        + (heightInches * heightInches));


        if (diagonalInches >= 7) {
            //Device is a 7" tablet
            return true;
        } else {
            return false;
        }

    }

}
