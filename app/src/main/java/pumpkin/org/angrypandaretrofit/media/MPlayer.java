package pumpkin.org.angrypandaretrofit.media;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/10 10:59
 * @des: 以MediaPlayer为基础的播放器
 * @see {@link }
 */

public class MPlayer {

    private static final String TAG = MPlayer.class.getName();
    private static int INVALID_RES_ID = -1;
    private static final float MEDIA_VOLUME_MAX = 1.0f;
    private static final float MEDIA_VOLUME_MIN = 0.0f;

    private MediaPlayer mMediaPlayer;
    private Context mContext;
    private AudioManager mAudioManager;
    private int mCurrentResID;

    public MPlayer(Context context) {
        mContext = context;
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        initPlayer();
    }

    private void initPlayer() {
        mMediaPlayer = new MediaPlayer();

    }

    /**
     * 播放assets目录下的资源
     */
    public void startLocalPlay(String tonename) {

        try {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
                mMediaPlayer.release();
            }
            AssetFileDescriptor fd = mContext.getAssets().openFd(tonename);
            mMediaPlayer.reset();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mMediaPlayer.start();
                }
            });
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mMediaPlayer.release();
                    mCurrentResID = INVALID_RES_ID;
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "startLocalPlay: ", e);
        }

    }

    /**
     * 播放raw目录下的资源
     */
    public synchronized void startLocalPlay(int resId) {
        mCurrentResID = resId;
        String path = "android.resource://" + mContext.getPackageName() + "/" + resId;
        Uri uri = Uri.parse(path);

        try {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.reset();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setDataSource(mContext, uri);
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mMediaPlayer.start();
                }
            });
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mCurrentResID = INVALID_RES_ID;
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "startLocalPlay: ", e);
        } catch (IllegalArgumentException ex) {
            Log.e(TAG, "startLocalPlay: ", ex);
        } catch (SecurityException ex) {
            Log.e(TAG, "startLocalPlay: ", ex);
        }catch (IllegalStateException ex){
            Log.e(TAG, "startLocalPlay: ", ex);
        }finally {
            // todo nothing
        }

    }

    public synchronized void startNetPlay(String url) {
        Uri uri = Uri.parse(url);

        try {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.stop();
            }
            mMediaPlayer.reset();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setDataSource(mContext, uri);
            mMediaPlayer.prepareAsync();
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mMediaPlayer.start();
                }
            });
            mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mCurrentResID = INVALID_RES_ID;
                }
            });
        } catch (IOException e) {
            Log.e(TAG, "startLocalPlay: ", e);
        } catch (IllegalArgumentException ex) {
            Log.e(TAG, "startLocalPlay: ", ex);
        } catch (SecurityException ex) {
            Log.e(TAG, "startLocalPlay: ", ex);
        }catch (IllegalStateException ex){
            Log.e(TAG, "startLocalPlay: ", ex);
        }finally {
            // todo nothing
        }

    }

    public void stopPlay() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer.reset();
        }
    }

    public void setVolume(float letfvol, float rightvol) {
        if (letfvol > MEDIA_VOLUME_MIN && letfvol < MEDIA_VOLUME_MAX) {
            if (rightvol > MEDIA_VOLUME_MIN && rightvol < MEDIA_VOLUME_MAX) {
                mMediaPlayer.setVolume(letfvol, rightvol);
            }
        }
    }

    private int getSystemMusicVolume() {
        int currentVol = 0;
        if (mAudioManager != null) {
            currentVol = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            if (currentVol == 0) {
                currentVol = 3;
                mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, currentVol, 0);
            }
        }
        return currentVol;
    }

    public boolean isPlaying() {
        if (mMediaPlayer != null) {
            return mMediaPlayer.isPlaying();
        }
        return false;
    }

    public int getPlayingResID() {
        return mCurrentResID;
    }

}
