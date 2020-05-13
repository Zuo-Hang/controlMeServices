package com.example.demo.bean;

/**
 * 用户（角色）
 *
 * 权限一致的人员编入角色，然后对该角色进行权限分配。
 * @Author:zuohang
 * @date:2020/5/13 0013 11:17
 */
public class Role {
    //角色id
    private Integer roleId;
    //角色名称
    private String roleName;
    //角色描述
    private String description;

    public Role() {
    }

    public Role(Integer roleId, String roleName, String description) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
