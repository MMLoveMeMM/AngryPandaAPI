package ximalayaos.net.model.category;

import java.util.List;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: CategoriesList
 * @Author: 刘志保
 * @CreateDate: 2019/9/16 10:13
 * @Description: java类作用描述
 */
public class CategoriesList extends BaseResult {

    private List<XiCategoryBean> data;

    public List<XiCategoryBean> getData() {
        return data;
    }

    public void setData(List<XiCategoryBean> data) {
        this.data = data;
    }

}
