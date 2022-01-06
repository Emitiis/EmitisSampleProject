package co.geeksempire.emitis.sampleproject.PreferencesIO.OutputProcess

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ReadPreferences (val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Settings",
        scope = CoroutineScope(SupervisorJob() + Dispatchers.IO))

    fun readPreferencesString(preferenceKey: Preferences.Key<String>, defaultValue: String) : Flow<String> {

        // Key         ->   Value
        //-----------------------
        // Email       ->   "Support@GeeksEmpire.co"
        // Username    ->   "GeeksEmpire"
        // Website     ->   "GeeksEmpire.co"
        // Address     ->   "Earth"

        return context.dataStore.data.map { preferences -> preferences[preferenceKey]?:defaultValue }
    }

    fun readPreferencesBoolean(preferenceKey: Preferences.Key<Int>, defaultValue: Int) : Flow<Int> {

        // Key               ->   Value
        //-----------------------
        // PhoneNumber       ->   0903666
        // Age               ->   357
        // Date              ->   1919
        // PostalCode        ->   123456789

        return context.dataStore.data.map { preferences -> preferences[preferenceKey]?:defaultValue }
    }

}