/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.rankslist;
import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * Auto-generated: 2019-09-17 14:34:43
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RankListBean extends BaseResult{

    private String rank_key;
    private String kind;
    private int rank_list_id;
    private String rank_title;
    private int rank_type;
    private String rank_sub_title;
    private int rank_period;
    private String rank_period_type;
    private int rank_item_num;
    private int rank_order_num;
    private String cover_url;
    private String rank_content_type;
    private long rank_first_item_id;
    private String rank_first_item_title;
    private List<Index_rank_items> index_rank_items;
    public void setRank_key(String rank_key) {
         this.rank_key = rank_key;
     }
     public String getRank_key() {
         return rank_key;
     }

    public void setKind(String kind) {
         this.kind = kind;
     }
     public String getKind() {
         return kind;
     }

    public void setRank_list_id(int rank_list_id) {
         this.rank_list_id = rank_list_id;
     }
     public int getRank_list_id() {
         return rank_list_id;
     }

    public void setRank_title(String rank_title) {
         this.rank_title = rank_title;
     }
     public String getRank_title() {
         return rank_title;
     }

    public void setRank_type(int rank_type) {
         this.rank_type = rank_type;
     }
     public int getRank_type() {
         return rank_type;
     }

    public void setRank_sub_title(String rank_sub_title) {
         this.rank_sub_title = rank_sub_title;
     }
     public String getRank_sub_title() {
         return rank_sub_title;
     }

    public void setRank_period(int rank_period) {
         this.rank_period = rank_period;
     }
     public int getRank_period() {
         return rank_period;
     }

    public void setRank_period_type(String rank_period_type) {
         this.rank_period_type = rank_period_type;
     }
     public String getRank_period_type() {
         return rank_period_type;
     }

    public void setRank_item_num(int rank_item_num) {
         this.rank_item_num = rank_item_num;
     }
     public int getRank_item_num() {
         return rank_item_num;
     }

    public void setRank_order_num(int rank_order_num) {
         this.rank_order_num = rank_order_num;
     }
     public int getRank_order_num() {
         return rank_order_num;
     }

    public void setCover_url(String cover_url) {
         this.cover_url = cover_url;
     }
     public String getCover_url() {
         return cover_url;
     }

    public void setRank_content_type(String rank_content_type) {
         this.rank_content_type = rank_content_type;
     }
     public String getRank_content_type() {
         return rank_content_type;
     }

    public void setRank_first_item_id(long rank_first_item_id) {
         this.rank_first_item_id = rank_first_item_id;
     }
     public long getRank_first_item_id() {
         return rank_first_item_id;
     }

    public void setRank_first_item_title(String rank_first_item_title) {
         this.rank_first_item_title = rank_first_item_title;
     }
     public String getRank_first_item_title() {
         return rank_first_item_title;
     }

    public void setIndex_rank_items(List<Index_rank_items> index_rank_items) {
         this.index_rank_items = index_rank_items;
     }
     public List<Index_rank_items> getIndex_rank_items() {
         return index_rank_items;
     }

}