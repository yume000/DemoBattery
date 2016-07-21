package com.yume.demobattery;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.TextView;
public class DemoBattery extends Activity {
    private TextView batteryLevelTxt,batteryStatusTxt,batteryHealthTxt,batteryPluggedTxt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        batteryLevelTxt=(TextView)findViewById(R.id.LevelTxt);
        batteryStatusTxt=(TextView)findViewById(R.id.statusTxt);
        batteryHealthTxt=(TextView)findViewById(R.id.healthTxt);
        batteryPluggedTxt=(TextView)findViewById(R.id.pluggedTxt);
        this.registerReceiver(batteryInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED)); //註冊BroadcastReceiver，filter設定為ACTION_BATTERY_CHANGED，它將會在電池狀態改變時觸發其onReceive方法
    }
    private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            int lv=intent.getIntExtra("level",0); //取得目前電量
            //batteryLevelTxt.setText("目前電量>>"+String.format("%s",lv)+String.valueOf(lv)+"%");
            batteryLevelTxt.setText(getResources().getString(R.string.batteryLevelTxt,lv));
            int status = intent.getIntExtra("status", 0); //偵測電池狀態
            String statusString="";
            switch (status) {
                case BatteryManager.BATTERY_STATUS_UNKNOWN: //未知狀態
                    statusString = "unknown";
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING: //充電
                    statusString = "charging";
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING: //放電
                    statusString = "discharging";
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING: //未充電
                    statusString = "not charging";
                    break;
                case BatteryManager.BATTERY_STATUS_FULL: //充滿
                    statusString = "full";
                    break;
            }
            batteryStatusTxt.setText(getResources().getString(R.string.batteryStatusTxt, statusString));
            int health = intent.getIntExtra("health", 0); //電池健康狀態
            String healthString = "";
            switch (health) {
                case BatteryManager.BATTERY_HEALTH_UNKNOWN: //未知
                    healthString = "unknown";
                    break;
                case BatteryManager.BATTERY_HEALTH_GOOD: //良好
                    healthString = "good";
                    break;
                case BatteryManager.BATTERY_HEALTH_OVERHEAT: //電池過熱
                    healthString = "overheat";
                    break;
                case BatteryManager.BATTERY_HEALTH_DEAD: //沒有電
                    healthString = "dead";
                    break;
                case BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE: //電壓過高
                    healthString = "voltage";
                    break;
                case BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE: //未知錯誤
                    healthString = "unspecified failure";
                    break;
            }
            batteryHealthTxt.setText(getResources().getString(R.string.batteryHealthTxt,healthString));

            int plugged = intent.getIntExtra("plugged", 0); //充電方式
            String acString = "";
            switch (plugged) {
                case BatteryManager.BATTERY_PLUGGED_AC:
                    acString = "plugged ac"; //ac充電
                    break;
                case BatteryManager.BATTERY_PLUGGED_USB:
                    acString = "plugged usb"; //usb充電
                    break;
            }
            batteryPluggedTxt.setText(getResources().getString(R.string.batteryPluggedTxt,acString));
        }
    };
}
