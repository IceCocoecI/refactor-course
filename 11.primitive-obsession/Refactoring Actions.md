一、为fly(int[] coordinate)引入Coordinate对象：
1、为Plane的fly(int[] coordinate)引入Coordinate对象   
2、将Plane的fly(List<int[]> airLine, String airLineType)方法里的单个int[]坐标的校验抽取为validateCoordinate方法  
3、为validateCoordinate方法引入Coordinate参数（此处注意勾选掉String参数）

二、为fly(List<int[]> airLine, String airLineType)引入Coordinate对象：
1、拷贝fly方法，并命名为flyTemp  
2、手动将flyTemp的入参List<int[]> airLine改为List<Coordinate> airLine，并手动修复错误  
3、在fly方法中实现List<int[]> airLine转换为List<Coordinate>，并调用flyTemp方法，删除原有逻辑  
4、将List<Coordinate> coordinates引入为入参  
5、内联flyTemp方法  
6、在PlaneTest中将List<int[]>转List<Coordinate>的逻辑提炼为方法toCoordinate  

三、封装Coordinate对象行为：
1、将coordinate.getCoordinate()[0]提炼为getX方法，并移动到Coordinate中  
2、将coordinate.getCoordinate()[1]提炼为getY方法，并移动到Coordinate中  
3、将坐标的长度校验抽取为validateLength函数，并移动到Coordinate中  

四、引入AirLine对象：
1、为fly方法引入参数对象AirLine  

五、封装AirLine对象行为：
1、将validateCoordinate内联   
2、将校验的逻辑抽取为validate方法，并挪到AirLine中
3、移动validate(AirLine airLine)方法到AirLine中

六、提炼AirLine接口：
1、将AirLine重命名为AbstractAirLine，并将validate方法改为public   
2、提炼接口AirLine，将getAirLineType、getCoordinates、validate都选上

七、使用多态+工厂取代字符串表达式：
1、创建子类DomesticAirLine、InternationalAirLine
2、使用工厂方法替换构造器，手动补全逻辑  
3、将AbstractAirLine的validate方法中的airLineType变量内联     
4、将校验坐标值大小的逻辑提炼为validateCoordinate方法  
5、提炼"domestic"、"International"为静态变量并挪到接口AirLine中
6、将AbstractAirLine中的validateCoordinate方法下推，勾选为抽象函数  
7、修改DomesticAirLine的validateCoordinate中的校验逻辑，仅保留国内航线的校验
8、修改InternationalAirLine的validateCoordinate中的校验逻辑，仅保留国际航线的校验
9、将工厂方法移动到工厂类中，创建工厂类
10、修改DomesticAirLine的构造方法，将super(airLine, coordinates)改为super(DOMESTIC, coordinates)，并删除airLine入参
11、修改InternationalAirLine的构造方法，将super(airLine, coordinates)改为super(INTERNATIONAL, coordinates)，并删除airLine入参
13、将Plane的fly方法的入参类AbstractAirLine迁移为AirLine
