package ximalayaos.net.model.rankslist;

import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: RanksList
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 14:38
 * @Description: java类作用描述
 */
public class RanksList extends BaseResult{
    private List<RankListBean> data;

    public List<RankListBean> getData() {
        return data;
    }

    public void setData(List<RankListBean> data) {
        this.data = data;
    }
}
