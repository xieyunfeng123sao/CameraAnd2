package com.ityun.cameraand2;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.SurfaceView;

/**
 * @user xie
 * @date 2019/1/3 0003
 * @email 773675907@qq.com.
 */

public class CameraFactory {

    public static CameraFactory cameraFactory = new CameraFactory();

    CameraInterface cameraInterface;

    public static CameraFactory getInstance() {
        return cameraFactory;
    }

    //LOLLIPOP
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void init(Context context, SurfaceView surfaceView) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            //如果小于6.0使用camera
            cameraInterface = new CameraUtil(context);
        } else {
            //版本大于等于6.0使用camera2
            cameraInterface = new Camera2Util(context);
        }
        cameraInterface.startPreview(surfaceView);
    }

    public CameraInterface getCameraInterface() {
        return cameraInterface;
    }
}
