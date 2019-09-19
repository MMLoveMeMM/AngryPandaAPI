package pumpkin.org.angrypandaretrofit.media;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/10 11:35
 * @des: 以SoundPool为基础的播放器
 * @see {@link }
 */

public class SPlayer {

    private static final String TAG = SPlayer.class.getName();

    private SoundPool mSoundPool;
    private AudioManager mAudioManager;
    private Context mContext;
    private int mStreamId = 0;

    public SPlayer(Context context) {
        mContext = context;
        init();
    }

    public void init() {

        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

        SoundPool.Builder spb = new SoundPool.Builder();
        spb.setMaxStreams(1);
        mSoundPool = spb.build();
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                playNotification(sampleId);
            }
        });
    }

    /**
     * 播放assets目录下的资源
     */
    public void startLocalPlay(String fileName) {
        try {
            stopPlay();
            AssetManager assetManager = mContext.getAssets();
            mSoundPool.load(assetManager.openFd(fileName), 1);
        } catch (IOException e) {
            Log.e(TAG,"startLocalPlay: ",e);
        }
    }

    /**
     * 播放raw目录下的资源
     */
    public void startLocalPlay(int resId) {
        try {
            stopPlay();
            mSoundPool.load(mContext, resId, 1);
        }catch (Resources.NotFoundException e){
            // Log.e(TAG,e);
        }
    }

    private void playNotification(int id) {
        int max = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, max, 0);
        mStreamId = mSoundPool.play(id, max, max, 1, 0, 1);
        if (mStreamId != 0) {
            Log.d(TAG, "mSoundPool.play success" + id);
        } else {
            Log.d(TAG, "mSoundPool.play failed" + id);
            mStreamId = 0;
        }
    }

    public void stopPlay() {
        if (mSoundPool != null && mStreamId != 0) {
            mSoundPool.stop(mStreamId);
        }
    }

}
