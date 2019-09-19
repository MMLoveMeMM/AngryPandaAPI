/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.searchtrackv2;
import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * Auto-generated: 2019-09-17 18:5:8
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SearchTrackv2Bean extends BaseResult {

    private long total_page;
    private long total_count;
    private int current_page;
    private List<Tracks> tracks;
    public void setTotal_page(long total_page) {
         this.total_page = total_page;
     }
     public long getTotal_page() {
         return total_page;
     }

    public void setTotal_count(long total_count) {
         this.total_count = total_count;
     }
     public long getTotal_count() {
         return total_count;
     }

    public void setCurrent_page(int current_page) {
         this.current_page = current_page;
     }
     public int getCurrent_page() {
         return current_page;
     }

    public void setTracks(List<Tracks> tracks) {
         this.tracks = tracks;
     }
     public List<Tracks> getTracks() {
         return tracks;
     }

}