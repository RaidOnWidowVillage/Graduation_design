toastr.options = {
    closeButton: true, //是否显示关闭按钮（提示框右上角关闭按钮）；
    debug: false,   //是否为调试；
    progressBar: true, //是否显示进度条（设置关闭的超时时间进度条）；
    positionClass: "toast-top-center", //消息框在页面显示的位置
    onclick: null, //点击消息框自定义事件
    showDuration: "300", //显示动作时间
    hideDuration: "1000",//隐藏动作时间
    timeOut: "3000", //自动关闭超时时间
    extendedTimeOut: "1000",
    showEasing: "swing",
    hideEasing: "linear",
    showMethod: "fadeIn",
    hideMethod: "fadeOut"
};

/**
 oast-top-left  顶端左边
 toast-top-right    顶端右边
 toast-top-center  顶端中间
 toast-top-full-width 顶端，宽度铺满整个屏幕
 toast-botton-right
 toast-bottom-left
 toast-bottom-center
 toast-bottom-full-width
 */

$.ajaxSetup({
    contentType:"application/x-www-form-urlencoded;charset=utf-8",
    complete:function(XMLHttpRequest){
        //通过XMLHttpRequest取得响应结果
        var res = XMLHttpRequest.responseText;
        try{
            var jsonData = JSON.parse(res);
            if(jsonData.state === -1){
                //如果超时就处理 ，指定要跳转的页面(比如登陆页)
                toastr.error("登录失效啦，请重新登录哦~");
                setTimeout(function () {
                    window.location.replace("login.html");
                },3000);
            }else if(jsonData.state === 0){
                //其他的异常情况,给个提示。
                toastr.success("登录的session一直存在");
            }
        }catch(e){
        }
    },statusCode: {
        404: function() {
            toastr.error("小犊子，肯定是地址配置错误了");
        },
        504: function() {
            toastr.error("数据获取/输入失败，服务器没有响应。504");
        },
        500: function() {
            toastr.error("小犊子，肯定是后台写错了");
        }
    }
});