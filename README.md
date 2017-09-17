# MVVM-RecyclerView
基于MVVM架构的RecyclerView

支持的功能
  
 - Sticky Header效果；实现RecyclerView Item顶部悬浮，支持多种Header样式；  
 - Swipe Menu效果：横向滑动菜单，支持左右滑动两种操作；
 - Drag 效果；

# Demo  
- [Download Demo](https://www.pgyer.com/ebTo)

- [StickyHeaderRecyclerView](library/src/main/java/com/wuhenzhizao/view/StickyHeaderRecyclerView.java)  
<div style="float:left;border:solid 1px 000;margin:5px;">
	<img src="screenshots/20170917_155444.gif" alt="screenshot" title="singleType" width="250">
	<img src="screenshots/20170917_155550.gif" alt="screenshot" title="multiType" width="250">
</div>
<div style="clear:both;"></div>

- [SwipeMenuRecyclerView](library/src/main/java/com/wuhenzhizao/view/SwipeMenuRecyclerView.java)  
<div style="float:left;border:solid 1px 000;margin:5px;">
	<img src="screenshots/20170917_155618.gif" alt="screenshot" title="swipeMenuLeft" width="250">
	<img src="screenshots/20170917_155634.gif" alt="screenshot" title="swipeMenuRight" width="250">
</div>
<div style="clear:both;"></div>  

- [DragRecyclerView](library/src/main/java/com/wuhenzhizao/view/DragRecyclerView.java)
<div style="float:left;border:solid 1px 000;margin:5px;">
	<img src="screenshots/20170917_155648.gif" alt="screenshot" title="drag" width="250">
</div>
<div style="clear:both;"></div>  

# Usage
  
**本项目基于MVVM架构，使用了[android-mvvm-framwork](https://github.com/wuhenzhizao/android-mvvm-framwork)框架，mvvm部分代码请参考该框架，下面主要讲RecyclerViwe部分的用法** 

- StickyHeaderRecyclerView  

```xml
<data>
	<import type="com.wuhenzhizao.view.factory.StickyItemViewFactory" />
	<import type="com.gomeos.mvvm.view.LayoutManagers" />
	<variable
		name="vm"
		type="com.wuhenzhizao.viewmodule.StickyViewModel" />
</data>

<com.wuhenzhizao.view.StickyHeaderRecyclerView
	xmlns:sticky="http://schemas.android.com/apk/res-auto"
    android:id="@+id/drv"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_below="@id/toolbar"
  	sticky:headerClickListener="@{vm.headerClickListener}"
  	sticky:itemViewFactory="@{StickyItemViewFactory.className}"
	sticky:items="@{vm.itemList}"
	sticky:layoutManager="@{LayoutManagers.linear()}" />
``` 
```java
public class StickyViewModel extends LifecycleViewModel {
    private List<StickyTestViewBean> itemList;

    public List<StickyTestViewBean> getItemList() {
        return itemList;
    }
}
```

