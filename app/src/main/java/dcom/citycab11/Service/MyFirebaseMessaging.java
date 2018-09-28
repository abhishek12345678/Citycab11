package dcom.citycab11.Service;

import android.content.Intent;
import android.os.Looper;
import android.widget.Toast;.import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyFirebaseMessaging {

    Intent.putExtra("customer",remoteMessage.getNotification().getTitle());

    public void onMessageReceived(final RemoteMessage remoteMessage)
    {
        Handler handler = new Handler(Looper.getMainLooper()) {
           handler.post(new Runnable())
            {
                   public void run()
                {
                    Toast.makeText(MyFirebaseMessaging.this," "+ remoteMessage.getNotification().getBody(),Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
