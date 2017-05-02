package com.example.wjq.app.entityclass;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 王瑞青 on 2017/4/14.
 */

public class ActivityCollector {

    public static List<Activity> activityies = new ArrayList<>();

    public static void addActivity(Activity activity){
        activityies.add(activity) ;
    }

    public static void removeActivity(Activity activity){
        activityies.remove(activity) ;
    }


    public static void finish_All_Activity(){
        for (  Activity activ : activityies    ) {
            if (!activ.isFinishing()){
                activ.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
