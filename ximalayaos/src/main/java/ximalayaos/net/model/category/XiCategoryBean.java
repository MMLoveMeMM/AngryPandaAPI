package ximalayaos.net.model.category;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: XiCategoryBean
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 9:52
 * @Description: java类作用描述
 */
public class XiCategoryBean extends BaseResult {
    private int id;
    private String kind;
    private String category_name;
    private String cover_url_small;
    private String cover_url_middle;
    private String cover_url_large;
    private int order_num;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
    public String getKind() {
        return kind;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public String getCategory_name() {
        return category_name;
    }

    public void setCover_url_small(String cover_url_small) {
        this.cover_url_small = cover_url_small;
    }
    public String getCover_url_small() {
        return cover_url_small;
    }

    public void setCover_url_middle(String cover_url_middle) {
        this.cover_url_middle = cover_url_middle;
    }
    public String getCover_url_middle() {
        return cover_url_middle;
    }

    public void setCover_url_large(String cover_url_large) {
        this.cover_url_large = cover_url_large;
    }
    public String getCover_url_large() {
        return cover_url_large;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }
    public int getOrder_num() {
        return order_num;
    }
}
