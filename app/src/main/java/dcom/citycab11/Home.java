package dcom.citycab11;

import android.app.Notification;

public class Home {

    private void sendRequestToDriver(String driverId)
    {
            String riderToken = FirebaseInstanceId.getInstance().getToken();
            Notification data=new Notification(riderToken,json_lat_lng);

    }
}
