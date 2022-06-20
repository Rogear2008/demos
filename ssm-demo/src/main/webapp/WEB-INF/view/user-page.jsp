<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<head>
    <%--<jsp:include page="include-head.jsp"/>--%>
    <meta charset="UTF-8">
    <title>SSM Demo</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"/>
    <link rel="stylesheet" type="text/css" href="static/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="static/jquery-easyui-1.7.0/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="static/jquery-easyui-1.7.0/themes/color.css">
    <link rel="stylesheet" type="text/css" href="static/jquery-easyui-1.7.0/demo/demo.css">
    <script type="text/javascript" src="static/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript" src="static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
</head>
<body>
<p>用户列表</p>

<table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:250px"
       url="${pageContext.request.contextPath}/user/list?pageNumb=1&pageSize=10"
       toolbar="#toolbar" pagination="true"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="id" width="50">ID</th>
        <th field="createTime" width="50">创建时间</th>
        <th field="updateTime" width="50">更新时间</th>
        <th field="username" width="50">用户名</th>
        <th field="password" width="50">密码</th>
        <th field="birthday" width="50">生日</th>
        <th field="enable" width="50">状态</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">New
        User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">Edit
        User</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">Remove
        User</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px"
     data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <h3>User Information</h3>
        <div style="margin-bottom:10px">
            <input name="firstname" class="easyui-textbox" required="true" label="First Name:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="lastname" class="easyui-textbox" required="true" label="Last Name:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="phone" class="easyui-textbox" required="true" label="Phone:" style="width:100%">
        </div>
        <div style="margin-bottom:10px">
            <input name="email" class="easyui-textbox" required="true" validType="email" label="Email:"
                   style="width:100%">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel"
       onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>
<script type="text/javascript">
    var url;

    function newUser() {
        $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'New User');
        $('#fm').form('clear');
        url = 'save_user.php';
    }

    function editUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $('#dlg').dialog('open').dialog('center').dialog('setTitle', 'Edit User');
            $('#fm').form('load', row);
            url = 'update_user.php?id=' + row.id;
        }
    }

    function saveUser() {
        $('#fm').form('submit', {
            url: url,
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (result) {
                var result = eval('(' + result + ')');
                if (result.errorMsg) {
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg
                    });
                } else {
                    $('#dlg').dialog('close');		// close the dialog
                    $('#dg').datagrid('reload');	// reload the user data
                }
            }
        });
    }

    function destroyUser() {
        var row = $('#dg').datagrid('getSelected');
        if (row) {
            $.messager.confirm('Confirm', 'Are you sure you want to destroy this user?', function (r) {
                if (r) {
                    $.post('destroy_user.php', {id: row.id}, function (result) {
                        if (result.success) {
                            $('#dg').datagrid('reload');	// reload the user data
                        } else {
                            $.messager.show({	// show error message
                                title: 'Error',
                                msg: result.errorMsg
                            });
                        }
                    }, 'json');
                }
            });
        }
    }
</script>
</body>
</html>