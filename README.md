# 序言
每周都要写周报，烦死人。为了解救自己，把自己从无聊的工作中抽离出来。
特别写了一个工具。可以查询GitLab中自己一段时间内的所有提交记录。
按照项目和分支进行排序

# 效果


![p1.png](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/a1b5e81d6594482f842a181e37a773cc~tplv-k3u1fbpfcp-watermark.image?)

还可以查询原始的json数据方便自己进行筛选和扩展


![p2.png](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/c6323380dec54aebbb4ce8ba0127191d~tplv-k3u1fbpfcp-watermark.image?)

# 使用方式
**使用java8 编译。如果运行不了，可能是java版本的问题。**

很简单，我发布成一个jar包了。直接双击运行就行了。

[下载地址](https://github.com/zhuguohui/GitLabWorkList/blob/master/product/GitLabLog-0.0.1.jar)

每次都输入地址和token很麻烦，还支持通过命令行输入。到时候写个批处理文件就行了。


```js
java -jar GitLabLog-0.0.1.jar -url https://git.abc.cn -token 123456 -name zhan.shang
```

# 更多扩展
项目已经开源了，大家可以安装自己的需要

[GitLabWorkList](https://github.com/zhuguohui/GitLabWorkList)
