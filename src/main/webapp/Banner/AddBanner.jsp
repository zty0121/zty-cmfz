<%@ page pageEncoding="UTF-8" %>
<body>
<script type="text/javascript">
    $(function () {
        $("#title").validatebox({
            validType: true,
            required: true
        });
        $('#status').switchbutton({
            checked: true,
            onChange: function (checked) {
                console.log(checked);
            }
        })
        $("#description").validatebox({
            validType: true,
            required: true
        });
        $("#BannerCancleBtn").linkbutton({
            text: "Cancle"
        });
        $("#BannerSubmitBtn").linkbutton({
            text: "submit",
            onClick: function () {          //提交表单
                $("#AddBannerForm").form("submit", {

                    url: "${pageContext.request.contextPath}/bc/AddBanner",
                    onSubmit: function () {
                        return $("#AddBannerForm").form("validate");                 //当表单全部验证为true 时提交表单
                    },
                    success: function (result1) {
                        $.messager.show({
                            title: "Tips",
                            msg: "success"
                        });
                        $("#AddBannerdig").dialog("close");
                        $("#PictureContentTable").datagrid("reload");
                    }
                });

            },
        });


    });
</script>

<form id="AddBannerForm" method="post" enctype="multipart/form-data">

    <table>

        <tr>
            <td> title</td>
            <td><input id="title" name="title"></td>
        </tr>
        <tr>
            <td> status</td>
            <td><a id="status" name="status"/></td>
        </tr>
        <tr>
            <td> description</td>
            <td><input id="description" name="description"></td>
        </tr>
        <tr>
            <td> 选择图片:</td>
            <td><input type="file" name="file"></td>
        </tr>
    </table>
    <a id="BannerSubmitBtn"></a>
    <a id="BannerCancleBtn"></a>
</form>
</body>

