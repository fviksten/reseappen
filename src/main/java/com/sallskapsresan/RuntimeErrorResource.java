package com.sallskapsresan;

import java.util.List;

/**
 * Created by Administrator on 2016-10-26.
 */
public class RuntimeErrorResource extends ErrorResource {
    private List<RuntimeError> runtimeErrors;

    public RuntimeErrorResource() {
    }

    public void setRuntimeErrors(List<RuntimeError> runtimeErrors) {
        this.runtimeErrors = runtimeErrors;
    }

    public List<RuntimeError> getRuntimeErrors() {
        return runtimeErrors;
    }
}
