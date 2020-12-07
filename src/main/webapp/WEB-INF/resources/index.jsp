<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>index页面</title>
    <meta name="decorator" content="default"/>
</head>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>

    function exportExcle() {

        window.open("/exportExcel")
    }
</script>
<body>
    <form action="/readExcel" method="post" enctype="multipart/form-data">
        <input type="button" onclick="exportExcle()" value="导出"/>
        <input type="file" name="file"  value="导入"/>
        <input type="submit" value="保存"/>
    </form>
</body>