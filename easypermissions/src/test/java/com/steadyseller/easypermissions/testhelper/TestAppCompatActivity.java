package com.steadyseller.easypermissions.testhelper;

import android.os.Bundle;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.steadyseller.easypermissions.AfterPermissionGranted;
import com.steadyseller.easypermissions.EasyPermissions;
import com.steadyseller.easypermissions.R;

public class TestAppCompatActivity extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks, EasyPermissions.RationaleCallbacks {

    public static final int REQUEST_CODE = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getTheme().applyStyle(R.style.Theme_AppCompat, true);
        super.onCreate(savedInstanceState);
    }

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
