package com.flab.cafeguidebook.domain;

import com.flab.cafeguidebook.enumeration.MenuGroup;
import com.flab.cafeguidebook.enumeration.MenuStatus;
import java.time.LocalDateTime;

public class Menu {

  private long menuId;
  private String cafeId;
  private String menuName;
  private int menuPrice;
  private String menuPhoto;
  private String menuInfo;
  private int menuPriority;
  private LocalDateTime createMenuDate;
  private LocalDateTime updateMenuDate;
  private MenuGroup menuGroup;
  private MenuStatus menuStatus;

  public Menu(Builder builder) {
    this.menuId = menuId;
    this.cafeId = cafeId;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuPhoto = menuPhoto;
    this.menuInfo = menuInfo;
    this.menuPriority = menuPriority;
    this.createMenuDate = createMenuDate;
    this.updateMenuDate = updateMenuDate;
    this.menuGroup = menuGroup;
    this.menuStatus = menuStatus;
  }

  public Menu(long menuId, String cafeId, String menuName, int menuPrice, String menuPhoto,
      String menuInfo, int menuPriority, LocalDateTime createMenuDate, LocalDateTime updateMenuDate,
      MenuGroup menuGroup, MenuStatus menuStatus) {
    this.menuId = menuId;
    this.cafeId = cafeId;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
    this.menuPhoto = menuPhoto;
    this.menuInfo = menuInfo;
    this.menuPriority = menuPriority;
    this.createMenuDate = createMenuDate;
    this.updateMenuDate = updateMenuDate;
    this.menuGroup = menuGroup;
    this.menuStatus = menuStatus;
  }

  public static Builder builder() {
    return new Builder();
  }

  public long getMenuId() {
    return menuId;
  }

  public void setMenuId(long menuId) {
    this.menuId = menuId;
  }

  public String getCafeId() {
    return cafeId;
  }

  public void setCafeId(String cafeId) {
    this.cafeId = cafeId;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public int getMenuPrice() {
    return menuPrice;
  }

  public void setMenuPrice(int menuPrice) {
    this.menuPrice = menuPrice;
  }

  public String getMenuPhoto() {
    return menuPhoto;
  }

  public void setMenuPhoto(String menuPhoto) {
    this.menuPhoto = menuPhoto;
  }

  public String getMenuInfo() {
    return menuInfo;
  }

  public void setMenuInfo(String menuInfo) {
    this.menuInfo = menuInfo;
  }

  public int getMenuPriority() {
    return menuPriority;
  }

  public void setMenuPriority(int menuPriority) {
    this.menuPriority = menuPriority;
  }

  public LocalDateTime getCreateMenuDate() {
    return createMenuDate;
  }

  public void setCreateMenuDate(LocalDateTime createMenuDate) {
    this.createMenuDate = createMenuDate;
  }

  public LocalDateTime getUpdateMenuDate() {
    return updateMenuDate;
  }

  public void setUpdateMenuDate(LocalDateTime updateMenuDate) {
    this.updateMenuDate = updateMenuDate;
  }

  public MenuGroup getMenuGroup() {
    return menuGroup;
  }

  public void setMenuGroup(MenuGroup menuGroup) {
    this.menuGroup = menuGroup;
  }

  public MenuStatus getMenuStatus() {
    return menuStatus;
  }

  public void setMenuStatus(MenuStatus menuStatus) {
    this.menuStatus = menuStatus;
  }

  public static class Builder {

    private long menuId;
    private String cafeId;
    private String menuName;
    private int menuPrice;
    private String menuPhoto;
    private String menuInfo;
    private int menuPriority;
    private LocalDateTime createMenuDate;
    private LocalDateTime updateMenuDate;
    private MenuGroup menuGroup;
    private MenuStatus menuStatus;

    public Menu.Builder Builder() {
      return this;
    }

    public Menu.Builder menuId(final long menuID) {
      this.menuId = menuId;
      return this;
    }

    public Menu.Builder cafeId(final String cafeId) {
      this.cafeId = cafeId;
      return this;
    }

    public Menu.Builder menuName(final String menuName) {
      this.menuName = menuName;
      return this;
    }

    public Menu.Builder menuPrice(final int menuPrice) {
      this.menuPrice = menuPrice;
      return this;
    }

    public Menu.Builder menuPhoto(final String menuPhoto) {
      this.menuPhoto = menuPhoto;
      return this;
    }

    public Menu.Builder menuInfo(final String menuInfo) {
      this.menuInfo = menuInfo;
      return this;
    }

    public Menu.Builder menuPriority(final int menuPriority) {
      this.menuPriority = menuPriority;
      return this;
    }

    public Menu.Builder createMenuDate(final LocalDateTime createMenuDate) {
      this.createMenuDate = createMenuDate;
      return this;
    }

    public Menu.Builder updateMenuDate(final LocalDateTime updateMenuDate) {
      this.updateMenuDate = updateMenuDate;
      return this;
    }

    public Menu.Builder menuGroup(final MenuGroup menuGroup) {
      this.menuGroup = menuGroup;
      return this;
    }

    public Menu.Builder menuStatus(final MenuStatus menuStatus) {
      this.menuStatus = menuStatus;
      return this;
    }

    public Menu build() {
      return new Menu(this.menuId, this.cafeId, this.menuName, this.menuPrice, this.menuPhoto,
          this.menuInfo, this.menuPriority, this.createMenuDate, this.updateMenuDate,
          this.menuGroup, this.menuStatus);
    }
  }
}
