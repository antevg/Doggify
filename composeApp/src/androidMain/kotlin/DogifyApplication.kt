import android.app.Application
import com.eacipher.doggify.di.initKoin
import org.koin.core.context.startKoin


class DogifyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
//        initKoin {
//            androidContext(this@DogifyApplication)
//        }
        startKoin { initKoin() }
       // INSTANCE = this
    }
}