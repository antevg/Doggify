package database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.eacipher.doggify.db.DogifyDatabase
import org.koin.core.scope.Scope
import org.koin.android.ext.koin.androidContext

internal actual fun Scope.createDriver(databaseName: String): SqlDriver =
    AndroidSqliteDriver(DogifyDatabase.Schema, androidContext(), databaseName)