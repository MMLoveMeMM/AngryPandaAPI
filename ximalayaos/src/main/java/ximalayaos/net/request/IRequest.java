package ximalayaos.net.request;

import ximalayaos.net.model.BaseResult;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: IRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 9:38
 * @Description: 请求接口回调
 */
public interface IRequest {

    void callBackRequestResult(String rawJson);
    void callBackRequestBean(BaseResult result);
    void callBackRequestError(String rawJson);
}
