package com.vasyl.velhus.lost;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class Launcher extends AndroidApplication {
    AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
    @Override
    protected void onCreate(@Nullable Bundle s) {
        androidScreenSetup();
        super.onCreate(s);
        switchToGDX();
    }
    @SuppressLint("SourceLockedOrientationActivity")
    private void androidScreenSetup(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    private void switchToGDX(){
        cfg.useAccelerometer=false;
        cfg.useCompass=false;
        cfg.hideStatusBar=true;
        cfg.useWakelock=true;
        initialize(new LostGame(),cfg);
    }
}
