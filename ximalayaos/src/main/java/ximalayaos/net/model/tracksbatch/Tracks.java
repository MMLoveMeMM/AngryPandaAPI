/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.tracksbatch;

/**
 * Auto-generated: 2019-09-17 19:32:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Tracks {

    private long id;
    private String kind;
    private String track_title;
    private String track_tags;
    private String track_intro;
    private String cover_url_small;
    private String cover_url_middle;
    private String cover_url_large;
    private Announcer announcer;
    private int duration;
    private int play_count;
    private int favorite_count;
    private int comment_count;
    private int download_count;
    private long play_size_32;
    private long play_size_64;
    private boolean can_download;
    private int download_size;
    private Subordinated_album subordinated_album;
    private int source;
    private long updated_at;
    private long created_at;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setKind(String kind) {
         this.kind = kind;
     }
     public String getKind() {
         return kind;
     }

    public void setTrack_title(String track_title) {
         this.track_title = track_title;
     }
     public String getTrack_title() {
         return track_title;
     }

    public void setTrack_tags(String track_tags) {
         this.track_tags = track_tags;
     }
     public String getTrack_tags() {
         return track_tags;
     }

    public void setTrack_intro(String track_intro) {
         this.track_intro = track_intro;
     }
     public String getTrack_intro() {
         return track_intro;
     }

    public void setCover_url_small(String cover_url_small) {
         this.cover_url_small = cover_url_small;
     }
     public String getCover_url_small() {
         return cover_url_small;
     }

    public void setCover_url_middle(String cover_url_middle) {
         this.cover_url_middle = cover_url_middle;
     }
     public String getCover_url_middle() {
         return cover_url_middle;
     }

    public void setCover_url_large(String cover_url_large) {
         this.cover_url_large = cover_url_large;
     }
     public String getCover_url_large() {
         return cover_url_large;
     }

    public void setAnnouncer(Announcer announcer) {
         this.announcer = announcer;
     }
     public Announcer getAnnouncer() {
         return announcer;
     }

    public void setDuration(int duration) {
         this.duration = duration;
     }
     public int getDuration() {
         return duration;
     }

    public void setPlay_count(int play_count) {
         this.play_count = play_count;
     }
     public int getPlay_count() {
         return play_count;
     }

    public void setFavorite_count(int favorite_count) {
         this.favorite_count = favorite_count;
     }
     public int getFavorite_count() {
         return favorite_count;
     }

    public void setComment_count(int comment_count) {
         this.comment_count = comment_count;
     }
     public int getComment_count() {
         return comment_count;
     }

    public void setDownload_count(int download_count) {
         this.download_count = download_count;
     }
     public int getDownload_count() {
         return download_count;
     }

    public void setPlay_size_32(long play_size_32) {
         this.play_size_32 = play_size_32;
     }
     public long getPlay_size_32() {
         return play_size_32;
     }

    public void setPlay_size_64(long play_size_64) {
         this.play_size_64 = play_size_64;
     }
     public long getPlay_size_64() {
         return play_size_64;
     }

    public void setCan_download(boolean can_download) {
         this.can_download = can_download;
     }
     public boolean getCan_download() {
         return can_download;
     }

    public void setDownload_size(int download_size) {
         this.download_size = download_size;
     }
     public int getDownload_size() {
         return download_size;
     }

    public void setSubordinated_album(Subordinated_album subordinated_album) {
         this.subordinated_album = subordinated_album;
     }
     public Subordinated_album getSubordinated_album() {
         return subordinated_album;
     }

    public void setSource(int source) {
         this.source = source;
     }
     public int getSource() {
         return source;
     }

    public void setUpdated_at(long updated_at) {
         this.updated_at = updated_at;
     }
     public long getUpdated_at() {
         return updated_at;
     }

    public void setCreated_at(long created_at) {
         this.created_at = created_at;
     }
     public long getCreated_at() {
         return created_at;
     }

}