package ddwucom.mobile.week05.etcapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SoundPool soundPool;
    int sound;

    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sound = soundPool.load(this, R.raw.dingdong, 1);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                soundPool.play(sound, 1, 1, 0, 0, 1);
                break;
            case R.id.button2:
//                vibrator.vibrate(500);
                vibrator.vibrate(new long[] {100, 50, 200, 50}, 0);

                vibrator.cancel();
                break;
        }

    }
}