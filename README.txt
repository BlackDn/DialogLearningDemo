# README
这个项目其实是边学习边写的测试用项目，是学习对话框Dialog的时候的副产物
包括**AlertDialog**的各种类型，以及其子类**DatePickerDialog**，**TimePickerDialog**，**ProgressDialog**
包括**PopupWindow** 的两种类型（下拉和定点）
包括**Activity利用style**实现对话框的形式

其中，**DialogActivity** 包含多个按钮，每个按钮对应一个对话框，已经被修改为初始Activity。**activity_dialog.xml** 是他的布局
**DialogWindowActivity** 是 **Activity利用style**实现对话框的时候作为对话框显示的Activity
**layout_customized_dialog.xml**是自定义的对话框布局，在AlerDialog自定义布局、PopupWindow、Activity实现对话框中皆有用到
具体内容在这篇博客里：
[Dialog各种对话框的实现](https://blackdn.github.io/2021/05/07/Dialog-Learning-2021/)

本项目的**MainActivity** 、**MyAdapter** 及布局**activity_main.xml** 是没用的，内容是之前学习ListView和Adapter的代码，可以无视或删除
**item.xml** 是ListView中item的布局，和这次Dialog也没啥关系
不过那时候也写了博客：
[Adapter：开始自定义Adapter](https://blackdn.github.io/2021/04/29/Adapter-Customed-2021/)
[Adapter：ArrayAdapter和SimpleAdapter适配ListView](https://blackdn.github.io/2021/04/09/Adapter-ArrayAdapter-SimpleAdapter-2021/)

呼...终于写完了，累死了...