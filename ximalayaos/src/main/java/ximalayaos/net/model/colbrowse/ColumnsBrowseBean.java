/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.colbrowse;
import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * Auto-generated: 2019-09-17 15:19:11
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ColumnsBrowseBean extends BaseResult{

    private List<Values> values;
    private int total_page;
    private int total_count;
    private int current_page;
    public void setValues(List<Values> values) {
         this.values = values;
     }
     public List<Values> getValues() {
         return values;
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

}