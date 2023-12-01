package com.CoboSoft.androidprimerproyecto.Settings

import android.bluetooth.BluetoothA2dp

data class SettingsModel (
    var volume:Int,
    var bluetooth:Boolean,
    var darkMode:Boolean,
    var vibration:Boolean) {

}