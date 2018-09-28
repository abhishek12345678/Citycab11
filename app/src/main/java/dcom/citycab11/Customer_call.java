package dcom.citycab11;

import android.app.Notification;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Customer_call extends AppCompatActivity {

    Button btnCancal,btnAccept;
    String customerId;
    IFCMService mFCMService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_call);


        mFCMService=Common.getFCMService();
        btnAccept = (Button)findViewById(R.id.btnAccept);
        btnCancal =  (Button)findViewById(R.id.btnDecline);

            btnCancal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(!TextUtils.isEmpty(customerId))
                        cancelBooking(customerId);



                }
            });

            if(getIntent() !=null)
            {
                customerId = getIntent().getStringExtra("customer");
            }
    }

    private void cancelBooking(String customerId)
    {
        Token token=new Token(customerId);
        Notification notification = new Notification("Notice!","Driver has cancelled yout request");
        Sender sender=new Sender(token.getToken(),notification);

        mFCMService.sendMessage(sender)
                .enqueue(new Callback<FCMResponse>() {

                    public void onResponse(Call<FCMResponse> call, Response<FCMResponse> response) {

                        if(response.body().success == 1)
                        {
                            Toast.makeText(Customer_call.this,"Cancelled",Toast.LENGTH_LONG).show();
                            finish();
                        }

                    }

                    public void onFailure(Call<FCMResponse> call, Throwable t) {

                    }

                }
    }


}
