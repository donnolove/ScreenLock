package screenlock.donnolove.com.screenlock;

import android.annotation.SuppressLint;
import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

@SuppressLint("NewApi")
public class mDeviceAdminReceiver extends android.app.admin.DeviceAdminReceiver
	{
	@Override  
    public void onReceive(Context context, Intent intent) {  
        super.onReceive(context, intent);
//        Log.e("debug", "onreceiver");
    }  
  
    @Override  
    public void onEnabled(Context context, Intent intent) {
//    	Log.e("debug", "激活使用");
        super.onEnabled(context, intent);  
    }  
  
    @Override  
    public void onDisabled(Context context, Intent intent) {  
//    	Log.e("debug", "取消激活");
        super.onDisabled(context, intent);  
    }  
	}