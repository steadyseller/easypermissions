package com.steadyseller.easypermissions.testhelper;

import android.app.Activity;

import java.util.List;

import androidx.annotation.NonNull;
import com.steadyseller.easypermissions.AfterPermissionGranted;
import com.steadyseller.easypermissions.EasyPermissions;

public class TestActivity extends Activity
        implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {

    public static final int REQUEST_CODE = 1;

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }

    @AfterPermissionGranted(REQUEST_CODE)
    public void afterPermissionGranted() {

    }

    @Override
    public void onRationaleAccepted(int requestCode) {

    }

    @Override
    public void onRationaleDenied(int requestCode) {

    }
}
