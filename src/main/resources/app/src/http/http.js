/**
 * http请求工具类
 */
import axios from "axios";
import env from "../config/env";

const http = {
    /**
     * 封装post请求
     * @param funcName   接口名
     * @param params    请求参数
     * @param successCallback   成功回调
     * @param errorCallback     失败回调
     */
    post (funcName, params, successCallback, errorCallback) {
        axios.post(env.getWebApiUrl(env.getEnv()) + funcName, {params})
            .then(response => {
                console.log('invoke "' + funcName + '" success, result is: ' + response.toString());
                successCallback && successCallback(response);
            })
            .catch(error => {
                console.log('invoke "' + funcName + '" failure, error info is: ' + error.toString());
                errorCallback && errorCallback(error);
            });

    }
};


export default http;