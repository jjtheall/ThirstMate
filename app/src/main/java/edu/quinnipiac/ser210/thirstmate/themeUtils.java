/*
 * ThirstMate App
 * @author: Jack Theall, MacArthur Mills
 * Developed Spring '22
 */

package edu.quinnipiac.ser210.thirstmate;

import android.app.Activity;

public class themeUtils {
    public static String globalTheme = "";

    public static void changeToTheme(String theme){
        globalTheme = theme;
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (globalTheme){
            default:
            case "Original":
                activity.setTheme(R.style.AppTheme);
                break;
            case "Red":
                activity.setTheme(R.style.RedTheme);
                break;
            case "Orange":
                activity.setTheme(R.style.OrangeTheme);
                break;
            case "Yellow":
                activity.setTheme(R.style.YellowTheme);
                break;
            case "Green":
                activity.setTheme(R.style.GreenTheme);
                break;
            case "Blue":
                activity.setTheme(R.style.BlueTheme);
                break;
            case "Pink":
                activity.setTheme(R.style.PinkTheme);
                break;
        }
    }

}
