package com.steadyseller.easypermissions.sample;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.List;

import com.steadyseller.easypermissions.AfterPermissionGranted;
import com.steadyseller.easypermissions.EasyPermissions;

/**
 * Created in {@link R.layout#activity_main}
 */
public class MainFragment extends Fragment implements EasyPermissions.PermissionCallbacks {

    private static final String TAG = "MainFragment";
    private static final int RC_SMS_PERM = 122;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        // Create view
        View v = inflater.inflate(R.layout.fragment_main, container);

        // Button click listener
        v.findViewById(R.id.button_sms).setOnClickListener(v1 -> smsTask());

        return v;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(RC_SMS_PERM)
    private void smsTask() {
        if (EasyPermissions.hasPermissions(requireContext(), Manifest.permission.READ_SMS)) {
            // Have permission, do the thing!
            Toast.makeText(getActivity(), "TODO: SMS things", Toast.LENGTH_LONG).show();
        } else {
            // Request one permission
            EasyPermissions.requestPermissions(this, getString(R.string.rationale_sms),
                    RC_SMS_PERM, Manifest.permission.READ_SMS);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Log.d(TAG, "onPermissionsGranted:" + requestCode + ":" + perms.size());
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Log.d(TAG, "onPermissionsDenied:" + requestCode + ":" + perms.size());
    }
}
