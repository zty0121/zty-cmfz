<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#title").validatebox({
            validType: true,
            required: true
        });
        $("#AlbumType").combobox({
            url: "${pageContext.request.contextPath}/act/QueryAllAlbum",
            valueField: "id",
            textField: "title",
            onLoadSuccess: function (data) {
                $("#AlbumType").combobox("setValue", data[0].id);
            },
            onChange: function (proCode) {
                $("#AlbumType").combobox("setValue", proCode);
            }
        });
        $("#AddChapterSubmitBtn").linkbutton({
            text: "submit",
            onClick: function () {          //提交表单
                $("#AddChapterForm").form("submit", {
                    url: "${pageContext.request.contextPath}/cc/AddOneChapter",
                    onSubmit: function () {
                        return $("#AddChapterForm").form("validate");                 //当表单全部验证为true 时提交表单
                    },
                    success: function () {
                        $("#AddAlbumDig").dialog("close");
                        $("#AlbumTreeGrid").treegrid("reload");
                        $.messager.show({
                            title: "Tips",
                            msg: "success"
                        });
                    }
                });
            }
        })
    });
</script>
<form method="post" id="AddChapterForm" enctype="multipart/form-data">
    <table>
        <tr>
            <td> title:</td>
            <td><input id="title" name="title"></td>
        </tr>
        <tr>
            <td> upload:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td> Type:</td>
            <td><input id="AlbumType" name="album_id"></td>
        </tr>
    </table>
    <a id="AddChapterSubmitBtn"></a>
</form>