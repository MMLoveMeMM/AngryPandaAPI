package ximalayaos.net.model.metalist;

import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: MetaListBeanList
 * @Author: 刘志保
 * @CreateDate: 2019/9/18 9:56
 * @Description: java类作用描述
 */
public class MetaListBeanList extends BaseResult {
    private List<MetaListBean> data;

    public List<MetaListBean> getData() {
        return data;
    }

    public void setData(List<MetaListBean> data) {
        this.data = data;
    }
}
