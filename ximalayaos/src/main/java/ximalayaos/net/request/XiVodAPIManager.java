package ximalayaos.net.request;

import android.content.Context;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: VodAPIManager
 * @Author: 刘志保
 * @CreateDate: 2019/9/18 10:03
 * @Description: 喜马拉雅资源点播资源获取类
 */
public class XiVodAPIManager {
    private static final XiVodAPIManager ourInstance = new XiVodAPIManager();

    public static XiVodAPIManager getInstance() {
        return ourInstance;
    }

    private XiVodAPIManager() {
    }

    /**
     * 分类列表
     * @param context
     * @param iRequest
     */
    public void httpCategoryRequest(Context context, final IRequest iRequest){
        CategoryRequest.httpCategoryRequest(context, iRequest);
    }

    /**
     * 标签列表
     * @param context
     * @param categoryId
     * @param type
     * @param iRequest
     */
    public void httpTagRequest(Context context,int categoryId,int type, final IRequest iRequest){
        TagRequest.httpTagRequest(context, categoryId, type, iRequest);
    }

    /**
     * 专辑列表
     * @param context
     * @param categoryId
     * @param calcDimension
     * @param iRequest
     */
    public void httpAlbumRequest(Context context, int categoryId, int calcDimension, final IRequest iRequest){
        AlbumRequest.httpAlbumRequest(context, categoryId, calcDimension, iRequest);
    }

    /**
     * 专辑列表
     * @param context
     * @param categoryId
     * @param tagName
     * @param calcDimension
     * @param page
     * @param count
     * @param containsPaid
     * @param iRequest
     */
    public void httpAlbumRequest(Context context, int categoryId, String tagName, int calcDimension,
                                        int page, int count, boolean containsPaid, final IRequest iRequest){
        AlbumRequest.httpAlbumRequest(context, categoryId, tagName, calcDimension, page, count, containsPaid, iRequest);
    }

    /**
     * 专辑浏览
     * @param context
     * @param albumId
     * @param iRequest
     */
    public void httpAlbumBrowseRequest(Context context,int albumId,final IRequest iRequest){
        AlbumBrowseRequest.httpAlbumBrowseRequest(context, albumId, iRequest);
    }

    /**
     * 专辑浏览
     * @param context
     * @param albumId
     * @param sort
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpAlbumBrowseRequest(Context context,int albumId,String sort,int page,int count, final IRequest iRequest){
        AlbumBrowseRequest.httpAlbumBrowseRequest(context, albumId, sort, page, count, iRequest);
    }

    /**
     * 批量获取专辑信息
     * @param context
     * @param ids
     * @param iRequest
     */
    public void httpAlbumBatchRequest(Context context, String ids, final IRequest iRequest){
        AlbumBatchRequest.httpAlbumBatchRequest(context, ids, iRequest);
    }

    /**
     * 批量获取专辑信息
     * @param context
     * @param ids
     * @param withMeta
     * @param iRequest
     */
    public void httpAlbumBatchRequest(Context context, String ids, boolean withMeta, final IRequest iRequest){
        AlbumBatchRequest.httpAlbumBatchRequest(context, ids, withMeta, iRequest);
    }

    /**
     * 批量获取专辑更新信息
     * @param context
     * @param ids
     * @param iRequest
     */
    public void httpAlbumBatchUpdateRequest(Context context,String ids, final IRequest iRequest){
        AlbumBatchUpdateRequest.httpAlbumBatchUpdateRequest(context, ids, iRequest);
    }

    /**
     * 批量获取声音信息
     * @param context
     * @param ids
     * @param onlyPlay
     * @param iRequest
     */
    public void httpTracksBatchRequest(Context context, String ids, boolean onlyPlay, final IRequest iRequest){
        TracksBatchRequest.httpTracksBatchRequest(context, ids, onlyPlay, iRequest);
    }

    /**
     * 获取某条声音在专辑内所属声音页信息列表
     * @param context
     * @param albumId
     * @param trackId
     * @param iRequest
     */
    public void httpTracksLastPlayRequest(Context context,int albumId,int trackId, final IRequest iRequest){
        TracksLastPlayRequest.httpTracksLastPlayRequest(context, albumId, trackId, iRequest);
    }

    /**
     * 获取某条声音在专辑内所属声音页信息列表
     * @param context
     * @param albumId
     * @param trackId
     * @param count
     * @param sort
     * @param containPaid
     * @param iRequest
     */
    public void httpTracksLastPlayRequest(Context context,int albumId,int trackId,int count,
                                                 String sort,boolean containPaid, final IRequest iRequest){
        TracksLastPlayRequest.httpTracksLastPlayRequest(context, albumId, trackId, count, sort, containPaid, iRequest);
    }

    /**
     * 获取某个分类下的元数据列表
     * @param context
     * @param categoryId
     * @param iRequest
     */
    public void httpMetadataListRequest(Context context, int categoryId, final IRequest iRequest){
        MetadataListRequest.httpMetadataListRequest(context, categoryId, iRequest);
    }

    /**
     * 获取元数据下的专辑列表
     * @param context
     * @param categoryId
     * @param calcDimension
     * @param iRequest
     */
    public void httpMetadataAblumsRequest(Context context,int categoryId,int calcDimension,final IRequest iRequest){
        MetadataAblumsRequest.httpMetadataAblumsRequest(context, categoryId, calcDimension, iRequest);
    }

    /**
     * 获取元数据下的专辑列表
     * @param context
     * @param categoryId
     * @param calcDimension
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpMetadataAblumsRequest(Context context,int categoryId,int calcDimension,int page,int count, final IRequest iRequest){
        MetadataAblumsRequest.httpMetadataAblumsRequest(context, categoryId, calcDimension, page, count, iRequest);
    }

    /**
     * 获取专辑榜单列表
     * @param context
     * @param rankType
     * @param iRequest
     */
    public void httpRanksListRequest(Context context, int rankType, final IRequest iRequest){
        RanksListRequest.httpRanksListRequest(context, rankType, iRequest);
    }

    /**
     * 获取专辑榜单详情
     * @param context
     * @param rankListId
     * @param iRequest
     */
    public void httpRankAlbumRequest(Context context, String rankListId, final IRequest iRequest){
        RankAlbumRequest.httpRankAlbumRequest(context, rankListId, iRequest);
    }

    /**
     * 获取专辑榜单详情
     * @param context
     * @param rankListId
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpRankAlbumRequest(Context context, String rankListId, int page, int count, final IRequest iRequest){
        RankAlbumRequest.httpRankAlbumRequest(context, rankListId, page, count, iRequest);
    }

    /**
     * 批量获取听单信息
     * @param context
     * @param ids
     * @param iRequest
     */
    public void httpColumnsBatchRequest(Context context,String ids,final IRequest iRequest){
        ColumnsBatchRequest.httpColumnsBatchRequest(context, ids, iRequest);
    }

    /**
     * 分页获取听单内容
     * @param context
     * @param id
     * @param page
     * @param count
     * @param iRequest
     */
    public void httpColumnsBrowseRequest(Context context, long id, int page, int count, final IRequest iRequest){
        ColumnsBrowseRequest.httpColumnsBrowseRequest(context, id, page, count, iRequest);
    }

    /**
     * 批量获取焦点图信息
     * @param context
     * @param ids
     * @param iRequest
     */
    public void httpBannersBatchRequest(Context context,String ids,final IRequest iRequest){
        BannersBatchRequest.httpBannersBatchRequest(context, ids, iRequest);
    }

}
