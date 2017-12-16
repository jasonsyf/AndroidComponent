package com.jason_sunyf.core.http.entity;

import com.google.gson.Gson;
import com.jason_sunyf.core.appbase.Config;
import com.jason_sunyf.core.util.LogUtils;

/**
 * the more diligent, the more luckier you are !
 * ---------------------------------------------
 * Created by StudyAbc on 2017/7/14.
 *
 * @des Base请求参数，所有的请求参数必须通过该类封装
 * <p>
 * parameter  具体参数实体
 */

public class Parameter<T> {
    public T parameter;

    public Parameter(T parameter) {
        this.parameter = parameter;
        LogUtils.d(Config.NetWork, new Gson().toJson(parameter));
    }

    public Parameter() {
    }
}
