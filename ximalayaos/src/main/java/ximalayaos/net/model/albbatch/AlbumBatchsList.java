package ximalayaos.net.model.albbatch;

import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: AlbumBatchsList
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 11:18
 * @Description: java类作用描述
 */
public class AlbumBatchsList extends BaseResult {
    private List<AlbumBatchBean> data;

    public List<AlbumBatchBean> getData() {
        return data;
    }

    public void setData(List<AlbumBatchBean> data) {
        this.data = data;
    }
}
