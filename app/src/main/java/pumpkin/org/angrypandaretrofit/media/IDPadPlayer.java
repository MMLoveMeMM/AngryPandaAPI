package pumpkin.org.angrypandaretrofit.media;

import android.content.Context;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/10 10:58
 * @des: 提供给外界使用播放器的类
 * @see {@link }
 */

public class IDPadPlayer {

    private Context mContext;
    private MPlayer mMPlayer;
    private SPlayer mSPlayer;
    private static IDPadPlayer mIDPadPlayer;

    @IntDef({PlayType.MEDIA_PLAYER_MP, PlayType.MEDIA_PLAYER_SL, PlayType.MEDIA_PLAYER_DTMF})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayType {
        int MEDIA_PLAYER_MP = 0; // 使用meidaplayer播放
        int MEDIA_PLAYER_SL = 1; // 使用SoundPool播放
        int MEDIA_PLAYER_DTMF = 2; // 使用ToneGeneral播放DTMF
    }

    private static int mPlayerType = PlayType.MEDIA_PLAYER_MP;
    private static int INVALID_RES_ID = -1;

    public IDPadPlayer(Context context) {
        mContext = context;
        init();
    }

    public static IDPadPlayer builder(Context context) {
        if (mIDPadPlayer == null) {
            mIDPadPlayer = new IDPadPlayer(context);
        }
        return mIDPadPlayer;
    }

    /**
     * @param mediaType 选择使用何种播放器进行本地资源播放
     */
    public static IDPadPlayer builder(Context context, int mediaType) {
        if (mIDPadPlayer == null) {
            mIDPadPlayer = new IDPadPlayer(context);
        }
        mPlayerType = mediaType;
        return mIDPadPlayer;
    }

    /**
     * @param resId raw目录下的资源id,比如R.raw.hello
     */
    public static IDPadPlayer play(Context context, int resId) {
        if (mIDPadPlayer == null) {
            mIDPadPlayer = new IDPadPlayer(context);
        }
        mIDPadPlayer.play(resId);
        return mIDPadPlayer;
    }

    /**
     * @param localres assets目录下的本地资源名称,比如 hello.wav
     */
    public static IDPadPlayer play(Context context, String localres) {
        if (mIDPadPlayer == null) {
            mIDPadPlayer = new IDPadPlayer(context);
        }
        mIDPadPlayer.play(localres);
        return mIDPadPlayer;
    }

    private void init() {
        mMPlayer = new MPlayer(mContext);
        mSPlayer = new SPlayer(mContext);
    }

    public void mediaType(int type) {
        if (type == PlayType.MEDIA_PLAYER_MP || type == PlayType.MEDIA_PLAYER_SL) {
            mPlayerType = type;
        }
    }

    /**
     * @param left  左声道音量[0.0,1.0f]
     * @param right 右声道音量[0.0,1.0f]
     */
    public void volume(float left, float right) {
        mMPlayer.setVolume(left, right);
    }

    public void play(String localres) {
        if (mPlayerType == PlayType.MEDIA_PLAYER_SL) {
            mSPlayer.startLocalPlay(localres);
        } else {
            // mMPlayer.startLocalPlay(localres);
            mMPlayer.startNetPlay(localres);
        }
    }

    public void play(int resId) {
        if (mPlayerType == PlayType.MEDIA_PLAYER_SL) {
            mSPlayer.startLocalPlay(resId);
        }else if (mPlayerType == PlayType.MEDIA_PLAYER_MP) {
            mMPlayer.startLocalPlay(resId);
        }
    }


    /**
     * 停止播放
     */
    public void stopPlay() {
        if (mPlayerType == PlayType.MEDIA_PLAYER_SL) {
            mSPlayer.stopPlay();
        } else {
            mMPlayer.stopPlay();
        }
    }

    /**
     * 获取当前MediaPlayer播放器的状态
     * 注意 : SoundPool是无法获取播放状态的
     */
    public boolean isPlaying() {
        if (mMPlayer != null) {
            return mMPlayer.isPlaying();
        }
        return false;
    }

    /**
     * 获取正在播放的资源ID
     */
    public int getPlayingResID() {
        if (mMPlayer != null) {
            return mMPlayer.getPlayingResID();
        }
        return INVALID_RES_ID;
    }

}
