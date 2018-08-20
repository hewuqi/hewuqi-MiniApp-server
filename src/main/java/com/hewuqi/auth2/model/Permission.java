package com.hewuqi.auth2.model;

public class Permission {
    private Long id;

    private String resourceCode;

    private String resorceName;

    private String permissionCode;

    private String permissionName;

    private Long requiredPermission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode == null ? null : resourceCode.trim();
    }

    public String getResorceName() {
        return resorceName;
    }

    public void setResorceName(String resorceName) {
        this.resorceName = resorceName == null ? null : resorceName.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public Long getRequiredPermission() {
        return requiredPermission;
    }

    public void setRequiredPermission(Long requiredPermission) {
        this.requiredPermission = requiredPermission;
    }
}