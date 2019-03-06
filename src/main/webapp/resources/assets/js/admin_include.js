/**
 * 引用JS和CSS头文件
 */
var rootPath = getRootPath(); //项目路

/**
 * 动态加载CSS和JS文件
 */
var dynamicLoading = {
    meta : function(){
        document.write('<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">');
    },
    css: function(path){
        if(!path || path.length === 0){
            throw new Error('argument "path" is required!');
        }
        document.write('<link rel="stylesheet" type="text/css" href="' + path + '">');
    },
    js: function(path, charset){
        if(!path || path.length === 0){
            throw new Error('argument "path" is required!');
        }
        document.write('<script  type="text/javascript" src="' + path + '"></script>');
    }
};

/**
 * 取得项目路径
 * @author wul
 */
function getRootPath() {
    //取得当前URL
    var path = window.document.location.href;
    //取得主机地址后的目录
    var pathName = window.document.location.pathname;
    var post = path.indexOf(pathName);
    //取得主机地址
    var hostPath = path.substring(0, post);
    //取得项目名
    var name = pathName.substring(0, pathName.substr(1).indexOf("/") + 1);
    return hostPath + name + "/";
}

//动态生成meta
dynamicLoading.meta();

//动态加载项目 CSS文件
dynamicLoading.css("/resources/assets/css/toastr.min.css");
dynamicLoading.css("/resources/assets/css/bootstrap.css");
dynamicLoading.css("/resources/assets/css/font-awesome.css");
dynamicLoading.css("/resources/assets/js/morris/morris-0.4.3.min.css");
dynamicLoading.css("/resources/assets/css/custom.css");
dynamicLoading.css("/resources/assets/js/dataTables/dataTables.bootstrap.css");
dynamicLoading.css("http://fonts.googleapis.com/css?family=Open+Sans");



//动态加载项目 JS文件
dynamicLoading.js("/resources/assets/js/jquery-3.3.1.min.js", "utf-8");
dynamicLoading.js("/resources/assets/js/bootstrap.min.js", "utf-8");
dynamicLoading.js("/resources/assets/js/toastr.min.js", "utf-8");
dynamicLoading.js("/resources/assets/js/jquery.metisMenu.js", "utf-8");
dynamicLoading.js("/resources/assets/js/morris/raphael-2.1.0.min.js", "utf-8");
dynamicLoading.js("/resources/assets/js/dataTables/jquery.dataTables.js", "utf-8");
dynamicLoading.js("/resources/assets/js/dataTables/dataTables.bootstrap.js", "utf-8");
dynamicLoading.js("/resources/assets/js/response.js", "utf-8");
