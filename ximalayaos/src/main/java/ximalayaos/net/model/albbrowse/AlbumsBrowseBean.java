/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.albbrowse;
import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * Auto-generated: 2019-09-17 10:52:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AlbumsBrowseBean extends BaseResult{

    private long album_id;
    private int total_page;
    private int total_count;
    private int current_page;
    private String album_title;
    private String album_intro;
    private int category_id;
    private String cover_url;
    private String cover_url_small;
    private String cover_url_middle;
    private String cover_url_large;
    private boolean can_download;
    private List<Tracks> tracks;
    private String selling_point;
    private String recommend_reason;
    public void setAlbum_id(long album_id) {
         this.album_id = album_id;
     }
     public long getAlbum_id() {
         return album_id;
     }

    public void setTotal_page(int total_page) {
         this.total_page = total_page;
     }
     public int getTotal_page() {
         return total_page;
     }

    public void setTotal_count(int total_count) {
         this.total_count = total_count;
     }
     public int getTotal_count() {
         return total_count;
     }

    public void setCurrent_page(int current_page) {
         this.current_page = current_page;
     }
     public int getCurrent_page() {
         return current_page;
     }

    public void setAlbum_title(String album_title) {
         this.album_title = album_title;
     }
     public String getAlbum_title() {
         return album_title;
     }

    public void setAlbum_intro(String album_intro) {
         this.album_intro = album_intro;
     }
     public String getAlbum_intro() {
         return album_intro;
     }

    public void setCategory_id(int category_id) {
         this.category_id = category_id;
     }
     public int getCategory_id() {
         return category_id;
     }

    public void setCover_url(String cover_url) {
         this.cover_url = cover_url;
     }
     public String getCover_url() {
         return cover_url;
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

    public void setCan_download(boolean can_download) {
         this.can_download = can_download;
     }
     public boolean getCan_download() {
         return can_download;
     }

    public void setTracks(List<Tracks> tracks) {
         this.tracks = tracks;
     }
     public List<Tracks> getTracks() {
         return tracks;
     }

    public void setSelling_point(String selling_point) {
         this.selling_point = selling_point;
     }
     public String getSelling_point() {
         return selling_point;
     }

    public void setRecommend_reason(String recommend_reason) {
         this.recommend_reason = recommend_reason;
     }
     public String getRecommend_reason() {
         return recommend_reason;
     }

}