/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.searchalbumv2;
import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * Auto-generated: 2019-09-17 17:51:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class SearchAlbumv2Bean extends BaseResult {

    private int category_id;
    private int total_page;
    private int total_count;
    private int current_page;
    private String tag_name;
    private List<Albums> albums;
    public void setCategory_id(int category_id) {
         this.category_id = category_id;
     }
     public int getCategory_id() {
         return category_id;
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

    public void setTag_name(String tag_name) {
         this.tag_name = tag_name;
     }
     public String getTag_name() {
         return tag_name;
     }

    public void setAlbums(List<Albums> albums) {
         this.albums = albums;
     }
     public List<Albums> getAlbums() {
         return albums;
     }

}