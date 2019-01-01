<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
    function DeleteRow(row) {
        //此处tag代表当前delete按钮的dom对象
        $.post("${pageContext.request.contextPath}/bc/DeleteBanner",
            "id=" + row.id,
            function (result) {
                if (result == "ok") {
                    $('#UserContentTable').edatagrid('destroyRow');
                }
            }
        )
    };
    $(function () {
        //初始化edategrid
        $("#UserContentTable").edatagrid({
            updateUrl: "${pageContext.request.contextPath}/uc/UpdateBanner",
            url: '${pageContext.request.contextPath}/uc/SelectAll',
            columns: [[
                {field: 'name', title: '名称', width: 100},
                {field: 'sex', title: '性别', width: 100},
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required: true}
                    }
                },
                {field: 'phone', title: '手机号码', width: 100},
                {field: 'reg_date', title: '注册时间', width: 100},
            ]],
            fitColumns: true,
            fit: true,
            toolbar: UserTaskBar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.head_pic + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.province + '</p>' +
                    '<p>日期: ' + rowData.reg_date + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });


        //初始化按钮
        $("#AddUserBtn").linkbutton({
            iconCls: 'icon-add',
            text: "添加",
            onClick: function () {
                $("#AddUserdig").dialog("open");
            }
        });
        //初始化添加对话框
        $("#AddUserdig").dialog({
            title: "添加轮播图",
            width: 600,
            height: 300,
            href: "${pageContext.request.contextPath}/Banner/AddBanner.jsp",
            closed: true,
            modal: true,
            cache: false,
        });
        $("#UpdateUserBtn").linkbutton({
            iconCls: 'icon-edit',
            text: "修改",
            onClick: function () {
                //获取选中行
                var row = $("#UserContentTable").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#UserContentTable").edatagrid("getRowIndex", row);
                    $("#UserContentTable").edatagrid("editRow", index);
                } else {
                    alert("请先选中行");
                }
            }
        });
        $("#RemoveUserBtn").linkbutton({
            iconCls: 'icon-remove',
            text: "删除",
            onClick: function () {
                //获取选中行
                var row = $("#UserContentTable").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    DeleteRow(row);
                } else {
                    alert("请先选中行");
                }
            }
        });
        $("#SaveUserBtn").linkbutton({
            iconCls: 'icon-save',
            text: "保存",
            onClick: function () {
                $("#UserContentTable").edatagrid("saveRow");
                $("#UserContentTable").edatagrid("load");
            }
        });
        $("#ImportFileDig").dialog({
            title: "添加轮播图",
            width: 600,
            height: 300,
            closed: true,
            modal: true,
            cache: false,
        });
        $("#ImportFileBtns").linkbutton({
            iconCls: 'icon-save',
            text: "导入",
            onClick: function () {
                $("#ImportFileDig").dialog("open");
            }
        });
        $('#FileImport').filebox({
            buttonText: '选择文件',
            buttonAlign: 'left'
        })
        $("#ImportFileBtn").linkbutton({
            text: "submit",
            onClick: function () {          //提交表单
                $("#ImportFileForm").form("submit", {
                    url: "${pageContext.request.contextPath}/bc/AddBanner",
                    onSubmit: function () {
                        return $("#ImportFileForm").form("validate");                 //当表单全部验证为true 时提交表单
                    },
                    success: function (result1) {
                        $.messager.show({
                            title: "Tips",
                            msg: "success"
                        });
                        $("#UserContentTable").datagrid("reload");
                    }
                });

            },
        });
    })


</script>

<div id="UserTaskBar">
    <a id="AddUserBtn"></a>
    <a id="UpdateUserBtn"></a>
    <a id="RemoveUserBtn"></a>
    <a id="SaveUserBtn"></a>
    <a id="ImportFileBtns"></a>
</div>
<table id="UserContentTable"></table>
<!-- 点击添加的对话框 -->
<div id="AddUserdig"></div>

<div id="ImportFileDig">
    <form id="ImportFileForm" method="post" enctype="multipart/form-data">
        <input type="file" name="FileImport">
        <a id="ImportFileBtn"></a>
    </form>
</div>