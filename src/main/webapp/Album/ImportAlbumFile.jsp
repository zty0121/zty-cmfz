<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        $("#ImportAlbumSubmitBtn").linkbutton({
            text: "submit",
            onClick: function () {          //提交表单
                $("#ImportAlbumForm").form("submit", {
                    url: "${pageContext.request.contextPath}/fc/FileImport",
                    onSubmit: function () {
                        return $("#ImportAlbumForm").form("validate");                 //当表单全部验证为true 时提交表单
                    },
                    success: function () {
                        $("#ImportDig").dialog("close");
                        $("#AlbumTreeGrid").treegrid("reload");
                        $.messager.show({
                            title: "Tips",
                            msg: "success"
                        });
                    }
                });
            }
        })
    })

</script>


<form method="post" id="ImportAlbumForm" enctype="multipart/form-data">
    <table>
        <tr>
            <td> 请选择文件:</td>
            <td><input type="file" name="file"></td>
        </tr>
    </table>
    <a id="ImportAlbumSubmitBtn"></a>
</form>