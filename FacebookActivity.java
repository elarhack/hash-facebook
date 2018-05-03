package com.cuscoup.facebookloguin;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FacebookLoguin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_loguin);
        System.out.print("KeyHashes "+KeyHashes());
    }
    public String KeyHashes(){
        PackageInfo info;
        String KeyHashes = null;
        try {
            info = getPackageManager().getPackageInfo("com.cuscoup.facebookloguin", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                KeyHashes = new String(Base64.encode(md.digest(), 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return KeyHashes;
    }
}
