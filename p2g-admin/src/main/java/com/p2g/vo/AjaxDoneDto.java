package com.p2g.vo;

/**
 * Created on 2016-06-24 10:12.
 *
 * @author FanShukui
 */
public class AjaxDoneDto {
    //必选。状态码(ok = 200, error = 300, timeout = 301)
    private Integer statusCode;
    //可选。信息内容。
    private String message;
    //可选。待刷新navtab id，多个id以英文逗号分隔开，当前的navtab id不需要填写，填写后可能会导致当前navtab重复刷新。
    private String tabid;
    //可选。待刷新dialog id，多个id以英文逗号分隔开，请不要填写当前的dialog id，要控制刷新当前dialog，请设置dialog中表单的reload参数。
    private String dialogid;
    //可选。待刷新div id，多个id以英文逗号分隔开，请不要填写当前的div id，要控制刷新当前div，请设置该div中表单的reload参数。
    private String divid;
    //可选。是否关闭当前窗口(navtab或dialog)。
    private boolean closeCurrent;
    //可选。跳转到某个url。
    private String forward;
    //可选。跳转url前的确认提示信息。
    private String forwardConfirm;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTabid() {
        return tabid;
    }

    public void setTabid(String tabid) {
        this.tabid = tabid;
    }

    public String getDialogid() {
        return dialogid;
    }

    public void setDialogid(String dialogid) {
        this.dialogid = dialogid;
    }

    public String getDivid() {
        return divid;
    }

    public void setDivid(String divid) {
        this.divid = divid;
    }

    public boolean isCloseCurrent() {
        return closeCurrent;
    }

    public void setCloseCurrent(boolean closeCurrent) {
        this.closeCurrent = closeCurrent;
    }

    public String getForward() {
        return forward;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }

    public String getForwardConfirm() {
        return forwardConfirm;
    }

    public void setForwardConfirm(String forwardConfirm) {
        this.forwardConfirm = forwardConfirm;
    }
}
