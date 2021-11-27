package com.villadeleyva.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.villadeleyva.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}