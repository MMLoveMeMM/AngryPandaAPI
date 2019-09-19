package ximalayaos.net.model.hotword;

import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: HotwordList
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 19:03
 * @Description: java类作用描述
 */
public class HotwordList extends BaseResult {
    private List<HotwordBean> data;

    public List<HotwordBean> getData() {
        return data;
    }

    public void setData(List<HotwordBean> data) {
        this.data = data;
    }
}
