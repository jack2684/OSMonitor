package com.eolwral.osmonitor.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Settings {
	
	private SharedPreferences preferenceMgr = null;
	final public static String PREFRENCE_INTERVAL = "id_preference_interval";
	final public static String PREFERENCE_CPUUSAGE = "id_preference_cpuusage";
	final public static String PREFERENCE_COLOR = "id_preference_color";
	final public static String PREFERENCE_AUTOSTART = "id_preference_autostart";
	final public static String PREFERENCE_EXPERTMODE = "id_preference_expertmode";
	final public static String PREFERENCE_ROOT = "id_preference_root";
	final private static int MODE_MULTI_PROCESS = 4;
	 
	/**
	 * construct 
	 * @param context
	 */
	public Settings(Context context) {
		preferenceMgr =  context.getSharedPreferences(context.getPackageName() + "_preferences",
							MODE_MULTI_PROCESS);
	}

	/**
	 * get update interval
	 * @return interval (seconds)
	 */
	public int getInterval() {
		String interval = preferenceMgr.getString(PREFRENCE_INTERVAL, "2");
		return Integer.parseInt(interval);
	}
	
	/**
	 * enable CPU meter  
	 * @return true == enable, false == disable
	 */
	public boolean enableCPUMeter() {
		return preferenceMgr.getBoolean(PREFERENCE_CPUUSAGE, false);
	}
	
	/**
	 * get color for CPU meter
	 * @return 1 == green, 2 == blue
	 */
	public int chooseColor() {
		String color = preferenceMgr.getString(PREFERENCE_COLOR, "1");
		return Integer.parseInt(color);
	}
	
	/**
	 * start the CPU Meter when reboot
	 * @return true == yes, false == no
	 */
	public boolean enableAutoStart() {
		return preferenceMgr.getBoolean(PREFERENCE_AUTOSTART, false);
	}    
	
	/**
	 * enable expert mode
	 * @return true == yes, false == no
	 */
	public boolean useExpertMode() {
		return preferenceMgr.getBoolean(PREFERENCE_EXPERTMODE, false);
	} 
	
	/**
	 * grant root permission or not
	 * @return true == yes, false == no
	 */
	public boolean isRoot() {
		return preferenceMgr.getBoolean(PREFERENCE_ROOT, false);
	}  

	/**
	 * set a security token
	 * @param token
	 */
	public void setToken(String token) {
		Editor edit = preferenceMgr.edit();
		edit.putString("token", token);
		edit.commit();
	}
	
	/**
	 * get the security token
	 * @return token
	 */
	public String getToken() {
		if(preferenceMgr.getString("token", "").length() == 0 )
			setToken(java.util.UUID.randomUUID().toString());
		return preferenceMgr.getString("token", "");
	}
	
	 
}