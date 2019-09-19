package ximalayaos.net.model.tag;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: XiTagBean
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 10:05
 * @Description: java类作用描述
 */
public class XiTagBean extends BaseResult {

        private String kind;
        private String tag_name;
        private String cover_url_small;
        private String cover_url_middle;
        private String cover_url_large;
        public void setKind(String kind) {
            this.kind = kind;
        }
        public String getKind() {
            return kind;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }
        public String getTag_name() {
            return tag_name;
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
}
