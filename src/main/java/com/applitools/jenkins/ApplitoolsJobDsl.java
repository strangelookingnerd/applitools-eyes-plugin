package com.applitools.jenkins;

import hudson.Extension;
import javaposse.jobdsl.dsl.helpers.wrapper.WrapperContext;
import javaposse.jobdsl.plugin.ContextExtensionPoint;
import javaposse.jobdsl.plugin.DslExtensionMethod;

@Extension(optional = true)
public class ApplitoolsJobDsl extends ContextExtensionPoint {
    @DslExtensionMethod(context = WrapperContext.class)
    public Object applitools(String serverUrl) {
        return applitools(serverUrl, ApplitoolsCommon.NOTIFY_BY_COMPLETION);
    }

    @DslExtensionMethod(context = WrapperContext.class)
    public Object applitools(String serverUrl, boolean notifyByCompletion) {
        return new ApplitoolsBuildWrapper(serverUrl, notifyByCompletion);
    }

    @DslExtensionMethod(context = WrapperContext.class)
    public Object applitools() {
        return new ApplitoolsBuildWrapper(ApplitoolsCommon.APPLITOOLS_DEFAULT_URL, ApplitoolsCommon.NOTIFY_BY_COMPLETION);
    }

}
