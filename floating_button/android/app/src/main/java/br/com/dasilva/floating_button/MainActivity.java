package br.com.dasilva.floating_button;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.yhao.floatwindow.FloatWindow;
import com.yhao.floatwindow.Screen;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {

    private static final String CHANNEL = "floating_button";

    @Override  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this.getFlutterEngine());

         MethodChannel channel = new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL);

    channel.setMethodCallHandlers(
        (call, result) ->  {
            switch (call.method){
                case "create":
                    ImageView imageView = new ImageView(getApplicationContext());
                    imageView.setImageResource(R.drawable.plus);

                    FloatWindow.with(getApplicationContext()).setView(imageView).setWidth(Screen.width, 0.15f).setHeight(Screen.width, 0.15f)
                    .setX(Screen.width, 0.8f)
                    .setY(Screen.height, 0.3f)
                    .setDesktopShow(true)
                    .build();

                break;
                case "show":
                    FloatWindow.get().show();
                break;
                case "hide":
                    FloatWindow.get().hide();
                break;
            }
        }
    );
    }

   
}
