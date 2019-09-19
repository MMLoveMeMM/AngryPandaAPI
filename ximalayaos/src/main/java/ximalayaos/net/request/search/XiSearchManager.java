package ximalayaos.net.request.search;

import android.content.Context;

import ximalayaos.net.request.IRequest;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: XiSearchManager
 * @Author: 刘志保
 * @CreateDate: 2019/9/18 10:34
 * @Description: 喜马拉雅资源搜索接口类
 */
public class XiSearchManager {
    private static final XiSearchManager ourInstance = new XiSearchManager();

    public static XiSearchManager getInstance() {
        return ourInstance;
    }

    private XiSearchManager() {
    }

    /**
     * 搜索专辑
     * @param context
     * @param q
     * @param iRequest
     */
    public void httpSearchAlbumRequest(Context context, String q, final IRequest iRequest){
        SearchAlbumRequest.httpSearchAlbumRequest(context, q, iRequest);
    }

    /**
     * 搜索专辑
     * @param context
     * @param q
     * @param categoryId
     * @param calcDimension
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpSearchAlbumRequest(Context context, String q, int categoryId, int calcDimension,
                                              int page, int count, final IRequest iRequest){
        SearchAlbumRequest.httpSearchAlbumRequest(context, q, categoryId, calcDimension, page, count, iRequest);
    }

    /**
     * 搜索声音
     * @param context
     * @param q
     * @param categoryId
     * @param calcDimension
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpSearchTracksRequest(Context context,String q, int categoryId, int calcDimension,
                                               int page, int count, final IRequest iRequest){
        SearchTracksRequest.httpSearchTracksRequest(context, q, categoryId, calcDimension, page, count, iRequest);
    }

    /**
     * 多筛选条件搜索专辑
     * @param context
     * @param iRequest
     */
    public void httpSearchAlbumv2Request(Context context,final IRequest iRequest){
        SearchAlbumv2Request.httpSearchAlbumv2Request(context, iRequest);
    }

    /**
     * 多筛选条件搜索专辑
     * @param context
     * @param id
     * @param title
     * @param uid
     * @param nickname
     * @param tags
     * @param isPaid
     * @param priceType
     * @param categoryId
     * @param categoryName
     * @param sortBy
     * @param desc
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpSearchAlbumv2Request(Context context,long id,String title,long uid,
                                                String nickname,String tags,int isPaid,int priceType,
                                                long categoryId,String categoryName,String sortBy,boolean desc,
                                                int page,int count,
                                                final IRequest iRequest){
        SearchAlbumv2Request.httpSearchAlbumv2Request(context, id, title, uid, nickname, tags, isPaid,
                priceType, categoryId, categoryName, sortBy, desc, page, count, iRequest);
    }

    /**
     * 多筛选条件搜索声音
     * @param context
     * @param iRequest
     */
    public void httpSearchTrackv2Request(Context context,final IRequest iRequest){
        SearchTrackv2Request.httpSearchTrackv2Request(context, iRequest);
    }

    /**
     * 多筛选条件搜索声音
     * @param context
     * @param id
     * @param title
     * @param uid
     * @param nickname
     * @param tags
     * @param isPaid
     * @param priceType
     * @param categoryId
     * @param categoryName
     * @param sortBy
     * @param desc
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpSearchTrackv2Request(Context context,long id,String title,long uid,
                                                String nickname,String tags,int isPaid,int priceType,
                                                long categoryId,String categoryName,String sortBy,boolean desc,
                                                int page,int count,
                                                final IRequest iRequest){
        SearchTrackv2Request.httpSearchTrackv2Request(context, id, title, uid, nickname, tags, isPaid,
                priceType, categoryId, categoryName, sortBy, desc, page, count, iRequest);
    }

    /**
     * 获取热搜词
     * @param context
     * @param top
     * @param iRequest
     */
    public void httpSearchHotWordRequest(Context context, int top, final IRequest iRequest){
        SearchHotWordRequest.httpSearchHotWordRequest(context, top, iRequest);
    }

    /**
     * 获取热搜词
     * @param context
     * @param top
     * @param categoryId
     * @param iRequest
     */
    public void httpSearchHotWordRequest(Context context, int top, int categoryId, final IRequest iRequest){
        SearchHotWordRequest.httpSearchHotWordRequest(context, top, categoryId, iRequest);
    }

    /**
     * 搜索词自动提示
     * @param context
     * @param q
     * @param iRequest
     */
    public void httpSearchSuggestWordsRequest(Context context, String q ,final IRequest iRequest){
        SearchSuggestWordsRequest.httpSearchSuggestWordsRequest(context, q, iRequest);
    }

}
