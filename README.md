##這是一個簡易的鎖定螢幕範例

如下圖,必須先取得 Android 系統的裝置管理員權限才可以鎖定螢幕

![image](./wiki/pic/device-2016-05-08-140824_.png =695x1197)

以 device_admin.xml 來描述要跟系統取得哪些權限 (在 AndroidManifest.xml 使用到)

透過 mDeviceAdminReceiver.java 實作跟系統取得權限

在 AndroidManifest.xml 中別忘了定義以下

<receiver android:name=".mDeviceAdminReceiver" android:label="@string/app_name"
            android:description="@string/str_screenlock_descript" android:permission="android.permission.BIND_DEVICE_ADMIN">

            <meta-data android:name="android.app.device_admin"
                android:resource="@xml/device_admin" />

            <intent-filter>
                <action android:name="android.app.action.DEVICE_ADMIN_ENABLED" />
            </intent-filter>

</receiver>