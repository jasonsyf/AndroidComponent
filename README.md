# AndroidComponent
android 组件化
最近工作忙一直没有更新.
接下来准备把工作中解决的问题写成博客
## 邮箱添加收件人控件
可编辑可输入可删除可索引自动带出控件
## 富文本编辑器
还是邮件部分遇到的,开始我还觉得可以这么easy!自己发邮件自娱自乐十分开心,直到一打开web端发的邮件,整个人都懵比了,各种div,span,br标签都出来了,富文本编辑器还可以传图片,mmp,
啧啧,这酸爽.
一开始邮件内容这一部分,查看详情打算使用TextView,通过formHtml(),重写imageGatter,来展示邮件内容(目前也确实这样做的),但是收件箱的邮件是需要恢复的,前端回复的时候
会将发件人的信息组装成标签放在上边,用formHtml方法,虽然可以实现加载html中的简单排版以及图片(这个方法的图片大小挺合适!),but,当你在Edittext中加入回复的内容后,
由于前一部分是h5,回复这一部分又是原生的,虽然可以发送成功,但是内容会产生很多乱码,so,我需要一个富文本编辑器.Github找了两个开源的(richeditor和icarus-android)
这两个编辑器各有优缺点,本质都是webView,剩下的以后慢慢谈
## recyclerView 长按全选编辑(删除或者撤回邮件)
产品需要时间暗处功能,开始只在详情里边提供一个按钮,考虑到如果邮件数量爆炸,这样操作用户体验不高,但是由于产品开始设计的时候,界面操作已经比较多,实在无法再在列表添加操作功能,
于是就吸收别人家的好的思想,发现长按全局编辑比较普遍,样式也还可以,so,对网易邮箱的UI,操作啊比较欣赏,就动手实现了一个,接下来会在代码里实现.

## 写过博客,但是没有真正思考去写过技术上的博客,因此需要考虑一下怎么组织语言,怎么能让别人看懂,同时还得补一补知识,毕竟有些东西,写出来了不代表我懂了...
