package com.example.mylibrary;

import android.app.Application;
import android.os.StrictMode;

public class MyApp extends Application {
    public MyApp() {
        if(BuildConfig.DEBUG)
            StrictMode.enableDefaults();
    }
}
