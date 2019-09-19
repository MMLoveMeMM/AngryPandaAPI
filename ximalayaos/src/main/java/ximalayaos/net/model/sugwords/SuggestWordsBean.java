/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.sugwords;
import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * Auto-generated: 2019-09-17 19:12:0
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SuggestWordsBean extends BaseResult {

    private int album_total_count;
    private List<Albums> albums;
    private int keyword_total_count;
    private List<Keywords> keywords;
    public void setAlbum_total_count(int album_total_count) {
         this.album_total_count = album_total_count;
     }
     public int getAlbum_total_count() {
         return album_total_count;
     }

    public void setAlbums(List<Albums> albums) {
         this.albums = albums;
     }
     public List<Albums> getAlbums() {
         return albums;
     }

    public void setKeyword_total_count(int keyword_total_count) {
         this.keyword_total_count = keyword_total_count;
     }
     public int getKeyword_total_count() {
         return keyword_total_count;
     }

    public void setKeywords(List<Keywords> keywords) {
         this.keywords = keywords;
     }
     public List<Keywords> getKeywords() {
         return keywords;
     }

}