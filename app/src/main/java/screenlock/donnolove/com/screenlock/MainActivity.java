package screenlock.donnolove.com.screenlock;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private DevicePolicyManager mDevicePolicyManager;
    private ComponentName mAdminComponent;
    private boolean isAdminActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(checkAdminComponent())
            this.mDevicePolicyManager.lockNow();

    }


    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }

    private boolean checkAdminComponent(){
        this.mAdminComponent = new ComponentName(this, mDeviceAdminReceiver.class);
        this.mDevicePolicyManager = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
        isAdminActive = mDevicePolicyManager.isAdminActive(mAdminComponent);

        if(!isAdminActive){
            Intent intent = new Intent();
            //指定動作
            intent.setAction(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            //指定给那個組件授權
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mAdminComponent);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, getString(R.string.str_screenlock_descript_2));//some description
            startActivity(intent);
        }
        return isAdminActive;
    }

}
