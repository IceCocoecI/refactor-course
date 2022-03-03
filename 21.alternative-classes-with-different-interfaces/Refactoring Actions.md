先说一句：你要时不时记得按“Shift+F10”运行下测试

Case1
1. Shift+F6: 修改Employee属性名称identity -> id
2. Ctrl+Shift+F6: 类型迁移，修改sex类型 boolean -> Sex
	1. 修复编译错误、测试错误
3. Shift+F6: 修改Employee属性名称isMale -> sex，(本例中 setSex/getSex也要手动改)
4. Ctrl+F6：修改函数签名 setValues -> setProperties
   1. 修复编译错误、测试错误
5. F6: 移动函数 ManufactureService.createProductUsingEmployee() -> Employee.produce()
6. Alt+Del: 删除无用代码
7. 让Employee继承自Worker
8. 用Worker替换Employee：Use Interface where possible 
9. 删除 Employee类，并修复编译错误

Case2
1. Extract Superclass：从Quotation提取超类AbstractSalesDocument但不抽函数
2. 手动编码：让SalesOrder继承AbstractSalesDocument
3. Pull Members Up：依次上移公共逻辑，
   1. 超类中删除重复定义，部分内容需要手动操作
4. 分别对Quotation/SalesOrder执行：Use Interface where possible 
	
	