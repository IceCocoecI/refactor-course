# Middle Man

## 操作方法
1. 当我们遇到Person类和Department这种关系时：person类中直接返回department相关属性，这是我们操作快捷键：

``
Ctrl + Shift + Alt + T
``

会发现弹出框中有Remove MiddleMan...选项，点击后选择所有委托的方法，便可一次性去除，我们会发现在这种场景下使用了移除中间人方法。

2. 当我们发现委托类和被委托类之间关系可以成为父子类关系，则使用Replace Delegation with Inheritance(将委托替换为继承)，使chicken继承Animal，去除相关委托方法得到我们最终结果。
3. 当发现有方法被委托且没有其他用处时，可以使用内联函数手段来消除臃肿的代码，通过快捷键：

``
Ctrl + shift + N
``
