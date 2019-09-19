package ximalayaos.net.model.tag;

import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: XiTagsList
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 10:05
 * @Description: java类作用描述
 */
public class TagsList extends BaseResult {
    private List<XiTagBean> data;

    public List<XiTagBean> getData() {
        return data;
    }

    public void setData(List<XiTagBean> data) {
        this.data = data;
    }
}
