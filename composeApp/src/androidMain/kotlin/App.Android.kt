import android.app.Application
import com.eacipher.doggify.di.initKoin


class AndroidApp : Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}