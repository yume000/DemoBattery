#Android Battery BroadcastReceiver  

### 1. 註冊Broadcast Receiver  

	this.registerReceiver(batteryInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

### 2. 取得目前電量

	intent.getIntExtra("level",0);

### 3. 偵測電池狀態  

> BatteryManager.BATTERY_STATUS_UNKNOWN //未知  

> BatteryManager.BATTERY_STATUS_CHARGING //充電  

> BatteryManager.BATTERY_STATUS_DISCHARGING //放電  

> BatteryManager.BATTERY_STATUS_NOT_CHARGING //未充電  

> BatteryManager.BATTERY_STATUS_FULL //充滿  

	intent.getIntExtra("status", 0);  

### 4. 偵測電池健康狀態  

> BatteryManager.BATTERY_HEALTH_UNKNOWN //未知  

> BatteryManager.BATTERY_HEALTH_GOOD //良好  

> BatteryManager.BATTERY_HEALTH_OVERHEAT //電池過熱  

> BatteryManager.BATTERY_HEALTH_DEAD //沒有電  

> BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE //電壓過高  

>BatteryManager.BATTERY_HEALTH_UNSPECIFIED_FAILURE //未知错误

	intent.getIntExtra("health", 0);

### 5. 充電方式  

> BatteryManager.BATTERY_PLUGGED_AC //AC充電  

> BatteryManager.BATTERY_PLUGGED_USB //USB充電  

	intent.getIntExtra("plugged", 0);


