package ximalayaos.net.model;

import java.io.Serializable;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/6 19:20
 * @des: 数据格式参考聚合返回数据形式
 * @see {@link }
 */

public class BaseResultBean implements Serializable {

    /**
     * result : true
     */
    private String reason;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                ", reason='" + reason + '\'' +
                '}';
    }
    /**
     * result : true
     */
    private int error_code;
    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
