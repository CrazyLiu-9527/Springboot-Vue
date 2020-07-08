export default {
    /**
     * 获取当前环境
     * @return {number} 0:测试 1:堡垒 2:UAT 3:LPT 4:生产 5:dev
     */
    getEnv (options) {
        if (typeof window !== "undefined") {
            let host = location.host;

            if (host.match(/\.ctrip\.com/i)) {
                return 4;
            } else if (host.match(/\.uat\.qa/i)) {
                return 2;
            } else if (host.match(/(\.fws|\.fat|\.lpt)/i)) {
                return 0;
            } else if (host.match(/(|localhost|172\.16|127\.0)/i)) {
                return 5;
            } else {
                return 4;
            }
        } else {
            if (options && options.envObj && options.envObj.env) {
                let env = options.envObj.env.toLowerCase();

                if (env === "fat") {
                    return 0;
                } else if (env === "uat") {
                    return 2;
                }else if (env === "dev") {
                    return 5;
                } else {
                    return 4;
                }
            } else {
                return 4; //生产
            }
        }
    },
    /**
     * 通过envcode获取不同环境下的域名
     * @param envCode
     * @returns {string}
     */
    getWebApiUrl (envCode) {
        switch (envCode) {
            case 5:
                return 'http://localhost:8080/api';
            case 0:
                return 'http://10.21.36.23:8080/api';
            // todo 完善正确的url
            case 2:
                return '';
            default:
                return '';
        }
    }
}