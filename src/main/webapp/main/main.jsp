<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/china.js"></script>
    <script type="text/javascript">
        <!--菜单处理-->
        function twoTitle(MenuList) {
            if (MenuList.length == 0) {
                return "空";
            }
            var li = "";
            for (var i = 0; i < MenuList.length; i++) {
                // var li = li + "<a  class='l-btn' >" + MenuList[i].title + "</a><br>";
                // li+="<p style='text-align: center'><a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('"+MenuList[i]+"')\" data-options=\"iconCls:'icon-search'\">"+MenuList[i].title+"</a></p>";
                li += "<p style='text-align: center'><a id=\"btn\" href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('" + MenuList[i].title + "','" + MenuList[i].iconCls + "','" + MenuList[i].url + "')\" data-options=\"iconCls:'icon-search'\">" + MenuList[i].title + "</a></p>";
            }
            return li;
        }

        $(function () {
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/mc/QueryAll",
                dataType: "JSON",
                success: function (result) {
                    for (var i = 0; i < result.length; i++) {
                        $("#aa").accordion("add", {
                            title: result[i].title,
                            content: twoTitle(result[i].menuList),
                            selected: false
                        });
                    }
                }
            });
        });

        //选项卡产生
        function addTabs(title, iconCls, url) {
            var a = $("#tt").tabs("exists", title)
            if (a) {
                $("#tt").tabs("select", title)
            } else {
                $('#tt').tabs('add', {
                    title: title,
                    iconCls: "icon-save",
                    href: "${pageContext.request.contextPath}" + url,
                    selected: true,
                    closable: true
                });
            }
        }

    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:xxxxx
        &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="#"
                                                                                                              class="easyui-linkbutton"
                                                                                                              data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div id="aa" data-options="region:'west',title:'导航菜单',split:true" style="width:220px;" class="easyui-accordion">

</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">

    </div>
</div>
</body>
</html>