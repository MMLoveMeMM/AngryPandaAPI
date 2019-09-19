package ximalayaos.net.model.albbatchs;

import java.util.List;

import ximalayaos.net.model.BaseResult;
import ximalayaos.net.model.albbatch.AlbumBatchBean;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: AlbumBatchUpdateList
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 11:22
 * @Description: java类作用描述
 */
public class AlbumBatchUpdateList extends BaseResult {
    private List<AlbumBatchUpdateBean> data;

    public List<AlbumBatchUpdateBean> getData() {
        return data;
    }

    public void setData(List<AlbumBatchUpdateBean> data) {
        this.data = data;
    }
}
