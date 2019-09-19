/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.searchalbumv2;
import java.util.List;

/**
 * Auto-generated: 2019-09-17 17:51:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Albums {

    private long id;
    private String kind;
    private int category_id;
    private String album_title;
    private String album_tags;
    private String album_intro;
    private String cover_url_small;
    private String cover_url_middle;
    private String cover_url_large;
    private boolean tracks_natural_ordered;
    private Announcer announcer;
    private long play_count;
    private int favorite_count;
    private long share_count;
    private long subscribe_count;
    private int include_track_count;
    private Last_uptrack last_uptrack;
    private boolean can_download;
    private int is_finished;
    private long updated_at;
    private long created_at;
    private boolean is_paid;
    private int estimated_track_count;
    private String album_rich_intro;
    private String speaker_intro;
    private int free_track_count;
    private String free_track_ids;
    private String sale_intro;
    private String expected_revenue;
    private String buy_notes;
    private String speaker_title;
    private String speaker_content;
    private boolean has_sample;
    private int composed_price_type;
    private String price_type_detail;
    private List<Price_type_info> price_type_info;
    private String detail_banner_url;
    private String album_score;
    private String outline;
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

    public void setCategory_id(int category_id) {
         this.category_id = category_id;
     }
     public int getCategory_id() {
         return category_id;
     }

    public void setAlbum_title(String album_title) {
         this.album_title = album_title;
     }
     public String getAlbum_title() {
         return album_title;
     }

    public void setAlbum_tags(String album_tags) {
         this.album_tags = album_tags;
     }
     public String getAlbum_tags() {
         return album_tags;
     }

    public void setAlbum_intro(String album_intro) {
         this.album_intro = album_intro;
     }
     public String getAlbum_intro() {
         return album_intro;
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

    public void setTracks_natural_ordered(boolean tracks_natural_ordered) {
         this.tracks_natural_ordered = tracks_natural_ordered;
     }
     public boolean getTracks_natural_ordered() {
         return tracks_natural_ordered;
     }

    public void setAnnouncer(Announcer announcer) {
         this.announcer = announcer;
     }
     public Announcer getAnnouncer() {
         return announcer;
     }

    public void setPlay_count(long play_count) {
         this.play_count = play_count;
     }
     public long getPlay_count() {
         return play_count;
     }

    public void setFavorite_count(int favorite_count) {
         this.favorite_count = favorite_count;
     }
     public int getFavorite_count() {
         return favorite_count;
     }

    public void setShare_count(long share_count) {
         this.share_count = share_count;
     }
     public long getShare_count() {
         return share_count;
     }

    public void setSubscribe_count(long subscribe_count) {
         this.subscribe_count = subscribe_count;
     }
     public long getSubscribe_count() {
         return subscribe_count;
     }

    public void setInclude_track_count(int include_track_count) {
         this.include_track_count = include_track_count;
     }
     public int getInclude_track_count() {
         return include_track_count;
     }

    public void setLast_uptrack(Last_uptrack last_uptrack) {
         this.last_uptrack = last_uptrack;
     }
     public Last_uptrack getLast_uptrack() {
         return last_uptrack;
     }

    public void setCan_download(boolean can_download) {
         this.can_download = can_download;
     }
     public boolean getCan_download() {
         return can_download;
     }

    public void setIs_finished(int is_finished) {
         this.is_finished = is_finished;
     }
     public int getIs_finished() {
         return is_finished;
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

    public void setIs_paid(boolean is_paid) {
         this.is_paid = is_paid;
     }
     public boolean getIs_paid() {
         return is_paid;
     }

    public void setEstimated_track_count(int estimated_track_count) {
         this.estimated_track_count = estimated_track_count;
     }
     public int getEstimated_track_count() {
         return estimated_track_count;
     }

    public void setAlbum_rich_intro(String album_rich_intro) {
         this.album_rich_intro = album_rich_intro;
     }
     public String getAlbum_rich_intro() {
         return album_rich_intro;
     }

    public void setSpeaker_intro(String speaker_intro) {
         this.speaker_intro = speaker_intro;
     }
     public String getSpeaker_intro() {
         return speaker_intro;
     }

    public void setFree_track_count(int free_track_count) {
         this.free_track_count = free_track_count;
     }
     public int getFree_track_count() {
         return free_track_count;
     }

    public void setFree_track_ids(String free_track_ids) {
         this.free_track_ids = free_track_ids;
     }
     public String getFree_track_ids() {
         return free_track_ids;
     }

    public void setSale_intro(String sale_intro) {
         this.sale_intro = sale_intro;
     }
     public String getSale_intro() {
         return sale_intro;
     }

    public void setExpected_revenue(String expected_revenue) {
         this.expected_revenue = expected_revenue;
     }
     public String getExpected_revenue() {
         return expected_revenue;
     }

    public void setBuy_notes(String buy_notes) {
         this.buy_notes = buy_notes;
     }
     public String getBuy_notes() {
         return buy_notes;
     }

    public void setSpeaker_title(String speaker_title) {
         this.speaker_title = speaker_title;
     }
     public String getSpeaker_title() {
         return speaker_title;
     }

    public void setSpeaker_content(String speaker_content) {
         this.speaker_content = speaker_content;
     }
     public String getSpeaker_content() {
         return speaker_content;
     }

    public void setHas_sample(boolean has_sample) {
         this.has_sample = has_sample;
     }
     public boolean getHas_sample() {
         return has_sample;
     }

    public void setComposed_price_type(int composed_price_type) {
         this.composed_price_type = composed_price_type;
     }
     public int getComposed_price_type() {
         return composed_price_type;
     }

    public void setPrice_type_detail(String price_type_detail) {
         this.price_type_detail = price_type_detail;
     }
     public String getPrice_type_detail() {
         return price_type_detail;
     }

    public void setPrice_type_info(List<Price_type_info> price_type_info) {
         this.price_type_info = price_type_info;
     }
     public List<Price_type_info> getPrice_type_info() {
         return price_type_info;
     }

    public void setDetail_banner_url(String detail_banner_url) {
         this.detail_banner_url = detail_banner_url;
     }
     public String getDetail_banner_url() {
         return detail_banner_url;
     }

    public void setAlbum_score(String album_score) {
         this.album_score = album_score;
     }
     public String getAlbum_score() {
         return album_score;
     }

    public void setOutline(String outline) {
         this.outline = outline;
     }
     public String getOutline() {
         return outline;
     }

}