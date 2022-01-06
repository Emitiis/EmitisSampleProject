package co.geeksempire.emitis.sampleproject.PreferencesIO.InputProcess

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class SavePreferences (val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Settings",
        scope = CoroutineScope(SupervisorJob() + Dispatchers.IO))

    suspend fun savePreferences(preferenceKey: Preferences.Key<String>, inputValue: String) {

        // Key         ->   Value
        //-----------------------
        // Email       ->   "Support@GeeksEmpire.co"
        // Username    ->   "GeeksEmpire"
        // Website     ->   "GeeksEmpire.co"
        // Address     ->   "Earth"

        context.dataStore.edit { settings ->

            settings[preferenceKey] = inputValue

        }
    }

    suspend fun savePreferences(preferenceKey: Preferences.Key<Int>, inputValue: Int) {

        // Key               ->   Value
        //-----------------------
        // PhoneNumber       ->   0903666
        // Age               ->   357
        // Date              ->   1919
        // PostalCode        ->   123456789

        context.dataStore.edit { settings ->

            settings[preferenceKey] = inputValue

        }
    }

}