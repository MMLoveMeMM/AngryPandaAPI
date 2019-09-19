package ximalayaos.net.model;

import java.util.List;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: JuHeChengYu
 * @Author: 刘志保
 * @CreateDate: 2019/9/12 19:36
 * @Description: java类作用描述
 */
public class JuHeChengYu extends BaseResult {

    /*private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }*/

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean{
        private String bushou;
        private String head;
        private String pinyin;
        private String chengyujs;
        private String from_;
        private String example;
        private String yufa;
        private String ciyujs;
        private String yinzhengjs;
        private List<String> tongyi;
        private List<String> fanyi;
        public void setBushou(String bushou) {
            this.bushou = bushou;
        }
        public String getBushou() {
            return bushou;
        }

        public void setHead(String head) {
            this.head = head;
        }
        public String getHead() {
            return head;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }
        public String getPinyin() {
            return pinyin;
        }

        public void setChengyujs(String chengyujs) {
            this.chengyujs = chengyujs;
        }
        public String getChengyujs() {
            return chengyujs;
        }

        public void setFrom_(String from_) {
            this.from_ = from_;
        }
        public String getFrom_() {
            return from_;
        }

        public void setExample(String example) {
            this.example = example;
        }
        public String getExample() {
            return example;
        }

        public void setYufa(String yufa) {
            this.yufa = yufa;
        }
        public String getYufa() {
            return yufa;
        }

        public void setCiyujs(String ciyujs) {
            this.ciyujs = ciyujs;
        }
        public String getCiyujs() {
            return ciyujs;
        }

        public void setYinzhengjs(String yinzhengjs) {
            this.yinzhengjs = yinzhengjs;
        }
        public String getYinzhengjs() {
            return yinzhengjs;
        }

        public void setTongyi(List<String> tongyi) {
            this.tongyi = tongyi;
        }
        public List<String> getTongyi() {
            return tongyi;
        }

        public void setFanyi(List<String> fanyi) {
            this.fanyi = fanyi;
        }
        public List<String> getFanyi() {
            return fanyi;
        }
    }

}
