先说一句：你要时不时记得按“Shift+F10”运行下测试
1. InvoiceFormatter中出现了对行总额的计算。
   1. 提炼函数（InvoiceFormatter）
      * 光标移至line.getQuantity().multiply(line.getPrice())（可利用Ctrl+W辅助框选）
      * Ctrl+Alt+M (提取函数)
      * 命名为calcLineAmount
   2. 搬移函数(InvoiceFormatter.命名为calcLineAmount)
      * 光标移至calcLineAmount
      * F6（搬移函数）至InvoiceLine
      * 命名不太合适，Shift+F6重命名为getAmount
   3. 增加几个针对InvoiceLine.getAmount的测试
2. InvoiceFormatter中还有个对Invoice总额的计算，同样采用：
   1. 提炼函数
   2. 搬移函数
   3. 增加几个针对Invoice.getAmount的测试
  