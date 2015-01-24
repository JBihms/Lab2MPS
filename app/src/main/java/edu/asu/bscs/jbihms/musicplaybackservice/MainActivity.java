package edu.asu.bscs.jbihms.musicplaybackservice;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//

// TODO add better comments!

//

public class MainActivity extends ActionBarActivity {

    private MusicPlaybackService musicService;
    private Intent playIntent;
    private boolean isBound =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.util.Log.d(getClass().getSimpleName(), "in onCreate()");
        playIntent = null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart(){
    super.onStart();
        android.util.Log.d(getClass().getSimpleName(),"in onStart()");
    }

    public void startPlay(View v){
        android.util.Log.w("ActivityMain","called startPlay()");
        playIntent = new Intent(this, MusicPlaybackService.class);
        playIntent.putExtra(MusicPlaybackService.COMMAND, //intent passes the COMMAD->START call the our service
                            MusicPlaybackService.START);
        startService(playIntent);
    }

    public void pausePlay(View v){
        android.util.Log.w("ActivityMain","called pausePlay()");
        playIntent = new Intent(this, MusicPlaybackService.class);
        playIntent.putExtra(MusicPlaybackService.COMMAND,
                MusicPlaybackService.PAUSE);
        startService(playIntent);
    }

    public void resumePlay(View v){
        android.util.Log.w("ActivityMain","called resumePlay()");
        playIntent = new Intent(this, MusicPlaybackService.class);
        playIntent.putExtra(MusicPlaybackService.COMMAND,
                MusicPlaybackService.RESUME);
        startService(playIntent);
    }

    public void stopPlay(View v){
        android.util.Log.w("ActivityMain","called stopPlay()");
        playIntent = new Intent(this, MusicPlaybackService.class);
        playIntent.putExtra(MusicPlaybackService.COMMAND,
                MusicPlaybackService.STOP);
        startService(playIntent);
    }
    @Override
    protected void onPause(){
        super.onPause();
        android.util.Log.d(getClass().getSimpleName(),"in onPause()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        android.util.Log.d(getClass().getSimpleName(),"in onResume()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        android.util.Log.d(getClass().getSimpleName(),"in onStop()");
    }
}
