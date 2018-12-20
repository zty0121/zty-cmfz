<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    function DeleteRow(row) {
        //此处tag代表当前delete按钮的dom对象
        $.post("${pageContext.request.contextPath}/bc/DeleteBanner",
            "id=" + row.id,
            function (result) {
                if (result == "ok") {
                    $('#PictureContentTable').edatagrid('destroyRow');
                }
            }
        )
    };
    $(function () {
        //初始化edategrid
        $("#PictureContentTable").edatagrid({
            updateUrl: "${pageContext.request.contextPath}/bc/UpdateBanner",
            url: '${pageContext.request.contextPath}/bc/BannerPage',
            columns: [[
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required: true}
                    }
                },
                {field: 'pub_date', title: '时间', width: 100, align: 'right',}
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageList: [1, 3, 5, 7, 9],
            pageSize: 3,
            toolbar: TaskBar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.img_path + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pub_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });


        //初始化按钮
        $("#AddBannerBtn").linkbutton({
            iconCls: 'icon-add',
            text: "添加",
            onClick: function () {
                $("#AddBannerdig").dialog("open");
            }
        });
        //初始化添加对话框
        $("#AddBannerdig").dialog({
            title: "添加轮播图",
            width: 600,
            height: 300,
            href: "${pageContext.request.contextPath}/Banner/AddBanner.jsp",
            closed: true,
            modal: true,
            cache: false,
        });
        $("#UpdateBannerBtn").linkbutton({
            iconCls: 'icon-edit',
            text: "修改",
            onClick: function () {
                //获取选中行
                var row = $("#PictureContentTable").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#PictureContentTable").edatagrid("getRowIndex", row);
                    $("#PictureContentTable").edatagrid("editRow", index);
                } else {
                    alert("请先选中行");
                }
            }
        });
        $("#RemoveBannerBtn").linkbutton({
            iconCls: 'icon-remove',
            text: "删除",
            onClick: function () {
                //获取选中行
                var row = $("#PictureContentTable").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    DeleteRow(row);
                    //var dele = $("#PictureContentTable").edatagrid("getRowIndex", row);
                    //$("#PictureContentTable").edatagrid("editRow", index);
                } else {
                    alert("请先选中行");
                }
            }
        });
        $("#SaveBannerBtn").linkbutton({
            iconCls: 'icon-save',
            text: "保存",
            onClick: function () {
                $("#PictureContentTable").edatagrid("saveRow");
                $("#PictureContentTable").edatagrid("load");
            }
        });
    })


</script>

<div id="TaskBar">
    <a id="AddBannerBtn"></a>
    <a id="UpdateBannerBtn"></a>
    <a id="RemoveBannerBtn"></a>
    <a id="SaveBannerBtn"></a>
</div>
<table id="PictureContentTable"></table>
<!-- 点击添加的对话框 -->
<div id="AddBannerdig"></div>