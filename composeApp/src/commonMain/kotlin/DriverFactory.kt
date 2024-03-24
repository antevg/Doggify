import app.cash.sqldelight.db.SqlDriver
import com.eacipher.doggify.db.DogifyDatabase

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DriverFactory): DogifyDatabase {
    val driver = driverFactory.createDriver()
    val database = DogifyDatabase(driver)
    return database

    // Do more work with the database (see below).
}