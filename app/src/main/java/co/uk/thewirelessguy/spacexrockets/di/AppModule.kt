package co.uk.thewirelessguy.spacexrockets.di

import android.content.Context
import android.content.SharedPreferences
import co.uk.thewirelessguy.spacexrockets.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideRocketDao(db: AppDatabase) = db.rocketsDao

    @Singleton
    @Provides
    fun provideSettingsPreferences(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("co.uk.thewirelessguy.spacexrockets.settings_preferences", Context.MODE_PRIVATE)
}