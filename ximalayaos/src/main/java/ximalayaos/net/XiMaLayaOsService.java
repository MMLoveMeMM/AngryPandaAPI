package ximalayaos.net;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import ximalayaos.net.model.JuHeChengYu;
import ximalayaos.net.model.JuHeNews;
import ximalayaos.net.model.JuHeNewsStr;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/6 19:20
 * @des:
 * @see {@link }
 */
public interface XiMaLayaOsService {

    /**
     * 测试API
     * */
    @POST("/toutiao/index")
    //  此处回调返回的可为任意类型Call<T>，再也不用自己去解析json数据啦！！！
    Observable<JuHeNews> getJuHeMessage(@Body RequestBody body/*@Query("type") String type, @Query("key") String key*/);

    @POST("/toutiao/index")
    Observable<JuHeNewsStr> getJuHeMessageStr(@Body RequestBody body);

    @POST("/chengyu/query")
    Observable<JuHeChengYu> getChengYuMessage(@Body RequestBody body/*@Query("type") String type, @Query("key") String key*/);

    /**
     * 喜马拉雅接口
     */
    /**
     * 获取目录列表
     * @param map 请求参数列表
     * @return
     */
    @GET("/categories/list")
    Call<ResponseBody> getCategoriesList(@QueryMap Map<String, String> map);

    /**
     * 获取标签列表
     * @param map 请求参数列表
     * @return
     */
    @GET("/v2/tags/list")
    Call<ResponseBody> getTagsList(@QueryMap Map<String, String> map);

    /**
     * 获取专辑列表
     * @param map 请求参数列表
     * @return
     */
    @GET("/v2/albums/list")
    Call<ResponseBody> getAlbumsList(@QueryMap Map<String, String> map);

    /**
     * 获取专辑浏览
     * @param map
     * @return
     */
    @GET("/albums/browse")
    Call<ResponseBody> getAlbumBrowseList(@QueryMap Map<String, String> map);

    /**
     * 批量获取专辑信息
     * @param map
     * @return
     */
    @GET("/albums/get_batch")
    Call<ResponseBody> getAlbumBatchList(@QueryMap Map<String, String> map);

    /**
     * 批量获取专辑更新信息
     * @param map
     * @return
     */
    @GET("/albums/get_update_batch")
    Call<ResponseBody> getAlbumBatchUpdateList(@QueryMap Map<String, String> map);

    /**
     * 批量获取声音信息
     * @param map
     * @return
     */
    @GET("/tracks/get_batch")
    Call<ResponseBody> getTracksBatchList(@QueryMap Map<String, String> map);

    /**
     * 获取某条声音在某个专辑内所属声音页信息列表
     * @param map
     * @return
     */
    @GET("/tracks/get_last_play_tracks")
    Call<ResponseBody> getTracksLastPlayList(@QueryMap Map<String, String> map);

    /**
     * 获取某个分类下的元数据列表
     * @param map
     * @return
     */
    @GET("/metadata/list")
    Call<ResponseBody> getMetadataList(@QueryMap Map<String, String> map);

    /**
     * 获取元数据下的专辑列表
     * @param map
     * @return
     */
    @GET("/metadata/albums")
    Call<ResponseBody> getMetadataAblums(@QueryMap Map<String, String> map);

    /**
     * 获取专辑榜单列表
     * @param map
     * @return
     */
    @GET("/v3/ranks/index_list")
    Call<ResponseBody> getRanksList(@QueryMap Map<String, String> map);

    /**
     * 获取专辑榜单详情
     * @param map
     * @return
     */
    @GET("/v3/ranks/albums")
    Call<ResponseBody> getRanksAlbumList(@QueryMap Map<String, String> map);

    /**
     * 批量获取听单信息
     * @param map
     * @return
     */
    @GET("/v2/columns/get_batch")
    Call<ResponseBody> getColumnsBatchList(@QueryMap Map<String, String> map);

    /**
     * 分页获取听单内容
     * @param map
     * @return
     */
    @GET("/v2/columns/browse")
    Call<ResponseBody> getColumnsBrowseList(@QueryMap Map<String, String> map);

    /**
     * 批量获取焦点图信息
     * @param map
     * @return
     */
    @GET("/v3/banners/get_batch")
    Call<ResponseBody> getBannersBatchList(@QueryMap Map<String, String> map);

    /*-----------------------------下面是喜马拉雅的搜索部分-----------------------------------*/
    /**
     * 搜索专辑
     * @param map
     * @return
     */
    @GET("/search/albums")
    Call<ResponseBody> getSearchAlbumList(@QueryMap Map<String, String> map);

    /**
     * 搜索声音
     * @param map
     * @return
     */
    @GET("/search/tracks")
    Call<ResponseBody> getSearchTracksList(@QueryMap Map<String, String> map);

    /**
     * 多筛选条件搜索专辑
     * @param map
     * @return
     */
    @GET("/v2/search/albums")
    Call<ResponseBody> getSearchAlbumv2List(@QueryMap Map<String, String> map);

    /**
     * 多筛选条件搜索声音
     * @param map
     * @return
     */
    @GET("/v2/search/tracks")
    Call<ResponseBody> getSearchTrackv2List(@QueryMap Map<String, String> map);

    /**
     * 获取热搜词
     * @param map
     * @return
     */
    @GET("/search/hot_words")
    Call<ResponseBody> getSearchHotWordList(@QueryMap Map<String, String> map);

    /**
     * 搜索词自动提示
     * @param map
     * @return
     */
    @GET("/search/suggest_words")
    Call<ResponseBody> getSearchSuggestWordsList(@QueryMap Map<String, String> map);

}
