import android.app.Application
import com.eacipher.doggify.di.initKoin

class DogifyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}