# 序言
每周都要写周报，烦死人。为了解救自己，把自己从无聊的工作中抽离出来。
特别写了一个工具。可以查询GitLab中自己一段时间内的所有提交记录。
按照项目和分支进行排序

# 2.0发布
支持分页，之前只差一周的，懒得写分页，一页100条。这次升级以后可以查一年的记录。
为什么升级这个功能，因为要写年终总结了。

# 效果


![p1.png](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/a1b5e81d6594482f842a181e37a773cc~tplv-k3u1fbpfcp-watermark.image?)

还可以查询原始的json数据方便自己进行筛选和扩展


![p2.png](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c6323380dec54aebbb4ce8ba0127191d~tplv-k3u1fbpfcp-watermark.image?)

# 使用方式

## 1.获取个人令牌

![image.png](https://p9-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/6203bbe161f04a51bb4f7222b6ba98cc~tplv-k3u1fbpfcp-watermark.image?)

## 2.双击运行
**使用java8 编译。如果运行不了，可能是java版本的问题。**

很简单，我发布成一个jar包了。直接双击运行就行了。

[下载地址](https://github.com/zhuguohui/GitLabWorkList/blob/master/product/GitLabLog-2.0.jar)

## 3.使用批处理 避免每次都要输入信息

每次都输入地址和token很麻烦，还支持通过命令行输入参数。

只支持三个参数

| 参数名 |内容  |
| --- | --- |
| -url | gitlab 地址 |
| -name| 用户名|
|-token| 访问令牌|

示例代码如下
```js
java -jar GitLabLog-2.0.jar -url https://git.abc.cn -token 123456 -name zhan.shang
```

# 更多扩展
项目已经开源了，大家可以按照自己的需要进行扩展。
</br>
使用的技术是 
**okhttp retorfit rxjava gson java swing**

## github 地址

[GitLabWorkList](https://github.com/zhuguohui/GitLabWorkList)
