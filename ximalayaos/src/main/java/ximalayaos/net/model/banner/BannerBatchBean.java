/**
  * Copyright 2019 bejson.com 
  */
package ximalayaos.net.model.banner;
import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * Auto-generated: 2019-09-17 15:33:31
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BannerBatchBean extends BaseResult {

    private List<Banners> banners;
    public void setBanners(List<Banners> banners) {
         this.banners = banners;
     }
     public List<Banners> getBanners() {
         return banners;
     }

}